package com.connect.stock.spirit.dao;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.concurrent.FutureCallback;
import org.apache.http.entity.BufferedHttpEntity;
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.apache.http.impl.nio.client.HttpAsyncClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.connect.stock.spirit.Application;
import com.connect.stock.spirit.Config;
import com.connect.stock.spirit.model.future.FutureQuote;
import com.connect.stock.spirit.model.future.SinaFutureQuote;
import com.connect.stock.spirit.model.product.ProductQuote;
import com.connect.stock.spirit.model.product.SinaLondonGoldQuote;
import com.connect.stock.spirit.model.stock.SinaStockQuote;
import com.connect.stock.spirit.model.stock.StockQuote;

@ComponentScan
@Component
public class DynamicScheduledTask{
	private static final Logger logger = LoggerFactory.getLogger(Application.class);
	
	public final static String QUOTATE_URL = "http://hq.sinajs.cn/list=";
	public final static long DEFAULT_INTERVAL = 3000;
	private DateFormat df = new SimpleDateFormat("HH:mm:ss");
	
	private CloseableHttpAsyncClient stockClient = null;
	private CloseableHttpAsyncClient futureClient = null;
	private CloseableHttpAsyncClient productClient = null;
	
	private Map<String,StockQuote> stockQuoteCache;
	private Map<String,FutureQuote> futureQuoteCache;
	private Map<String,ProductQuote> productQuoteCache;
	
	private HttpGet[] stockRequests = null;
	private HttpGet[] futureRequests = null;
	private HttpGet[] productRequests = null;
	
	@Autowired
	@Qualifier("config")
	private Config config;
	
	@Autowired
	@Qualifier("DAOforMySQL")
	private DAO dao;
	
	@Scheduled(fixedRate = 5000)
	public void loadStockQuotation() throws Exception {
		logger.info("Loading Sina stock Quotation.");
		
		//初始化
		if(stockClient == null){
			RequestConfig requestConfig = RequestConfig.custom()
					 .setSocketTimeout(3000)
					 .setConnectTimeout(3000).build();
			stockClient = HttpAsyncClients.custom().setDefaultRequestConfig(requestConfig)
					 .build();
			
			stockRequests = new HttpGet[config.getStockConfig().getIds().size()];
			for(int i=0;i<stockRequests.length;i++){
				stockRequests[i] = new HttpGet(QUOTATE_URL+config.getStockConfig().getIds().get(i));
			}
		}
		
		if(stockQuoteCache == null){
			stockQuoteCache = new ConcurrentHashMap<String,StockQuote>();
		}
		
		Date now;
		try {
			now = df.parse(df.format(new Date()));
			if(now.before(df.parse(config.getStockConfig().getOpeningTime())) || now.after(df.parse(config.getStockConfig().getClosingTime()))){
				logger.trace("The market is close now.");
			}
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		
		if(stockClient == null){
			throw new Exception("HTTP Client is not started. Please invoke the function init()");
		}
		
		if(!stockClient.isRunning()){
			stockClient.start();
		}
		
		try{
			final CountDownLatch latch = new CountDownLatch(stockRequests.length);
			for(final HttpGet request:stockRequests){
				stockClient.execute(request, new FutureCallback<HttpResponse>(){
	
					@Override
	                public void completed(final HttpResponse response) {
						logger.debug(request.getRequestLine() + "->" + response.getStatusLine());
	                    HttpEntity entity = response.getEntity();
	                    try {
							BufferedHttpEntity bufferedHttpEntity = new BufferedHttpEntity(entity);
							ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
							bufferedHttpEntity.writeTo(byteArrayOutputStream);
							String result=new String(byteArrayOutputStream.toByteArray(),"GBK");
							logger.info(result);
							
							SinaStockQuote sq = new SinaStockQuote(result);
							sq.setID(request.getRequestLine().getUri().substring(QUOTATE_URL.length()));
							if(stockQuoteCache.get(sq.getID()) != null){
								StockQuote q = stockQuoteCache.get(sq.getID());
								if(q.getDate().getTime() == sq.getDate().getTime() && 
										q.getTime().getTime() == sq.getTime().getTime()){
									return;
								}
							}
							
							if(dao != null){
								dao.addStockQuote(sq);
								stockQuoteCache.put(sq.getID(), sq);
							}
							
						} catch (IOException e) {
							e.printStackTrace();
						} catch (SQLException e) {
							e.printStackTrace();
						}finally{
							latch.countDown();
						}
	                }
	
	                @Override
	                public void failed(final Exception ex) {
	                	logger.debug(request.getRequestLine() + "->" + ex);
	                    latch.countDown();
	                }
	
	                @Override
	                public void cancelled() {                   
	                	logger.debug(request.getRequestLine() + " cancelled");
	                    latch.countDown();
	                }
					
				});
			}
			latch.await();
			
		} catch (InterruptedException e) {
			e.printStackTrace();
			throw new Exception("Communicating with SINA hq server is failed.");
		}
	}
	
	@Scheduled(fixedRate = 5000)
	public void loadfutureQuotation() throws Exception {
		logger.info("Loading Sina future Quotation.");
		
		//初始化
		if(futureClient == null){
			RequestConfig requestConfig = RequestConfig.custom()
					 .setSocketTimeout(3000)
					 .setConnectTimeout(3000).build();
			futureClient = HttpAsyncClients.custom().setDefaultRequestConfig(requestConfig)
					 .build();
			
			futureRequests = new HttpGet[config.getFutureConfig().getIds().size()];
			for(int i=0;i<futureRequests.length;i++){
				futureRequests[i] = new HttpGet(QUOTATE_URL+config.getFutureConfig().getIds().get(i));
			}
		}
		
		if(futureQuoteCache == null){
			futureQuoteCache = new ConcurrentHashMap<String,FutureQuote>();
		}
		
		Date now;
		try {
			now = df.parse(df.format(new Date()));
			if(now.before(df.parse(config.getFutureConfig().getOpeningTime())) || now.after(df.parse(config.getFutureConfig().getClosingTime()))){
				logger.trace("The market is close now.");
			}
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		
		if(futureClient == null){
			throw new Exception("HTTP Client is not started. Please invoke the function init()");
		}
		
		if(!futureClient.isRunning()){
			futureClient.start();
		}
		
		try{
			final CountDownLatch latch = new CountDownLatch(futureRequests.length);
			for(final HttpGet request:futureRequests){
				futureClient.execute(request, new FutureCallback<HttpResponse>(){
	
					@Override
	                public void completed(final HttpResponse response) {
						logger.debug(request.getRequestLine() + "->" + response.getStatusLine());
	                    HttpEntity entity = response.getEntity();
	                    try {
							BufferedHttpEntity bufferedHttpEntity = new BufferedHttpEntity(entity);
							ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
							bufferedHttpEntity.writeTo(byteArrayOutputStream);
							String result=new String(byteArrayOutputStream.toByteArray(),"GBK");
							logger.info(result);
							
							SinaFutureQuote sq = new SinaFutureQuote(result);
							sq.setID(request.getRequestLine().getUri().substring(QUOTATE_URL.length()));
							if(futureQuoteCache.get(sq.getID()) != null){
								FutureQuote q = futureQuoteCache.get(sq.getID());
								if(q.getDate().getTime() == sq.getDate().getTime() && 
										q.getTime().getTime() == sq.getTime().getTime()){
									return;
								}
							}
							
							if(dao != null){
								dao.addFutureQuote(sq);
								futureQuoteCache.put(sq.getID(), sq);
							}
							
						} catch (IOException e) {
							e.printStackTrace();
						} catch (SQLException e) {
							e.printStackTrace();
						}finally{
							latch.countDown();
						}
	                }
	
	                @Override
	                public void failed(final Exception ex) {
	                	logger.debug(request.getRequestLine() + "->" + ex);
	                    latch.countDown();
	                }
	
	                @Override
	                public void cancelled() {                   
	                	logger.debug(request.getRequestLine() + " cancelled");
	                    latch.countDown();
	                }
					
				});
			}
			latch.await();
			
		} catch (InterruptedException e) {
			e.printStackTrace();
			throw new Exception("Communicating with SINA hq server is failed.");
		}
	}
	
	@Scheduled(fixedRate = 5000)
	public void loadProductQuotation() throws Exception {
		logger.info("Loading Sina product Quotation.");
		
		//初始化
		if(productClient == null){
			RequestConfig requestConfig = RequestConfig.custom()
					 .setSocketTimeout(3000)
					 .setConnectTimeout(3000).build();
			productClient = HttpAsyncClients.custom().setDefaultRequestConfig(requestConfig)
					 .build();
			
			productRequests = new HttpGet[config.getProductConfig().getIds().size()];
			for(int i=0;i<productRequests.length;i++){
				productRequests[i] = new HttpGet(QUOTATE_URL+config.getProductConfig().getIds().get(i));
			}
		}
		
		if(productQuoteCache == null){
			productQuoteCache = new ConcurrentHashMap<String,ProductQuote>();
		}
		
		Date now;
		try {
			now = df.parse(df.format(new Date()));
			if(now.before(df.parse(config.getProductConfig().getOpeningTime())) || now.after(df.parse(config.getProductConfig().getClosingTime()))){
				logger.trace("The market is close now.");
			}
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		
		if(productClient == null){
			throw new Exception("HTTP Client is not started. Please invoke the function init()");
		}
		
		if(!productClient.isRunning()){
			productClient.start();
		}
		
		try{
			final CountDownLatch latch = new CountDownLatch(productRequests.length);
			for(final HttpGet request:productRequests){
				productClient.execute(request, new FutureCallback<HttpResponse>(){
	
					@Override
	                public void completed(final HttpResponse response) {
						logger.debug(request.getRequestLine() + "->" + response.getStatusLine());
	                    HttpEntity entity = response.getEntity();
	                    try {
							BufferedHttpEntity bufferedHttpEntity = new BufferedHttpEntity(entity);
							ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
							bufferedHttpEntity.writeTo(byteArrayOutputStream);
							String result=new String(byteArrayOutputStream.toByteArray(),"GBK");
							logger.info(result);
							
							SinaLondonGoldQuote sq = new SinaLondonGoldQuote(result);
							sq.setID(request.getRequestLine().getUri().substring(QUOTATE_URL.length()));
							if(productQuoteCache.get(sq.getID()) != null){
								ProductQuote q = productQuoteCache.get(sq.getID());
								if(q.getDate().getTime() == sq.getDate().getTime() && 
										q.getTime().getTime() == sq.getTime().getTime()){
									return;
								}
							}
							
							if(dao != null){
								dao.addProductQuote(sq);
								productQuoteCache.put(sq.getID(), sq);
								
							}
							
						} catch (IOException e) {
							e.printStackTrace();
						} catch (SQLException e) {
							e.printStackTrace();
						}finally{
							latch.countDown();
						}
	                }
	
	                @Override
	                public void failed(final Exception ex) {
	                	logger.debug(request.getRequestLine() + "->" + ex);
	                    latch.countDown();
	                }
	
	                @Override
	                public void cancelled() {                   
	                	logger.debug(request.getRequestLine() + " cancelled");
	                    latch.countDown();
	                }
					
				});
			}
			latch.await();
			
		} catch (InterruptedException e) {
			e.printStackTrace();
			throw new Exception("Communicating with SINA hq server is failed.");
		}
	}
}

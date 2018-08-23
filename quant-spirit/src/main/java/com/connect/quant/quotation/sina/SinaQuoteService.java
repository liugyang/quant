package com.connect.quant.quotation.sina;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
import org.springframework.stereotype.Service;

import com.connect.quant.model.Bar;
import com.connect.quant.model.Tick;

/**
 * 接收新浪行情数据，
 * @author liugy
 *
 */
@Service
public class SinaQuoteService {
	private static final Logger logger = LoggerFactory.getLogger(SinaQuoteReceiver.class);
	
	private final static DateFormat datetimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	@Autowired
	private SinaQuoteConfig quoteConfig;

	private CloseableHttpAsyncClient client = null;
	private Map<String,HttpGet> requestMap = null;
	
	private Map<String,Bar> tmpBarMap = new HashMap<String, Bar>();
	private Map<String,Bar> barMap = new HashMap<String, Bar>();

	private CloseableHttpAsyncClient getClient(){
		//初始化
		if(client == null){
			RequestConfig requestConfig = RequestConfig.custom()
					 .setSocketTimeout(SinaQuoteConfig.DEFAULT_INTERVAL)
					 .setConnectTimeout(SinaQuoteConfig.DEFAULT_INTERVAL).build();
			client = HttpAsyncClients.custom().setDefaultRequestConfig(requestConfig).build();
			
			requestMap = new HashMap<String,HttpGet>();
			for(String key:quoteConfig.getContractList().keySet()){
			    requestMap.put(key, new HttpGet(quoteConfig.getServiceUrl() + key));
            }
		}
		
		if(!client.isRunning()){
			client.start();
		}
		
		return client;
	}
	
	class ReceiveCallback implements FutureCallback<HttpResponse>{

		HttpGet httpGet;
		Tick tick;
		CountDownLatch latch;
		
		public ReceiveCallback(HttpGet httpGet, CountDownLatch latch){
			this.httpGet = httpGet;
			this.latch = latch;
		}
		
		@Override
        public void completed(final HttpResponse response) {
			logger.trace(httpGet.getRequestLine() + "->" + response.getStatusLine());
            HttpEntity entity = response.getEntity();
            try {
				BufferedHttpEntity bufferedHttpEntity = new BufferedHttpEntity(entity);
				ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
				bufferedHttpEntity.writeTo(byteArrayOutputStream);
				String result=new String(byteArrayOutputStream.toByteArray(),"GBK");
				logger.trace(result);
				
				String symbol = httpGet.getRequestLine().getUri().substring(quoteConfig.getServiceUrl().length());
				Map<String,Object> m = quoteConfig.getContractList().get(symbol);
				String productClass = (String)m.get("productClass");
				
				if(productClass.equals(quoteConfig.FUTURE)){
					SinaFutureQuote sq = new SinaFutureQuote(result);
					sq.setSymbol(symbol);
					tick = sq.toTick((double)m.get("upperLimit"),(double)m.get("lowerLimit"));
				}else if(productClass.equals(quoteConfig.PRODUCT)){
					
				}else{
					SinaStockQuote sq = new SinaStockQuote(result);
					sq.setSymbol(symbol);
					tick = sq.toTick((double)m.get("upperLimit"),(double)m.get("lowerLimit"));
				}
				
				
				if(tmpBarMap.get(tick.getSymbol()) == null){
					Bar _bar = new Bar();
					tmpBarMap.put(tick.getSymbol(), _bar);
				}
				
				Bar oldBar = tmpBarMap.get(tick.getSymbol());
				if(oldBar.getDate().getDate() == tick.getDate().getDate() &&
						oldBar.getTime().getHours() == tick.getTime().getHours() &&
						oldBar.getTime().getMinutes() == tick.getTime().getMinutes()){
					if(oldBar.getHigh() < tick.getLastPrice())
						oldBar.setHigh(tick.getLastPrice());
					
					if(oldBar.getLow() > tick.getLastPrice())
						oldBar.setLow(tick.getLastPrice());
					
					oldBar.setOpenInterest(tick.getOpenlongerest());
					oldBar.setVolume(tick.getVolume());
				}else{
					//finished create one bar data, put it into map
					barMap.put(oldBar.getSymbol(), oldBar);
					
					//create another bar data;
					Bar bar = new Bar();
					bar.setClose(tick.getPreClosePrice());
					bar.setDate(tick.getDate());
					bar.setDatetime(tick.getDatetime());
					bar.setExchange(tick.getExchange());
					bar.setHigh(tick.getLastPrice());
					bar.setLow(tick.getLastPrice());
					bar.setOpen(tick.getOpenPrice());
					bar.setOpenInterest(tick.getOpenlongerest());
					bar.setSymbol(tick.getSymbol());
					bar.setTime(tick.getDate());
					bar.setVolume(tick.getVolume());
					tmpBarMap.put(tick.getSymbol(), bar);
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}
            
            latch.countDown();
        }

        @Override
        public void failed(final Exception ex) {
        	logger.debug(httpGet.getRequestLine() + "->" + ex);
        	latch.countDown();
        }

        @Override
        public void cancelled() {                   
        	logger.debug(httpGet.getRequestLine() + " cancelled");
        	latch.countDown();
        }
		
	}
	
	public Tick receiveTick(String symbol){

		List<Tick> ticks = receiveTick(new String[]{symbol});
		if(ticks.size() > 0){
			return ticks.get(0);
		}else{
			return null;
		}
	}
	
	public Bar receiveBar(String symbol){

		List<Bar> bars = receiveBar(new String[]{symbol});
		if(bars.size() > 0){
			return bars.get(0);
		}else{
			return null;
		}
	}
	
	public List<Tick> receiveTick(String[] symbols){

		List<Tick> list = new ArrayList<Tick>();
		CloseableHttpAsyncClient quoteClient = this.getClient();

		try{
			CountDownLatch latch = new CountDownLatch(symbols.length);
			for(String symbol:symbols){
				HttpGet req = requestMap.get(symbol);
				if(req != null){
					ReceiveCallback cb = new ReceiveCallback(req, latch);
					quoteClient.execute(req, cb);
					if(cb.tick != null)
						list.add(cb.tick);
				}else{
					latch.countDown();
				}
			}
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public List<Bar> receiveBar(String[] symbols){

		List<Bar> list = new ArrayList<Bar>();

		try{
			for(String symbol:symbols){
				Bar bar = barMap.get(symbol);
				if(bar != null && (System.currentTimeMillis() - datetimeFormat.parse(bar.getDatetime()).getTime() < 60000)){
					list.add(bar);
				}
			}
		} catch (java.text.ParseException e) {
			e.printStackTrace();
		}
		
		return list;
	}
}

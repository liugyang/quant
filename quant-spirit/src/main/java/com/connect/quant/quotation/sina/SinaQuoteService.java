package com.connect.quant.quotation.sina;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
import org.springframework.stereotype.Service;

import com.connect.quant.quotation.QuoteService;


@Service
public class SinaQuoteService extends QuoteService{
	
	private static final Logger logger = LoggerFactory.getLogger(SinaQuoteService.class);
	
	@Autowired
	@Qualifier("quoteConfig")
	private SinaQuoteConfig quoteConfig;
	private CloseableHttpAsyncClient client = null;
	private HttpGet[] requests = null;
	private DateFormat df = new SimpleDateFormat("HH:mm:ss");

	private CloseableHttpAsyncClient getClient(){
		//初始化
		if(client == null){
			RequestConfig requestConfig = RequestConfig.custom()
					 .setSocketTimeout(3000)
					 .setConnectTimeout(3000).build();
			client = HttpAsyncClients.custom().setDefaultRequestConfig(requestConfig)
					 .build();
			
			requests = new HttpGet[quoteConfig.getVtSymbols().size()];
			for(int i=0;i<requests.length;i++){
				requests[i] = new HttpGet(quoteConfig.getServiceUrl() + quoteConfig.getVtSymbols().get(i));
			}
		}
		
		if(!client.isRunning()){
			client.start();
		}
		
		return client;
	}
	
	@Override
	public void processTick() {
		
		CloseableHttpAsyncClient quoteClient = this.getClient();
		
		try{
			final CountDownLatch latch = new CountDownLatch(requests.length);
			for(final HttpGet request:requests){
				quoteClient.execute(request, new FutureCallback<HttpResponse>(){
	
					@Override
	                public void completed(final HttpResponse response) {
						logger.trace(request.getRequestLine() + "->" + response.getStatusLine());
	                    HttpEntity entity = response.getEntity();
	                    try {
							BufferedHttpEntity bufferedHttpEntity = new BufferedHttpEntity(entity);
							ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
							bufferedHttpEntity.writeTo(byteArrayOutputStream);
							String result=new String(byteArrayOutputStream.toByteArray(),"GBK");
							logger.trace(result);
							
							SinaStockQuote sq = new SinaStockQuote(result);
							sq.setSymbol(request.getRequestLine().getUri().substring(quoteConfig.getServiceUrl().length()));
							
						} catch (IOException e) {
							e.printStackTrace();
						} finally{
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

	@Override
	public void processBar() {
		
	}

	@Override
	public void beforeExecute() {
		
	}

	@Override
	public void afterExecute() {
		
	}
}

package com.connect.quant.quotation.sina;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

import com.connect.quant.dao.mapper.FutureQuoteMapper;
import com.connect.quant.dao.mapper.TickMapper;
import com.connect.quant.model.Tick;
import com.connect.quant.quotation.TickEvent;
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
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import com.connect.quant.quotation.QuoteService;

import javax.annotation.Resource;


@Service
public class SinaQuoteService extends QuoteService{
	
	private static final Logger logger = LoggerFactory.getLogger(SinaQuoteService.class);
	
	@Autowired
	private SinaQuoteConfig quoteConfig;

	@Resource
	private ApplicationContext applicationContext;

	@Autowired
	private TickMapper tickMapper;

	private CloseableHttpAsyncClient client = null;
	private HttpGet[] requests = null;
	private DateFormat df = new SimpleDateFormat("HH:mm:ss");

	private Tick tmpTick;

	private CloseableHttpAsyncClient getClient(){
		//初始化
		if(client == null){
			RequestConfig requestConfig = RequestConfig.custom()
					 .setSocketTimeout(quoteConfig.DEFAULT_INTERVAL)
					 .setConnectTimeout(quoteConfig.DEFAULT_INTERVAL).build();
			client = HttpAsyncClients.custom().setDefaultRequestConfig(requestConfig).build();
			
			requests = new HttpGet[quoteConfig.getContractList().size()];
			int i = 0;
			for(String key:quoteConfig.getContractList().keySet()){
			    requests[i] = new HttpGet(quoteConfig.getServiceUrl() + key);
			    i++;
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

							Map<String,Object> m = quoteConfig.getContractList().get(sq.getSymbol());
							tmpTick = sq.toTick((double)m.get("upperLimit"),(double)m.get("lowerLimit"));
							tickMapper.insert(tmpTick);

							//fire a event for new tick
							TickEvent event = new TickEvent(tmpTick);
							event.setTick(tmpTick);
							applicationContext.publishEvent(event);

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

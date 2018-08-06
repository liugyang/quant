package com.connect.quant.quotation.sina;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.apache.http.impl.nio.client.HttpAsyncClients;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.connect.quant.quotation.QuoteConfig;
import com.connect.quant.quotation.QuoteService;

public class SinaQuoteProccessor extends QuoteService {
	
	
	
	private CloseableHttpAsyncClient client = null;
	
	private HttpGet[] requests = null;
	
	private DateFormat df = new SimpleDateFormat("HH:mm:ss");
	
	@Override
	public void init() {
		//初始化
		if(client == null){
			RequestConfig requestConfig = RequestConfig.custom()
					 .setSocketTimeout(3000)
					 .setConnectTimeout(3000).build();
			client = HttpAsyncClients.custom().setDefaultRequestConfig(requestConfig)
					 .build();
			
			requests = new HttpGet[quoteConfig.getVtSymbols().size()];
			for(int i=0;i<requests.length;i++){
				requests[i] = new HttpGet(quoteConfig.getServiceUrl()+quoteConfig.getVtSymbols().get(i));
			}
		}
		
//		Date now;
//		try {
//			now = df.parse(df.format(new Date()));
//			if(now.before(df.parse(config.getStockConfig().getOpeningTime())) || now.after(df.parse(config.getStockConfig().getClosingTime()))){
//				logger.trace("The market is close now.");
//			}
//		} catch (ParseException e1) {
//			e1.printStackTrace();
//		}
//		
//		if(stockClient == null){
//			throw new Exception("HTTP Client is not started. Please invoke the function init()");
//		}
//		
//		if(!stockClient.isRunning()){
//			stockClient.start();
//		}
	}

	@Override
	public QuoteConfig getSetting() {
		return (QuoteConfig)quoteConfig;
	}

	@Override
	public void processTick() {
		// TODO Auto-generated method stub

	}

	@Override
	public void processBar() {
		// TODO Auto-generated method stub

	}

	@Override
	public void register() {
		// TODO Auto-generated method stub

	}

	@Override
	public void start() {
		// TODO Auto-generated method stub

	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub

	}

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		// TODO Auto-generated method stub
		
	}

}

package com.connect.quant.quotation.sina;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

import com.connect.quant.dao.mapper.FutureQuoteMapper;
import com.connect.quant.dao.mapper.TickMapper;
import com.connect.quant.model.Bar;
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
import org.quartz.JobExecutionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import com.connect.quant.quotation.BarEvent;
import com.connect.quant.quotation.QuoteReceiver;

import javax.annotation.Resource;

public class SinaQuoteReceiver extends QuoteReceiver{
	
	public final static String TICK = "tick";
	
	private static final Logger logger = LoggerFactory.getLogger(SinaQuoteReceiver.class);
	@Autowired
	private SinaQuoteService quoteService;
	@Autowired
	private SinaQuoteConfig quoteConfig;
	
	@Resource
	private ApplicationContext applicationContext;
	
	@Override
	public void receive(JobExecutionContext context) {
		for(String symbol:quoteConfig.getContractList().keySet()){
			Tick tick = quoteService.receiveTick(symbol);
			//fire a event for tick received
			TickEvent e = new TickEvent(tick);
			applicationContext.publishEvent(e);
			
			Bar bar = quoteService.receiveBar(symbol);
			//fire a event for bar received;
			BarEvent be = new BarEvent(bar);
			applicationContext.publishEvent(be);
		}
	}
}

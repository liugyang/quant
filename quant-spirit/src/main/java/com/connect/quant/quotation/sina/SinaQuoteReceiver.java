package com.connect.quant.quotation.sina;

import org.quartz.JobExecutionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

import com.connect.quant.model.Bar;
import com.connect.quant.model.Tick;
import com.connect.quant.quotation.ReceiveBarEvent;
import com.connect.quant.quotation.QuoteReceiver;
import com.connect.quant.quotation.ReceiveTickEvent;

public class SinaQuoteReceiver extends QuoteReceiver{
	
	public final static String TICK = "tick";
	
	private static final Logger logger = LoggerFactory.getLogger(SinaQuoteReceiver.class);
	
	@Override
	public void receive(JobExecutionContext context) {
		
		logger.info("Receiving quote from Sina website.");
		
		SinaQuoteService quoteService = (SinaQuoteService)context.get("quoteService");
		ApplicationContext applicationContext = (ApplicationContext)context.get("applicationContext");
		SinaQuoteConfig quoteConfig = (SinaQuoteConfig)context.get("quoteConfig");
		
		for(String symbol:quoteConfig.getContractList().keySet()){
			Tick tick = quoteService.receiveTick(symbol);
			//fire a event for tick received
			ReceiveTickEvent e = new ReceiveTickEvent(tick);
			applicationContext.publishEvent(e);
			
			Bar bar = quoteService.receiveBar(symbol);
			//fire a event for bar received;
			ReceiveBarEvent be = new ReceiveBarEvent(bar);
			applicationContext.publishEvent(be);
		}
	}
}

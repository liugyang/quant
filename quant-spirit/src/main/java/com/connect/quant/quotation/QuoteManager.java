package com.connect.quant.quotation;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class QuoteManager {
	
	public static enum QUOTE_SOURCE{
		SINA;
	}

	@EventListener
	public void onTick(TickEvent event){

	}

	@EventListener
	public void onBar(BarEvent event){
		
	}

}

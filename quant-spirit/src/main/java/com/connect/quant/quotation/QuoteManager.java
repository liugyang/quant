package com.connect.quant.quotation;

import org.springframework.stereotype.Component;

@Component
public class QuoteManager {
	
	public static enum QUOTE_SOURCE{
		SINA;
	}
	
	public void tickEventListener(TickEvent event){

	}

}

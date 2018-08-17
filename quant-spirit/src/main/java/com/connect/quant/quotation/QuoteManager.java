package com.connect.quant.quotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.connect.quant.dao.mapper.BarMapper;
import com.connect.quant.dao.mapper.TickMapper;

@Component
public class QuoteManager {
	
	@Autowired
	private TickMapper tickMapper;
	
	@Autowired
	private BarMapper barMapper;

	@EventListener
	public void onTick(TickEvent event){
		tickMapper.insert(event.getTick());
	}

	@EventListener
	public void onBar(BarEvent event){
		barMapper.insert(event.getBar());
	}

}

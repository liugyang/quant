package com.connect.quant.engine.event;

import org.springframework.context.ApplicationEvent;

import com.connect.quant.model.Trade;

public class TradeEvent extends ApplicationEvent {

	private static final long serialVersionUID = -5091493364632868624L;
	private Trade trade;

	public TradeEvent(Object source) {
		super(source);
	}

	public Trade getTrade() {
		return trade;
	}

	public void setTrade(Trade trade) {
		this.trade = trade;
	}

}

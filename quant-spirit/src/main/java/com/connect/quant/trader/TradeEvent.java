package com.connect.quant.trader;

import org.springframework.context.ApplicationEvent;

import com.connect.quant.model.Trade;

/**
 * 交易事件
 * @author liugy
 *
 */
public class TradeEvent extends ApplicationEvent {
	
	private static final long serialVersionUID = 2768150104579038612L;

	public TradeEvent(Object source) {
		super(source);
	}

	/**交易数据*/
	private Trade trade;

	public Trade getTrade() {
		return trade;
	}

	public void setTrade(Trade trade) {
		this.trade = trade;
	}
	
	
}

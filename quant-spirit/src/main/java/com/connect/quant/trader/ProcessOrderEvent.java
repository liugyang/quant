package com.connect.quant.trader;

import org.springframework.context.ApplicationEvent;

import com.connect.quant.model.Order;

public class ProcessOrderEvent extends ApplicationEvent {
	private static final long serialVersionUID = -3405203972679256704L;
	private Order order;

	public ProcessOrderEvent(Object source) {
		super(source);
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

}

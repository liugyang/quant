package com.connect.quant.engine.event;

import org.springframework.context.ApplicationEvent;

import com.connect.quant.model.Order;

public class OrderEvent extends ApplicationEvent {

	private static final long serialVersionUID = 6114720596283802421L;
	private Order order;

	public OrderEvent(Object source) {
		super(source);
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

}

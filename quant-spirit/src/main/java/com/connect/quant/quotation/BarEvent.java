package com.connect.quant.quotation;

import org.springframework.context.ApplicationEvent;

import com.connect.quant.model.Bar;

public class BarEvent extends ApplicationEvent {

	private static final long serialVersionUID = -2633123465500012086L;
	
	private Bar bar;

	public Bar getBar() {
		return bar;
	}

	public void setBar(Bar bar) {
		this.bar = bar;
	}

	public BarEvent(Object source) {
		super(source);
	}

}

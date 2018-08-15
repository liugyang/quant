package com.connect.quant.quotation;

import com.connect.quant.model.Tick;
import org.springframework.context.ApplicationEvent;

public class TickEvent extends ApplicationEvent {

	private static final long serialVersionUID = -9107201966231192015L;
	
	private Tick tick;
	
	public Tick getTick() {
		return tick;
	}

	public void setTick(Tick tick) {
		this.tick = tick;
	}

	public TickEvent(Object source) {
		super(source);
	}

}

package com.connect.quant.engine;

import org.springframework.context.ApplicationEvent;

import com.connect.quant.model.Position;

public class PositionEvent extends ApplicationEvent {

	private static final long serialVersionUID = 7702679532981362719L;
	private Position position;

	public PositionEvent(Object source) {
		super(source);
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

}

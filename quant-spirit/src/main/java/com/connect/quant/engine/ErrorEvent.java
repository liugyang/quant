package com.connect.quant.engine;

import org.springframework.context.ApplicationEvent;

public class ErrorEvent extends ApplicationEvent {

	private static final long serialVersionUID = 3281943876590782368L;
	private Error error;

	public ErrorEvent(Object source) {
		super(source);
	}

	public Error getError() {
		return error;
	}

	public void setError(Error error) {
		this.error = error;
	}

}

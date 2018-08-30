package com.connect.quant.engine.event;

import org.springframework.context.ApplicationEvent;

import com.connect.quant.model.Contract;

public class ContractEvent extends ApplicationEvent {

	private static final long serialVersionUID = -8365003048210165423L;
	
	private Contract contract;

	public ContractEvent(Object source) {
		super(source);
	}

	public Contract getContract() {
		return contract;
	}

	public void setContract(Contract contract) {
		this.contract = contract;
	}
}

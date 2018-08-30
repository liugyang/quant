package com.connect.quant.engine;

import org.springframework.context.ApplicationEvent;

import com.connect.quant.model.Account;

public class AccountEvent extends ApplicationEvent {

	private static final long serialVersionUID = -240399363863758755L;
	private Account account;

	public AccountEvent(Object source) {
		super(source);
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

}

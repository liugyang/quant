package com.connect.quant.strategy.cta;

import java.util.List;

import com.connect.quant.engine.MainEngine;
import com.connect.quant.gateway.Gateway;
import com.connect.quant.model.Account;
import com.connect.quant.model.Contract;
import com.connect.quant.model.ExPosition;
import com.connect.quant.model.Order;
import com.connect.quant.model.Position;
import com.connect.quant.model.Trade;
import com.connect.quant.risk.RmEngine;

/*
 * CTA策略引擎，针对CTA类型的策略，抽象简化了部分底层接口的功能
 */
public class CtaEngine implements MainEngine{

	@Override
	public void addGateway(Gateway gateway) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void connect(Gateway gateway) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void subscribe(Gateway gateway) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sendOrder(Order order, Account account, Gateway gateway) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cancelOrder(Order order, Account account, Gateway gateway) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Account qryAccount(Account account, Gateway gateway) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Position qryPosition(Account account, Gateway gateway) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Contract getContract(String vtSymbol) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Contract> getAllContracts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void loadContracts() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Order getOrder(String orderId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> getAllOrders() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ExPosition getPositionDetail(String positionId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ExPosition> getAllPositionDetail() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Trade getTrade(String tradeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Trade> getAllTrade() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account getAccount(String accountId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Account> getAllAccount() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Gateway> getAllGateway() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveContracts() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void andRmEngine(RmEngine rmEngine) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<RmEngine> getAllRmEngine() {
		// TODO Auto-generated method stub
		return null;
	}
	
}

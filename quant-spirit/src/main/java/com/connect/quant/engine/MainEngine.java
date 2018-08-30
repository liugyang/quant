package com.connect.quant.engine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.connect.quant.Constant;
import com.connect.quant.gateway.Gateway;
import com.connect.quant.model.Account;
import com.connect.quant.model.Contract;
import com.connect.quant.model.ExPosition;
import com.connect.quant.model.Order;
import com.connect.quant.model.Position;
import com.connect.quant.model.ReqOrder;
import com.connect.quant.model.Trade;
import com.connect.quant.risk.RmEngine;
import com.connect.quant.strategy.Strategy;

public abstract class MainEngine{
	
	protected List<Gateway> gateways;
	protected Gateway nowGateway;
	/**风控引擎*/
	protected RmEngine rmEngine; 
	/**持仓细节*/
	private Map<String, ExPosition> detailDict;
	/**订单与策略对应关系*/
	private Map<String, Strategy> orderStrategyDict;
	
	public Map<String, Strategy> getOrderStrategyDict() {
		if(orderStrategyDict == null)
			orderStrategyDict = new HashMap<String, Strategy>();
		return orderStrategyDict;
	}

	public Map<String, ExPosition> getDetailDict() {
		if(detailDict == null)
			detailDict = new HashMap<String,ExPosition>();
		return detailDict;
	}
	
	protected void updateOrderReq(ReqOrder req, String vtOrderID){
		String vtSymbol = req.getVtSymbol();
		
		ExPosition detail = this.getDetailDict().get(vtSymbol);
		req.setVtOrderId(vtOrderID);
		detail.updateOrderReq(req);
	}
	
	protected List<ReqOrder> convertOrderReq(ReqOrder req){
		ExPosition detail = this.getDetailDict().get(req.getVtSymbol());
		if(detail == null){
			List<ReqOrder> list = new ArrayList<ReqOrder>();
			list.add(req);
			return list;
		}else{
			return detail.convertOrderReq(req);
		}
	}

	/**
	 * 添加交易网关
	 * */
	public void addGateway(Gateway gateway){
		if(gateways == null)
			gateways = new ArrayList<Gateway>();
		
		gateways.add(gateway);
	}
	
	/**
	 * 连接网关
	 * */
	public void connect(Gateway gateway){
		if(gateways.contains(gateway)){
			gateway.connect();
		}
	}
	
	/**
	 * 订阅行情
	 * */
	public void subscribe(Gateway gateway){
		//TODO
	}
	
	/**发送订单*/
	public List<String> sendOrder(String vtSymbol, String orderType, String accountId, double price, long volume, Strategy strategy, Gateway gateway){
		Contract contract = this.getContract(vtSymbol);
		ReqOrder req = new ReqOrder();
		req.setSymbol(contract.getSymbol());
		req.setAccountId(accountId);
		req.setVtSymbol(contract.getVtSymbol());
		req.setPrice(this.roundToPriceTick(contract.getPriceTick(), price));
		req.setTotalVolume(volume);
		
		req.setCurrency(strategy.getCurrency());
		req.setProductClass(strategy.getProductClass());
		//设计为CTA引擎发出的委托只允许使用限价单
		req.setPriceType(Constant.PRICETYPE_LIMITPRICE);
		//CTA委托类型映射
		if(Constant.CTAORDER_BUY.equals(orderType)){
			req.setDirection(Constant.DIRECTION_LONG);
			req.setOffset(Constant.OFFSET_OPEN);
		}else if(Constant.CTAORDER_SELL.equals(orderType)){
			req.setDirection(Constant.DIRECTION_SHORT);
			req.setOffset(Constant.OFFSET_CLOSE);
		}else if(Constant.CTAORDER_SHORT.equals(orderType)){
			req.setDirection(Constant.DIRECTION_SHORT);
			req.setOffset(Constant.OFFSET_OPEN);
		}else if(Constant.CTAORDER_COVER.equals(orderType)){
			req.setDirection(Constant.DIRECTION_LONG);
			req.setOffset(Constant.OFFSET_CLOSE);
		}
		
		//委托转换
		List<ReqOrder> reqList = this.convertOrderReq(req);
		if(reqList == null || reqList.size() == 0){
			return new ArrayList<String>();
		}
		
		for(ReqOrder reqOrder:reqList){
			if(rmEngine != null && !rmEngine.checkRisk(reqOrder, gateway)){
				return new ArrayList<String>();
			}
			
			if(gateway != null){
				String vtOrderId = gateway.sendOrder(reqOrder);
				this.updateOrderReq(reqOrder, vtOrderId);
				this.getOrderStrategyDict().put(vtOrderId, strategy);
				
				
				List<String> list = new ArrayList<String>();
				list.add(vtOrderId);
				return list;
			}else{
				return new ArrayList<String>();
			}
		}
	}
	
	/**撤单*/
	public void cancelOrder(Order order, Account account, Gateway gateway){
		
	}
	/**查询账户*/
	public Account qryAccount(Account account, Gateway gateway);
	/**查询持仓*/
	public Position qryPosition(Account account, Gateway gateway);
	/**查询合约*/
	abstract public Contract getContract(String vtSymbol);
	/**获取所有合约*/
	abstract List<Contract> getAllContracts();
	/**保存合约*/
	abstract public void saveContracts(List<Contract> contracts);
	/**获取订单*/
	public Order getOrder(String orderId);
	/**获取所有订单*/
	public List<Order> getAllOrders();
	/**获取持仓明细*/
	public ExPosition getPositionDetail(String positionId);
	/**获取所有持仓明细*/
	public List<ExPosition> getAllPositionDetail();
	/**获取成交*/
	public Trade getTrade(String tradeId);
	/**获取所有成交*/
	public List<Trade> getAllTrade();
	/**获取账户*/
	public Account getAccount(String accountId);
	/**获取所有账户*/
	public List<Account> getAllAccount();
	/**获取所有交易网关*/
	public List<Gateway> getAllGateway();
	/**添加风控引擎*/
	public void andRmEngine(RmEngine rmEngine);
	/**获取所有风控引擎*/
	public List<RmEngine> getAllRmEngine();
	
	private double roundToPriceTick(double priceTick, double price){
		if(priceTick <= 0.0)
			return price;
		
		double newPrice = Math.floor(price/priceTick+0.5)*priceTick;
		return newPrice;
	}
}

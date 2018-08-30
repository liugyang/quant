package com.connect.quant.strategy;

import com.connect.quant.model.Bar;
import com.connect.quant.model.Order;
import com.connect.quant.model.Tick;
import com.connect.quant.model.Trade;

public abstract class Strategy {
	
	protected String strategyName;
	
	protected String productClass;
	protected String vtSymbol;
	protected String currency;
	
	public String getProductClass() {
		return productClass;
	}
	public void setProductClass(String productClass) {
		this.productClass = productClass;
	}
	public String getVtSymbol() {
		return vtSymbol;
	}
	public void setVtSymbol(String vtSymbol) {
		this.vtSymbol = vtSymbol;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getStrategyName() {
		return strategyName;
	}
	public void setStrategyName(String strategyName) {
		this.strategyName = strategyName;
	}
	/**初始化策略*/
	abstract public void init();
    /**启动策略*/
    abstract public void start();
    /**停止策略*/
    abstract public void stop();
    /**收到行情TICK推送*/
    abstract public void onTick(Tick tick);
    /**收到委托变化推送*/
    abstract public void onOrder(Order order);
    /**收到成交推送*/    
    abstract public void onTrade(Trade trade);
    /**收到Bar推送*/
    abstract public void onBar(Bar bar);
    /**收到停止单推送*/
    abstract public void onStopOrder(Order so);
    /**买开*/
    abstract public void _buy(double price, long volume, boolean stop);
    /**卖平*/
    abstract public void _sell(double price, long volume, boolean stop);
    /**卖开*/
    abstract public void _short(double price, long volume, boolean stop);
    /**买平*/
    abstract public void _cover(double price, long volume, boolean stop);
    /**发送委托*/
    abstract public void sendOrder(String orderType, double price, long volume, boolean stop);
    /**撤单*/
    abstract public void cancelOrder(String vtOrderID);
    /**全部撤单*/
    abstract public void cancelAll();
}

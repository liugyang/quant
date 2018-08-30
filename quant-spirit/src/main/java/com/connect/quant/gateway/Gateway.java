package com.connect.quant.gateway;

import com.connect.quant.model.Account;
import com.connect.quant.model.Contract;
import com.connect.quant.model.Order;
import com.connect.quant.model.Position;
import com.connect.quant.model.Tick;
import com.connect.quant.model.Trade;

/**
 * 交易网关（接口）
 * @author liugy
 *
 */
public abstract class Gateway {
	
	protected String gatewayName;
	
	public Gateway(String gatewayName){
		this.gatewayName = gatewayName;
	}
	/**市场行情推送*/
	abstract public void onTick(Tick tick);
    /**成交信息推送*/
	abstract public void onTrade(Trade trade);
    /**订单变化推送*/
	abstract public void onOrder(Order order);
    /**持仓信息推送*/
	abstract public void onPosition(Position position);
    /**账户信息推送*/
	abstract public void onAccount(Account account);
    /**错误信息推送*/
    abstract public void onError(Error error);
    /**合约基础信息推送*/
    abstract public void onContract(Contract contract);
    /**连接*/
    abstract public void connect();
    /**订阅行情*/
    abstract public void subscribe(Object object);
    /**发单*/
    abstract public String sendOrder(Order order);
    /**撤单*/
    abstract public void cancelOrder(Order order);
    /**查询账户资金*/
    abstract public Account qryAccount();
    /**查询持仓*/
    abstract public Position qryPosition();
    /**关闭*/
    abstract public void close();
}

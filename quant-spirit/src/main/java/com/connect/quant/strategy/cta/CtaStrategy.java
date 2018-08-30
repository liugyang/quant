package com.connect.quant.strategy.cta;

import org.springframework.context.event.EventListener;

import com.connect.quant.gateway.Gateway;
import com.connect.quant.model.Bar;
import com.connect.quant.model.Order;
import com.connect.quant.model.Tick;
import com.connect.quant.model.Trade;
import com.connect.quant.strategy.Strategy;

/**
 * 基于King Keltner通道的交易策略
 * @author liugy
 *
 */
public class CtaStrategy extends Strategy {
	
	private Gateway gateway;
	
	private CtaEngine ctaEngine;
	/**交易的合约vt系统代码*/
    private String vtSymbol;
    /**产品类型*/
    private String productClass;
    /**货币*/
    private String currency;
    /**是否进行了初始化*/
    private boolean inited = false;
    /**是否启动交易*/
    private boolean trading = false;
    /**持仓情况*/
    private long pos = 0;
    
    /**参数列表，保存了参数的名称*/
    private String[] paramList = {"name",
                 "className",
                 "author",
                 "vtSymbol"};
    
    /**变量列表，保存了变量的名称*/
    private String[] varList = {"inited",
               "trading",
               "pos"};
    
    /**同步列表，保存了需要保存到数据库的变量名称*/
    private String[] syncList = {"pos"};

	public CtaEngine getCtaEngine() {
		return ctaEngine;
	}

	public void setCtaEngine(CtaEngine ctaEngine) {
		this.ctaEngine = ctaEngine;
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
	}

	@Override
	public void start() {
		if(ctaEngine != null)
			ctaEngine.connect(gateway);
		
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		
	}

	@EventListener
	@Override
	public void onTick(Tick tick) {
		// TODO Auto-generated method stub
		
	}

	@EventListener
	@Override
	public void onOrder(Order order) {
		// TODO Auto-generated method stub
		
	}

	@EventListener
	@Override
	public void onTrade(Trade trade) {
		// TODO Auto-generated method stub
		
	}

	@EventListener
	@Override
	public void onBar(Bar bar) {
		// TODO Auto-generated method stub
		
	}

	@EventListener
	@Override
	public void onStopOrder(Order so) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void _buy(double price, long volume, boolean stop) {
		
	}

	@Override
	public void _sell(double price, long volume, boolean stop) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void _short(double price, long volume, boolean stop) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void _cover(double price, long volume, boolean stop) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sendOrder(String orderType, double price, long volume, boolean stop) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cancelOrder(String vtOrderID) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cancelAll() {
		// TODO Auto-generated method stub
		
	}

}

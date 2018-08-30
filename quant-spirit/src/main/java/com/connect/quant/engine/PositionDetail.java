package com.connect.quant.engine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.cglib.beans.BeanCopier;

import com.connect.quant.Constant;
import com.connect.quant.model.Order;
import com.connect.quant.model.Position;
import com.connect.quant.model.PositionsDetail;
import com.connect.quant.model.ReqOrder;
import com.connect.quant.model.Tick;
import com.connect.quant.model.Trade;

public class PositionDetail extends PositionsDetail{
	
	protected int sno;
	/** 合约代码 */
	protected String symbol;
	/** 交易所代码 */
	protected String exchange;
	/** 合约在vt系统中的唯一代码，合约代码.交易所代码 */
	protected String vtSymbol;
	/** 持仓在vt系统中的唯一代码，通常是vtSymbol.方向 */
	protected String vtPositionName;
	/** 名称 */
	protected String name;
	protected int size = 1;
	/** 做多持仓 */
	protected int longPos;
	/** 做多昨日持仓 */
	protected int longYd;
	/** 做多今日持仓 */
	protected int longTd;
	/** 做多冻结 */
	protected int longPosFrozen;
	/** 做多昨日冻结 */
	protected int longYdFrozen;
	/** 做多今日冻结 */
	protected int longTdFrozen;
	/** 做多盈亏 */
	protected double longPnl;
	/** 做多均价 */
	protected double longPrice;
	/** 做空持仓 */
	protected int shortPos;
	/** 做空昨日持仓 */
	protected int shortYd;
	/** 做空今日持仓 */
	protected int shortTd;
	/** 做空冻结 */
	protected int shortPosFrozen;
	/** 做空昨日持仓 */
	protected int shortYdFrozen;
	/** 做空今日持仓 */
	protected int shortTdFrozen;
	/** 做空盈亏 */
	protected double shortPnl;
	/** 做空均价 */
	protected double shortPrice;
	/** 市价 */
	protected double lastPrice;
	/** 模式， 包括：普通模式、上期所今昨分别平仓、平今惩罚 */
	protected String mode;
	
	protected String accountId;
	
	private HashMap<String, Order> workingOrderDict;

	public int getSno() {
		return sno;
	}

	public void setSno(int sno) {
		this.sno = sno;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getExchange() {
		return exchange;
	}

	public void setExchange(String exchange) {
		this.exchange = exchange;
	}

	public String getVtSymbol() {
		return vtSymbol;
	}

	public void setVtSymbol(String vtSymbol) {
		this.vtSymbol = vtSymbol;
	}

	public String getVtPositionName() {
		return vtPositionName;
	}

	public void setVtPositionName(String vtPositionName) {
		this.vtPositionName = vtPositionName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getLongPos() {
		return longPos;
	}

	public void setLongPos(int longPos) {
		this.longPos = longPos;
	}

	public int getLongYd() {
		return longYd;
	}

	public void setLongYd(int longYd) {
		this.longYd = longYd;
	}

	public int getLongTd() {
		return longTd;
	}

	public void setLongTd(int longTd) {
		this.longTd = longTd;
	}

	public int getLongPosFrozen() {
		return longPosFrozen;
	}

	public void setLongPosFrozen(int longPosFrozen) {
		this.longPosFrozen = longPosFrozen;
	}

	public int getLongYdFrozen() {
		return longYdFrozen;
	}

	public void setLongYdFrozen(int longYdFrozen) {
		this.longYdFrozen = longYdFrozen;
	}

	public int getLongTdFrozen() {
		return longTdFrozen;
	}

	public void setLongTdFrozen(int longTdFrozen) {
		this.longTdFrozen = longTdFrozen;
	}

	public Double getLongPnl() {
		return longPnl;
	}

	public void setLongPnl(Double longPnl) {
		this.longPnl = longPnl;
	}

	public Double getLongPrice() {
		return longPrice;
	}

	public void setLongPrice(double longPrice) {
		this.longPrice = longPrice;
	}

	public int getShortPos() {
		return shortPos;
	}

	public void setShortPos(int shortPos) {
		this.shortPos = shortPos;
	}

	public int getShortYd() {
		return shortYd;
	}

	public void setShortYd(int shortYd) {
		this.shortYd = shortYd;
	}

	public int getShortTd() {
		return shortTd;
	}

	public void setShortTd(int shortTd) {
		this.shortTd = shortTd;
	}

	public int getShortPosFrozen() {
		return shortPosFrozen;
	}

	public void setShortPosFrozen(int shortPosFrozen) {
		this.shortPosFrozen = shortPosFrozen;
	}

	public int getShortYdFrozen() {
		return shortYdFrozen;
	}

	public void setShortYdFrozen(int shortYdFrozen) {
		this.shortYdFrozen = shortYdFrozen;
	}

	public int getShortTdFrozen() {
		return shortTdFrozen;
	}

	public void setShortTdFrozen(int shortTdFrozen) {
		this.shortTdFrozen = shortTdFrozen;
	}

	public Double getShortPnl() {
		return shortPnl;
	}

	public void setShortPnl(Double shortPnl) {
		this.shortPnl = shortPnl;
	}

	public Double getShortPrice() {
		return shortPrice;
	}

	public void setShortPrice(Double shortPrice) {
		this.shortPrice = shortPrice;
	}

	public Double getLastPrice() {
		return lastPrice;
	}

	public void setLastPrice(Double lastPrice) {
		this.lastPrice = lastPrice;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public HashMap<String, Order> getWorkingOrderDict() {
		if (workingOrderDict == null)
			workingOrderDict = new HashMap<String, Order>();

		return workingOrderDict;
	}
	
	/**
	 * 更新成交信息
	 * 
	 * @param trade
	 */
	public void updateTrade(Trade trade) {
		if (trade.getDirection().equals(Constant.DIRECTION_LONG)) {
			// 开仓
			if (trade.getOffset().equals(Constant.OFFSET_OPEN)) {
				this.longTd += trade.getVolume();
				// 平今
			} else if (trade.getOffset().equals(Constant.OFFSET_CLOSETODAY)) {
				this.shortTd -= trade.getVolume();
				// 平昨
			} else if (trade.getOffset().equals(Constant.OFFSET_CLOSEYESTERDAY)) {
				this.shortYd -= trade.getVolume();
				// 平仓
			} else if (trade.getOffset().equals(Constant.OFFSET_CLOSE)) {
				// 上期所等同于平昨
				if (this.exchange.equals(Constant.EXCHANGE_SHFE)) {
					this.shortYd -= trade.getVolume();
					// 非上期所，优先平今
				} else {
					this.shortTd -= trade.getVolume();

					if (this.shortTd < 0) {
						this.shortYd += this.shortTd;
						this.shortTd = 0;
					}
				}
			}
			// 空头
		} else if (trade.getDirection().equals(Constant.DIRECTION_SHORT)) {
			// 开仓
			if (trade.getOffset().equals(Constant.OFFSET_OPEN)) {
				this.shortTd += trade.getVolume();
				// 平今
			} else if (trade.getOffset().equals(Constant.OFFSET_CLOSETODAY)) {
				this.longTd -= trade.getVolume();
				// 平昨
			} else if (trade.getOffset().equals(Constant.OFFSET_CLOSEYESTERDAY)) {
				this.longYd -= trade.getVolume();
				// 平仓
			} else if (trade.getOffset().equals(Constant.OFFSET_CLOSE)) {
				// 上期所等同于平昨
				if (this.exchange.equals(Constant.EXCHANGE_SHFE)) {
					this.longYd -= trade.getVolume();
					// 非上期所，优先平今
				} else {
					this.longTd -= trade.getVolume();

					if (this.longTd < 0) {
						this.longYd += this.longTd;
						this.longTd = 0;
					}
				}
			}

		}
		// 汇总
		calculatePrice(trade);
		calculatePosition();
		calculatePnl();
	}

	/**
	 * 更新委托
	 * @param order
	 */
	public void updateOrder(Order order){
		// 将活动委托缓存下来
        if(Constant.WORKING_STATUS.contains(order.getStatus())){
            getWorkingOrderDict().put(order.getVtOrderId(),order);
            
        // 移除缓存中已经完成的委托
        }else if(getWorkingOrderDict().containsKey(order.getVtOrderId())){
        	getWorkingOrderDict().remove(order.getVtOrderId());
        }
                
        // 计算冻结
        calculateFrozen();
	}
	
	/**
	 * 计算冻结情况
	 */
	public void calculateFrozen(){
		// 清空冻结数据
        this.longPosFrozen = 0;
		this.longYdFrozen = 0;
		this.longTdFrozen = 0;
		this.shortPosFrozen = 0;
		this.shortYdFrozen = 0;
		this.shortTdFrozen = 0;  
        
        // 遍历统计
        for(Order order:getWorkingOrderDict().values()){
            // 计算剩余冻结量
            long frozenVolume = order.getTotalVolume() - order.getTradedVolume();
            
            // 多头委托
            if(order.getDirection().equals(Constant.DIRECTION_LONG)){
                // 平今
                if(order.getOffset().equals(Constant.OFFSET_CLOSETODAY)){
                    this.shortTdFrozen += frozenVolume;
                // 平昨
                }else if( order.getOffset().equals(Constant.OFFSET_CLOSEYESTERDAY)){
                    this.shortYdFrozen += frozenVolume;
                // 平仓
                }else if(order.getOffset().equals(Constant.OFFSET_CLOSE)){
                    this.shortTdFrozen += frozenVolume;
                    
                    if(this.shortTdFrozen > this.shortTd){
                    	this.shortYdFrozen += (this.shortTdFrozen - this.shortTd);
                    	this.shortTdFrozen = this.shortTd;
                    }
                }
            // 空头委托
            }else if(order.getDirection().equals(Constant.DIRECTION_SHORT)){
                // 平今
                if(order.getOffset().equals(Constant.OFFSET_CLOSETODAY)){
                    this.longTdFrozen += frozenVolume;
                // 平昨
                }else if(order.getOffset().equals(Constant.OFFSET_CLOSEYESTERDAY)){
                    this.longYdFrozen += frozenVolume;
                // 平仓
                }else if(order.getOffset().equals(Constant.OFFSET_CLOSE)){
                	this.longTdFrozen += frozenVolume;
                    
                    if(this.longTdFrozen > this.longTd){
                    	this.longYdFrozen += (this.longTdFrozen - this.longTd);
                    	this.longTdFrozen = this.longTd;
                    }
                }
            }     
            // 汇总今昨冻结
            this.longPosFrozen = this.longYdFrozen + this.longTdFrozen;
            this.shortPosFrozen = this.shortYdFrozen + this.shortTdFrozen;
        }
	}
	/**
	 * 持仓更新
	 * @param pos
	 */
	public void updatePosition(Position pos){
		if(Constant.DIRECTION_LONG.equals(pos.getDirection())){
            this.longPos = pos.getPositions();
            this.longYd = pos.getYdPosition();
            this.longTd = this.longPos - this.longYd;
            this.longPnl = pos.getPositionProfit();
            this.longPrice = pos.getPrice();
		}else if(Constant.DIRECTION_SHORT.equals(pos.getDirection())){
			this.shortPos = pos.getPositions();
            this.shortYd = pos.getYdPosition();
            this.shortTd = this.shortPos - this.shortYd;
            this.shortPnl = pos.getPositionProfit();
            this.shortPrice = pos.getPrice();
		}
	}

	/**
	 * 计算持仓均价（基于成交数据）
	 * 
	 * @param trade
	 */
	public void calculatePrice(Trade trade) {
		double cost;
		double newPos;

		// 只有开仓会影响持仓均价
		if (trade.getOffset().equals(Constant.OFFSET_OPEN)) {
			if (trade.getDirection().equals(Constant.DIRECTION_LONG)) {
				cost = this.longPrice * this.longPos;
				cost += trade.getVolume() * trade.getPrice();
				newPos = this.longPos + trade.getVolume();
				if (newPos > 0) {
					this.longPrice = cost / newPos;
				} else {
					this.longPrice = 0;
				}
			} else {
				cost = this.shortPrice * this.shortPos;
				cost += trade.getVolume() * trade.getPrice();
				newPos = this.shortPos + trade.getVolume();
				if (newPos > 0) {
					this.shortPrice = cost / newPos;
				} else {
					this.shortPrice = 0;
				}
			}
		}
	}

	/**
	 * 计算持仓情况
	 */
	public void calculatePosition() {
		this.longPos = this.longTd + this.longYd;
		this.shortPos = this.shortTd + this.shortYd;
	}

	/**
	 * 计算持仓盈亏
	 */
	public void calculatePnl() {
		this.longPnl = this.longPos * (this.lastPrice - this.longPrice) * this.size;
		this.shortPnl = this.shortPos * (this.shortPrice - this.lastPrice) * this.size;
	}
	/**
	 * 行情更新
	 */
	public void updateTick(Tick tick){
		this.lastPrice = tick.getLastPrice();
		this.calculatePnl();
	}
	/**
	 * 发单更新
	 * @param order
	 */
	public void updateOrderReq(Order order){
		this.getWorkingOrderDict().put(order.getVtOrderId(), order);
		this.calculateFrozen();
	}
	/**
	 * 转换委托请求
	 * @param order
	 */
	public List<ReqOrder> convertOrderReq(ReqOrder order){
		
		long posAvailable = 0;
        long tdAvailable = 0;
        long ydAvailable = 0;  
        List<ReqOrder> list = new ArrayList<ReqOrder>();
		// 普通模式无需转换
        if(this.mode.equals(Constant.MODE_NORMAL)){
        	list.add(order);
            return list;
        }
        // 上期所模式拆分今昨，优先平今
        else if(this.mode.equals(Constant.MODE_SHFE)){
            // 开仓无需转换
            if(order.getOffset().equals(Constant.OFFSET_OPEN)){
            	list.add(order);
                return list;
            }
                		
            // 多头
            if(order.getDirection().equals(Constant.DIRECTION_LONG)){
                posAvailable = this.shortPos - this.shortPosFrozen;
                tdAvailable = this.shortTd- this.shortTdFrozen;
                ydAvailable = this.shortYd - this.shortYdFrozen;          
            // 空头
            } else {
                posAvailable = this.longPos - this.longPosFrozen;
                tdAvailable = this.longTd - this.longTdFrozen;
                ydAvailable = this.longYd - this.longYdFrozen;
            }
                
            //平仓量超过总可用，拒绝，返回空列表
            if(order.getTotalVolume() > posAvailable){
                return list;
            }
            // 平仓量小于今可用，全部平今
            else if(order.getTotalVolume() <= tdAvailable){
                order.setOffset(Constant.OFFSET_CLOSETODAY);
                list.add(order);
                return list;
            }
            // 平仓量大于今可用，平今再平昨
            else {
            	BeanCopier copy = BeanCopier.create(Order.class, Order.class, false);
                if(tdAvailable > 0){
                	ReqOrder orderTd = new ReqOrder();
                	copy.copy(order, orderTd, null);
                	orderTd.setOffset(Constant.OFFSET_CLOSETODAY);
                    orderTd.setTotalVolume(tdAvailable);
                    list.add(orderTd);
                }
                    
                ReqOrder orderYd = new ReqOrder();
                copy.copy(order, orderYd, null);
                orderYd.setOffset(Constant.OFFSET_CLOSEYESTERDAY);
                orderYd.setTotalVolume(order.getTotalVolume() - tdAvailable);
                list.add(orderYd);
                
                return list;
            }
        }
            
        // 平今惩罚模式，没有今仓则平昨，否则锁仓
        else if(this.mode.equals(Constant.MODE_TDPENALTY)){
        	int td = 0;
        	// 多头
            if(order.getDirection().equals(Constant.DIRECTION_LONG)){
                td = this.shortTd;
                ydAvailable = this.shortYd - this.shortYdFrozen;
            }
            // 空头
            else{
                td = this.longTd;
                ydAvailable = this.longYd - this.longYdFrozen;
            }
                
            // 这里针对开仓和平仓委托均使用一套逻辑
            // 如果有今仓，则只能开仓（或锁仓）
            if(td>0){
                order.setOffset(Constant.OFFSET_OPEN);
                list.add(order);
                return list;
            }   		
            // 如果平仓量小于昨可用，全部平昨
            else if(order.getTotalVolume() <= ydAvailable){
                if(this.exchange.equals(Constant.EXCHANGE_SHFE)){
                    order.setOffset(Constant.OFFSET_CLOSEYESTERDAY);
                }else{
                    order.setOffset(Constant.OFFSET_CLOSE);
                }
                list.add(order);
                return list;
            }
            // 平仓量大于昨可用，平仓再反向开仓
            else{
            	BeanCopier copy = BeanCopier.create(Order.class, Order.class, false);
            	
                if(ydAvailable > 0){
                    ReqOrder reqClose = new ReqOrder();
                    copy.copy(order,reqClose,null);
                    if(this.exchange.equals(Constant.EXCHANGE_SHFE)){
                        reqClose.getOffset().equals(Constant.OFFSET_CLOSEYESTERDAY);
                    }else{
                        reqClose.getOffset().equals(Constant.OFFSET_CLOSE);
                    }
                    reqClose.setTotalVolume(ydAvailable);
                    list.add(reqClose);
                }
                
                ReqOrder reqOpen = new ReqOrder();
                copy.copy(order,reqOpen,null);
                reqOpen.setOffset(Constant.OFFSET_OPEN);
                reqOpen.setTotalVolume(order.getTotalVolume() - ydAvailable);
                list.add(reqOpen);
                
                return list;
            }
        }
        
        // 其他情况则直接返回空
        return list;
	}
}

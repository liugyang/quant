package com.connect.quant.model;

import java.util.HashMap;

import com.connect.quant.Constant;

/**
 * 持仓信息
 * 
 * @author liugy
 *
 */
public class Position {
	/** 合约代码 */
	private String symbol;
	/** 交易所代码 */
	private String exchange;
	/** 合约在vt系统中的唯一代码，合约代码.交易所代码 */
	private String vtSymbol;
	/** 持仓在vt系统中的唯一代码，通常是vtSymbol.方向 */
	private String vtPositionName;
	/** 名称 */
	private String name;
	int size = 1;
	/** 做多持仓 */
	private int longPos;
	/** 做多昨日持仓 */
	private int longYd;
	/** 做多今日持仓 */
	private int longTd;
	/** 做多冻结 */
	private int longPosFrozen;
	/** 做多昨日冻结 */
	private int longYdFrozen;
	/** 做多今日冻结 */
	private int longTdFrozen;
	/** 做多盈亏 */
	private double longPnl;
	/** 做多均价 */
	private double longPrice;
	/** 做空持仓 */
	private int shortPos;
	/** 做空昨日持仓 */
	private int shortYd;
	/** 做空今日持仓 */
	private int shortTd;
	/** 做空冻结 */
	private int shortPosFrozen;
	/** 做空昨日持仓 */
	private int shortYdFrozen;
	/** 做空今日持仓 */
	private int shortTdFrozen;
	/** 做空盈亏 */
	private double shortPnl;
	/** 做空均价 */
	private double shortPrice;
	/** 市价 */
	private double lastPrice;
	/** 模式， 包括：普通模式、上期所今昨分别平仓、平今惩罚 */
	private int mode;

	private HashMap<String, Order> workingOrderDict;

	public HashMap<String, Order> getWorkingOrderDict() {
		if (workingOrderDict == null)
			workingOrderDict = new HashMap<String, Order>();

		return workingOrderDict;
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

	public double getLongPnl() {
		return longPnl;
	}

	public void setLongPnl(double longPnl) {
		this.longPnl = longPnl;
	}

	public double getLongPrice() {
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

	public double getShortPnl() {
		return shortPnl;
	}

	public void setShortPnl(double shortPnl) {
		this.shortPnl = shortPnl;
	}

	public double getShortPrice() {
		return shortPrice;
	}

	public void setShortPrice(double shortPrice) {
		this.shortPrice = shortPrice;
	}

	public double getLastPrice() {
		return lastPrice;
	}

	public void setLastPrice(double lastPrice) {
		this.lastPrice = lastPrice;
	}

	public int getMode() {
		return mode;
	}

	public void setMode(int mode) {
		this.mode = mode;
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
        if(order.getStatus().equals(Constant.WORKING_STATUS.STATUS_UNKNOWN) ||
        		order.getStatus().equals(Constant.WORKING_STATUS.STATUS_PARTTRADED) ||
        		order.getStatus().equals(Constant.WORKING_STATUS.STATUS_NOTTRADED)){
            workingOrderDict.put(order.getVtOrderID(),order);
            
        // 移除缓存中已经完成的委托
        }else if(workingOrderDict.containsKey(order.getVtOrderID())){
                workingOrderDict.remove(order.getVtOrderID());
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
        for(Order order:workingOrderDict.values()){
            // 计算剩余冻结量
            double frozenVolume = order.getTotalVolume() - order.getTradedVolume();
            
            // 多头委托
            if(order.getDirection().equals(Constant.DIRECTION_LONG)){
                # 平今
                if order.offset is OFFSET_CLOSETODAY:
                    self.shortTdFrozen += frozenVolume
                # 平昨
                elif order.offset is OFFSET_CLOSEYESTERDAY:
                    self.shortYdFrozen += frozenVolume
                # 平仓
                elif order.offset is OFFSET_CLOSE:
                    self.shortTdFrozen += frozenVolume
                    
                    if self.shortTdFrozen > self.shortTd:
                        self.shortYdFrozen += (self.shortTdFrozen - self.shortTd)
                        self.shortTdFrozen = self.shortTd
            # 空头委托
            elif order.direction is DIRECTION_SHORT:
                # 平今
                if order.offset is OFFSET_CLOSETODAY:
                    self.longTdFrozen += frozenVolume
                # 平昨
                elif order.offset is OFFSET_CLOSEYESTERDAY:
                    self.longYdFrozen += frozenVolume
                # 平仓
                elif order.offset is OFFSET_CLOSE:
                    self.longTdFrozen += frozenVolume
                    
                    if self.longTdFrozen > self.longTd:
                        self.longYdFrozen += (self.longTdFrozen - self.longTd)
                        self.longTdFrozen = self.longTd
                        
            # 汇总今昨冻结
            self.longPosFrozen = self.longYdFrozen + self.longTdFrozen
            self.shortPosFrozen = self.shortYdFrozen + self.shortTdFrozen
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
}

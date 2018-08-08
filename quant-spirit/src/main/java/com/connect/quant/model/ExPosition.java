package com.connect.quant.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.cglib.beans.BeanCopier;

import com.connect.quant.Constant;
import com.connect.quant.model.Order;
import com.connect.quant.model.Trade;

public class ExPosition extends Position{
	
	private HashMap<String, Order> workingOrderDict;

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
        if(order.getStatus().equals(Constant.WORKING_STATUS.STATUS_UNKNOWN) ||
        		order.getStatus().equals(Constant.WORKING_STATUS.STATUS_PARTTRADED) ||
        		order.getStatus().equals(Constant.WORKING_STATUS.STATUS_NOTTRADED)){
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
            int frozenVolume = order.getTotalVolume() - order.getTradedVolume();
            
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
	public List<Order> convertOrderReq(Order order){
		
		int posAvailable = 0;
        int tdAvailable = 0;
        int ydAvailable = 0;  
        List<Order> list = new ArrayList<Order>();
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
                	Order orderTd = new Order();
                	copy.copy(order, orderTd, null);
                	orderTd.setOffset(Constant.OFFSET_CLOSETODAY);
                    orderTd.setTotalVolume(tdAvailable);
                    list.add(orderTd);
                }
                    
                Order orderYd = new Order();
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
                    Order reqClose = new Order();
                    copy.copy(order,reqClose,null);
                    if(this.exchange.equals(Constant.EXCHANGE_SHFE)){
                        reqClose.getOffset().equals(Constant.OFFSET_CLOSEYESTERDAY);
                    }else{
                        reqClose.getOffset().equals(Constant.OFFSET_CLOSE);
                    }
                    reqClose.setTotalVolume(ydAvailable);
                    list.add(reqClose);
                }
                
                Order reqOpen = new Order();
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

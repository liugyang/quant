package com.connect.quant.model;
/**
 * 交易数据
 * @author liugy
 *
 */
public class Trade {
	/** 合约代码 */
	private String symbol;
	/** 交易所代码 */
	private String exchange;
	/** 合约在vt系统中的唯一代码，通常是 合约代码.交易所代码 */
	private String vtSymbol;
	/** 成交编号 */
	private String tradeID;
	/** 成交在vt系统中的唯一编号，通常是 Gateway名.成交编号 */
	private String vtTradeID;
	/** 订单编号 */
	private String orderID;
	/** 订单在vt系统中的唯一编号，通常是 Gateway名.订单编号 */
	private String vtOrderID;
	/** 成交方向 */
	private String direction;
	/** 成交开平仓 */
	private String offset;
	/** 成交价格 */
	private double price;
	/** 成交数量 */
	private int volume;
	/** 成交时间 */
	private String tradeTime;
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
	public String getTradeID() {
		return tradeID;
	}
	public void setTradeID(String tradeID) {
		this.tradeID = tradeID;
	}
	public String getVtTradeID() {
		return vtTradeID;
	}
	public void setVtTradeID(String vtTradeID) {
		this.vtTradeID = vtTradeID;
	}
	public String getOrderID() {
		return orderID;
	}
	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}
	public String getVtOrderID() {
		return vtOrderID;
	}
	public void setVtOrderID(String vtOrderID) {
		this.vtOrderID = vtOrderID;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	public String getOffset() {
		return offset;
	}
	public void setOffset(String offset) {
		this.offset = offset;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getVolume() {
		return volume;
	}
	public void setVolume(int volume) {
		this.volume = volume;
	}
	public String getTradeTime() {
		return tradeTime;
	}
	public void setTradeTime(String tradeTime) {
		this.tradeTime = tradeTime;
	}
}

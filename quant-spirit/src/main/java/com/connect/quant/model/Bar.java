package com.connect.quant.model;

/**
 * K线数据
 * 
 * @author liugy
 *
 */
public class Bar {
	/** vt系统代码 */
	private String vtSymbol;
	/** 代码 */
	private String symbol;
	/** 交易所 */
	private String exchange;
	/** OHLC */
	private double open;
	private double high;
	private double low;
	private double close;
	/** bar开始的时间，日期 */
	private String date;
	/** 时间 */
	private String time;
	/** python的datetime时间对象 */
	private String datetime;
	/** 成交量 */
	private int volume;
	/** 持仓量 */
	private int openInterest;
	public String getVtSymbol() {
		return vtSymbol;
	}
	public void setVtSymbol(String vtSymbol) {
		this.vtSymbol = vtSymbol;
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
	public double getOpen() {
		return open;
	}
	public void setOpen(double open) {
		this.open = open;
	}
	public double getHigh() {
		return high;
	}
	public void setHigh(double high) {
		this.high = high;
	}
	public double getLow() {
		return low;
	}
	public void setLow(double low) {
		this.low = low;
	}
	public double getClose() {
		return close;
	}
	public void setClose(double close) {
		this.close = close;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getDatetime() {
		return datetime;
	}
	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}
	public int getVolume() {
		return volume;
	}
	public void setVolume(int volume) {
		this.volume = volume;
	}
	public int getOpenInterest() {
		return openInterest;
	}
	public void setOpenInterest(int openInterest) {
		this.openInterest = openInterest;
	}
}

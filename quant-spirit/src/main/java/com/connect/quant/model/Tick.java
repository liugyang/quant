package com.connect.quant.model;

/**
 * Tick行情数据类
 * @author liugy
 *
 */
public class Tick {
	/** 合约代码 */
	private String symbol;
	/** 交易所代码 */
	private String exchange;
	/** 合约在vt系统中的唯一代码，通常是 合约代码.交易所代码 */
	private String vtSymbol;

	/**成交数据*/
	/** 最新成交价 */
	private float lastPrice;
	/** 最新成交量 */
	private int lastVolume;
	/** 今天总成交量 */
	private int volume;
	/** 持仓量 */
	private int openInterest;
	/** 时间 11:20:56.5 */
	private String time;
	/** 日期 20151009 */
	private String date;
	/**python的datetime时间对象*/
	private String datetime;                  
	
	/**常规行情*/
	/** 今日开盘价 */
	private float openPrice;
	/** 今日最高价 */
	private float highPrice;
	/** 今日最低价 */
	private float lowPrice;
	/** 昨日收盘价*/
	private float preClosePrice;

	/** 涨停价 */
	private float upperLimit;
	/** 跌停价 */
	private float lowerLimit;

	/**五档行情*/
	private float bidPrice1;
	private float bidPrice2;
	private float bidPrice3;
	private float bidPrice4;
	private float bidPrice5;

	private float askPrice1;
	private float askPrice2;
	private float askPrice3;
	private float askPrice4;
	private float askPrice5;

	private int bidVolume1;
	private int bidVolume2;
	private int bidVolume3;
	private int bidVolume4;
	private int bidVolume5;

	private int askVolume1;
	private int askVolume2;
	private int askVolume3;
	private int askVolume4;
	private int askVolume5;
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
	public float getLastPrice() {
		return lastPrice;
	}
	public void setLastPrice(float lastPrice) {
		this.lastPrice = lastPrice;
	}
	public int getLastVolume() {
		return lastVolume;
	}
	public void setLastVolume(int lastVolume) {
		this.lastVolume = lastVolume;
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
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getDatetime() {
		return datetime;
	}
	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}
	public float getOpenPrice() {
		return openPrice;
	}
	public void setOpenPrice(float openPrice) {
		this.openPrice = openPrice;
	}
	public float getHighPrice() {
		return highPrice;
	}
	public void setHighPrice(float highPrice) {
		this.highPrice = highPrice;
	}
	public float getLowPrice() {
		return lowPrice;
	}
	public void setLowPrice(float lowPrice) {
		this.lowPrice = lowPrice;
	}
	public float getPreClosePrice() {
		return preClosePrice;
	}
	public void setPreClosePrice(float preClosePrice) {
		this.preClosePrice = preClosePrice;
	}
	public float getUpperLimit() {
		return upperLimit;
	}
	public void setUpperLimit(float upperLimit) {
		this.upperLimit = upperLimit;
	}
	public float getLowerLimit() {
		return lowerLimit;
	}
	public void setLowerLimit(float lowerLimit) {
		this.lowerLimit = lowerLimit;
	}
	public float getBidPrice1() {
		return bidPrice1;
	}
	public void setBidPrice1(float bidPrice1) {
		this.bidPrice1 = bidPrice1;
	}
	public float getBidPrice2() {
		return bidPrice2;
	}
	public void setBidPrice2(float bidPrice2) {
		this.bidPrice2 = bidPrice2;
	}
	public float getBidPrice3() {
		return bidPrice3;
	}
	public void setBidPrice3(float bidPrice3) {
		this.bidPrice3 = bidPrice3;
	}
	public float getBidPrice4() {
		return bidPrice4;
	}
	public void setBidPrice4(float bidPrice4) {
		this.bidPrice4 = bidPrice4;
	}
	public float getBidPrice5() {
		return bidPrice5;
	}
	public void setBidPrice5(float bidPrice5) {
		this.bidPrice5 = bidPrice5;
	}
	public float getAskPrice1() {
		return askPrice1;
	}
	public void setAskPrice1(float askPrice1) {
		this.askPrice1 = askPrice1;
	}
	public float getAskPrice2() {
		return askPrice2;
	}
	public void setAskPrice2(float askPrice2) {
		this.askPrice2 = askPrice2;
	}
	public float getAskPrice3() {
		return askPrice3;
	}
	public void setAskPrice3(float askPrice3) {
		this.askPrice3 = askPrice3;
	}
	public float getAskPrice4() {
		return askPrice4;
	}
	public void setAskPrice4(float askPrice4) {
		this.askPrice4 = askPrice4;
	}
	public float getAskPrice5() {
		return askPrice5;
	}
	public void setAskPrice5(float askPrice5) {
		this.askPrice5 = askPrice5;
	}
	public int getBidVolume1() {
		return bidVolume1;
	}
	public void setBidVolume1(int bidVolume1) {
		this.bidVolume1 = bidVolume1;
	}
	public int getBidVolume2() {
		return bidVolume2;
	}
	public void setBidVolume2(int bidVolume2) {
		this.bidVolume2 = bidVolume2;
	}
	public int getBidVolume3() {
		return bidVolume3;
	}
	public void setBidVolume3(int bidVolume3) {
		this.bidVolume3 = bidVolume3;
	}
	public int getBidVolume4() {
		return bidVolume4;
	}
	public void setBidVolume4(int bidVolume4) {
		this.bidVolume4 = bidVolume4;
	}
	public int getBidVolume5() {
		return bidVolume5;
	}
	public void setBidVolume5(int bidVolume5) {
		this.bidVolume5 = bidVolume5;
	}
	public int getAskVolume1() {
		return askVolume1;
	}
	public void setAskVolume1(int askVolume1) {
		this.askVolume1 = askVolume1;
	}
	public int getAskVolume2() {
		return askVolume2;
	}
	public void setAskVolume2(int askVolume2) {
		this.askVolume2 = askVolume2;
	}
	public int getAskVolume3() {
		return askVolume3;
	}
	public void setAskVolume3(int askVolume3) {
		this.askVolume3 = askVolume3;
	}
	public int getAskVolume4() {
		return askVolume4;
	}
	public void setAskVolume4(int askVolume4) {
		this.askVolume4 = askVolume4;
	}
	public int getAskVolume5() {
		return askVolume5;
	}
	public void setAskVolume5(int askVolume5) {
		this.askVolume5 = askVolume5;
	}
}

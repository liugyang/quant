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
	private double lastPrice;
	/** 最新成交量 */
	private long lastVolume;
	/** 今天总成交量 */
	private long volume;
	/** 持仓量 */
	private long openlongerest;
	/** 时间 11:20:56.5 */
	private String time;
	/** 日期 20151009 */
	private String date;
	/**python的datetime时间对象*/
	private String datetime;                  
	
	/**常规行情*/
	/** 今日开盘价 */
	private double openPrice;
	/** 今日最高价 */
	private double highPrice;
	/** 今日最低价 */
	private double lowPrice;
	/** 昨日收盘价*/
	private double preClosePrice;

	/** 涨停价 */
	private double upperLimit;
	/** 跌停价 */
	private double lowerLimit;

	/**五档行情*/
	private double bidPrice1;
	private double bidPrice2;
	private double bidPrice3;
	private double bidPrice4;
	private double bidPrice5;

	private double askPrice1;
	private double askPrice2;
	private double askPrice3;
	private double askPrice4;
	private double askPrice5;

	private long bidVolume1;
	private long bidVolume2;
	private long bidVolume3;
	private long bidVolume4;
	private long bidVolume5;

	private long askVolume1;
	private long askVolume2;
	private long askVolume3;
	private long askVolume4;
	private long askVolume5;
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
	public double getLastPrice() {
		return lastPrice;
	}
	public void setLastPrice(double lastPrice) {
		this.lastPrice = lastPrice;
	}
	public long getLastVolume() {
		return lastVolume;
	}
	public void setLastVolume(long lastVolume) {
		this.lastVolume = lastVolume;
	}
	public long getVolume() {
		return volume;
	}
	public void setVolume(long volume) {
		this.volume = volume;
	}
	public long getOpenlongerest() {
		return openlongerest;
	}
	public void setOpenlongerest(long openlongerest) {
		this.openlongerest = openlongerest;
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
	public double getOpenPrice() {
		return openPrice;
	}
	public void setOpenPrice(double openPrice) {
		this.openPrice = openPrice;
	}
	public double getHighPrice() {
		return highPrice;
	}
	public void setHighPrice(double highPrice) {
		this.highPrice = highPrice;
	}
	public double getLowPrice() {
		return lowPrice;
	}
	public void setLowPrice(double lowPrice) {
		this.lowPrice = lowPrice;
	}
	public double getPreClosePrice() {
		return preClosePrice;
	}
	public void setPreClosePrice(double preClosePrice) {
		this.preClosePrice = preClosePrice;
	}
	public double getUpperLimit() {
		return upperLimit;
	}
	public void setUpperLimit(double upperLimit) {
		this.upperLimit = upperLimit;
	}
	public double getLowerLimit() {
		return lowerLimit;
	}
	public void setLowerLimit(double lowerLimit) {
		this.lowerLimit = lowerLimit;
	}
	public double getBidPrice1() {
		return bidPrice1;
	}
	public void setBidPrice1(double bidPrice1) {
		this.bidPrice1 = bidPrice1;
	}
	public double getBidPrice2() {
		return bidPrice2;
	}
	public void setBidPrice2(double bidPrice2) {
		this.bidPrice2 = bidPrice2;
	}
	public double getBidPrice3() {
		return bidPrice3;
	}
	public void setBidPrice3(double bidPrice3) {
		this.bidPrice3 = bidPrice3;
	}
	public double getBidPrice4() {
		return bidPrice4;
	}
	public void setBidPrice4(double bidPrice4) {
		this.bidPrice4 = bidPrice4;
	}
	public double getBidPrice5() {
		return bidPrice5;
	}
	public void setBidPrice5(double bidPrice5) {
		this.bidPrice5 = bidPrice5;
	}
	public double getAskPrice1() {
		return askPrice1;
	}
	public void setAskPrice1(double askPrice1) {
		this.askPrice1 = askPrice1;
	}
	public double getAskPrice2() {
		return askPrice2;
	}
	public void setAskPrice2(double askPrice2) {
		this.askPrice2 = askPrice2;
	}
	public double getAskPrice3() {
		return askPrice3;
	}
	public void setAskPrice3(double askPrice3) {
		this.askPrice3 = askPrice3;
	}
	public double getAskPrice4() {
		return askPrice4;
	}
	public void setAskPrice4(double askPrice4) {
		this.askPrice4 = askPrice4;
	}
	public double getAskPrice5() {
		return askPrice5;
	}
	public void setAskPrice5(double askPrice5) {
		this.askPrice5 = askPrice5;
	}
	public long getBidVolume1() {
		return bidVolume1;
	}
	public void setBidVolume1(long bidVolume1) {
		this.bidVolume1 = bidVolume1;
	}
	public long getBidVolume2() {
		return bidVolume2;
	}
	public void setBidVolume2(long bidVolume2) {
		this.bidVolume2 = bidVolume2;
	}
	public long getBidVolume3() {
		return bidVolume3;
	}
	public void setBidVolume3(long bidVolume3) {
		this.bidVolume3 = bidVolume3;
	}
	public long getBidVolume4() {
		return bidVolume4;
	}
	public void setBidVolume4(long bidVolume4) {
		this.bidVolume4 = bidVolume4;
	}
	public long getBidVolume5() {
		return bidVolume5;
	}
	public void setBidVolume5(long bidVolume5) {
		this.bidVolume5 = bidVolume5;
	}
	public long getAskVolume1() {
		return askVolume1;
	}
	public void setAskVolume1(long askVolume1) {
		this.askVolume1 = askVolume1;
	}
	public long getAskVolume2() {
		return askVolume2;
	}
	public void setAskVolume2(long askVolume2) {
		this.askVolume2 = askVolume2;
	}
	public long getAskVolume3() {
		return askVolume3;
	}
	public void setAskVolume3(long askVolume3) {
		this.askVolume3 = askVolume3;
	}
	public long getAskVolume4() {
		return askVolume4;
	}
	public void setAskVolume4(long askVolume4) {
		this.askVolume4 = askVolume4;
	}
	public long getAskVolume5() {
		return askVolume5;
	}
	public void setAskVolume5(long askVolume5) {
		this.askVolume5 = askVolume5;
	}
}

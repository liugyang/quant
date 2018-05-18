package com.connect.stock.spirit.model.product;

import java.util.Date;

public class ProductQuote {
	/**期货名字；*/
	private String name;
	/**今日开盘价*/ 
	private double openingPrice;
	/**昨日收盘价*/ 
	private double closingPrice;
	/**当前价格*/ 
	private double currentPrice;
	/**今日最高价*/ 
	private double highestPrice;
	/**今日最低价*/
	private double lowestPrice;
	/**竞买价，即“买一”报价*/
	private double competitiveBuyPrice;
	/**竞卖价，即“卖一”报价*/
	private double competitiveSalePrice;
	/**持仓量*/
	private long numberOfHeld;
	/**成交金额*/
	private long numberOfTraded;
	/**买量*/ 
	private long amountOfBuy;
	/**“买一”报价*/
	private double priceOfBuy1;
	/**“买二”*/
	private double priceOfBuy2;
	/**“买三”*/
	private double priceOfBuy3;
	/**“买四”*/
	private double priceOfBuy4;
	/**“买五”*/
	private double priceOfBuy5;
	/**卖量*/
	private long amountOfSale;
	/**“卖一”报价*/
	private double priceOfSale1;
	/**“卖二”报价*/
	private double priceOfSale2;
	/**“卖三”报价*/
	private double priceOfSale3;
	/**“卖四”报价*/
	private double priceOfSale4;
	/**“卖五”报价*/
	private double priceOfSale5;
	/**日期*/
	private Date date;
	/**时间*/
	private Date time;
	/**ID*/
	private String ID;
	/**结算价*/
	private double settlementPrice;
	/** 昨日结算*/
	private double lastSettlementPrice;
	/**交易简称*/
	private String market;
	/**品种名称*/
	private String categoryName;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getOpeningPrice() {
		return openingPrice;
	}
	public void setOpeningPrice(double openingPrice) {
		this.openingPrice = openingPrice;
	}
	public double getClosingPrice() {
		return closingPrice;
	}
	public void setClosingPrice(double closingPrice) {
		this.closingPrice = closingPrice;
	}
	public double getCurrentPrice() {
		return currentPrice;
	}
	public void setCurrentPrice(double currentPrice) {
		this.currentPrice = currentPrice;
	}
	public double getHighestPrice() {
		return highestPrice;
	}
	public void setHighestPrice(double highestPrice) {
		this.highestPrice = highestPrice;
	}
	public double getLowestPrice() {
		return lowestPrice;
	}
	public void setLowestPrice(double lowestPrice) {
		this.lowestPrice = lowestPrice;
	}
	public double getCompetitiveBuyPrice() {
		return competitiveBuyPrice;
	}
	public void setCompetitiveBuyPrice(double competitiveBuyPrice) {
		this.competitiveBuyPrice = competitiveBuyPrice;
	}
	public double getCompetitiveSalePrice() {
		return competitiveSalePrice;
	}
	public void setCompetitiveSalePrice(double competitiveSalePrice) {
		this.competitiveSalePrice = competitiveSalePrice;
	}
	public long getNumberOfHeld() {
		return numberOfHeld;
	}
	public void setNumberOfHeld(long numberOfHeld) {
		this.numberOfHeld = numberOfHeld;
	}
	public long getNumberOfTraded() {
		return numberOfTraded;
	}
	public void setNumberOfTraded(long numberOfTraded) {
		this.numberOfTraded = numberOfTraded;
	}
	public long getAmountOfBuy() {
		return amountOfBuy;
	}
	public void setAmountOfBuy(long amountOfBuy) {
		this.amountOfBuy = amountOfBuy;
	}
	public double getPriceOfBuy1() {
		return priceOfBuy1;
	}
	public void setPriceOfBuy1(double priceOfBuy1) {
		this.priceOfBuy1 = priceOfBuy1;
	}
	public double getPriceOfBuy2() {
		return priceOfBuy2;
	}
	public void setPriceOfBuy2(double priceOfBuy2) {
		this.priceOfBuy2 = priceOfBuy2;
	}
	public double getPriceOfBuy3() {
		return priceOfBuy3;
	}
	public void setPriceOfBuy3(double priceOfBuy3) {
		this.priceOfBuy3 = priceOfBuy3;
	}
	public double getPriceOfBuy4() {
		return priceOfBuy4;
	}
	public void setPriceOfBuy4(double priceOfBuy4) {
		this.priceOfBuy4 = priceOfBuy4;
	}
	public double getPriceOfBuy5() {
		return priceOfBuy5;
	}
	public void setPriceOfBuy5(double priceOfBuy5) {
		this.priceOfBuy5 = priceOfBuy5;
	}
	public long getAmountOfSale() {
		return amountOfSale;
	}
	public void setAmountOfSale(long amountOfSale) {
		this.amountOfSale = amountOfSale;
	}
	public double getPriceOfSale1() {
		return priceOfSale1;
	}
	public void setPriceOfSale1(double priceOfSale1) {
		this.priceOfSale1 = priceOfSale1;
	}
	public double getPriceOfSale2() {
		return priceOfSale2;
	}
	public void setPriceOfSale2(double priceOfSale2) {
		this.priceOfSale2 = priceOfSale2;
	}
	public double getPriceOfSale3() {
		return priceOfSale3;
	}
	public void setPriceOfSale3(double priceOfSale3) {
		this.priceOfSale3 = priceOfSale3;
	}
	public double getPriceOfSale4() {
		return priceOfSale4;
	}
	public void setPriceOfSale4(double priceOfSale4) {
		this.priceOfSale4 = priceOfSale4;
	}
	public double getPriceOfSale5() {
		return priceOfSale5;
	}
	public void setPriceOfSale5(double priceOfSale5) {
		this.priceOfSale5 = priceOfSale5;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public double getSettlementPrice() {
		return settlementPrice;
	}
	public void setSettlementPrice(double settlementPrice) {
		this.settlementPrice = settlementPrice;
	}
	public double getLastSettlementPrice() {
		return lastSettlementPrice;
	}
	public void setLastSettlementPrice(double lastSettlementPrice) {
		this.lastSettlementPrice = lastSettlementPrice;
	}
	public String getMarket() {
		return market;
	}
	public void setMarket(String market) {
		this.market = market;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
}

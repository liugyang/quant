package com.connect.stock.spirit.model.stock;

import java.util.Date;

public class StockQuote {
	/**0：股票名字；*/
	private String name;
	/**1：今日开盘价*/ 
	private double openingPrice;
	/**2：昨日收盘价*/ 
	private double closingPrice;
	/**3：当前价格*/ 
	private double currentPrice;
	/**4：今日最高价*/ 
	private double highestPrice;
	/**5：今日最低价*/
	private double lowestPrice;
	/**6：竞买价，即“买一”报价*/
	private double competitiveBuyPrice;
	/**7：竞卖价，即“卖一”报价*/
	private double competitiveSalePrice;
	/**8：成交的股票数，由于股票交易以一百股为基本单位，所以在使用时，通常把该值除以一百*/
	private long NumberOfShareTraded;
	/**9：成交金额，单位为“元”，为了一目了然，通常以“万元”为成交金额的单位，所以通常把该值除以一万*/
	private double moneyOfShareTraded;
	/**10：“买一”申请4695股，即47手*/ 
	private long amountOfBuy1;
	/**11：”26.91″，“买一”报价*/
	private double priceOfBuy1;
	/**12：”57590″，“买二”*/
	private long amountOfBuy2;
	/**13：”26.90″，“买二”*/
	private double priceOfBuy2;
	/**14：”14700″，“买三”*/
	private long amountOfBuy3;
	/**15：”26.89″，“买三”*/
	private double priceOfBuy3;
	/**16：”14300″，“买四”*/
	private long amountOfBuy4;
	/**17：”26.88″，“买四”*/
	private double priceOfBuy4;
	/**18：”15100″，“买五”*/
	private long amountOfBuy5;
	/**19：”26.87″，“买五”*/
	private double priceOfBuy5;
	/**20：”3100″，“卖一”申报3100股，即31手；*/
	private long amountOfSale1;
	/**21：”26.92″，“卖一”报价*/
	private double priceOfSale1;
	/**20：”3100″，“卖二”申报3100股，即31手；*/
	private long amountOfSale2;
	/**21：”26.92″，“卖二”报价*/
	private double priceOfSale2;
	/**20：”3100″，“卖三”申报3100股，即31手；*/
	private long amountOfSale3;
	/**21：”26.92″，“卖三”报价*/
	private double priceOfSale3;
	/**20：”3100″，“卖四”申报3100股，即31手；*/
	private long amountOfSale4;
	/**21：”26.92″，“卖四”报价*/
	private double priceOfSale4;
	/**20：”3100″，“卖五”申报3100股，即31手；*/
	private long amountOfSale5;
	/**21：”26.92″，“卖五”报价*/
	private double priceOfSale5;
	/**30：”2008-01-11″，日期；*/
	private Date date;
	/**31：”15:05:32″，时间；*/
	private Date time;
	/**32：ID*/
	private String ID;
	
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
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
	public long getNumberOfShareTraded() {
		return NumberOfShareTraded;
	}
	public void setNumberOfShareTraded(long numberOfShareTraded) {
		NumberOfShareTraded = numberOfShareTraded;
	}
	public double getMoneyOfShareTraded() {
		return moneyOfShareTraded;
	}
	public void setMoneyOfShareTraded(double moneyOfShareTraded) {
		this.moneyOfShareTraded = moneyOfShareTraded;
	}
	public long getAmountOfBuy1() {
		return amountOfBuy1;
	}
	public void setAmountOfBuy1(long amountOfBuy1) {
		this.amountOfBuy1 = amountOfBuy1;
	}
	public double getPriceOfBuy1() {
		return priceOfBuy1;
	}
	public void setPriceOfBuy1(double priceOfBuy1) {
		this.priceOfBuy1 = priceOfBuy1;
	}
	public long getAmountOfBuy2() {
		return amountOfBuy2;
	}
	public void setAmountOfBuy2(long amountOfBuy2) {
		this.amountOfBuy2 = amountOfBuy2;
	}
	public double getPriceOfBuy2() {
		return priceOfBuy2;
	}
	public void setPriceOfBuy2(double priceOfBuy2) {
		this.priceOfBuy2 = priceOfBuy2;
	}
	public long getAmountOfBuy3() {
		return amountOfBuy3;
	}
	public void setAmountOfBuy3(long amountOfBuy3) {
		this.amountOfBuy3 = amountOfBuy3;
	}
	public double getPriceOfBuy3() {
		return priceOfBuy3;
	}
	public void setPriceOfBuy3(double priceOfBuy3) {
		this.priceOfBuy3 = priceOfBuy3;
	}
	public long getAmountOfBuy4() {
		return amountOfBuy4;
	}
	public void setAmountOfBuy4(long amountOfBuy4) {
		this.amountOfBuy4 = amountOfBuy4;
	}
	public double getPriceOfBuy4() {
		return priceOfBuy4;
	}
	public void setPriceOfBuy4(double priceOfBuy4) {
		this.priceOfBuy4 = priceOfBuy4;
	}
	public long getAmountOfBuy5() {
		return amountOfBuy5;
	}
	public void setAmountOfBuy5(long amountOfBuy5) {
		this.amountOfBuy5 = amountOfBuy5;
	}
	public double getPriceOfBuy5() {
		return priceOfBuy5;
	}
	public void setPriceOfBuy5(double priceOfBuy5) {
		this.priceOfBuy5 = priceOfBuy5;
	}
	public long getAmountOfSale1() {
		return amountOfSale1;
	}
	public void setAmountOfSale1(long amountOfSale1) {
		this.amountOfSale1 = amountOfSale1;
	}
	public double getPriceOfSale1() {
		return priceOfSale1;
	}
	public void setPriceOfSale1(double priceOfSale1) {
		this.priceOfSale1 = priceOfSale1;
	}
	public long getAmountOfSale2() {
		return amountOfSale2;
	}
	public void setAmountOfSale2(long amountOfSale2) {
		this.amountOfSale2 = amountOfSale2;
	}
	public double getPriceOfSale2() {
		return priceOfSale2;
	}
	public void setPriceOfSale2(double priceOfSale2) {
		this.priceOfSale2 = priceOfSale2;
	}
	public long getAmountOfSale3() {
		return amountOfSale3;
	}
	public void setAmountOfSale3(long amountOfSale3) {
		this.amountOfSale3 = amountOfSale3;
	}
	public double getPriceOfSale3() {
		return priceOfSale3;
	}
	public void setPriceOfSale3(double priceOfSale3) {
		this.priceOfSale3 = priceOfSale3;
	}
	public long getAmountOfSale4() {
		return amountOfSale4;
	}
	public void setAmountOfSale4(long amountOfSale4) {
		this.amountOfSale4 = amountOfSale4;
	}
	public double getPriceOfSale4() {
		return priceOfSale4;
	}
	public void setPriceOfSale4(double priceOfSale4) {
		this.priceOfSale4 = priceOfSale4;
	}
	public long getAmountOfSale5() {
		return amountOfSale5;
	}
	public void setAmountOfSale5(long amountOfSale5) {
		this.amountOfSale5 = amountOfSale5;
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
	
}

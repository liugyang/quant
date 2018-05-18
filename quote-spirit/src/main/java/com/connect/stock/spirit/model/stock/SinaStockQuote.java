package com.connect.stock.spirit.model.stock;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class SinaStockQuote extends StockQuote {
	
	private String originalStr;

	public SinaStockQuote(String infoStr){
		if(!infoStr.contains("=")){
			return;
		}
		originalStr = infoStr;
		
		String value = infoStr.split("=")[1];
		value.replace("\"", "");
		String[] splits = value.split(",");
		this.setName(splits[0].trim());
		this.setOpeningPrice(Double.parseDouble(splits[1].trim()));
		this.setClosingPrice(Double.parseDouble(splits[2].trim()));
		this.setCurrentPrice(Double.parseDouble(splits[3].trim()));
		this.setHighestPrice(Double.parseDouble(splits[4].trim()));
		this.setLowestPrice(Double.parseDouble(splits[5].trim()));
		this.setCompetitiveBuyPrice(Double.parseDouble(splits[6].trim()));
		this.setCompetitiveSalePrice(Double.parseDouble(splits[7].trim()));
		this.setNumberOfShareTraded(Long.parseLong(splits[8].trim()));
		this.setMoneyOfShareTraded(Double.parseDouble(splits[9].trim()));
		this.setAmountOfBuy1(Long.parseLong(splits[10].trim()));
		this.setPriceOfBuy1(Double.parseDouble(splits[11].trim()));
		this.setAmountOfBuy2(Long.parseLong(splits[12].trim()));
		this.setPriceOfBuy2(Double.parseDouble(splits[13].trim()));
		this.setAmountOfBuy3(Long.parseLong(splits[14].trim()));
		this.setPriceOfBuy3(Double.parseDouble(splits[15].trim()));
		this.setAmountOfBuy4(Long.parseLong(splits[16].trim()));
		this.setPriceOfBuy4(Double.parseDouble(splits[17].trim()));
		this.setAmountOfBuy5(Long.parseLong(splits[18].trim()));
		this.setPriceOfBuy5(Double.parseDouble(splits[19].trim()));
		this.setAmountOfSale1(Long.parseLong(splits[20].trim()));
		this.setPriceOfSale1(Double.parseDouble(splits[21].trim()));
		this.setAmountOfSale2(Long.parseLong(splits[22].trim()));
		this.setPriceOfSale2(Double.parseDouble(splits[23].trim()));
		this.setAmountOfSale3(Long.parseLong(splits[24].trim()));
		this.setPriceOfSale3(Double.parseDouble(splits[25].trim()));
		this.setAmountOfSale4(Long.parseLong(splits[26].trim()));
		this.setPriceOfSale4(Double.parseDouble(splits[27].trim()));
		this.setAmountOfSale5(Long.parseLong(splits[28].trim()));
		this.setPriceOfSale5(Double.parseDouble(splits[29].trim()));
		DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		try {
			this.setDate(format1.parse(splits[30].trim()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		DateFormat format2 = new SimpleDateFormat("HH:mm:ss");
		try {
			this.setTime(format2.parse(splits[31].trim()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String toString() {
		return originalStr;
	}
}

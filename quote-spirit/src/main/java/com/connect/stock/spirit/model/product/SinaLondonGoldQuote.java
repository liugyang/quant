package com.connect.stock.spirit.model.product;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class SinaLondonGoldQuote extends ProductQuote{
	private String originalStr;
	
	public SinaLondonGoldQuote(String infoStr){
		if(!infoStr.contains("=")){
			return;
		}
		originalStr = infoStr;
		
		String value = infoStr.split("=")[1];
		value = value.replaceAll("\"", "");
		String[] splits = value.split(",");
		this.setCurrentPrice(Double.parseDouble(splits[0].trim()));
		//splits[1]
		this.setPriceOfSale1(Double.parseDouble(splits[2].trim()));
		this.setPriceOfBuy1(Double.parseDouble(splits[3].trim()));
		this.setHighestPrice(Double.parseDouble(splits[4].trim()));
		this.setLowestPrice(Double.parseDouble(splits[5].trim()));
		DateFormat format2 = new SimpleDateFormat("HH:mm:ss");
		try {
			String time = splits[6].trim();
			this.setTime(format2.parse(time));
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (NumberFormatException e){
			e.printStackTrace();
		}
		this.setLastSettlementPrice(Double.parseDouble(splits[7].trim()));
		this.setOpeningPrice(Double.parseDouble(splits[8].trim()));
		//splits[9]
		//splits[10]
		//splits[11]
		DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		try {
			this.setDate(format1.parse(splits[12].trim()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		this.setName(splits[13].trim());
	}

	@Override
	public String toString() {
		return originalStr;
	}
}

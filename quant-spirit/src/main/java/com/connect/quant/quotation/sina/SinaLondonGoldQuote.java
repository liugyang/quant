package com.connect.quant.quotation.sina;

/**
 * 新浪黄金现货行情
 */
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.connect.quant.model.ProductQuote;

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
		this.setCurrentprice(Double.parseDouble(splits[0].trim()));
		//splits[1]
		this.setPriceofsale1(Double.parseDouble(splits[2].trim()));
		this.setPriceofbuy1(Double.parseDouble(splits[3].trim()));
		this.setHighestprice(Double.parseDouble(splits[4].trim()));
		this.setLowestprice(Double.parseDouble(splits[5].trim()));
		DateFormat format2 = new SimpleDateFormat("HH:mm:ss");
		try {
			String time = splits[6].trim();
			this.setTime(format2.parse(time));
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (NumberFormatException e){
			e.printStackTrace();
		}
		this.setLastsettlementprice(Double.parseDouble(splits[7].trim()));
		this.setOpeningprice(Double.parseDouble(splits[8].trim()));
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

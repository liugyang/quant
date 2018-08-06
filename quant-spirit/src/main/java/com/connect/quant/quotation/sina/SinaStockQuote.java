package com.connect.quant.quotation.sina;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.connect.quant.model.StockQuote;
/**
 * 新浪A股行情对象
 * @author liugy
 *
 */
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
		this.setOpeningprice(Double.parseDouble(splits[1].trim()));
		this.setClosingprice(Double.parseDouble(splits[2].trim()));
		this.setCurrentprice(Double.parseDouble(splits[3].trim()));
		this.setHighestprice(Double.parseDouble(splits[4].trim()));
		this.setLowestprice(Double.parseDouble(splits[5].trim()));
		this.setCompetitivebuyprice(Double.parseDouble(splits[6].trim()));
		this.setCompetitivesaleprice(Double.parseDouble(splits[7].trim()));
		this.setNumberofsharetraded(Long.parseLong(splits[8].trim()));
		this.setMoneyofsharetraded(Double.parseDouble(splits[9].trim()));
		this.setAmountofbuy1(Long.parseLong(splits[10].trim()));
		this.setPriceofbuy1(Double.parseDouble(splits[11].trim()));
		this.setAmountofbuy2(Long.parseLong(splits[12].trim()));
		this.setPriceofbuy2(Double.parseDouble(splits[13].trim()));
		this.setAmountofbuy3(Long.parseLong(splits[14].trim()));
		this.setPriceofbuy3(Double.parseDouble(splits[15].trim()));
		this.setAmountofbuy4(Long.parseLong(splits[16].trim()));
		this.setPriceofbuy4(Double.parseDouble(splits[17].trim()));
		this.setAmountofbuy5(Long.parseLong(splits[18].trim()));
		this.setPriceofbuy5(Double.parseDouble(splits[19].trim()));
		this.setAmountofsale1(Long.parseLong(splits[20].trim()));
		this.setPriceofsale1(Double.parseDouble(splits[21].trim()));
		this.setAmountofsale2(Long.parseLong(splits[22].trim()));
		this.setPriceofsale2(Double.parseDouble(splits[23].trim()));
		this.setAmountofsale3(Long.parseLong(splits[24].trim()));
		this.setPriceofsale3(Double.parseDouble(splits[25].trim()));
		this.setAmountofsale4(Long.parseLong(splits[26].trim()));
		this.setPriceofsale4(Double.parseDouble(splits[27].trim()));
		this.setAmountofsale5(Long.parseLong(splits[28].trim()));
		this.setPriceofsale5(Double.parseDouble(splits[29].trim()));
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

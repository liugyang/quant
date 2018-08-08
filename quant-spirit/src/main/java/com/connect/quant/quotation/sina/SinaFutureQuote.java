package com.connect.quant.quotation.sina;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.connect.quant.model.FutureQuote;

/**
 * 新浪期货行情对象
 * @author liugy
 *
 */
public class SinaFutureQuote extends FutureQuote {
	private String originalStr;

	public SinaFutureQuote(String infoStr){
		if(!infoStr.contains("=")){
			return;
		}
		originalStr = infoStr;
		
		String value = infoStr.split("=")[1];
		value = value.replaceAll("\"", "");
		String[] splits = value.split(",");
		this.setName(splits[0].trim());
		DateFormat format2 = new SimpleDateFormat("HHmmss");
		try {
			String time = String.format("%06d", Integer.parseInt(splits[1].trim()));
			this.setTime(format2.parse(time));
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (NumberFormatException e){
			e.printStackTrace();
		}
		this.setOpeningPrice(Double.parseDouble(splits[2].trim()));
		this.setHighestPrice(Double.parseDouble(splits[3].trim()));
		this.setLowestPrice(Double.parseDouble(splits[4].trim()));
		this.setClosingPrice(Double.parseDouble(splits[5].trim()));
		this.setPriceOfBuy1(Double.parseDouble(splits[6].trim()));
		this.setPriceOfSale1(Double.parseDouble(splits[7].trim()));
		this.setCurrentPrice(Double.parseDouble(splits[8].trim()));
		this.setSettlementPrice(Double.parseDouble(splits[9].trim()));
		this.setLastSettlementPrice(Double.parseDouble(splits[10].trim()));
		this.setAmountOfBuy(Long.parseLong(splits[11].trim()));
		this.setAmountOfSale(Long.parseLong(splits[12].trim()));
		this.setNumberOfHeld(Long.parseLong(splits[13].trim()));
		this.setNumberOfTraded(Long.parseLong(splits[14].trim()));
		this.setExchange(splits[15].trim());
		this.setCategory(splits[16].trim());
		DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		try {
			this.setDate(format1.parse(splits[17].trim()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		//splits[18] TODO
		this.setPriceOfBuy2(Double.parseDouble(splits[19].trim()));
		this.setPriceOfSale2(Double.parseDouble(splits[20].trim()));
		this.setPriceOfBuy3(Double.parseDouble(splits[21].trim()));
		this.setPriceOfSale3(Double.parseDouble(splits[22].trim()));
		this.setPriceOfBuy4(Double.parseDouble(splits[23].trim()));
		this.setPriceOfSale4(Double.parseDouble(splits[24].trim()));
		this.setPriceOfBuy5(Double.parseDouble(splits[25].trim()));
		this.setPriceOfSale5(Double.parseDouble(splits[26].trim()));
		//splits[27] TODO
	}

	@Override
	public String toString() {
		return originalStr;
	}
}

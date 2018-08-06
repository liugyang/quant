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
		this.setOpeningprice(Double.parseDouble(splits[2].trim()));
		this.setHighestprice(Double.parseDouble(splits[3].trim()));
		this.setLowestprice(Double.parseDouble(splits[4].trim()));
		this.setClosingprice(Double.parseDouble(splits[5].trim()));
		this.setPriceofbuy1(Double.parseDouble(splits[6].trim()));
		this.setPriceofsale1(Double.parseDouble(splits[7].trim()));
		this.setCurrentprice(Double.parseDouble(splits[8].trim()));
		this.setSettlementprice(Double.parseDouble(splits[9].trim()));
		this.setLastsettlementprice(Double.parseDouble(splits[10].trim()));
		this.setAmountofbuy(Long.parseLong(splits[11].trim()));
		this.setAmountofsale(Long.parseLong(splits[12].trim()));
		this.setNumberofheld(Long.parseLong(splits[13].trim()));
		this.setNumberoftraded(Long.parseLong(splits[14].trim()));
		this.setMarket(splits[15].trim());
		this.setCategory(splits[16].trim());
		DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		try {
			this.setDate(format1.parse(splits[17].trim()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		//splits[18] TODO
		this.setPriceofbuy2(Double.parseDouble(splits[19].trim()));
		this.setPriceofsale2(Double.parseDouble(splits[20].trim()));
		this.setPriceofbuy3(Double.parseDouble(splits[21].trim()));
		this.setPriceofsale3(Double.parseDouble(splits[22].trim()));
		this.setPriceofbuy4(Double.parseDouble(splits[23].trim()));
		this.setPriceofsale4(Double.parseDouble(splits[24].trim()));
		this.setPriceofbuy5(Double.parseDouble(splits[25].trim()));
		this.setPriceofsale5(Double.parseDouble(splits[26].trim()));
		//splits[27] TODO
	}

	@Override
	public String toString() {
		return originalStr;
	}
}

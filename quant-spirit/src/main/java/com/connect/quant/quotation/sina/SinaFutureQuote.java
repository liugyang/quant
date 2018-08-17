package com.connect.quant.quotation.sina;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.connect.quant.model.FutureQuote;
import com.connect.quant.model.Tick;

/**
 * 新浪期货行情对象
 * @author liugy
 *
 */
public class SinaFutureQuote extends FutureQuote {
	private final static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private final static DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
    private final static DateFormat datetimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
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
	
	public Tick toTick(double upperLimitRate, double lowerLimitRate) {
        Tick tick = new Tick();
        tick.setSymbol(this.getSymbol());
        tick.setVtSymbol(this.getSymbol() + "." + this.getExchange());
        tick.setLastPrice(this.getCurrentPrice());
        tick.setLastVolume(this.getNumberOfTraded());
        tick.setVolume(this.getNumberOfTraded());
        tick.setOpenlongerest(this.getNumberOfHeld());
        tick.setTime(this.getTime());
        tick.setDate(this.getDate());
        tick.setDatetime(tick.getDate() + " " + tick.getTime());
        tick.setOpenPrice(this.getOpeningPrice());
        tick.setHighPrice(this.getHighestPrice());
        tick.setLowPrice(this.getLowestPrice());
        tick.setPreClosePrice(this.getClosingPrice());
        tick.setUpperLimit(this.getOpeningPrice()*(1+upperLimitRate));
        tick.setLowerLimit(this.getOpeningPrice()*(1-lowerLimitRate));
        tick.setBidPrice1(this.getPriceOfSale1());
        tick.setBidPrice2(this.getPriceOfSale2());
        tick.setBidPrice3(this.getPriceOfSale3());
        tick.setBidPrice4(this.getPriceOfSale4());
        tick.setBidPrice5(this.getPriceOfSale5());
        tick.setAskPrice1(this.getPriceOfBuy1());
        tick.setAskPrice2(this.getPriceOfBuy2());
        tick.setAskPrice3(this.getPriceOfBuy3());
        tick.setAskPrice4(this.getPriceOfBuy4());
        tick.setAskPrice5(this.getPriceOfBuy5());
        tick.setBidVolume1(this.getAmountOfSale());
        tick.setBidVolume2(0L);
        tick.setBidVolume3(0L);
        tick.setBidVolume4(0L);
        tick.setBidVolume5(0L);
        tick.setAskVolume1(this.getAmountOfBuy());
        tick.setAskVolume2(0L);
        tick.setAskVolume3(0L);
        tick.setAskVolume4(0L);
        tick.setAskVolume5(0L);

        return tick;
    }

	@Override
	public String toString() {
		return originalStr;
	}
}

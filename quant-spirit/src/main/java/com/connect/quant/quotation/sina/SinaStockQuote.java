package com.connect.quant.quotation.sina;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.connect.quant.model.StockQuote;
import com.connect.quant.model.Tick;

/**
 * 新浪A股行情对象
 *
 * @author liugy
 */
public class SinaStockQuote extends StockQuote {

    private final static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private final static DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
    private final static DateFormat datetimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private String originalStr;

    public SinaStockQuote(String infoStr) {
        if (!infoStr.contains("=")) {
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
        try {
            this.setDate(dateFormat.parse(splits[30].trim()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        try {
            this.setTime(timeFormat.parse(splits[31].trim()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public Tick toTick(double upperLimitRate, double lowerLimitRate) {
        Tick tick = new Tick();
        tick.setSymbol(this.getSymbol());
        tick.setVtSymbol(this.getSymbol() + "." + this.getExchange());
        tick.setLastPrice(this.getCurrentPrice());
        tick.setLastVolume(this.getNumberOfShareTraded());
        tick.setVolume(this.getNumberOfShareTraded());
        tick.setOpenlongerest(this.getNumberOfShareTraded());
        tick.setTime(timeFormat.format(this.getTime()));
        tick.setDate(dateFormat.format(this.getDate()));
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
        tick.setBidVolume1(this.getAmountOfSale1());
        tick.setBidVolume2(this.getAmountOfSale2());
        tick.setBidVolume3(this.getAmountOfSale3());
        tick.setBidVolume4(this.getAmountOfSale4());
        tick.setBidVolume5(this.getAmountOfSale5());
        tick.setAskVolume1(this.getAmountOfBuy1());
        tick.setAskVolume2(this.getAmountOfBuy2());
        tick.setAskVolume3(this.getAmountOfBuy3());
        tick.setAskVolume4(this.getAmountOfBuy4());
        tick.setAskVolume5(this.getAmountOfBuy5());

        return tick;
    }

    @Override
    public String toString() {
        return originalStr;
    }
}

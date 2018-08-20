package com.connect.stock.spirit.controller;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.connect.stock.spirit.Config;
import com.connect.stock.spirit.component.FutureAccount;
import com.connect.stock.spirit.model.future.FutureQuote;
import com.connect.stock.spirit.task.ChannelBreakPolicy;

@RestController
public class FundController {

	@Autowired
    @Qualifier("config")
    private Config config;
	
    @Autowired
    private FutureAccount futureAccount;

    @Autowired
    private ChannelBreakPolicy channelBreakPolicy;

    @RequestMapping("/show_shares")
    public @ResponseBody FundShares showShares(){
        FundShares sh = new FundShares();
        sh.setBuyLongShares(futureAccount.getBuyLongShares());
        sh.setShortSellingShares(futureAccount.getShortSellingShares());
        return sh;
    }

    @RequestMapping("/show_trade_log")
    public @ResponseBody LinkedList<String> showTradeLog(){
        return futureAccount.getTradesLogs();
    }

    @RequestMapping("/show_cached_quote")
    public @ResponseBody ArrayBlockingQueue<FutureQuote> getFutureQuoteCache() {
        return channelBreakPolicy.getFutureQuoteCache();
    }

    @RequestMapping("/show_cached_quote_for_atr")
    public @ResponseBody ArrayBlockingQueue<FutureQuote> getFutureQuoteCacheForATR() {
        return channelBreakPolicy.getFutureQuoteCacheForATR();
    }

    @RequestMapping("/show_cached_stop_loss_price_buy_long")
    public @ResponseBody
    Map<String, Double> getStopLossPriceCacheForBuyLong() {
        return channelBreakPolicy.getStopLossPriceCacheForBuyLong();
    }

    @RequestMapping("/show_cached_stop_loss_price_short_sell")
    public @ResponseBody Map<String, Double> getStopLossPriceCacheForShortSell() {
        return channelBreakPolicy.getStopLossPriceCacheForShortSell();
    }

    @RequestMapping("/show_cached_atr")
    public @ResponseBody ArrayBlockingQueue<Double> getCacheforATR() {
        return channelBreakPolicy.getCacheforATR();
    }

    @RequestMapping("/show_current_atr")
    public @ResponseBody double getCurAvgATR() {
        return channelBreakPolicy.getCurAvgATR();
    }

    @RequestMapping("/show_avg_trade_amount")
    public @ResponseBody double getAvgTradeAmount() {
        return channelBreakPolicy.getAvgTradeAmount();
    }

    @RequestMapping("/show_highest_price")
    public @ResponseBody double getHighestPrice() {
        return channelBreakPolicy.getHighestPrice();
    }

    @RequestMapping("/show_lowest_price")
    public @ResponseBody double getLowestPrice() {
        return channelBreakPolicy.getLowestPrice();
    }

    @RequestMapping("/show_lastest_trade_quote")
    public @ResponseBody FutureQuote getLastTradeQuote() {
        return channelBreakPolicy.getLastTradeQuote();
    }
    
    @RequestMapping(value="/calc_stop_loss_price/{symbol}/{direction}",method=RequestMethod.GET)
    public @ResponseBody Map<String, Double> calcStopLossPrice(@PathVariable String symbol, @PathVariable String direction){
    	
    	Map<String, Double> m = new HashMap<String,Double>();
    	if(direction == null){
    		return m;
    	}else{
    		String d = direction.toLowerCase().substring(0, 1);
    	
	    	if("s".equals(d)){
	    		double price1 = channelBreakPolicy.getStopLossPriceCacheForShortSell().get(symbol);
	    		double price2 = channelBreakPolicy.getClosingPrice() + config.getTimeAtrForClosePrice()*channelBreakPolicy.getCurAvgATR();
	            m.put("lowest", channelBreakPolicy.getLowestPrice());
	            m.put("highest", channelBreakPolicy.getHighestPrice());
	            m.put("closing", channelBreakPolicy.getClosingPrice());
	            m.put("stopLoss", Math.min(price1,price2));
	            return m;
	    	}else if("l".equals(d)){
	    		//模拟：计算止损线
	    		double price1 = channelBreakPolicy.getStopLossPriceCacheForBuyLong().get(symbol);
	            double price2 = channelBreakPolicy.getClosingPrice() - config.getTimeAtrForClosePrice()*channelBreakPolicy.getCurAvgATR();
	            m.put("lowest", channelBreakPolicy.getLowestPrice());
	            m.put("highest", channelBreakPolicy.getHighestPrice());
	            m.put("closing", channelBreakPolicy.getClosingPrice());
	            m.put("stopLoss", Math.max(price1,price2));
	            return m;
	    	}
    	}
    	return m;
    }

}

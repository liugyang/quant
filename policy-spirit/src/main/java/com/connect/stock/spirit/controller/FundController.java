package com.connect.stock.spirit.controller;

import com.connect.stock.spirit.component.FutureAccount;
import com.connect.stock.spirit.model.future.FutureQuote;
import com.connect.stock.spirit.task.ChannelBreakPolicy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;

@RestController
public class FundController {

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

}

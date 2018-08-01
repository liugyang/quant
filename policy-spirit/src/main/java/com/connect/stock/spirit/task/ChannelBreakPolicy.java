package com.connect.stock.spirit.task;

import com.connect.stock.spirit.Config;
import com.connect.stock.spirit.component.FutureAccount;
import com.connect.stock.spirit.dao.DAO;
import com.connect.stock.spirit.event.SendMailEvent;
import com.connect.stock.spirit.model.Share;
import com.connect.stock.spirit.model.future.FutureQuote;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;

@ComponentScan
@Component
public class ChannelBreakPolicy {
    private static final Logger logger = LoggerFactory.getLogger(ChannelBreakPolicy.class);
    public static final long DEFAULT_INTERVAL = 3000L;
    private DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
    private DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");

    private ArrayBlockingQueue<FutureQuote> futureQuoteCache;

    private ArrayBlockingQueue<FutureQuote> futureQuoteCacheForATR;

    private Map<String, Double> stopLossPriceCacheForBuyLong = new LinkedHashMap<String, Double>();
    private Map<String, Double> stopLossPriceCacheForShortSell = new LinkedHashMap<String, Double>();

    @Autowired
    @Qualifier("config")
    private Config config;

    @Autowired
    @Qualifier("futureAccount")
    private FutureAccount futureAccount;

    @Autowired
    @Qualifier("DAOforMySQL")
    private DAO dao;
    private Date lastDate = null;

    /**计算ATR值所需要的行情信息*/
    private ArrayBlockingQueue<Double> cacheforATR;
    /**当前平均ATR*/
    private double curAvgATR;

    @Resource
    private ApplicationContext applicationContext;

    /**平均交易量*/
    private double avgTradeAmount = 0.0D;
    /**今日最高价格*/
    private double highestPrice = 0.0D;
    /**今日最低价格*/
    private double lowestPrice = 9999999.9000000004D;

    /**上次交易的行情*/
    private FutureQuote lastTradeQuote;

    public ArrayBlockingQueue<FutureQuote> getFutureQuoteCache() {
        return futureQuoteCache;
    }

    public void setFutureQuoteCache(ArrayBlockingQueue<FutureQuote> futureQuoteCache) {
        this.futureQuoteCache = futureQuoteCache;
    }

    public ArrayBlockingQueue<FutureQuote> getFutureQuoteCacheForATR() {
        return futureQuoteCacheForATR;
    }

    public void setFutureQuoteCacheForATR(ArrayBlockingQueue<FutureQuote> futureQuoteCacheForATR) {
        this.futureQuoteCacheForATR = futureQuoteCacheForATR;
    }

    public Map<String, Double> getStopLossPriceCacheForBuyLong() {
        return stopLossPriceCacheForBuyLong;
    }

    public void setStopLossPriceCacheForBuyLong(Map<String, Double> stopLossPriceCacheForBuyLong) {
        this.stopLossPriceCacheForBuyLong = stopLossPriceCacheForBuyLong;
    }

    public Map<String, Double> getStopLossPriceCacheForShortSell() {
        return stopLossPriceCacheForShortSell;
    }

    public void setStopLossPriceCacheForShortSell(Map<String, Double> stopLossPriceCacheForShortSell) {
        this.stopLossPriceCacheForShortSell = stopLossPriceCacheForShortSell;
    }

    public Date getLastDate() {
        return lastDate;
    }

    public void setLastDate(Date lastDate) {
        this.lastDate = lastDate;
    }

    public ArrayBlockingQueue<Double> getCacheforATR() {
        return cacheforATR;
    }

    public void setCacheforATR(ArrayBlockingQueue<Double> cacheforATR) {
        this.cacheforATR = cacheforATR;
    }

    public double getCurAvgATR() {
        return curAvgATR;
    }

    public void setCurAvgATR(double curAvgATR) {
        this.curAvgATR = curAvgATR;
    }

    public double getAvgTradeAmount() {
        return avgTradeAmount;
    }

    public void setAvgTradeAmount(double avgTradeAmount) {
        this.avgTradeAmount = avgTradeAmount;
    }

    public double getHighestPrice() {
        return highestPrice;
    }

    public void setHighestPrice(double highestPrice) {
        this.highestPrice = highestPrice;
    }

    public double getLowestPrice() {
        return lowestPrice;
    }

    public void setLowestPrice(double lowestPrice) {
        this.lowestPrice = lowestPrice;
    }

    public FutureQuote getLastTradeQuote() {
        return lastTradeQuote;
    }

    public void setLastTradeQuote(FutureQuote lastTradeQuote) {
        this.lastTradeQuote = lastTradeQuote;
    }

    @Scheduled(cron = "0 0 8 * * ?")
    public void initEvalData() throws Exception {
        logger.info("Initializing evaluation data");

        this.futureQuoteCache = new ArrayBlockingQueue(this.config.getMacdDays());
        if (this.lastDate == null) {
            this.lastDate = this.dateFormat.parse(this.dateFormat.format(new Date()));

            List list = this.dao.getClosedFutureQuoteByDays(this.config.getEvalFutureId(), this.config.getMacdDays());
            this.futureQuoteCache.addAll(list);
        }

        if (this.futureQuoteCache.size() < this.config.getMacdDays()) {
            Date nowDate = this.dateFormat.parse(this.dateFormat.format(new Date()));
            if (nowDate.after(this.lastDate)) {
                List<FutureQuote> list = this.dao.getClosedFutureQuoteByDate(this.config.getEvalFutureId(), this.lastDate, nowDate, 0, 100);
                for (FutureQuote fq : list) {
                    this.futureQuoteCache.put(fq);
                }
            }
            return;
        }
        Date nowDate = this.dateFormat.parse(this.dateFormat.format(new Date()));
        if (nowDate.after(this.lastDate)) {
            List<FutureQuote> list = this.dao.getClosedFutureQuoteByDate(this.config.getEvalFutureId(), this.lastDate, nowDate, 0, 100);
            for (FutureQuote fq : list) {
                this.futureQuoteCache.poll();
                this.futureQuoteCache.put(fq);
            }
        }

        this.highestPrice = 0.0D;
        this.lowestPrice = 9999999.9000000004D;
        avgTradeAmount = 0.0D;
        for (FutureQuote fq : this.futureQuoteCache) {
            if (fq.getClosingPrice() > this.highestPrice) {
                this.highestPrice = fq.getClosingPrice();
            }
            if (fq.getClosingPrice() < this.lowestPrice)
                this.lowestPrice = fq.getClosingPrice();

            avgTradeAmount += fq.getNumberOfTraded();
        }
        avgTradeAmount = avgTradeAmount/this.futureQuoteCache.size();

        logger.info("[Avg Trade Amount]:"+avgTradeAmount);
    }

    @Scheduled(cron = "0 0 8 * * ?")
    public void initATRData() throws Exception {
        logger.info("Initializing ATR data");

        this.futureQuoteCacheForATR = new ArrayBlockingQueue(this.config.getDaysForAtr());
        if (this.lastDate == null) {
            this.lastDate = this.dateFormat.parse(this.dateFormat.format(new Date()));

            List list = this.dao.getClosedFutureQuoteByDays(this.config.getEvalFutureId(), this.config.getDaysForAtr());
            this.futureQuoteCacheForATR.addAll(list);
        }

        if (this.futureQuoteCacheForATR.size() < this.config.getDaysForAtr()) {
            Date nowDate = this.dateFormat.parse(this.dateFormat.format(new Date()));
            if (nowDate.after(this.lastDate)) {
                List<FutureQuote> list = this.dao.getClosedFutureQuoteByDate(this.config.getEvalFutureId(), this.lastDate, nowDate, 0, 100);
                for (FutureQuote fq : list) {
                    this.futureQuoteCacheForATR.put(fq);
                }
            }
            return;
        }
        Date nowDate = this.dateFormat.parse(this.dateFormat.format(new Date()));
        if (nowDate.after(this.lastDate)) {
            List<FutureQuote> list = this.dao.getClosedFutureQuoteByDate(this.config.getEvalFutureId(), this.lastDate, nowDate, 0, 100);
            for (FutureQuote fq : list) {
                this.futureQuoteCacheForATR.poll();
                this.futureQuoteCacheForATR.put(fq);
            }

        }

        cacheforATR = new ArrayBlockingQueue<Double>(config.getDaysForAtr());

        FutureQuote lastQuote = null;
        double sumAtr = 0.0D;
        for(FutureQuote fq:futureQuoteCacheForATR){
            double atr = this.calcAvgAtr(lastQuote,fq);
            cacheforATR.add(atr);
            sumAtr = sumAtr + atr;
        }
        curAvgATR = sumAtr / config.getDaysForAtr();

        logger.info("[Current Average ATR]:"+curAvgATR);
    }

    @Scheduled(fixedRate = 5000L)
    public void watching() throws SQLException {
        logger.info("Evaluating the time when open the transaction.");

        //判断是否已经进行了MACD数据初始化，如果未进行初始化则从数据库中获取历史行情
        if (this.futureQuoteCache == null) {
            try {
                initEvalData();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        //判断是否已经进行了ATR数据初始化，如果未进行初始化则从数据库中获取历史行情
        if (this.futureQuoteCacheForATR == null) {
            try {
                initATRData();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        //如果MACD数据不足则不进行任何处理
        if (this.futureQuoteCache.size() != this.config.getMacdDays()) {
            return;
        }

        //从数据库中获取当前行情，然后利用MACD数据判断是否具备建仓条件。
        //目前的开仓条件为当前价格超过当日MACD时，则进行建仓
        boolean isShortSelling = false;
        List list = this.dao.getFutureQuoteByFutureId(this.config.getEvalFutureId(), 0, 1);
        if (list.size() > 0) {
            FutureQuote fq = (FutureQuote) list.get(0);
            if (this.highestPrice < fq.getCurrentPrice()) {
                logger.info("Discovered upward break point.");

                double moreRate = (fq.getNumberOfTraded()-avgTradeAmount)/avgTradeAmount;
                if(moreRate > config.getDiffAvgTradeAmountRate()){
                    logger.info("Send signal for building buying long.");
                    //发出购买建仓信号
                    applicationContext.publishEvent(new SendMailEvent(this, this.config.getMailConfig().getEmailFrom(), this.config.getMailConfig().getWatchers(), "向上突破", fq.getID() + "突破" + this.config.getMacdDays() + "天最大值"));
                    this.highestPrice *= 1.0D+config.getDiffPriceForNextAlerm();

                    //模拟：建仓
                    boolean result = futureAccount.buy(fq,1, false, config.getRateForTrade(),config.getRevenceStamp(),config.getSecurityDepositRate());
                    if(!result)
                        return;

                    isShortSelling = false;

                    //模拟：计算止损线
                    double price1 = fq.getHighestPrice() - config.getTimeAtrForHighestPrice()*curAvgATR;
                    double price2 = fq.getClosingPrice() - config.getTimeAtrForClosePrice()*curAvgATR;
                    stopLossPriceCacheForBuyLong.put(fq.getID(),Math.max(price1,price2));
                }
            }

            if (this.lowestPrice > fq.getCurrentPrice()) {
                logger.info("Discovered downward break point.");

                double moreRate = (fq.getNumberOfTraded()-avgTradeAmount)/avgTradeAmount;
                if(moreRate > config.getDiffAvgTradeAmountRate()) {
                    logger.info("Send signal for building sell short.");
                    //发出购买建仓信号
                    applicationContext.publishEvent(new SendMailEvent(this,this.config.getMailConfig().getEmailFrom(), this.config.getMailConfig().getWatchers(), "向下突破", fq.getID() + "突破" + this.config.getMacdDays() + "天最小值"));
                    this.lowestPrice *= 1.0D-config.getDiffPriceForNextAlerm();

                    //模拟：建仓
                    boolean result = futureAccount.buy(fq,1, true, config.getRateForTrade(),config.getRevenceStamp(), config.getSecurityDepositRate());
                    if(!result)
                        return;

                    isShortSelling = true;

                    //模拟：计算止损线
                    double price1 = fq.getLowestPrice() + config.getTimeAtrForLowestPrice()*curAvgATR;
                    double price2 = fq.getClosingPrice() + config.getTimeAtrForClosePrice()*curAvgATR;
                    stopLossPriceCacheForShortSell.put(fq.getID(),Math.min(price1,price2));
                }
            }

            //模拟：判断是否当前价格突破止损线，如果突破则卖出
            Share share = futureAccount.getShare(fq.getID(),isShortSelling);
            if(share != null){
                if(!isShortSelling) {
                    double stopLossPrice = stopLossPriceCacheForBuyLong.get(share.getId());
                    if (!isShortSelling && (stopLossPrice > fq.getCurrentPrice())) {
                        logger.info("Discorver stopping losing signal");
                        //发出止损信号
                        applicationContext.publishEvent(new SendMailEvent(this, this.config.getMailConfig().getEmailFrom(), this.config.getMailConfig().getWatchers(), "止损", "ID:" + fq.getID()));
                        //模拟建仓
                        boolean result = futureAccount.sell(fq, share.getAmount(), isShortSelling, config.getRateForTrade(), config.getRevenceStamp(), config.getSecurityDepositRate());
                        if (!result)
                            logger.error("Failure in selling share: id="+fq.getID() + " isShortSelling:" + isShortSelling);

                        stopLossPriceCacheForBuyLong.remove(share.getId());
                    }
                }else {
                    double stopLossPrice = stopLossPriceCacheForShortSell.get(share.getId());

                    if (isShortSelling && (stopLossPrice < fq.getCurrentPrice())) {
                        logger.info("Discorver stopping losing signal");
                        //发出止损信号
                        applicationContext.publishEvent(new SendMailEvent(this, this.config.getMailConfig().getEmailFrom(), this.config.getMailConfig().getWatchers(), "止损", "ID:" + fq.getID()));
                        //模拟建仓
                        boolean result = futureAccount.sell(fq, share.getAmount(), isShortSelling, config.getRateForTrade(), config.getRevenceStamp(), config.getSecurityDepositRate());
                        if (!result)
                            logger.error("Failure in selling share: id="+fq.getID() + " isShortSelling:" + isShortSelling);

                        stopLossPriceCacheForShortSell.remove(share.getId());
                    }
                }
            }
        }

    }

    /**
     * 计算当前ATR值
     * @param lastQuote
     * @param fq
     * @return
     */ 
    private double calcAvgAtr(FutureQuote lastQuote, FutureQuote fq){
        double lastDayHighestDiff = 0.0;
        double todayHighestDiff = 0.0;
        double todayLowestDiff = 0.0;

        if(lastQuote == null){
            lastQuote = fq;
            lastDayHighestDiff = Math.abs(lastQuote.getHighestPrice()-lastQuote.getLowestPrice());
        }

        todayHighestDiff = Math.abs(lastQuote.getClosingPrice() - fq.getHighestPrice());
        todayLowestDiff = Math.abs(lastQuote.getClosingPrice() - fq.getLowestPrice());

        double atr = Math.max(lastDayHighestDiff,Math.max(todayHighestDiff,todayLowestDiff));
        return atr;
    }
}
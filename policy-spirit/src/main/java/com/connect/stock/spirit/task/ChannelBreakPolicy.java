package com.connect.stock.spirit.task;

import com.connect.stock.spirit.Config;
import com.connect.stock.spirit.dao.DAO;
import com.connect.stock.spirit.event.SendMailEvent;
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
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

@ComponentScan
@Component
public class ChannelBreakPolicy {
    private static final Logger logger = LoggerFactory.getLogger(ChannelBreakPolicy.class);
    public static final long DEFAULT_INTERVAL = 3000L;
    private DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
    private DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");

    private ArrayBlockingQueue<FutureQuote> futureQuoteCache;

    private ArrayBlockingQueue<FutureQuote> cacheForATR;

    @Autowired
    @Qualifier("config")
    private Config config;

    @Autowired
    @Qualifier("DAOforMySQL")
    private DAO dao;
    private Date lastDate = null;

    @Resource
    private ApplicationContext applicationContext;

    /**average trade amount*/
    private double avgTradeAmount = 0.0D;
    private double highestPrice = 0.0D;
    private double lowestPrice = 9999999.9000000004D;

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
    }

    @Scheduled(cron = "0 0 8 * * ?")
    public void initATRData() throws Exception {
        logger.info("Initializing ATR data");

        this.cacheForATR = new ArrayBlockingQueue(this.config.getDaysForAtr());
        if (this.lastDate == null) {
            this.lastDate = this.dateFormat.parse(this.dateFormat.format(new Date()));

            List list = this.dao.getClosedFutureQuoteByDays(this.config.getEvalFutureId(), this.config.getDaysForAtr());
            this.cacheForATR.addAll(list);
        }

        if (this.cacheForATR.size() < this.config.getDaysForAtr()) {
            Date nowDate = this.dateFormat.parse(this.dateFormat.format(new Date()));
            if (nowDate.after(this.lastDate)) {
                List<FutureQuote> list = this.dao.getClosedFutureQuoteByDate(this.config.getEvalFutureId(), this.lastDate, nowDate, 0, 100);
                for (FutureQuote fq : list) {
                    this.cacheForATR.put(fq);
                }
            }
            return;
        }
        Date nowDate = this.dateFormat.parse(this.dateFormat.format(new Date()));
        if (nowDate.after(this.lastDate)) {
            List<FutureQuote> list = this.dao.getClosedFutureQuoteByDate(this.config.getEvalFutureId(), this.lastDate, nowDate, 0, 100);
            for (FutureQuote fq : list) {
                this.cacheForATR.poll();
                this.cacheForATR.put(fq);
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
    }

    @Scheduled(fixedRate = 5000L)
    public void evalFutureOpenTransTime() throws SQLException {
        logger.info("Evaluating the time when open the transaction.");

        if (this.futureQuoteCache == null) {
            try {
                initEvalData();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (this.futureQuoteCache.size() != this.config.getMacdDays()) {
            return;
        }

        List list = this.dao.getFutureQuoteByFutureId(this.config.getEvalFutureId(), 0, 1);
        if (list.size() > 0) {
            FutureQuote fq = (FutureQuote) list.get(0);
            if (this.highestPrice < fq.getCurrentPrice()) {
                logger.info("Discovered upward break point.");

                double moreRate = (fq.getNumberOfTraded()-avgTradeAmount)/avgTradeAmount;
                if(moreRate > 0.5){
                    applicationContext.publishEvent(new SendMailEvent(this, this.config.getMailConfig().getEmailFrom(), this.config.getMailConfig().getWatchers(), "向上突破", fq.getID() + "突破" + this.config.getMacdDays() + "天最大值"));
                    this.highestPrice *= 1.05D;
                }
            }

            if (this.lowestPrice > fq.getCurrentPrice()) {
                logger.info("Discovered downward break point.");

                double moreRate = (fq.getNumberOfTraded()-avgTradeAmount)/avgTradeAmount;
                if(moreRate > 0.5) {
                    applicationContext.publishEvent(new SendMailEvent(this,this.config.getMailConfig().getEmailFrom(), this.config.getMailConfig().getWatchers(), "向下突破", fq.getID() + "突破" + this.config.getMacdDays() + "天最小值"));
                    this.lowestPrice *= 0.95D;
                }
            }


        }
    }
}
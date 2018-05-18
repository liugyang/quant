package com.connect.stock.spirit.component;

import com.connect.stock.spirit.Application;
import com.connect.stock.spirit.Config;
import com.connect.stock.spirit.MailConfig;
import com.connect.stock.spirit.model.future.FutureQuote;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@ComponentScan
@Component
public class DynamicScheduledTask
{
  private static final Logger logger = LoggerFactory.getLogger(Application.class);
  public static final long DEFAULT_INTERVAL = 3000L;
  private DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
  private DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
  private ArrayBlockingQueue<FutureQuote> futureQuoteCache;

  @Autowired
  @Qualifier("config")
  private Config config;

  @Autowired
  @Qualifier("mailService")
  private MailService mailService;

  @Autowired
  @Qualifier("DAOforMySQL")
  private DAO dao;
  private Date lastDate = null;

  private double highestPrice = 0.0D;
  private double lowestPrice = 9999999.9000000004D;

  @Scheduled(cron="0 0 8 * * ?")
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
    for (FutureQuote fq : this.futureQuoteCache) {
      if (fq.getClosingPrice() > this.highestPrice) {
        this.highestPrice = fq.getClosingPrice();
      }
      if (fq.getClosingPrice() < this.lowestPrice)
        this.lowestPrice = fq.getClosingPrice();
    }
  }

  @Scheduled(fixedRate=5000L)
  public void evalFutureOpenTransTime() throws SQLException
  {
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
      FutureQuote fq = (FutureQuote)list.get(0);
      if (this.highestPrice < fq.getCurrentPrice()) {
        logger.info("Discovered upward break point.");
        try {
          this.mailService.sendMsg(this.config.getMailConfig().getEmailFrom(), this.config.getMailConfig().getWatchers(), "向上突破", fq.getID() + "突破" + this.config.getMacdDays() + "天最大值");
          logger.info("Sent email to watcher");
          this.highestPrice *= 1.05D;
        } catch (AddressException e) {
          logger.error(e.getMessage());
          e.printStackTrace();
        } catch (MessagingException e) {
          logger.error(e.getMessage());
          e.printStackTrace();
        }
      }

      if (this.lowestPrice > fq.getCurrentPrice()) {
        logger.info("Discovered downward break point.");
        try {
          this.mailService.sendMsg(this.config.getMailConfig().getEmailFrom(), this.config.getMailConfig().getWatchers(), "向下突破", fq.getID() + "突破" + this.config.getMacdDays() + "天最小值");
          logger.info("Sent email to watcher");
          this.lowestPrice *= 0.95D;
        } catch (AddressException e) {
          logger.error(e.getMessage());
          e.printStackTrace();
        } catch (MessagingException e) {
          logger.error(e.getMessage());
          e.printStackTrace();
        }
      }
    }
  }
}
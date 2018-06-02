package com.connect.stock.spirit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * 系统运行配置
 *
 * @author liugy
 */
@Configuration
@Component
@ConfigurationProperties(prefix = "config")
public class Config {
    @Autowired
    @Qualifier("mailConfig")
    private MailConfig mailConfig;

    private String openingTime;
    private String closingTime;
    private int daysForAtr;
    private int macdDays;
    private String evalFutureId;
    private double timesForAtr;

    public double getRateForTrade() {
        return rateForTrade;
    }

    public void setRateForTrade(double rateForTrade) {
        this.rateForTrade = rateForTrade;
    }

    public double getRevenceStamp() {
        return revenceStamp;
    }

    public void setRevenceStamp(double revenceStamp) {
        this.revenceStamp = revenceStamp;
    }

    private double rateForTrade;
    private double revenceStamp;
    private double securityDepositRate;

    public double getSecurityDepositRate() {
        return securityDepositRate;
    }

    public void setSecurityDepositRate(double securityDepositRate) {
        this.securityDepositRate = securityDepositRate;
    }

    public double getTimesForAtr() {
        return timesForAtr;
    }

    public void setTimesForAtr(double timesForAtr) {
        this.timesForAtr = timesForAtr;
    }

    public String getOpeningTime() {
        return openingTime;
    }

    public void setOpeningTime(String openingTime) {
        this.openingTime = openingTime;
    }

    public String getClosingTime() {
        return closingTime;
    }

    public void setClosingTime(String closingTime) {
        this.closingTime = closingTime;
    }

    public int getMacdDays() {
        return macdDays;
    }

    public void setMacdDays(int macdDays) {
        this.macdDays = macdDays;
    }

    public String getEvalFutureId() {
        return evalFutureId;
    }

    public void setEvalFutureId(String evalFutureId) {
        this.evalFutureId = evalFutureId;
    }

    public MailConfig getMailConfig() {
        return mailConfig;
    }

    public void setMailConfig(MailConfig mailConfig) {
        this.mailConfig = mailConfig;
    }

    public int getDaysForAtr() {
        return daysForAtr;
    }

    public void setDaysForAtr(int daysForAtr) {
        this.daysForAtr = daysForAtr;
    }
}

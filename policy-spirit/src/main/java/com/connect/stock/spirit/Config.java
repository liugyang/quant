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
 *
 */
@Configuration
@Component
@ConfigurationProperties(prefix = "config")
public class Config {
	
	private String openingTime;
	private String closingTime;
	
	@Autowired
	@Qualifier("mailConfig")
	private MailConfig mailConfig;
	
	private int macdDays;
	private String evalFutureId;
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

}

package com.connect.stock.spirit;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix="config.mail")
public class MailConfig {
	private String host = "smtp.163.com";
    private Integer port = 25;
    private String username = "*******@163.com";
    private String password = "*******";
    private String emailFrom = "*******@163.com";
    private String[] watchers;
	public String[] getWatchers() {
		return watchers;
	}
	public void setWatchers(String[] watchers) {
		this.watchers = watchers;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public Integer getPort() {
		return port;
	}
	public void setPort(Integer port) {
		this.port = port;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmailFrom() {
		return emailFrom;
	}
	public void setEmailFrom(String emailFrom) {
		this.emailFrom = emailFrom;
	}
	
}

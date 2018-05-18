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

	@Autowired
	@Qualifier("productConfig")
	private ProductConfig productConfig;
	
	@Autowired
	@Qualifier("futureConfig")
	private FutureConfig futureConfig;
	
	@Autowired
	@Qualifier("stockConfig")
	private StockConfig stockConfig;
	
	public ProductConfig getProductConfig() {
		return productConfig;
	}
	
	public StockConfig getStockConfig() {
		return stockConfig;
	}
	
	public FutureConfig getFutureConfig() {
		return futureConfig;
	}
}

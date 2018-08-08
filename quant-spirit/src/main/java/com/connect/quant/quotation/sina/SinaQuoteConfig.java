package com.connect.quant.quotation.sina;

import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.connect.quant.quotation.QuoteConfig;

@Configuration
@Component
@ConfigurationProperties(prefix = "config.quote.sina")
public class SinaQuoteConfig extends QuoteConfig{
	
	public final static String DEFAULT_SERVICE_URL = "http://hq.sinajs.cn/list=";
	public final static long DEFAULT_INTERVAL = 3000;

	private String serviceUrl;
	
	private String interval;
	/**合约编码以及所属市场，key:value形式*/
	private Map<String,String> vtSymbols;
	/**	时间窗口，cron表达式 */
	private String tradeTimeExpression;

	public String getTradeTimeExpression() {
		return tradeTimeExpression;
	}

	public void setTradeTimeExpression(String tradeTimeExpression) {
		this.tradeTimeExpression = tradeTimeExpression;
	}

	public String getServiceUrl() {
		if(serviceUrl == null)
			serviceUrl = DEFAULT_SERVICE_URL;
		return serviceUrl;
	}

	public void setServiceUrl(String serviceUrl) {
		this.serviceUrl = serviceUrl;
	}

	public String getInterval() {
		return interval;
	}

	public void setInterval(String interval) {
		this.interval = interval;
	}

	public Map<String,String> getVtSymbols() {
		return vtSymbols;
	}

	public void setVtSymbols(Map<String,String> vtSymbols) {
		this.vtSymbols = vtSymbols;
	}
}

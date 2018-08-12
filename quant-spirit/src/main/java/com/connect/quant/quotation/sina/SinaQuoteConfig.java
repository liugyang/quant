package com.connect.quant.quotation.sina;

import java.io.*;
import java.util.HashMap;
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
	/**关注合约清单的列表信息*/
	private String contractsListPath;
	/**	时间窗口，cron表达式 */
	private String tradeTimeExpression;
	/**关注合约的配置信息，需要通过加载contractList配置文件*/
	private Map<String, Map<String,String>> contractMap = null;

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

	public String getContractsListPath() {
		return contractsListPath;
	}

	public void setContractsListPath(String contractsListPath) {
		this.contractsListPath = contractsListPath;
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

	public Map<String, Map<String,String>> getContractList() throws FileNotFoundException {
		if(contractMap == null) {
			BufferedReader reader = null;
			String content = "";
			try{
				FileInputStream fileInputStream = new FileInputStream(this.getContractsListPath());
				InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
				reader = new BufferedReader(inputStreamReader);
				String tempString = null;
				while((tempString = reader.readLine()) != null){
					content += tempString;
				}
				reader.close();
			}catch(IOException e){
				e.printStackTrace();
			}finally{
				if(reader != null){
					try {
						reader.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}


//			contractMap =

			Map<String, Map<String,String>> map = new HashMap<String,Map<String,String>>();

		}
	}
}

package com.connect.quant.quotation.sina;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.connect.quant.quotation.QuoteConfig;

@Configuration
@Component
@ConfigurationProperties(prefix = "config.quote.sina")
public class SinaQuoteConfig extends QuoteConfig{
	
	public final static String STOCK = "stock";
	public final static String FUTURE = "future";
	public final static String PRODUCT = "product";
	
	public final static String DEFAULT_SERVICE_URL = "http://hq.sinajs.cn/list=";
	public final static String DEFAULT_CONTRACT_PATH = "ContractList.json";
	public final static int DEFAULT_INTERVAL = 3000;

	private String serviceUrl;
	
	private String interval;
	/**关注合约清单的列表信息*/
	private String contractsListPath;
	/**	时间窗口，cron表达式 */
	private String tradeTimeExpression;
	/**关注合约的配置信息，需要通过加载contractList配置文件*/
	private Map<String, Map<String,Object>> contractMap = null;

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
		if(contractsListPath == null)
			contractsListPath = DEFAULT_CONTRACT_PATH;
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

	public Map<String, Map<String,Object>> getContractList() {
		if(contractMap == null) {
			contractMap = new HashMap<String,Map<String,Object>>();

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

			JSONObject obj = (JSONObject)JSON.parse(content);
			JSONArray array = obj.getJSONArray("contracts");
			if(array != null){
				for(int i=0;i<array.size();i++){
					JSONObject o = (JSONObject)array.get(i);
					Map<String,Object> m = new HashMap<String,Object>();
					for(String key:o.keySet())
						m.put(key,o.get(key));

					contractMap.put((String)o.get("symbol"),m);
				}
			}
		}
		return contractMap;
	}
}

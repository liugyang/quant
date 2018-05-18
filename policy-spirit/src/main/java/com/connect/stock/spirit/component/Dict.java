package com.connect.stock.spirit.component;

import java.util.Map;

public class Dict {
	/**请求响应：成功*/
	public static final int RET_SUCCESS = 0;
	/**请求响应：数据不存在*/
	public static final int RET_DATA_NOT_EXIST = 1;
	
	
	/**历史行情表*/
	public static final int HISTORY_QUOTE_MAP = 0;
	/**价格变化率*/
	public static final int PRICE_CHANGE_RATE = 1;
	/**曲线斜率*/
	public static final int SLOPE = 2;
	/**换手率*/
	public static final int TURNOVER_RATE = 3;
	/**连续涨跌天数*/
	public static final int CONTINUE_CHANGE_DAYS = 4;
	/**T-1日行情波动幅度（基于拟合曲线）*/
	public static final int QUOTE_FLUCTUATE_RATE = 5;
	/**连续多日平均换手率*/
	public static final int AVERAGE_TURNOVER_RATE = 6;
	/**连续多天平均涨跌幅*/
	public static final int AVERAGE_CHANGE_PERCENTAGE = 7;
	/**交易流水*/
	public static final int MATCHING_LIST = 8;
	/**新增持仓*/
	public static final int NEW_SHARES = 9;
	
	/**执行条件:一天一次*/
	public static final int CONDITION_ONCE_A_DAY = 1000;
	/**执行条件:总是执行*/
	public static final int CONDITION_ALWAY = 1001;
	
	private static Map<String, String> map;

	public Map<String, String> getMap() {
		return map;
	}
	public void setMap(Map<String, String> map) {
		Dict.map = map;
	}
	
	public String getValue(String key){
		return map.get(key);
	}
}

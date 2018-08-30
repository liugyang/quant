package com.connect.quant;

import java.util.ArrayList;
import java.util.List;

public class Constant {
	/**方向常量*/
	public final static String DIRECTION_NONE = "none";
	public final static String DIRECTION_LONG = "long";
	public final static String DIRECTION_SHORT = "short";
	public final static String DIRECTION_UNKNOWN = "unknown";
	public final static String DIRECTION_NET = "net";
	public final static String DIRECTION_SELL = "sell";      				//IB接口
	public final static String DIRECTION_COVEREDSHORT = "covered short";    //证券期权

	/**开平常量*/
	public final static String OFFSET_NONE = "none";
	public final static String OFFSET_OPEN = "open";
	public final static String OFFSET_CLOSE = "close";
	public final static String OFFSET_CLOSETODAY = "close today";
	public final static String OFFSET_CLOSEYESTERDAY = "close yesterday";
	public final static String OFFSET_UNKNOWN = "unknown";

	public final static List<String> FINISHED_STATUS = new ArrayList<String>();
	static{
		FINISHED_STATUS.add("STATUS_ALLTRADED");
	    FINISHED_STATUS.add("STATUS_REJECTED");
	    FINISHED_STATUS.add("STATUS_CANCELLED");
	}
	
	public final static List<String> WORKING_STATUS = new ArrayList<String>();
	static{
		WORKING_STATUS.add("STATUS_UNKNOWN");
		WORKING_STATUS.add("STATUS_NOTTRADED");
		WORKING_STATUS.add("STATUS_PARTTRADED");
	}

	/**状态常量*/
	public final static String STATUS_NOTTRADED = "pending";
	public final static String STATUS_PARTTRADED = "partial filled";
	public final static String STATUS_ALLTRADED = "filled";
	public final static String STATUS_CANCELLED = "cancelled";
	public final static String STATUS_REJECTED = "rejected";
	public final static String STATUS_UNKNOWN = "unknown";

	/**合约类型常量*/
	public final static String PRODUCT_EQUITY = "equity";
	public final static String PRODUCT_FUTURES = "futures";
	public final static String PRODUCT_OPTION = "option";
	public final static String PRODUCT_INDEX = "index";
	public final static String PRODUCT_COMBINATION = "combination";
	public final static String PRODUCT_FOREX = "forex";
	public final static String PRODUCT_UNKNOWN = "unknown";
	public final static String PRODUCT_SPOT = "spot";
	public final static String PRODUCT_DEFER = "defer";
	public final static String PRODUCT_NONE = "none";

	/**价格类型常量*/
	public final static String PRICETYPE_LIMITPRICE = "limit order";
	public final static String PRICETYPE_MARKETPRICE = "market order";
	public final static String PRICETYPE_FAK = "FAK";
	public final static String PRICETYPE_FOK = "FOK";

	/**期权类型*/
	public final static String OPTION_CALL = "call";
	public final static String OPTION_PUT = "put";

	/**交易所类型*/
	public final static String EXCHANGE_SSE = "SSE";       //上交所
	public final static String EXCHANGE_SZSE = "SZSE";     //深交所
	public final static String EXCHANGE_CFFEX = "CFFEX";   //中金所
	public final static String EXCHANGE_SHFE = "SHFE";     //上期所
	public final static String EXCHANGE_CZCE = "CZCE";     //郑商所
	public final static String EXCHANGE_DCE = "DCE";       //大商所
	public final static String EXCHANGE_SGE = "SGE";       //上金所
	public final static String EXCHANGE_INE = "INE";       //国际能源交易中心
	public final static String EXCHANGE_UNKNOWN = "UNKNOWN";//未知交易所
	public final static String EXCHANGE_NONE = "";          //空交易所
	public final static String EXCHANGE_HKEX = "HKEX";      //港交所
	public final static String EXCHANGE_HKFE = "HKFE";      //香港期货交易所

	public final static String EXCHANGE_SMART = "SMART";       //IB智能路由（股票、期权）
	public final static String EXCHANGE_NYMEX = "NYMEX";       //IB 期货
	public final static String EXCHANGE_GLOBEX = "GLOBEX";     //CME电子交易平台
	public final static String EXCHANGE_IDEALPRO = "IDEALPRO"; //IB外汇ECN

	public final static String EXCHANGE_CME = "CME";           //CME交易所
	public final static String EXCHANGE_ICE = "ICE";           //ICE交易所
	public final static String EXCHANGE_LME = "LME";           //LME交易所

	public final static String EXCHANGE_OANDA = "OANDA";       //OANDA外汇做市商
	public final static String EXCHANGE_FXCM = "FXCM";         //FXCM外汇做市商

	public final static String EXCHANGE_OKCOIN = "OKCOIN";       //OKCOIN比特币交易所
	public final static String EXCHANGE_HUOBI = "HUOBI";         //火币比特币交易所
	public final static String EXCHANGE_LBANK = "LBANK";         //LBANK比特币交易所
	public final static String EXCHANGE_KORBIT = "KORBIT";	 //KORBIT韩国交易所
	public final static String EXCHANGE_ZB = "ZB";		 //比特币中国比特币交易所
	public final static String EXCHANGE_OKEX = "OKEX";		 //OKEX比特币交易所
	public final static String EXCHANGE_ZAIF = "ZAIF";	 //ZAIF日本比特币交易所
	public final static String EXCHANGE_COINCHECK = "COINCHECK"; //COINCHECK日本比特币交易所

	/**货币类型*/
	public final static String CURRENCY_USD = "USD";            //美元
	public final static String CURRENCY_CNY = "CNY";            //人民币
	public final static String CURRENCY_HKD = "HKD";            //港币
	public final static String CURRENCY_UNKNOWN = "UNKNOWN";    //未知货币
	public final static String CURRENCY_NONE = "";              //空货币

	/**数据库*/
	public final static String LOG_DB_NAME = "VnTrader_Log_Db";

	/**接口类型*/
	public final static String GATEWAYTYPE_EQUITY = "equity";                   //股票、ETF、债券
	public final static String GATEWAYTYPE_FUTURES = "futures";                 //期货、期权、贵金属
	public final static String GATEWAYTYPE_INTERNATIONAL = "international";     //外盘
	public final static String GATEWAYTYPE_BTC = "btc";                         //比特币
	public final static String GATEWAYTYPE_DATA = "data";                       //数据（非交易）
	
	/**普通模式*/
	public final static String MODE_NORMAL = "normal";
	/**上期所今昨分别平仓*/
	public final static String MODE_SHFE = "shfe";
	/**平今惩罚*/
	public final static String MODE_TDPENALTY = "tdpenalty"; 
	
	/**行情源：新浪*/
	public final static String SOURCE_SINA = "sina";
	
	//CTA引擎中涉及到的交易方向类型
	/**买开*/
	public final static String CTAORDER_BUY = "buy";
	/**卖平*/
	public final static String CTAORDER_SELL = "sell";
	/**卖开*/
	public final static String CTAORDER_SHORT = "short";
	/**买开*/
	public final static String CTAORDER_COVER = "cover";

	//本地停止单状态
	/**等待中*/
	public final static String STOPORDER_WAITING = "waiting";
	/**已撤销*/
	public final static String STOPORDER_CANCELLED = "cancelled";
	/**已触发*/
	public final static String STOPORDER_TRIGGERED = "triggered";

	//引擎类型，用于区分当前策略的运行环境
	/**回测*/
	public final static String ENGINETYPE_BACKTESTING = "backtesting";
	/**实盘*/
	public final static String ENGINETYPE_TRADING = "trading";
}

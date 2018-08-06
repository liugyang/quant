CREATE TABLE IF NOT EXISTS STOCK_QUOTE(
SNO						INT(11) NOT NULL AUTO_INCREMENT primary key,
SYMBOL					    VARCHAR(50),
NAME                   	VARCHAR(50),
OPENING_PRICE           	DOUBLE,
CLOSING_PRICE           	DOUBLE,
CURRENT_PRICE           	DOUBLE,
HIGHEST_PRICE           	DOUBLE,
LOWEST_PRICE            	DOUBLE,
COMPETITIVE_BUY_PRICE    	DOUBLE,
COMPETITIVE_SALE_PRICE   	DOUBLE,
NUMBER_OF_SHARE_TRADED    	BIGINT,
MONEY_OF_SHARE_TRADED     	DOUBLE,
AMOUNT_OF_BUY1           	BIGINT,
PRICE_OF_BUY1            	DOUBLE,
AMOUNT_OF_BUY2           	BIGINT,
PRICE_OF_BUY2            	DOUBLE,
AMOUNT_OF_BUY3           	BIGINT,
PRICE_OF_BUY3            	DOUBLE,
AMOUNT_OF_BUY4           	BIGINT,
PRICE_OF_BUY4            	DOUBLE,
AMOUNT_OF_BUY5           	BIGINT,
PRICE_OF_BUY5            	DOUBLE,
AMOUNT_OF_SALE1          	BIGINT,
PRICE_OF_SALE1           	DOUBLE,
AMOUNT_OF_SALE2          	BIGINT,
PRICE_OF_SALE2           	DOUBLE,
AMOUNT_OF_SALE3          	BIGINT,
PRICE_OF_SALE3           	DOUBLE,
AMOUNT_OF_SALE4          	BIGINT,
PRICE_OF_SALE4           	DOUBLE,
AMOUNT_OF_SALE5          	BIGINT,
PRICE_OF_SALE5           	DOUBLE,
EXCHANGE				VARCHAR(50),
DATE                   	DATE,
TIME                   	TIME
);

CREATE TABLE IF NOT EXISTS FUTURE_QUOTE(
SNO						INT(11) NOT NULL AUTO_INCREMENT primary key,
NAME                   VARCHAR(50),
OPENING_PRICE           DOUBLE,
CLOSING_PRICE           DOUBLE,
CURRENT_PRICE           DOUBLE,
HIGHEST_PRICE           DOUBLE,
LOWEST_PRICE            DOUBLE,
COMPETITIVE_BUY_PRICE    DOUBLE,
COMPETITIVE_SALE_PRICE   DOUBLE,
NUMBER_OF_HELD           BIGINT  ,
NUMBER_OF_TRADED         BIGINT  ,
AMOUNT_OF_BUY            BIGINT  ,
PRICE_OF_BUY1            DOUBLE,
PRICE_OF_BUY2            DOUBLE,
PRICE_OF_BUY3            DOUBLE,
PRICE_OF_BUY4            DOUBLE,
PRICE_OF_BUY5            DOUBLE,
AMOUNT_OF_SALE           BIGINT  ,
PRICE_OF_SALE1           DOUBLE,
PRICE_OF_SALE2           DOUBLE,
PRICE_OF_SALE3           DOUBLE,
PRICE_OF_SALE4           DOUBLE,
PRICE_OF_SALE5           DOUBLE,
DATE                   DATE  ,
TIME                   TIME  ,
SYMBOL                     VARCHAR(50),
SETTLEMENT_PRICE        DOUBLE,
LAST_SETTLEMENT_PRICE    DOUBLE,
EXCHANGE                 VARCHAR(50),
CATEGORY               VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS PRODUCT_QUOTE(
SNO						INT(11) NOT NULL AUTO_INCREMENT primary key,
NAME                   VARCHAR(50),
OPENING_PRICE           DOUBLE,
CLOSING_PRICE           DOUBLE,
CURRENT_PRICE           DOUBLE,
HIGHEST_PRICE           DOUBLE,
LOWEST_PRICE            DOUBLE,
COMPETITIVE_BUY_PRICE    DOUBLE,
COMPETITIVE_SALE_PRICE   DOUBLE,
NUMBER_OF_HELD           BIGINT  ,
NUMBER_OF_TRADED         BIGINT  ,
AMOUNT_OF_BUY            BIGINT  ,
PRICE_OF_BUY1            DOUBLE,
PRICE_OF_BUY2            DOUBLE,
PRICE_OF_BUY3            DOUBLE,
PRICE_OF_BUY4            DOUBLE,
PRICE_OF_BUY5            DOUBLE,
AMOUNT_OF_SALE           BIGINT  ,
PRICE_OF_SALE1           DOUBLE,
PRICE_OF_SALE2           DOUBLE,
PRICE_OF_SALE3           DOUBLE,
PRICE_OF_SALE4           DOUBLE,
PRICE_OF_SALE5           DOUBLE,
DATE                   DATE  ,
TIME                   TIME  ,
SYMBOL                     VARCHAR(50),
SETTLEMENT_PRICE        DOUBLE,
LAST_SETTLEMENT_PRICE   DOUBLE,
EXCHANGE                 VARCHAR(50),
CATEGORY               VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS BAR(
SNO						INT(11) NOT NULL AUTO_INCREMENT primary key,
SYMBOL					    VARCHAR(50),
EXCHANGE                  VARCHAR(50),
OPEN	           		DOUBLE,
HIGH		           	DOUBLE,
LOW			           	DOUBLE,
CLOSE					DOUBLE,
DATE                   	DATE,
TIME                   	TIME,
DATETIME				VARCHAR(100),
VOLUME					INT(11),
OPEN_INTEREST			INT(11)
);

CREATE TABLE IF NOT EXISTS ORDERS(
SNO						INT(11) NOT NULL AUTO_INCREMENT primary key,
SYMBOL					VARCHAR(50),              --  合约代码
EXCHANGE				VARCHAR(50),            --  交易所代码
VT_SYMBOL				VARCHAR(50),            --  合约在vt系统中的唯一代码，通常是 合约代码.交易所代码
ORDER_ID				VARCHAR(50),             --  订单编号
VT_ORDER_ID				VARCHAR(50),           --  订单在vt系统中的唯一编号，通常是 Gateway名.订单编号
DIRECTION				VARCHAR(50),          --  报单方向
OFFSET					VARCHAR(50),             --  报单开平仓
PRICE					DOUBLE,                --  报单价格
TOTAL_VOLUME			INT(11),            --  报单总数量
TRADED_VOLUME			INT(11),           --  报单成交数量
STATUS					VARCHAR(50),             --  报单状态
ORDER_TIME				VARCHAR(50),           --  发单时间
CANCEL_TIME				VARCHAR(50),          --  撤单时间
FRONT_ID				INT(11),                --  前置机编号
SESSION_ID				INT(11),              --  连接编号
ACCOUNT_ID				INT(11)
);

CREATE TABLE IF NOT EXISTS ACCOUNT(
SNO						INT(11) NOT NULL AUTO_INCREMENT primary key,
ACCOUNT_ID				VARCHAR(50),  --  账户代码
VT_ACCOUNT_ID			VARCHAR(50),  --  账户在vt中的唯一代码，通常是 Gateway名.账户代码
PRE_BALANCE				DOUBLE,       --  昨日账户结算净值
BALANCE					DOUBLE,       --  账户净值
AVAILABLE				DOUBLE,       --  可用资金
COMMISSION				DOUBLE,       --  今日手续费
MARGIN					DOUBLE,       --  保证金占用
CLOSE_PROFIT			DOUBLE,       --  平仓盈亏
POSITION_PROFIT			DOUBLE        --  持仓盈亏
);


CREATE TABLE IF NOT EXISTS TRADE(
SNO						INT(11) NOT NULL AUTO_INCREMENT primary key,
SYMBOL					VARCHAR(50),          --  合约代码
EXCHANGE				VARCHAR(50),          --  交易所代码
VT_SYMBOL				VARCHAR(50),          --  合约在vt系统中的唯一代码，通常是 合约代码.交易所代码
TRADE_ID				VARCHAR(50),          --  成交编号
VT_TRADE_ID				VARCHAR(50),          --  成交在vt系统中的唯一编号，通常是 Gateway名.成交编号
ORDER_ID				VARCHAR(50),          --  订单编号
VT_ORDER_ID				VARCHAR(50),          --  订单在vt系统中的唯一编号，通常是 Gateway名.订单编号
DIRECTION				VARCHAR(50),          --  成交方向
OFFSET					VARCHAR(50),          --  成交开平仓
PRICE					DOUBLE,               --  成交价格
VOLUME					INT(11),              --  成交数量
TRADE_TIME				VARCHAR(50),          --  成交时间
ACCOUNT_ID				INT(11)				
);

CREATE TABLE IF NOT EXISTS POSITIONS(
SNO				 		INT(11) NOT NULL AUTO_INCREMENT primary key,
SYMBOL			 		VARCHAR(50),          -- 合约代码
EXCHANGE		 		VARCHAR(50),          -- 交易所代码
VT_SYMBOL		 		VARCHAR(50),          -- 合约在vt系统中的唯一代码，合约代码.交易所代码
VT_POSITION_NAME 		VARCHAR(50),          -- 持仓在vt系统中的唯一代码，通常是vtSymbol.方向
NAME			 		VARCHAR(50),          -- 名称
SIZE			 		INT(11),              
LONG_POS		 		INT(11),              -- 做多持仓
LONG_YD			 		INT(11),              -- 做多昨日持仓
LONG_TD			 		INT(11),              -- 做多今日持仓
LONG_POS_FROZEN	 		INT(11),              -- 做多冻结
LONG_YD_FROZEN	 		INT(11),              -- 做多昨日冻结
LONG_TD_FROZEN	 		INT(11),              -- 做多今日冻结
LONG_PNL		 		DOUBLE,               -- 做多盈亏
LONG_PRICE		 		DOUBLE,               -- 做多均价
SHORT_POS		 		INT(11),              -- 做空持仓
SHORT_YD		 		INT(11),              -- 做空昨日持仓
SHORT_TD		 		INT(11),              -- 做空今日持仓
SHORT_POS_FROZEN 		INT(11),              -- 做空冻结
SHORT_YD_FROZEN	 		INT(11),              -- 做空昨日持仓
SHORT_TD_FROZEN	 		INT(11),              -- 做空今日持仓
SHORT_PNL		 		DOUBLE,               -- 做空盈亏
SHORT_PRICE		 		DOUBLE,               -- 做空均价
LAST_PRICE		 		DOUBLE,               -- 市价
MODE			 		VARCHAR(50),          -- 模式，包括：普通模式、上期所今昨分别平仓、平今惩罚
ACCOUNT_ID		 		INT(11)
);
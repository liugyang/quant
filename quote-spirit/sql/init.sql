CREATE TABLE IF NOT EXISTS STOCK_QUOTE(
SNO						INT(11) NOT NULL AUTO_INCREMENT primary key,
ID					    VARCHAR(50),
NAME                   	VARCHAR(50),
OPENINGPRICE           	DOUBLE,
CLOSINGPRICE           	DOUBLE,
CURRENTPRICE           	DOUBLE,
HIGHESTPRICE           	DOUBLE,
LOWESTPRICE            	DOUBLE,
COMPETITIVEBUYPRICE    	DOUBLE,
COMPETITIVESALEPRICE   	DOUBLE,
NUMBEROFSHARETRADED    	BIGINT,
MONEYOFSHARETRADED     	DOUBLE,
AMOUNTOFBUY1           	BIGINT,
PRICEOFBUY1            	DOUBLE,
AMOUNTOFBUY2           	BIGINT,
PRICEOFBUY2            	DOUBLE,
AMOUNTOFBUY3           	BIGINT,
PRICEOFBUY3            	DOUBLE,
AMOUNTOFBUY4           	BIGINT,
PRICEOFBUY4            	DOUBLE,
AMOUNTOFBUY5           	BIGINT,
PRICEOFBUY5            	DOUBLE,
AMOUNTOFSALE1          	BIGINT,
PRICEOFSALE1           	DOUBLE,
AMOUNTOFSALE2          	BIGINT,
PRICEOFSALE2           	DOUBLE,
AMOUNTOFSALE3          	BIGINT,
PRICEOFSALE3           	DOUBLE,
AMOUNTOFSALE4          	BIGINT,
PRICEOFSALE4           	DOUBLE,
AMOUNTOFSALE5          	BIGINT,
PRICEOFSALE5           	DOUBLE,
DATE                   	DATE,
TIME                   	TIME
);

CREATE TABLE IF NOT EXISTS FUTURE_QUOTE(
SNO						INT(11) NOT NULL AUTO_INCREMENT primary key,
NAME                   VARCHAR(50),
OPENINGPRICE           DOUBLE,
CLOSINGPRICE           DOUBLE,
CURRENTPRICE           DOUBLE,
HIGHESTPRICE           DOUBLE,
LOWESTPRICE            DOUBLE,
COMPETITIVEBUYPRICE    DOUBLE,
COMPETITIVESALEPRICE   DOUBLE,
NUMBEROFHELD           BIGINT  ,
NUMBEROFTRADED         BIGINT  ,
AMOUNTOFBUY            BIGINT  ,
PRICEOFBUY1            DOUBLE,
PRICEOFBUY2            DOUBLE,
PRICEOFBUY3            DOUBLE,
PRICEOFBUY4            DOUBLE,
PRICEOFBUY5            DOUBLE,
AMOUNTOFSALE           BIGINT  ,
PRICEOFSALE1           DOUBLE,
PRICEOFSALE2           DOUBLE,
PRICEOFSALE3           DOUBLE,
PRICEOFSALE4           DOUBLE,
PRICEOFSALE5           DOUBLE,
DATE                   DATE  ,
TIME                   TIME  ,
ID                     VARCHAR(50),
SETTLEMENTPRICE        DOUBLE,
LASTSETTLEMENTPRICE    DOUBLE,
MARKET                 VARCHAR(50),
CATEGORY               VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS PRODUCT_QUOTE(
SNO						INT(11) NOT NULL AUTO_INCREMENT primary key,
NAME                   VARCHAR(50),
OPENINGPRICE           DOUBLE,
CLOSINGPRICE           DOUBLE,
CURRENTPRICE           DOUBLE,
HIGHESTPRICE           DOUBLE,
LOWESTPRICE            DOUBLE,
COMPETITIVEBUYPRICE    DOUBLE,
COMPETITIVESALEPRICE   DOUBLE,
NUMBEROFHELD           BIGINT  ,
NUMBEROFTRADED         BIGINT  ,
AMOUNTOFBUY            BIGINT  ,
PRICEOFBUY1            DOUBLE,
PRICEOFBUY2            DOUBLE,
PRICEOFBUY3            DOUBLE,
PRICEOFBUY4            DOUBLE,
PRICEOFBUY5            DOUBLE,
AMOUNTOFSALE           BIGINT  ,
PRICEOFSALE1           DOUBLE,
PRICEOFSALE2           DOUBLE,
PRICEOFSALE3           DOUBLE,
PRICEOFSALE4           DOUBLE,
PRICEOFSALE5           DOUBLE,
DATE                   DATE  ,
TIME                   TIME  ,
ID                     VARCHAR(50),
SETTLEMENTPRICE        DOUBLE,
LASTSETTLEMENTPRICE    DOUBLE,
MARKET                 VARCHAR(50),
CATEGORY               VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS MATCHING(
SNO						INT(11) NOT NULL AUTO_INCREMENT primary key,
ID					    VARCHAR(50),
NAME                   	VARCHAR(50),
PRICE           		DOUBLE,
AMOUNT		           	BIGINT,
TOTALMONEY           	DOUBLE,
TYPE					VARCHAR(10),
STATUS					BIGINT,
DATE                   	DATE,
TIME                   	TIME,
NOTE					VARCHAR(100),
USERID					VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS SHARE(
SNO						INT(11) NOT NULL AUTO_INCREMENT primary key,
ID					    VARCHAR(50),
USERID					VARCHAR(50),
AMOUNT                  BIGINT,
DEALPRICE          		DOUBLE,
TOTALCOST	           	DOUBLE,
DATE                   	DATE,
TIME                   	TIME,
NOTE					VARCHAR(100)
);

CREATE TABLE IF NOT EXISTS HISTORY(
SNO						INT(11) NOT NULL AUTO_INCREMENT primary key,
ID					    VARCHAR(50) NOT NULL,
OPENPRICE				DOUBLE,
HIGHPRICE               DOUBLE,
LOWPRICE          		DOUBLE,
CLOSEPRICE	           	DOUBLE,
VOLUME                  BIGINT,
ADJCLOSEPRICE           DOUBLE,
DATE					DATE NOT NULL
);


CREATE TABLE IF NOT EXISTS TRIGGER(
SNO						INT(11) NOT NULL AUTO_INCREMENT primary key,
ID						VARCHAR(50),
NAME					VARCHAR(50),
GROUPNAME				VARCHAR(50),
CRONEXPRESSION			VARCHAR(100),
FLOWID					VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS FLOW(
SNO						INT(11) NOT NULL AUTO_INCREMENT primary key,
ID						VARCHAR(50),
USERID					VARCHAR(50),
NAME					VARCHAR(50),
GROUPNAME				VARCHAR(50),
STATE					VARCHAR(50),
TARGETOBJECT			VARCHAR(100),
EXECUTEFUNCTION			VARCHAR(50),
CONCURRENT				BOOLEAN,
ROOTNODEID				VARCHAR(50),
INIT					VARCHAR(50),
DESTROY					VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS NODE(
SNO						INT(11) NOT NULL AUTO_INCREMENT primary key,
ID						VARCHAR(50),
NAME					VARCHAR(50),
STATE					VARCHAR(50),
CONDITIONID				VARCHAR(50),
FLOWID					VARCHAR(50),
TARGETOBJECT			VARCHAR(100),
INIT					VARCHAR(50),
DESTROY					VARCHAR(50),
SCRIPT					VARCHAR(500)
);

CREATE TABLE IF NOT EXISTS RELATIVE(
SNO						INT(11) NOT NULL AUTO_INCREMENT primary key,
ID						VARCHAR(50),
NODEID					VARCHAR(50),
TYPE					INT,
RELATIVENODEID			VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS CONFIGURATION(
SNO						INT(11) NOT NULL AUTO_INCREMENT primary key,
ID						VARCHAR(50),
NODEID					VARCHAR(50),
CONFIGNAME				VARCHAR(50),
CONFIGVALUE				VARCHAR(200),
TYPE					VARCHAR(50),
REFKEYID				VARCHAR(50)
);
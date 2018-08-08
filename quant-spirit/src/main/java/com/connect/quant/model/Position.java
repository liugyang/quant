package com.connect.quant.model;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table POSITIONS
 *
 * @mbg.generated do_not_delete_during_merge Tue Aug 07 14:58:26 CST 2018
 */
public class Position {
    
	protected Integer sno;
	/** 合约代码 */
	protected String symbol;
	/** 交易所代码 */
	protected String exchange;
	/** 合约在vt系统中的唯一代码，合约代码.交易所代码 */
	protected String vtSymbol;
	/** 持仓在vt系统中的唯一代码，通常是vtSymbol.方向 */
	protected String vtPositionName;
	/** 名称 */
	protected String name;
	protected int size = 1;
	/** 做多持仓 */
	protected int longPos;
	/** 做多昨日持仓 */
	protected int longYd;
	/** 做多今日持仓 */
	protected int longTd;
	/** 做多冻结 */
	protected int longPosFrozen;
	/** 做多昨日冻结 */
	protected int longYdFrozen;
	/** 做多今日冻结 */
	protected int longTdFrozen;
	/** 做多盈亏 */
	protected double longPnl;
	/** 做多均价 */
	protected double longPrice;
	/** 做空持仓 */
	protected int shortPos;
	/** 做空昨日持仓 */
	protected int shortYd;
	/** 做空今日持仓 */
	protected int shortTd;
	/** 做空冻结 */
	protected int shortPosFrozen;
	/** 做空昨日持仓 */
	protected int shortYdFrozen;
	/** 做空今日持仓 */
	protected int shortTdFrozen;
	/** 做空盈亏 */
	protected double shortPnl;
	/** 做空均价 */
	protected double shortPrice;
	/** 市价 */
	protected double lastPrice;
	/** 模式， 包括：普通模式、上期所今昨分别平仓、平今惩罚 */
	protected String mode;
	
	protected int accountId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column POSITIONS.SNO
     *
     * @return the value of POSITIONS.SNO
     *
     * @mbg.generated Tue Aug 07 14:58:26 CST 2018
     */
    public Integer getSno() {
        return sno;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column POSITIONS.SNO
     *
     * @param sno the value for POSITIONS.SNO
     *
     * @mbg.generated Tue Aug 07 14:58:26 CST 2018
     */
    public void setSno(Integer sno) {
        this.sno = sno;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column POSITIONS.SYMBOL
     *
     * @return the value of POSITIONS.SYMBOL
     *
     * @mbg.generated Tue Aug 07 14:58:26 CST 2018
     */
    public String getSymbol() {
        return symbol;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column POSITIONS.SYMBOL
     *
     * @param symbol the value for POSITIONS.SYMBOL
     *
     * @mbg.generated Tue Aug 07 14:58:26 CST 2018
     */
    public void setSymbol(String symbol) {
        this.symbol = symbol == null ? null : symbol.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column POSITIONS.EXCHANGE
     *
     * @return the value of POSITIONS.EXCHANGE
     *
     * @mbg.generated Tue Aug 07 14:58:26 CST 2018
     */
    public String getExchange() {
        return exchange;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column POSITIONS.EXCHANGE
     *
     * @param exchange the value for POSITIONS.EXCHANGE
     *
     * @mbg.generated Tue Aug 07 14:58:26 CST 2018
     */
    public void setExchange(String exchange) {
        this.exchange = exchange == null ? null : exchange.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column POSITIONS.VT_SYMBOL
     *
     * @return the value of POSITIONS.VT_SYMBOL
     *
     * @mbg.generated Tue Aug 07 14:58:26 CST 2018
     */
    public String getVtSymbol() {
        return vtSymbol;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column POSITIONS.VT_SYMBOL
     *
     * @param vtSymbol the value for POSITIONS.VT_SYMBOL
     *
     * @mbg.generated Tue Aug 07 14:58:26 CST 2018
     */
    public void setVtSymbol(String vtSymbol) {
        this.vtSymbol = vtSymbol == null ? null : vtSymbol.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column POSITIONS.VT_POSITION_NAME
     *
     * @return the value of POSITIONS.VT_POSITION_NAME
     *
     * @mbg.generated Tue Aug 07 14:58:26 CST 2018
     */
    public String getVtPositionName() {
        return vtPositionName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column POSITIONS.VT_POSITION_NAME
     *
     * @param vtPositionName the value for POSITIONS.VT_POSITION_NAME
     *
     * @mbg.generated Tue Aug 07 14:58:26 CST 2018
     */
    public void setVtPositionName(String vtPositionName) {
        this.vtPositionName = vtPositionName == null ? null : vtPositionName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column POSITIONS.NAME
     *
     * @return the value of POSITIONS.NAME
     *
     * @mbg.generated Tue Aug 07 14:58:26 CST 2018
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column POSITIONS.NAME
     *
     * @param name the value for POSITIONS.NAME
     *
     * @mbg.generated Tue Aug 07 14:58:26 CST 2018
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column POSITIONS.SIZE
     *
     * @return the value of POSITIONS.SIZE
     *
     * @mbg.generated Tue Aug 07 14:58:26 CST 2018
     */
    public Integer getSize() {
        return size;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column POSITIONS.SIZE
     *
     * @param size the value for POSITIONS.SIZE
     *
     * @mbg.generated Tue Aug 07 14:58:26 CST 2018
     */
    public void setSize(Integer size) {
        this.size = size;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column POSITIONS.LONG_POS
     *
     * @return the value of POSITIONS.LONG_POS
     *
     * @mbg.generated Tue Aug 07 14:58:26 CST 2018
     */
    public Integer getLongPos() {
        return longPos;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column POSITIONS.LONG_POS
     *
     * @param longPos the value for POSITIONS.LONG_POS
     *
     * @mbg.generated Tue Aug 07 14:58:26 CST 2018
     */
    public void setLongPos(Integer longPos) {
        this.longPos = longPos;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column POSITIONS.LONG_YD
     *
     * @return the value of POSITIONS.LONG_YD
     *
     * @mbg.generated Tue Aug 07 14:58:26 CST 2018
     */
    public Integer getLongYd() {
        return longYd;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column POSITIONS.LONG_YD
     *
     * @param longYd the value for POSITIONS.LONG_YD
     *
     * @mbg.generated Tue Aug 07 14:58:26 CST 2018
     */
    public void setLongYd(Integer longYd) {
        this.longYd = longYd;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column POSITIONS.LONG_TD
     *
     * @return the value of POSITIONS.LONG_TD
     *
     * @mbg.generated Tue Aug 07 14:58:26 CST 2018
     */
    public Integer getLongTd() {
        return longTd;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column POSITIONS.LONG_TD
     *
     * @param longTd the value for POSITIONS.LONG_TD
     *
     * @mbg.generated Tue Aug 07 14:58:26 CST 2018
     */
    public void setLongTd(Integer longTd) {
        this.longTd = longTd;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column POSITIONS.LONG_POS_FROZEN
     *
     * @return the value of POSITIONS.LONG_POS_FROZEN
     *
     * @mbg.generated Tue Aug 07 14:58:26 CST 2018
     */
    public Integer getLongPosFrozen() {
        return longPosFrozen;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column POSITIONS.LONG_POS_FROZEN
     *
     * @param longPosFrozen the value for POSITIONS.LONG_POS_FROZEN
     *
     * @mbg.generated Tue Aug 07 14:58:26 CST 2018
     */
    public void setLongPosFrozen(Integer longPosFrozen) {
        this.longPosFrozen = longPosFrozen;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column POSITIONS.LONG_YD_FROZEN
     *
     * @return the value of POSITIONS.LONG_YD_FROZEN
     *
     * @mbg.generated Tue Aug 07 14:58:26 CST 2018
     */
    public Integer getLongYdFrozen() {
        return longYdFrozen;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column POSITIONS.LONG_YD_FROZEN
     *
     * @param longYdFrozen the value for POSITIONS.LONG_YD_FROZEN
     *
     * @mbg.generated Tue Aug 07 14:58:26 CST 2018
     */
    public void setLongYdFrozen(Integer longYdFrozen) {
        this.longYdFrozen = longYdFrozen;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column POSITIONS.LONG_TD_FROZEN
     *
     * @return the value of POSITIONS.LONG_TD_FROZEN
     *
     * @mbg.generated Tue Aug 07 14:58:26 CST 2018
     */
    public Integer getLongTdFrozen() {
        return longTdFrozen;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column POSITIONS.LONG_TD_FROZEN
     *
     * @param longTdFrozen the value for POSITIONS.LONG_TD_FROZEN
     *
     * @mbg.generated Tue Aug 07 14:58:26 CST 2018
     */
    public void setLongTdFrozen(Integer longTdFrozen) {
        this.longTdFrozen = longTdFrozen;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column POSITIONS.LONG_PNL
     *
     * @return the value of POSITIONS.LONG_PNL
     *
     * @mbg.generated Tue Aug 07 14:58:26 CST 2018
     */
    public Double getLongPnl() {
        return longPnl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column POSITIONS.LONG_PNL
     *
     * @param longPnl the value for POSITIONS.LONG_PNL
     *
     * @mbg.generated Tue Aug 07 14:58:26 CST 2018
     */
    public void setLongPnl(Double longPnl) {
        this.longPnl = longPnl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column POSITIONS.LONG_PRICE
     *
     * @return the value of POSITIONS.LONG_PRICE
     *
     * @mbg.generated Tue Aug 07 14:58:26 CST 2018
     */
    public Double getLongPrice() {
        return longPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column POSITIONS.LONG_PRICE
     *
     * @param longPrice the value for POSITIONS.LONG_PRICE
     *
     * @mbg.generated Tue Aug 07 14:58:26 CST 2018
     */
    public void setLongPrice(Double longPrice) {
        this.longPrice = longPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column POSITIONS.SHORT_POS
     *
     * @return the value of POSITIONS.SHORT_POS
     *
     * @mbg.generated Tue Aug 07 14:58:26 CST 2018
     */
    public Integer getShortPos() {
        return shortPos;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column POSITIONS.SHORT_POS
     *
     * @param shortPos the value for POSITIONS.SHORT_POS
     *
     * @mbg.generated Tue Aug 07 14:58:26 CST 2018
     */
    public void setShortPos(Integer shortPos) {
        this.shortPos = shortPos;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column POSITIONS.SHORT_YD
     *
     * @return the value of POSITIONS.SHORT_YD
     *
     * @mbg.generated Tue Aug 07 14:58:26 CST 2018
     */
    public Integer getShortYd() {
        return shortYd;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column POSITIONS.SHORT_YD
     *
     * @param shortYd the value for POSITIONS.SHORT_YD
     *
     * @mbg.generated Tue Aug 07 14:58:26 CST 2018
     */
    public void setShortYd(Integer shortYd) {
        this.shortYd = shortYd;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column POSITIONS.SHORT_TD
     *
     * @return the value of POSITIONS.SHORT_TD
     *
     * @mbg.generated Tue Aug 07 14:58:26 CST 2018
     */
    public Integer getShortTd() {
        return shortTd;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column POSITIONS.SHORT_TD
     *
     * @param shortTd the value for POSITIONS.SHORT_TD
     *
     * @mbg.generated Tue Aug 07 14:58:26 CST 2018
     */
    public void setShortTd(Integer shortTd) {
        this.shortTd = shortTd;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column POSITIONS.SHORT_POS_FROZEN
     *
     * @return the value of POSITIONS.SHORT_POS_FROZEN
     *
     * @mbg.generated Tue Aug 07 14:58:26 CST 2018
     */
    public Integer getShortPosFrozen() {
        return shortPosFrozen;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column POSITIONS.SHORT_POS_FROZEN
     *
     * @param shortPosFrozen the value for POSITIONS.SHORT_POS_FROZEN
     *
     * @mbg.generated Tue Aug 07 14:58:26 CST 2018
     */
    public void setShortPosFrozen(Integer shortPosFrozen) {
        this.shortPosFrozen = shortPosFrozen;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column POSITIONS.SHORT_YD_FROZEN
     *
     * @return the value of POSITIONS.SHORT_YD_FROZEN
     *
     * @mbg.generated Tue Aug 07 14:58:26 CST 2018
     */
    public Integer getShortYdFrozen() {
        return shortYdFrozen;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column POSITIONS.SHORT_YD_FROZEN
     *
     * @param shortYdFrozen the value for POSITIONS.SHORT_YD_FROZEN
     *
     * @mbg.generated Tue Aug 07 14:58:26 CST 2018
     */
    public void setShortYdFrozen(Integer shortYdFrozen) {
        this.shortYdFrozen = shortYdFrozen;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column POSITIONS.SHORT_TD_FROZEN
     *
     * @return the value of POSITIONS.SHORT_TD_FROZEN
     *
     * @mbg.generated Tue Aug 07 14:58:26 CST 2018
     */
    public Integer getShortTdFrozen() {
        return shortTdFrozen;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column POSITIONS.SHORT_TD_FROZEN
     *
     * @param shortTdFrozen the value for POSITIONS.SHORT_TD_FROZEN
     *
     * @mbg.generated Tue Aug 07 14:58:26 CST 2018
     */
    public void setShortTdFrozen(Integer shortTdFrozen) {
        this.shortTdFrozen = shortTdFrozen;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column POSITIONS.SHORT_PNL
     *
     * @return the value of POSITIONS.SHORT_PNL
     *
     * @mbg.generated Tue Aug 07 14:58:26 CST 2018
     */
    public Double getShortPnl() {
        return shortPnl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column POSITIONS.SHORT_PNL
     *
     * @param shortPnl the value for POSITIONS.SHORT_PNL
     *
     * @mbg.generated Tue Aug 07 14:58:26 CST 2018
     */
    public void setShortPnl(Double shortPnl) {
        this.shortPnl = shortPnl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column POSITIONS.SHORT_PRICE
     *
     * @return the value of POSITIONS.SHORT_PRICE
     *
     * @mbg.generated Tue Aug 07 14:58:26 CST 2018
     */
    public Double getShortPrice() {
        return shortPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column POSITIONS.SHORT_PRICE
     *
     * @param shortPrice the value for POSITIONS.SHORT_PRICE
     *
     * @mbg.generated Tue Aug 07 14:58:26 CST 2018
     */
    public void setShortPrice(Double shortPrice) {
        this.shortPrice = shortPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column POSITIONS.LAST_PRICE
     *
     * @return the value of POSITIONS.LAST_PRICE
     *
     * @mbg.generated Tue Aug 07 14:58:26 CST 2018
     */
    public Double getLastPrice() {
        return lastPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column POSITIONS.LAST_PRICE
     *
     * @param lastPrice the value for POSITIONS.LAST_PRICE
     *
     * @mbg.generated Tue Aug 07 14:58:26 CST 2018
     */
    public void setLastPrice(Double lastPrice) {
        this.lastPrice = lastPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column POSITIONS.MODE
     *
     * @return the value of POSITIONS.MODE
     *
     * @mbg.generated Tue Aug 07 14:58:26 CST 2018
     */
    public String getMode() {
        return mode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column POSITIONS.MODE
     *
     * @param mode the value for POSITIONS.MODE
     *
     * @mbg.generated Tue Aug 07 14:58:26 CST 2018
     */
    public void setMode(String mode) {
        this.mode = mode == null ? null : mode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column POSITIONS.ACCOUNT_ID
     *
     * @return the value of POSITIONS.ACCOUNT_ID
     *
     * @mbg.generated Tue Aug 07 14:58:26 CST 2018
     */
    public Integer getAccountId() {
        return accountId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column POSITIONS.ACCOUNT_ID
     *
     * @param accountId the value for POSITIONS.ACCOUNT_ID
     *
     * @mbg.generated Tue Aug 07 14:58:26 CST 2018
     */
    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }
}
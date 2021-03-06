package com.connect.quant.model;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table POSITION_DETAIL
 *
 * @mbg.generated do_not_delete_during_merge Thu Aug 30 13:14:54 CST 2018
 */
public class PositionsDetail {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column POSITION_DETAIL.SNO
     *
     * @mbg.generated Thu Aug 30 13:14:54 CST 2018
     */
    private int sno;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column POSITION_DETAIL.SYMBOL
     *
     * @mbg.generated Thu Aug 30 13:14:54 CST 2018
     */
    private String symbol;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column POSITION_DETAIL.EXCHANGE
     *
     * @mbg.generated Thu Aug 30 13:14:54 CST 2018
     */
    private String exchange;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column POSITION_DETAIL.VT_SYMBOL
     *
     * @mbg.generated Thu Aug 30 13:14:54 CST 2018
     */
    private String vtSymbol;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column POSITION_DETAIL.VT_POSITION_NAME
     *
     * @mbg.generated Thu Aug 30 13:14:54 CST 2018
     */
    private String vtPositionName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column POSITION_DETAIL.NAME
     *
     * @mbg.generated Thu Aug 30 13:14:54 CST 2018
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column POSITION_DETAIL.SIZE
     *
     * @mbg.generated Thu Aug 30 13:14:54 CST 2018
     */
    private int size;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column POSITION_DETAIL.LONG_POS
     *
     * @mbg.generated Thu Aug 30 13:14:54 CST 2018
     */
    private int longPos;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column POSITION_DETAIL.LONG_YD
     *
     * @mbg.generated Thu Aug 30 13:14:54 CST 2018
     */
    private int longYd;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column POSITION_DETAIL.LONG_TD
     *
     * @mbg.generated Thu Aug 30 13:14:54 CST 2018
     */
    private int longTd;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column POSITION_DETAIL.LONG_POS_FROZEN
     *
     * @mbg.generated Thu Aug 30 13:14:54 CST 2018
     */
    private int longPosFrozen;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column POSITION_DETAIL.LONG_YD_FROZEN
     *
     * @mbg.generated Thu Aug 30 13:14:54 CST 2018
     */
    private int longYdFrozen;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column POSITION_DETAIL.LONG_TD_FROZEN
     *
     * @mbg.generated Thu Aug 30 13:14:54 CST 2018
     */
    private int longTdFrozen;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column POSITION_DETAIL.LONG_PNL
     *
     * @mbg.generated Thu Aug 30 13:14:54 CST 2018
     */
    private Double longPnl;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column POSITION_DETAIL.LONG_PRICE
     *
     * @mbg.generated Thu Aug 30 13:14:54 CST 2018
     */
    private Double longPrice;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column POSITION_DETAIL.SHORT_POS
     *
     * @mbg.generated Thu Aug 30 13:14:54 CST 2018
     */
    private int shortPos;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column POSITION_DETAIL.SHORT_YD
     *
     * @mbg.generated Thu Aug 30 13:14:54 CST 2018
     */
    private int shortYd;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column POSITION_DETAIL.SHORT_TD
     *
     * @mbg.generated Thu Aug 30 13:14:54 CST 2018
     */
    private int shortTd;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column POSITION_DETAIL.SHORT_POS_FROZEN
     *
     * @mbg.generated Thu Aug 30 13:14:54 CST 2018
     */
    private int shortPosFrozen;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column POSITION_DETAIL.SHORT_YD_FROZEN
     *
     * @mbg.generated Thu Aug 30 13:14:54 CST 2018
     */
    private int shortYdFrozen;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column POSITION_DETAIL.SHORT_TD_FROZEN
     *
     * @mbg.generated Thu Aug 30 13:14:54 CST 2018
     */
    private int shortTdFrozen;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column POSITION_DETAIL.SHORT_PNL
     *
     * @mbg.generated Thu Aug 30 13:14:54 CST 2018
     */
    private Double shortPnl;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column POSITION_DETAIL.SHORT_PRICE
     *
     * @mbg.generated Thu Aug 30 13:14:54 CST 2018
     */
    private Double shortPrice;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column POSITION_DETAIL.LAST_PRICE
     *
     * @mbg.generated Thu Aug 30 13:14:54 CST 2018
     */
    private Double lastPrice;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column POSITION_DETAIL.MODE
     *
     * @mbg.generated Thu Aug 30 13:14:54 CST 2018
     */
    private String mode;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column POSITION_DETAIL.ACCOUNT_ID
     *
     * @mbg.generated Thu Aug 30 13:14:54 CST 2018
     */
    private String accountId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column POSITION_DETAIL.SNO
     *
     * @return the value of POSITION_DETAIL.SNO
     *
     * @mbg.generated Thu Aug 30 13:14:54 CST 2018
     */
    public int getSno() {
        return sno;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column POSITION_DETAIL.SNO
     *
     * @param sno the value for POSITION_DETAIL.SNO
     *
     * @mbg.generated Thu Aug 30 13:14:54 CST 2018
     */
    public void setSno(int sno) {
        this.sno = sno;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column POSITION_DETAIL.SYMBOL
     *
     * @return the value of POSITION_DETAIL.SYMBOL
     *
     * @mbg.generated Thu Aug 30 13:14:54 CST 2018
     */
    public String getSymbol() {
        return symbol;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column POSITION_DETAIL.SYMBOL
     *
     * @param symbol the value for POSITION_DETAIL.SYMBOL
     *
     * @mbg.generated Thu Aug 30 13:14:54 CST 2018
     */
    public void setSymbol(String symbol) {
        this.symbol = symbol == null ? null : symbol.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column POSITION_DETAIL.EXCHANGE
     *
     * @return the value of POSITION_DETAIL.EXCHANGE
     *
     * @mbg.generated Thu Aug 30 13:14:54 CST 2018
     */
    public String getExchange() {
        return exchange;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column POSITION_DETAIL.EXCHANGE
     *
     * @param exchange the value for POSITION_DETAIL.EXCHANGE
     *
     * @mbg.generated Thu Aug 30 13:14:54 CST 2018
     */
    public void setExchange(String exchange) {
        this.exchange = exchange == null ? null : exchange.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column POSITION_DETAIL.VT_SYMBOL
     *
     * @return the value of POSITION_DETAIL.VT_SYMBOL
     *
     * @mbg.generated Thu Aug 30 13:14:54 CST 2018
     */
    public String getVtSymbol() {
        return vtSymbol;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column POSITION_DETAIL.VT_SYMBOL
     *
     * @param vtSymbol the value for POSITION_DETAIL.VT_SYMBOL
     *
     * @mbg.generated Thu Aug 30 13:14:54 CST 2018
     */
    public void setVtSymbol(String vtSymbol) {
        this.vtSymbol = vtSymbol == null ? null : vtSymbol.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column POSITION_DETAIL.VT_POSITION_NAME
     *
     * @return the value of POSITION_DETAIL.VT_POSITION_NAME
     *
     * @mbg.generated Thu Aug 30 13:14:54 CST 2018
     */
    public String getVtPositionName() {
        return vtPositionName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column POSITION_DETAIL.VT_POSITION_NAME
     *
     * @param vtPositionName the value for POSITION_DETAIL.VT_POSITION_NAME
     *
     * @mbg.generated Thu Aug 30 13:14:54 CST 2018
     */
    public void setVtPositionName(String vtPositionName) {
        this.vtPositionName = vtPositionName == null ? null : vtPositionName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column POSITION_DETAIL.NAME
     *
     * @return the value of POSITION_DETAIL.NAME
     *
     * @mbg.generated Thu Aug 30 13:14:54 CST 2018
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column POSITION_DETAIL.NAME
     *
     * @param name the value for POSITION_DETAIL.NAME
     *
     * @mbg.generated Thu Aug 30 13:14:54 CST 2018
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column POSITION_DETAIL.SIZE
     *
     * @return the value of POSITION_DETAIL.SIZE
     *
     * @mbg.generated Thu Aug 30 13:14:54 CST 2018
     */
    public int getSize() {
        return size;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column POSITION_DETAIL.SIZE
     *
     * @param size the value for POSITION_DETAIL.SIZE
     *
     * @mbg.generated Thu Aug 30 13:14:54 CST 2018
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column POSITION_DETAIL.LONG_POS
     *
     * @return the value of POSITION_DETAIL.LONG_POS
     *
     * @mbg.generated Thu Aug 30 13:14:54 CST 2018
     */
    public int getLongPos() {
        return longPos;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column POSITION_DETAIL.LONG_POS
     *
     * @param longPos the value for POSITION_DETAIL.LONG_POS
     *
     * @mbg.generated Thu Aug 30 13:14:54 CST 2018
     */
    public void setLongPos(int longPos) {
        this.longPos = longPos;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column POSITION_DETAIL.LONG_YD
     *
     * @return the value of POSITION_DETAIL.LONG_YD
     *
     * @mbg.generated Thu Aug 30 13:14:54 CST 2018
     */
    public int getLongYd() {
        return longYd;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column POSITION_DETAIL.LONG_YD
     *
     * @param longYd the value for POSITION_DETAIL.LONG_YD
     *
     * @mbg.generated Thu Aug 30 13:14:54 CST 2018
     */
    public void setLongYd(int longYd) {
        this.longYd = longYd;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column POSITION_DETAIL.LONG_TD
     *
     * @return the value of POSITION_DETAIL.LONG_TD
     *
     * @mbg.generated Thu Aug 30 13:14:54 CST 2018
     */
    public int getLongTd() {
        return longTd;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column POSITION_DETAIL.LONG_TD
     *
     * @param longTd the value for POSITION_DETAIL.LONG_TD
     *
     * @mbg.generated Thu Aug 30 13:14:54 CST 2018
     */
    public void setLongTd(int longTd) {
        this.longTd = longTd;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column POSITION_DETAIL.LONG_POS_FROZEN
     *
     * @return the value of POSITION_DETAIL.LONG_POS_FROZEN
     *
     * @mbg.generated Thu Aug 30 13:14:54 CST 2018
     */
    public int getLongPosFrozen() {
        return longPosFrozen;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column POSITION_DETAIL.LONG_POS_FROZEN
     *
     * @param longPosFrozen the value for POSITION_DETAIL.LONG_POS_FROZEN
     *
     * @mbg.generated Thu Aug 30 13:14:54 CST 2018
     */
    public void setLongPosFrozen(int longPosFrozen) {
        this.longPosFrozen = longPosFrozen;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column POSITION_DETAIL.LONG_YD_FROZEN
     *
     * @return the value of POSITION_DETAIL.LONG_YD_FROZEN
     *
     * @mbg.generated Thu Aug 30 13:14:54 CST 2018
     */
    public int getLongYdFrozen() {
        return longYdFrozen;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column POSITION_DETAIL.LONG_YD_FROZEN
     *
     * @param longYdFrozen the value for POSITION_DETAIL.LONG_YD_FROZEN
     *
     * @mbg.generated Thu Aug 30 13:14:54 CST 2018
     */
    public void setLongYdFrozen(int longYdFrozen) {
        this.longYdFrozen = longYdFrozen;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column POSITION_DETAIL.LONG_TD_FROZEN
     *
     * @return the value of POSITION_DETAIL.LONG_TD_FROZEN
     *
     * @mbg.generated Thu Aug 30 13:14:54 CST 2018
     */
    public int getLongTdFrozen() {
        return longTdFrozen;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column POSITION_DETAIL.LONG_TD_FROZEN
     *
     * @param longTdFrozen the value for POSITION_DETAIL.LONG_TD_FROZEN
     *
     * @mbg.generated Thu Aug 30 13:14:54 CST 2018
     */
    public void setLongTdFrozen(int longTdFrozen) {
        this.longTdFrozen = longTdFrozen;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column POSITION_DETAIL.LONG_PNL
     *
     * @return the value of POSITION_DETAIL.LONG_PNL
     *
     * @mbg.generated Thu Aug 30 13:14:54 CST 2018
     */
    public Double getLongPnl() {
        return longPnl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column POSITION_DETAIL.LONG_PNL
     *
     * @param longPnl the value for POSITION_DETAIL.LONG_PNL
     *
     * @mbg.generated Thu Aug 30 13:14:54 CST 2018
     */
    public void setLongPnl(Double longPnl) {
        this.longPnl = longPnl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column POSITION_DETAIL.LONG_PRICE
     *
     * @return the value of POSITION_DETAIL.LONG_PRICE
     *
     * @mbg.generated Thu Aug 30 13:14:54 CST 2018
     */
    public Double getLongPrice() {
        return longPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column POSITION_DETAIL.LONG_PRICE
     *
     * @param longPrice the value for POSITION_DETAIL.LONG_PRICE
     *
     * @mbg.generated Thu Aug 30 13:14:54 CST 2018
     */
    public void setLongPrice(Double longPrice) {
        this.longPrice = longPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column POSITION_DETAIL.SHORT_POS
     *
     * @return the value of POSITION_DETAIL.SHORT_POS
     *
     * @mbg.generated Thu Aug 30 13:14:54 CST 2018
     */
    public int getShortPos() {
        return shortPos;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column POSITION_DETAIL.SHORT_POS
     *
     * @param shortPos the value for POSITION_DETAIL.SHORT_POS
     *
     * @mbg.generated Thu Aug 30 13:14:54 CST 2018
     */
    public void setShortPos(int shortPos) {
        this.shortPos = shortPos;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column POSITION_DETAIL.SHORT_YD
     *
     * @return the value of POSITION_DETAIL.SHORT_YD
     *
     * @mbg.generated Thu Aug 30 13:14:54 CST 2018
     */
    public int getShortYd() {
        return shortYd;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column POSITION_DETAIL.SHORT_YD
     *
     * @param shortYd the value for POSITION_DETAIL.SHORT_YD
     *
     * @mbg.generated Thu Aug 30 13:14:54 CST 2018
     */
    public void setShortYd(int shortYd) {
        this.shortYd = shortYd;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column POSITION_DETAIL.SHORT_TD
     *
     * @return the value of POSITION_DETAIL.SHORT_TD
     *
     * @mbg.generated Thu Aug 30 13:14:54 CST 2018
     */
    public int getShortTd() {
        return shortTd;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column POSITION_DETAIL.SHORT_TD
     *
     * @param shortTd the value for POSITION_DETAIL.SHORT_TD
     *
     * @mbg.generated Thu Aug 30 13:14:54 CST 2018
     */
    public void setShortTd(int shortTd) {
        this.shortTd = shortTd;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column POSITION_DETAIL.SHORT_POS_FROZEN
     *
     * @return the value of POSITION_DETAIL.SHORT_POS_FROZEN
     *
     * @mbg.generated Thu Aug 30 13:14:54 CST 2018
     */
    public int getShortPosFrozen() {
        return shortPosFrozen;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column POSITION_DETAIL.SHORT_POS_FROZEN
     *
     * @param shortPosFrozen the value for POSITION_DETAIL.SHORT_POS_FROZEN
     *
     * @mbg.generated Thu Aug 30 13:14:54 CST 2018
     */
    public void setShortPosFrozen(int shortPosFrozen) {
        this.shortPosFrozen = shortPosFrozen;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column POSITION_DETAIL.SHORT_YD_FROZEN
     *
     * @return the value of POSITION_DETAIL.SHORT_YD_FROZEN
     *
     * @mbg.generated Thu Aug 30 13:14:54 CST 2018
     */
    public int getShortYdFrozen() {
        return shortYdFrozen;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column POSITION_DETAIL.SHORT_YD_FROZEN
     *
     * @param shortYdFrozen the value for POSITION_DETAIL.SHORT_YD_FROZEN
     *
     * @mbg.generated Thu Aug 30 13:14:54 CST 2018
     */
    public void setShortYdFrozen(int shortYdFrozen) {
        this.shortYdFrozen = shortYdFrozen;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column POSITION_DETAIL.SHORT_TD_FROZEN
     *
     * @return the value of POSITION_DETAIL.SHORT_TD_FROZEN
     *
     * @mbg.generated Thu Aug 30 13:14:54 CST 2018
     */
    public int getShortTdFrozen() {
        return shortTdFrozen;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column POSITION_DETAIL.SHORT_TD_FROZEN
     *
     * @param shortTdFrozen the value for POSITION_DETAIL.SHORT_TD_FROZEN
     *
     * @mbg.generated Thu Aug 30 13:14:54 CST 2018
     */
    public void setShortTdFrozen(int shortTdFrozen) {
        this.shortTdFrozen = shortTdFrozen;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column POSITION_DETAIL.SHORT_PNL
     *
     * @return the value of POSITION_DETAIL.SHORT_PNL
     *
     * @mbg.generated Thu Aug 30 13:14:54 CST 2018
     */
    public Double getShortPnl() {
        return shortPnl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column POSITION_DETAIL.SHORT_PNL
     *
     * @param shortPnl the value for POSITION_DETAIL.SHORT_PNL
     *
     * @mbg.generated Thu Aug 30 13:14:54 CST 2018
     */
    public void setShortPnl(Double shortPnl) {
        this.shortPnl = shortPnl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column POSITION_DETAIL.SHORT_PRICE
     *
     * @return the value of POSITION_DETAIL.SHORT_PRICE
     *
     * @mbg.generated Thu Aug 30 13:14:54 CST 2018
     */
    public Double getShortPrice() {
        return shortPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column POSITION_DETAIL.SHORT_PRICE
     *
     * @param shortPrice the value for POSITION_DETAIL.SHORT_PRICE
     *
     * @mbg.generated Thu Aug 30 13:14:54 CST 2018
     */
    public void setShortPrice(Double shortPrice) {
        this.shortPrice = shortPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column POSITION_DETAIL.LAST_PRICE
     *
     * @return the value of POSITION_DETAIL.LAST_PRICE
     *
     * @mbg.generated Thu Aug 30 13:14:54 CST 2018
     */
    public Double getLastPrice() {
        return lastPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column POSITION_DETAIL.LAST_PRICE
     *
     * @param lastPrice the value for POSITION_DETAIL.LAST_PRICE
     *
     * @mbg.generated Thu Aug 30 13:14:54 CST 2018
     */
    public void setLastPrice(Double lastPrice) {
        this.lastPrice = lastPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column POSITION_DETAIL.MODE
     *
     * @return the value of POSITION_DETAIL.MODE
     *
     * @mbg.generated Thu Aug 30 13:14:54 CST 2018
     */
    public String getMode() {
        return mode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column POSITION_DETAIL.MODE
     *
     * @param mode the value for POSITION_DETAIL.MODE
     *
     * @mbg.generated Thu Aug 30 13:14:54 CST 2018
     */
    public void setMode(String mode) {
        this.mode = mode == null ? null : mode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column POSITION_DETAIL.ACCOUNT_ID
     *
     * @return the value of POSITION_DETAIL.ACCOUNT_ID
     *
     * @mbg.generated Thu Aug 30 13:14:54 CST 2018
     */
    public String getAccountId() {
        return accountId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column POSITION_DETAIL.ACCOUNT_ID
     *
     * @param accountId the value for POSITION_DETAIL.ACCOUNT_ID
     *
     * @mbg.generated Thu Aug 30 13:14:54 CST 2018
     */
    public void setAccountId(String accountId) {
        this.accountId = accountId == null ? null : accountId.trim();
    }
}
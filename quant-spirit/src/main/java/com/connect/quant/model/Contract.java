package com.connect.quant.model;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table CONTRACT
 *
 * @mbg.generated do_not_delete_during_merge Mon Aug 27 14:08:14 CST 2018
 */
public class Contract {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column CONTRACT.SNO
     *
     * @mbg.generated Mon Aug 27 14:08:14 CST 2018
     */
    private Integer sno;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column CONTRACT.SYMBOL
     *
     * @mbg.generated Mon Aug 27 14:08:14 CST 2018
     */
    private String symbol;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column CONTRACT.EXCHANGE
     *
     * @mbg.generated Mon Aug 27 14:08:14 CST 2018
     */
    private String exchange;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column CONTRACT.VT_SYMBOL
     *
     * @mbg.generated Mon Aug 27 14:08:14 CST 2018
     */
    private String vtSymbol;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column CONTRACT.NAME
     *
     * @mbg.generated Mon Aug 27 14:08:14 CST 2018
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column CONTRACT.PRODUCT_CLASS
     *
     * @mbg.generated Mon Aug 27 14:08:14 CST 2018
     */
    private String productClass;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column CONTRACT.SIZE
     *
     * @mbg.generated Mon Aug 27 14:08:14 CST 2018
     */
    private Integer size;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column CONTRACT.PRICE_TICK
     *
     * @mbg.generated Mon Aug 27 14:08:14 CST 2018
     */
    private Double priceTick;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column CONTRACT.STRIKE_PRICE
     *
     * @mbg.generated Mon Aug 27 14:08:14 CST 2018
     */
    private Double strikePrice;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column CONTRACT.UNDERLYING_SYMBOL
     *
     * @mbg.generated Mon Aug 27 14:08:14 CST 2018
     */
    private String underlyingSymbol;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column CONTRACT.OPTION_TYPE
     *
     * @mbg.generated Mon Aug 27 14:08:14 CST 2018
     */
    private String optionType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column CONTRACT.EXPIRY_DATE
     *
     * @mbg.generated Mon Aug 27 14:08:14 CST 2018
     */
    private String expiryDate;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CONTRACT.SNO
     *
     * @return the value of CONTRACT.SNO
     *
     * @mbg.generated Mon Aug 27 14:08:14 CST 2018
     */
    public Integer getSno() {
        return sno;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CONTRACT.SNO
     *
     * @param sno the value for CONTRACT.SNO
     *
     * @mbg.generated Mon Aug 27 14:08:14 CST 2018
     */
    public void setSno(Integer sno) {
        this.sno = sno;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CONTRACT.SYMBOL
     *
     * @return the value of CONTRACT.SYMBOL
     *
     * @mbg.generated Mon Aug 27 14:08:14 CST 2018
     */
    public String getSymbol() {
        return symbol;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CONTRACT.SYMBOL
     *
     * @param symbol the value for CONTRACT.SYMBOL
     *
     * @mbg.generated Mon Aug 27 14:08:14 CST 2018
     */
    public void setSymbol(String symbol) {
        this.symbol = symbol == null ? null : symbol.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CONTRACT.EXCHANGE
     *
     * @return the value of CONTRACT.EXCHANGE
     *
     * @mbg.generated Mon Aug 27 14:08:14 CST 2018
     */
    public String getExchange() {
        return exchange;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CONTRACT.EXCHANGE
     *
     * @param exchange the value for CONTRACT.EXCHANGE
     *
     * @mbg.generated Mon Aug 27 14:08:14 CST 2018
     */
    public void setExchange(String exchange) {
        this.exchange = exchange == null ? null : exchange.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CONTRACT.VT_SYMBOL
     *
     * @return the value of CONTRACT.VT_SYMBOL
     *
     * @mbg.generated Mon Aug 27 14:08:14 CST 2018
     */
    public String getVtSymbol() {
        return vtSymbol;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CONTRACT.VT_SYMBOL
     *
     * @param vtSymbol the value for CONTRACT.VT_SYMBOL
     *
     * @mbg.generated Mon Aug 27 14:08:14 CST 2018
     */
    public void setVtSymbol(String vtSymbol) {
        this.vtSymbol = vtSymbol == null ? null : vtSymbol.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CONTRACT.NAME
     *
     * @return the value of CONTRACT.NAME
     *
     * @mbg.generated Mon Aug 27 14:08:14 CST 2018
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CONTRACT.NAME
     *
     * @param name the value for CONTRACT.NAME
     *
     * @mbg.generated Mon Aug 27 14:08:14 CST 2018
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CONTRACT.PRODUCT_CLASS
     *
     * @return the value of CONTRACT.PRODUCT_CLASS
     *
     * @mbg.generated Mon Aug 27 14:08:14 CST 2018
     */
    public String getProductClass() {
        return productClass;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CONTRACT.PRODUCT_CLASS
     *
     * @param productClass the value for CONTRACT.PRODUCT_CLASS
     *
     * @mbg.generated Mon Aug 27 14:08:14 CST 2018
     */
    public void setProductClass(String productClass) {
        this.productClass = productClass == null ? null : productClass.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CONTRACT.SIZE
     *
     * @return the value of CONTRACT.SIZE
     *
     * @mbg.generated Mon Aug 27 14:08:14 CST 2018
     */
    public Integer getSize() {
        return size;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CONTRACT.SIZE
     *
     * @param size the value for CONTRACT.SIZE
     *
     * @mbg.generated Mon Aug 27 14:08:14 CST 2018
     */
    public void setSize(Integer size) {
        this.size = size;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CONTRACT.PRICE_TICK
     *
     * @return the value of CONTRACT.PRICE_TICK
     *
     * @mbg.generated Mon Aug 27 14:08:14 CST 2018
     */
    public Double getPriceTick() {
        return priceTick;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CONTRACT.PRICE_TICK
     *
     * @param priceTick the value for CONTRACT.PRICE_TICK
     *
     * @mbg.generated Mon Aug 27 14:08:14 CST 2018
     */
    public void setPriceTick(Double priceTick) {
        this.priceTick = priceTick;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CONTRACT.STRIKE_PRICE
     *
     * @return the value of CONTRACT.STRIKE_PRICE
     *
     * @mbg.generated Mon Aug 27 14:08:14 CST 2018
     */
    public Double getStrikePrice() {
        return strikePrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CONTRACT.STRIKE_PRICE
     *
     * @param strikePrice the value for CONTRACT.STRIKE_PRICE
     *
     * @mbg.generated Mon Aug 27 14:08:14 CST 2018
     */
    public void setStrikePrice(Double strikePrice) {
        this.strikePrice = strikePrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CONTRACT.UNDERLYING_SYMBOL
     *
     * @return the value of CONTRACT.UNDERLYING_SYMBOL
     *
     * @mbg.generated Mon Aug 27 14:08:14 CST 2018
     */
    public String getUnderlyingSymbol() {
        return underlyingSymbol;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CONTRACT.UNDERLYING_SYMBOL
     *
     * @param underlyingSymbol the value for CONTRACT.UNDERLYING_SYMBOL
     *
     * @mbg.generated Mon Aug 27 14:08:14 CST 2018
     */
    public void setUnderlyingSymbol(String underlyingSymbol) {
        this.underlyingSymbol = underlyingSymbol == null ? null : underlyingSymbol.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CONTRACT.OPTION_TYPE
     *
     * @return the value of CONTRACT.OPTION_TYPE
     *
     * @mbg.generated Mon Aug 27 14:08:14 CST 2018
     */
    public String getOptionType() {
        return optionType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CONTRACT.OPTION_TYPE
     *
     * @param optionType the value for CONTRACT.OPTION_TYPE
     *
     * @mbg.generated Mon Aug 27 14:08:14 CST 2018
     */
    public void setOptionType(String optionType) {
        this.optionType = optionType == null ? null : optionType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CONTRACT.EXPIRY_DATE
     *
     * @return the value of CONTRACT.EXPIRY_DATE
     *
     * @mbg.generated Mon Aug 27 14:08:14 CST 2018
     */
    public String getExpiryDate() {
        return expiryDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CONTRACT.EXPIRY_DATE
     *
     * @param expiryDate the value for CONTRACT.EXPIRY_DATE
     *
     * @mbg.generated Mon Aug 27 14:08:14 CST 2018
     */
    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate == null ? null : expiryDate.trim();
    }
}
package com.connect.quant.model;

import java.util.ArrayList;
import java.util.List;

public class PositionExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table POSITIONS
     *
     * @mbg.generated Thu Aug 30 13:02:13 CST 2018
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table POSITIONS
     *
     * @mbg.generated Thu Aug 30 13:02:13 CST 2018
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table POSITIONS
     *
     * @mbg.generated Thu Aug 30 13:02:13 CST 2018
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table POSITIONS
     *
     * @mbg.generated Thu Aug 30 13:02:13 CST 2018
     */
    public PositionExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table POSITIONS
     *
     * @mbg.generated Thu Aug 30 13:02:13 CST 2018
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table POSITIONS
     *
     * @mbg.generated Thu Aug 30 13:02:13 CST 2018
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table POSITIONS
     *
     * @mbg.generated Thu Aug 30 13:02:13 CST 2018
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table POSITIONS
     *
     * @mbg.generated Thu Aug 30 13:02:13 CST 2018
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table POSITIONS
     *
     * @mbg.generated Thu Aug 30 13:02:13 CST 2018
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table POSITIONS
     *
     * @mbg.generated Thu Aug 30 13:02:13 CST 2018
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table POSITIONS
     *
     * @mbg.generated Thu Aug 30 13:02:13 CST 2018
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table POSITIONS
     *
     * @mbg.generated Thu Aug 30 13:02:13 CST 2018
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table POSITIONS
     *
     * @mbg.generated Thu Aug 30 13:02:13 CST 2018
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table POSITIONS
     *
     * @mbg.generated Thu Aug 30 13:02:13 CST 2018
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table POSITIONS
     *
     * @mbg.generated Thu Aug 30 13:02:13 CST 2018
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andSnoIsNull() {
            addCriterion("SNO is null");
            return (Criteria) this;
        }

        public Criteria andSnoIsNotNull() {
            addCriterion("SNO is not null");
            return (Criteria) this;
        }

        public Criteria andSnoEqualTo(Integer value) {
            addCriterion("SNO =", value, "sno");
            return (Criteria) this;
        }

        public Criteria andSnoNotEqualTo(Integer value) {
            addCriterion("SNO <>", value, "sno");
            return (Criteria) this;
        }

        public Criteria andSnoGreaterThan(Integer value) {
            addCriterion("SNO >", value, "sno");
            return (Criteria) this;
        }

        public Criteria andSnoGreaterThanOrEqualTo(Integer value) {
            addCriterion("SNO >=", value, "sno");
            return (Criteria) this;
        }

        public Criteria andSnoLessThan(Integer value) {
            addCriterion("SNO <", value, "sno");
            return (Criteria) this;
        }

        public Criteria andSnoLessThanOrEqualTo(Integer value) {
            addCriterion("SNO <=", value, "sno");
            return (Criteria) this;
        }

        public Criteria andSnoIn(List<Integer> values) {
            addCriterion("SNO in", values, "sno");
            return (Criteria) this;
        }

        public Criteria andSnoNotIn(List<Integer> values) {
            addCriterion("SNO not in", values, "sno");
            return (Criteria) this;
        }

        public Criteria andSnoBetween(Integer value1, Integer value2) {
            addCriterion("SNO between", value1, value2, "sno");
            return (Criteria) this;
        }

        public Criteria andSnoNotBetween(Integer value1, Integer value2) {
            addCriterion("SNO not between", value1, value2, "sno");
            return (Criteria) this;
        }

        public Criteria andSymbolIsNull() {
            addCriterion("SYMBOL is null");
            return (Criteria) this;
        }

        public Criteria andSymbolIsNotNull() {
            addCriterion("SYMBOL is not null");
            return (Criteria) this;
        }

        public Criteria andSymbolEqualTo(String value) {
            addCriterion("SYMBOL =", value, "symbol");
            return (Criteria) this;
        }

        public Criteria andSymbolNotEqualTo(String value) {
            addCriterion("SYMBOL <>", value, "symbol");
            return (Criteria) this;
        }

        public Criteria andSymbolGreaterThan(String value) {
            addCriterion("SYMBOL >", value, "symbol");
            return (Criteria) this;
        }

        public Criteria andSymbolGreaterThanOrEqualTo(String value) {
            addCriterion("SYMBOL >=", value, "symbol");
            return (Criteria) this;
        }

        public Criteria andSymbolLessThan(String value) {
            addCriterion("SYMBOL <", value, "symbol");
            return (Criteria) this;
        }

        public Criteria andSymbolLessThanOrEqualTo(String value) {
            addCriterion("SYMBOL <=", value, "symbol");
            return (Criteria) this;
        }

        public Criteria andSymbolLike(String value) {
            addCriterion("SYMBOL like", value, "symbol");
            return (Criteria) this;
        }

        public Criteria andSymbolNotLike(String value) {
            addCriterion("SYMBOL not like", value, "symbol");
            return (Criteria) this;
        }

        public Criteria andSymbolIn(List<String> values) {
            addCriterion("SYMBOL in", values, "symbol");
            return (Criteria) this;
        }

        public Criteria andSymbolNotIn(List<String> values) {
            addCriterion("SYMBOL not in", values, "symbol");
            return (Criteria) this;
        }

        public Criteria andSymbolBetween(String value1, String value2) {
            addCriterion("SYMBOL between", value1, value2, "symbol");
            return (Criteria) this;
        }

        public Criteria andSymbolNotBetween(String value1, String value2) {
            addCriterion("SYMBOL not between", value1, value2, "symbol");
            return (Criteria) this;
        }

        public Criteria andExchangeIsNull() {
            addCriterion("EXCHANGE is null");
            return (Criteria) this;
        }

        public Criteria andExchangeIsNotNull() {
            addCriterion("EXCHANGE is not null");
            return (Criteria) this;
        }

        public Criteria andExchangeEqualTo(String value) {
            addCriterion("EXCHANGE =", value, "exchange");
            return (Criteria) this;
        }

        public Criteria andExchangeNotEqualTo(String value) {
            addCriterion("EXCHANGE <>", value, "exchange");
            return (Criteria) this;
        }

        public Criteria andExchangeGreaterThan(String value) {
            addCriterion("EXCHANGE >", value, "exchange");
            return (Criteria) this;
        }

        public Criteria andExchangeGreaterThanOrEqualTo(String value) {
            addCriterion("EXCHANGE >=", value, "exchange");
            return (Criteria) this;
        }

        public Criteria andExchangeLessThan(String value) {
            addCriterion("EXCHANGE <", value, "exchange");
            return (Criteria) this;
        }

        public Criteria andExchangeLessThanOrEqualTo(String value) {
            addCriterion("EXCHANGE <=", value, "exchange");
            return (Criteria) this;
        }

        public Criteria andExchangeLike(String value) {
            addCriterion("EXCHANGE like", value, "exchange");
            return (Criteria) this;
        }

        public Criteria andExchangeNotLike(String value) {
            addCriterion("EXCHANGE not like", value, "exchange");
            return (Criteria) this;
        }

        public Criteria andExchangeIn(List<String> values) {
            addCriterion("EXCHANGE in", values, "exchange");
            return (Criteria) this;
        }

        public Criteria andExchangeNotIn(List<String> values) {
            addCriterion("EXCHANGE not in", values, "exchange");
            return (Criteria) this;
        }

        public Criteria andExchangeBetween(String value1, String value2) {
            addCriterion("EXCHANGE between", value1, value2, "exchange");
            return (Criteria) this;
        }

        public Criteria andExchangeNotBetween(String value1, String value2) {
            addCriterion("EXCHANGE not between", value1, value2, "exchange");
            return (Criteria) this;
        }

        public Criteria andVtSymbolIsNull() {
            addCriterion("VT_SYMBOL is null");
            return (Criteria) this;
        }

        public Criteria andVtSymbolIsNotNull() {
            addCriterion("VT_SYMBOL is not null");
            return (Criteria) this;
        }

        public Criteria andVtSymbolEqualTo(String value) {
            addCriterion("VT_SYMBOL =", value, "vtSymbol");
            return (Criteria) this;
        }

        public Criteria andVtSymbolNotEqualTo(String value) {
            addCriterion("VT_SYMBOL <>", value, "vtSymbol");
            return (Criteria) this;
        }

        public Criteria andVtSymbolGreaterThan(String value) {
            addCriterion("VT_SYMBOL >", value, "vtSymbol");
            return (Criteria) this;
        }

        public Criteria andVtSymbolGreaterThanOrEqualTo(String value) {
            addCriterion("VT_SYMBOL >=", value, "vtSymbol");
            return (Criteria) this;
        }

        public Criteria andVtSymbolLessThan(String value) {
            addCriterion("VT_SYMBOL <", value, "vtSymbol");
            return (Criteria) this;
        }

        public Criteria andVtSymbolLessThanOrEqualTo(String value) {
            addCriterion("VT_SYMBOL <=", value, "vtSymbol");
            return (Criteria) this;
        }

        public Criteria andVtSymbolLike(String value) {
            addCriterion("VT_SYMBOL like", value, "vtSymbol");
            return (Criteria) this;
        }

        public Criteria andVtSymbolNotLike(String value) {
            addCriterion("VT_SYMBOL not like", value, "vtSymbol");
            return (Criteria) this;
        }

        public Criteria andVtSymbolIn(List<String> values) {
            addCriterion("VT_SYMBOL in", values, "vtSymbol");
            return (Criteria) this;
        }

        public Criteria andVtSymbolNotIn(List<String> values) {
            addCriterion("VT_SYMBOL not in", values, "vtSymbol");
            return (Criteria) this;
        }

        public Criteria andVtSymbolBetween(String value1, String value2) {
            addCriterion("VT_SYMBOL between", value1, value2, "vtSymbol");
            return (Criteria) this;
        }

        public Criteria andVtSymbolNotBetween(String value1, String value2) {
            addCriterion("VT_SYMBOL not between", value1, value2, "vtSymbol");
            return (Criteria) this;
        }

        public Criteria andDirectionIsNull() {
            addCriterion("DIRECTION is null");
            return (Criteria) this;
        }

        public Criteria andDirectionIsNotNull() {
            addCriterion("DIRECTION is not null");
            return (Criteria) this;
        }

        public Criteria andDirectionEqualTo(String value) {
            addCriterion("DIRECTION =", value, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionNotEqualTo(String value) {
            addCriterion("DIRECTION <>", value, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionGreaterThan(String value) {
            addCriterion("DIRECTION >", value, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionGreaterThanOrEqualTo(String value) {
            addCriterion("DIRECTION >=", value, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionLessThan(String value) {
            addCriterion("DIRECTION <", value, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionLessThanOrEqualTo(String value) {
            addCriterion("DIRECTION <=", value, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionLike(String value) {
            addCriterion("DIRECTION like", value, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionNotLike(String value) {
            addCriterion("DIRECTION not like", value, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionIn(List<String> values) {
            addCriterion("DIRECTION in", values, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionNotIn(List<String> values) {
            addCriterion("DIRECTION not in", values, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionBetween(String value1, String value2) {
            addCriterion("DIRECTION between", value1, value2, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionNotBetween(String value1, String value2) {
            addCriterion("DIRECTION not between", value1, value2, "direction");
            return (Criteria) this;
        }

        public Criteria andPositionsIsNull() {
            addCriterion("POSITIONS is null");
            return (Criteria) this;
        }

        public Criteria andPositionsIsNotNull() {
            addCriterion("POSITIONS is not null");
            return (Criteria) this;
        }

        public Criteria andPositionsEqualTo(Integer value) {
            addCriterion("POSITIONS =", value, "positions");
            return (Criteria) this;
        }

        public Criteria andPositionsNotEqualTo(Integer value) {
            addCriterion("POSITIONS <>", value, "positions");
            return (Criteria) this;
        }

        public Criteria andPositionsGreaterThan(Integer value) {
            addCriterion("POSITIONS >", value, "positions");
            return (Criteria) this;
        }

        public Criteria andPositionsGreaterThanOrEqualTo(Integer value) {
            addCriterion("POSITIONS >=", value, "positions");
            return (Criteria) this;
        }

        public Criteria andPositionsLessThan(Integer value) {
            addCriterion("POSITIONS <", value, "positions");
            return (Criteria) this;
        }

        public Criteria andPositionsLessThanOrEqualTo(Integer value) {
            addCriterion("POSITIONS <=", value, "positions");
            return (Criteria) this;
        }

        public Criteria andPositionsIn(List<Integer> values) {
            addCriterion("POSITIONS in", values, "positions");
            return (Criteria) this;
        }

        public Criteria andPositionsNotIn(List<Integer> values) {
            addCriterion("POSITIONS not in", values, "positions");
            return (Criteria) this;
        }

        public Criteria andPositionsBetween(Integer value1, Integer value2) {
            addCriterion("POSITIONS between", value1, value2, "positions");
            return (Criteria) this;
        }

        public Criteria andPositionsNotBetween(Integer value1, Integer value2) {
            addCriterion("POSITIONS not between", value1, value2, "positions");
            return (Criteria) this;
        }

        public Criteria andFrozenIsNull() {
            addCriterion("FROZEN is null");
            return (Criteria) this;
        }

        public Criteria andFrozenIsNotNull() {
            addCriterion("FROZEN is not null");
            return (Criteria) this;
        }

        public Criteria andFrozenEqualTo(Integer value) {
            addCriterion("FROZEN =", value, "frozen");
            return (Criteria) this;
        }

        public Criteria andFrozenNotEqualTo(Integer value) {
            addCriterion("FROZEN <>", value, "frozen");
            return (Criteria) this;
        }

        public Criteria andFrozenGreaterThan(Integer value) {
            addCriterion("FROZEN >", value, "frozen");
            return (Criteria) this;
        }

        public Criteria andFrozenGreaterThanOrEqualTo(Integer value) {
            addCriterion("FROZEN >=", value, "frozen");
            return (Criteria) this;
        }

        public Criteria andFrozenLessThan(Integer value) {
            addCriterion("FROZEN <", value, "frozen");
            return (Criteria) this;
        }

        public Criteria andFrozenLessThanOrEqualTo(Integer value) {
            addCriterion("FROZEN <=", value, "frozen");
            return (Criteria) this;
        }

        public Criteria andFrozenIn(List<Integer> values) {
            addCriterion("FROZEN in", values, "frozen");
            return (Criteria) this;
        }

        public Criteria andFrozenNotIn(List<Integer> values) {
            addCriterion("FROZEN not in", values, "frozen");
            return (Criteria) this;
        }

        public Criteria andFrozenBetween(Integer value1, Integer value2) {
            addCriterion("FROZEN between", value1, value2, "frozen");
            return (Criteria) this;
        }

        public Criteria andFrozenNotBetween(Integer value1, Integer value2) {
            addCriterion("FROZEN not between", value1, value2, "frozen");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("PRICE is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("PRICE is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(Double value) {
            addCriterion("PRICE =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(Double value) {
            addCriterion("PRICE <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(Double value) {
            addCriterion("PRICE >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(Double value) {
            addCriterion("PRICE >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(Double value) {
            addCriterion("PRICE <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(Double value) {
            addCriterion("PRICE <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<Double> values) {
            addCriterion("PRICE in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<Double> values) {
            addCriterion("PRICE not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(Double value1, Double value2) {
            addCriterion("PRICE between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(Double value1, Double value2) {
            addCriterion("PRICE not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andVtPositionNameIsNull() {
            addCriterion("VT_POSITION_NAME is null");
            return (Criteria) this;
        }

        public Criteria andVtPositionNameIsNotNull() {
            addCriterion("VT_POSITION_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andVtPositionNameEqualTo(String value) {
            addCriterion("VT_POSITION_NAME =", value, "vtPositionName");
            return (Criteria) this;
        }

        public Criteria andVtPositionNameNotEqualTo(String value) {
            addCriterion("VT_POSITION_NAME <>", value, "vtPositionName");
            return (Criteria) this;
        }

        public Criteria andVtPositionNameGreaterThan(String value) {
            addCriterion("VT_POSITION_NAME >", value, "vtPositionName");
            return (Criteria) this;
        }

        public Criteria andVtPositionNameGreaterThanOrEqualTo(String value) {
            addCriterion("VT_POSITION_NAME >=", value, "vtPositionName");
            return (Criteria) this;
        }

        public Criteria andVtPositionNameLessThan(String value) {
            addCriterion("VT_POSITION_NAME <", value, "vtPositionName");
            return (Criteria) this;
        }

        public Criteria andVtPositionNameLessThanOrEqualTo(String value) {
            addCriterion("VT_POSITION_NAME <=", value, "vtPositionName");
            return (Criteria) this;
        }

        public Criteria andVtPositionNameLike(String value) {
            addCriterion("VT_POSITION_NAME like", value, "vtPositionName");
            return (Criteria) this;
        }

        public Criteria andVtPositionNameNotLike(String value) {
            addCriterion("VT_POSITION_NAME not like", value, "vtPositionName");
            return (Criteria) this;
        }

        public Criteria andVtPositionNameIn(List<String> values) {
            addCriterion("VT_POSITION_NAME in", values, "vtPositionName");
            return (Criteria) this;
        }

        public Criteria andVtPositionNameNotIn(List<String> values) {
            addCriterion("VT_POSITION_NAME not in", values, "vtPositionName");
            return (Criteria) this;
        }

        public Criteria andVtPositionNameBetween(String value1, String value2) {
            addCriterion("VT_POSITION_NAME between", value1, value2, "vtPositionName");
            return (Criteria) this;
        }

        public Criteria andVtPositionNameNotBetween(String value1, String value2) {
            addCriterion("VT_POSITION_NAME not between", value1, value2, "vtPositionName");
            return (Criteria) this;
        }

        public Criteria andYdPositionIsNull() {
            addCriterion("YD_POSITION is null");
            return (Criteria) this;
        }

        public Criteria andYdPositionIsNotNull() {
            addCriterion("YD_POSITION is not null");
            return (Criteria) this;
        }

        public Criteria andYdPositionEqualTo(Integer value) {
            addCriterion("YD_POSITION =", value, "ydPosition");
            return (Criteria) this;
        }

        public Criteria andYdPositionNotEqualTo(Integer value) {
            addCriterion("YD_POSITION <>", value, "ydPosition");
            return (Criteria) this;
        }

        public Criteria andYdPositionGreaterThan(Integer value) {
            addCriterion("YD_POSITION >", value, "ydPosition");
            return (Criteria) this;
        }

        public Criteria andYdPositionGreaterThanOrEqualTo(Integer value) {
            addCriterion("YD_POSITION >=", value, "ydPosition");
            return (Criteria) this;
        }

        public Criteria andYdPositionLessThan(Integer value) {
            addCriterion("YD_POSITION <", value, "ydPosition");
            return (Criteria) this;
        }

        public Criteria andYdPositionLessThanOrEqualTo(Integer value) {
            addCriterion("YD_POSITION <=", value, "ydPosition");
            return (Criteria) this;
        }

        public Criteria andYdPositionIn(List<Integer> values) {
            addCriterion("YD_POSITION in", values, "ydPosition");
            return (Criteria) this;
        }

        public Criteria andYdPositionNotIn(List<Integer> values) {
            addCriterion("YD_POSITION not in", values, "ydPosition");
            return (Criteria) this;
        }

        public Criteria andYdPositionBetween(Integer value1, Integer value2) {
            addCriterion("YD_POSITION between", value1, value2, "ydPosition");
            return (Criteria) this;
        }

        public Criteria andYdPositionNotBetween(Integer value1, Integer value2) {
            addCriterion("YD_POSITION not between", value1, value2, "ydPosition");
            return (Criteria) this;
        }

        public Criteria andPositionProfitIsNull() {
            addCriterion("POSITION_PROFIT is null");
            return (Criteria) this;
        }

        public Criteria andPositionProfitIsNotNull() {
            addCriterion("POSITION_PROFIT is not null");
            return (Criteria) this;
        }

        public Criteria andPositionProfitEqualTo(Double value) {
            addCriterion("POSITION_PROFIT =", value, "positionProfit");
            return (Criteria) this;
        }

        public Criteria andPositionProfitNotEqualTo(Double value) {
            addCriterion("POSITION_PROFIT <>", value, "positionProfit");
            return (Criteria) this;
        }

        public Criteria andPositionProfitGreaterThan(Double value) {
            addCriterion("POSITION_PROFIT >", value, "positionProfit");
            return (Criteria) this;
        }

        public Criteria andPositionProfitGreaterThanOrEqualTo(Double value) {
            addCriterion("POSITION_PROFIT >=", value, "positionProfit");
            return (Criteria) this;
        }

        public Criteria andPositionProfitLessThan(Double value) {
            addCriterion("POSITION_PROFIT <", value, "positionProfit");
            return (Criteria) this;
        }

        public Criteria andPositionProfitLessThanOrEqualTo(Double value) {
            addCriterion("POSITION_PROFIT <=", value, "positionProfit");
            return (Criteria) this;
        }

        public Criteria andPositionProfitIn(List<Double> values) {
            addCriterion("POSITION_PROFIT in", values, "positionProfit");
            return (Criteria) this;
        }

        public Criteria andPositionProfitNotIn(List<Double> values) {
            addCriterion("POSITION_PROFIT not in", values, "positionProfit");
            return (Criteria) this;
        }

        public Criteria andPositionProfitBetween(Double value1, Double value2) {
            addCriterion("POSITION_PROFIT between", value1, value2, "positionProfit");
            return (Criteria) this;
        }

        public Criteria andPositionProfitNotBetween(Double value1, Double value2) {
            addCriterion("POSITION_PROFIT not between", value1, value2, "positionProfit");
            return (Criteria) this;
        }

        public Criteria andAccountIdIsNull() {
            addCriterion("ACCOUNT_ID is null");
            return (Criteria) this;
        }

        public Criteria andAccountIdIsNotNull() {
            addCriterion("ACCOUNT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andAccountIdEqualTo(String value) {
            addCriterion("ACCOUNT_ID =", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdNotEqualTo(String value) {
            addCriterion("ACCOUNT_ID <>", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdGreaterThan(String value) {
            addCriterion("ACCOUNT_ID >", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdGreaterThanOrEqualTo(String value) {
            addCriterion("ACCOUNT_ID >=", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdLessThan(String value) {
            addCriterion("ACCOUNT_ID <", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdLessThanOrEqualTo(String value) {
            addCriterion("ACCOUNT_ID <=", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdLike(String value) {
            addCriterion("ACCOUNT_ID like", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdNotLike(String value) {
            addCriterion("ACCOUNT_ID not like", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdIn(List<String> values) {
            addCriterion("ACCOUNT_ID in", values, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdNotIn(List<String> values) {
            addCriterion("ACCOUNT_ID not in", values, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdBetween(String value1, String value2) {
            addCriterion("ACCOUNT_ID between", value1, value2, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdNotBetween(String value1, String value2) {
            addCriterion("ACCOUNT_ID not between", value1, value2, "accountId");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table POSITIONS
     *
     * @mbg.generated do_not_delete_during_merge Thu Aug 30 13:02:13 CST 2018
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table POSITIONS
     *
     * @mbg.generated Thu Aug 30 13:02:13 CST 2018
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}
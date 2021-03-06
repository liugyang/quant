package com.connect.quant.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.connect.quant.model.Trade;
import com.connect.quant.model.TradeExample;

@Repository
public interface TradeMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table TRADE
	 * @mbg.generated  Fri Aug 17 14:00:14 CST 2018
	 */
	long countByExample(TradeExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table TRADE
	 * @mbg.generated  Fri Aug 17 14:00:14 CST 2018
	 */
	int deleteByExample(TradeExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table TRADE
	 * @mbg.generated  Fri Aug 17 14:00:14 CST 2018
	 */
	int deleteByPrimaryKey(Integer sno);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table TRADE
	 * @mbg.generated  Fri Aug 17 14:00:14 CST 2018
	 */
	int insert(Trade record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table TRADE
	 * @mbg.generated  Fri Aug 17 14:00:14 CST 2018
	 */
	int insertSelective(Trade record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table TRADE
	 * @mbg.generated  Fri Aug 17 14:00:14 CST 2018
	 */
	List<Trade> selectByExample(TradeExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table TRADE
	 * @mbg.generated  Fri Aug 17 14:00:14 CST 2018
	 */
	Trade selectByPrimaryKey(Integer sno);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table TRADE
	 * @mbg.generated  Fri Aug 17 14:00:14 CST 2018
	 */
	int updateByExampleSelective(@Param("record") Trade record, @Param("example") TradeExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table TRADE
	 * @mbg.generated  Fri Aug 17 14:00:14 CST 2018
	 */
	int updateByExample(@Param("record") Trade record, @Param("example") TradeExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table TRADE
	 * @mbg.generated  Fri Aug 17 14:00:14 CST 2018
	 */
	int updateByPrimaryKeySelective(Trade record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table TRADE
	 * @mbg.generated  Fri Aug 17 14:00:14 CST 2018
	 */
	int updateByPrimaryKey(Trade record);
}
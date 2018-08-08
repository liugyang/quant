package com.connect.quant.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.connect.quant.model.Order;
import com.connect.quant.model.OrderExample;

public interface OrderMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ORDERS
	 * @mbg.generated  Tue Aug 07 14:58:26 CST 2018
	 */
	long countByExample(OrderExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ORDERS
	 * @mbg.generated  Tue Aug 07 14:58:26 CST 2018
	 */
	int deleteByExample(OrderExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ORDERS
	 * @mbg.generated  Tue Aug 07 14:58:26 CST 2018
	 */
	int deleteByPrimaryKey(Integer sno);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ORDERS
	 * @mbg.generated  Tue Aug 07 14:58:26 CST 2018
	 */
	int insert(Order record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ORDERS
	 * @mbg.generated  Tue Aug 07 14:58:26 CST 2018
	 */
	int insertSelective(Order record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ORDERS
	 * @mbg.generated  Tue Aug 07 14:58:26 CST 2018
	 */
	List<Order> selectByExample(OrderExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ORDERS
	 * @mbg.generated  Tue Aug 07 14:58:26 CST 2018
	 */
	Order selectByPrimaryKey(Integer sno);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ORDERS
	 * @mbg.generated  Tue Aug 07 14:58:26 CST 2018
	 */
	int updateByExampleSelective(@Param("record") Order record, @Param("example") OrderExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ORDERS
	 * @mbg.generated  Tue Aug 07 14:58:26 CST 2018
	 */
	int updateByExample(@Param("record") Order record, @Param("example") OrderExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ORDERS
	 * @mbg.generated  Tue Aug 07 14:58:26 CST 2018
	 */
	int updateByPrimaryKeySelective(Order record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ORDERS
	 * @mbg.generated  Tue Aug 07 14:58:26 CST 2018
	 */
	int updateByPrimaryKey(Order record);
}
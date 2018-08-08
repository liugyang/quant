package com.connect.quant.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.connect.quant.model.Position;
import com.connect.quant.model.PositionExample;

public interface PositionMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table POSITIONS
	 * @mbg.generated  Tue Aug 07 14:58:26 CST 2018
	 */
	long countByExample(PositionExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table POSITIONS
	 * @mbg.generated  Tue Aug 07 14:58:26 CST 2018
	 */
	int deleteByExample(PositionExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table POSITIONS
	 * @mbg.generated  Tue Aug 07 14:58:26 CST 2018
	 */
	int deleteByPrimaryKey(Integer sno);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table POSITIONS
	 * @mbg.generated  Tue Aug 07 14:58:26 CST 2018
	 */
	int insert(Position record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table POSITIONS
	 * @mbg.generated  Tue Aug 07 14:58:26 CST 2018
	 */
	int insertSelective(Position record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table POSITIONS
	 * @mbg.generated  Tue Aug 07 14:58:26 CST 2018
	 */
	List<Position> selectByExample(PositionExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table POSITIONS
	 * @mbg.generated  Tue Aug 07 14:58:26 CST 2018
	 */
	Position selectByPrimaryKey(Integer sno);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table POSITIONS
	 * @mbg.generated  Tue Aug 07 14:58:26 CST 2018
	 */
	int updateByExampleSelective(@Param("record") Position record, @Param("example") PositionExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table POSITIONS
	 * @mbg.generated  Tue Aug 07 14:58:26 CST 2018
	 */
	int updateByExample(@Param("record") Position record, @Param("example") PositionExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table POSITIONS
	 * @mbg.generated  Tue Aug 07 14:58:26 CST 2018
	 */
	int updateByPrimaryKeySelective(Position record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table POSITIONS
	 * @mbg.generated  Tue Aug 07 14:58:26 CST 2018
	 */
	int updateByPrimaryKey(Position record);
}
package com.connect.quant.dao.mapper;

import com.connect.quant.model.PositionDetail;
import com.connect.quant.model.PositionDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PositionDetailMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table POSITION_DETAIL
     *
     * @mbg.generated Thu Aug 30 12:58:27 CST 2018
     */
    long countByExample(PositionDetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table POSITION_DETAIL
     *
     * @mbg.generated Thu Aug 30 12:58:27 CST 2018
     */
    int deleteByExample(PositionDetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table POSITION_DETAIL
     *
     * @mbg.generated Thu Aug 30 12:58:27 CST 2018
     */
    int deleteByPrimaryKey(Integer sno);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table POSITION_DETAIL
     *
     * @mbg.generated Thu Aug 30 12:58:27 CST 2018
     */
    int insert(PositionDetail record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table POSITION_DETAIL
     *
     * @mbg.generated Thu Aug 30 12:58:27 CST 2018
     */
    int insertSelective(PositionDetail record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table POSITION_DETAIL
     *
     * @mbg.generated Thu Aug 30 12:58:27 CST 2018
     */
    List<PositionDetail> selectByExample(PositionDetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table POSITION_DETAIL
     *
     * @mbg.generated Thu Aug 30 12:58:27 CST 2018
     */
    PositionDetail selectByPrimaryKey(Integer sno);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table POSITION_DETAIL
     *
     * @mbg.generated Thu Aug 30 12:58:27 CST 2018
     */
    int updateByExampleSelective(@Param("record") PositionDetail record, @Param("example") PositionDetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table POSITION_DETAIL
     *
     * @mbg.generated Thu Aug 30 12:58:27 CST 2018
     */
    int updateByExample(@Param("record") PositionDetail record, @Param("example") PositionDetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table POSITION_DETAIL
     *
     * @mbg.generated Thu Aug 30 12:58:27 CST 2018
     */
    int updateByPrimaryKeySelective(PositionDetail record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table POSITION_DETAIL
     *
     * @mbg.generated Thu Aug 30 12:58:27 CST 2018
     */
    int updateByPrimaryKey(PositionDetail record);
}
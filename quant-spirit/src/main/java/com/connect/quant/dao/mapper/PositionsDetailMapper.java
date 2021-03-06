package com.connect.quant.dao.mapper;

import com.connect.quant.model.PositionsDetail;
import com.connect.quant.model.PositionsDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PositionsDetailMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table POSITION_DETAIL
     *
     * @mbg.generated Thu Aug 30 13:14:54 CST 2018
     */
    long countByExample(PositionsDetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table POSITION_DETAIL
     *
     * @mbg.generated Thu Aug 30 13:14:54 CST 2018
     */
    int deleteByExample(PositionsDetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table POSITION_DETAIL
     *
     * @mbg.generated Thu Aug 30 13:14:54 CST 2018
     */
    int deleteByPrimaryKey(Integer sno);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table POSITION_DETAIL
     *
     * @mbg.generated Thu Aug 30 13:14:54 CST 2018
     */
    int insert(PositionsDetail record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table POSITION_DETAIL
     *
     * @mbg.generated Thu Aug 30 13:14:54 CST 2018
     */
    int insertSelective(PositionsDetail record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table POSITION_DETAIL
     *
     * @mbg.generated Thu Aug 30 13:14:54 CST 2018
     */
    List<PositionsDetail> selectByExample(PositionsDetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table POSITION_DETAIL
     *
     * @mbg.generated Thu Aug 30 13:14:54 CST 2018
     */
    PositionsDetail selectByPrimaryKey(Integer sno);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table POSITION_DETAIL
     *
     * @mbg.generated Thu Aug 30 13:14:54 CST 2018
     */
    int updateByExampleSelective(@Param("record") PositionsDetail record, @Param("example") PositionsDetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table POSITION_DETAIL
     *
     * @mbg.generated Thu Aug 30 13:14:54 CST 2018
     */
    int updateByExample(@Param("record") PositionsDetail record, @Param("example") PositionsDetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table POSITION_DETAIL
     *
     * @mbg.generated Thu Aug 30 13:14:54 CST 2018
     */
    int updateByPrimaryKeySelective(PositionsDetail record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table POSITION_DETAIL
     *
     * @mbg.generated Thu Aug 30 13:14:54 CST 2018
     */
    int updateByPrimaryKey(PositionsDetail record);
}
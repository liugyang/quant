package com.connect.quant.dao.mapper;

import com.connect.quant.model.Contract;
import com.connect.quant.model.ContractExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ContractMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CONTRACT
     *
     * @mbg.generated Mon Aug 27 14:08:14 CST 2018
     */
    long countByExample(ContractExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CONTRACT
     *
     * @mbg.generated Mon Aug 27 14:08:14 CST 2018
     */
    int deleteByExample(ContractExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CONTRACT
     *
     * @mbg.generated Mon Aug 27 14:08:14 CST 2018
     */
    int deleteByPrimaryKey(Integer sno);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CONTRACT
     *
     * @mbg.generated Mon Aug 27 14:08:14 CST 2018
     */
    int insert(Contract record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CONTRACT
     *
     * @mbg.generated Mon Aug 27 14:08:14 CST 2018
     */
    int insertSelective(Contract record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CONTRACT
     *
     * @mbg.generated Mon Aug 27 14:08:14 CST 2018
     */
    List<Contract> selectByExample(ContractExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CONTRACT
     *
     * @mbg.generated Mon Aug 27 14:08:14 CST 2018
     */
    Contract selectByPrimaryKey(Integer sno);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CONTRACT
     *
     * @mbg.generated Mon Aug 27 14:08:14 CST 2018
     */
    int updateByExampleSelective(@Param("record") Contract record, @Param("example") ContractExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CONTRACT
     *
     * @mbg.generated Mon Aug 27 14:08:14 CST 2018
     */
    int updateByExample(@Param("record") Contract record, @Param("example") ContractExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CONTRACT
     *
     * @mbg.generated Mon Aug 27 14:08:14 CST 2018
     */
    int updateByPrimaryKeySelective(Contract record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CONTRACT
     *
     * @mbg.generated Mon Aug 27 14:08:14 CST 2018
     */
    int updateByPrimaryKey(Contract record);
}
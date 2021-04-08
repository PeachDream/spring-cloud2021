package com.peach.springcloud.mapper;

import com.peach.springcloud.entity.TAccount;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

public interface TAccountMapper {

    @Update("UPDATE t_account SET used = used + #{number} ,residue = residue - #{number} where id = #{id}")
    int reduceSccount(@Param("id")Long id, @Param("number") Long number);
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_account
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_account
     *
     * @mbg.generated
     */
    int insert(TAccount record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_account
     *
     * @mbg.generated
     */
    int insertSelective(TAccount record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_account
     *
     * @mbg.generated
     */
    TAccount selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_account
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(TAccount record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_account
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(TAccount record);
}
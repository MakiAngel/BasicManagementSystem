package com.uestc.fff.information.mapper;

import com.uestc.fff.information.domain.MajorInfo;
import com.uestc.fff.information.domain.MajorInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MajorInfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table major
     *
     * @mbg.generated Sat Sep 05 21:58:25 CST 2020
     */
    long countByExample(MajorInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table major
     *
     * @mbg.generated Sat Sep 05 21:58:25 CST 2020
     */
    int deleteByExample(MajorInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table major
     *
     * @mbg.generated Sat Sep 05 21:58:25 CST 2020
     */
    int deleteByPrimaryKey(String mid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table major
     *
     * @mbg.generated Sat Sep 05 21:58:25 CST 2020
     */
    int insert(MajorInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table major
     *
     * @mbg.generated Sat Sep 05 21:58:25 CST 2020
     */
    int insertSelective(MajorInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table major
     *
     * @mbg.generated Sat Sep 05 21:58:25 CST 2020
     */
    List<MajorInfo> selectByExample(MajorInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table major
     *
     * @mbg.generated Sat Sep 05 21:58:25 CST 2020
     */
    MajorInfo selectByPrimaryKey(String mid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table major
     *
     * @mbg.generated Sat Sep 05 21:58:25 CST 2020
     */
    int updateByExampleSelective(@Param("record") MajorInfo record, @Param("example") MajorInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table major
     *
     * @mbg.generated Sat Sep 05 21:58:25 CST 2020
     */
    int updateByExample(@Param("record") MajorInfo record, @Param("example") MajorInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table major
     *
     * @mbg.generated Sat Sep 05 21:58:25 CST 2020
     */
    int updateByPrimaryKeySelective(MajorInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table major
     *
     * @mbg.generated Sat Sep 05 21:58:25 CST 2020
     */
    int updateByPrimaryKey(MajorInfo record);
}
package com.uestc.fff.information.mapper;

import com.uestc.fff.information.domain.TeacherInfo;
import com.uestc.fff.information.domain.TeacherInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TeacherInfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table teacher
     *
     * @mbg.generated Sat Sep 05 21:58:25 CST 2020
     */
    long countByExample(TeacherInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table teacher
     *
     * @mbg.generated Sat Sep 05 21:58:25 CST 2020
     */
    int deleteByExample(TeacherInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table teacher
     *
     * @mbg.generated Sat Sep 05 21:58:25 CST 2020
     */
    int deleteByPrimaryKey(String tid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table teacher
     *
     * @mbg.generated Sat Sep 05 21:58:25 CST 2020
     */
    int insert(TeacherInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table teacher
     *
     * @mbg.generated Sat Sep 05 21:58:25 CST 2020
     */
    int insertSelective(TeacherInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table teacher
     *
     * @mbg.generated Sat Sep 05 21:58:25 CST 2020
     */
    List<TeacherInfo> selectByExample(TeacherInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table teacher
     *
     * @mbg.generated Sat Sep 05 21:58:25 CST 2020
     */
    TeacherInfo selectByPrimaryKey(String tid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table teacher
     *
     * @mbg.generated Sat Sep 05 21:58:25 CST 2020
     */
    int updateByExampleSelective(@Param("record") TeacherInfo record, @Param("example") TeacherInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table teacher
     *
     * @mbg.generated Sat Sep 05 21:58:25 CST 2020
     */
    int updateByExample(@Param("record") TeacherInfo record, @Param("example") TeacherInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table teacher
     *
     * @mbg.generated Sat Sep 05 21:58:25 CST 2020
     */
    int updateByPrimaryKeySelective(TeacherInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table teacher
     *
     * @mbg.generated Sat Sep 05 21:58:25 CST 2020
     */
    int updateByPrimaryKey(TeacherInfo record);
}
package com.bjxxkjdx.job_analysis.mapper;

import com.bjxxkjdx.job_analysis.bean.allMapReturn;
import com.bjxxkjdx.job_analysis.bean.dataReturn;
import com.bjxxkjdx.job_analysis.bean.jobsData;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author ChenXing
 * @date 2021/4/16 上午8:12
 */
@Component
@Mapper
public interface dataMapper {
    @Select("select jobName,name,value from dataStruct")
    List<dataReturn> getAllData();

    @Select("select name, sum(value)value from dataStruct group by name;")
    List<allMapReturn> getGroupMapData();

    @Select("SELECT * FROM jobData WHERE jobName like %#{keyword}%;")
    List<jobsData> getGroupJobData(@Param("keyword")String keyword);

    @Select("select dataStruct.jobName from dataStruct group by jobName")
    List<String> getAllJobTypes();

    @Select("select dataStruct.value from dataStruct where jobName = #{jobName} and name = #{name}")
    List<Integer> getValue(@Param("jobName")String jobName,@Param("name")String name);

    @Update("update dataStruct set value = #{value} where jobName = #{jobName} and name = #{name}")
    int updateDataStruct(@Param("jobName")String jobName,@Param("name")String name,@Param("value")String value);

    @Insert("insert into dataStruct (jobName, name, value) VALUES (#{jobName},#{name},#{value})")
    int insertDataStruct(@Param("jobName")String jobName,@Param("name")String name,@Param("value")String value);


    @Insert("insert into jobData (jobName, jobArea, salary, des) VALUES (#{jobName},#{area},#{salary},#{des})")
    int insertData(@Param("jobName")String jobName,@Param("area")String area,@Param("salary")String salary,@Param("des")String des);


    @Delete("delete from dataStruct where name = #{name} and jobName = #{jobName} and value = #{value}")
    void deleteData(@Param("jobName")String jobName,@Param("name")String name,@Param("value")String value);
}
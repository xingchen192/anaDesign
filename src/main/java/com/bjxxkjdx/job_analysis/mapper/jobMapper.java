package com.bjxxkjdx.job_analysis.mapper;

import com.bjxxkjdx.job_analysis.bean.employment;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author ChenXing
 * @date 2021/1/23 下午3:59
 */
@Component
@Mapper
public interface jobMapper {
    @Select("select * from jobs")
    List<employment> getData();


    @Select("select jobs.salary from jobs")
    List<String> getSalary();

    @Insert("insert into simhash (job_id, simhash) values (#{id},#{value})")
    void insetSimhash(@Param("id") int id,@Param("value") Long value);

    @Select("select descString from jobs order by job_id limit 100")
//    select descString from jobs order by job_id desc limit 10
    List<String> getDe();

    @Select("select jobs.job_href from jobs")
    List<String> getHerf();

    @Select("select simhash.simhash from simhash order by job_id limit 50")
//    select descString from jobs order by job_id desc limit 10
    List<Long> getLimitFifty();


    @Select("select * from jobs where job_id = #{id}")
    employment getById(@Param("id") int id);

    @Select("select job_id from jobs where job_id = #{id}")
    int getId(@Param("id") int id);
//    @Select("select id from dataset where item = #{item}")
//    List<String> getData(@Param("val") String name);
}

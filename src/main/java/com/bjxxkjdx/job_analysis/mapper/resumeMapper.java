package com.bjxxkjdx.job_analysis.mapper;

import com.bjxxkjdx.job_analysis.bean.resume;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author ChenXing
 * @date 2021/1/15 下午7:42
 */
@Component
@Mapper
public interface resumeMapper {

    @Insert("insert into filePath (path,fileName) VALUES (#{path},#{name})")
    public void insertFile(@Param("path") String path,@Param("name") String name);
//    @Select("select * from .....")
//    List<resume> getAll();
//
}

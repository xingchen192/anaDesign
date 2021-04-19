package com.bjxxkjdx.job_analysis.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import com.bjxxkjdx.job_analysis.bean.theuser;
import org.springframework.stereotype.Component;

/**
 * @author ChenXing
 * @date 2021/3/20 下午9:24
 */
@Component
@Mapper
public interface userMapper {
    @Insert("insert into theUser(account, password) VALUES (#{id},#{password})")
    int adduser(@Param("id") String id, @Param("password") String password);

    @Select("select *from theUser where account = #{id} and password=#{password}")
    theuser login(@Param("id") String id, @Param("password") String password);

    @Select("select *from theUser where account = #{id}")
    theuser judge(@Param("id") String id);
}

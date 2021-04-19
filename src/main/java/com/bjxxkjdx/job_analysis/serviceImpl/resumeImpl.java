package com.bjxxkjdx.job_analysis.serviceImpl;

import com.bjxxkjdx.job_analysis.mapper.resumeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ChenXing
 * @date 2021/1/26 下午10:08
 */
@Service
public class resumeImpl {
    @Autowired
    resumeMapper resumeMapper;

    public void insertFile(String path,String name){
        resumeMapper.insertFile(path,name);
    }

}

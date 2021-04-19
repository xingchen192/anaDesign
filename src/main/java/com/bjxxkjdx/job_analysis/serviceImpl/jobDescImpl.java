package com.bjxxkjdx.job_analysis.serviceImpl;

import com.bjxxkjdx.job_analysis.bean.employment;
import com.bjxxkjdx.job_analysis.mapper.jobMapper;
import com.bjxxkjdx.job_analysis.service.jobDesc;
import com.bjxxkjdx.job_analysis.utils.Simhash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ChenXing
 * @date 2021/1/23 下午4:33
 */
@Service
public class jobDescImpl implements jobDesc {
    @Autowired
    jobMapper jobMapper;

    @Override
    public List<employment> getDesc() {
        return jobMapper.getData();
    }

    public employment getOne(int id) {
        return jobMapper.getById(id);
    }

    public int getId(int id) {
        return jobMapper.getId(id);
    }

    public List<Long> get50() {
        return jobMapper.getLimitFifty();
    }
    public List<String> getSalary(){
       return jobMapper.getSalary();
    }

    public List<String> getDes() {
        return jobMapper.getDe();
    }

    public void insertSimhas(int id, Long value) {
        jobMapper.insetSimhash(id, value);

    }

    public Long simHash(String content) {
        Simhash simhash = new Simhash(4, 3);
        return simhash.calSimhash(content);
    }

    public List<String> getHrefs() {
        return jobMapper.getHerf();
    }



}

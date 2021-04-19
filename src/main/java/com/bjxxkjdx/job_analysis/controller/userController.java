package com.bjxxkjdx.job_analysis.controller;

import com.bjxxkjdx.job_analysis.mapper.userMapper;
import com.bjxxkjdx.job_analysis.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author ChenXing
 * @date 2021/3/20 下午9:31
 */
@RestController
@RequestMapping(value = "/user")
public class userController {
    @Autowired
    userMapper userMapper;

    @PostMapping(value = "/add")
    public String addUser(@RequestParam("id") String id, @RequestParam("password") String password) {

        if (userMapper.judge(id) != null)
            return "0";
        else {
            userMapper.adduser(id, MD5Utils.md5Password(password));
            return "1";
        }

    }
    @PostMapping(value = "/login")
    public String login(@RequestParam("id") String id, @RequestParam("password") String password) {
        if (userMapper.login(id, MD5Utils.md5Password(password))!=null)
            return "1";
        return "0";
    }



    }

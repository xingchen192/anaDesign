package com.bjxxkjdx.job_analysis.bean;

import lombok.Data;

/**
 * @author ChenXing
 * @date 2021/1/13 下午8:39
 */
@Data
public class employment {
    private int job_id;
    private String job_name;
    private String company_name;
    private String work_addr;
    private String salary;
    private String push_date;
    private String job_key;
    private String industry;
    private String underindustry;
    private String job_href;
    private String descString;
}

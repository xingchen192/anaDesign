package com.bjxxkjdx.job_analysis.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ChenXing
 * @date 2021/4/16 上午8:12
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class dataReturn {
    private String jobName;
    private String name;
    private int value;

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}

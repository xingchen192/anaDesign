package com.bjxxkjdx.job_analysis.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ChenXing
 * @date 2021/4/17 下午10:24
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class jobsData {
    private String jobName;
    private String jobArea;
    private String salary;
    private String des;
}

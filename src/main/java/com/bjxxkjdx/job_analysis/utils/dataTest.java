package com.bjxxkjdx.job_analysis.utils;

import java.util.Date;

/**
 * @author ChenXing
 * @date 2021/3/23 上午10:44
 */
public class dataTest {
    public static void main(String[] args) {
        Date data = new Date();
        Date data2 = new Date();
        System.out.println(data.toString());
        System.out.println(data.getTime());
        System.out.println(data.hashCode());
        System.out.println();
        System.out.println(data2.toString());
        System.out.println(data2.getTime());
        System.out.println(data2.hashCode());
    }
}

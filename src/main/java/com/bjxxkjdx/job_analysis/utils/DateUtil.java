package com.bjxxkjdx.job_analysis.utils;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * @author ChenXing
 * @date 2021/4/27 下午6:24
 */

public class DateUtil {

    /**
     * 生成随机时间
     *
     * @param beginDate
     * @param endDate
     * @return
     */
    public static Date randomDate(String beginDate, String endDate) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date start = format.parse(beginDate);// 构造开始日期
            Date end = format.parse(endDate);// 构造结束日期
            // getTime()表示返回自 1970 年 1 月 1 日 00:00:00 GMT 以来此 Date 对象表示的毫秒数。
            if (start.getTime() >= end.getTime()) {
                return null;
            }
            long date = random(start.getTime(), end.getTime());
            return new Date(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static long random(long begin, long end) {
        long rtn = begin + (long) (Math.random() * (end - begin));
        // 如果返回的是开始时间和结束时间，则递归调用本函数查找随机值
        if (rtn == begin || rtn == end) {
            return random(begin, end);
        }
        return rtn;
    }

    public static void main(String[] args) {
        for (int i =0;i < 100;i++){
        Date randomDate = randomDate("2019-01-01", "2019-12-29");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//
        String result = format.format(randomDate);
        System.out.println(result);
    }}
}

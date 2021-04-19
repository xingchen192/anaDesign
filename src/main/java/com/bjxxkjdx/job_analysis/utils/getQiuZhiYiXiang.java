package com.bjxxkjdx.job_analysis.utils;

import java.io.*;
import java.util.ArrayList;

/**
 * @author ChenXing
 * @date 2021/4/12 下午5:50
 */
public class getQiuZhiYiXiang {
    public static void main(String[] args) {
        String job = "ExtractText.txt";
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            File file = new File(job);
            InputStreamReader inputReader = new InputStreamReader(new FileInputStream(file));
            BufferedReader bf = new BufferedReader(inputReader);
            // 按行读取字符串
            String str;
            while ((str = bf.readLine()) != null) {
                if (str.contains("求职意向"))
                arrayList.add(str.split("求职意向")[1]);
            }
            bf.close();
            inputReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String v:arrayList){
            System.out.println(v);
        }
    }
}

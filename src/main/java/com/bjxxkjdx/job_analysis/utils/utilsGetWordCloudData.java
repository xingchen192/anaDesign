package com.bjxxkjdx.job_analysis.utils;

import com.bjxxkjdx.job_analysis.bean.allMapReturn;
import com.bjxxkjdx.job_analysis.bean.dataReturn;
import com.bjxxkjdx.job_analysis.bean.jobsData;
import com.hankcs.hanlp.HanLP;

import java.util.*;

/**
 * @author ChenXing
 * @date 2021/4/17 下午3:28
 */
public class utilsGetWordCloudData {


    public static List<jobsData> utilsHandle(List<jobsData> jobsDataList, List<String> nameLists) {
        List<jobsData> list = new ArrayList<>();
        for (jobsData jobsData : jobsDataList) {
//            boolean flag = true;
            for (String c : nameLists) {
                if (jobsData.getJobName().contains(c)) {
                    jobsData.setJobName(c);
                    list.add(jobsData);
//                    flag = false;
                }
            }

        }
        return list;
    }


    public static List<dataReturn> utilsGetDataStruct(List<jobsData> lists, String jobname) {
        List<dataReturn> dataReturnList = new ArrayList<>();
        List<String> areas = new ArrayList<>();
        for (jobsData data : lists) {
            String area = data.getJobArea();
            if (area.contains("-"))
                area = area.split("-")[0];
            areas.add(area);

            Set<String> uniqueSet = new HashSet(areas);
//            List<allMapReturn> allMapReturns = new ArrayList<>();
            for (String temp : uniqueSet) {
                dataReturn dataReturn = new dataReturn(jobname, temp, Collections.frequency(areas, temp));
                dataReturnList.add(dataReturn);
                System.out.println("{\'name\':\"" + temp + "\"" + ", " + "\"value\":" + Collections.frequency(areas, temp) + "},");
            }

//            dataReturn dataReturn = new dataReturn();
//
//            dataReturn.setJobName(jobname);
//
//            String area = temp.getJobArea();
//            if (area.contains("-"))
//                area = area.split("-")[0];
//            dataReturn.setName(area);
//
//            dataReturn.setName();
        }
        return dataReturnList;
    }

    public static List<dataReturn> utilsGetDataStruct(List<jobsData> lists) {
        List<dataReturn> dataReturnList = new ArrayList<>();
        List<String> areas = new ArrayList<>();
        for (jobsData data : lists) {
            String area = data.getJobArea();
            if (area.contains("-"))
                area = area.split("-")[0];
            areas.add(area);

            Set<String> uniqueSet = new HashSet(areas);
//            List<allMapReturn> allMapReturns = new ArrayList<>();
            for (String temp : uniqueSet) {
                dataReturn dataReturn = new dataReturn(data.getJobName(), temp, Collections.frequency(areas, temp));
                dataReturnList.add(dataReturn);
                System.out.println(data.getJobName()+"{\'name\':\"" + temp + "\"" + ", " + "\"value\":" + Collections.frequency(areas, temp) + "},");
            }

//            dataReturn dataReturn = new dataReturn();
//
//            dataReturn.setJobName(jobname);
//
//            String area = temp.getJobArea();
//            if (area.contains("-"))
//                area = area.split("-")[0];
//            dataReturn.setName(area);
//
//            dataReturn.setName();
        }
        return dataReturnList;
    }


    public static List<allMapReturn> utilsGetWordCloudDatas(List<String> lists, int type) {
        List<String> results = new ArrayList();
        if (type == 0) {
            for (String res : lists) {
//            System.out.println(res);
                List<String> keywordList = HanLP.extractKeyword(res, 100);
//            List<String> phraseList = HanLP.extractPhrase(res, 1000);
//            for (String re:phraseList)
//                System.out.println(re);
//            System.out.println(phraseList);
                results.addAll(keywordList);
            }
        } else {
            for (String res : lists) {

                List<String> phraseList = HanLP.extractPhrase(res, 1000);
//            for (String re:phraseList)
//                System.out.println(re);
//            System.out.println(phraseList);
                results.addAll(phraseList);
            }

        }


        Set<String> uniqueSet = new HashSet(results);
        List<allMapReturn> allMapReturns = new ArrayList<>();
        for (String temp : uniqueSet) {
            if (Collections.frequency(results, temp) !=0) {
                allMapReturn allMapReturn = new allMapReturn(temp, Collections.frequency(results, temp));
                allMapReturns.add(allMapReturn);
                System.out.println("{\'name\':\"" + temp + "\"" + ", " + "\"value\":" + Collections.frequency(results, temp) + "},");
            }
        }
        return allMapReturns;
    }
}

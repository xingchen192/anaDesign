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
                System.out.println(data.getJobName() + "{\'name\':\"" + temp + "\"" + ", " + "\"value\":" + Collections.frequency(areas, temp) + "},");
            }

        }
        return dataReturnList;
    }

    public static List<dataReturn> utilsGetDataStruct1(List<jobsData> lists) {
        List<dataReturn> dataReturnList = new ArrayList<>();
//        List<String> areas = new ArrayList<>();
        List<jobsData> strings=lists;
        for (int i = 0;i < strings.size()-1;i++) {
            dataReturn dataReturn = new dataReturn(strings.get(i).getJobName(),strings.get(i).getJobArea(),1);
            for (int j= i+1;j<strings.size();j++){
                if (strings.get(j).getJobName().equals(dataReturn.getJobName())&&strings.get(j).getJobArea().equals(dataReturn.getName())){
                    dataReturn.setValue(dataReturn.getValue()+1);
                    dataReturnList.add(dataReturn);
                    strings.remove(j);
//                    j--;
                }
                for (jobsData jobsData : strings){
                    System.out.println(jobsData.getJobName());
                }
            }
//            String area = data.getJobArea();
//            if (area.contains("-"))
//                area = area.split("-")[0];
//            areas.add(area);
//
//            Set<String> uniqueSet = new HashSet(areas);
////            List<allMapReturn> allMapReturns = new ArrayList<>();
//            for (String temp : uniqueSet) {
//                dataReturn dataReturn = new dataReturn(data.getJobName(), temp, Collections.frequency(areas, temp));
//                dataReturnList.add(dataReturn);
//                System.out.println(data.getJobName() + "{\'name\':\"" + temp + "\"" + ", " + "\"value\":" + Collections.frequency(areas, temp) + "},");
//            }




        }
        dataReturnList.add(new dataReturn(strings.get(strings.size()-1).getJobName(),strings.get(strings.size()-1).getJobArea(),1));


        for (dataReturn dataReturn:dataReturnList){
            System.out.println(dataReturn.getJobName());
            System.out.println(dataReturn.getName());
            System.out.println(dataReturn.getValue());
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
            if (Collections.frequency(results, temp) != 0) {
                allMapReturn allMapReturn = new allMapReturn(temp, Collections.frequency(results, temp));
                allMapReturns.add(allMapReturn);
                System.out.println("{\'name\':\"" + temp + "\"" + ", " + "\"value\":" + Collections.frequency(results, temp) + "},");
            }
        }
        return allMapReturns;
    }


    public static List<allMapReturn> handleSalary(List<String> salarys) {
        List<String> res = new ArrayList<>();
        for (String sala : salarys) {
//            System.out.println(sala);
            res.add(sala.split("-")[0]);
        }

        Set<String> uniqueSet = new HashSet(res);
        List<allMapReturn> allMapReturns = new ArrayList<>();
        for (String temp : uniqueSet) {
            if (Collections.frequency(res, temp) != 0) {
                allMapReturn allMapReturn = new allMapReturn(temp, Collections.frequency(res, temp));
                allMapReturns.add(allMapReturn);
//                System.out.println("{\'name\':\"" + temp + "\"" + ", " + "\"value\":" + Collections.frequency(res, temp) + "},");
            }
        }

        List<allMapReturn> allMapReturns2 = new ArrayList<>();
        allMapReturns2.add(new allMapReturn("4-10k/月", 0));
        allMapReturns2.add(new allMapReturn("10-20k/月", 0));
        allMapReturns2.add(new allMapReturn("20-30k/月", 0));
        allMapReturns2.add(new allMapReturn("其他", 0));
        for (allMapReturn mapReturn : allMapReturns) {
            if (Integer.parseInt(mapReturn.getName()) >= 4 && Integer.parseInt(mapReturn.getName()) <= 10) {
                allMapReturns2.get(0).setValue(allMapReturns2.get(0).getValue() + mapReturn.getValue());
            } else if (Integer.parseInt(mapReturn.getName()) >= 10 && Integer.parseInt(mapReturn.getName()) <= 20) {
                allMapReturns2.get(1).setValue(allMapReturns2.get(1).getValue() + mapReturn.getValue());
            } else if (Integer.parseInt(mapReturn.getName()) >= 20 && Integer.parseInt(mapReturn.getName()) <= 30) {
                allMapReturns2.get(2).setValue(allMapReturns2.get(2).getValue() + mapReturn.getValue());
            } else {
                allMapReturns2.get(3).setValue(allMapReturns2.get(3).getValue() + mapReturn.getValue());
            }
        }
        return allMapReturns2;
    }


    public static List<allMapReturn> utilHandelResArea(List<String> areas){
        Set<String> uniqueSet = new HashSet(areas);
        List<allMapReturn> allMapReturns = new ArrayList<>();
        for (String temp : uniqueSet) {
            if (Collections.frequency(areas, temp) != 0) {
                allMapReturn allMapReturn = new allMapReturn(temp, Collections.frequency(areas, temp));
                allMapReturns.add(allMapReturn);
//                System.out.println("{\'name\':\"" + temp + "\"" + ", " + "\"value\":" + Collections.frequency(res, temp) + "},");
            }
        }
        return allMapReturns;
    }
}

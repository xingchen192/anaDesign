package com.bjxxkjdx.job_analysis.controller;

import com.bjxxkjdx.job_analysis.bean.allMapReturn;
import com.bjxxkjdx.job_analysis.bean.dataReturn;
import com.bjxxkjdx.job_analysis.bean.jobsData;
import com.bjxxkjdx.job_analysis.mapper.dataMapper;
import com.bjxxkjdx.job_analysis.serviceImpl.importService;
import com.bjxxkjdx.job_analysis.utils.utilsGetWordCloudData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ChenXing
 * @date 2021/4/16 上午8:17
 */
@RequestMapping(value = "/data")
@RestController
public class dataController {
    @Autowired
    private dataMapper dataMapper;

    @Autowired
    private importService importService;

    @GetMapping(value = "/allDatas")
    public List<dataReturn> getAllData() {
        return dataMapper.getAllData();
    }

    @GetMapping(value = "/allGroupDatas")
    public List<allMapReturn> getGroupMapData() {
        return dataMapper.getGroupMapData();
    }


    @GetMapping(value = "/allGroupDataByDate")
    public List<allMapReturn> getGroupMapByDate(@RequestParam(value = "bda") String bda, @RequestParam(value = "eda") String eda) {
        return dataMapper.getGroupMaByDate(bda, eda);
    }


    @PostMapping(value = "/upload")
    @ResponseBody
    public String uploadExcel(@RequestParam(value = "file") MultipartFile file) throws Exception {

        if (file.isEmpty()) {
            return "文件不能为空";
        }


        InputStream inputStream = file.getInputStream();
        List<List<Object>> list = importService.getBankListByExcel(inputStream, file.getOriginalFilename());
        inputStream.close();


        List<String> nameLists = dataMapper.getAllJobTypes();
        List<jobsData> jobsDataList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            List<Object> lo = list.get(i);
            //TODO 随意发挥
//            System.out.println(lo.get(0));
//            System.out.println(lo.get(1));
//            System.out.println(lo.get(2));
//            System.out.println(lo.get(3));
            if (lo.size() > 4) {
                return "格式错误";
            } else {
                jobsDataList.add(new jobsData(lo.get(0).toString(), lo.get(1).toString(), lo.get(2).toString(), lo.get(3).toString()));
                dataMapper.insertData(lo.get(0).toString(), lo.get(1).toString(), lo.get(2).toString(), lo.get(3).toString());
            }
        }

//        for (jobsData jobsData : jobsDataList) {
//            boolean flag = true;
//            for (String c : nameLists) {
//                if (jobsData.getJobName().contains(c)) {
//                    jobsData.setJobName(c);
//                    flag = false;
//                }
//            }
//            if (flag) {
//                jobsDataList.remove(jobsData);
//            }
//
//        }

        List<jobsData> jobsDataListRes = utilsGetWordCloudData.utilsHandle(jobsDataList, nameLists);
        List<dataReturn> res = utilsGetWordCloudData.utilsGetDataStruct1(jobsDataListRes);

        for (dataReturn dataReturn : res) {
//            if (dataMapper.getValue(dataReturn.getJobName(), dataReturn.getName()) != null) {
//                List<Integer> values = dataMapper.getValue(dataReturn.getJobName(), dataReturn.getName());
//                if (values.size() > 0) {
//                    dataMapper.deleteData(dataReturn.getJobName(), dataReturn.getName(), String.valueOf(values.get(0)));
//                    dataMapper.insertDataStruct(dataReturn.getJobName(), dataReturn.getName(), String.valueOf(dataReturn.getValue() + values.get(0)));
////                    System.out.println(dataMapper.updateDataStruct(dataReturn.getJobName(), dataReturn.getName(), String.valueOf(dataReturn.getValue())));
//                } else {
//                    dataMapper.insertDataStruct(dataReturn.getJobName(), dataReturn.getName(), String.valueOf(dataReturn.getValue()));
//
//                }
//            }

            dataMapper.insertDataStruct(dataReturn.getJobName(), dataReturn.getName(), String.valueOf(dataReturn.getValue()));

        }
//        for (dataReturn dataReturn : res) {
//            if (dataMapper.getValue(dataReturn.getJobName(), dataReturn.getName()) != null) {
//                List<Integer> values = dataMapper.getValue(dataReturn.getJobName(), dataReturn.getName());
//                if (values.size() > 0) {
//                    dataMapper.deleteData(dataReturn.getJobName(), dataReturn.getName(), String.valueOf(values.get(0)));
//                    dataMapper.insertDataStruct(dataReturn.getJobName(), dataReturn.getName(), String.valueOf(dataReturn.getValue() + values.get(0)));
////                    System.out.println(dataMapper.updateDataStruct(dataReturn.getJobName(), dataReturn.getName(), String.valueOf(dataReturn.getValue())));
//                } else {
//                    dataMapper.insertDataStruct(dataReturn.getJobName(), dataReturn.getName(), String.valueOf(dataReturn.getValue()));
//
//                }
//            }
//
//
//        }

        return "上传成功";
    }


    /**
     * 简历Excel数据上传
     *
     * @param file
     * @return
     * @throws Exception
     */
    @PostMapping(value = "/upload2")
    @ResponseBody
    public String uploadExcelResume(@RequestParam(value = "file") MultipartFile file) throws Exception {

        if (file.isEmpty()) {
            return "文件不能为空";
        }


        InputStream inputStream = file.getInputStream();
        List<List<Object>> list = importService.getBankListByExcel(inputStream, file.getOriginalFilename());
        inputStream.close();


//        List<String> nameLists = dataMapper.getAllJobTypes();
        List<jobsData> jobsDataList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            List<Object> lo = list.get(i);
            System.out.println(lo);
            //TODO 随意发挥
//           if (lo.get(0).equals("0")&&lo.get(6).equals("1")){
//                if (lo.get(1)==null)
//           }
            if (lo.size() > 5) {
                dataMapper.addResum(lo.get(1) == null ? "" : lo.get(1).toString(), lo.get(2) == null ? "" : lo.get(2).toString(), lo.get(3) == null ? "" : lo.get(3).toString(), lo.get(4) == null ? "" : lo.get(4).toString(), lo.get(5) == null ? "" : lo.get(5).toString());
            } else {
                break;
            }

        }


        return "上传成功";
    }

    @GetMapping(value = "/allCommments")
    public List<allMapReturn> getAllComments() {
//        utilsGetWordCloudData.utilsGetWordCloudDatas(dataMapper.getAllComment(),0);

        return utilsGetWordCloudData.utilsGetWordCloudDatas(dataMapper.getAllComment(), 1);
    }

    @GetMapping(value = "/allSkills")
    public List<allMapReturn> getAllSkills() {
        return utilsGetWordCloudData.utilsGetWordCloudDatas(dataMapper.getAllSkills(), 0);
//        return dataMapper.getAllSkills();
    }

    @GetMapping(value = "/type")
    public List<allMapReturn> getTypeData(@RequestParam(value = "name") String name) {
        List<allMapReturn> re = new ArrayList<>();
        if (name.equals("java") || name.equals("android")) {
            re = dataMapper.getTypeD(5, name);
        } else if (name.equals("python")) {
            System.out.println("python");
            re = dataMapper.getTypeD(0, name);
        } else
            re = dataMapper.getTypeD(1, name);


//        for (allMapReturn r : re){
//            dataMapper.insertWordCloud(name,r.getName(),String.valueOf(r.getValue()));
//        }
        return re;
//        return dataMapper.getAllSkills();
    }

    @GetMapping(value = "/salary")
    public List<allMapReturn> getSalary() {


        return utilsGetWordCloudData.handleSalary(dataMapper.getAllSalary());
//        return dataMapper.getAllSkills();
    }

    @GetMapping(value = "/typeSalary")
    public List<allMapReturn> getSalary(@RequestParam(value = "name") String name) {
        return utilsGetWordCloudData.handleSalary(dataMapper.getTypeSalary(name));
//        return utilsGetWordCloudData.handleSalary(dataMapper.getAllSalary());
//        return dataMapper.getAllSkills();
    }

    @GetMapping(value = "/resArea")
    public List<allMapReturn> getResArea() {


        return utilsGetWordCloudData.utilHandelResArea(dataMapper.getResArea());
//        return dataMapper.getAllSkills();
    }
}

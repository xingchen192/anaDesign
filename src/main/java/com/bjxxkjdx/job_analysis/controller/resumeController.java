package com.bjxxkjdx.job_analysis.controller;

import com.bjxxkjdx.job_analysis.bean.employment;
import com.bjxxkjdx.job_analysis.serviceImpl.jobDescImpl;
import com.bjxxkjdx.job_analysis.serviceImpl.resumeImpl;
import com.hankcs.hanlp.mining.word2vec.DocVectorModel;
import com.hankcs.hanlp.mining.word2vec.WordVectorModel;
import com.spire.pdf.PdfDocument;
import com.spire.pdf.PdfPageBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author ChenXing
 * @date 2021/1/26 下午2:35
 */
//@CrossOrigin
@Controller
@RequestMapping(value = "/resume")
public class resumeController {
    @Autowired
    jobDescImpl jobDesc;

    @Autowired
    resumeImpl resumeI;

    @PostMapping("/reco")
    @ResponseBody
    public List<employment> uploadPoster(@RequestParam("skills") String skills) throws IOException {

        List<employment> res = new ArrayList<>();
        //获取数据库职位信息
        List<employment> jobdes = jobDesc.getDesc();
        DocVectorModel docVectorModel = new DocVectorModel(new WordVectorModel("mrs.txt"));
        Map<employment, Float> floatMap = new HashMap<>();
        for (employment empWithId : jobdes) {
            float re = docVectorModel.similarity(skills, empWithId.getDescString());
            if (re > 0.7) {
                floatMap.put(empWithId, re);
//                System.out.println(re);
//                res.add(empWithId);
            }
        }
        ArrayList<Map.Entry<employment, Float>> arrayList = new ArrayList<Map.Entry<employment, Float>>(floatMap.entrySet());
        //排序
        Collections.sort(arrayList, new Comparator<Map.Entry<employment, Float>>() {
            public int compare(Map.Entry<employment, Float> map1, Map.Entry<employment, Float> map2) {
                return ((map2.getValue() - map1.getValue() == 0) ? 0 : (map2.getValue() - map1.getValue() > 0) ? 1 : -1);
            }
        });
        for (Map.Entry<employment, Float> entry : arrayList) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
            res.add(entry.getKey());
//            System.out.println(entry.getKey() + "\t" + entry.getValue());
        }
        if (res.size() > 0)
            return res;
        else
            return null;

    }

    @PostMapping("/uploadPoster")
    @ResponseBody
    public List<employment> uploadPoster(@RequestParam("file") MultipartFile file) throws IOException {
        if (file.isEmpty()) {
            return null;
        }
//        System.out.println(file.getName());
        String upFile = file.getOriginalFilename();
        Date data = new Date();
        String fileType = "";
        System.out.println(upFile);
        if (upFile != null)
            fileType += upFile.split("\\.")[upFile.split("\\.").length - 1];

//        System.out.println(fileType);
        String fileName = data.getTime() + "." + fileType;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        String filepath = dateFormat.format(data);
        String creatpath = ResourceUtils.getURL("classpath:").getPath() + "static/" + filepath + "/";

        File file1 = new File(creatpath);
        if (!file1.exists())
            file1.mkdirs();
        File dest = new File(creatpath + fileName);
        resumeI.insertFile("/" + filepath + "/" + fileName, upFile);
        try {
            file.transferTo(dest);
//            return "fileReturn";
        } catch (IOException ignored) {

        }

//        System.out.println(upFile);
        PdfDocument pdf = new PdfDocument(creatpath + fileName);

        StringBuilder sb = new StringBuilder();
        //定义一个int型变量
        int index = 0;

        //遍历PDF文档中每页
        PdfPageBase page;
        for (int i = 0; i < pdf.getPages().getCount(); i++) {
            page = pdf.getPages().get(i);
            sb.append(page.extractText(true));
        }
        pdf.close();

        List<employment> res = new ArrayList<>();
        //获取数据库职位信息
        List<employment> jobdes = jobDesc.getDesc();
        DocVectorModel docVectorModel = new DocVectorModel(new WordVectorModel("mrs.txt"));
        Map<employment, Float> floatMap = new HashMap<>();
        for (employment empWithId : jobdes) {
            float re = docVectorModel.similarity(sb.toString(), empWithId.getDescString());
            if (re > 0.7) {
                floatMap.put(empWithId, re);
//                System.out.println(re);
//                res.add(empWithId);
            }
        }
        ArrayList<Map.Entry<employment, Float>> arrayList = new ArrayList<Map.Entry<employment, Float>>(floatMap.entrySet());
        //排序
        Collections.sort(arrayList, new Comparator<Map.Entry<employment, Float>>() {
            public int compare(Map.Entry<employment, Float> map1, Map.Entry<employment, Float> map2) {
                return ((map2.getValue() - map1.getValue() == 0) ? 0 : (map2.getValue() - map1.getValue() > 0) ? 1 : -1);
            }
        });
        for (Map.Entry<employment, Float> entry : arrayList) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
            res.add(entry.getKey());
//            System.out.println(entry.getKey() + "\t" + entry.getValue());
        }

        if (res.size() > 0)
            return res;
        else
            return null;
    }

    @PostMapping("/uploads")
    @ResponseBody
    public String uploads(@RequestParam("file") MultipartFile file) throws IOException, InterruptedException {
        if (file.isEmpty()) {
            return null;
        }
//        System.out.println(file.getName());
        String upFile = file.getOriginalFilename();

        String fileType = "";
//        System.out.println("flag1:");
//        System.out.println(upFile);
//        String filerealName = "";
        if (upFile != null){
            fileType += upFile.split("\\.")[upFile.split("\\.").length - 1];
//            filerealName += upFile.split("\\.")[0];
        }
//        Thread.sleep(3000);
        Date data = new Date();
//        System.out.println(fileType);
        String fileName = data.getTime()+ "." + fileType;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        String filepath = dateFormat.format(data);
        String creatpath = ResourceUtils.getURL("classpath:").getPath() + "static/" + filepath + "/";

        File file1 = new File(creatpath);
        if (!file1.exists())
            file1.mkdirs();
        String reaFilePath = creatpath + fileName;
        System.out.println(upFile);
        System.out.println(reaFilePath);
        File dest = new File(creatpath + fileName);
        String requestPath = "/" + filepath + "/" + fileName;
        resumeI.insertFile(requestPath, upFile);
        try {
            file.transferTo(dest);
//            System.out.println("flag2:");
//            System.out.println(reaFilePath);
//            System.out.println();
            return reaFilePath;
        } catch (IOException ignored) {
        }
        return "0";

    }

    @PostMapping(value = "/access")
    @ResponseBody
    public List<List<Float>> access(@RequestParam("filePaths") String[] filePaths) throws IOException {

        List<List<Float>> listList = new ArrayList<>();
        for (String path : filePaths) {
            PdfDocument pdf = new PdfDocument(path);

            StringBuilder sb = new StringBuilder();
            //定义一个int型变量
            int index = 0;

            //遍历PDF文档中每页
            PdfPageBase page;
            for (int i = 0; i < pdf.getPages().getCount(); i++) {
                page = pdf.getPages().get(i);
                sb.append(page.extractText(true));
            }
            pdf.close();
            System.out.println(sb);
            List<employment> res = new ArrayList<>();
//            获取数据库职位信息
            List<employment> jobdes = jobDesc.getDesc();
            DocVectorModel docVectorModel = new DocVectorModel(new WordVectorModel("mrs.txt"));

            List<Float> floats = new ArrayList<>();
            for (employment empWithId : jobdes) {
                float re = docVectorModel.similarity(sb.toString(), empWithId.getDescString());

                if (re > 0.6) {
                    System.out.println(re);
                    floats.add(re);
//                    res.add(empWithId);
                }
            }
            listList.add(floats);
        }
        System.out.println(listList.toString());
        for(List<Float> li:listList)
            System.out.println(li.toString());

        return listList;
    }


//    /**
//     * 使用 Map按value进行排序
//     *
//     * @param map
//     * @return
//     */
//    public static Map<employment, Float> sortMapByValue(Map<employment, Float> oriMap) {
//        if (oriMap == null || oriMap.isEmpty()) {
//            return null;
//        }
//        Map<employment, Float> sortedMap = new LinkedHashMap<employment, Float>();
//        List<Map.Entry<employment, Float>> entryList = new ArrayList<Map.Entry<employment, Float>>(
//                oriMap.entrySet());
//        Collections.sort(entryList, new MapValueComparator());
//
//        Iterator<Map.Entry<employment, Float>> iter = entryList.iterator();
//        Map.Entry<employment, Float> tmpEntry = null;
//        while (iter.hasNext()) {
//            tmpEntry = iter.next();
//            sortedMap.put(tmpEntry.getKey(), tmpEntry.getValue());
//        }
//        return sortedMap;
//    }
//
//    static class MapValueComparator implements Comparator<Map.Entry<employment, Float>> {
//
//        @Override
//        public int compare(Map.Entry<employment, Float> me1, Map.Entry<employment, Float> me2) {
//            //按照从大到小的顺序排列，如果想正序 调换me1 me2的位置
//            return me2.getValue().compareTo(me1.getValue());
//        }
//    }
//
//
//    private static List<employment> sort(Map<employment, Float> floatMap) {
//
//        return null;
//    }


}

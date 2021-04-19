package com.bjxxkjdx.job_analysis.controller;

import com.bjxxkjdx.job_analysis.bean.employment;
import com.bjxxkjdx.job_analysis.serviceImpl.jobDescImpl;
import com.bjxxkjdx.job_analysis.utils.Simhash;
import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.mining.word2vec.DocVectorModel;
import com.hankcs.hanlp.mining.word2vec.WordVectorModel;
import com.hankcs.hanlp.seg.common.Term;
import com.hankcs.hanlp.tokenizer.StandardTokenizer;
import com.spire.pdf.PdfDocument;
import com.spire.pdf.PdfPageBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ChenXing
 * @date 2021/1/23 下午4:52
 */
@RequestMapping(value = "/job")
@RestController
public class jobController {
    @Autowired
    jobDescImpl jobDesc;
    private static final String MODEL_FILE_NAME = "mrs.txt";

    @GetMapping(value = "/all")
    public void data() throws IOException {

        List<String> res = jobDesc.getDes();
        FileWriter writer;
        writer = new FileWriter("cutWord.txt", true);
//        int i = 0;
        for (String ess : res) {

//            System.out.println(ess);
            StringBuilder sb = new StringBuilder();

            List<Term> termList = StandardTokenizer.segment(ess);
//            List<String> keywordList1 = HanLP.extractKeyword(ess, 20);
            for (Term t : termList) {
//                System.out.println(t);
                sb.append(t.word).append(" ");
            }
            System.out.println(sb.toString());
            writer.write(sb.toString());
            writer.write("\n");

//            System.out.println(termList);

//            break;
//            if (++i==100)
//                break;
        }
        writer.flush();
    }

    //通过所有网址获取地址信息
    @GetMapping(value = "/hrefs")
    public void gethref() throws IOException {
        List<String> res = jobDesc.getHrefs();
        FileWriter writer;
        writer = new FileWriter("hrefs.txt", true);
        for (String re : res) {
            writer.write(re);
            writer.write("\n");
        }
        writer.flush();
    }


    //测试算法效果
    @GetMapping(value = "/judge")
    public List<Float> hanMing() throws IOException {
        List<Float> re = new ArrayList<>();
//        Simhash simhash = new Simhash(4, 3);
        List<String> resH = jobDesc.getDes();
        String[] d = {"计科1703 马旭.pdf",
                "计科1703 朱博文 求职简历-converted.pdf",
                "计科1703-姜悦-converted.pdf",
                "计科1703-周龙.pdf",
                "计科1703-张琳.pdf",
                "计科1703-张永荟(1).pdf",
                "计科1703-任子玉-converted.pdf",
                "计科1703-冯浩田-converted.pdf",
                "计科1703-刘从硕-converted.pdf",
                "计科1703-周峻宇-converted.pdf",
                "计科1703-孙志方-converted.pdf",
                "计科1703-徐方颖-converted.pdf",
                "计科1703-戴光奕-converted.pdf",
                "计科1703-李文博-converted.pdf",
                "计科1703-杨志武-converted.pdf",
                "计科1703-杨震栋-converted.pdf",
                "计科1703-王博涵-converted.pdf",
                "计科1703-袁冰霖-converted.pdf",
                "计科1703-邱则衡-converted.pdf",
                "计科1703-郜艾荣-converted.pdf",
                "计科1703-陈盈盈-converted.pdf",
                "计科1703-刘帅康.pdf",
                "计科1703-夏思哲.pdf",
                "计科1703-殷国华.pdf",
                "计科1703-蔡真真.pdf",
                "计科1703-赵孖同.pdf",
                "计科1703-雪合热提-converted.pdf"};
//        计科1703简历/计科1703 朱博文 求职简历-converted.pdf
        String retur = "";
        for (String name : d) {
            //加载测试文档
            PdfDocument pdf = new PdfDocument("计科1703简历/" + name);


            //实例化StringBuilder类
            StringBuilder sb = new StringBuilder();
            //定义一个int型变量
            int index = 0;

            //遍历PDF文档中每页
            PdfPageBase page;
            for (int i = 0; i < pdf.getPages().getCount(); i++) {
                page = pdf.getPages().get(i);
                //调用extractText()方法提取文本
                sb.append(page.extractText(true));
//                FileWriter writer;
//                try {
//                    //将StringBuilder对象中的文本写入到txt
//                    writer = new FileWriter("ExtractText.txt",true);
//                    writer.write(sb.toString());
//                    writer.flush();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            //调用extractImages方法获取图片
//            for (BufferedImage image : page.extractImages()) {
//                //指定输出图片名，指定图片格式
//                File output = new File(String.format("Image_%d.png", index++));
//                ImageIO.write(image, "PNG", output);
//            }
            }
            pdf.close();
            System.out.println(sb);
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            WordVectorModel wordVectorModel = new WordVectorModel(MODEL_FILE_NAME);
            DocVectorModel docVectorModel = new DocVectorModel(wordVectorModel);
            int i = 0;
            for (String in : resH) {
//                Map<Float, String> word2vec = new HashMap<>();

                float res = docVectorModel.similarity(sb.toString(), in);
                System.out.println("第" + ++i + "个与" + name + "文本相似度是：\t" + res);
//                word2vec.put(res,name);
                re.add(res);
            }
//            float temp = -1;
//            for (Map<Float, String> word2vec:re){
//                if (word2vec.)
//            }
            break;
        }
        return re;
    }


    //招聘信息进行simhash运算
    @GetMapping(value = "/str")
    public List<String> Str() {
        List<String> res = jobDesc.getDes();
        Simhash simhash = new Simhash(4, 3);
        List<Long> simhashVals = new ArrayList<>();
        System.out.println(res.size());
        int i = 0;
        for (String content : res) {
            i++;
            Long simhashVal = simhash.calSimhash(content);
//            System.out.println(Long.toBinaryString(simhashVal));
//            System.out.println(simhash.isDuplicate(content));
//            System.out.println(i);
            simhashVals.add(simhashVal);
            jobDesc.insertSimhas(i, simhashVal);
//            simhash.store(simhashVal, content);
        }
        System.out.println(simhashVals.size());
        return res;
    }

    @GetMapping("/salary")
    public List<String> getSalary(){
        List<String> salarys = jobDesc.getSalary();
        for (String sa:salarys){
            System.out.println(sa);
        }
        return salarys;
    }

}

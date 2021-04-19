package com.bjxxkjdx.job_analysis.utils;


import com.spire.pdf.*;
import org.springframework.util.ResourceUtils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author ChenXing
 * @date 2021/1/25 上午11:26
 */
public class pdfReader {
    public static void main(String[] args) throws Exception {
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
        for (String name : d) {
            //加载测试文档
            String creatpath = ResourceUtils.getURL("classpath:").getPath() + "static/";

            PdfDocument pdf = new PdfDocument(creatpath+"/20210126/1611671197842.pdf");


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
            FileWriter writer;
            try {
                //将StringBuilder对象中的文本写入到txt
                writer = new FileWriter("ExtractText.txt",true);
                writer.write(sb.toString());
                writer.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }

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
            break;
        }
    }
}
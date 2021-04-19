package com.bjxxkjdx.job_analysis.utils;

import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.model.crf.CRFLexicalAnalyzer;
import com.hankcs.hanlp.seg.Dijkstra.DijkstraSegment;
import com.hankcs.hanlp.seg.NShort.NShortSegment;
import com.hankcs.hanlp.seg.Segment;

import java.io.*;
import java.util.*;

/**
 * @author ChenXing
 * @date 2021/2/23 下午6:55
 */
public class getkeyWords {
    public static void main(String[] args) throws IOException {
        String job = "network.txt";
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            File file = new File(job);
            InputStreamReader inputReader = new InputStreamReader(new FileInputStream(file));
            BufferedReader bf = new BufferedReader(inputReader);
            // 按行读取字符串
            String str;
            while ((str = bf.readLine()) != null) {
                arrayList.add(str);
            }
            bf.close();
            inputReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        utilsGetWordCloudData.utilsGetWordCloudDatas(arrayList);
//        List<String> results = new ArrayList();
//        for (String res : arrayList) {
////            List<String> keywordList = HanLP.extractKeyword(res, 10);
////            System.out.println(keywordList);
////            List<String> sentenceList = HanLP.extractSummary(res, 3);
////            System.out.println(sentenceList);
////            System.out.println(analyzer.analyze(res));
////            System.out.println("N-最短分词：" + nShortSegment.seg(res) + "\n最短路分词：" + shortestSegment.seg(res));
//
//            List<String> phraseList = HanLP.extractPhrase(res, 1000);
////            System.out.println(phraseList);
//            results.addAll(phraseList);
//        }
//        Set<String> uniqueSet = new HashSet(results);
//
//        for (String temp : uniqueSet) {
//            if (Collections.frequency(results, temp) > 5)
//                System.out.println("{\'name\':\"" + temp + "\"" + ", " + "\"value\":" + Collections.frequency(results, temp) + "},");
//        }
//        for (String temp : uniqueSet) {
//            System.out.println("\'"+ temp+"\':" + Collections.frequency(results, temp));
//        }
    }
}

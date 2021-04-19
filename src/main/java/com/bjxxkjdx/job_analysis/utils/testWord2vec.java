package com.bjxxkjdx.job_analysis.utils;

import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.dictionary.py.Pinyin;
import com.hankcs.hanlp.mining.word2vec.DocVectorModel;
import com.hankcs.hanlp.mining.word2vec.WordVectorModel;
import com.hankcs.hanlp.model.crf.CRFLexicalAnalyzer;
import com.hankcs.hanlp.seg.Dijkstra.DijkstraSegment;
import com.hankcs.hanlp.seg.NShort.NShortSegment;
import com.hankcs.hanlp.seg.Segment;
import com.hankcs.hanlp.seg.common.Term;
import com.hankcs.hanlp.tokenizer.NLPTokenizer;
import com.hankcs.hanlp.tokenizer.StandardTokenizer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ChenXing
 * @date 2021/1/29 下午7:05
 */
public class testWord2vec {
    public static void main(String[] args) throws IOException {
        String[] networks = {
//                "jobs/互联网/test(android).txt",
//                "jobs/互联网/test(c#).txt",
//                "jobs/互联网/test(c).txt",
//                "jobs/互联网/test(go).txt",
//                "jobs/互联网/test(ios).txt",
//                "jobs/互联网/test(html5).txt",
//                "jobs/互联网/test(java).txt",
//                "jobs/互联网/test(node.js).txt",
//                "jobs/互联网/test(js).txt",
//                "jobs/互联网/test(php).txt",
//                "jobs/互联网/test(ruby).txt",
//                "jobs/互联网/test(python).txt",
//                "jobs/互联网/test(web).txt",
//                "jobs/互联网/test(技术经理).txt",
//                "jobs/互联网/test(测试).txt",
                "jobs/互联网/test(网络工程师).txt",
                "jobs/互联网/test(运维).txt"};
        String[] financial = {
                "jobs/金融/test(业务经理).txt",
                "jobs/金融/test(产品主管).txt",
                "jobs/金融/test(产品经理).txt",
                "jobs/金融/test(公司业务客户经理).txt",
                "jobs/金融/test(大堂经理).txt",
                "jobs/金融/test(客户经理).txt",
                "jobs/金融/test(客服专员).txt",
                "jobs/金融/test(市场营销人员).txt",
                "jobs/金融/test(市场部经理).txt",
                "jobs/金融/test(投资经理).txt",
                "jobs/金融/test(投资顾问).txt",
                "jobs/金融/test(支行副行长).txt",
                "jobs/金融/test(理财经理).txt",
                "jobs/金融/test(综合柜员).txt",
                "jobs/金融/test(营销总监).txt",
                "jobs/金融/test(营销经理).txt",
                "jobs/金融/test(财富管理客户经理).txt",
                "jobs/金融/test(银行柜员).txt",
                "jobs/金融/test(销售代表).txt",
                "jobs/金融/test(首席财务官CFO).txt"};

//        ArrayList<String> allList = new ArrayList<>();

        for (String job : networks) {

            ArrayList<String> arrayList = new ArrayList<>();
            int i = 0;
            int j7 = 7,j1=1,j3=3,j4=4;
            try {
                File file = new File(job);
                InputStreamReader inputReader = new InputStreamReader(new FileInputStream(file));
                BufferedReader bf = new BufferedReader(inputReader);
                // 按行读取字符串
                String str;
                while ((str = bf.readLine()) != null) {
                    i++;
                    arrayList.add(str);
                    if (i == j7) {
                        System.out.println("'"+str+"'),");
                        j7 += 11;
                        System.out.println();

                    }
                    if (i == j1) {
                        System.out.println("('"+str+"',");
                        j1 += 11;
                    }
                    if (i == j3) {
                        System.out.println("'"+str+"',");
                        j3 += 11;
                    }
                    if (i == j4) {
                        System.out.println("'"+str+"',");
                        j4 += 11;
                    }
                }
                bf.close();
                inputReader.close();

//                System.out.println();
            } catch (IOException e) {
                e.printStackTrace();
            }

//            Segment segment = HanLP.newSegment().enablePlaceRecognize(true);
//            for (String con:arrayList){
//
//
//                    List<Term> termList = segment.seg(con);
//                    System.out.println(termList);
//            }
            break;
        }


//
//        String document = "算法可大致分为基本算法、数据结构的算法、数论算法、计算几何的算法、图的算法、动态规划以及数值分析、加密算法、排序算法、检索算法、随机化算法、并行算法、厄米变形模型、随机森林算法。" ,
//                "算法可以宽泛的分为三类，" ,
//                "一，有限的确定性算法，这类算法在有限的一段时间内终止。他们可能要花很长时间来执行指定的任务，但仍将在一定的时间内终止。这类算法得出的结果常取决于输入值。" ,
//                "二，有限的非确定算法，这类算法在有限的时间内终止。然而，对于一个（或一些）给定的数值，算法的结果并不是唯一的或确定的。" ,
//                "三，无限的算法，是那些由于没有定义终止定义条件，或定义的条件无法由输入的数据满足而不终止运行的算法。通常，无限算法的产生是由于未能确定的定义终止条件。";
//        List<String> sentenceList = HanLP.extractSummary(document, 3);
//        System.out.println(sentenceList);


//        String[] contents = {"计算机网络、数据库（SqlServer）、软件工程导论、linux、c语言、数据结构等，在软件工程导论这门课中了解了一些有关软件测试的基础理论知识和测试流程",
//                "Python",
//                "计算机应用基础、计算机组装与维护、Flash动画制作、3Dmax图形图像处理。",
//                "Visual Basic语言 、大数据系统设计、计算机体系结构、并行编程。掌握大数据应用知识，能熟练使用HTML5,CSS3,JavaScript等编译软件，熟悉各种前端调试工具，优秀毕业生，熟悉使用office办公软件，尤其擅长PPT制作。",
//                "c语言、数据结构、软件工程、c++、嵌入式、oracle、javaweb、计算机组成原理等课程熟练掌握办公软件。熟悉数据库，有过oracle和mysql的编程经历。简单了解python",
//                "程序设计基础（C语言）、数据结构 Java、面向对象技术（JAVA）、web应用系统实践、",
//                "Linux 操作系统实践、大数据技术实践、CPU设计等 计算机体系结构，编译原理，，计算机网络，移动应用开发，数据库原理与应用，软件工程，汇编语言与微机接口技术，离散数学计算机电路基础等了解Java，c.c++编程语言；了解数据库 MySQL，SQLserver，oracle；了解Android开发、网页开发的基本操作。",
//                "专业课程：数据库，C语言，离散数学，算法设计与分析，数据结构，计算机组成原理，计算机网络，编译原理，并行计算等。",
//                "营销管理导论、经济法、微观经济学、管理学、线性代数A、概率论与数理统计、离散数学、程序设计基础（C语言）、面向对象技术（C++）、JAVA程序设计、人工智能、python、大数据平台技术实践、深度学习、数据采集、云计算导论、数据库原理与应用、计算机网络",
//                "Python，BI，Word（熟练），Excel（熟练），PowerPoint（可设计模板），Android	Studio（简单可视化界面开发），PS，秀米，PR",
//                "java程序设计实践、java 面向对象技术、数据结构、linux系统实践、计算机网络、操作系统、计算机组成原理、数据库原理、oracle库、算法设计、CPU设计、web应用开发、汇编语言与微机接口技术、移动应用开发、软件工程、编译原理、嵌入式、计算机体系结构、信息安全、大学英语、高等数学等相关课程。",
//                "熟悉Windows、Linux操作系统，具有系统管理与维护经验;熟悉各种办公软件(MicrosoftOffice、WPS等）;能用sqlsever 进行小型数据库编程;能使用Eclipse、DEV C++编写程序，学过HTML、JAVA、JSP、CSS 等网站开发语言。能熟练地配置软件环境以及系统的重装。",
//                "熟练掌握Java、C#、SQL、JavaScript等语言；",
//                "掌握并熟练使用 eclipse、myeclipse、vc0、SQL sever、My Sql、Android studio等工具；",
//                "了解 mysql 数据库，精通Jprofile等性能调优工具、loadruner等性能测试工具；",
//                "了解 J2EE 相关开发技术，包括：Java、DB2、SSH开发框架、SOA思想、ETL工具等；  主修课程：计算机组成原理、数据结构、Visual Basic语言，计算机网络、操作系统。 大学英语六级，办公软件熟练，PS 使用熟练，精通 python，C++，C，Linux 工作网络安全、经历VB、计算机可视化编程、android、JAVA WEB、计算机体系结构、微机原理、嵌入式高等数学、数据结构、离散数学、计算机组成原理、数据库原理、微机原理与汇编语言、软件工程、操作系统、Java语言程序设计、编译原理等 IELTS:0 VFP 计算机二级证 熟悉C语音，JAVA等编程语言 熟悉office 等办公软件 英語四六級证书 程序设计基础（C语言）、数据结构 Java、面向对象技术（JAVA）、web应用系统实践、",
//                " Linux 操作系统实践、计算机体系结构、编译原理、计算机网络等数据结构、算法设计、计算机网络、操作系统、计算机组成原理、数据库设计、计算机体系结构、软件工程师职业道德与素养、软件工程、嵌入式系统设计、C语言程序设计、C++程序设计、Java 程序设计、Python程序设计 大学英语四、六级| 接受过系统的乐理训练 | 熟悉网络前端体系架构的搭建、开发和部署。",
//                "数据结构,计算机组成原理,计算机电路基础,计算机网络, 操作系统, 微机原理与接口技术,编译原理,信息安全, 现代密码学,计算机视觉,C/C++, MySQL/Oracle",
//                "熟练掌握C语言、C++和Java；熟练使用各种 IDE，如VC、Eclipse；熟练使用Ps 和 Pr 进行图片和视频处理；精通 AutoCAD 相关图纸绘制功能数据结构，计算机组成原理，操作系统，编译原理，计算机网络，计算机体系结构等课程。各类公文写作",
//                "新闻写作和新闻摄影",
//                "Photoshop 图片编辑 ",
//                "office办公软件",
//                "Java、SQL、Word、Excel、Python、Eclipse、Visio、C/C++",
//                "移动应用开发 操作系统 算法设计与分析 软件工程 数据库 C语言 数据结构 计算机组成原理 计算机网络",
//                " 熟练使用数据库，如sqlserver、mysql、oracle,掌握数据库原理 深入理解数据结构，并能够用Java实现哈希表、链表、队列、栈、二叉树等数据结构 熟练使用Java、较熟悉linux 能够熟练使用HTML、javascript开发前端页面，并能够开发javaweb系统,Oracle数据库、WEB应用系统实践、移动应用系统，面向对象技术（JAVA）、数据结构(JAVA)、",
//                "Linux系统实践、现代密码学、信息安全等。计算机体系结构、操作系统、数据结构、离散数学等课。大学英语四级，熟悉C、C++等语言，能够使用Java、Python等程序语言，能够掌握数据库的搭建与使用。高等数学、线性代数、数据结构、计算机网络、操作系统、数据库原理及应用等课程熟练使用 Microsoftoffice 办公软件",
//                "熟悉常见网络协议",
//                "精通 C语言",
//                "熟悉 javaweb",
//                "熟悉 C++",
//                "了解 linux 系统",
//                "了解常见网络安全技术",
//                "在校学过，C语言，C++，java，数据库，数据结构，linux操纵系统，安卓移动应用等等",
//                " Web开发：会使用Servlet+Jsp+MySql的mvc结构开发Web应用	 	 ",
//                " 前端框架：学过并有过Bootstrap/	Vue	/JQuery框架使用经验 	 ",
//                " 数据库相关：学过并有过MySQL/	SQL/	Mongo/	SQLite	数据库操作经验 	 ",
//                " 版本管理、文档和自动化部署工具：会应用Git 	 学过RESTful	API设计及应用 	 ",
//                " 操作系统：基于mac开发 "};
//        String content = "程序员(英文Programmer)是从事程序开发、维护的专业人员。一般将程序员分为程序设计人员和程序编码人员，但两者的界限并不非常清楚，特别是在中国。软件从业人员分为初级程序员、高级程序员、系统分析员和项目经理四大类。";
//        List<String> keywordList = new ArrayList<>();
//
////        CRFLexicalAnalyzer analyzer = new CRFLexicalAnalyzer();
//        Segment nShortSegment = new NShortSegment().enableCustomDictionary(false).enablePlaceRecognize(true).enableOrganizationRecognize(true);
//        Segment shortestSegment = new DijkstraSegment().enableCustomDictionary(false).enablePlaceRecognize(true).enableOrganizationRecognize(true);

//        for (String content : contents){
////            System.out.println("N-最短分词：" , nShortSegment.seg(content));
////            System.out.println("最短路分词：" , shortestSegment.seg(content));
//
////            List<Term> termList = StandardTokenizer.segment(content);
////            System.out.println(termList);
////            System.out.println(analyzer.analyze(content));
//            System.out.println("+++++++++++++++++++");
//            List<String> phraseList = HanLP.extractKeyword(content, 100);
////            System.out.println(keywordList);
//            System.out.println("+++++++++++++++++++");
////            List<String> phraseList = HanLP.extractPhrase(content, 100);
//            keywordList.addAll(phraseList);
//            System.out.println(phraseList);
////            System.out.println("-------------------------------------------------");
//
//        }
//        System.out.println(keywordList);


//        String text = "算法工程师" ,
//                "算法（Algorithm）是一系列解决问题的清晰指令，也就是说，能够对一定规范的输入，在有限时间内获得所要求的输出。如果一个算法有缺陷，或不适合于某个问题，执行这个算法将不会解决这个问题。不同的算法可能用不同的时间、空间或效率来完成同样的任务。一个算法的优劣可以用空间复杂度与时间复杂度来衡量。算法工程师就是利用算法处理事物的人。" ,
//                "" ,
//                "1职位简介" ,
//                "算法工程师是一个非常高端的职位；" ,
//                "专业要求：计算机、电子、通信、数学等相关专业；" ,
//                "学历要求：本科及其以上的学历，大多数是硕士学历及其以上；" ,
//                "语言要求：英语要求是熟练，基本上能阅读国外专业书刊；" ,
//                "必须掌握计算机相关知识，熟练使用仿真工具MATLAB等，必须会一门编程语言。" ,
//                "" ,
//                "2研究方向" ,
//                "视频算法工程师、图像处理算法工程师、音频算法工程师 通信基带算法工程师" ,
//                "" ,
//                "3目前国内外状况" ,
//                "目前国内从事算法研究的工程师不少，但是高级算法工程师却很少，是一个非常紧缺的专业工程师。算法工程师根据研究领域来分主要有音频/视频算法处理、图像技术方面的二维信息算法处理和通信物理层、雷达信号处理、生物医学信号处理等领域的一维信息算法处理。" ,
//                "在计算机音视频和图形图像技术等二维信息算法处理方面目前比较先进的视频处理算法：机器视觉成为此类算法研究的核心；另外还有2D转3D算法(2D-to-3D conversion)，去隔行算法(de-interlacing)，运动估计运动补偿算法(Motion estimation/Motion Compensation)，去噪算法(Noise Reduction)，缩放算法(scaling)，锐化处理算法(Sharpness)，超分辨率算法(Super Resolution),手势识别(gesture recognition),人脸识别(face recognition)。" ,
//                "在通信物理层等一维信息领域目前常用的算法：无线领域的RRM、RTT，传送领域的调制解调、信道均衡、信号检测、网络优化、信号分解等。" ,
//                "另外数据挖掘、互联网搜索算法也成为当今的热门方向。" ,
//                "算法工程师逐渐往人工智能方向发展。";
//        List<String> phraseList = HanLP.extractPhrase(text, 10);
//        System.out.println(phraseList);
//
//


//        System.out.println(HanLP.segment("你好，欢迎使用HanLP汉语处理包！"));
//
//        List<Term> termList = StandardTokenizer.segment("商品和服务");
//        System.out.println(termList);
//
//        Segment nShortSegment = new NShortSegment().enableCustomDictionary(false).enablePlaceRecognize(true).enableOrganizationRecognize(true);
//        Segment shortestSegment = new DijkstraSegment().enableCustomDictionary(false).enablePlaceRecognize(true).enableOrganizationRecognize(true);
//        String[] testCase = new String[]{
//                "今天，刘志军案的关键人物,山西女商人丁书苗在市二中院出庭受审。",
//                "刘喜杰石国祥会见吴亚琴先进事迹报告团成员",
//        };
//        for (String sentence : testCase)
//        {
//            System.out.println("N-最短分词：" , nShortSegment.seg(sentence) + "最短路分词：" , shortestSegment.seg(sentence));
//        }
//
//        String content = "程序员(英文Programmer)是从事程序开发、维护的专业人员。一般将程序员分为程序设计人员和程序编码人员，但两者的界限并不非常清楚，特别是在中国。软件从业人员分为初级程序员、高级程序员、系统分析员和项目经理四大类。";
//        List<String> keywordList = HanLP.extractKeyword(content, 5);
//        System.out.println(keywordList);
//
//        String content1 = "程序员(英文Programmer)是从事程序开发、维护的专业人员。一般将程序员分为程序设计人员和程序编码人员，但两者的界限并不非常清楚，特别是在中国。软件从业人员分为初级程序员、高级程序员、系统分析员和项目经理四大类。";
//        List<String> keywordList1 = HanLP.extractKeyword(content1, 20);
//        System.out.println(keywordList1);

//        String text = "重载不是重任";
//        List<Pinyin> pinyinList = HanLP.convertToPinyinList(text);
//        System.out.print("原文,");
//        for (char c : text.toCharArray()) {
//            System.out.printf("%c,", c);
//        }
//        System.out.println();
//
//        System.out.print("拼音（数字音调）,");
//        for (Pinyin pinyin : pinyinList) {
//            System.out.printf("%s,", pinyin);
//        }
//        System.out.println();
//
//        System.out.print("拼音（符号音调）,");
//        for (Pinyin pinyin : pinyinList) {
//            System.out.printf("%s,", pinyin.getPinyinWithToneMark());
//        }
//        System.out.println();
//
//        System.out.print("拼音（无音调）,");
//        for (Pinyin pinyin : pinyinList) {
//            System.out.printf("%s,", pinyin.getPinyinWithoutTone());
//        }
//        System.out.println();
//
//        System.out.print("声调,");
//
//        for (Pinyin pinyin : pinyinList) {
//            System.out.printf("%s,", pinyin.getTone());
//        }
//        System.out.println();
//
//        System.out.print("声母,");
//        for (Pinyin pinyin : pinyinList) {
//            System.out.printf("%s,", pinyin.getShengmu());
//        }
//        System.out.println();
//
//        System.out.print("韵母,");
//        for (Pinyin pinyin : pinyinList) {
//            System.out.printf("%s,", pinyin.getYunmu());
//        }
//        System.out.println();
//
//        System.out.print("输入法头,");
//        for (Pinyin pinyin : pinyinList) {
//            System.out.printf("%s,", pinyin.getHead());
//        }
//        System.out.println();


//        WordVectorModel wordVectorModel = trainOrLoadModel();
//        printNearest("中国", wordVectorModel);
//        printNearest("美丽", wordVectorModel);
//        printNearest("购买", wordVectorModel);

        // 文档向量
//        DocVectorModel docVectorModel = new DocVectorModel(new WordVectorModel("mrs.txt"));
//        String[] documents = new String[]{
//                "山东苹果丰收",
//                "农民在江苏种水稻",
//                "奥运会女排夺冠",
//                "世界锦标赛胜出",
//                "中国足球失败",
//        };
//
//        System.out.println(docVectorModel.similarity(documents[0], documents[1]));
//        System.out.println(docVectorModel.similarity(documents[0], documents[4]));
//
//        for (int i = 0; i < documents.length; i++)
//        {
//            docVectorModel.addDocument(i, documents[i]);
//        }
//        System.out.println(docVectorModel.similarity(documents[0], documents[1]));
//        System.out.println(docVectorModel.similarity(documents[0], documents[4]));

//        printNearestDocument("体育", documents, docVectorModel);
//        printNearestDocument("农业", documents, docVectorModel);
//        printNearestDocument("我要看比赛", documents, docVectorModel);
//        printNearestDocument("要不做饭吧", documents, docVectorModel);
//        System.out.println(NLPTokenizer.segment("我新造一个词叫幻想乡你能识别并标注正确词性吗？"));
//// 注意观察下面两个“希望”的词性、两个“晚霞”的词性
//        System.out.println(NLPTokenizer.analyze("我的希望是希望张晚霞的背影被晚霞映红").translateLabels());
//        System.out.println(NLPTokenizer.analyze("支援臺灣正體香港繁體：微软公司於1975年由比爾·蓋茲和保羅·艾倫創立。"));
//
    }
}

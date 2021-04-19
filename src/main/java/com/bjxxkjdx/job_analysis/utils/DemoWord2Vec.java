/*
 * <author>Hankcs</author>
 * <email>me@hankcs.com</email>
 * <create-date>2017-11-02 12:09</create-date>
 *
 * <copyright file="Demo.java" company="码农场">
 * Copyright (c) 2017, 码农场. All Right Reserved, http://www.hankcs.com/
 * This source is subject to Hankcs. Please contact Hankcs to get more information.
 * </copyright>
 */
package com.bjxxkjdx.job_analysis.utils;

//import com.hankcs.hanlp.corpus.MSR;

import com.hankcs.hanlp.corpus.io.IOUtil;
import com.hankcs.hanlp.mining.word2vec.DocVectorModel;
import com.hankcs.hanlp.mining.word2vec.Word2VecTrainer;
import com.hankcs.hanlp.mining.word2vec.WordVectorModel;
import com.spire.pdf.PdfDocument;
import com.spire.pdf.PdfPageBase;

import java.io.IOException;
import java.util.Map;

/**
 * 演示词向量的训练与应用
 *
 * @author hankcs
 */
public class DemoWord2Vec {
    private static final String TRAIN_FILE_NAME = "cutWord.txt";
    private static final String MODEL_FILE_NAME = "mrs.txt";

    public static void main(String[] args) throws IOException {
        WordVectorModel wordVectorModel = new WordVectorModel(MODEL_FILE_NAME);
//        printNearest("开发", wordVectorModel);
//        printNearest("程序员", wordVectorModel);
//        printNearest("项目", wordVectorModel);
//        System.out.println(wordVectorModel.similarity("独立", "完成"));
//        System.out.println(wordVectorModel.analogy("程序", "开发", "团队"));

        //        // 文档向量
        DocVectorModel docVectorModel = new DocVectorModel(wordVectorModel);
        String[] documents = new String[]{
                "岗位职责：  1.企业级数据安全产品，windows平台客户端相关组件开发维护 2.参与系统分析与设计，根据开发规范与流程完成模块的设计、编码、单元测试以及相关文档。任职资格：  1.本科及以上学历，计算机相关专业，1年以上实际项目开发经验；  2.精通C/C++，熟悉visual studio c++集成开发工具，熟练掌握常用的调试工具及调试方法；  3.熟练掌握多线程、Socket编程；  4.熟悉网络编程相关技术；  5.有信息安全产品开发经验或信息安全专业背景者优先；  6.需具备较强的学习能力和沟通能力，良好的团队合作精神； ",
                "职能类别：高级软件工程师软件工程师 关键字：windows核心岗位职责： 1、能够带领团队使用U3D进行客户端开发，安排和分配开发任务。 2、制作程序编程规范、核心架构搭建及技术攻关。 3、能够提出客户端开发过程中遇到疑难问题的解决方案。 4、能够带领团队推进项目进展，促进团队成长和公司技术积累。  ",
                "岗位要求： 1、3~5年U3D开发经验，至少1款成功上线游戏产品经验, 至少经历过一款成功上线游戏的完整开发过程，计算机相关专业本科及以上学历。 2、熟练使用Unity进行客户端研发，包括客户端架构搭建、维护、优化与调整。 3、能够解决研发过程中开发人员遇到的问题和困难。 4、熟悉渲染，物理，资源管理，性能分析等，对U3D组件系统有深刻的理解。 5、熟悉网络Socket、Http、TCP等。 6、熟悉U3D引擎渲染管线，能够快速定位和优化客户端效率问题。 7、具有优秀的沟通表达能力、资源协调能力、时间管理能力和团队管理能力。 8. 精通.net、C#语言及面向对象编程； 9. 熟悉Unity3D引擎架构，熟悉Unity3D渲染，资源管理，性能分析等模块，对Unity3D的 组件系统有着深入的理解； 10. 熟悉网络C# Socket编程或者Unity Socket编程, 有Socket/Http通信的协议实现和封装经验的优先； 11.有Unity3d webgl平台项目制作经验的优先考虑。 12.能写安卓程序、调用安卓底层实现与Unity通讯优先考虑。 13.有第三方流媒体（语音、视频）接入经验优先考虑。",
                "职能类别：Unity3d开发工程师高级软件工程师 关键字：U3DUnity3Dunity客户端游戏C#1.理解并熟练使用Spring+MyBatis进行开发。熟练使用Spring Cloud框架。对微服务有自己的理解，对服务拆分，服务治理有一定的思考。 2.熟悉关系型数据库MySQL等，有良好的模型抽象能力，理解并能合理使用索引，有SQL调优经验优先。熟练使用Elasticsearch。 3.熟练使用redis缓存，分布式锁。熟练使用RocketMQ等消息中间件。 4.熟悉elastic-job或相关调度框架，熟悉Zookeeper。 5.按照团队规范熟练使用git，gitlab. 6.有保险行业相关经验，有CRM系统的开发/设计经验优先。有高并发场景的处理经验。 7.了解服务容器化。使用过jenkins或其他CI等可持续集成工具。 职能类别：Java开发工程师高级软件工程师 关键字：java软件开发软件工程师开发软件工程师开发工程师java开发",
                "岗位职责： 1.负责研发公司应用软件的设计、开发和交付； 2.熟悉activiti工作流，有该方面的项目经验优先； 3.熟练使用spring、spring cloud开发，有过分布式事务管理等项目经验； 4.熟练应用vue,熟练进行freemarker模板开发，并能有效进行前后端整合；  5.熟悉数据库相关知识，能够熟练使用mysql数据库进行开发； 6.熟悉等机器学习、spark、es等大数据工具者优先，学习公司研发平台，并可独立进行研发并参与平台设计，并能有效的提出改进意见； 7.熟悉k8s、docker、ranchar、apollo等优先； 8.熟悉node、python等优先； 9.参与与其业务相关的需求变更评审，完成上级交代的方向性事务的推进落实； 10.编写技术设计文档，有良好的编码习惯，遵循团队开发规范和代码规范，并具备团队意识，带领团队其他成员进行研发； 11.攻克技术难题。  任职要求： 1．能适应国内外短期出差（不接受出差不考虑）； 2．刻苦，以学习新东西为乐趣，技术驱动； 3．喜欢挑战性的工作，并能承受较大压力； 4．性格开朗，喜欢人际交往，并能进行团队协作工作； 5．出差人员有餐补补贴和差旅报销； 6．公司提供餐补； 7．五险一金。   职能类别：高级软件工程师科技开发中心BIM开发人员", "招聘需求 招聘方向：BIM软件二次开发 人数：1人 学历要求：硕士研究生及以上 技能要求： 熟练掌握Windows平台开发，熟悉WPF界面设计及开发技术，拥有相应项目经验； 掌握C++、C#等编程语言，熟悉面向对象编程思想，了解常用设计模式； 了解Bentley Microstation使用及体系架构，从事过Bentley相关产品的二次开发者优先； 有较强的团队合作意识和良好的交流沟通能力。  职能类别：高级软件工程师C/C++开发工程师加入国内领先的数据库容器云平台核心开发团队！正在进行的项目有中国银联、建设银行、工商银行、浦发银行等。 ", "岗位职责   职位要求 1、基础扎实，熟悉常用数据结构和算法，熟悉REST API设计和开发； 2、熟练掌握Go语言，具备扎实的相关软件开发技能，对代码基本规范有清晰的认识，2年以上Go语言项目开发经验优先，能够基于Git进行团队合作项目开发； 3、有丰富的工作经验，能够独立主导要求对自己做的项目有自己深入的理解，并能持续的关注和优化自己做的项目，研究过优秀开源软件的源码并有心得者优先； 4、熟悉 MySQL, Redis或MongoDB(任何一种)； 5、熟悉TCP/IP，HTTP协议，包括但不限于RPC、MQ、缓存技术、调用策略等；熟悉Protobuf/JSON序列化协议； 6、熟悉 Etcd、Consul、Docker 等开源软件，熟悉分布式系统架构设计， 有Kubenetes 相关开发经验优先； 7、有Github等博客作品者优先。 职能类别：软件工程师高级软件工程师 关键字：GolangGO语言开发工程师",
                "后端开发1、协助项目经理开展团队管理，负责部分任务的需求分析、设计； 2、根据需求规格说明书、原型界面及设计文档负责自己承担模块的详细设计和代码编写、单元测试； 3、负责已开发模块的测试及维护；负责对测试人员反馈的测试结果，进行bug修改和代码完善； 4、参与相关技术文档、用户手册的编写。 5、沟通能力强，性格开朗，做事积极主动。  技能要求： 1、具备3年实际开发或管理团队的经验或者承担过项目组长的角色，具备良好的沟通能力，做事认真责任心强，性格开朗，计算机相关专业毕业； 2、熟悉java,JSP,JavaScript等开发语言，精通HTML，XML，CSS等超文本标记语言，熟悉AJAX，Web Service开发； 3、熟悉MVC架构模式和J2EE设计模式，熟练掌握struts,hibernate,spring框架； 4、熟悉SQL语法及oracle、mysql或sql server数据库应用开发。 职能类别：高级软件工程师Java开发工程师 关键字：软件开发java开发工程师", "岗位职责  1、参与功能模块的需求分析；  2、编写功能模块的概要设计文档；  3、功能模块的代码编写；  4、对已有的产品功能模块进行升级和维护。    任职资格  1、计算机软件及相关专业本科学历及以上，基础扎实，3年以上开发经验；  2、精通Java或者C/C++，熟悉nginx、mysql、memcached、shell脚本，有代码控制力，能自测和自己上线到Linux生产环境，有数据库性能优化经验；  3、有清晰的设计思路和良好的代码习惯，掌握面向对象编程思想，熟悉HTML/CSS/Javascript开发更佳；  4、曾参与过“优信二手车、汽车之家、瓜子二手车、壁虎、优联保、车车车”等相关行业的开发、或有车险相关的项目经验者优先，可适当降低入职要求  5、善于沟通和逻辑表达，主动思考，跟产品人员讨论需求能提出部分更优意见，团队协作时能灵活补位，具有较强的协调推动能力。 职能类别：高级软件工程师 关键字：java开发、车险", "岗位职责： 1.独立完成整体系统分析、设计，并主导完成详细设计、编码、文档任务，确保项目的进度和质量； 2.负责前后端核心功能的框架与代码编写，开发与维护系统核心模块，包括应用系统前后端、数据可视化，并协助完部署及调试工作； 3.负责逻辑模型设计、系统框架的搭建，并对架构、功能、性能进行持续优化； 4.项目管理，客户沟通协调、进度管理，质量控制 5.系统上线部署组织与协调，已上线系统应用故障排查、BUG修复、运维支持； 6.对相关技术的跟踪、研究和学习。  任职资格： 1.计算机或相关专业本科学历或以上，三年以上java软件开发经验； 2.JAVA基础扎实,理解io、多线程、集合等基础框架,熟悉JVM工作原理 3.熟练掌握Spring boot、Spring Clound、Mybatis等开发框架，熟悉Redis、Memcached、RabbitMQ、ActiveMQ、Kafka、Dubbo中的3项以上的技术，并有实战经验； 4.熟练掌握Vue前端框架； 5.熟练掌握Oracle or mySql至少一种； 6.熟悉Linux系统的常用命令和开发环境，熟悉Tomcat、Nginx等常用配置； 7.具备较强的团队沟通和协作能力，较强的自我驱动能力,具备良好的抗压能力，能主动承担并解决问题，能处理紧急情况和复杂问题； 8.有金融资管类系统研发经验优先； 职能类别：高级软件工程师",
                "Java开发工程师 关键字：Java高级开发工程师1、国内外知名院校全日制统招本科及以上学历，且学历证、学位证双证齐全； 2、计算机、信息安全、通信、数学、地球物理、自动化、仪器仪表、电气、热能、动力、石油勘探、油气储运、信息管理与信息系统、管理类等相关专业； 3、本科通过英语四级，研究生通过英语六级； 4、毕业时间：2019年9月1日至2020年8月30日。  职能类别：高级软件工程师1、计算机、电子信息工程、自动化等相关专业本科/硕士学历； 2.2年以上硬件原理图设计以及PCB设计经验； 3.熟悉模拟电路基础，如二三极管、运放、线性电源、开关电源； 4.熟悉FPGA外围构成、接口协议、工作原理，了解并掌握Verilog或者VHDL； 5.熟悉ADC、DAC性能及测试方法； 6.熟悉USB3.0、PCIE等高速总线硬件设计及驱动开发； 7.掌握高速PCB的信号完整性以及电源完整性分析； 8.熟练使用Cadence/designer等EDA工具； 9.能熟练使用万用表、示波器、频谱分析仪等设备进行硬件调试；  优先要求（非必须）： 1、有华为海思3559A或赛灵思ZYNQ使用和开发经验者优先； 2、有上位机程序开发经验者优先； 3、熟悉linux系统，并能够进行系统定制和裁剪者优先； 4、对神经网络在嵌入式上部署感兴趣者优先。  职能类别：高级软件工程师工作地点：北京 薪资：7到9K/年底双薪/五险一金 专业要求：电气工程/经济管理/信息管理/计算机科学、软件工程类专业。  ",
                "岗位职责： 1、理解业务需求，按照需求设计文档，实现业务模块代码编制； 2、设计系统，攻克各种技术难点，给出各种技术解决方案； 3、进行系统单元测试、集成测试； 4、进行系统的部署工作。 任职资格： 1.本科或以上学历，CET-4级及以上。 2.电气自动化、计算机科学、软件工程类等相关专业。 3.对互联网技术具有浓厚兴趣。 4.熟悉springboot,spring cloude, mybatis, ES, docker ,nginx, rabbitmq、gitlab, mysql技能者优先。 实习机会：公司提供实习岗位，毕业前可到岗实习。 职业方向：技术经理、系统架构师。 职能类别：高级软件工程师数据仓库工程师 关键字：java开发大数据微服务前端开发电力信息化软件开发岗位描述： 如果你对基础技术感兴趣，你可以参与基础软件的设计、开发和维护，如分布式文件系统、缓存系统、Key/Value存储系统、数据库、Linux操作系统等； 如果你热衷于高性能分布式技术，你可以参与世界***规模的分布式服务端程序的系统设计，为阿里巴巴的产品提供强有力的后台支持，在海量的网络访问和数据处理中，设计并设施最强大的解决方案； 如果你喜欢研究搜索技术，你可以参与搜索引擎各个功能模块的设计和实现，构建高可靠性、高可用性、高可扩展性的体系结构，满足日趋复杂的业务需求； 如果你对电子商务产品技术感兴趣，你可以参与产品的开发和维护，完成从需求到设计、开发和上线等整个项目周期内的工作； 如果你热衷于客户端开发，你可以参与为用户提供丰富且有价值的桌面或无线软件产品。",
                "岗位要求： 或许，你来自计算机专业，机械专业，甚至可能是学生物的， 但是，你酷爱着计算机以及互联网技术，热衷于解决挑战性的问题。 或许，你痴迷于数据结构和算法，热衷于ACM，常常为看到“accept”而兴奋的手足舞蹈； 或许，你熟悉Unix/Linux/Win32环境下编程，并有相关开发经验，熟练使用调试工具，并熟悉某种脚本语言； 或许，你熟悉网络编程和多线程编程，对TCP/IP，HTTP等网络协议有很深的理解； 或许，你享受底层技术，在kernel的源代码中纵横驰骋； 或许，你并不熟悉C，C++，但是你不畏挑战，喜欢钻研，能够用你亮眼的成果证明自己超强的学习能力； 或许，你参加过大学生数学建模竞赛，“挑战杯”，机器人足球比赛等； 或许，你在学校的时候作为骨干参与学生网站的建设和开发； 但是，这些都是我们想要的。 职能类别：高级软件工程师",
                "岗位职责：  1、负责软件代码设计、开发、单元测试和变更维护; 2、根据开发规范与流程完成系统设计、编码、测试以及相关文档的编写； 3、主流程代码设计、编码工作；  任职要求：  1、统招本科及以上学历，有2年以上java开发经验； 2、有Struts、Hibernate、Spring开发经验； 2、熟练掌握Oracle、SqlServer、Mysql等数据库其中一种； 3、了解Weblogic、Jboss、Tomcat等应用服务器的使用； 4、熟悉面向对象分析方法，熟悉常用设计模式； 5、熟悉Html、JavaScript、CSS、Ajax等WEB前端技术； 职能类别：软件工程师高级软件工程师工作职责： 1、进行战术数据链网络协议研究与方案验证，对相关协议和算法进行仿真和实现； 2、跟踪国际和国内民用通信、战术通信技术发展方向，重点关注网络层、接入层技术发展动态，对关键技术进行预研。 任职要求： 1、硕士需三年以上、博士需一年以上相关工作经验； 2、有扎实的计算机网络原理知识和无线通信基本原理知识； 3、具备良好的文档编写能力； 4、具备良好的英文科技文献查阅能力； 5、熟悉常见的网络协议原理，如TCP/IP协议、RIP/OSPF协议、DSDV/AODV协议、CSMA/TDMA协议等，熟练使用NS2、OPNET、QUALNET、OMNET++任一仿真软件； 6、有LINK16、LINK22、TTNT等数据链相关研究经验者优先； 7、对民用4G、5G网络技术、接入技术深入研究者优先。  职能类别：高级软件工程师系统架构设计师称：后台开发（开发） ",
                "岗位职责： a、对需求采集人员给出的需求，设计后台的功能实现 b、为前台提供功能调用，完成和前台的数据交互设计 c、依据需求设计和优化数据库表及数据结构 d、依据业务需求和变化，优化现有系统后台功能。优化系统性能，不断提升系统的健壮性 ",
                "岗位要求： 1. 精通 Java 技术栈相关技术，精通 OOP/设计模式，有移动互联网架构如移动网关，微服务化等经验者优先；  2. 熟悉 MySQL 数据库设计和优化，熟悉缓存技术，如 Redis 等；  3. 对 OOA\\OOD\\OOP 等思想有深入的理解以及很强的应用能力，具有较强的业务需求分析能力；  4. 具备良好的识别和设计通用框架及模块的能力；  5. 计算机或相关专业本科以上学历；  6. 具有优良的代码书写规范；  7. 主观能动性强、善与人沟通、责任心强、具有团队合作精神；    加分项  1. 熟悉基本的 shell 命令者优先；  2. 有 Linux 环境开发经验者优先；  3. 熟悉 http，https, websocket 等应用协议,熟练使用 extjs 或 vue 框架；  4. 有过大规模互联网系统架构设计经验者优先；  5. 有 OA、CRM、ERP 系统开发经验优先；  6. 有 Paas 开发经验者优先  职能类别：软件工程师高级软件工程师 关键字：软件软件开发工程师计算机开发技术支持互联网职位描述 1、参与需求分析和设计 2、按照公司规范编制高质量代码 3、按照公司规范对代码进行单元测试，保证交付代码质量 4、编写相关技术文档 5、开发项目核心功能 6、指导初级工程师开发工作", " 任职要求： 1、3年以上JAVA开发经验 2、熟悉SpringBoot和MyBatis等常用框架 3、熟悉缓存机制，了解消息队列的使用 4、熟悉多线程 5、熟练使用MySQL 6、熟悉Tomcat服务器，对项目的打包部署、服务器性能优化有一定了解 7、参与过大型复杂分布式互联网 WEB 系统的设计开发者优先 8、有Kafka，Redis，MongoDB等使用经验者优先 9、熟悉ServiceCombo/Spring Cloud/Docker/K8S或其他服务治理架构者优先  职能类别：高级软件工程师Java开发工程师 关键字：java软件开发软件工程师java开发1. 负责按照国内运营商、GSMA等规范开发智能卡操作系统； 2. 负责智能卡相关的软件产品的支持、维护，评估应用条件及风险； 3. 负责基于智能卡技术的安全方案设计与实现； 4. 针对现有产品，设计优化应用方案，并开展应用调试、检测流程设计； 5. 跟进挖掘研究和应用新兴尖端技术，负责产品应用功能设计及应用场景设计。 ",
                "任职要求： 1. 电子、自动化、计算机相关专业硕士以上学历；有5年以上JAVA卡系统开发或智能卡开发经验； 2. 熟练掌握Java、C等基础编程语言，具有良好的编码风格； 3. 熟悉运营商、GSMA规范、GP规范、JavaCard规范，具有Java、GP相关功能开发调试经验； 4. 熟悉CA认证技术、openSSL、TPM技术，上位机技术、linux系统联调、具有相关的开发经验； 5. 熟悉GSMA、ETSI相关规范；有系统或硬件开发背景者优先； 6. 工作积极主动，具有较强的创新意识和学习能力以及团队协作精神； 7. 可根据客户场景/需求进行应用方案的设计开发。 职能类别：高级软件工程师Java开发工程师2、 负责系统的架构设计和系统设计、详细设计； 3、 主导技术难题攻关，指导开发人员； 4、 解决系统开发、运行中出现的各种问题； 5、 参与项目详细需求评审、设计评审和代码评审； 6、 根据公司质控要求负责系统架构的质量保障。"
        };
        for (int i = 0; i < documents.length; i++) {
            docVectorModel.addDocument(i, documents[i]);
        }
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
        for (String name : d) {
//            PdfDocument pdf = new PdfDocument("计科1703简历/" + name);
            PdfDocument pdf = new PdfDocument("陈星-java开发工程师.pdf");

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
            }
            pdf.close();
            System.out.println(sb.toString());
            for (String doc : documents) {
                System.out.println(docVectorModel.similarity(sb.toString(), doc));
//                System.out.println(docVectorModel.similarity(sb.toString(), documents[1]));
//                System.out.println(docVectorModel.similarity(sb.toString(), documents[2]));
            }
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            break;
//            System.out.println(docVectorModel.similarity(documents[0], documents[1]));
//            System.out.println(docVectorModel.similarity(documents[0], documents[2]));
//            System.out.println(docVectorModel.similarity(documents[1], documents[1]));
        }

//        PdfDocument pdf = new PdfDocument("example.pdf");
//        StringBuilder sb = new StringBuilder();
//        PdfPageBase page;
//        for (int i = 0; i < pdf.getPages().getCount(); i++) {
//            page = pdf.getPages().get(i);
//            //调用extractText()方法提取文本
//            sb.append(page.extractText(true));
//        }
//        pdf.close();


//        printNearestDocument("性格开朗", documents, docVectorModel);
//        printNearestDocument("算法工程师", documents, docVectorModel);
//        printNearestDocument("我会写程序", documents, docVectorModel);
//        printNearestDocument("有两年以上java开发经验", documents, docVectorModel);
    }

    static void printNearest(String word, WordVectorModel model) {
        System.out.printf("\n                                                Word     Cosine\n------------------------------------------------------------------------\n");
        for (Map.Entry<String, Float> entry : model.nearest(word)) {
            System.out.printf("%50s\t\t%f\n", entry.getKey(), entry.getValue());
        }
    }

    static void printNearestDocument(String document, String[] documents, DocVectorModel model) {
        printHeader(document);
        for (Map.Entry<Integer, Float> entry : model.nearest(document)) {
            System.out.printf("%50s\t\t%f\n", documents[entry.getKey()], entry.getValue());
        }
    }

    private static void printHeader(String query) {
        System.out.printf("\n%50s          Cosine\n------------------------------------------------------------------------\n", query);
    }

    static WordVectorModel trainOrLoadModel() throws IOException {
        if (!IOUtil.isFileExisted(MODEL_FILE_NAME)) {
            if (!IOUtil.isFileExisted(TRAIN_FILE_NAME)) {
                System.err.println("语料不存在，请阅读文档了解语料获取与格式：https://github.com/hankcs/HanLP/wiki/word2vec");
                System.exit(1);
            }
            Word2VecTrainer trainerBuilder = new Word2VecTrainer();
            return trainerBuilder.train(TRAIN_FILE_NAME, MODEL_FILE_NAME);
        }

        return loadModel();
    }

    static WordVectorModel loadModel() throws IOException {
        return new WordVectorModel(MODEL_FILE_NAME);
    }
}

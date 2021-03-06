-- MySQL dump 10.13  Distrib 8.0.23, for osx10.15 (x86_64)
--
-- Host: 127.0.0.1    Database: 51jobs
-- ------------------------------------------------------
-- Server version	8.0.23

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `dataStruct`
--

DROP TABLE IF EXISTS `dataStruct`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dataStruct` (
id int auto_increment,
	constraint table_name_pk
		primary key (id)  `jobName` char(20) NOT NULL,
  `name` char(20) NOT NULL,
  `value` char(11) NOT NULL,
  `pushDate` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dataStruct`
--

LOCK TABLES `dataStruct` WRITE;
/*!40000 ALTER TABLE `dataStruct` DISABLE KEYS */;
INSERT INTO `dataStruct` (`jobName`, `name`, `value`, `pushDate`) VALUES ('android','杭州','20',NULL),('android','福州','3',NULL),('android','泉州','1',NULL),('android','邯郸','1',NULL),('android','南京','11',NULL),('android','重庆','5',NULL),('android','北京','50',NULL),('android','嘉兴','2',NULL),('android','上海','41',NULL),('android','昆明','1',NULL),('android','南充','1',NULL),('android','肇庆','1',NULL),('android','成都','5',NULL),('android','长沙','2',NULL),('android','惠州','1',NULL),('android','苏州','9',NULL),('android','厦门','5',NULL),('android','石家庄','1',NULL),('android','天津','1',NULL),('android','广州','26',NULL),('android','郑州','1',NULL),('android','无锡','3',NULL),('android','深圳','87',NULL),('android','宁波','1',NULL),('android','湖北','1',NULL),('android','合肥','6',NULL),('android','珠海','2',NULL),('android','大连','1',NULL),('android','武汉','6',NULL),('android','太原','1',NULL),('android','济南','2',NULL),('android','西安','6',NULL),('java','福州','3',NULL),('java','南京','11',NULL),('java','重庆','6',NULL),('java','北京','88',NULL),('java','嘉兴','1',NULL),('java','上海','64',NULL),('java','成都','10',NULL),('java','长沙','14',NULL),('java','苏州','4',NULL),('java','厦门','5',NULL),('java','石家庄','2',NULL),('java','天津','2',NULL),('java','广州','39',NULL),('java','郑州','9',NULL),('java','无锡','1',NULL),('java','深圳','54',NULL),('java','宁波','4',NULL),('java','贵阳','2',NULL),('java','合肥','1',NULL),('java','珠海','1',NULL),('java','青岛','2',NULL),('java','大连','1',NULL),('java','威海','1',NULL),('java','南昌','1',NULL),('java','武汉','7',NULL),('java','廊坊','1',NULL),('java','西安','3',NULL),('python','杭州','18',NULL),('python','福州','2',NULL),('python','南京','1',NULL),('python','徐州','1',NULL),('python','重庆','2',NULL),('python','上海','60',NULL),('python','成都','4',NULL),('python','长沙','2',NULL),('python','苏州','6',NULL),('python','天津','2',NULL),('python','广州','16',NULL),('python','郑州','2',NULL),('python','海口','1',NULL),('python','无锡','1',NULL),('python','深圳','38',NULL),('python','宁波','1',NULL),('python','合肥','1',NULL),('python','珠海','1',NULL),('python','青岛','7',NULL),('python','大连','1',NULL),('python','武汉','3',NULL),('python','西安','5',NULL),('web','福州','3',NULL),('web','南京','6',NULL),('web','重庆','2',NULL),('web','北京','43',NULL),('web','嘉兴','1',NULL),('web','上海','64',NULL),('web','沈阳','2',NULL),('web','温州','2',NULL),('web','成都','14',NULL),('web','长沙','3',NULL),('web','苏州','7',NULL),('web','南宁','3',NULL),('web','厦门','1',NULL),('web','东莞','1',NULL),('web','天津','1',NULL),('web','郑州','4',NULL),('web','无锡','1',NULL),('web','深圳','47',NULL),('web','宁波','6',NULL),('web','合肥','3',NULL),('web','青岛','3',NULL),('web','大连','3',NULL),('web','武汉','7',NULL),('web','太原','1',NULL),('web','济南','7',NULL),('web','萍乡','1',NULL),('web','西安','7',NULL),('测试','杭州','40',NULL),('测试','徐州','3',NULL),('测试','绍兴','1',NULL),('测试','佛山','1',NULL),('测试','嘉兴','4',NULL),('测试','上海','71',NULL),('测试','成都','14',NULL),('测试','惠州','2',NULL),('测试','苏州','19',NULL),('测试','东莞','7',NULL),('测试','天津','3',NULL),('测试','合肥','7',NULL),('测试','珠海','4',NULL),('测试','南昌','1',NULL),('测试','武汉','15',NULL),('测试','衡阳','1',NULL),('测试','西安','7',NULL),('测试','邯郸','1',NULL),('测试','南京','18',NULL),('测试','湖州','1',NULL),('测试','重庆','3',NULL),('测试','乌鲁木齐','2',NULL),('测试','北京','45',NULL),('测试','沈阳','1',NULL),('测试','常州','2',NULL),('测试','长沙','1',NULL),('测试','烟台','2',NULL),('测试','南宁','2',NULL),('测试','厦门','3',NULL),('测试','广州','21',NULL),('测试','郑州','3',NULL),('测试','无锡','2',NULL),('测试','深圳','72',NULL),('测试','贵阳','1',NULL),('测试','青岛','3',NULL),('测试','大连','1',NULL),('测试','威海','1',NULL),('测试','镇江','2',NULL),('网络工程师','南宁','3',NULL),('网络工程师','厦门','1',NULL),('网络工程师','东莞','1',NULL),('网络工程师','石家庄','2',NULL),('网络工程师','天津','1',NULL),('网络工程师','杭州','6',NULL),('网络工程师','福州','1',NULL),('网络工程师','广州','10',NULL),('网络工程师','泉州','1',NULL),('网络工程师','南京','4',NULL),('网络工程师','徐州','2',NULL),('网络工程师','荆州','1',NULL),('网络工程师','重庆','2',NULL),('网络工程师','无锡','1',NULL),('网络工程师','深圳','12',NULL),('网络工程师','北京','16',NULL),('网络工程师','佛山','2',NULL),('网络工程师','宁波','1',NULL),('网络工程师','青岛','2',NULL),('网络工程师','大连','2',NULL),('网络工程师','南昌','1',NULL),('网络工程师','上海','18',NULL),('网络工程师','武汉','2',NULL),('网络工程师','昆明','1',NULL),('网络工程师','成都','4',NULL),('网络工程师','长沙','3',NULL),('网络工程师','西安','2',NULL),('java','杭州','24',NULL),('web','广州','30',NULL),('web','杭州','24',NULL),('python','北京','47',NULL);
/*!40000 ALTER TABLE `dataStruct` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-04-28 14:35:21

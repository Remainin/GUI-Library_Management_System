-- MySQL dump 10.13  Distrib 5.5.52, for Win32 (x86)
--
-- Host: localhost    Database: bookdb
-- ------------------------------------------------------
-- Server version	5.5.52

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `author`
--

DROP TABLE IF EXISTS `author`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `author` (
  `AuthorID` smallint(5) unsigned NOT NULL DEFAULT '0',
  `Name` varchar(20) NOT NULL,
  `Age` smallint(5) unsigned DEFAULT NULL,
  `Country` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`AuthorID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `author`
--

LOCK TABLES `author` WRITE;
/*!40000 ALTER TABLE `author` DISABLE KEYS */;
INSERT INTO `author` VALUES (1,'奥巴马',40,'美国'),(2,'蔡英文',35,'中国'),(3,'普京',52,'俄罗斯'),(4,'马英九',40,'中国'),(5,'周玉',64,'中国'),(6,'帕克',37,'法国'),(7,'张茗帅',20,'中国'),(8,'阿德',35,'阿斯蒂芬'),(10,'坏人',19,'美国'),(11,'飞机',16,'意大利'),(15,'老邓',16,'日本'),(16,'宋梅',36,'中国');
/*!40000 ALTER TABLE `author` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `book`
--

DROP TABLE IF EXISTS `book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `book` (
  `ISBN` bigint(20) unsigned NOT NULL DEFAULT '0',
  `Title` varchar(30) NOT NULL,
  `AuthorID` smallint(5) unsigned NOT NULL,
  `Publisher` varchar(20) DEFAULT NULL,
  `PublishDate` date DEFAULT NULL,
  `Price` double(5,2) unsigned DEFAULT NULL,
  PRIMARY KEY (`ISBN`),
  KEY `AuthorID` (`AuthorID`),
  CONSTRAINT `book_ibfk_1` FOREIGN KEY (`AuthorID`) REFERENCES `author` (`AuthorID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book`
--

LOCK TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
INSERT INTO `book` VALUES (1000000001,'实现美国的伟大复兴',1,'美国教育出版社','2002-08-30',85.99),(1000000002,'何时回到祖国的怀抱',2,'台湾民进党出版社','2014-11-12',50.33),(1000000003,'竞选之路',2,'台湾民进党出版社','2016-09-12',33.33),(1000000004,'当总理的那些年',3,'俄罗斯铁人出版社','2007-03-21',120.99),(1000000005,'论与美国的持久战',3,'俄罗斯战争出版社','2010-05-01',99.99),(1000000006,'我的失败人生',4,'台湾自由出版社','2010-03-28',39.99),(1000000007,'我与工大的那一份情',5,'哈工大出版社','2011-08-01',45.66),(1000000008,'热力学传输理论',5,'高等教育出版社','2006-01-22',120.99),(1000000009,'我的篮球故事',6,'法国工业出版社','2011-04-01',45.79),(1000000010,'GDP传奇',6,'NBA出版社','2016-04-30',77.79),(1000000011,'我的童年',1,'美国农业出版社','2004-02-10',50.45),(1000000012,'小时候的事情',8,'哈哈出版社','2004-09-04',33.33),(1000000013,'我的假期如此之短',7,'痛苦出版社','2016-07-16',66.66);
/*!40000 ALTER TABLE `book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `borrow`
--

DROP TABLE IF EXISTS `borrow`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `borrow` (
  `snumber` varchar(10) NOT NULL,
  `isbn` bigint(20) NOT NULL,
  `day` int(11) DEFAULT NULL,
  `beginday` date DEFAULT NULL,
  `endday` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `borrow`
--

LOCK TABLES `borrow` WRITE;
/*!40000 ALTER TABLE `borrow` DISABLE KEYS */;
INSERT INTO `borrow` VALUES ('1140310606',1000000005,10,'2017-05-05','2017-05-15');
/*!40000 ALTER TABLE `borrow` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `house`
--

DROP TABLE IF EXISTS `house`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `house` (
  `hnumber` int(11) NOT NULL,
  `isbn` bigint(20) unsigned NOT NULL DEFAULT '0',
  `count` int(11) DEFAULT NULL,
  KEY `isbn` (`isbn`),
  CONSTRAINT `house_ibfk_1` FOREIGN KEY (`isbn`) REFERENCES `book` (`ISBN`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `house`
--

LOCK TABLES `house` WRITE;
/*!40000 ALTER TABLE `house` DISABLE KEYS */;
INSERT INTO `house` VALUES (1,1000000001,7),(1,1000000002,8),(1,1000000003,7),(2,1000000004,10),(2,1000000005,1),(2,1000000006,7),(2,1000000007,18),(2,1000000008,11),(2,1000000009,11),(3,1000000010,11),(3,1000000011,4),(3,1000000013,14),(4,1000000012,33);
/*!40000 ALTER TABLE `house` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `room`
--

DROP TABLE IF EXISTS `room`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `room` (
  `rnumber` int(11) NOT NULL,
  `isbn` bigint(20) unsigned NOT NULL DEFAULT '0',
  `floor` int(11) DEFAULT NULL,
  KEY `isbn` (`isbn`),
  CONSTRAINT `room_ibfk_1` FOREIGN KEY (`isbn`) REFERENCES `book` (`ISBN`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `room`
--

LOCK TABLES `room` WRITE;
/*!40000 ALTER TABLE `room` DISABLE KEYS */;
INSERT INTO `room` VALUES (103,1000000001,1),(102,1000000002,1),(202,1000000003,2),(202,1000000004,2),(212,1000000005,2),(212,1000000006,2),(315,1000000007,3),(315,1000000008,3),(407,1000000009,4),(407,1000000010,4),(407,1000000011,4),(538,1000000013,5),(538,1000000012,5);
/*!40000 ALTER TABLE `room` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student` (
  `snumber` varchar(10) NOT NULL,
  `sname` varchar(20) NOT NULL,
  `saddr` varchar(40) NOT NULL,
  PRIMARY KEY (`snumber`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES ('1140310606','张帅','吉林松原');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-01-04 14:19:11

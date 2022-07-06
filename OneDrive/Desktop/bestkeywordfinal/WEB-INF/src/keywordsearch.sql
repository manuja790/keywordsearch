-- MySQL dump 10.10
--
-- Host: localhost    Database: keywordsearch
-- ------------------------------------------------------
-- Server version	5.0.20-nt

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
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` int(2) NOT NULL auto_increment,
  `username` varchar(20) default NULL,
  `password` varchar(10) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin`
--


/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
LOCK TABLES `admin` WRITE;
INSERT INTO `admin` VALUES (1,'admin','admin');
UNLOCK TABLES;
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;

--
-- Table structure for table `efg`
--

DROP TABLE IF EXISTS `efg`;
CREATE TABLE `efg` (
  `id` int(11) NOT NULL auto_increment,
  `os` varchar(10) default NULL,
  `es` varchar(10) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `efg`
--


/*!40000 ALTER TABLE `efg` DISABLE KEYS */;
LOCK TABLES `efg` WRITE;
INSERT INTO `efg` VALUES (1,'60','90');
UNLOCK TABLES;
/*!40000 ALTER TABLE `efg` ENABLE KEYS */;

--
-- Table structure for table `hotels`
--

DROP TABLE IF EXISTS `hotels`;
CREATE TABLE `hotels` (
  `id` int(2) NOT NULL auto_increment,
  `hotelname` varchar(60) default NULL,
  `bar` varchar(10) default NULL,
  `restaurant` varchar(10) default NULL,
  `rooms` varchar(50) default NULL,
  `latitude` varchar(40) default NULL,
  `longitude` varchar(40) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `hotels`
--


/*!40000 ALTER TABLE `hotels` DISABLE KEYS */;
LOCK TABLES `hotels` WRITE;
INSERT INTO `hotels` VALUES (1,'Kallada Holiday Inn,Irinjalakuda','no','no','yes','10.3446664','76.20937149999997'),(2,'The Gateway Hotel Marine Drive Ernakulam','yes','no','no','9.9825798','76.27542749999998'),(3,'Fortune Hotel The South Park, Trivandrum','no','yes','no','8.5241391','76.93663760000004'),(4,'The Central Park Hotel,kollam','yes','no','yes','8.8932118','76.61413960000004'),(5,'Hotel Malabar Gate,kozhikode','yes','yes','no','11.2587531','75.78041000000007'),(6,'Hotel Ernad Inn,Malappuram','no','yes','yes','11.0731819','76.07399989999999'),(7,'Hotel Elite Palazzo,Angamaly','yes','yes','yes','10.1849092','76.37530459999994');
UNLOCK TABLES;
/*!40000 ALTER TABLE `hotels` ENABLE KEYS */;

--
-- Table structure for table `locationdetail`
--

DROP TABLE IF EXISTS `locationdetail`;
CREATE TABLE `locationdetail` (
  `lid` int(11) NOT NULL auto_increment,
  `location` varchar(50) default NULL,
  `keynames` varchar(50) default NULL,
  `star` varchar(10) default NULL,
  `fid` int(11) default NULL,
  PRIMARY KEY  (`lid`),
  KEY `fid` (`fid`),
  CONSTRAINT `locationdetail_ibfk_1` FOREIGN KEY (`fid`) REFERENCES `hotels` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `locationdetail`
--


/*!40000 ALTER TABLE `locationdetail` DISABLE KEYS */;
LOCK TABLES `locationdetail` WRITE;
INSERT INTO `locationdetail` VALUES (1,'Irinjalakuda','Hotel','3',1),(2,'Kochi','Hotel','4',2),(3,'Trivandrum','Hotel','5',3),(4,'kollam','Hotel','2',4),(5,'kozhikode','Hotel with bar','1',5),(6,'malappuram','Hotel','4',6),(7,'angamaly','Hotel,bar and restaurant','5',7);
UNLOCK TABLES;
/*!40000 ALTER TABLE `locationdetail` ENABLE KEYS */;

--
-- Table structure for table `register`
--

DROP TABLE IF EXISTS `register`;
CREATE TABLE `register` (
  `id` int(2) NOT NULL auto_increment,
  `username` varchar(20) default NULL,
  `firstname` varchar(30) default NULL,
  `lastname` varchar(30) default NULL,
  `password` varchar(10) default NULL,
  `gender` varchar(20) default NULL,
  `dob` varchar(10) default NULL,
  `email` varchar(30) default NULL,
  `phone` varchar(10) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `register`
--


/*!40000 ALTER TABLE `register` DISABLE KEYS */;
LOCK TABLES `register` WRITE;
INSERT INTO `register` VALUES (1,'achu','archana','m','achu','female','20-10-1993','archana123sam@gmail.com','2144'),(2,'vinod','vinod','venugopal','vinod','male','30/20/1552','fgdfg','32565436');
UNLOCK TABLES;
/*!40000 ALTER TABLE `register` ENABLE KEYS */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;


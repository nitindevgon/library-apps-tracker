CREATE DATABASE IF NOT EXISTS `web_library_db` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `web_library_db`;
-- MySQL dump 10.13  Distrib 5.6.13, for osx10.6 (i386)
--
-- Host: 127.0.0.1    Database: web_library_db
-- ------------------------------------------------------
-- Server version	5.6.16

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
-- Table structure for table `patrons`
--

DROP TABLE IF EXISTS `patrons`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `patrons` (
  `patron_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `address` varchar(200) NOT NULL,
  `email` varchar(45) NOT NULL,
  PRIMARY KEY (`patron_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;


/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patrons`
--

LOCK TABLES `patrons` WRITE;
/*!40000 ALTER TABLE `patrons` DISABLE KEYS */;
INSERT INTO `patrons` VALUES 
(1,'David','17 GREEANACRES AVE, ADELAIDE','david@nla.com.au'),
(2,'Adam','27 KLEMZIG AVE, ADELAIDE','adam@nla.com.au'),
(3,'Ajay','37 MAGILL AVE, ADELAIDE','ajay@nla.com.au'),
(4,'Bill','47 PLYMPTON AVE, ADELAIDE','bill@nla.com.au'),
(5,'Maxwell','57 PROSPECT AVE, ADELAIDE','max@nla.com.au');
/*!40000 ALTER TABLE `patrons` ENABLE KEYS */;
UNLOCK TABLES;

/******************************************************************/
DROP TABLE IF EXISTS `books`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `books` (
  `book_id` int(11) NOT NULL AUTO_INCREMENT,
  `book_title` varchar(45) NOT NULL,
  `book_author` varchar(200) NOT NULL,
  `book_isbn` varchar(45) NOT NULL,
  PRIMARY KEY (`book_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `books`
--

LOCK TABLES `books` WRITE;
/*!40000 ALTER TABLE `books` DISABLE KEYS */;
INSERT INTO `books` VALUES 
(1,'Oracle','Larry Ellison','978-3-16-148410-1'),
(2,'MySQL','D Kanetkar','978-3-16-148410-2'),
(3,'SQL SERVER','Deitel Harrison','978-3-16-148410-3'),
(4,'IBM DB2','Wilson John','978-3-16-148410-4'),
(5,'PostgreSQL','Robert Bates','978-3-16-148410-5');
/*!40000 ALTER TABLE `books` ENABLE KEYS */;
UNLOCK TABLES;


/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;



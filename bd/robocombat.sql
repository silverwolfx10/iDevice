CREATE DATABASE  IF NOT EXISTS `robocombat` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `robocombat`;
-- MySQL dump 10.13  Distrib 5.5.38, for debian-linux-gnu (x86_64)
--
-- Host: 127.0.0.1    Database: robocombat
-- ------------------------------------------------------
-- Server version	5.5.38-0ubuntu0.14.04.1

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
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cliente` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `telefone` varchar(20) DEFAULT NULL,
  `quantidade` int(11) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (1,'nome','email','11478222168',8,NULL),(2,'nome2','email2','54548548484',9,NULL),(3,'Nome','Email','11111111111',152151515,NULL),(4,'Nome','Email','11111111111',152151515,NULL),(5,'Nome','Email','11111111111',152151515,NULL),(6,'Nome','Email','11111111111',152151515,NULL),(7,'Nome','Email','11111111111',152151515,NULL),(8,'nome','email','mememe',1111,NULL),(9,'nomeHaha','emaiiilllssss','oioijijij',8,NULL),(10,'Noem','uhuihiuh','iuhiuhiuh',9959,NULL),(11,'Nome do Cliiiii','Emailll','8859595959',8800,NULL),(12,'nomelelekkk','emaillll','948484',9,NULL),(13,'nomelelekkk','emaillll','948484',9,NULL),(14,'nomelelekkk','emaillll','948484',9,NULL);
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `investidor`
--

DROP TABLE IF EXISTS `investidor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `investidor` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) DEFAULT NULL,
  `empresa` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `telefone` varchar(20) DEFAULT NULL,
  `proposta` float DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `investidor`
--

LOCK TABLES `investidor` WRITE;
/*!40000 ALTER TABLE `investidor` DISABLE KEYS */;
INSERT INTO `investidor` VALUES (1,'Nome do Investidor','Empresa','Email do investidor','1484848484',551551,NULL),(2,'neome','ubuiu','oijih','guygvuyg',55,'2014-10-15 17:51:09');
/*!40000 ALTER TABLE `investidor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'robocombat'
--

--
-- Dumping routines for database 'robocombat'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-10-15 17:55:22

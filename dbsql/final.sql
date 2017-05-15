-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: imaima
-- ------------------------------------------------------
-- Server version	5.7.16-log

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
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `account` (
  `accountID` int(11) NOT NULL AUTO_INCREMENT,
  `firstName` varchar(45) NOT NULL,
  `lastName` varchar(45) NOT NULL,
  `contactNo` bigint(11) NOT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  PRIMARY KEY (`accountID`),
  UNIQUE KEY `accountID_UNIQUE` (`accountID`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `accountcart`
--

DROP TABLE IF EXISTS `accountcart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `accountcart` (
  `accountID` int(11) NOT NULL,
  `cartID` int(11) NOT NULL,
  PRIMARY KEY (`accountID`,`cartID`),
  KEY `fk_account_has_cart_cart1_idx` (`cartID`),
  KEY `fk_account_has_cart_account1_idx` (`accountID`),
  CONSTRAINT `fk_account_has_cart_account1` FOREIGN KEY (`accountID`) REFERENCES `account` (`accountID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_account_has_cart_cart1` FOREIGN KEY (`cartID`) REFERENCES `cart` (`cartID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `address`
--

DROP TABLE IF EXISTS `address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `address` (
  `addressID` int(11) NOT NULL AUTO_INCREMENT,
  `accountID` int(11) NOT NULL,
  `Country` varchar(45) NOT NULL,
  `City` varchar(45) NOT NULL,
  `State` varchar(45) NOT NULL,
  `Street` varchar(45) NOT NULL,
  PRIMARY KEY (`addressID`),
  UNIQUE KEY `addressID_UNIQUE` (`addressID`),
  KEY `accountID_idx` (`accountID`),
  CONSTRAINT `accountID` FOREIGN KEY (`accountID`) REFERENCES `account` (`accountID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `admins`
--

DROP TABLE IF EXISTS `admins`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `admins` (
  `adminID` int(11) NOT NULL,
  PRIMARY KEY (`adminID`),
  UNIQUE KEY `adminID_UNIQUE` (`adminID`),
  CONSTRAINT `adminID` FOREIGN KEY (`adminID`) REFERENCES `account` (`accountID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cart`
--

DROP TABLE IF EXISTS `cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cart` (
  `cartID` int(11) NOT NULL AUTO_INCREMENT,
  `quantity` int(11) NOT NULL,
  `itemID` int(11) NOT NULL,
  PRIMARY KEY (`cartID`),
  UNIQUE KEY `cartID_UNIQUE` (`cartID`),
  KEY `userID_idx` (`cartID`),
  KEY `itemID_idx` (`itemID`),
  CONSTRAINT `itemID` FOREIGN KEY (`itemID`) REFERENCES `items` (`itemId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `category` (
  `categoryID` int(11) NOT NULL AUTO_INCREMENT,
  `categoryName` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`categoryID`),
  UNIQUE KEY `categoryID_UNIQUE` (`categoryID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `company`
--

DROP TABLE IF EXISTS `company`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `company` (
  `companyID` int(11) NOT NULL AUTO_INCREMENT,
  `companyName` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`companyID`),
  UNIQUE KEY `companyID_UNIQUE` (`companyID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `items`
--

DROP TABLE IF EXISTS `items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `items` (
  `itemId` int(11) NOT NULL AUTO_INCREMENT,
  `itemName` varchar(45) NOT NULL,
  `companyID` int(11) NOT NULL,
  `categoryID` int(11) NOT NULL,
  `stock` int(11) NOT NULL,
  `itemPrice` double NOT NULL,
  `salePrice` double DEFAULT NULL,
  `saleStart` datetime DEFAULT NULL,
  `saleEnd` datetime DEFAULT NULL,
  PRIMARY KEY (`itemId`),
  UNIQUE KEY `itemId_UNIQUE` (`itemId`),
  KEY `companyID_idx` (`companyID`),
  KEY `categoryID_idx` (`categoryID`),
  CONSTRAINT `categoryID` FOREIGN KEY (`categoryID`) REFERENCES `category` (`categoryID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `companyID` FOREIGN KEY (`companyID`) REFERENCES `company` (`companyID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `order`
--

DROP TABLE IF EXISTS `order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order` (
  `orderID` int(11) NOT NULL AUTO_INCREMENT,
  `userID` int(11) NOT NULL,
  `totalAmt` double NOT NULL,
  `orderStatus` varchar(45) NOT NULL,
  `orderDate` datetime NOT NULL,
  `shippingID` int(11) NOT NULL,
  `shipAddress` varchar(45) NOT NULL,
  PRIMARY KEY (`orderID`),
  UNIQUE KEY `orderID_UNIQUE` (`orderID`),
  KEY `userID_idx` (`userID`),
  KEY `shippingID_idx` (`shippingID`),
  CONSTRAINT `shippingID` FOREIGN KEY (`shippingID`) REFERENCES `shipping` (`shippingId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `userID` FOREIGN KEY (`userID`) REFERENCES `account` (`accountID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `order_details`
--

DROP TABLE IF EXISTS `order_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order_details` (
  `detailID` int(11) NOT NULL AUTO_INCREMENT,
  `orderID` int(11) NOT NULL,
  `itemID` int(11) NOT NULL,
  `qty` varchar(45) NOT NULL,
  PRIMARY KEY (`detailID`),
  UNIQUE KEY `detailID_UNIQUE` (`detailID`),
  KEY `orderID_idx` (`orderID`),
  CONSTRAINT `orderID` FOREIGN KEY (`orderID`) REFERENCES `order` (`orderID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `shipping`
--

DROP TABLE IF EXISTS `shipping`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shipping` (
  `shippingId` int(11) NOT NULL AUTO_INCREMENT,
  `shippingPrice` double NOT NULL,
  `shippingName` varchar(45) NOT NULL,
  `days` int(11) NOT NULL,
  PRIMARY KEY (`shippingId`),
  UNIQUE KEY `shippingId_UNIQUE` (`shippingId`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping events for database 'imaima'
--

--
-- Dumping routines for database 'imaima'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-04-10 21:05:22

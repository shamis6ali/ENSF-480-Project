-- MySQL dump 10.13  Distrib 8.0.27, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: Online_Rental
-- ------------------------------------------------------
-- Server version	8.0.27

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Landlord`
--

DROP TABLE IF EXISTS `Landlord`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Landlord` (
  `idLandlord` varchar(50) NOT NULL,
  `Name` varchar(100) DEFAULT NULL,
  `Password` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idLandlord`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Landlord`
--

LOCK TABLES `Landlord` WRITE;
/*!40000 ALTER TABLE `Landlord` DISABLE KEYS */;
INSERT INTO `Landlord` VALUES ('BlDy02','Bill Dipperly','dipperlyMAN2'),('MxBy01','Max Bay','Supersecretpassword'),('Rt7y48','Wilkson','somepass'),('SeTx03','Shingle Trax','TRAX!!pss'),('TmAe04','Tom Awesome','TGisnottheway1725'),('TyLJs05','Tray L Jonas','kgosnmelsd');
/*!40000 ALTER TABLE `Landlord` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Manager`
--

DROP TABLE IF EXISTS `Manager`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Manager` (
  `idManager` varchar(50) NOT NULL,
  `Name` varchar(100) DEFAULT NULL,
  `Username` varchar(45) DEFAULT NULL,
  `Password` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idManager`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Manager`
--

LOCK TABLES `Manager` WRITE;
/*!40000 ALTER TABLE `Manager` DISABLE KEYS */;
INSERT INTO `Manager` VALUES ('Jnsh01','John Smith','johnSmith','passWordjohn');
/*!40000 ALTER TABLE `Manager` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Messages`
--

DROP TABLE IF EXISTS `Messages`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Messages` (
  `Property_id` varchar(50) NOT NULL,
  `Email` varchar(100) DEFAULT NULL,
  `Message` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`Property_id`),
  CONSTRAINT `fk_Prop_id_1` FOREIGN KEY (`Property_id`) REFERENCES `Property` (`idProperty`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Messages`
--

LOCK TABLES `Messages` WRITE;
/*!40000 ALTER TABLE `Messages` DISABLE KEYS */;
/*!40000 ALTER TABLE `Messages` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Property`
--

DROP TABLE IF EXISTS `Property`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Property` (
  `idProperty` varchar(45) NOT NULL,
  `Landlord_id` varchar(50) DEFAULT NULL,
  `Apartment_type` varchar(45) DEFAULT NULL,
  `No_of_bedrooms` double DEFAULT NULL,
  `No_of_bathrooms` double DEFAULT NULL,
  `Furnished` int DEFAULT NULL,
  `Unfurnished` int DEFAULT NULL,
  `City_quadrant` varchar(10) DEFAULT NULL,
  `StatusP` varchar(15) NOT NULL,
  `Address` varchar(150) NOT NULL,
  `Day` int DEFAULT NULL,
  `Month` int DEFAULT NULL,
  `Year` int DEFAULT NULL,
  PRIMARY KEY (`idProperty`),
  KEY `fk_landlord_id_idx` (`Landlord_id`),
  CONSTRAINT `fk_landlord_id` FOREIGN KEY (`Landlord_id`) REFERENCES `Landlord` (`idLandlord`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Property`
--

LOCK TABLES `Property` WRITE;
/*!40000 ALTER TABLE `Property` DISABLE KEYS */;
INSERT INTO `Property` VALUES ('pqro05','BlDy02','Unattached House',3,3,1,0,'SW','Rented','3723 Ganges Road',5,12,2021),('pqro08','SeTx03','Apartment',1,1,0,1,'SW','Active','5786 Glenna Tunnel Apt. 279',25,11,2020),('prop01','MxBy01','Apartment',2,1.5,0,1,'SE','Active','2381 Milton Corner Suite 396',24,5,2020),('prop06','SeTx03','Apartment',4,3,0,1,'SE','Cancelled','850 Mayer Park Apt. 340',27,5,2019),('prop07','SeTx03','Bungalow',3,3,1,0,'NW','Active','4655 Craven Place ',19,4,2019),('prop10','TyLJs05','Unattached House',10,7.5,1,0,'SW','Active','412 Rich Grove Street',15,3,2021),('prop11','TyLJs05','Apartment',3,3.5,1,0,'NE','Active','137 Murphy Streets Apt. 977',4,8,2020),('prp02','MxBy01','Attached House',4,2,1,0,'NW','Active','2388 Tchesinkut Lake Rd',8,7,2021),('prpoq03','MxBy01','Townhouse',2,2.5,1,0,'SW','Active','765 Heritage Drive',6,9,2020),('prpoq09','TmAe04','Townhouse',2,2.5,1,0,'SW','Cancelled','1337 Awesome Street',9,9,2020),('prq04','BlDy02','Attached House',1,1,0,1,'NE','Active','1239 Bank St',7,5,2019);
/*!40000 ALTER TABLE `Property` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Property_amount`
--

DROP TABLE IF EXISTS `Property_amount`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Property_amount` (
  `Propertyid` varchar(45) NOT NULL,
  `Landlord_id` varchar(50) NOT NULL,
  `Amount` double DEFAULT NULL,
  `Period` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`Propertyid`,`Landlord_id`),
  KEY `fk_Property_amount_2_idx` (`Landlord_id`),
  CONSTRAINT `fk_Property_amount_1` FOREIGN KEY (`Propertyid`) REFERENCES `Property` (`idProperty`),
  CONSTRAINT `fk_Property_amount_2` FOREIGN KEY (`Landlord_id`) REFERENCES `Landlord` (`idLandlord`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Property_amount`
--

LOCK TABLES `Property_amount` WRITE;
/*!40000 ALTER TABLE `Property_amount` DISABLE KEYS */;
/*!40000 ALTER TABLE `Property_amount` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `RRenter`
--

DROP TABLE IF EXISTS `RRenter`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `RRenter` (
  `idRenter` varchar(50) NOT NULL,
  `Name` varchar(100) DEFAULT NULL,
  `Password` varchar(50) DEFAULT NULL,
  `Subscribe` int DEFAULT NULL,
  `Email` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`idRenter`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `RRenter`
--

LOCK TABLES `RRenter` WRITE;
/*!40000 ALTER TABLE `RRenter` DISABLE KEYS */;
INSERT INTO `RRenter` VALUES ('BgTs02','Big Tings','123456789',1,'somebody@gmail.com'),('NiTSs05','Naomi Teehee-Shillings','verynicepassword',1,'maybesomeone@gmail.com'),('RyJi03','Ray Joani','big123pass@',1,'xyz@yahoo.com'),('SzJz04','Suazz Juazz','paszzzz123',0,'abc@yahoo.com'),('TgTi01','Thang Thi','bigpassword123',0,'kfc@yahoo.com');
/*!40000 ALTER TABLE `RRenter` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Search_Criteria`
--

DROP TABLE IF EXISTS `Search_Criteria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Search_Criteria` (
  `idSearch` varchar(50) NOT NULL,
  `Apartment_type` varchar(45) DEFAULT NULL,
  `No_of_bedrooms` double DEFAULT NULL,
  `No_of_bathrooms` double DEFAULT NULL,
  `Furnished` int DEFAULT NULL,
  `Unfurnished` int DEFAULT NULL,
  `City_quadrant` varchar(10) DEFAULT NULL,
  `idRenter` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idSearch`),
  KEY `idRenter_idx` (`idRenter`),
  CONSTRAINT `idRenter_fk` FOREIGN KEY (`idRenter`) REFERENCES `RRenter` (`idRenter`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Search_Criteria`
--

LOCK TABLES `Search_Criteria` WRITE;
/*!40000 ALTER TABLE `Search_Criteria` DISABLE KEYS */;
INSERT INTO `Search_Criteria` VALUES ('s01','Apartment',2,0,1,0,'SW','TgTi01'),('s02','Any',0,3,1,1,'Any','BgTs02'),('s03','Townhouse',0,0,1,0,'SW','RyJi03'),('s04','Any',2,2,1,1,'NE','SzJz04'),('s05','Unattached ',0,3,0,1,'NW','NiTSs05');
/*!40000 ALTER TABLE `Search_Criteria` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-12-10 20:04:40

<<<<<<< HEAD
-- MySQL dump 10.13  Distrib 8.3.0, for macos14.2 (arm64)
--
-- Host: localhost    Database: Farm-In-Server
=======
-- MySQL dump 10.13  Distrib 8.0.34, for macos13 (arm64)
--
-- Host: 127.0.0.1    Database: Farm-In-Server
>>>>>>> 93c8a23ff01af8a88b0d4720bf024bde9a15dc32
-- ------------------------------------------------------
-- Server version	8.3.0

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
<<<<<<< HEAD
/*!50503 SET NAMES utf8mb4 */;
=======
/*!50503 SET NAMES utf8 */;
>>>>>>> 93c8a23ff01af8a88b0d4720bf024bde9a15dc32
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
<<<<<<< HEAD

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admin` (
  `admin_id` varchar(255) NOT NULL,
  `admin_pw` varchar(255) NOT NULL,
  PRIMARY KEY (`admin_id`,`admin_pw`),
  UNIQUE KEY `Admin_id_UNIQUE` (`admin_id`),
  UNIQUE KEY `admin_pw_UNIQUE` (`admin_pw`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES ('farmin','farmin230130*');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `boars_barn`
--

DROP TABLE IF EXISTS `boars_barn`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `boars_barn` (
  `farm_name` varchar(45) NOT NULL,
  `boars_barn_num` varchar(45) NOT NULL,
  `boars_barn_room_num` varchar(45) NOT NULL,
  PRIMARY KEY (`farm_name`,`boars_barn_num`,`boars_barn_room_num`),
  UNIQUE KEY `farm_name_UNIQUE` (`farm_name`),
  UNIQUE KEY `boars_barn_num_UNIQUE` (`boars_barn_num`),
  UNIQUE KEY `boars_barn_room_num_UNIQUE` (`boars_barn_room_num`),
  CONSTRAINT `boars_barn_room_num` FOREIGN KEY (`boars_barn_room_num`) REFERENCES `boars_room` (`boars_barn_room_num`),
  CONSTRAINT `Farm_name_1` FOREIGN KEY (`farm_name`) REFERENCES `farm_info` (`farm_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `boars_barn`
--

LOCK TABLES `boars_barn` WRITE;
/*!40000 ALTER TABLE `boars_barn` DISABLE KEYS */;
/*!40000 ALTER TABLE `boars_barn` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `boars_co2_sensor`
--

DROP TABLE IF EXISTS `boars_co2_sensor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `boars_co2_sensor` (
  `boars_barn_room_num` varchar(45) NOT NULL,
  `boars_co2_data` double NOT NULL,
  `boars_co2_input_time` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`boars_barn_room_num`),
  UNIQUE KEY `boars_barn_room_num_UNIQUE` (`boars_barn_room_num`),
  CONSTRAINT `boars_room_num_1` FOREIGN KEY (`boars_barn_room_num`) REFERENCES `boars_room` (`boars_barn_room_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `boars_co2_sensor`
--

LOCK TABLES `boars_co2_sensor` WRITE;
/*!40000 ALTER TABLE `boars_co2_sensor` DISABLE KEYS */;
/*!40000 ALTER TABLE `boars_co2_sensor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `boars_humidity_sensor`
--

DROP TABLE IF EXISTS `boars_humidity_sensor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `boars_humidity_sensor` (
  `boars_barn_room_num` varchar(45) NOT NULL,
  `boars_humidity_data` double NOT NULL,
  `boars_humidity_input_time` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`boars_barn_room_num`),
  UNIQUE KEY `boars_barn_room_num_UNIQUE` (`boars_barn_room_num`),
  CONSTRAINT `boars_room_num_3` FOREIGN KEY (`boars_barn_room_num`) REFERENCES `boars_room` (`boars_barn_room_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `boars_humidity_sensor`
--

LOCK TABLES `boars_humidity_sensor` WRITE;
/*!40000 ALTER TABLE `boars_humidity_sensor` DISABLE KEYS */;
/*!40000 ALTER TABLE `boars_humidity_sensor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `boars_nh3_sensor`
--

DROP TABLE IF EXISTS `boars_nh3_sensor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `boars_nh3_sensor` (
  `boars_baen_room_num` varchar(45) NOT NULL,
  `boars_nh3_data` double NOT NULL,
  `boars_nh3_input_time` datetime(6) DEFAULT NULL,
  `boars_barn_room_num` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`boars_baen_room_num`),
  UNIQUE KEY `boars_baen_room_num_UNIQUE` (`boars_baen_room_num`),
  CONSTRAINT `boars_barn_room_num_2` FOREIGN KEY (`boars_baen_room_num`) REFERENCES `boars_room` (`boars_barn_room_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `boars_nh3_sensor`
--

LOCK TABLES `boars_nh3_sensor` WRITE;
/*!40000 ALTER TABLE `boars_nh3_sensor` DISABLE KEYS */;
/*!40000 ALTER TABLE `boars_nh3_sensor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `boars_pm_sensor`
--

DROP TABLE IF EXISTS `boars_pm_sensor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `boars_pm_sensor` (
  `boars_barn_room_num` varchar(45) NOT NULL,
  `boars_pm1_data` double DEFAULT NULL,
  `boars_pm25_data` double DEFAULT NULL,
  `boars_pm10` double DEFAULT NULL,
  `boars_totalpm_data` double DEFAULT NULL,
  `boars_pm_input_time` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`boars_barn_room_num`),
  UNIQUE KEY `boars_barn_room_num_UNIQUE` (`boars_barn_room_num`),
  CONSTRAINT `boars_barn_room_num_5` FOREIGN KEY (`boars_barn_room_num`) REFERENCES `boars_room` (`boars_barn_room_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `boars_pm_sensor`
--

LOCK TABLES `boars_pm_sensor` WRITE;
/*!40000 ALTER TABLE `boars_pm_sensor` DISABLE KEYS */;
/*!40000 ALTER TABLE `boars_pm_sensor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `boars_room`
--

DROP TABLE IF EXISTS `boars_room`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `boars_room` (
  `boars_barn_num` varchar(45) NOT NULL,
  `boars_barn_room_num` varchar(45) NOT NULL,
  PRIMARY KEY (`boars_barn_num`,`boars_barn_room_num`),
  UNIQUE KEY `boars_barn_num_UNIQUE` (`boars_barn_num`),
  UNIQUE KEY `boars_barn_room_num_UNIQUE` (`boars_barn_room_num`),
  CONSTRAINT `boars_barn_num` FOREIGN KEY (`boars_barn_num`) REFERENCES `boars_barn` (`boars_barn_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `boars_room`
--

LOCK TABLES `boars_room` WRITE;
/*!40000 ALTER TABLE `boars_room` DISABLE KEYS */;
/*!40000 ALTER TABLE `boars_room` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `boars_temperature_sensor`
--

DROP TABLE IF EXISTS `boars_temperature_sensor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `boars_temperature_sensor` (
  `boars_barn_room_num` varchar(45) NOT NULL,
  `boars_temper_data` double NOT NULL,
  `boars_temper_input_time` datetime(6) DEFAULT NULL,
  `boars_temper_locate_data` bigint NOT NULL,
  PRIMARY KEY (`boars_barn_room_num`),
  UNIQUE KEY `boars_barn_room_num_UNIQUE` (`boars_barn_room_num`),
  CONSTRAINT `boars_room_name_4` FOREIGN KEY (`boars_barn_room_num`) REFERENCES `boars_room` (`boars_barn_room_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `boars_temperature_sensor`
--

LOCK TABLES `boars_temperature_sensor` WRITE;
/*!40000 ALTER TABLE `boars_temperature_sensor` DISABLE KEYS */;
/*!40000 ALTER TABLE `boars_temperature_sensor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `farm_info`
--

DROP TABLE IF EXISTS `farm_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `farm_info` (
  `farm_name` varchar(45) NOT NULL,
  PRIMARY KEY (`farm_name`),
  UNIQUE KEY `farm_name_UNIQUE` (`farm_name`),
  CONSTRAINT `Farm_Name` FOREIGN KEY (`farm_name`) REFERENCES `user` (`farm_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `farm_info`
--

LOCK TABLES `farm_info` WRITE;
/*!40000 ALTER TABLE `farm_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `farm_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `finishing_co2_sensor`
--

DROP TABLE IF EXISTS `finishing_co2_sensor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `finishing_co2_sensor` (
  `finishing_room_num` varchar(45) NOT NULL,
  `finishing_co2_data` double NOT NULL,
  `finishing_co2_input_time` datetime(6) DEFAULT NULL,
  `finishing_barn_room_num` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`finishing_room_num`),
  UNIQUE KEY `finishing_room_num_UNIQUE` (`finishing_room_num`),
  CONSTRAINT `finising_room_num_1` FOREIGN KEY (`finishing_room_num`) REFERENCES `finishing_room` (`finishing_room_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `finishing_co2_sensor`
--

LOCK TABLES `finishing_co2_sensor` WRITE;
/*!40000 ALTER TABLE `finishing_co2_sensor` DISABLE KEYS */;
/*!40000 ALTER TABLE `finishing_co2_sensor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `finishing_humidity_sensor`
--

DROP TABLE IF EXISTS `finishing_humidity_sensor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `finishing_humidity_sensor` (
  `finishing_room_num` varchar(45) NOT NULL,
  `finishing_humidity_data` double NOT NULL,
  `finishing_humidity_input_data` varchar(45) DEFAULT NULL,
  `finishing_barn_room_num` varchar(255) DEFAULT NULL,
  `finishing_humidity_input_time` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`finishing_room_num`),
  UNIQUE KEY `finishing_room_num_UNIQUE` (`finishing_room_num`),
  CONSTRAINT `finishing_room_num_3` FOREIGN KEY (`finishing_room_num`) REFERENCES `finishing_room` (`finishing_room_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `finishing_humidity_sensor`
--

LOCK TABLES `finishing_humidity_sensor` WRITE;
/*!40000 ALTER TABLE `finishing_humidity_sensor` DISABLE KEYS */;
/*!40000 ALTER TABLE `finishing_humidity_sensor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `finishing_nh3_sensor`
--

DROP TABLE IF EXISTS `finishing_nh3_sensor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `finishing_nh3_sensor` (
  `finishing_room_num` varchar(45) NOT NULL,
  `finishing_nh3_data` double NOT NULL,
  `finishing_nh3_input_time` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`finishing_room_num`),
  UNIQUE KEY `finishing_room_num_UNIQUE` (`finishing_room_num`),
  CONSTRAINT `finising_room_num_2` FOREIGN KEY (`finishing_room_num`) REFERENCES `finishing_room` (`finishing_room_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `finishing_nh3_sensor`
--

LOCK TABLES `finishing_nh3_sensor` WRITE;
/*!40000 ALTER TABLE `finishing_nh3_sensor` DISABLE KEYS */;
/*!40000 ALTER TABLE `finishing_nh3_sensor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `finishing_pen`
--

DROP TABLE IF EXISTS `finishing_pen`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `finishing_pen` (
  `farm_name` varchar(45) NOT NULL,
  `finishing_pen_num` varchar(45) NOT NULL,
  `finishing_pen_room_num` varchar(45) NOT NULL,
  PRIMARY KEY (`finishing_pen_num`,`finishing_pen_room_num`),
  UNIQUE KEY `farm_name_UNIQUE` (`farm_name`),
  UNIQUE KEY `finishing_pen_num_UNIQUE` (`finishing_pen_num`),
  UNIQUE KEY `finishing_pen_room_num_UNIQUE` (`finishing_pen_room_num`),
  CONSTRAINT `Farm_name_7` FOREIGN KEY (`farm_name`) REFERENCES `farm_info` (`farm_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `finishing_pen`
--

LOCK TABLES `finishing_pen` WRITE;
/*!40000 ALTER TABLE `finishing_pen` DISABLE KEYS */;
/*!40000 ALTER TABLE `finishing_pen` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `finishing_pm_sensor`
--

DROP TABLE IF EXISTS `finishing_pm_sensor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `finishing_pm_sensor` (
  `finishing_room_num` varchar(45) NOT NULL,
  `finishing_pm1_data` double DEFAULT NULL,
  `finishing_pm25_data` double DEFAULT NULL,
  `finishing_pm10_data` double DEFAULT NULL,
  `finishing_pm_total_data` double DEFAULT NULL,
  `finishing_pm_input_time` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`finishing_room_num`),
  UNIQUE KEY `finishing_room_num_UNIQUE` (`finishing_room_num`),
  CONSTRAINT `finishing_room_num_5` FOREIGN KEY (`finishing_room_num`) REFERENCES `finishing_room` (`finishing_room_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `finishing_pm_sensor`
--

LOCK TABLES `finishing_pm_sensor` WRITE;
/*!40000 ALTER TABLE `finishing_pm_sensor` DISABLE KEYS */;
/*!40000 ALTER TABLE `finishing_pm_sensor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `finishing_room`
--

DROP TABLE IF EXISTS `finishing_room`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `finishing_room` (
  `finishing_pen_num` varchar(45) NOT NULL,
  `finishing_room_num` varchar(45) NOT NULL,
  PRIMARY KEY (`finishing_pen_num`,`finishing_room_num`),
  UNIQUE KEY `finishing_pen_num_UNIQUE` (`finishing_pen_num`),
  UNIQUE KEY `finishing_room_num_UNIQUE` (`finishing_room_num`),
  CONSTRAINT `finishing_pen_num` FOREIGN KEY (`finishing_pen_num`) REFERENCES `finishing_pen` (`finishing_pen_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `finishing_room`
--

LOCK TABLES `finishing_room` WRITE;
/*!40000 ALTER TABLE `finishing_room` DISABLE KEYS */;
/*!40000 ALTER TABLE `finishing_room` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `finishing_temperature_sensor`
--

DROP TABLE IF EXISTS `finishing_temperature_sensor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `finishing_temperature_sensor` (
  `finishing_room_num` varchar(45) NOT NULL,
  `finishing_temper_data` varchar(45) DEFAULT NULL,
  `finishing_temper_input_time` varchar(45) DEFAULT NULL,
  `finishing_temper_locate_data` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`finishing_room_num`),
  UNIQUE KEY `finishing_room_num_UNIQUE` (`finishing_room_num`),
  CONSTRAINT `finishing_room_num_4` FOREIGN KEY (`finishing_room_num`) REFERENCES `finishing_room` (`finishing_room_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `finishing_temperature_sensor`
--

LOCK TABLES `finishing_temperature_sensor` WRITE;
/*!40000 ALTER TABLE `finishing_temperature_sensor` DISABLE KEYS */;
/*!40000 ALTER TABLE `finishing_temperature_sensor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gestation_co2_sensor`
--

DROP TABLE IF EXISTS `gestation_co2_sensor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `gestation_co2_sensor` (
  `gestation_room_num` varchar(45) NOT NULL,
  `gestation_co2_data` double NOT NULL,
  `gestation_co2_input_time` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`gestation_room_num`),
  UNIQUE KEY `gestation_room_num_UNIQUE` (`gestation_room_num`),
  CONSTRAINT `gestation_room_num_1` FOREIGN KEY (`gestation_room_num`) REFERENCES `gestation_room` (`gestation_room_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gestation_co2_sensor`
--

LOCK TABLES `gestation_co2_sensor` WRITE;
/*!40000 ALTER TABLE `gestation_co2_sensor` DISABLE KEYS */;
/*!40000 ALTER TABLE `gestation_co2_sensor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gestation_crate`
--

DROP TABLE IF EXISTS `gestation_crate`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `gestation_crate` (
  `farm_name` varchar(45) NOT NULL,
  `gestation_crate_num` varchar(45) NOT NULL,
  `gestation_crate_room_num` varchar(45) NOT NULL,
  PRIMARY KEY (`farm_name`,`gestation_crate_num`,`gestation_crate_room_num`),
  UNIQUE KEY `gestation_crate_room_num_UNIQUE` (`gestation_crate_room_num`),
  UNIQUE KEY `gestation_crate_num_UNIQUE` (`gestation_crate_num`),
  UNIQUE KEY `farm_name_UNIQUE` (`farm_name`),
  CONSTRAINT `Farm_name_3` FOREIGN KEY (`farm_name`) REFERENCES `farm_info` (`farm_name`),
  CONSTRAINT `gestation_create_room_num` FOREIGN KEY (`gestation_crate_room_num`) REFERENCES `gestation_room` (`gestation_room_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gestation_crate`
--

LOCK TABLES `gestation_crate` WRITE;
/*!40000 ALTER TABLE `gestation_crate` DISABLE KEYS */;
/*!40000 ALTER TABLE `gestation_crate` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gestation_humidity_sensor`
--

DROP TABLE IF EXISTS `gestation_humidity_sensor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `gestation_humidity_sensor` (
  `gestation_room_num` varchar(45) NOT NULL,
  `gestation_humidity_data` double NOT NULL,
  `gestation_humidity_input_time` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`gestation_room_num`),
  UNIQUE KEY `gestation_room_num_UNIQUE` (`gestation_room_num`),
  CONSTRAINT `gestation_room_num_3` FOREIGN KEY (`gestation_room_num`) REFERENCES `gestation_room` (`gestation_room_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gestation_humidity_sensor`
--

LOCK TABLES `gestation_humidity_sensor` WRITE;
/*!40000 ALTER TABLE `gestation_humidity_sensor` DISABLE KEYS */;
/*!40000 ALTER TABLE `gestation_humidity_sensor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gestation_nh3_sensor`
--

DROP TABLE IF EXISTS `gestation_nh3_sensor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `gestation_nh3_sensor` (
  `gestation_room_num` varchar(45) NOT NULL,
  `gestation_nh3_data` double NOT NULL,
  `gestation_nh3_input_time` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`gestation_room_num`),
  UNIQUE KEY `gestation_room_num_UNIQUE` (`gestation_room_num`),
  CONSTRAINT `gestation_room_num_2` FOREIGN KEY (`gestation_room_num`) REFERENCES `gestation_room` (`gestation_room_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gestation_nh3_sensor`
--

LOCK TABLES `gestation_nh3_sensor` WRITE;
/*!40000 ALTER TABLE `gestation_nh3_sensor` DISABLE KEYS */;
/*!40000 ALTER TABLE `gestation_nh3_sensor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gestation_pm_sensor`
--

DROP TABLE IF EXISTS `gestation_pm_sensor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `gestation_pm_sensor` (
  `gestation_room_num` varchar(45) NOT NULL,
  `gestation_pm1_data` double DEFAULT NULL,
  `gestation_pm25_data` double DEFAULT NULL,
  `gestation_pm10_data` double DEFAULT NULL,
  `gestation_pm_total` double DEFAULT NULL,
  `gestation_pm_input_time` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`gestation_room_num`),
  UNIQUE KEY `gestation_room_num_UNIQUE` (`gestation_room_num`),
  CONSTRAINT `gestation_room_num_5` FOREIGN KEY (`gestation_room_num`) REFERENCES `gestation_room` (`gestation_room_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gestation_pm_sensor`
--

LOCK TABLES `gestation_pm_sensor` WRITE;
/*!40000 ALTER TABLE `gestation_pm_sensor` DISABLE KEYS */;
/*!40000 ALTER TABLE `gestation_pm_sensor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gestation_room`
--

DROP TABLE IF EXISTS `gestation_room`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `gestation_room` (
  `gestation_room_num` varchar(45) NOT NULL,
  `gestation_create_num` varchar(45) NOT NULL,
  PRIMARY KEY (`gestation_room_num`,`gestation_create_num`),
  UNIQUE KEY `gestation_create_num_UNIQUE` (`gestation_create_num`),
  UNIQUE KEY `gestation_room_num_UNIQUE` (`gestation_room_num`),
  CONSTRAINT `gestation_create_num` FOREIGN KEY (`gestation_create_num`) REFERENCES `gestation_crate` (`gestation_crate_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gestation_room`
--

LOCK TABLES `gestation_room` WRITE;
/*!40000 ALTER TABLE `gestation_room` DISABLE KEYS */;
/*!40000 ALTER TABLE `gestation_room` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gestation_temperature`
--

DROP TABLE IF EXISTS `gestation_temperature`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `gestation_temperature` (
  `gestation_room_num` varchar(45) NOT NULL,
  `gestation_temper_data` double NOT NULL,
  `gestation_temper_input_time` datetime(6) DEFAULT NULL,
  `gestation_temper_locate` varchar(45) DEFAULT NULL,
  `gestation_temper_locate_data` bigint NOT NULL,
  PRIMARY KEY (`gestation_room_num`),
  UNIQUE KEY `gestation_room_num_UNIQUE` (`gestation_room_num`),
  CONSTRAINT `gestation_room_num_4` FOREIGN KEY (`gestation_room_num`) REFERENCES `gestation_room` (`gestation_room_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gestation_temperature`
--

LOCK TABLES `gestation_temperature` WRITE;
/*!40000 ALTER TABLE `gestation_temperature` DISABLE KEYS */;
/*!40000 ALTER TABLE `gestation_temperature` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `growing_barn`
--

DROP TABLE IF EXISTS `growing_barn`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `growing_barn` (
  `farm_name` varchar(45) NOT NULL,
  `growing_barn_num` varchar(45) NOT NULL,
  `growing_barn_room_num` varchar(45) NOT NULL,
  PRIMARY KEY (`farm_name`,`growing_barn_num`,`growing_barn_room_num`),
  UNIQUE KEY `farm_name_UNIQUE` (`farm_name`),
  UNIQUE KEY `growing_barn_num_UNIQUE` (`growing_barn_num`),
  KEY `Growing_rooom_num_idx` (`growing_barn_room_num`),
  CONSTRAINT `Farm_name_6` FOREIGN KEY (`farm_name`) REFERENCES `farm_info` (`farm_name`),
  CONSTRAINT `Growing_rooom_num` FOREIGN KEY (`growing_barn_room_num`) REFERENCES `growing_room_num` (`growing_room_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `growing_barn`
--

LOCK TABLES `growing_barn` WRITE;
/*!40000 ALTER TABLE `growing_barn` DISABLE KEYS */;
/*!40000 ALTER TABLE `growing_barn` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `growing_co2_sensor`
--

DROP TABLE IF EXISTS `growing_co2_sensor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `growing_co2_sensor` (
  `growing_room_num` varchar(45) NOT NULL,
  `growing_co2_data` double NOT NULL,
  `growing_co2_input_time` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`growing_room_num`),
  UNIQUE KEY `growing_room_num_UNIQUE` (`growing_room_num`),
  CONSTRAINT `growing_room_num_1` FOREIGN KEY (`growing_room_num`) REFERENCES `growing_room_num` (`growing_room_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `growing_co2_sensor`
--

LOCK TABLES `growing_co2_sensor` WRITE;
/*!40000 ALTER TABLE `growing_co2_sensor` DISABLE KEYS */;
/*!40000 ALTER TABLE `growing_co2_sensor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `growing_humidity_sensor`
--

DROP TABLE IF EXISTS `growing_humidity_sensor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `growing_humidity_sensor` (
  `growing_room_num` varchar(45) NOT NULL,
  `growing_humidity_data` double NOT NULL,
  `growing_humidity_input_time` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`growing_room_num`),
  UNIQUE KEY `growing_room_num_UNIQUE` (`growing_room_num`),
  CONSTRAINT `growing_room_num_3` FOREIGN KEY (`growing_room_num`) REFERENCES `growing_room_num` (`growing_room_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `growing_humidity_sensor`
--

LOCK TABLES `growing_humidity_sensor` WRITE;
/*!40000 ALTER TABLE `growing_humidity_sensor` DISABLE KEYS */;
/*!40000 ALTER TABLE `growing_humidity_sensor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `growing_nh3_sensor`
--

DROP TABLE IF EXISTS `growing_nh3_sensor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `growing_nh3_sensor` (
  `growing_room_num` varchar(45) NOT NULL,
  `growing_nh3_data` double NOT NULL,
  `growing_nh3_input_time` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`growing_room_num`),
  UNIQUE KEY `growing_room_num_UNIQUE` (`growing_room_num`),
  CONSTRAINT `growing_room_num_2` FOREIGN KEY (`growing_room_num`) REFERENCES `growing_room_num` (`growing_room_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `growing_nh3_sensor`
--

LOCK TABLES `growing_nh3_sensor` WRITE;
/*!40000 ALTER TABLE `growing_nh3_sensor` DISABLE KEYS */;
/*!40000 ALTER TABLE `growing_nh3_sensor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `growing_pm_sensor`
--

DROP TABLE IF EXISTS `growing_pm_sensor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `growing_pm_sensor` (
  `growing_room_num` varchar(45) NOT NULL,
  `growing_pm1_data` double DEFAULT NULL,
  `growing_pm25_data` double DEFAULT NULL,
  `growing_pm10_data` double DEFAULT NULL,
  `growing_pm_total` double DEFAULT NULL,
  `growing_pm_input_time` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`growing_room_num`),
  UNIQUE KEY `growing_room_num_UNIQUE` (`growing_room_num`),
  CONSTRAINT `growing_room_num_5` FOREIGN KEY (`growing_room_num`) REFERENCES `growing_room_num` (`growing_room_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `growing_pm_sensor`
--

LOCK TABLES `growing_pm_sensor` WRITE;
/*!40000 ALTER TABLE `growing_pm_sensor` DISABLE KEYS */;
/*!40000 ALTER TABLE `growing_pm_sensor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `growing_room_num`
--

DROP TABLE IF EXISTS `growing_room_num`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `growing_room_num` (
  `growing_barn_num` varchar(45) NOT NULL,
  `growing_room_num` varchar(45) NOT NULL,
  PRIMARY KEY (`growing_barn_num`,`growing_room_num`),
  UNIQUE KEY `growing_barn_num_UNIQUE` (`growing_barn_num`),
  UNIQUE KEY `growing_room_num_UNIQUE` (`growing_room_num`),
  CONSTRAINT `Growing_barn` FOREIGN KEY (`growing_barn_num`) REFERENCES `growing_barn` (`growing_barn_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `growing_room_num`
--

LOCK TABLES `growing_room_num` WRITE;
/*!40000 ALTER TABLE `growing_room_num` DISABLE KEYS */;
/*!40000 ALTER TABLE `growing_room_num` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `growing_temperature_sensor`
--

DROP TABLE IF EXISTS `growing_temperature_sensor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `growing_temperature_sensor` (
  `growing_room_num` varchar(45) NOT NULL,
  `growing_temper_data` double NOT NULL,
  `growing_temper_input_time` datetime(6) DEFAULT NULL,
  `growing_temper_locate` varchar(45) DEFAULT NULL,
  `growing_temper_locate_data` bigint NOT NULL,
  PRIMARY KEY (`growing_room_num`),
  UNIQUE KEY `growing_room_num_UNIQUE` (`growing_room_num`),
  CONSTRAINT `growing_room_num_4` FOREIGN KEY (`growing_room_num`) REFERENCES `growing_room_num` (`growing_room_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `growing_temperature_sensor`
--

LOCK TABLES `growing_temperature_sensor` WRITE;
/*!40000 ALTER TABLE `growing_temperature_sensor` DISABLE KEYS */;
/*!40000 ALTER TABLE `growing_temperature_sensor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `maternity_barn`
--

DROP TABLE IF EXISTS `maternity_barn`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `maternity_barn` (
  `farm_name` varchar(45) NOT NULL,
  `maternity_barn_num` varchar(45) NOT NULL,
  `maternity_barn_room_num` varchar(45) NOT NULL,
  PRIMARY KEY (`farm_name`,`maternity_barn_num`,`maternity_barn_room_num`),
  UNIQUE KEY `farm_name_UNIQUE` (`farm_name`),
  UNIQUE KEY `maternity_barn_num_UNIQUE` (`maternity_barn_num`),
  UNIQUE KEY `maternity_barn_name_UNIQUE` (`maternity_barn_room_num`),
  CONSTRAINT `farm_name_4` FOREIGN KEY (`farm_name`) REFERENCES `farm_info` (`farm_name`),
  CONSTRAINT `Maternity_rooom_num` FOREIGN KEY (`maternity_barn_room_num`) REFERENCES `maternity_room` (`maternity_barn_room_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `maternity_barn`
--

LOCK TABLES `maternity_barn` WRITE;
/*!40000 ALTER TABLE `maternity_barn` DISABLE KEYS */;
/*!40000 ALTER TABLE `maternity_barn` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `maternity_co2_sensor`
--

DROP TABLE IF EXISTS `maternity_co2_sensor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `maternity_co2_sensor` (
  `maternity_room_num` varchar(45) NOT NULL,
  `maternity_co2_data` double NOT NULL,
  `maternity_co2_input_data` varchar(45) DEFAULT NULL,
  `maternity_co2_input_time` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`maternity_room_num`),
  UNIQUE KEY `maternity_room_num_UNIQUE` (`maternity_room_num`),
  CONSTRAINT `maternity_room_num_1` FOREIGN KEY (`maternity_room_num`) REFERENCES `maternity_room` (`maternity_barn_room_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `maternity_co2_sensor`
--

LOCK TABLES `maternity_co2_sensor` WRITE;
/*!40000 ALTER TABLE `maternity_co2_sensor` DISABLE KEYS */;
/*!40000 ALTER TABLE `maternity_co2_sensor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `maternity_humidity_sensor`
--

DROP TABLE IF EXISTS `maternity_humidity_sensor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `maternity_humidity_sensor` (
  `maternity_room_num` varchar(45) NOT NULL,
  `maternity_humidity_data` double NOT NULL,
  `maternity_humidity_input_time` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`maternity_room_num`),
  UNIQUE KEY `maternity_room_num_UNIQUE` (`maternity_room_num`),
  CONSTRAINT `maternity_room_num_2` FOREIGN KEY (`maternity_room_num`) REFERENCES `maternity_room` (`maternity_barn_room_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `maternity_humidity_sensor`
--

LOCK TABLES `maternity_humidity_sensor` WRITE;
/*!40000 ALTER TABLE `maternity_humidity_sensor` DISABLE KEYS */;
/*!40000 ALTER TABLE `maternity_humidity_sensor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `maternity_nh3_sensor`
--

DROP TABLE IF EXISTS `maternity_nh3_sensor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `maternity_nh3_sensor` (
  `maternity_room_num` varchar(45) NOT NULL,
  `maternity_nh3_data` double NOT NULL,
  `maternity_nh3_input_time` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`maternity_room_num`),
  UNIQUE KEY `meternity_room_num_UNIQUE` (`maternity_room_num`),
  CONSTRAINT `maternity_room_num_3` FOREIGN KEY (`maternity_room_num`) REFERENCES `maternity_room` (`maternity_barn_room_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `maternity_nh3_sensor`
--

LOCK TABLES `maternity_nh3_sensor` WRITE;
/*!40000 ALTER TABLE `maternity_nh3_sensor` DISABLE KEYS */;
/*!40000 ALTER TABLE `maternity_nh3_sensor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `maternity_pm_sensor`
--

DROP TABLE IF EXISTS `maternity_pm_sensor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `maternity_pm_sensor` (
  `maternity_room_num` varchar(45) NOT NULL,
  `maternity_pm1_data` double DEFAULT NULL,
  `maeternity_pm25_data` double DEFAULT NULL,
  `maeternity_pm10_data` double DEFAULT NULL,
  `maternity_pm_total_data` double DEFAULT NULL,
  `maternity_pm_input_time` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`maternity_room_num`),
  UNIQUE KEY `meternity_room_num_UNIQUE` (`maternity_room_num`),
  CONSTRAINT `maternity_room_num_5` FOREIGN KEY (`maternity_room_num`) REFERENCES `maternity_room` (`maternity_barn_room_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `maternity_pm_sensor`
--

LOCK TABLES `maternity_pm_sensor` WRITE;
/*!40000 ALTER TABLE `maternity_pm_sensor` DISABLE KEYS */;
/*!40000 ALTER TABLE `maternity_pm_sensor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `maternity_room`
--

DROP TABLE IF EXISTS `maternity_room`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `maternity_room` (
  `maternity_barn_num` varchar(45) NOT NULL,
  `maternity_barn_room_num` varchar(45) NOT NULL,
  PRIMARY KEY (`maternity_barn_num`,`maternity_barn_room_num`),
  UNIQUE KEY `maternity_barn_num_UNIQUE` (`maternity_barn_num`),
  UNIQUE KEY `maternity_barn_room_num_UNIQUE` (`maternity_barn_room_num`),
  CONSTRAINT `Maternity_Barn` FOREIGN KEY (`maternity_barn_num`) REFERENCES `maternity_barn` (`maternity_barn_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `maternity_room`
--

LOCK TABLES `maternity_room` WRITE;
/*!40000 ALTER TABLE `maternity_room` DISABLE KEYS */;
/*!40000 ALTER TABLE `maternity_room` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `maternity_temperature_sensor`
--

DROP TABLE IF EXISTS `maternity_temperature_sensor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `maternity_temperature_sensor` (
  `maternity_room_num` varchar(45) NOT NULL,
  `maternity_temper_data` double NOT NULL,
  `maternity_temper_input_time` datetime(6) DEFAULT NULL,
  `maternity_temper_locate` varchar(45) DEFAULT NULL,
  `maternity_barn_room_num` varchar(255) DEFAULT NULL,
  `maternity_temper_locate_data` bigint NOT NULL,
  PRIMARY KEY (`maternity_room_num`),
  UNIQUE KEY `meternity_room_num_UNIQUE` (`maternity_room_num`),
  CONSTRAINT `maternity_room_num_4` FOREIGN KEY (`maternity_room_num`) REFERENCES `maternity_room` (`maternity_barn_room_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `maternity_temperature_sensor`
--

LOCK TABLES `maternity_temperature_sensor` WRITE;
/*!40000 ALTER TABLE `maternity_temperature_sensor` DISABLE KEYS */;
/*!40000 ALTER TABLE `maternity_temperature_sensor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `piglet_co2_sensor`
--

DROP TABLE IF EXISTS `piglet_co2_sensor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `piglet_co2_sensor` (
  `piglet_pen_room_num` varchar(45) NOT NULL,
  `piglet_co2_data` double NOT NULL,
  `piglet_co2_input_time` datetime(6) DEFAULT NULL,
  `piglet_room_num` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`piglet_pen_room_num`),
  UNIQUE KEY `piglet_pen_room_num_UNIQUE` (`piglet_pen_room_num`),
  CONSTRAINT `piglet_pen_room_num_1` FOREIGN KEY (`piglet_pen_room_num`) REFERENCES `piglet_pen_room` (`piglet_pen_room_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `piglet_co2_sensor`
--

LOCK TABLES `piglet_co2_sensor` WRITE;
/*!40000 ALTER TABLE `piglet_co2_sensor` DISABLE KEYS */;
/*!40000 ALTER TABLE `piglet_co2_sensor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `piglet_humidity_sensor`
--

DROP TABLE IF EXISTS `piglet_humidity_sensor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `piglet_humidity_sensor` (
  `piglet_pen_room_num` varchar(45) NOT NULL,
  `piglet_humidity_data` double NOT NULL,
  `piglet_humidity_input_time` datetime(6) DEFAULT NULL,
  `piglet_room_num` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`piglet_pen_room_num`),
  UNIQUE KEY `piglet_pen_room_num_UNIQUE` (`piglet_pen_room_num`),
  CONSTRAINT `piglet_pen_room_num_3` FOREIGN KEY (`piglet_pen_room_num`) REFERENCES `piglet_pen_room` (`piglet_pen_room_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `piglet_humidity_sensor`
--

LOCK TABLES `piglet_humidity_sensor` WRITE;
/*!40000 ALTER TABLE `piglet_humidity_sensor` DISABLE KEYS */;
/*!40000 ALTER TABLE `piglet_humidity_sensor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `piglet_nh3_sensor`
--

DROP TABLE IF EXISTS `piglet_nh3_sensor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `piglet_nh3_sensor` (
  `piglet_pen_room_num` varchar(45) NOT NULL,
  `piglet_nh3_data` double NOT NULL,
  `piglet_nh3_input_time` datetime(6) DEFAULT NULL,
  `piglet_room_num` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`piglet_pen_room_num`),
  UNIQUE KEY `piglet_pen_room_num_UNIQUE` (`piglet_pen_room_num`),
  CONSTRAINT `piglet_pen_room_num_2` FOREIGN KEY (`piglet_pen_room_num`) REFERENCES `piglet_pen_room` (`piglet_pen_room_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `piglet_nh3_sensor`
--

LOCK TABLES `piglet_nh3_sensor` WRITE;
/*!40000 ALTER TABLE `piglet_nh3_sensor` DISABLE KEYS */;
/*!40000 ALTER TABLE `piglet_nh3_sensor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `piglet_pen`
--

DROP TABLE IF EXISTS `piglet_pen`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `piglet_pen` (
  `farm_name` varchar(45) NOT NULL,
  `piglet_pen_num` varchar(45) NOT NULL,
  `piglet_pen_room_num` varchar(45) NOT NULL,
  PRIMARY KEY (`farm_name`,`piglet_pen_num`,`piglet_pen_room_num`),
  UNIQUE KEY `piglet_pen_room_num_UNIQUE` (`piglet_pen_room_num`),
  UNIQUE KEY `piglet_pen_num_UNIQUE` (`piglet_pen_num`),
  UNIQUE KEY `farm_name_UNIQUE` (`farm_name`),
  CONSTRAINT `Farm_name_5` FOREIGN KEY (`farm_name`) REFERENCES `farm_info` (`farm_name`),
  CONSTRAINT `Piglet_Pen_Room` FOREIGN KEY (`piglet_pen_room_num`) REFERENCES `piglet_pen_room` (`piglet_pen_room_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `piglet_pen`
--

LOCK TABLES `piglet_pen` WRITE;
/*!40000 ALTER TABLE `piglet_pen` DISABLE KEYS */;
/*!40000 ALTER TABLE `piglet_pen` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `piglet_pen_room`
--

DROP TABLE IF EXISTS `piglet_pen_room`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `piglet_pen_room` (
  `piglet_pen_num` varchar(45) NOT NULL,
  `piglet_pen_room_num` varchar(45) NOT NULL,
  PRIMARY KEY (`piglet_pen_num`,`piglet_pen_room_num`),
  UNIQUE KEY `piglet_pen_num_UNIQUE` (`piglet_pen_num`),
  UNIQUE KEY `piglet_pen_room_num_UNIQUE` (`piglet_pen_room_num`),
  CONSTRAINT `piglet_pen_num` FOREIGN KEY (`piglet_pen_num`) REFERENCES `piglet_pen` (`piglet_pen_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `piglet_pen_room`
--

LOCK TABLES `piglet_pen_room` WRITE;
/*!40000 ALTER TABLE `piglet_pen_room` DISABLE KEYS */;
/*!40000 ALTER TABLE `piglet_pen_room` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `piglet_pm_sensor`
--

DROP TABLE IF EXISTS `piglet_pm_sensor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `piglet_pm_sensor` (
  `piglet_pen_room_num` varchar(45) NOT NULL,
  `piglet_pm1_data` double DEFAULT NULL,
  `piglet_pm25_data` double DEFAULT NULL,
  `piglet_pm10_data` double DEFAULT NULL,
  `piglet_pm_total_data` double DEFAULT NULL,
  `piglet_pm_input_time` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`piglet_pen_room_num`),
  UNIQUE KEY `piglet_pen_room_num_UNIQUE` (`piglet_pen_room_num`),
  CONSTRAINT `piglet_pen_room_num_5` FOREIGN KEY (`piglet_pen_room_num`) REFERENCES `piglet_pen_room` (`piglet_pen_room_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `piglet_pm_sensor`
--

LOCK TABLES `piglet_pm_sensor` WRITE;
/*!40000 ALTER TABLE `piglet_pm_sensor` DISABLE KEYS */;
/*!40000 ALTER TABLE `piglet_pm_sensor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `piglet_temperature_sensor`
--

DROP TABLE IF EXISTS `piglet_temperature_sensor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `piglet_temperature_sensor` (
  `piglet_pen_room_num` varchar(45) NOT NULL,
  `piglet_temper_data` double NOT NULL,
  `piglet_temper_input_time` datetime(6) DEFAULT NULL,
  `piglet_temper_locate` varchar(45) DEFAULT NULL,
  `piglet_room_num` varchar(255) DEFAULT NULL,
  `piglet_temper_locate_data` bigint NOT NULL,
  PRIMARY KEY (`piglet_pen_room_num`),
  UNIQUE KEY `piglet_pen_room_num_UNIQUE` (`piglet_pen_room_num`),
  CONSTRAINT `piglet_pen_room_num_4` FOREIGN KEY (`piglet_pen_room_num`) REFERENCES `piglet_pen_room` (`piglet_pen_room_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `piglet_temperature_sensor`
--

LOCK TABLES `piglet_temperature_sensor` WRITE;
/*!40000 ALTER TABLE `piglet_temperature_sensor` DISABLE KEYS */;
/*!40000 ALTER TABLE `piglet_temperature_sensor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reserve_co2_sensor`
--

DROP TABLE IF EXISTS `reserve_co2_sensor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reserve_co2_sensor` (
  `reserve_sows_room_num` varchar(45) NOT NULL,
  `reserve_co2_data` double NOT NULL,
  `reserve_co2_input_time` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`reserve_sows_room_num`),
  UNIQUE KEY `reserve_sows_room_UNIQUE` (`reserve_sows_room_num`),
  CONSTRAINT `reserve_sows_room_num_1` FOREIGN KEY (`reserve_sows_room_num`) REFERENCES `reserve_sows_room` (`reserve_sows_room_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reserve_co2_sensor`
--

LOCK TABLES `reserve_co2_sensor` WRITE;
/*!40000 ALTER TABLE `reserve_co2_sensor` DISABLE KEYS */;
/*!40000 ALTER TABLE `reserve_co2_sensor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reserve_humidity_sensor`
--

DROP TABLE IF EXISTS `reserve_humidity_sensor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reserve_humidity_sensor` (
  `reserve_sows_room_num` varchar(45) NOT NULL,
  `reserve_humidity_data` double NOT NULL,
  `reserve_humidity_input_time` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`reserve_sows_room_num`),
  UNIQUE KEY `ireserve_sows_humidity_sensor_UNIQUE` (`reserve_sows_room_num`),
  CONSTRAINT `reserve_sows_room_num_3` FOREIGN KEY (`reserve_sows_room_num`) REFERENCES `reserve_sows_room` (`reserve_sows_room_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reserve_humidity_sensor`
--

LOCK TABLES `reserve_humidity_sensor` WRITE;
/*!40000 ALTER TABLE `reserve_humidity_sensor` DISABLE KEYS */;
/*!40000 ALTER TABLE `reserve_humidity_sensor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reserve_nh3_sensor`
--

DROP TABLE IF EXISTS `reserve_nh3_sensor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reserve_nh3_sensor` (
  `reserve_sows_room_num` varchar(45) NOT NULL,
  `reserve_nh3_data` double NOT NULL,
  `reserve_nh3_input_time` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`reserve_sows_room_num`),
  UNIQUE KEY `reserve_sows_room_num_UNIQUE` (`reserve_sows_room_num`),
  CONSTRAINT `reserve_sows_room_num_2` FOREIGN KEY (`reserve_sows_room_num`) REFERENCES `reserve_sows_room` (`reserve_sows_room_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reserve_nh3_sensor`
--

LOCK TABLES `reserve_nh3_sensor` WRITE;
/*!40000 ALTER TABLE `reserve_nh3_sensor` DISABLE KEYS */;
/*!40000 ALTER TABLE `reserve_nh3_sensor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reserve_sows_barn`
--

DROP TABLE IF EXISTS `reserve_sows_barn`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reserve_sows_barn` (
  `farm_name` varchar(45) NOT NULL,
  `reserve_sows_barn_num` varchar(45) NOT NULL,
  `reserve_sows_room_num` varchar(45) NOT NULL,
  PRIMARY KEY (`farm_name`,`reserve_sows_barn_num`,`reserve_sows_room_num`),
  UNIQUE KEY `farm_name_UNIQUE` (`farm_name`),
  UNIQUE KEY `reserve_sows_barn_num_UNIQUE` (`reserve_sows_barn_num`),
  UNIQUE KEY `reserve_sows_barn_room_num_UNIQUE` (`reserve_sows_room_num`),
  CONSTRAINT `Farm_name_2` FOREIGN KEY (`farm_name`) REFERENCES `farm_info` (`farm_name`),
  CONSTRAINT `reserve_sows_room_num` FOREIGN KEY (`reserve_sows_room_num`) REFERENCES `reserve_sows_room` (`reserve_sows_room_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reserve_sows_barn`
--

LOCK TABLES `reserve_sows_barn` WRITE;
/*!40000 ALTER TABLE `reserve_sows_barn` DISABLE KEYS */;
/*!40000 ALTER TABLE `reserve_sows_barn` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reserve_sows_pm_sensor`
--

DROP TABLE IF EXISTS `reserve_sows_pm_sensor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reserve_sows_pm_sensor` (
  `reserve_sows_room_num` varchar(45) NOT NULL,
  `reserve_sows_pm1_data` double DEFAULT NULL,
  `reserve_sows_pm25_data` double DEFAULT NULL,
  `reserve_sows_pm10_data` double DEFAULT NULL,
  `reserve_sows_pm_total_data` double DEFAULT NULL,
  `reserve_sows_pm_input_time` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`reserve_sows_room_num`),
  UNIQUE KEY `reserve_sows_room_num_UNIQUE` (`reserve_sows_room_num`),
  CONSTRAINT `reserve_sows_room_num_5` FOREIGN KEY (`reserve_sows_room_num`) REFERENCES `reserve_sows_room` (`reserve_sows_room_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reserve_sows_pm_sensor`
--

LOCK TABLES `reserve_sows_pm_sensor` WRITE;
/*!40000 ALTER TABLE `reserve_sows_pm_sensor` DISABLE KEYS */;
/*!40000 ALTER TABLE `reserve_sows_pm_sensor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reserve_sows_room`
--

DROP TABLE IF EXISTS `reserve_sows_room`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reserve_sows_room` (
  `idreserve_sows_num` varchar(45) NOT NULL,
  `reserve_sows_room_num` varchar(45) NOT NULL,
  PRIMARY KEY (`idreserve_sows_num`,`reserve_sows_room_num`),
  UNIQUE KEY `idreserve_sows_num_UNIQUE` (`idreserve_sows_num`),
  UNIQUE KEY `reserve_sows_room_num_UNIQUE` (`reserve_sows_room_num`),
  CONSTRAINT `reserve_sows_num` FOREIGN KEY (`idreserve_sows_num`) REFERENCES `reserve_sows_barn` (`reserve_sows_barn_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reserve_sows_room`
--

LOCK TABLES `reserve_sows_room` WRITE;
/*!40000 ALTER TABLE `reserve_sows_room` DISABLE KEYS */;
/*!40000 ALTER TABLE `reserve_sows_room` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reserve_temperature_sensor`
--

DROP TABLE IF EXISTS `reserve_temperature_sensor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reserve_temperature_sensor` (
  `reserve_sows_room_num` varchar(45) NOT NULL,
  `reserve_temperature_data` double NOT NULL,
  `reserve_temperature_input_time` datetime(6) DEFAULT NULL,
  `reserve_temperature_locate` varchar(45) DEFAULT NULL,
  `finishing_barn_room_num` varchar(255) DEFAULT NULL,
  `finishing_temper_data` double NOT NULL,
  `finishing_temper_input_time` datetime(6) DEFAULT NULL,
  `finishing_temper_locate_data` bigint NOT NULL,
  `reserve_temperature_locate_data` bigint NOT NULL,
  PRIMARY KEY (`reserve_sows_room_num`),
  UNIQUE KEY `reserve_sows_room_num_UNIQUE` (`reserve_sows_room_num`),
  CONSTRAINT `reserve_sows_room_num_4` FOREIGN KEY (`reserve_sows_room_num`) REFERENCES `reserve_sows_room` (`reserve_sows_room_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reserve_temperature_sensor`
--

LOCK TABLES `reserve_temperature_sensor` WRITE;
/*!40000 ALTER TABLE `reserve_temperature_sensor` DISABLE KEYS */;
/*!40000 ALTER TABLE `reserve_temperature_sensor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `user_id` varchar(255) NOT NULL,
  `user_pw` varchar(45) NOT NULL,
  `user_name` varchar(255) NOT NULL,
  `user_phone_num` varchar(255) NOT NULL,
  `farm_name` varchar(45) NOT NULL,
  PRIMARY KEY (`user_id`,`user_pw`,`user_phone_num`,`farm_name`),
  UNIQUE KEY `user_id_UNIQUE` (`user_id`),
  UNIQUE KEY `user_pw_UNIQUE` (`user_pw`),
  UNIQUE KEY `user_phone_num_UNIQUE` (`user_phone_num`),
  UNIQUE KEY `farm_name_UNIQUE` (`farm_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
=======
>>>>>>> 93c8a23ff01af8a88b0d4720bf024bde9a15dc32
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

<<<<<<< HEAD
-- Dump completed on 2024-07-30 11:09:27
=======
-- Dump completed on 2024-07-29 16:10:28
>>>>>>> 93c8a23ff01af8a88b0d4720bf024bde9a15dc32

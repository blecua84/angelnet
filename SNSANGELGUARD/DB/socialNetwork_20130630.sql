-- MySQL dump 10.13  Distrib 5.6.12, for osx10.7 (x86_64)
--
-- Host: localhost    Database: socialNetwork
-- ------------------------------------------------------
-- Server version	5.6.12

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
-- Table structure for table `Address_openSocial`
--

DROP TABLE IF EXISTS `Address_openSocial`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Address_openSocial` (
  `id_Address_openSocial` varchar(100) NOT NULL DEFAULT '',
  `COUNTRY` varchar(100) DEFAULT NULL,
  `EXTENDED_ADDRESS` varchar(150) DEFAULT NULL,
  `LATITUDE` int(11) DEFAULT NULL,
  `LOCALITY` varchar(100) DEFAULT NULL,
  `LONGITUDE` int(11) DEFAULT NULL,
  `PO_BOX` varchar(10) DEFAULT NULL,
  `POSTAL_CODE` varchar(10) DEFAULT NULL,
  `REGION` varchar(100) DEFAULT NULL,
  `STREET_ADDRESS` varchar(150) DEFAULT NULL,
  `TYPE` varchar(45) DEFAULT NULL,
  `UNSTRUCTURED` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id_Address_openSocial`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Address_openSocial`
--

LOCK TABLES `Address_openSocial` WRITE;
/*!40000 ALTER TABLE `Address_openSocial` DISABLE KEYS */;
INSERT INTO `Address_openSocial` VALUES ('0000000000','','',0,'',0,'','','','','',NULL);
/*!40000 ALTER TABLE `Address_openSocial` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Drinker_openSocial`
--

DROP TABLE IF EXISTS `Drinker_openSocial`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Drinker_openSocial` (
  `id_Drinker_openSocial` int(11) NOT NULL AUTO_INCREMENT,
  `DESCRIPTION` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_Drinker_openSocial`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Drinker_openSocial`
--

LOCK TABLES `Drinker_openSocial` WRITE;
/*!40000 ALTER TABLE `Drinker_openSocial` DISABLE KEYS */;
INSERT INTO `Drinker_openSocial` VALUES (1,''),(2,'NO'),(3,'OCCASIONALLY'),(4,'QUIT'),(5,'QUITTING'),(6,'REGULARLY'),(7,'SOCIALLY'),(8,'YES'),(9,'HEAVILY');
/*!40000 ALTER TABLE `Drinker_openSocial` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Email_openSocial`
--

DROP TABLE IF EXISTS `Email_openSocial`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Email_openSocial` (
  `id_Email_openSocial` int(11) NOT NULL,
  `ADDRESS` varchar(100) DEFAULT NULL,
  `TYPE` varchar(45) DEFAULT NULL,
  `user_openSocial_id_user_openSocial` varchar(100) NOT NULL,
  PRIMARY KEY (`id_Email_openSocial`),
  KEY `fk_Email_openSocial_user_openSocial1` (`user_openSocial_id_user_openSocial`),
  CONSTRAINT `fk_Email_openSocial_user_openSocial1` FOREIGN KEY (`user_openSocial_id_user_openSocial`) REFERENCES `user_openSocial` (`id_user_openSocial`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Email_openSocial`
--

LOCK TABLES `Email_openSocial` WRITE;
/*!40000 ALTER TABLE `Email_openSocial` DISABLE KEYS */;
/*!40000 ALTER TABLE `Email_openSocial` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Friends_openSocial`
--

DROP TABLE IF EXISTS `Friends_openSocial`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Friends_openSocial` (
  `USER_ID` varchar(45) NOT NULL,
  `GROUP_ID` varchar(45) DEFAULT NULL,
  `NETWORK_DISTANCE` int(11) DEFAULT NULL,
  PRIMARY KEY (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Friends_openSocial`
--

LOCK TABLES `Friends_openSocial` WRITE;
/*!40000 ALTER TABLE `Friends_openSocial` DISABLE KEYS */;
/*!40000 ALTER TABLE `Friends_openSocial` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Gender_openSocial`
--

DROP TABLE IF EXISTS `Gender_openSocial`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Gender_openSocial` (
  `id_Gender_openSocial` int(11) NOT NULL AUTO_INCREMENT,
  `DESCRIPTION` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_Gender_openSocial`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Gender_openSocial`
--

LOCK TABLES `Gender_openSocial` WRITE;
/*!40000 ALTER TABLE `Gender_openSocial` DISABLE KEYS */;
INSERT INTO `Gender_openSocial` VALUES (1,''),(2,'MALE'),(3,'FEMALE');
/*!40000 ALTER TABLE `Gender_openSocial` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `LookingFor_openSocial`
--

DROP TABLE IF EXISTS `LookingFor_openSocial`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `LookingFor_openSocial` (
  `id_LookingFor_openSocial` int(11) NOT NULL AUTO_INCREMENT,
  `DESCRIPTION` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_LookingFor_openSocial`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `LookingFor_openSocial`
--

LOCK TABLES `LookingFor_openSocial` WRITE;
/*!40000 ALTER TABLE `LookingFor_openSocial` DISABLE KEYS */;
INSERT INTO `LookingFor_openSocial` VALUES (1,''),(2,'ACTIVITY_PARTNERS'),(3,'DATING'),(4,'FRIENDS'),(5,'NETWORKING'),(6,'RANDOM'),(7,'RELATIONSHIP');
/*!40000 ALTER TABLE `LookingFor_openSocial` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Message_Type_openSocial`
--

DROP TABLE IF EXISTS `Message_Type_openSocial`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Message_Type_openSocial` (
  `id_Message_Type_openSocial` int(11) NOT NULL AUTO_INCREMENT,
  `DESCRIPTION` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_Message_Type_openSocial`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Message_Type_openSocial`
--

LOCK TABLES `Message_Type_openSocial` WRITE;
/*!40000 ALTER TABLE `Message_Type_openSocial` DISABLE KEYS */;
INSERT INTO `Message_Type_openSocial` VALUES (1,NULL),(2,'EMAIL'),(3,'NOTIFICATION'),(4,'PRIVATE_MESSAGE'),(5,'PUBLIC_MESSAGE');
/*!40000 ALTER TABLE `Message_Type_openSocial` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Message_openSocial`
--

DROP TABLE IF EXISTS `Message_openSocial`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Message_openSocial` (
  `id_Message_openSocial` int(11) NOT NULL,
  `BODY` varchar(1000) DEFAULT NULL,
  `BODY_ID` varchar(1000) DEFAULT NULL,
  `TITLE` varchar(200) DEFAULT NULL,
  `TITLE_ID` varchar(200) DEFAULT NULL,
  `Message_Type_openSocial_id_Message_Type_openSocial` int(11) NOT NULL,
  `user_openSocial_id_user_openSocial` varchar(100) NOT NULL,
  PRIMARY KEY (`id_Message_openSocial`),
  KEY `fk_Message_openSocial_Message_Type_openSocial1` (`Message_Type_openSocial_id_Message_Type_openSocial`),
  KEY `fk_Message_openSocial_user_openSocial1` (`user_openSocial_id_user_openSocial`),
  CONSTRAINT `fk_Message_openSocial_Message_Type_openSocial1` FOREIGN KEY (`Message_Type_openSocial_id_Message_Type_openSocial`) REFERENCES `Message_Type_openSocial` (`id_Message_Type_openSocial`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Message_openSocial_user_openSocial1` FOREIGN KEY (`user_openSocial_id_user_openSocial`) REFERENCES `user_openSocial` (`id_user_openSocial`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Message_openSocial`
--

LOCK TABLES `Message_openSocial` WRITE;
/*!40000 ALTER TABLE `Message_openSocial` DISABLE KEYS */;
/*!40000 ALTER TABLE `Message_openSocial` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Name_openSocial`
--

DROP TABLE IF EXISTS `Name_openSocial`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Name_openSocial` (
  `id_Name_openSocial` int(11) NOT NULL,
  `ADDITIONAL_NAME` varchar(45) DEFAULT NULL,
  `FAMILY_NAME` varchar(45) DEFAULT NULL,
  `GIVEN_NAME` varchar(45) DEFAULT NULL,
  `HONORIFIC_PREFIX` varchar(45) DEFAULT NULL,
  `HONORIFIC_SUFFIX` varchar(45) DEFAULT NULL,
  `UNSTRUCTURED` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id_Name_openSocial`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Name_openSocial`
--

LOCK TABLES `Name_openSocial` WRITE;
/*!40000 ALTER TABLE `Name_openSocial` DISABLE KEYS */;
/*!40000 ALTER TABLE `Name_openSocial` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Organization_openSocial`
--

DROP TABLE IF EXISTS `Organization_openSocial`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Organization_openSocial` (
  `id_Organization_openSocial` int(11) NOT NULL,
  `Address_openSocial_id_Address_openSocial` varchar(10) NOT NULL,
  `DESCRIPTION` varchar(100) DEFAULT NULL,
  `END_DATE` date DEFAULT NULL,
  `FIELD` varchar(100) DEFAULT NULL,
  `NAME` varchar(100) DEFAULT NULL,
  `SALARY` varchar(45) DEFAULT NULL,
  `START_DATE` date DEFAULT NULL,
  `SUB_FIELD` varchar(45) DEFAULT NULL,
  `TITLE` varchar(45) DEFAULT NULL,
  `WEB_PAGE` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_Organization_openSocial`),
  KEY `fk_Organization_openSocial_Address_openSocial` (`Address_openSocial_id_Address_openSocial`),
  CONSTRAINT `fk_Organization_openSocial_Address_openSocial` FOREIGN KEY (`Address_openSocial_id_Address_openSocial`) REFERENCES `Address_openSocial` (`id_Address_openSocial`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Organization_openSocial`
--

LOCK TABLES `Organization_openSocial` WRITE;
/*!40000 ALTER TABLE `Organization_openSocial` DISABLE KEYS */;
/*!40000 ALTER TABLE `Organization_openSocial` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Phones_openSocial`
--

DROP TABLE IF EXISTS `Phones_openSocial`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Phones_openSocial` (
  `id_Phones_openSocial` int(11) NOT NULL,
  `NUMBER` varchar(45) DEFAULT NULL,
  `TYPE` varchar(45) DEFAULT NULL,
  `user_openSocial_id_user_openSocial` varchar(100) NOT NULL,
  PRIMARY KEY (`id_Phones_openSocial`),
  KEY `fk_Phones_openSocial_user_openSocial1` (`user_openSocial_id_user_openSocial`),
  CONSTRAINT `fk_Phones_openSocial_user_openSocial1` FOREIGN KEY (`user_openSocial_id_user_openSocial`) REFERENCES `user_openSocial` (`id_user_openSocial`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Phones_openSocial`
--

LOCK TABLES `Phones_openSocial` WRITE;
/*!40000 ALTER TABLE `Phones_openSocial` DISABLE KEYS */;
/*!40000 ALTER TABLE `Phones_openSocial` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Presence_openSocial`
--

DROP TABLE IF EXISTS `Presence_openSocial`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Presence_openSocial` (
  `id_Presence_openSocial` int(11) NOT NULL AUTO_INCREMENT,
  `DESCRIPTION` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_Presence_openSocial`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Presence_openSocial`
--

LOCK TABLES `Presence_openSocial` WRITE;
/*!40000 ALTER TABLE `Presence_openSocial` DISABLE KEYS */;
INSERT INTO `Presence_openSocial` VALUES (1,''),(2,'AWAY'),(3,'CHAT'),(4,'DND'),(5,'OFFLINE'),(6,'ONLINE'),(7,'XA');
/*!40000 ALTER TABLE `Presence_openSocial` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Smoker_openSocial`
--

DROP TABLE IF EXISTS `Smoker_openSocial`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Smoker_openSocial` (
  `id_Smoker_openSocial` int(11) NOT NULL AUTO_INCREMENT,
  `DESCRIPTION` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_Smoker_openSocial`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Smoker_openSocial`
--

LOCK TABLES `Smoker_openSocial` WRITE;
/*!40000 ALTER TABLE `Smoker_openSocial` DISABLE KEYS */;
INSERT INTO `Smoker_openSocial` VALUES (1,''),(2,'HEAVILY'),(3,'NO'),(4,'OCCASIONALLY'),(5,'QUIT'),(6,'QUITTING'),(7,'REGULARLY'),(8,'SOCIALLY'),(9,'YES');
/*!40000 ALTER TABLE `Smoker_openSocial` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `action_links_facebook`
--

DROP TABLE IF EXISTS `action_links_facebook`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `action_links_facebook` (
  `id_action_links_facebook` int(11) NOT NULL,
  `TEXT` varchar(200) DEFAULT NULL,
  `URL` varchar(100) DEFAULT NULL,
  `stream_facebook_post_id` varchar(100) NOT NULL,
  PRIMARY KEY (`id_action_links_facebook`),
  KEY `fk_action_links_facebook_stream_facebook1` (`stream_facebook_post_id`),
  CONSTRAINT `fk_action_links_facebook_stream_facebook1` FOREIGN KEY (`stream_facebook_post_id`) REFERENCES `stream_facebook` (`post_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `action_links_facebook`
--

LOCK TABLES `action_links_facebook` WRITE;
/*!40000 ALTER TABLE `action_links_facebook` DISABLE KEYS */;
/*!40000 ALTER TABLE `action_links_facebook` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `affiliations_facebook`
--

DROP TABLE IF EXISTS `affiliations_facebook`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `affiliations_facebook` (
  `id_affiliations_facebook` int(11) NOT NULL,
  `YEAR` varchar(10) DEFAULT NULL,
  `NAME` varchar(200) DEFAULT NULL,
  `NID` int(11) DEFAULT NULL,
  `STATUS` varchar(100) DEFAULT NULL,
  `type_affiliations_facebook_id_type_affiliations_facebook` int(11) NOT NULL,
  `user_facebook_id_user_facebook` varchar(100) NOT NULL,
  PRIMARY KEY (`id_affiliations_facebook`),
  KEY `fk_affiliations_facebook_type_affiliations_facebook1` (`type_affiliations_facebook_id_type_affiliations_facebook`),
  KEY `fk_affiliations_facebook_user_facebook1` (`user_facebook_id_user_facebook`),
  CONSTRAINT `fk_affiliations_facebook_type_affiliations_facebook1` FOREIGN KEY (`type_affiliations_facebook_id_type_affiliations_facebook`) REFERENCES `type_affiliations_facebook` (`id_type_affiliations_facebook`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_affiliations_facebook_user_facebook1` FOREIGN KEY (`user_facebook_id_user_facebook`) REFERENCES `user_facebook` (`id_user_facebook`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `affiliations_facebook`
--

LOCK TABLES `affiliations_facebook` WRITE;
/*!40000 ALTER TABLE `affiliations_facebook` DISABLE KEYS */;
/*!40000 ALTER TABLE `affiliations_facebook` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comment_facebook`
--

DROP TABLE IF EXISTS `comment_facebook`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comment_facebook` (
  `XID` varchar(100) NOT NULL,
  `OBJECT_ID` varchar(100) DEFAULT NULL,
  `POST_ID` varchar(100) NOT NULL,
  `FROMID` varchar(100) DEFAULT NULL,
  `TIME_COMMENT` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `TEXT` mediumtext CHARACTER SET utf8,
  `ID` varchar(100) NOT NULL,
  `USERNAME` varchar(100) DEFAULT NULL,
  `REPLY_XID` varchar(100) DEFAULT NULL,
  `comments_facebook_id_comments_facebook` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `fk_comment_facebook_comments_facebook1` (`comments_facebook_id_comments_facebook`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment_facebook`
--

LOCK TABLES `comment_facebook` WRITE;
/*!40000 ALTER TABLE `comment_facebook` DISABLE KEYS */;
/*!40000 ALTER TABLE `comment_facebook` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comments_facebook`
--

DROP TABLE IF EXISTS `comments_facebook`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comments_facebook` (
  `id_comments_facebook` int(11) NOT NULL,
  `CAN_REMOVE` tinyint(1) DEFAULT NULL,
  `CAN_POST` tinyint(1) DEFAULT NULL,
  `COUNT` int(11) DEFAULT NULL,
  `stream_facebook_post_id` varchar(100) NOT NULL,
  PRIMARY KEY (`id_comments_facebook`),
  KEY `fk_comments_facebook_stream_facebook1` (`stream_facebook_post_id`),
  CONSTRAINT `fk_comments_facebook_stream_facebook1` FOREIGN KEY (`stream_facebook_post_id`) REFERENCES `stream_facebook` (`post_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comments_facebook`
--

LOCK TABLES `comments_facebook` WRITE;
/*!40000 ALTER TABLE `comments_facebook` DISABLE KEYS */;
/*!40000 ALTER TABLE `comments_facebook` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `education_history_facebook`
--

DROP TABLE IF EXISTS `education_history_facebook`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `education_history_facebook` (
  `id_education_history_facebook` int(11) NOT NULL,
  `YEAR` varchar(5) DEFAULT NULL,
  `NAME` varchar(100) DEFAULT NULL,
  `DEGREE` varchar(100) DEFAULT NULL,
  `CONCENTRATIONS_0` varchar(200) DEFAULT NULL,
  `CONCENTRATIONS_1` varchar(200) DEFAULT NULL,
  `CONCENTRATIONS_2` varchar(200) DEFAULT NULL COMMENT '	',
  `user_facebook_id_user_facebook` varchar(100) NOT NULL,
  PRIMARY KEY (`id_education_history_facebook`),
  KEY `fk_education_history_facebook_user_facebook1` (`user_facebook_id_user_facebook`),
  CONSTRAINT `fk_education_history_facebook_user_facebook1` FOREIGN KEY (`user_facebook_id_user_facebook`) REFERENCES `user_facebook` (`id_user_facebook`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `education_history_facebook`
--

LOCK TABLES `education_history_facebook` WRITE;
/*!40000 ALTER TABLE `education_history_facebook` DISABLE KEYS */;
/*!40000 ALTER TABLE `education_history_facebook` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `family_facebook`
--

DROP TABLE IF EXISTS `family_facebook`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `family_facebook` (
  `id_family_facebook` int(11) NOT NULL,
  `relationship_facebook_id_relationship_facebook` int(11) NOT NULL,
  `UID` varchar(45) DEFAULT NULL,
  `NAME` varchar(100) DEFAULT NULL,
  `BIRTHDAY` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_family_facebook`),
  KEY `fk_family_facebook_relationship_facebook1` (`relationship_facebook_id_relationship_facebook`),
  CONSTRAINT `fk_family_facebook_relationship_facebook1` FOREIGN KEY (`relationship_facebook_id_relationship_facebook`) REFERENCES `relationship_facebook` (`id_relationship_facebook`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `family_facebook`
--

LOCK TABLES `family_facebook` WRITE;
/*!40000 ALTER TABLE `family_facebook` DISABLE KEYS */;
/*!40000 ALTER TABLE `family_facebook` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `friends_facebook`
--

DROP TABLE IF EXISTS `friends_facebook`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `friends_facebook` (
  `USER_UID` varchar(45) NOT NULL,
  `USER_NAME` varchar(45) DEFAULT NULL,
  `USER_BIRTHDAY` varchar(45) DEFAULT NULL,
  `USER_PIC` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`USER_UID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `friends_facebook`
--

LOCK TABLES `friends_facebook` WRITE;
/*!40000 ALTER TABLE `friends_facebook` DISABLE KEYS */;
/*!40000 ALTER TABLE `friends_facebook` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `friends_likes_facebook`
--

DROP TABLE IF EXISTS `friends_likes_facebook`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `friends_likes_facebook` (
  `id_friends_likes_facebook` int(11) NOT NULL,
  `UID` varchar(45) DEFAULT NULL,
  `likes_facebook_id_likes_facebook` int(11) NOT NULL,
  PRIMARY KEY (`id_friends_likes_facebook`),
  KEY `fk_friends_likes_facebook_likes_facebook1` (`likes_facebook_id_likes_facebook`),
  CONSTRAINT `fk_friends_likes_facebook_likes_facebook1` FOREIGN KEY (`likes_facebook_id_likes_facebook`) REFERENCES `likes_facebook` (`id_likes_facebook`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `friends_likes_facebook`
--

LOCK TABLES `friends_likes_facebook` WRITE;
/*!40000 ALTER TABLE `friends_likes_facebook` DISABLE KEYS */;
/*!40000 ALTER TABLE `friends_likes_facebook` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `guardian_settings`
--

DROP TABLE IF EXISTS `guardian_settings`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `guardian_settings` (
  `uid_guardian` int(11) NOT NULL AUTO_INCREMENT,
  `guardian_name` varchar(200) NOT NULL,
  `guardian_email` varchar(200) NOT NULL,
  PRIMARY KEY (`uid_guardian`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `guardian_settings`
--

LOCK TABLES `guardian_settings` WRITE;
/*!40000 ALTER TABLE `guardian_settings` DISABLE KEYS */;
/*!40000 ALTER TABLE `guardian_settings` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `likes_facebook`
--

DROP TABLE IF EXISTS `likes_facebook`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `likes_facebook` (
  `id_likes_facebook` int(11) NOT NULL,
  `HREF` varchar(100) DEFAULT NULL,
  `COUNT` int(11) DEFAULT NULL,
  `USER_LIKES` tinyint(1) DEFAULT NULL,
  `CAN_LIKE` tinyint(1) DEFAULT NULL,
  `stream_facebook_post_id` varchar(100) NOT NULL,
  PRIMARY KEY (`id_likes_facebook`),
  KEY `fk_likes_facebook_stream_facebook1` (`stream_facebook_post_id`),
  CONSTRAINT `fk_likes_facebook_stream_facebook1` FOREIGN KEY (`stream_facebook_post_id`) REFERENCES `stream_facebook` (`post_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `likes_facebook`
--

LOCK TABLES `likes_facebook` WRITE;
/*!40000 ALTER TABLE `likes_facebook` DISABLE KEYS */;
/*!40000 ALTER TABLE `likes_facebook` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `locale_settings`
--

DROP TABLE IF EXISTS `locale_settings`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `locale_settings` (
  `id_locale` varchar(100) NOT NULL DEFAULT '',
  `acceptingTerms` varchar(1000) DEFAULT NULL,
  `legalAccepted` mediumtext,
  `btnAgreeAT` varchar(100) DEFAULT NULL,
  `btnCancelAT` varchar(100) DEFAULT NULL,
  `titleAT` varchar(100) DEFAULT NULL,
  `titleSettings` varchar(100) DEFAULT NULL,
  `titleMenSettings` varchar(100) DEFAULT NULL,
  `btnSaveCheckSettings` varchar(100) DEFAULT NULL,
  `titleSettAng` varchar(100) DEFAULT NULL,
  `titleFriendsContentSettAng` varchar(100) DEFAULT NULL,
  `titleFriendsImportSettAng` varchar(100) DEFAULT NULL,
  `txtNameTutorSettAng` varchar(100) DEFAULT NULL,
  `txtEmailTutorSettAng` varchar(100) DEFAULT NULL,
  `btnImportSettAng` varchar(100) DEFAULT NULL,
  `titleFbListSettAng` varchar(100) DEFAULT NULL,
  `subTitleAngelSettAng` varchar(100) DEFAULT NULL,
  `titleSettVig` varchar(100) DEFAULT NULL,
  `titleVigilantSettVig` varchar(100) DEFAULT NULL,
  `titleVigSettVig` varchar(100) DEFAULT NULL,
  `titleVigDescriptionSettVig` varchar(1000) DEFAULT NULL,
  `titleVigFrecSettVig` varchar(100) DEFAULT NULL,
  `titleVigFrecSelectSettVig` varchar(100) DEFAULT NULL,
  `titleVigAngSettVig` varchar(100) DEFAULT NULL,
  `titleAngConfirm` varchar(100) DEFAULT NULL,
  `desInfoAngConfirm` varchar(1000) DEFAULT NULL,
  `aceptConfAngConfirm` varchar(100) DEFAULT NULL,
  `cancelConfAngConfirm` varchar(100) DEFAULT NULL,
  `infoAngGuard` varchar(100) DEFAULT NULL,
  `titleAngUser` varchar(100) DEFAULT NULL,
  `nameUserAngUser` varchar(100) DEFAULT NULL,
  `btnCloseAngUser` varchar(100) DEFAULT NULL,
  `titleGoogleCont` varchar(100) DEFAULT NULL,
  `titleContGoogleCont` varchar(100) DEFAULT NULL,
  `btnLogGoogleCont` varchar(100) DEFAULT NULL,
  `titleNameContactGoogleCont` varchar(100) DEFAULT NULL,
  `titleEmailContactGoogleCont` varchar(100) DEFAULT NULL,
  `btnAceptGoogleCont` varchar(100) DEFAULT NULL,
  `btnCancelGoogleCont` varchar(100) DEFAULT NULL,
  `helpMe` mediumtext NOT NULL,
  `warnings` mediumtext NOT NULL,
  `titleInformationMessage` varchar(100) NOT NULL,
  `informationMessage` mediumtext NOT NULL,
  `mailDelete` mediumtext NOT NULL,
  `mailNotification` mediumtext NOT NULL,
  `altContactsAngelsEd` mediumtext NOT NULL,
  `titleVisitsFilterOptions` mediumtext,
  PRIMARY KEY (`id_locale`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `locale_settings`
--

LOCK TABLES `locale_settings` WRITE;
/*!40000 ALTER TABLE `locale_settings` DISABLE KEYS */;
INSERT INTO `locale_settings` VALUES ('00000001','You are about to install SNSAngelGuard. Your profile data has NOT been accessed at this point. SNSAngelGuard is devised to give you support on living in social networks safely by declaring contact data of some people that you trust (e.g. your parents or relatives) that we call angels and selecting a number of guards, wich are software modules that read your profile information and inform the angels of any potential risk. Personal information on your contatcts is never forwarded to your angels, but they know that something that deserve inspection is needed and can warm and contact you.','Gracias por utilizar SNSAngelGuard. Al descargar, instalar o utilizar este software o cualquier parte de &eacute;l, el usuario se compromete a respetar las siguientes Condiciones de uso:\n                        1. USO DEL SOFTWARE; RESTRICCIONES\n\n                        Uso del Software. Para los usuarios finales individuales, el Software se pone a disposicion del usuario solo para su uso personal y no comercial, segun estas Condiciones de uso y la documentacion del Software. Para los usuarios finales de entidades comerciales o gubernamentales, el Software lo podra utilizar el usuario y sus empleados para uso interno, segun estas Condiciones de uso y la documentacion del Software (los usuarios finales individuales y los usuarios finales comerciales o gubernamentales se denominaran en adelante en el presente acuerdo \"el usuario\"). Restricciones. Salvo en el caso de que SNSAngelGuard le haya concedido una licencia especificamente para ello, el usuario no debe utilizar el Software en combinacion con otros productos, sistemas ni aplicaciones que se hayan instalado o conectado de modo alguno o que esten en comunicacion con vehiculos destinados a los siguientes fines o relacionados con ellos:\n\n                        (a) las indicaciones de ruta en tiempo real (incluidas, sin limitacion, las indicaciones detalladas sobre como llegar y otras rutas que se pueden obtener mediante el uso de un sensor);\n\n                        (b) cualquier sistema o funcion destinado a controlar de forma automatica o autonoma el comportamiento del vehiculo; o\n\n                        (c) la expedicion, la administracion de flotas o aplicaciones similares. No se permite utilizar el Software de ningun modo que permita al usuario u a otras personas acceder a descargas masivas o a feeds masivos de coordenadas numericas de latitud y longitud. El usuario no debe utilizar el Software para la impresion o la descarga masiva de imagenes, datos u otro contenido.\n                        2. POLiTICA DE PRIVACIDAD\n\n                        Como condicion para descargar y utilizar el Software, el usuario acepta los terminos de la Politica de privacidad de SNSAngelGuard dispuestos en http://www.SNSAngelGuard.es/privacy.html, los cuales pueden actualizarse sin previo aviso.\n                        3. DERECHOS DE PROPIEDAD\n\n                        a. SNSAngelGuard. El usuario reconoce que\n\n                        (a) el Software contiene informacion confidencial y con derechos de propiedad protegida, entre otras, por las leyes de proteccion de la propiedad intelectual aplicables; y que\n\n                        (b) SNSAngelGuard posee todos los derechos, titulos e intereses sobre el Software y sobre el software proporcionado a traves del Software o junto con el Software, incluidos, sin limitacion, todos los Derechos de propiedad intelectual sobre ellos incluidos aqui. Se entiende por \"Derechos de propiedad intelectual\" cualquier derecho existente en cualquier momento sujeto a las leyes de patentes, de copyright, de secretos comerciales, de marcas comerciales y de competencia desleal y cualquier otro derecho de propiedad, y cualquier solicitud, renovacion, extension y restauracion anterior, actual y futura aplicada y en vigor en todo el mundo. El usuario acepta no permitir, ni en el presente ni en el futuro, que terceros (1) copien, vendan, otorguen licencia, distribuyan, transfieran, modifiquen, adapten, traduzcan, preparen trabajos derivados, descompilen, realicen ingenieria inversa, desmonten ni intenten de cualquier otra forma descubrir el codigo fuente del Software, salvo que este expresamente permitido; (2) lleven a cabo acciones para sortear o anular la seguridad o las normas de uso del contenido proporcionadas, implementadas o aplicadas por cualquier funcionalidad (incluidas, sin limitaciones, las funcionalidades de gestion de derechos digitales) contenidas en el Software; (3) usen el Software para acceder, copiar, transferir, transmitir en codigo o retransmitir el contenido de forma que infrinja cualquier ley o los derechos de terceros; o (4) eliminen, oculten o alteren los avisos de copyright de SNSAngelGuard y otros avisos de marcas comerciales u otros derechos de propiedad adjuntos o contenidos en el Software o a los que se pueda acceder desde el Software. El contenido presentado como parte del Software, incluido, pero sin limitarse a ello, las imagenes fotograficas y los datos cartograficos (el ?Contenido?), esta protegido por los derechos de propiedad intelectual que posee SNSAngelGuard, otros proveedores de licencia y partners, y terceros que proporcionan dicho Contenido a SNSAngelGuard. El usuario no puede copiar, distribuir, mostrar, modificar ni utilizar de cualquier otro modo el Contenido (ni puede permitir que otras personas lo hagan), salvo si accede a el a traves del Software, a menos que SNSAngelGuard o los propietarios del Contenido le hayan dado autorizacion explicita para hacerlo en un acuerdo independiente. Ni SNSAngelGuard ni sus proveedores de licencias realizan declaracion ni garantia alguna con respecto a la precision o integridad de esta informacion.\n\n                        b. Terceras partes. Los datos de los contenidos de mapas del Software se proporcionan bajo la licencia de los proveedores de licencia de SNSAngelGuard, incluido Tele Atlas North America, Inc. (?TANA?, los ?Datos de TANA?), y estan sujetos a los derechos de propiedad intelectual que posean (o tengan licencia para ellos) TANA o los otros proveedores de licencia. El usuario se compromete a no realizar ninguna copia ni divulgacion de este material sin autorizacion y se le pueden pedir responsabilidades en su caso. El usuario se compromete a no utilizar ni distribuir informacion cartografica con fines comerciales. Al utilizar el Software, el usuario acepta convertir a TANA en tercero beneficiario de este acuerdo. El uso que se realice de los Datos de TANA esta sujeto a restricciones adicionales descritas en la pagina de Avisos legales.\n                        4. ACTUALIZACIONES AUTOMaTICAS\n\n                        El Software se puede comunicar en ocasiones con los servidores de SNSAngelGuard para comprobar si hay disponibles actualizaciones del mismo, como soluciones para errores, parches, funciones mejoradas, complementos ausentes y versiones nuevas (colectivamente denominados \"Actualizaciones\"). Al instalar el Software, el usuario acepta solicitar y recibir Actualizaciones de forma automatica.\n                        5. DERECHOS RESTRINGIDOS POR EL GOBIERNO DE EE.UU.\n\n                        Si se accede al Software o se utiliza este por parte del Gobierno de los Estados Unidos, o en su nombre, este uso o acceso estara sujeto a la siguiente clausula. El Software y toda la documentacion relacionada se consideran \"software informatico comercial\" y \"documentacion de software informatico comercial\" respectivamente, con el significado correspondiente a estos terminos en las normativas federales de adquisiciones civiles y militares de los Estados Unidos y de sus leyes complementarias. Si el usuario del Software es una agencia, departamento, empleado u otra entidad del Gobierno de los Estados Unidos de America, el uso, duplicacion, reproduccion, publicacion, modificacion, divulgacion o transferencia del Software, incluidos los datos y manuales tecnicos, estara restringido segun los terminos, condiciones y clausulas incluidos en estas Condiciones de uso. De acuerdo con la Normativa de adquisiciones federales (Federal Acquisition Regulation) 12.212 para agencias civiles y el Suplemento 227.7202 de esta Normativa para agencias militares, el uso del Software esta ademas restringido por estas Condiciones de uso.\n                        6. RESTRICCIONES DE EXPORTACIoN\n\n                        El Software esta sujeto a los controles a la exportacion de los Estados Unidos. Al descargar el Software, el usuario asume la responsabilidad exclusiva de cumplir con todas las regulaciones sobre el control a las exportaciones de los Estados Unidos, incluida la Normativa regulatoria de la administracion de exportaciones (EAR, por sus siglas en ingles), y todos los programas de sanciones, incluidos los administrados por la Oficina de control de los activos extranjeros (OFAC, por sus siglas en ingles) del Departamento del Tesoro de los Estados Unidos y todas las demas regulaciones sobre el comercio internacional aplicables. El usuario se compromete a no descargar ni utilizar el Software sin todos los permisos requeridos en cualquiera de los destinos proscritos (incluidos Corea del Norte, Cuba, Iran, Siria y Sudan), en nombre de cualquier entidad o persona proscrita, para cualquier uso proscrito o de ninguna otra forma que contradiga estas regulaciones a la exportacion o programas de sanciones. Al descargar o utilizar el Software, el usuario declara y garantiza que no es un usuario final proscrito y que no va a utilizar este software para ningun uso final proscrito segun estas regulaciones.\n                        7. CUMPLIMIENTO DE LAS LEYES Y DE LAS POLiTICAS DE SNSAngelGuard\n\n                        El usuario acepta cumplir todas las leyes y regulaciones locales relativas a la descarga, instalacion y uso del Software. El usuario acepta cumplir cualquier directiva o normativa aplicable que SNSAngelGuard pueda publicar en algun momento a su sola discrecion. Como ejemplo, y sin que sirva como limitacion, el usuario acepta que cuando utilice el software NO:\n\n                        * difamara, insultara, acosara, acechara, amenazara ni violara de ninguna otra forma los derechos legales (como los derechos de privacidad y publicidad) de terceros,\n                        * subira, publicara, enviara por correo electronico, transmitira ni hara asequible de ninguna otra forma ningun tipo de contenido inapropiado, difamatorio, infractor, obsceno ni ilegal,\n                        * subira, publicara, enviara por correo electronico, transmitira ni dispondra de ninguna otra forma ningun tipo de contenido que infrinja cualquier derecho de patente, marca comercial, copyright, secreto comercial u otros derechos de propiedad de parte alguna, a no ser que el usuario sea el propietario de dichos derechos o tenga permiso del propietario para publicar dicho contenido,\n                        * descargara ningun archivo publicado por cualquier otro usuario si se sabe, o razonablemente se deberia saber, que no es posible distribuirlo legalmente de dicha manera,\n                        * suplantara la identidad de otra persona o entidad, o falsificara o suprimira cualquier aviso legal, de atribucion de autoria u otros avisos, designaciones de propiedad o etiquetas similares que indiquen el origen o fuente del software, el contenido o de otro material,\n                        * restringira ni prohibira a ningun otro usuario el uso y disfrute de los servicios de SNSAngelGuard,\n                        * usara los servicios de SNSAngelGuard para ningun proposito ilegal o no autorizado,\n                        * suprimira ningun aviso de copyright, de marca comercial o de otros derechos de propiedad incluidos en los servicios de SNSAngelGuard,\n                        * interferira en los servicios, servidores de SNSAngelGuard o con las redes conectadas con los servicios de SNSAngelGuard ni los interrumpira; ni desobedecera ningun requisito, procedimiento, directiva ni regulacion de las redes conectadas a los servicios de SNSAngelGuard,\n                        * usara ningun robot, araña, aplicacion de recuperacion o de busqueda de sitios ni ningun otro dispositivo para recuperar o indexar parte alguna de los servicios de SNSAngelGuard ni recopilara informacion sobre los usuarios para ningun proposito no autorizado,\n                        * enviara contenido que exprese o implique falsamente que dicho contenido esta patrocinado o refrendado por SNSAngelGuard,\n                        * creara cuentas de usuario por medios automatizados o bajo premisas falsas o fraudulentas,\n                        * fomentara ni ofrecera instrucciones sobre actividades ilegales ni fomentara daños fisicos o lesiones contra ningun grupo ni individuo; ni\n                        * transmitira virus, gusanos, defectos, caballos de Troya ni ningun otro tipo de elemento de naturaleza destructiva.\n\n                        8. RESCISIoN\n\n                        El usuario podra rescindir estas Condiciones de uso en cualquier momento eliminando en su totalidad y de forma permanente el Software. Los derechos del usuario se revocaran de forma automatica e inmediata sin aviso por parte de SNSAngelGuard, si incumple cualquier disposicion de estas Condiciones de uso. En tal caso, el usuario debera eliminar de forma inmediata el Software y todo el Contenido. Con la extension maxima permitida por la ley, SNSAngelGuard se reserva el derecho a revocar este acuerdo y la utilizacion por parte del usuario del Software en cualquier momento y por cualquier motivo.\n                        9. PERMANENCIA\n\n                        Las disposiciones de las Secciones 3, 5, 6, 9, 10, 11, 12, 13, 14, 15 y 16 de este acuerdo permaneceran en vigor en caso de rescision o caducidad de estas Condiciones de uso.\n                        10. INDEMNIZACIoN\n\n                        El usuario acepta eximir e indemnizar a SNSAngelGuard y a sus filiales, afiliados, directivos, agentes y empleados en caso de que surja cualquier reclamacion, demanda o accion legal provocada o relacionada de cualquier forma con el uso por parte del usuario del Software o de la violacion de estas Condiciones de uso por parte del usuario, incluida cualquier responsabilidad o gasto que surja de cualquier reclamacion, perdida, daño, demanda, juicio, costes procesales y de abogados de cualquier tipo y naturaleza. En este caso, SNSAngelGuard proveera al usuario aviso por escrito de dichas reclamaciones, demandas o acciones.\n                        11. RENUNCIA A GARANTiAS\n\n                        EL USUARIO ENTIENDE Y ACEPTA EXPRESAMENTE QUE:\n\n                        a) EL USO QUE HAGA DEL SOFTWARE ES A SU PROPIA CUENTA Y RIESGO. EL SOFTWARE SE PROPORCIONA \"TAL CUAL\" Y SIN GARANTiAS DE NINGuN TIPO. SNSAngelGuard Y SUS PROVEEDORES DE LICENCIA RENUNCIAN EXPRESAMENTE, Y EN LA MEDIDA EN QUE LA LEY LO PERMITA, A TODAS LAS GARANTiAS Y CONDICIONES IMPLiCITAS O EXPLiCITAS DE CUALQUIER TIPO INCLUIDAS, SIN LIMITARSE A ELLAS, LAS GARANTiAS Y CONDICIONES IMPLiCITAS DE COMERCIABILIDAD, ADECUACIoN PARA UN FIN PARTICULAR Y NO INFRACCIoN.\n\n                        b) NI SNSAngelGuard NI SUS PROVEEDORES DE LICENCIA OTORGAN GARANTiA ALGUNA (I) DE QUE EL SOFTWARE CUMPLIRa LOS REQUISITOS DEL USUARIO, (II) DE QUE EL SOFTWARE NO TENDRa ERRORES NI FALLOS; (III) CONCERNIENTE A LA SEGURIDAD, FIABILIDAD, PUNTUALIDAD Y RENDIMIENTO DEL SOFTWARE; NI (IV) DE QUE SE CORREGIRa CUALQUIER ERROR DEL SOFTWARE.\n\n                        c) REALIZA CUALQUIER DESCARGA U OBTENCIoN DE MATERIAL O DATOS DE ALGUNA OTRA FORMA MEDIANTE EL USO DEL SOFTWARE A SU PROPIA DISCRECIoN Y RIESGO Y SERa EL uNICO RESPONSABLE POR CUALQUIER DAÑO A SU SISTEMA INFORMaTICO U OTRO DISPOSITIVO, O POR LA PeRDIDA DE INFORMACIoN QUE RESULTE DE DESCARGAR ESE MATERIAL O INFORMACIoN.\n\n                        d) NINGUNA PARTE DEL SOFTWARE ESTa PENSADA PARA SU USO EN LA EXPLOTACIoN DE INSTALACIONES NUCLEARES, SISTEMAS DE REANIMACIoN CARDIOPULMONAR, COMUNICACIONES DE EMERGENCIA, NAVEGACIoN AeREA O SISTEMAS DE COMUNICACIoN, NI EN SISTEMAS DE CONTROL DEL TRaFICO AeREO NI EN NINGUNA OTRA ACTIVIDAD DE ESE TIPO EN LA QUE EL FALLO DEL SOFTWARE PUEDA RESULTAR EN MUERTE, LESIONES PERSONALES O DAÑOS FiSICOS O MEDIOAMBIENTALES GRAVES.\n\n                        e) NINGuN CONSEJO NI INFORMACIoN, YA SEAN ORALES O ESCRITOS, OBTENIDOS DE SNSAngelGuard O DE TERCEROS O MEDIANTE EL USO DEL SOFTWARE OTORGAN NINGUNA GARANTiA QUE NO HAYA SIDO EXPRESAMENTE ESTABLECIDA EN ESTAS CONDICIONES DE USO.\n                        12. LIMITACIoN DE RESPONSABILIDADES\n\n                        EL USUARIO ENTIENDE Y ACEPTA EXPRESAMENTE QUE NI SNSAngelGuard NI SUS PROVEEDORES DE LICENCIA SE HARaN RESPONSABLES DE DAÑO DIRECTO, INDIRECTO, INCIDENTAL, ESPECIAL, DERIVADO NI PUNITIVO ALGUNO, INCLUIDOS, PERO SIN LIMITARSE A ELLOS, DAÑOS POR PeRDIDA DE GANANCIAS, CLIENTELA, USO, DATOS Y OTRAS PeRDIDAS INTANGIBLES (INCLUSO EN CASO DE QUE SNSAngelGuard HAYA SIDO ADVERTIDO DE LA POSIBILIDAD DE ESTOS DAÑOS) QUE SEAN RESULTADO DE:\n\n                        (I) EL USO O LA INCAPACIDAD DE USAR EL SOFTWARE O DE ACCEDER A CONTENIDO O A DATOS;\n\n                        (II) COSTE POR OBTENCIoN DE BIENES O SERVICIOS SUSTITUTOS;\n\n                        (III) ACCESO NO AUTORIZADO A SUS TRANSMISIONES O DATOS O ALTERACIoN DE LOS MISMOS; O (V) CUALQUIER OTRA CUESTIoN RELACIONADA CON EL SOFTWARE.\n\n                        LAS LIMITACIONES ANTERIORES SE APLICARaN INDEPENDIENTEMENTE DE UN FALLO DEL PROPoSITO ESENCIAL DE CUALQUIER RECURSO LEGAL LIMITADO Y CON EL ALCANCE TOTAL PERMITIDO POR LEY. BAJO NINGUNA CIRCUNSTANCIA, SNSAngelGuard O CUALQUIERA DE LAS COMPAÑiAS DE TERCEROS QUE OFRECEN SU SOFTWARE O SU CONTENIDO JUNTO CON EL SOFTWARE O A TRAVeS DE eL SERaN RESPONSABLES ANTE NINGuN USUARIO POR EL USO O EL MAL USO DEL SOFTWARE O DEL SOFTWARE O EL CONTENIDO DE TERCEROS. ESTA LIMITACIoN DE RESPONSABILIDADES SE APLICARa A FIN DE EVITAR EL OTORGAMIENTO DE CUALQUIER COMPENSACIoN POR DAÑOS DIRECTOS, INDIRECTOS, INCIDENTALES, CONSECUENTES, ESPECIALES, EJEMPLARES Y PUNITIVOS, INDEPENDIENTEMENTE DE SI ESTAS RECLAMACIONES SE BASAN EN GARANTiAS, CONTRATOS, AGRAVIOS (INCLUIDA LA NEGLIGENCIA) U OTROS (INCLUSO SI SNSAngelGuard O UNA DE LAS COMPAÑiAS DE SOFTWARE DE TERCEROS O LOS PROVEEDORES DE CONTENIDO HAN SIDO ADVERTIDOS DE LA POSIBILIDAD DE TALES DAÑOS). ESTA LIMITACIoN DE RESPONSABILIDADES SE APLICARa TANTO SI LOS DAÑOS PROVIENEN DEL USO O EL MAL USO DEL SOFTWARE, COMO DE LA INCAPACIDAD DE USARLO O DE LA CONFIANZA DEPOSITADA EN EL MISMO, Y EN EL SOFTWARE O EL CONTENIDO DE TERCEROS DISPONIBLE JUNTO CON EL SOFTWARE O A TRAVeS DE eL; O DE LA INTERRUPCIoN, SUSPENSIoN O FINALIZACIoN DEL SOFTWARE Y DEL SOFTWARE O EL CONTENIDO DE TERCEROS DISPONIBLE JUNTO CON EL SOFTWARE O A TRAVeS DE eL (INCLUIDOS LOS DAÑOS SUFRIDOS POR TERCEROS). ESTA LIMITACIoN SE APLICARa INDEPENDIENTEMENTE DE NO HABERSE CONSEGUIDO EL PROPoSITO ESENCIAL DE CUALQUIER SOLUCIoN O RECTIFICACIoN Y CON EL TOTAL ALCANCE PERMITIDO POR LA LEY.\n                        13. EXCLUSIONES Y LIMITACIONES\n\n                        NINGUNO DE LOS COMPONENTES DE ESTE ACUERDO PRETENDE EXCLUIR O LIMITAR NINGUNA CONDICIoN, GARANTiA, DERECHO O RESPONSABILIDAD QUE NO PUEDA EXCLUIRSE O LIMITARSE LEGALMENTE. ALGUNOS ESTADOS O JURISDICCIONES NO PERMITEN LA EXCLUSIoN DE GARANTiAS IMPLiCITAS. POR ELLO, ES POSIBLE QUE LAS EXCLUSIONES ANTERIORES NO SEAN APLICABLES EN SU CASO. ASIMISMO, PODRaN APLICaRSELE OTROS DERECHOS, QUE VARiAN EN FUNCIoN DEL ESTADO Y LA JURISDICCIoN.\n                        14. AUSENCIA DE BENEFICIARIOS TERCEROS\n\n                        El usuario acepta que, a menos que se indique expresamente lo contrario en estas Condiciones de uso, no habra ningun beneficiario tercero de estas Condiciones de uso.\n                        15. SERVICIOS DE SNSAngelGuard Y PRODUCTOS Y SERVICIOS DE TERCEROS\n\n                        Parte del Software esta diseñado para su uso junto a las busquedas de SNSAngelGuard y otros servicios. Por lo tanto, cada vez que utilice el Software, el usuario se compromete a cumplir las Condiciones de uso de SNSAngelGuard descritas en http://www.SNSAngelGuard.es/accounts/TOS.\n                        16. DISPOSICIONES VARIAS\n\n                        a) Eleccion de jurisdiccion y tribunal. Estas Condiciones de uso se regiran e interpretaran de acuerdo con las leyes del estado de California; toda disposicion asociada con los conflictos de leyes aplicables en California o en su estado o pais de residencia no tendra efecto. Si, por alguna razon, un tribunal de jurisdiccion competente determina que una clausula o parte de estas Condiciones de uso no es exigible, el resto de estas Condiciones de uso conservara su vigencia y efecto.\n\n                        b) Renuncia y separacion de terminos. El hecho de que SNSAngelGuard no ejercite o aplique cualquiera de los derechos o disposiciones de estas Condiciones de uso no constituye una renuncia a dicho derecho o disposicion. Si cualquiera de las disposiciones de estas Condiciones de uso es considerada invalida por un tribunal de jurisdiccion competente, las partes acuerdan que dicho tribunal debe esforzarse en considerar las intenciones de las partes tal y como se reflejan en la disposicion, y que las demas disposiciones de estas Condiciones de uso permaneceran en pleno vigor y efecto.\n\n                        c) Exencion de derechos. El usuario manifiesta su acuerdo en que, independientemente de cualquier estatuto o ley que disponga lo contrario, cualquier reclamacion o causa de accion que resulte del uso del Software o de estas Condiciones de uso o que este relacionada con ellas, se llevara a cabo dentro del plazo de un (1) año desde la aparicion de dicha reclamacion o causa de accion o prescribira para siempre.\n\n                        d) Estas Condiciones de uso constituyen el acuerdo total entre las partes con respecto al tema objeto del presente documento, y sustituyen y reemplazan todo acuerdo o entendimiento previo o actual, sea escrito u oral, sobre este. La renuncia a cualquiera de las clausulas de estas Condiciones de uso sera efectiva solo si se tramita por escrito y contiene la firma de SNSAngelGuard o de los terceros que ofrezcan su software junto con el Software o a traves de el.','Agree','Cancel','Accepting Terms and Conditions','Settings','Settings;Angels;Vigilants;','Save','Select your Angels','Select your Angels from your Facebook Contacts','Import a contact of your Gmail account;Select others contacts;','Name','Email','Import','View All;Selected;Unselected;','Select like your Angel','Configure your Vigilants','Vigilants','Wall Control;Friends Control;Privacy Control;Visits Control;','Vigilant Description;This when activated, it realizes a control of the ages of every friend, sending any incident to the Tutor of the application;This when activated, he verifies that offensive language does not exist in the messages of the wall, sending any incident to the Tutor of the application;This when activated, he verifies that the level of privacy of the user is not too permissive, sending any incident to the Tutor of the application;This when activated, he verifies the level of visits that has had the profile of the user during the period of time passed from the last checking of the profile, sending any incident to the Tutor of the application;','Notifications Frecuency','Once a day;Once a week;Once two weeks;Once a month;Once two months;Once six months;Once a year;','Angels','SNSAngelGuardFB: Autoritation for send notificacions',' wishes that you control his social activity in Facebook.\n\n                                    If you accept above mentioned authorization, a series of notifications will be sent in order that it could realize a personalized follow-up of his social activity.\n\n                                    If on the contrary, you cancel the authorization, it will not return to send any notification','Accept','Cancel',' is software developed in the Alcalá de Henares University, Spain.','SNSAngelGuardFB: User Identification','Name','Close','Import Contact from your Google account','Select a contact from your Google account','Login Google','Name','Email','Acept','Cancel','Need help?;Help; What is an Angel?; An Angel is a person who receives notifications of the anormal activities that it produces in your Facebook profile. For each anomalies, your Angels will receive a notification in her/his email.; What is a Vigilant?; A Vigilant is a software tool that is executing inside Facebook. These tools detect threats in your profile information, privacity, friends, wall, ..., etc and send notifications for your Angels.<br><br>Actually, there are four Vigilants: <br><br>- Wall Control: Check your post wall and send a notification to your Angels with the offensive language that could exist. <br><br>- Friends Control: Check your friends, detecting which of them have indicated his age, and if this one exceeds a certain limit.<br><br>- Privacity Control: Check your privacy configuration, detecting if your profile is too permissive to accede to your personal information.<br><br>- Visits Control: Check the last visits and to whom they belong on your facebook profile.; Vigilant configuration; To configure a Vigilant it\'s necesary two actions:<br><br>1. To select an Angel or Angels to which you want that they control your activity. The Angels they are selected in the eyelash \"Angels\" and later, in the eyelash \"Vigilants\", they will be able to associate in an individual way to every filter.<br><br>2. To form the frequency to which SNSAngelGuard will send reports to your Angels, informing them about your activity in Facebook.<br>;','You must select at least an angel;Dates saved successfully;Saving dates...;Loading dates...;Wait a momment, please;Angel correctly deleted!;Angel correctly saved!;Error;There is an error in the application… ;Details','Information','Dates saved successfully.;User already confirmated.;Error: Non-existent Angel;','SNSAngelGuard Alert: Deleted angel; deleted you of the Angel List;','SNSAngelGuard: Activity Notification; SNSAngelGuad Notification: User ;In the comment ; of the post wall ; there is offensive language. ;There isn\'t any anomalies in the user\'s Wall.; doen\'t say his/her age ; is too major for ;There isn\'t any anomalies in the user\'s friends.;There isn\'t any anomalies in the user\'s privacity configuration.;There isn\'t any anomalies in the user\'s profile visits.;','Create new Angel;Edit;Cancel;Delete;Save;','Best ranking\'s friends with mutual contacts in your Facebook; Worst ranking\'s friends with mutual contacts in your Facebook; Post wall of your friends in your Facebook wall; '),('00000002','SNSAngelGuard analiza la actividad social de una persona. Si detecta alguna anomal&iacute;a, env&iacute;a un informe a la persona o tutor responsable. Este tutor habr&aacute; sido previamente designado por la persona que decide instalar, por voluntad propia, SNSAngelGuard. La aplicaci&oacute;n utiliza datos personales del perfil en cuesti&oacute;n para ser posteriormente analizados. Para proceder a su instalaci&oacute;n, rogamos lea detenidamente el Acuerdo Legal que se expone a continuaci&oacute;n. Si, por el contrario, no desea que SNSAngelGuard se ejecute, pulse el bot&oacute;n \"Cancelar\" y se proceder&aacute; a su desinstalaci&oacute;n.','Gracias por utilizar SNSAngelGuard. Al descargar, instalar o utilizar este software o cualquier parte de &eacute;l, el usuario se compromete a respetar las siguientes Condiciones de uso:\n                        1. USO DEL SOFTWARE; RESTRICCIONES\n\n                        Uso del Software. Para los usuarios finales individuales, el Software se pone a disposicion del usuario solo para su uso personal y no comercial, segun estas Condiciones de uso y la documentacion del Software. Para los usuarios finales de entidades comerciales o gubernamentales, el Software lo podra utilizar el usuario y sus empleados para uso interno, segun estas Condiciones de uso y la documentacion del Software (los usuarios finales individuales y los usuarios finales comerciales o gubernamentales se denominaran en adelante en el presente acuerdo \"el usuario\"). Restricciones. Salvo en el caso de que SNSAngelGuard le haya concedido una licencia especificamente para ello, el usuario no debe utilizar el Software en combinacion con otros productos, sistemas ni aplicaciones que se hayan instalado o conectado de modo alguno o que esten en comunicacion con vehiculos destinados a los siguientes fines o relacionados con ellos:\n\n                        (a) las indicaciones de ruta en tiempo real (incluidas, sin limitacion, las indicaciones detalladas sobre como llegar y otras rutas que se pueden obtener mediante el uso de un sensor);\n\n                        (b) cualquier sistema o funcion destinado a controlar de forma automatica o autonoma el comportamiento del vehiculo; o\n\n                        (c) la expedicion, la administracion de flotas o aplicaciones similares. No se permite utilizar el Software de ningun modo que permita al usuario u a otras personas acceder a descargas masivas o a feeds masivos de coordenadas numericas de latitud y longitud. El usuario no debe utilizar el Software para la impresion o la descarga masiva de imagenes, datos u otro contenido.\n                        2. POLiTICA DE PRIVACIDAD\n\n                        Como condicion para descargar y utilizar el Software, el usuario acepta los terminos de la Politica de privacidad de SNSAngelGuard dispuestos en http://www.SNSAngelGuard.es/privacy.html, los cuales pueden actualizarse sin previo aviso.\n                        3. DERECHOS DE PROPIEDAD\n\n                        a. SNSAngelGuard. El usuario reconoce que\n\n                        (a) el Software contiene informacion confidencial y con derechos de propiedad protegida, entre otras, por las leyes de proteccion de la propiedad intelectual aplicables; y que\n\n                        (b) SNSAngelGuard posee todos los derechos, titulos e intereses sobre el Software y sobre el software proporcionado a traves del Software o junto con el Software, incluidos, sin limitacion, todos los Derechos de propiedad intelectual sobre ellos incluidos aqui. Se entiende por \"Derechos de propiedad intelectual\" cualquier derecho existente en cualquier momento sujeto a las leyes de patentes, de copyright, de secretos comerciales, de marcas comerciales y de competencia desleal y cualquier otro derecho de propiedad, y cualquier solicitud, renovacion, extension y restauracion anterior, actual y futura aplicada y en vigor en todo el mundo. El usuario acepta no permitir, ni en el presente ni en el futuro, que terceros (1) copien, vendan, otorguen licencia, distribuyan, transfieran, modifiquen, adapten, traduzcan, preparen trabajos derivados, descompilen, realicen ingenieria inversa, desmonten ni intenten de cualquier otra forma descubrir el codigo fuente del Software, salvo que este expresamente permitido; (2) lleven a cabo acciones para sortear o anular la seguridad o las normas de uso del contenido proporcionadas, implementadas o aplicadas por cualquier funcionalidad (incluidas, sin limitaciones, las funcionalidades de gestion de derechos digitales) contenidas en el Software; (3) usen el Software para acceder, copiar, transferir, transmitir en codigo o retransmitir el contenido de forma que infrinja cualquier ley o los derechos de terceros; o (4) eliminen, oculten o alteren los avisos de copyright de SNSAngelGuard y otros avisos de marcas comerciales u otros derechos de propiedad adjuntos o contenidos en el Software o a los que se pueda acceder desde el Software. El contenido presentado como parte del Software, incluido, pero sin limitarse a ello, las imagenes fotograficas y los datos cartograficos (el ?Contenido?), esta protegido por los derechos de propiedad intelectual que posee SNSAngelGuard, otros proveedores de licencia y partners, y terceros que proporcionan dicho Contenido a SNSAngelGuard. El usuario no puede copiar, distribuir, mostrar, modificar ni utilizar de cualquier otro modo el Contenido (ni puede permitir que otras personas lo hagan), salvo si accede a el a traves del Software, a menos que SNSAngelGuard o los propietarios del Contenido le hayan dado autorizacion explicita para hacerlo en un acuerdo independiente. Ni SNSAngelGuard ni sus proveedores de licencias realizan declaracion ni garantia alguna con respecto a la precision o integridad de esta informacion.\n\n                        b. Terceras partes. Los datos de los contenidos de mapas del Software se proporcionan bajo la licencia de los proveedores de licencia de SNSAngelGuard, incluido Tele Atlas North America, Inc. (?TANA?, los ?Datos de TANA?), y estan sujetos a los derechos de propiedad intelectual que posean (o tengan licencia para ellos) TANA o los otros proveedores de licencia. El usuario se compromete a no realizar ninguna copia ni divulgacion de este material sin autorizacion y se le pueden pedir responsabilidades en su caso. El usuario se compromete a no utilizar ni distribuir informacion cartografica con fines comerciales. Al utilizar el Software, el usuario acepta convertir a TANA en tercero beneficiario de este acuerdo. El uso que se realice de los Datos de TANA esta sujeto a restricciones adicionales descritas en la pagina de Avisos legales.\n                        4. ACTUALIZACIONES AUTOMaTICAS\n\n                        El Software se puede comunicar en ocasiones con los servidores de SNSAngelGuard para comprobar si hay disponibles actualizaciones del mismo, como soluciones para errores, parches, funciones mejoradas, complementos ausentes y versiones nuevas (colectivamente denominados \"Actualizaciones\"). Al instalar el Software, el usuario acepta solicitar y recibir Actualizaciones de forma automatica.\n                        5. DERECHOS RESTRINGIDOS POR EL GOBIERNO DE EE.UU.\n\n                        Si se accede al Software o se utiliza este por parte del Gobierno de los Estados Unidos, o en su nombre, este uso o acceso estara sujeto a la siguiente clausula. El Software y toda la documentacion relacionada se consideran \"software informatico comercial\" y \"documentacion de software informatico comercial\" respectivamente, con el significado correspondiente a estos terminos en las normativas federales de adquisiciones civiles y militares de los Estados Unidos y de sus leyes complementarias. Si el usuario del Software es una agencia, departamento, empleado u otra entidad del Gobierno de los Estados Unidos de America, el uso, duplicacion, reproduccion, publicacion, modificacion, divulgacion o transferencia del Software, incluidos los datos y manuales tecnicos, estara restringido segun los terminos, condiciones y clausulas incluidos en estas Condiciones de uso. De acuerdo con la Normativa de adquisiciones federales (Federal Acquisition Regulation) 12.212 para agencias civiles y el Suplemento 227.7202 de esta Normativa para agencias militares, el uso del Software esta ademas restringido por estas Condiciones de uso.\n                        6. RESTRICCIONES DE EXPORTACIoN\n\n                        El Software esta sujeto a los controles a la exportacion de los Estados Unidos. Al descargar el Software, el usuario asume la responsabilidad exclusiva de cumplir con todas las regulaciones sobre el control a las exportaciones de los Estados Unidos, incluida la Normativa regulatoria de la administracion de exportaciones (EAR, por sus siglas en ingles), y todos los programas de sanciones, incluidos los administrados por la Oficina de control de los activos extranjeros (OFAC, por sus siglas en ingles) del Departamento del Tesoro de los Estados Unidos y todas las demas regulaciones sobre el comercio internacional aplicables. El usuario se compromete a no descargar ni utilizar el Software sin todos los permisos requeridos en cualquiera de los destinos proscritos (incluidos Corea del Norte, Cuba, Iran, Siria y Sudan), en nombre de cualquier entidad o persona proscrita, para cualquier uso proscrito o de ninguna otra forma que contradiga estas regulaciones a la exportacion o programas de sanciones. Al descargar o utilizar el Software, el usuario declara y garantiza que no es un usuario final proscrito y que no va a utilizar este software para ningun uso final proscrito segun estas regulaciones.\n                        7. CUMPLIMIENTO DE LAS LEYES Y DE LAS POLiTICAS DE SNSAngelGuard\n\n                        El usuario acepta cumplir todas las leyes y regulaciones locales relativas a la descarga, instalacion y uso del Software. El usuario acepta cumplir cualquier directiva o normativa aplicable que SNSAngelGuard pueda publicar en algun momento a su sola discrecion. Como ejemplo, y sin que sirva como limitacion, el usuario acepta que cuando utilice el software NO:\n\n                        * difamara, insultara, acosara, acechara, amenazara ni violara de ninguna otra forma los derechos legales (como los derechos de privacidad y publicidad) de terceros,\n                        * subira, publicara, enviara por correo electronico, transmitira ni hara asequible de ninguna otra forma ningun tipo de contenido inapropiado, difamatorio, infractor, obsceno ni ilegal,\n                        * subira, publicara, enviara por correo electronico, transmitira ni dispondra de ninguna otra forma ningun tipo de contenido que infrinja cualquier derecho de patente, marca comercial, copyright, secreto comercial u otros derechos de propiedad de parte alguna, a no ser que el usuario sea el propietario de dichos derechos o tenga permiso del propietario para publicar dicho contenido,\n                        * descargara ningun archivo publicado por cualquier otro usuario si se sabe, o razonablemente se deberia saber, que no es posible distribuirlo legalmente de dicha manera,\n                        * suplantara la identidad de otra persona o entidad, o falsificara o suprimira cualquier aviso legal, de atribucion de autoria u otros avisos, designaciones de propiedad o etiquetas similares que indiquen el origen o fuente del software, el contenido o de otro material,\n                        * restringira ni prohibira a ningun otro usuario el uso y disfrute de los servicios de SNSAngelGuard,\n                        * usara los servicios de SNSAngelGuard para ningun proposito ilegal o no autorizado,\n                        * suprimira ningun aviso de copyright, de marca comercial o de otros derechos de propiedad incluidos en los servicios de SNSAngelGuard,\n                        * interferira en los servicios, servidores de SNSAngelGuard o con las redes conectadas con los servicios de SNSAngelGuard ni los interrumpira; ni desobedecera ningun requisito, procedimiento, directiva ni regulacion de las redes conectadas a los servicios de SNSAngelGuard,\n                        * usara ningun robot, araña, aplicacion de recuperacion o de busqueda de sitios ni ningun otro dispositivo para recuperar o indexar parte alguna de los servicios de SNSAngelGuard ni recopilara informacion sobre los usuarios para ningun proposito no autorizado,\n                        * enviara contenido que exprese o implique falsamente que dicho contenido esta patrocinado o refrendado por SNSAngelGuard,\n                        * creara cuentas de usuario por medios automatizados o bajo premisas falsas o fraudulentas,\n                        * fomentara ni ofrecera instrucciones sobre actividades ilegales ni fomentara daños fisicos o lesiones contra ningun grupo ni individuo; ni\n                        * transmitira virus, gusanos, defectos, caballos de Troya ni ningun otro tipo de elemento de naturaleza destructiva.\n\n                        8. RESCISIoN\n\n                        El usuario podra rescindir estas Condiciones de uso en cualquier momento eliminando en su totalidad y de forma permanente el Software. Los derechos del usuario se revocaran de forma automatica e inmediata sin aviso por parte de SNSAngelGuard, si incumple cualquier disposicion de estas Condiciones de uso. En tal caso, el usuario debera eliminar de forma inmediata el Software y todo el Contenido. Con la extension maxima permitida por la ley, SNSAngelGuard se reserva el derecho a revocar este acuerdo y la utilizacion por parte del usuario del Software en cualquier momento y por cualquier motivo.\n                        9. PERMANENCIA\n\n                        Las disposiciones de las Secciones 3, 5, 6, 9, 10, 11, 12, 13, 14, 15 y 16 de este acuerdo permaneceran en vigor en caso de rescision o caducidad de estas Condiciones de uso.\n                        10. INDEMNIZACIoN\n\n                        El usuario acepta eximir e indemnizar a SNSAngelGuard y a sus filiales, afiliados, directivos, agentes y empleados en caso de que surja cualquier reclamacion, demanda o accion legal provocada o relacionada de cualquier forma con el uso por parte del usuario del Software o de la violacion de estas Condiciones de uso por parte del usuario, incluida cualquier responsabilidad o gasto que surja de cualquier reclamacion, perdida, daño, demanda, juicio, costes procesales y de abogados de cualquier tipo y naturaleza. En este caso, SNSAngelGuard proveera al usuario aviso por escrito de dichas reclamaciones, demandas o acciones.\n                        11. RENUNCIA A GARANTiAS\n\n                        EL USUARIO ENTIENDE Y ACEPTA EXPRESAMENTE QUE:\n\n                        a) EL USO QUE HAGA DEL SOFTWARE ES A SU PROPIA CUENTA Y RIESGO. EL SOFTWARE SE PROPORCIONA \"TAL CUAL\" Y SIN GARANTiAS DE NINGuN TIPO. SNSAngelGuard Y SUS PROVEEDORES DE LICENCIA RENUNCIAN EXPRESAMENTE, Y EN LA MEDIDA EN QUE LA LEY LO PERMITA, A TODAS LAS GARANTiAS Y CONDICIONES IMPLiCITAS O EXPLiCITAS DE CUALQUIER TIPO INCLUIDAS, SIN LIMITARSE A ELLAS, LAS GARANTiAS Y CONDICIONES IMPLiCITAS DE COMERCIABILIDAD, ADECUACIoN PARA UN FIN PARTICULAR Y NO INFRACCIoN.\n\n                        b) NI SNSAngelGuard NI SUS PROVEEDORES DE LICENCIA OTORGAN GARANTiA ALGUNA (I) DE QUE EL SOFTWARE CUMPLIRa LOS REQUISITOS DEL USUARIO, (II) DE QUE EL SOFTWARE NO TENDRa ERRORES NI FALLOS; (III) CONCERNIENTE A LA SEGURIDAD, FIABILIDAD, PUNTUALIDAD Y RENDIMIENTO DEL SOFTWARE; NI (IV) DE QUE SE CORREGIRa CUALQUIER ERROR DEL SOFTWARE.\n\n                        c) REALIZA CUALQUIER DESCARGA U OBTENCIoN DE MATERIAL O DATOS DE ALGUNA OTRA FORMA MEDIANTE EL USO DEL SOFTWARE A SU PROPIA DISCRECIoN Y RIESGO Y SERa EL uNICO RESPONSABLE POR CUALQUIER DAÑO A SU SISTEMA INFORMaTICO U OTRO DISPOSITIVO, O POR LA PeRDIDA DE INFORMACIoN QUE RESULTE DE DESCARGAR ESE MATERIAL O INFORMACIoN.\n\n                        d) NINGUNA PARTE DEL SOFTWARE ESTa PENSADA PARA SU USO EN LA EXPLOTACIoN DE INSTALACIONES NUCLEARES, SISTEMAS DE REANIMACIoN CARDIOPULMONAR, COMUNICACIONES DE EMERGENCIA, NAVEGACIoN AeREA O SISTEMAS DE COMUNICACIoN, NI EN SISTEMAS DE CONTROL DEL TRaFICO AeREO NI EN NINGUNA OTRA ACTIVIDAD DE ESE TIPO EN LA QUE EL FALLO DEL SOFTWARE PUEDA RESULTAR EN MUERTE, LESIONES PERSONALES O DAÑOS FiSICOS O MEDIOAMBIENTALES GRAVES.\n\n                        e) NINGuN CONSEJO NI INFORMACIoN, YA SEAN ORALES O ESCRITOS, OBTENIDOS DE SNSAngelGuard O DE TERCEROS O MEDIANTE EL USO DEL SOFTWARE OTORGAN NINGUNA GARANTiA QUE NO HAYA SIDO EXPRESAMENTE ESTABLECIDA EN ESTAS CONDICIONES DE USO.\n                        12. LIMITACIoN DE RESPONSABILIDADES\n\n                        EL USUARIO ENTIENDE Y ACEPTA EXPRESAMENTE QUE NI SNSAngelGuard NI SUS PROVEEDORES DE LICENCIA SE HARaN RESPONSABLES DE DAÑO DIRECTO, INDIRECTO, INCIDENTAL, ESPECIAL, DERIVADO NI PUNITIVO ALGUNO, INCLUIDOS, PERO SIN LIMITARSE A ELLOS, DAÑOS POR PeRDIDA DE GANANCIAS, CLIENTELA, USO, DATOS Y OTRAS PeRDIDAS INTANGIBLES (INCLUSO EN CASO DE QUE SNSAngelGuard HAYA SIDO ADVERTIDO DE LA POSIBILIDAD DE ESTOS DAÑOS) QUE SEAN RESULTADO DE:\n\n                        (I) EL USO O LA INCAPACIDAD DE USAR EL SOFTWARE O DE ACCEDER A CONTENIDO O A DATOS;\n\n                        (II) COSTE POR OBTENCIoN DE BIENES O SERVICIOS SUSTITUTOS;\n\n                        (III) ACCESO NO AUTORIZADO A SUS TRANSMISIONES O DATOS O ALTERACIoN DE LOS MISMOS; O (V) CUALQUIER OTRA CUESTIoN RELACIONADA CON EL SOFTWARE.\n\n                        LAS LIMITACIONES ANTERIORES SE APLICARaN INDEPENDIENTEMENTE DE UN FALLO DEL PROPoSITO ESENCIAL DE CUALQUIER RECURSO LEGAL LIMITADO Y CON EL ALCANCE TOTAL PERMITIDO POR LEY. BAJO NINGUNA CIRCUNSTANCIA, SNSAngelGuard O CUALQUIERA DE LAS COMPAÑiAS DE TERCEROS QUE OFRECEN SU SOFTWARE O SU CONTENIDO JUNTO CON EL SOFTWARE O A TRAVeS DE eL SERaN RESPONSABLES ANTE NINGuN USUARIO POR EL USO O EL MAL USO DEL SOFTWARE O DEL SOFTWARE O EL CONTENIDO DE TERCEROS. ESTA LIMITACIoN DE RESPONSABILIDADES SE APLICARa A FIN DE EVITAR EL OTORGAMIENTO DE CUALQUIER COMPENSACIoN POR DAÑOS DIRECTOS, INDIRECTOS, INCIDENTALES, CONSECUENTES, ESPECIALES, EJEMPLARES Y PUNITIVOS, INDEPENDIENTEMENTE DE SI ESTAS RECLAMACIONES SE BASAN EN GARANTiAS, CONTRATOS, AGRAVIOS (INCLUIDA LA NEGLIGENCIA) U OTROS (INCLUSO SI SNSAngelGuard O UNA DE LAS COMPAÑiAS DE SOFTWARE DE TERCEROS O LOS PROVEEDORES DE CONTENIDO HAN SIDO ADVERTIDOS DE LA POSIBILIDAD DE TALES DAÑOS). ESTA LIMITACIoN DE RESPONSABILIDADES SE APLICARa TANTO SI LOS DAÑOS PROVIENEN DEL USO O EL MAL USO DEL SOFTWARE, COMO DE LA INCAPACIDAD DE USARLO O DE LA CONFIANZA DEPOSITADA EN EL MISMO, Y EN EL SOFTWARE O EL CONTENIDO DE TERCEROS DISPONIBLE JUNTO CON EL SOFTWARE O A TRAVeS DE eL; O DE LA INTERRUPCIoN, SUSPENSIoN O FINALIZACIoN DEL SOFTWARE Y DEL SOFTWARE O EL CONTENIDO DE TERCEROS DISPONIBLE JUNTO CON EL SOFTWARE O A TRAVeS DE eL (INCLUIDOS LOS DAÑOS SUFRIDOS POR TERCEROS). ESTA LIMITACIoN SE APLICARa INDEPENDIENTEMENTE DE NO HABERSE CONSEGUIDO EL PROPoSITO ESENCIAL DE CUALQUIER SOLUCIoN O RECTIFICACIoN Y CON EL TOTAL ALCANCE PERMITIDO POR LA LEY.\n                        13. EXCLUSIONES Y LIMITACIONES\n\n                        NINGUNO DE LOS COMPONENTES DE ESTE ACUERDO PRETENDE EXCLUIR O LIMITAR NINGUNA CONDICIoN, GARANTiA, DERECHO O RESPONSABILIDAD QUE NO PUEDA EXCLUIRSE O LIMITARSE LEGALMENTE. ALGUNOS ESTADOS O JURISDICCIONES NO PERMITEN LA EXCLUSIoN DE GARANTiAS IMPLiCITAS. POR ELLO, ES POSIBLE QUE LAS EXCLUSIONES ANTERIORES NO SEAN APLICABLES EN SU CASO. ASIMISMO, PODRaN APLICaRSELE OTROS DERECHOS, QUE VARiAN EN FUNCIoN DEL ESTADO Y LA JURISDICCIoN.\n                        14. AUSENCIA DE BENEFICIARIOS TERCEROS\n\n                        El usuario acepta que, a menos que se indique expresamente lo contrario en estas Condiciones de uso, no habra ningun beneficiario tercero de estas Condiciones de uso.\n                        15. SERVICIOS DE SNSAngelGuard Y PRODUCTOS Y SERVICIOS DE TERCEROS\n\n                        Parte del Software esta diseñado para su uso junto a las busquedas de SNSAngelGuard y otros servicios. Por lo tanto, cada vez que utilice el Software, el usuario se compromete a cumplir las Condiciones de uso de SNSAngelGuard descritas en http://www.SNSAngelGuard.es/accounts/TOS.\n                        16. DISPOSICIONES VARIAS\n\n                        a) Eleccion de jurisdiccion y tribunal. Estas Condiciones de uso se regiran e interpretaran de acuerdo con las leyes del estado de California; toda disposicion asociada con los conflictos de leyes aplicables en California o en su estado o pais de residencia no tendra efecto. Si, por alguna razon, un tribunal de jurisdiccion competente determina que una clausula o parte de estas Condiciones de uso no es exigible, el resto de estas Condiciones de uso conservara su vigencia y efecto.\n\n                        b) Renuncia y separacion de terminos. El hecho de que SNSAngelGuard no ejercite o aplique cualquiera de los derechos o disposiciones de estas Condiciones de uso no constituye una renuncia a dicho derecho o disposicion. Si cualquiera de las disposiciones de estas Condiciones de uso es considerada invalida por un tribunal de jurisdiccion competente, las partes acuerdan que dicho tribunal debe esforzarse en considerar las intenciones de las partes tal y como se reflejan en la disposicion, y que las demas disposiciones de estas Condiciones de uso permaneceran en pleno vigor y efecto.\n\n                        c) Exencion de derechos. El usuario manifiesta su acuerdo en que, independientemente de cualquier estatuto o ley que disponga lo contrario, cualquier reclamacion o causa de accion que resulte del uso del Software o de estas Condiciones de uso o que este relacionada con ellas, se llevara a cabo dentro del plazo de un (1) año desde la aparicion de dicha reclamacion o causa de accion o prescribira para siempre.\n\n                        d) Estas Condiciones de uso constituyen el acuerdo total entre las partes con respecto al tema objeto del presente documento, y sustituyen y reemplazan todo acuerdo o entendimiento previo o actual, sea escrito u oral, sobre este. La renuncia a cualquiera de las clausulas de estas Condiciones de uso sera efectiva solo si se tramita por escrito y contiene la firma de SNSAngelGuard o de los terceros que ofrezcan su software junto con el Software o a traves de el.','Aceptar','Cancelar','Condiciones y T&eacute;rminos de Aceptaci&oacute;n','Configuraci&oacute;n','Configuracion;Angeles;Vigilantes;','Guardar','Selecciona tus Angeles','Elige tus Angeles de entre tus contactos en Facebook','Importa un contacto de tu cuenta Gmail;Añade otros contactos;','Nombre','Email','Importar ','Ver Todos;Seleccionados;No seleccionados','Eligele como tu Angel','Configura tus Vigilantes','Vigilantes','Control de Muro;Control de Amigos;Control de Privacidad;Control de Visitas;','Descripcion del Vigilante;Cuando est&aacute activado, realiza un control de las edades de cada amigo, enviando cualquier incidencia al Tutor de la aplicaci&oacuten;Cuando est&aacute activado, comprueba que no exista lenguaje ofensivo en los mensajes del muro, enviando cualquier incidencia al Tutor de la aplicaci&oacuten;Cuando est&aacute activado, comprueba que el nivel de privacidad del usuario no sea demasiado permisivo, enviando cualquier incidencia al Tutor de la aplicaci&oacuten;Cuando est&aacute activado, comprueba el nivel de visitas que ha tenido el perfil del usuario durante el periodo de tiempo transcurrido desde la &uacuteltima comprobaci&oacuten del perfil, enviando cualquier incidencia al Tutor de la aplicaci&oacuten;','Frecuencia de Notificaciones','Cada día;Cada semana;Cada dos semanas;Cada mes;Cada dos meses;Cada seis meses;Cada año;','Angeles','SNSAngelGuardFB: Autorización para el envío de notificaciones','desea que ústed controle su actividad social en Facebook.\n\n                                    Si acepta dicha autorización, se le enviará una serie de notificaciones para que pueda realizar un seguimiento personalizado de su actividad social.\n\n                                    Si por el contrario, cancela la autorización, no se le volverá a enviar ninguna notificación.','Aceptar','Cancelar',' es una herramienta software desarrollada por la Universidad de Alcalá de Henares, España.','SNSAngelGuardFB: Identificación de Usuario','Nombre','Cerrar','Importar un contacto de tu cuenta Google','Selecciona un contacto de tu cuenta Google','Iniciar Sesion Google','Nombre','Email','Aceptar','Cancelar','Necesitas ayuda?;Ayuda; ¿Qué es un Angel?;Un Ángel es una persona que recibe informes de la actividad que usted genera en Facebook. Cada vez que se produzca una anomalía en la información de su Perfil Social, su Ángel recibirá detalladamente los datos de ésta.; ¿Qué es un Vigilante?;Un Vigilante en una herramienta software que se ejecuta dentro de Facebook. Detecta las posibles amenazas dentro de su perfil y elabora informes que enviará a sus Angeles para que éstos tengan constancia de su actividad social.<br><br>Actualmente, existen cuatro Vigilantes: <br><br>- Filtro de Control de Muro: Realiza un control sobre los mensajes del muro del usuario en cuestión, detectando el vocabulario ofensivo que pudiera existir. <br><br>- Filtro de Control de Amigos: Realiza un control sobre los amigos del usuario en cuestión, detectando cuales de ellos han indicado su edad, y si ésta sobrepasa un límite determinado.<br><br>- Filtro de Control de Privacidad: Realiza un control sobre la configuración de la privacidad del usuario, detectando si su perfil es demasiado permisivo para acceder a su información personal. <br><br>- Filtro de Control de Visitas: Realiza un control sobre las últimas visitas y a quién pertenecen, sobre el perfil del usuario.; Configuración de un Vigilante;Para configurar un Vigilante son necesarias dos acciones<br><br>1. Seleccionar un Ángel o Ángeles a los que quieres que controlen tu actividad. Los Ángeles son seleccionados en la pestaña \"Ángeles\" y posteriormente, en la pestaña \"Vigilantes\", se podrán asociar de manera individual a cada filtro.<br><br>2. Configurar la frecuencia a la que SNSAngelGuard enviará informes a tus Ángeles, informándoles de tu actividad en Facebook.<br>;','Debes elegir al menos un angel;Datos guardados correctamente;Guardando datos...;Cargando datos...;Espere, por favor;Angel correctamente eliminado!;Angel correctamente guardado!;Error;Se ha producido un error en la aplicación... ;Detalles','Información','Datos guardados correctamente;Usuario ya confirmado anteriormente;Error: Angel no existente;','SNSAngelGuard Aviso: Angel Eliminado; le ha borrado de su lista de Angeles;','SNSAngelGuard: Notificación de Actividad; SNSAngelGuad Notificación: Usuario ;En el comentario ; del post ; existe lenguaje ofensivo. ;No se han encontrado anomalías en el muro del usuario.; no ha especificado su fecha de nacimiento. ; es demasiado mayor para ;No se han encontrado anomalías en las amistades del usuario.;No se han encontrado anomalías en la configuración de Privacidad del usuario.;No se han encontrado anomalías en las últimas visitas al perfil del usuario.;','Añadir nuevo Angel;Editar;Cancelar;Eliminar;Guardar;','Ranking de tus amigos de Facebook con los que compartes más contactos;Ranking de tus amigos de Facebook con los que compartes menos contactos;Numero de mensajes de tus amigos en tu muro de Facebook;');
/*!40000 ALTER TABLE `locale_settings` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `location_facebook`
--

DROP TABLE IF EXISTS `location_facebook`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `location_facebook` (
  `id_location_facebook` int(11) NOT NULL,
  `CITY` varchar(45) DEFAULT NULL,
  `STATE` varchar(45) DEFAULT NULL,
  `COUNTRY` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_location_facebook`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `location_facebook`
--

LOCK TABLES `location_facebook` WRITE;
/*!40000 ALTER TABLE `location_facebook` DISABLE KEYS */;
/*!40000 ALTER TABLE `location_facebook` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `location_facebook_has_user_facebook`
--

DROP TABLE IF EXISTS `location_facebook_has_user_facebook`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `location_facebook_has_user_facebook` (
  `location_facebook_id_location_facebook` int(11) NOT NULL,
  `user_facebook_id_user_facebook` varchar(100) NOT NULL,
  PRIMARY KEY (`location_facebook_id_location_facebook`,`user_facebook_id_user_facebook`),
  KEY `fk_location_facebook_has_user_facebook_user_facebook1` (`user_facebook_id_user_facebook`),
  CONSTRAINT `fk_location_facebook_has_user_facebook_location_facebook1` FOREIGN KEY (`location_facebook_id_location_facebook`) REFERENCES `location_facebook` (`id_location_facebook`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_location_facebook_has_user_facebook_user_facebook1` FOREIGN KEY (`user_facebook_id_user_facebook`) REFERENCES `user_facebook` (`id_user_facebook`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `location_facebook_has_user_facebook`
--

LOCK TABLES `location_facebook_has_user_facebook` WRITE;
/*!40000 ALTER TABLE `location_facebook_has_user_facebook` DISABLE KEYS */;
/*!40000 ALTER TABLE `location_facebook_has_user_facebook` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `location_facebook_has_user_facebook_CURRENT_LOCATION`
--

DROP TABLE IF EXISTS `location_facebook_has_user_facebook_CURRENT_LOCATION`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `location_facebook_has_user_facebook_CURRENT_LOCATION` (
  `location_facebook_id_location_facebook` int(11) NOT NULL,
  `user_facebook_id_user_facebook` varchar(100) NOT NULL,
  `ZIP` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`location_facebook_id_location_facebook`,`user_facebook_id_user_facebook`),
  KEY `fk_location_facebook_has_user_facebook_user_facebook2` (`user_facebook_id_user_facebook`),
  CONSTRAINT `fk_location_facebook_has_user_facebook_location_facebook2` FOREIGN KEY (`location_facebook_id_location_facebook`) REFERENCES `location_facebook` (`id_location_facebook`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_location_facebook_has_user_facebook_user_facebook2` FOREIGN KEY (`user_facebook_id_user_facebook`) REFERENCES `user_facebook` (`id_user_facebook`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `location_facebook_has_user_facebook_CURRENT_LOCATION`
--

LOCK TABLES `location_facebook_has_user_facebook_CURRENT_LOCATION` WRITE;
/*!40000 ALTER TABLE `location_facebook_has_user_facebook_CURRENT_LOCATION` DISABLE KEYS */;
/*!40000 ALTER TABLE `location_facebook_has_user_facebook_CURRENT_LOCATION` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `privacy_facebook`
--

DROP TABLE IF EXISTS `privacy_facebook`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `privacy_facebook` (
  `id_privacy_facebook` int(11) NOT NULL,
  `UID` varchar(45) DEFAULT NULL,
  `stream_facebook_post_id` varchar(100) NOT NULL,
  PRIMARY KEY (`id_privacy_facebook`),
  KEY `fk_privacy_facebook_stream_facebook1` (`stream_facebook_post_id`),
  CONSTRAINT `fk_privacy_facebook_stream_facebook1` FOREIGN KEY (`stream_facebook_post_id`) REFERENCES `stream_facebook` (`post_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `privacy_facebook`
--

LOCK TABLES `privacy_facebook` WRITE;
/*!40000 ALTER TABLE `privacy_facebook` DISABLE KEYS */;
/*!40000 ALTER TABLE `privacy_facebook` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `relationship_facebook`
--

DROP TABLE IF EXISTS `relationship_facebook`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `relationship_facebook` (
  `id_relationship_facebook` int(11) NOT NULL,
  `DESCRIPTION` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_relationship_facebook`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `relationship_facebook`
--

LOCK TABLES `relationship_facebook` WRITE;
/*!40000 ALTER TABLE `relationship_facebook` DISABLE KEYS */;
/*!40000 ALTER TABLE `relationship_facebook` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sample_likes_facebook`
--

DROP TABLE IF EXISTS `sample_likes_facebook`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sample_likes_facebook` (
  `id_sample_likes_facebook` int(11) NOT NULL,
  `UID` varchar(45) DEFAULT NULL,
  `likes_facebook_id_likes_facebook` int(11) NOT NULL,
  PRIMARY KEY (`id_sample_likes_facebook`),
  KEY `fk_sample_likes_facebook_likes_facebook1` (`likes_facebook_id_likes_facebook`),
  CONSTRAINT `fk_sample_likes_facebook_likes_facebook1` FOREIGN KEY (`likes_facebook_id_likes_facebook`) REFERENCES `likes_facebook` (`id_likes_facebook`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sample_likes_facebook`
--

LOCK TABLES `sample_likes_facebook` WRITE;
/*!40000 ALTER TABLE `sample_likes_facebook` DISABLE KEYS */;
/*!40000 ALTER TABLE `sample_likes_facebook` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `settings_angels`
--

DROP TABLE IF EXISTS `settings_angels`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `settings_angels` (
  `uid_angel` int(11) NOT NULL AUTO_INCREMENT,
  `id_angel` varchar(100) NOT NULL,
  `name_angel` varchar(200) NOT NULL,
  `img_angel` varchar(200) NOT NULL,
  `type_angel` varchar(10) NOT NULL,
  `accept_angel` varchar(1) NOT NULL,
  `user_prop_angel` varchar(100) NOT NULL,
  `confirm_angel` varchar(1) NOT NULL,
  PRIMARY KEY (`uid_angel`)
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `settings_angels`
--

LOCK TABLES `settings_angels` WRITE;
/*!40000 ALTER TABLE `settings_angels` DISABLE KEYS */;
/*!40000 ALTER TABLE `settings_angels` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `settings_fltFriends`
--

DROP TABLE IF EXISTS `settings_fltFriends`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `settings_fltFriends` (
  `user_settings_uid` varchar(100) NOT NULL,
  `frec_fltFriends` varchar(10) NOT NULL,
  `active_fltFriends` varchar(1) NOT NULL,
  `last_check` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`user_settings_uid`) USING BTREE,
  CONSTRAINT `fk_settings_fltFriends_user_settings_uid` FOREIGN KEY (`user_settings_uid`) REFERENCES `user_settings` (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `settings_fltFriends`
--

LOCK TABLES `settings_fltFriends` WRITE;
/*!40000 ALTER TABLE `settings_fltFriends` DISABLE KEYS */;
/*!40000 ALTER TABLE `settings_fltFriends` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `settings_fltFriends_has_settings_angels`
--

DROP TABLE IF EXISTS `settings_fltFriends_has_settings_angels`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `settings_fltFriends_has_settings_angels` (
  `settings_fltFriends_user_settings_uid` varchar(100) NOT NULL,
  `settings_angels_uid_angel` int(11) NOT NULL,
  PRIMARY KEY (`settings_fltFriends_user_settings_uid`,`settings_angels_uid_angel`) USING BTREE,
  KEY `fk_settings_fltFriends_has_settings_angels_uid_angel` (`settings_angels_uid_angel`),
  CONSTRAINT `fk_settings_fltFriends_has_settings_angels_uid_angel` FOREIGN KEY (`settings_angels_uid_angel`) REFERENCES `settings_angels` (`uid_angel`),
  CONSTRAINT `fk_settings_fltFriends_has_settings_angels_user_settings_uid` FOREIGN KEY (`settings_fltFriends_user_settings_uid`) REFERENCES `settings_fltFriends` (`user_settings_uid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `settings_fltFriends_has_settings_angels`
--

LOCK TABLES `settings_fltFriends_has_settings_angels` WRITE;
/*!40000 ALTER TABLE `settings_fltFriends_has_settings_angels` DISABLE KEYS */;
/*!40000 ALTER TABLE `settings_fltFriends_has_settings_angels` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `settings_fltPriv`
--

DROP TABLE IF EXISTS `settings_fltPriv`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `settings_fltPriv` (
  `user_settings_uid` varchar(100) NOT NULL,
  `frec_fltPriv` varchar(10) NOT NULL,
  `active_fltPriv` varchar(1) NOT NULL,
  `last_check` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`user_settings_uid`) USING BTREE,
  CONSTRAINT `fk_settings_fltPriv_user_settings_uid` FOREIGN KEY (`user_settings_uid`) REFERENCES `user_settings` (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `settings_fltPriv`
--

LOCK TABLES `settings_fltPriv` WRITE;
/*!40000 ALTER TABLE `settings_fltPriv` DISABLE KEYS */;
/*!40000 ALTER TABLE `settings_fltPriv` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `settings_fltPriv_has_settings_angels`
--

DROP TABLE IF EXISTS `settings_fltPriv_has_settings_angels`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `settings_fltPriv_has_settings_angels` (
  `settings_fltPriv_user_settings_uid` varchar(100) NOT NULL,
  `settings_angels_uid_angel` int(11) NOT NULL,
  PRIMARY KEY (`settings_fltPriv_user_settings_uid`,`settings_angels_uid_angel`) USING BTREE,
  KEY `fk_settings_fltPriv_has_settings_angels_uid_angel` (`settings_angels_uid_angel`),
  CONSTRAINT `fk_settings_fltPriv_has_settings_angels_uid_angel` FOREIGN KEY (`settings_angels_uid_angel`) REFERENCES `settings_angels` (`uid_angel`),
  CONSTRAINT `fk_settings_fltPriv_has_settings_angels_user_settings_uid` FOREIGN KEY (`settings_fltPriv_user_settings_uid`) REFERENCES `settings_fltPriv` (`user_settings_uid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `settings_fltPriv_has_settings_angels`
--

LOCK TABLES `settings_fltPriv_has_settings_angels` WRITE;
/*!40000 ALTER TABLE `settings_fltPriv_has_settings_angels` DISABLE KEYS */;
/*!40000 ALTER TABLE `settings_fltPriv_has_settings_angels` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `settings_fltVist`
--

DROP TABLE IF EXISTS `settings_fltVist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `settings_fltVist` (
  `user_settings_uid` varchar(100) NOT NULL,
  `frec_fltVist` varchar(10) NOT NULL,
  `active_fltVist` varchar(1) NOT NULL,
  `last_check` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`user_settings_uid`) USING BTREE,
  CONSTRAINT `fk_settings_fltVist_user_settings_uid` FOREIGN KEY (`user_settings_uid`) REFERENCES `user_settings` (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `settings_fltVist`
--

LOCK TABLES `settings_fltVist` WRITE;
/*!40000 ALTER TABLE `settings_fltVist` DISABLE KEYS */;
/*!40000 ALTER TABLE `settings_fltVist` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `settings_fltVist_has_settings_angels`
--

DROP TABLE IF EXISTS `settings_fltVist_has_settings_angels`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `settings_fltVist_has_settings_angels` (
  `settings_fltVist_user_settings_uid` varchar(100) NOT NULL,
  `settings_angels_uid_angel` int(11) NOT NULL,
  PRIMARY KEY (`settings_fltVist_user_settings_uid`,`settings_angels_uid_angel`) USING BTREE,
  KEY `fk_settings_fltVist_has_settings_angels_uid_angel` (`settings_angels_uid_angel`),
  CONSTRAINT `fk_settings_fltVist_has_settings_angels_uid_angel` FOREIGN KEY (`settings_angels_uid_angel`) REFERENCES `settings_angels` (`uid_angel`),
  CONSTRAINT `fk_settings_fltVist_has_settings_angels_user_settings_uid` FOREIGN KEY (`settings_fltVist_user_settings_uid`) REFERENCES `settings_fltVist` (`user_settings_uid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `settings_fltVist_has_settings_angels`
--

LOCK TABLES `settings_fltVist_has_settings_angels` WRITE;
/*!40000 ALTER TABLE `settings_fltVist_has_settings_angels` DISABLE KEYS */;
/*!40000 ALTER TABLE `settings_fltVist_has_settings_angels` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `settings_fltWall`
--

DROP TABLE IF EXISTS `settings_fltWall`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `settings_fltWall` (
  `user_settings_uid` varchar(100) NOT NULL,
  `frec_fltWall` varchar(100) NOT NULL,
  `active_fltWall` varchar(1) NOT NULL,
  `last_check` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`user_settings_uid`) USING BTREE,
  CONSTRAINT `fk_settings_fltWall_user_settings_uid` FOREIGN KEY (`user_settings_uid`) REFERENCES `user_settings` (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `settings_fltWall`
--

LOCK TABLES `settings_fltWall` WRITE;
/*!40000 ALTER TABLE `settings_fltWall` DISABLE KEYS */;
/*!40000 ALTER TABLE `settings_fltWall` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `settings_fltWall_has_settings_angels`
--

DROP TABLE IF EXISTS `settings_fltWall_has_settings_angels`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `settings_fltWall_has_settings_angels` (
  `settings_fltWall_user_settings_uid` varchar(100) NOT NULL,
  `settings_angels_uid_angel` int(11) NOT NULL,
  PRIMARY KEY (`settings_fltWall_user_settings_uid`,`settings_angels_uid_angel`) USING BTREE,
  KEY `fk_settings_fltWall_has_settings_angels_uid_angel` (`settings_angels_uid_angel`),
  CONSTRAINT `fk_settings_fltWall_has_settings_angels_uid_angel` FOREIGN KEY (`settings_angels_uid_angel`) REFERENCES `settings_angels` (`uid_angel`),
  CONSTRAINT `fk_settings_fltWall_has_settings_angels_user_settings_uid` FOREIGN KEY (`settings_fltWall_user_settings_uid`) REFERENCES `settings_fltWall` (`user_settings_uid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `settings_fltWall_has_settings_angels`
--

LOCK TABLES `settings_fltWall_has_settings_angels` WRITE;
/*!40000 ALTER TABLE `settings_fltWall_has_settings_angels` DISABLE KEYS */;
/*!40000 ALTER TABLE `settings_fltWall_has_settings_angels` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stream_facebook`
--

DROP TABLE IF EXISTS `stream_facebook`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `stream_facebook` (
  `post_id` varchar(100) NOT NULL,
  `viewer_id` varchar(100) DEFAULT NULL,
  `app_id` varchar(100) DEFAULT NULL,
  `source_id` varchar(100) DEFAULT NULL,
  `updated_time` timestamp NULL DEFAULT NULL,
  `created_time` timestamp NULL DEFAULT NULL,
  `filter_key` varchar(100) DEFAULT NULL,
  `attribution` varchar(100) DEFAULT NULL,
  `actor_id` varchar(100) DEFAULT NULL,
  `target_id` varchar(100) DEFAULT NULL,
  `message` mediumtext CHARACTER SET utf8,
  `app_data` varchar(10000) DEFAULT NULL,
  `attachment` varchar(10000) DEFAULT NULL,
  `type` varchar(100) DEFAULT NULL,
  `permalink` varchar(300) DEFAULT NULL,
  `xid` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`post_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stream_facebook`
--

LOCK TABLES `stream_facebook` WRITE;
/*!40000 ALTER TABLE `stream_facebook` DISABLE KEYS */;
/*!40000 ALTER TABLE `stream_facebook` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `type_affiliations_facebook`
--

DROP TABLE IF EXISTS `type_affiliations_facebook`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `type_affiliations_facebook` (
  `id_type_affiliations_facebook` int(11) NOT NULL,
  `TYPE` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id_type_affiliations_facebook`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `type_affiliations_facebook`
--

LOCK TABLES `type_affiliations_facebook` WRITE;
/*!40000 ALTER TABLE `type_affiliations_facebook` DISABLE KEYS */;
/*!40000 ALTER TABLE `type_affiliations_facebook` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `url_openSocial`
--

DROP TABLE IF EXISTS `url_openSocial`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `url_openSocial` (
  `id_url_openSocial` int(11) NOT NULL,
  `ADDRESS` varchar(100) DEFAULT NULL,
  `LINK_TEST` varchar(100) DEFAULT NULL,
  `TYPE` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id_url_openSocial`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `url_openSocial`
--

LOCK TABLES `url_openSocial` WRITE;
/*!40000 ALTER TABLE `url_openSocial` DISABLE KEYS */;
/*!40000 ALTER TABLE `url_openSocial` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `url_openSocial_has_user_openSocial_PROFILE_VIDEO`
--

DROP TABLE IF EXISTS `url_openSocial_has_user_openSocial_PROFILE_VIDEO`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `url_openSocial_has_user_openSocial_PROFILE_VIDEO` (
  `url_openSocial_id_url_openSocial` int(11) NOT NULL,
  `user_openSocial_id_user_openSocial` varchar(100) NOT NULL,
  PRIMARY KEY (`url_openSocial_id_url_openSocial`,`user_openSocial_id_user_openSocial`),
  KEY `fk_url_openSocial_has_user_openSocial_user_openSocial1` (`user_openSocial_id_user_openSocial`),
  CONSTRAINT `fk_url_openSocial_has_user_openSocial_url_openSocial1` FOREIGN KEY (`url_openSocial_id_url_openSocial`) REFERENCES `url_openSocial` (`id_url_openSocial`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_url_openSocial_has_user_openSocial_user_openSocial1` FOREIGN KEY (`user_openSocial_id_user_openSocial`) REFERENCES `user_openSocial` (`id_user_openSocial`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `url_openSocial_has_user_openSocial_PROFILE_VIDEO`
--

LOCK TABLES `url_openSocial_has_user_openSocial_PROFILE_VIDEO` WRITE;
/*!40000 ALTER TABLE `url_openSocial_has_user_openSocial_PROFILE_VIDEO` DISABLE KEYS */;
/*!40000 ALTER TABLE `url_openSocial_has_user_openSocial_PROFILE_VIDEO` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `user_settings_uid` varchar(100) NOT NULL,
  `SEX` varchar(45) DEFAULT NULL,
  `RELIGION` varchar(450) DEFAULT NULL,
  `RELATIONSHIP_STATUS` varchar(450) DEFAULT NULL,
  `POLITICAL` varchar(450) DEFAULT NULL,
  `ACTIVITIES` varchar(450) DEFAULT NULL,
  `INTERESTS` varchar(450) DEFAULT NULL,
  `IS_APP_USER` tinyint(1) DEFAULT NULL,
  `MUSIC` varchar(450) DEFAULT NULL,
  `TV` varchar(450) DEFAULT NULL,
  `MOVIES` varchar(450) DEFAULT NULL,
  `BOOKS` varchar(450) DEFAULT NULL,
  `ABOUT_ME` varchar(450) DEFAULT NULL,
  `STATUS` varchar(450) DEFAULT NULL,
  `QUOTES` varchar(450) DEFAULT NULL,
  `user_facebook_id_user_facebook` varchar(100) NOT NULL,
  `user_openSocial_id_user_openSocial` varchar(100) NOT NULL,
  PRIMARY KEY (`user_settings_uid`),
  KEY `fk_user_user_settings1` (`user_settings_uid`),
  KEY `fk_user_user_facebook1` (`user_facebook_id_user_facebook`),
  KEY `fk_user_user_openSocial1` (`user_openSocial_id_user_openSocial`),
  CONSTRAINT `fk_user_user_facebook1` FOREIGN KEY (`user_facebook_id_user_facebook`) REFERENCES `user_facebook` (`id_user_facebook`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_user_openSocial1` FOREIGN KEY (`user_openSocial_id_user_openSocial`) REFERENCES `user_openSocial` (`id_user_openSocial`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_user_settings1` FOREIGN KEY (`user_settings_uid`) REFERENCES `user_settings` (`uid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_facebook`
--

DROP TABLE IF EXISTS `user_facebook`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_facebook` (
  `id_user_facebook` varchar(100) NOT NULL,
  `FIRST_NAME` varchar(100) DEFAULT NULL,
  `MIDDLE_NAME` varchar(100) DEFAULT NULL,
  `LAST_NAME` varchar(100) DEFAULT NULL,
  `NAME` varchar(200) DEFAULT NULL,
  `PIC_SMALL` varchar(450) DEFAULT NULL,
  `PIC_BIG` varchar(450) DEFAULT NULL,
  `PIC_SQUARE` varchar(450) DEFAULT NULL,
  `PIC` varchar(450) DEFAULT NULL,
  `PROFILE_UPDATE_TIME` time DEFAULT NULL,
  `BIRTHDAY` varchar(450) DEFAULT NULL,
  `BIRTHDAY_DATE` varchar(450) DEFAULT NULL,
  `SIGNIFICANT_OTHER_ID` varchar(450) DEFAULT NULL,
  `HS1_NAME` varchar(450) DEFAULT NULL,
  `HS2_NAME` varchar(450) DEFAULT NULL,
  `GRAD_YEAR` int(11) DEFAULT NULL,
  `HS1_ID` varchar(450) DEFAULT NULL,
  `HS2_ID` varchar(450) DEFAULT NULL,
  `NOTES_COUNT` int(11) DEFAULT NULL,
  `WALL_COUNT` int(11) DEFAULT NULL,
  `ONLINE_PRESENCE` varchar(450) DEFAULT NULL,
  `LOCALE` varchar(450) DEFAULT NULL,
  `PROXIED_EMAIL` varchar(450) DEFAULT NULL,
  `PROFILE_URL` varchar(450) DEFAULT NULL,
  `EMAIL_HASHES` varchar(450) DEFAULT NULL,
  `PIC_SMALL_WITH_LOGO` varchar(450) DEFAULT NULL,
  `PIC_BIG_WITH_LOGO` varchar(450) DEFAULT NULL,
  `PIC_SQUARE_WITH_LOGO` varchar(450) DEFAULT NULL,
  `PIC_WITH_LOGO` varchar(450) DEFAULT NULL,
  `ALLOWED_RESTRICTIONS` varchar(450) DEFAULT NULL,
  `VERIFIED` tinyint(1) DEFAULT NULL,
  `PROFILE_BLURB` varchar(450) DEFAULT NULL,
  `USERNAME` varchar(450) DEFAULT NULL,
  `WEBSITE` varchar(450) DEFAULT NULL,
  `IS_BLOCKED` tinyint(1) DEFAULT NULL,
  `CONTACT_EMAIL` varchar(450) DEFAULT NULL,
  `EMAIL` varchar(450) DEFAULT NULL,
  `MEETING_FOR` varchar(45) DEFAULT NULL,
  `MEETING_SEX` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_user_facebook`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_facebook`
--

LOCK TABLES `user_facebook` WRITE;
/*!40000 ALTER TABLE `user_facebook` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_facebook` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_facebook_has_family_facebook`
--

DROP TABLE IF EXISTS `user_facebook_has_family_facebook`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_facebook_has_family_facebook` (
  `user_facebook_id_user_facebook` varchar(100) NOT NULL,
  `family_facebook_id_family_facebook` int(11) NOT NULL,
  PRIMARY KEY (`user_facebook_id_user_facebook`,`family_facebook_id_family_facebook`),
  KEY `fk_user_facebook_has_family_facebook_family_facebook1` (`family_facebook_id_family_facebook`),
  CONSTRAINT `fk_user_facebook_has_family_facebook_family_facebook1` FOREIGN KEY (`family_facebook_id_family_facebook`) REFERENCES `family_facebook` (`id_family_facebook`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_facebook_has_family_facebook_user_facebook1` FOREIGN KEY (`user_facebook_id_user_facebook`) REFERENCES `user_facebook` (`id_user_facebook`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_facebook_has_family_facebook`
--

LOCK TABLES `user_facebook_has_family_facebook` WRITE;
/*!40000 ALTER TABLE `user_facebook_has_family_facebook` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_facebook_has_family_facebook` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_facebook_has_friends_facebook`
--

DROP TABLE IF EXISTS `user_facebook_has_friends_facebook`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_facebook_has_friends_facebook` (
  `user_facebook_id_user_facebook` varchar(100) NOT NULL,
  `friends_facebook_USER_UID` varchar(45) NOT NULL,
  PRIMARY KEY (`user_facebook_id_user_facebook`,`friends_facebook_USER_UID`),
  KEY `fk_user_facebook_has_friends_facebook_friends_facebook1` (`friends_facebook_USER_UID`),
  CONSTRAINT `fk_user_facebook_has_friends_facebook_friends_facebook1` FOREIGN KEY (`friends_facebook_USER_UID`) REFERENCES `friends_facebook` (`USER_UID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_facebook_has_friends_facebook_user_facebook1` FOREIGN KEY (`user_facebook_id_user_facebook`) REFERENCES `user_facebook` (`id_user_facebook`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_facebook_has_friends_facebook`
--

LOCK TABLES `user_facebook_has_friends_facebook` WRITE;
/*!40000 ALTER TABLE `user_facebook_has_friends_facebook` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_facebook_has_friends_facebook` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_facebook_has_stream_facebook`
--

DROP TABLE IF EXISTS `user_facebook_has_stream_facebook`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_facebook_has_stream_facebook` (
  `user_facebook_id_user_facebook` varchar(100) NOT NULL,
  `stream_facebook_post_id` varchar(100) NOT NULL,
  PRIMARY KEY (`user_facebook_id_user_facebook`,`stream_facebook_post_id`),
  KEY `fk_user_facebook_has_stream_facebook_stream_facebook1` (`stream_facebook_post_id`),
  CONSTRAINT `fk_user_facebook_has_stream_facebook_stream_facebook1` FOREIGN KEY (`stream_facebook_post_id`) REFERENCES `stream_facebook` (`post_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_facebook_has_stream_facebook_user_facebook1` FOREIGN KEY (`user_facebook_id_user_facebook`) REFERENCES `user_facebook` (`id_user_facebook`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_facebook_has_stream_facebook`
--

LOCK TABLES `user_facebook_has_stream_facebook` WRITE;
/*!40000 ALTER TABLE `user_facebook_has_stream_facebook` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_facebook_has_stream_facebook` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_openSocial`
--

DROP TABLE IF EXISTS `user_openSocial`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_openSocial` (
  `id_user_openSocial` varchar(100) NOT NULL,
  `AGE` int(11) DEFAULT NULL,
  `BODYTYPE_BUILD` varchar(100) DEFAULT NULL,
  `BODYTYPE_EYE_COLOR` varchar(45) DEFAULT NULL,
  `BODYTYPE_HAIR_COLOR` varchar(45) DEFAULT NULL,
  `BODYTYPE_HEIGHT` varchar(45) DEFAULT NULL,
  `BODYTYPE_WEIGHT` varchar(45) DEFAULT NULL,
  `CARS` varchar(450) DEFAULT NULL,
  `CHILDREN` varchar(450) DEFAULT NULL,
  `Address_openSocial_CURRENT_LOCATION` varchar(10) NOT NULL,
  `DATE_OF_BIRTH` date DEFAULT NULL,
  `Drinker_openSocial_id_Drinker_openSocial` int(11) NOT NULL,
  `ETHNICITY` varchar(450) DEFAULT NULL,
  `FASHION` varchar(450) DEFAULT NULL,
  `FOOD` varchar(450) DEFAULT NULL,
  `Gender_openSocial_id_Gender_openSocial` int(11) NOT NULL,
  `HAPPIEST_WHEN` varchar(450) DEFAULT NULL,
  `HEROES` varchar(450) DEFAULT NULL,
  `HUMOR` varchar(450) DEFAULT NULL,
  `JOB_INTERESTS` varchar(450) DEFAULT NULL,
  `LANGUAGES_SPOKEN` varchar(450) DEFAULT NULL,
  `LIVING_ARRANGEMENT` varchar(450) DEFAULT NULL,
  `LookingFor_openSocial_id_LookingFor_openSocial` int(11) NOT NULL,
  `Presence_openSocial_id_Presence_openSocial` int(11) NOT NULL,
  `NICKNAME` varchar(100) DEFAULT NULL,
  `PETS` varchar(450) DEFAULT NULL,
  `PROFILE_URL` varchar(100) DEFAULT NULL,
  `ROMANCE` varchar(100) DEFAULT NULL,
  `SCARED_OF` varchar(450) DEFAULT NULL,
  `Smoker_openSocial_id_Smoker_openSocial` int(11) NOT NULL,
  `SPORTS` varchar(450) DEFAULT NULL,
  `TAGS` varchar(450) DEFAULT NULL,
  `THUMBNAIL_URL` varchar(100) DEFAULT NULL,
  `TIME_ZONE` date DEFAULT NULL,
  `TURNS_OFFS` varchar(450) DEFAULT NULL,
  `TURNS_ONS` varchar(450) DEFAULT NULL,
  `URLS` varchar(450) DEFAULT NULL,
  PRIMARY KEY (`id_user_openSocial`),
  KEY `fk_user_openSocial_Address_openSocial1` (`Address_openSocial_CURRENT_LOCATION`),
  KEY `fk_user_openSocial_Drinker_openSocial1` (`Drinker_openSocial_id_Drinker_openSocial`),
  KEY `fk_user_openSocial_Gender_openSocial1` (`Gender_openSocial_id_Gender_openSocial`),
  KEY `fk_user_openSocial_LookingFor_openSocial1` (`LookingFor_openSocial_id_LookingFor_openSocial`),
  KEY `fk_user_openSocial_Presence_openSocial1` (`Presence_openSocial_id_Presence_openSocial`),
  KEY `fk_user_openSocial_Smoker_openSocial1` (`Smoker_openSocial_id_Smoker_openSocial`),
  CONSTRAINT `fk_user_openSocial_Address_openSocial1` FOREIGN KEY (`Address_openSocial_CURRENT_LOCATION`) REFERENCES `Address_openSocial` (`id_Address_openSocial`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_openSocial_Drinker_openSocial1` FOREIGN KEY (`Drinker_openSocial_id_Drinker_openSocial`) REFERENCES `Drinker_openSocial` (`id_Drinker_openSocial`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_openSocial_Gender_openSocial1` FOREIGN KEY (`Gender_openSocial_id_Gender_openSocial`) REFERENCES `Gender_openSocial` (`id_Gender_openSocial`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_openSocial_LookingFor_openSocial1` FOREIGN KEY (`LookingFor_openSocial_id_LookingFor_openSocial`) REFERENCES `LookingFor_openSocial` (`id_LookingFor_openSocial`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_openSocial_Presence_openSocial1` FOREIGN KEY (`Presence_openSocial_id_Presence_openSocial`) REFERENCES `Presence_openSocial` (`id_Presence_openSocial`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_openSocial_Smoker_openSocial1` FOREIGN KEY (`Smoker_openSocial_id_Smoker_openSocial`) REFERENCES `Smoker_openSocial` (`id_Smoker_openSocial`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_openSocial`
--

LOCK TABLES `user_openSocial` WRITE;
/*!40000 ALTER TABLE `user_openSocial` DISABLE KEYS */;
INSERT INTO `user_openSocial` VALUES ('0000000000',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'0000000000',NULL,1,NULL,NULL,NULL,1,NULL,NULL,NULL,NULL,NULL,NULL,1,1,NULL,NULL,NULL,NULL,NULL,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `user_openSocial` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_openSocial_has_Friends_openSocial`
--

DROP TABLE IF EXISTS `user_openSocial_has_Friends_openSocial`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_openSocial_has_Friends_openSocial` (
  `user_openSocial_id_user_openSocial` int(11) NOT NULL,
  `Friends_openSocial_USER_ID` varchar(45) NOT NULL,
  PRIMARY KEY (`user_openSocial_id_user_openSocial`,`Friends_openSocial_USER_ID`),
  KEY `fk_user_openSocial_has_Friends_openSocial_Friends_openSocial1` (`Friends_openSocial_USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_openSocial_has_Friends_openSocial`
--

LOCK TABLES `user_openSocial_has_Friends_openSocial` WRITE;
/*!40000 ALTER TABLE `user_openSocial_has_Friends_openSocial` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_openSocial_has_Friends_openSocial` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_openSocial_has_Name_openSocial`
--

DROP TABLE IF EXISTS `user_openSocial_has_Name_openSocial`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_openSocial_has_Name_openSocial` (
  `user_openSocial_id_user_openSocial` int(11) NOT NULL,
  `Name_openSocial_id_Name_openSocial` int(11) NOT NULL,
  PRIMARY KEY (`user_openSocial_id_user_openSocial`,`Name_openSocial_id_Name_openSocial`),
  KEY `fk_user_openSocial_has_Name_openSocial_Name_openSocial1` (`Name_openSocial_id_Name_openSocial`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_openSocial_has_Name_openSocial`
--

LOCK TABLES `user_openSocial_has_Name_openSocial` WRITE;
/*!40000 ALTER TABLE `user_openSocial_has_Name_openSocial` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_openSocial_has_Name_openSocial` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_openSocial_has_Organization_openSocial_JOBS`
--

DROP TABLE IF EXISTS `user_openSocial_has_Organization_openSocial_JOBS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_openSocial_has_Organization_openSocial_JOBS` (
  `user_openSocial_id_user_openSocial` int(11) NOT NULL,
  `Organization_openSocial_id_Organization_openSocial` int(11) NOT NULL,
  PRIMARY KEY (`user_openSocial_id_user_openSocial`,`Organization_openSocial_id_Organization_openSocial`),
  KEY `fk_user_openSocial_has_Organization_openSocial_Organization_o1` (`Organization_openSocial_id_Organization_openSocial`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_openSocial_has_Organization_openSocial_JOBS`
--

LOCK TABLES `user_openSocial_has_Organization_openSocial_JOBS` WRITE;
/*!40000 ALTER TABLE `user_openSocial_has_Organization_openSocial_JOBS` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_openSocial_has_Organization_openSocial_JOBS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_openSocial_has_Organization_openSocial_SCHOOLS`
--

DROP TABLE IF EXISTS `user_openSocial_has_Organization_openSocial_SCHOOLS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_openSocial_has_Organization_openSocial_SCHOOLS` (
  `user_openSocial_id_user_openSocial` int(11) NOT NULL,
  `Organization_openSocial_id_Organization_openSocial` int(11) NOT NULL,
  PRIMARY KEY (`user_openSocial_id_user_openSocial`,`Organization_openSocial_id_Organization_openSocial`),
  KEY `fk_user_openSocial_has_Organization_openSocial_Organization_o2` (`Organization_openSocial_id_Organization_openSocial`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_openSocial_has_Organization_openSocial_SCHOOLS`
--

LOCK TABLES `user_openSocial_has_Organization_openSocial_SCHOOLS` WRITE;
/*!40000 ALTER TABLE `user_openSocial_has_Organization_openSocial_SCHOOLS` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_openSocial_has_Organization_openSocial_SCHOOLS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_openSocial_has_url_openSocial_PROFILE_SONGS`
--

DROP TABLE IF EXISTS `user_openSocial_has_url_openSocial_PROFILE_SONGS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_openSocial_has_url_openSocial_PROFILE_SONGS` (
  `user_openSocial_id_user_openSocial` int(11) NOT NULL,
  `url_openSocial_id_url_openSocial` int(11) NOT NULL,
  PRIMARY KEY (`user_openSocial_id_user_openSocial`,`url_openSocial_id_url_openSocial`),
  KEY `fk_user_openSocial_has_url_openSocial_url_openSocial1` (`url_openSocial_id_url_openSocial`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_openSocial_has_url_openSocial_PROFILE_SONGS`
--

LOCK TABLES `user_openSocial_has_url_openSocial_PROFILE_SONGS` WRITE;
/*!40000 ALTER TABLE `user_openSocial_has_url_openSocial_PROFILE_SONGS` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_openSocial_has_url_openSocial_PROFILE_SONGS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_settings`
--

DROP TABLE IF EXISTS `user_settings`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_settings` (
  `uid` varchar(100) NOT NULL,
  `user_name` varchar(100) DEFAULT NULL,
  `user_email` varchar(200) DEFAULT NULL,
  `legal_accepted` varchar(1) DEFAULT NULL,
  `last_check` timestamp NULL DEFAULT NULL,
  `uid_public` varchar(200) CHARACTER SET utf8 DEFAULT NULL,
  `app_activated` varchar(1) DEFAULT NULL,
  `user_session` varchar(400) DEFAULT NULL,
  `locale_settings_id_locale` varchar(100) NOT NULL,
  `backup_check` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`uid`),
  KEY `fk_user_settings_locale_settings1` (`locale_settings_id_locale`),
  CONSTRAINT `fk_user_settings_locale_settings` FOREIGN KEY (`locale_settings_id_locale`) REFERENCES `locale_settings` (`id_locale`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_settings`
--

LOCK TABLES `user_settings` WRITE;
/*!40000 ALTER TABLE `user_settings` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_settings` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_settings_has_guardian_settings`
--

DROP TABLE IF EXISTS `user_settings_has_guardian_settings`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_settings_has_guardian_settings` (
  `user_settings_uid` varchar(100) NOT NULL,
  `guardian_settings_uid_guardian` int(11) NOT NULL,
  PRIMARY KEY (`user_settings_uid`,`guardian_settings_uid_guardian`),
  KEY `fk_user_settings_has_guardian_settings_guardian_settings` (`guardian_settings_uid_guardian`),
  CONSTRAINT `fk_user_settings_has_guardian_settings_guardian_settings` FOREIGN KEY (`guardian_settings_uid_guardian`) REFERENCES `guardian_settings` (`uid_guardian`),
  CONSTRAINT `fk_user_settings_has_guardian_settings_user_settings1` FOREIGN KEY (`user_settings_uid`) REFERENCES `user_settings` (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_settings_has_guardian_settings`
--

LOCK TABLES `user_settings_has_guardian_settings` WRITE;
/*!40000 ALTER TABLE `user_settings_has_guardian_settings` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_settings_has_guardian_settings` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_settings_has_settings_angels`
--

DROP TABLE IF EXISTS `user_settings_has_settings_angels`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_settings_has_settings_angels` (
  `user_settings_uid` varchar(100) NOT NULL,
  `settings_angels_uid_angel` int(11) NOT NULL,
  PRIMARY KEY (`user_settings_uid`,`settings_angels_uid_angel`),
  KEY `fk_user_settings_has_settings_angels_uid_angel` (`settings_angels_uid_angel`),
  CONSTRAINT `fk_user_settings_has_settings_angels_uid` FOREIGN KEY (`user_settings_uid`) REFERENCES `user_settings` (`uid`),
  CONSTRAINT `fk_user_settings_has_settings_angels_uid_angel` FOREIGN KEY (`settings_angels_uid_angel`) REFERENCES `settings_angels` (`uid_angel`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_settings_has_settings_angels`
--

LOCK TABLES `user_settings_has_settings_angels` WRITE;
/*!40000 ALTER TABLE `user_settings_has_settings_angels` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_settings_has_settings_angels` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `work_history_facebook`
--

DROP TABLE IF EXISTS `work_history_facebook`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `work_history_facebook` (
  `id_work_history_facebook` int(11) NOT NULL,
  `LOCATION` varchar(100) DEFAULT NULL,
  `COMPANY_NAME` varchar(100) DEFAULT NULL,
  `DESCRIPTION` varchar(100) DEFAULT NULL,
  `POSITION` varchar(100) DEFAULT NULL,
  `START_DATE` varchar(7) DEFAULT NULL,
  `END_DATE` varchar(7) DEFAULT NULL,
  `user_facebook_id_user_facebook` varchar(100) NOT NULL,
  PRIMARY KEY (`id_work_history_facebook`),
  KEY `fk_work_history_facebook_user_facebook1` (`user_facebook_id_user_facebook`),
  CONSTRAINT `fk_work_history_facebook_user_facebook1` FOREIGN KEY (`user_facebook_id_user_facebook`) REFERENCES `user_facebook` (`id_user_facebook`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `work_history_facebook`
--

LOCK TABLES `work_history_facebook` WRITE;
/*!40000 ALTER TABLE `work_history_facebook` DISABLE KEYS */;
/*!40000 ALTER TABLE `work_history_facebook` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-06-30 23:53:37

-- MySQL dump 10.13  Distrib 8.2.0, for Linux (x86_64)
--
-- Host: localhost    Database: oesm
-- ------------------------------------------------------
-- Server version	8.2.0

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
-- Table structure for table `class`
--

DROP TABLE IF EXISTS `class`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `class` (
  `class_name` varchar(255) DEFAULT NULL,
  `class_id` bigint NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`class_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `class`
--

LOCK TABLES `class` WRITE;
/*!40000 ALTER TABLE `class` DISABLE KEYS */;
INSERT INTO `class` VALUES ('test',1);
/*!40000 ALTER TABLE `class` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `exam`
--

DROP TABLE IF EXISTS `exam`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `exam` (
  `exam_id` bigint NOT NULL AUTO_INCREMENT,
  `exam_name` varchar(255) DEFAULT NULL,
  `exam_question_count` varchar(10) DEFAULT '10',
  `exam_question_single_count` varchar(10) DEFAULT '3',
  `exam_question_multiple_count` varchar(10) DEFAULT '3',
  `exam_question_tf_count` varchar(10) DEFAULT '4',
  `exam_start_time_stamp` timestamp NULL DEFAULT NULL,
  `exam_end_time_stamp` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`exam_id`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exam`
--

LOCK TABLES `exam` WRITE;
/*!40000 ALTER TABLE `exam` DISABLE KEYS */;
INSERT INTO `exam` VALUES (1,'Sample Exam','10','2','3',NULL,'2023-12-05 18:01:40',NULL),(2,'Sample Exam','10','4','3',NULL,'2023-12-05 18:01:49',NULL),(3,'Exam 1','10','3','3','4','2023-12-11 08:00:00','2023-12-11 10:00:00'),(4,'Exam 2','10','3','3','4','2023-12-12 09:00:00','2023-12-12 11:00:00'),(5,'Exam 3','10','3','3','4','2023-12-13 10:00:00','2023-12-13 12:00:00'),(6,'Exam 4','10','3','3','4','2023-12-14 11:00:00','2023-12-14 13:00:00'),(7,'Exam 5','10','3','3','4','2023-12-15 12:00:00','2023-12-15 14:00:00'),(8,'Exam 6','10','3','3','4','2023-12-16 13:00:00','2023-12-16 15:00:00'),(9,'Exam 7','10','3','3','4','2023-12-17 14:00:00','2023-12-17 16:00:00'),(10,'Exam 8','10','3','3','4','2023-12-18 15:00:00','2023-12-18 17:00:00'),(11,'Exam 9','10','3','3','4','2023-12-19 16:00:00','2023-12-19 18:00:00'),(12,'Exam 10','10','3','3','4','2023-12-20 17:00:00','2023-12-20 19:00:00'),(13,NULL,'10','3','3','4',NULL,NULL),(14,NULL,'10','3','3','4',NULL,NULL),(15,NULL,'10','3','3','4',NULL,NULL),(16,NULL,'10','3','3','4',NULL,NULL),(17,NULL,'10','3','3','4',NULL,NULL),(18,NULL,'10','3','3','4',NULL,NULL),(19,'test','10','3','3','4',NULL,NULL),(20,'test','10','3','3','4',NULL,NULL),(21,'test','20','3','3','4',NULL,NULL),(22,'test','20','3','3','4',NULL,NULL),(23,'test','20','3','3','4',NULL,NULL),(24,'test','20','3','3','4',NULL,NULL),(25,'test','12','3','3','4','2023-12-21 20:16:00','2023-12-21 20:18:00'),(26,'test2','20','3','3','4','2023-12-21 20:29:00','2023-12-21 20:32:00'),(27,'test2','20','3','3','4','2023-12-21 20:29:00','2023-12-21 20:32:00'),(28,'test2','20','3','3','4','2023-12-21 20:29:00','2023-12-21 20:32:00'),(29,'tutorial','12','3','3','4','2023-12-21 20:35:00','2023-12-21 20:37:00'),(30,'123','12','3','3','4','2023-12-21 20:37:00','2023-12-21 21:36:00'),(31,'tutorial','12','3','3','4','2023-12-21 20:40:00','2023-12-21 21:41:00'),(32,'test','12','3','3','4','2023-12-21 20:41:00','2023-12-21 21:41:00'),(33,'test2','20','3','3','4','2023-12-21 20:42:00','2023-12-21 21:43:00'),(34,'test2','20','3','3','4','2023-12-21 20:42:00','2023-12-21 21:43:00'),(35,'test2','20','3','3','4','2023-12-21 20:42:00','2023-12-21 21:43:00'),(36,'test2','20','3','3','4','2023-12-21 20:42:00','2023-12-21 21:43:00'),(37,'test2','20','3','3','4','2023-12-21 20:42:00','2023-12-21 21:43:00'),(38,'test2','20','3','3','4','2023-12-21 20:42:00','2023-12-21 21:43:00'),(39,'test','10','3','3','4','2023-12-21 20:42:00','2023-12-21 21:43:00'),(40,'push test','3','3','3','4','2023-12-21 20:54:00','2023-12-21 20:55:00'),(41,'hello world','5','3','3','4','2023-12-21 21:54:00','2023-12-21 22:55:00'),(42,'2023exam','15','3','3','4','2023-12-22 13:56:00','2023-12-22 13:58:00');
/*!40000 ALTER TABLE `exam` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `exam_record`
--

DROP TABLE IF EXISTS `exam_record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `exam_record` (
  `exam_record_id` int NOT NULL AUTO_INCREMENT,
  `exam_id` bigint DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  `exam_status` bigint DEFAULT NULL,
  `class_id` bigint DEFAULT NULL,
  PRIMARY KEY (`exam_record_id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exam_record`
--

LOCK TABLES `exam_record` WRITE;
/*!40000 ALTER TABLE `exam_record` DISABLE KEYS */;
INSERT INTO `exam_record` VALUES (1,37,7,0,NULL),(2,37,8,0,NULL),(3,37,9,0,NULL),(4,37,10,0,NULL),(5,37,11,0,NULL),(6,37,12,0,NULL),(7,37,13,0,NULL),(8,38,1,0,NULL),(9,38,3,0,NULL),(10,38,4,0,NULL),(11,38,5,0,NULL),(12,38,6,0,NULL),(13,39,1,0,NULL),(14,39,3,0,NULL),(15,39,4,0,NULL),(16,39,5,0,NULL),(17,39,6,0,NULL),(18,40,1,0,NULL),(19,40,3,0,NULL),(20,40,4,0,NULL),(21,40,5,0,NULL),(22,40,6,0,NULL),(23,41,7,0,NULL),(24,41,8,0,NULL),(25,41,9,0,NULL),(26,41,10,0,NULL),(27,41,11,0,NULL),(28,41,12,0,NULL),(29,41,13,0,NULL),(30,42,1,0,NULL),(31,42,3,0,NULL),(32,42,4,0,NULL),(33,42,5,0,NULL),(34,42,6,0,NULL);
/*!40000 ALTER TABLE `exam_record` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `question`
--

DROP TABLE IF EXISTS `question`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `question` (
  `question_id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `question_type` varchar(255) DEFAULT NULL,
  `question_name` varchar(255) DEFAULT NULL,
  `question_answer` varchar(255) DEFAULT NULL,
  `question_choices` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`question_id`),
  UNIQUE KEY `question_id` (`question_id`)
) ENGINE=InnoDB AUTO_INCREMENT=166 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `question`
--

LOCK TABLES `question` WRITE;
/*!40000 ALTER TABLE `question` DISABLE KEYS */;
INSERT INTO `question` VALUES (139,'single','What is the capital of France?','Paris','Paris$London$Berlin$Madrid'),(140,'multiple','Select the prime numbers','2,3,5','2$3$4$5'),(141,'truefalse','The earth is flat','False','True$False'),(142,'single','Which city is known as the \'City of Love\'?','Paris','Paris$Rome$New York$London'),(143,'single','What is the capital of Japan?','Tokyo','Kyoto$Tokyo$Osaka$Hiroshima'),(144,'multiple','Which elements are noble gases?','Helium, Neon, Argon','Oxygen$Helium$Neon$Argon'),(145,'multiple','What is the powerhouse of the cell?','Mitochondria','Nucleus$Mitochondria$Ribosome$Endoplasmic Reticulum'),(146,'single','Which country is famous for its tulips and windmills?','Netherlands','Netherlands$Belgium$Germany$France'),(147,'single','What is the largest desert in the world?','Sahara','Gobi$Sahara$Kalahari$Arabian'),(148,'single','In which city can you find the Colosseum?','Rome','Rome$Athens$Paris$London'),(149,'single','Which is the longest river in the world?','Nile','Amazon$Nile$Yangtze$Mississippi'),(150,'single','What is the smallest country in the world?','Vatican City','Vatican City$Monaco$Nauru$Liechtenstein'),(151,'multiple','What are the primary colors of light?','Red, Green, Blue','Red$Green$Blue$Yellow'),(152,'multiple','What gas do plants absorb during photosynthesis?','Carbon Dioxide','Oxygen$Carbon Dioxide$Nitrogen$Hydrogen'),(153,'multiple','Which planet is known as the Red Planet?','Mars','Jupiter$Mars$Saturn$Venus '),(154,'multiple','What is the chemical symbol for gold?','Au','Au$Ag$Fe$Cu'),(155,'multiple','Which animal is known for having the longest lifespan?','Greenland Shark','Elephant$Tortoise$Greenland Shark$Whale'),(156,'single','What city is famous for its Carnival celebration?','Rio de Janeiro','Rio de Janeiro$Venice$New Orleans$Munich'),(157,'single','Which country is home to the Great Barrier Reef?','Australia','Australia$Belize$Indonesia$Mexico'),(158,'single','Which Asian country is known as the Land of the Morning Calm?','South Korea','Japan$China$South Korea$Thailand'),(159,'single','What is the capital of Canada?','Ottawa','Toronto$Vancouver$Ottawa$Montreal'),(160,'single','In which country can you visit Machu Picchu?','Peru','Peru$Bolivia$Chile$Ecuador'),(161,'multiple','What is the main gas in Earth\'s atmosphere?','Nitrogen','Oxygen$Carbon Dioxide$Nitrogen$Argon'),(162,'multiple','Which vitamin is produced by the human body when exposed to sunlight?','Vitamin D','Vitamin A$Vitamin B$Vitamin C$Vitamin D'),(163,'multiple','Who developed the theory of relativity?','Albert Einstein','Isaac Newton$Albert Einstein$Nikola Tesla$Marie Curie'),(164,'multiple','What is the hardest natural substance on Earth?','Diamond','Diamond$Gold$Iron$Quartz'),(165,'multiple','Which planet in our solar system is known for its rings?','Saturn','Jupiter$Mars$Saturn$Uranus');
/*!40000 ALTER TABLE `question` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `user_id` bigint NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) DEFAULT NULL,
  `user_real_name` varchar(255) DEFAULT NULL,
  `user_password` varchar(255) DEFAULT NULL,
  `user_role_level` int DEFAULT '2',
  `user_email` varchar(255) DEFAULT NULL,
  `user_class_id` int DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'john_doe','John Doe','password123',2,'john.doe@example.com',1),(3,'test','test','test',2,'test@example.com',1),(4,'user1','User One','password1',2,'user1@example.com',1),(5,'user2','User Two','password2',2,'user2@example.com',1),(6,'user3','User Three','password3',2,'user3@example.com',1),(7,'user4','User Four','password4',2,'user4@example.com',2),(8,'user5','User Five','password5',2,'user5@example.com',2),(9,'user6','User Six','password6',2,'user6@example.com',2),(10,'user7','User Seven','password7',2,'user7@example.com',2),(11,'user8','User Eight','password8',2,'user8@example.com',2),(12,'user9','User Nine','password9',2,'user9@example.com',2),(13,'user10','User Ten','password10',2,'user10@example.com',2),(14,'admin','admin','admin',0,'admin@admin.com',1),(15,'teacher','teacher','teacher',1,'teacher@exam.com',1);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-12-22  6:28:46

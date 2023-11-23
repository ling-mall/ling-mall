-- MySQL dump 10.13  Distrib 8.1.0, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: ling-cloud
-- ------------------------------------------------------
-- Server version	8.1.0

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
-- Table structure for table `account_platform`
--

DROP TABLE IF EXISTS `account_platform`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account_platform` (
  `id` int unsigned NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `user_id` int unsigned NOT NULL DEFAULT '0' COMMENT '账号id',
  `platform_id` varchar(60) NOT NULL DEFAULT '' COMMENT '平台id',
  `platform_token` varchar(60) NOT NULL DEFAULT '' COMMENT '平台access_token',
  `type` tinyint(1) NOT NULL DEFAULT '0' COMMENT '平台类型 0:未知,1:facebook,2:google,3:wechat,4:qq,5:weibo,6:twitter',
  `nickname` varchar(60) NOT NULL DEFAULT '' COMMENT '昵称',
  `avatar` varchar(255) NOT NULL DEFAULT '' COMMENT '头像',
  `remark` varchar(500) NOT NULL DEFAULT '' COMMENT '备注',
  `create_by` bigint unsigned NOT NULL DEFAULT '0' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_by` bigint unsigned NOT NULL DEFAULT '0' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_deleted` tinyint unsigned NOT NULL DEFAULT '0' COMMENT '删除标志（0代表存在 1代表删除）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='第三方用户信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account_platform`
--

LOCK TABLES `account_platform` WRITE;
/*!40000 ALTER TABLE `account_platform` DISABLE KEYS */;
/*!40000 ALTER TABLE `account_platform` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `account_user`
--

DROP TABLE IF EXISTS `account_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account_user` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `username` varchar(30) NOT NULL COMMENT '用户账号',
  `email` varchar(50) NOT NULL DEFAULT '' COMMENT '用户邮箱',
  `tel` varchar(15) NOT NULL DEFAULT '' COMMENT '手机号码',
  `password` varchar(100) NOT NULL DEFAULT '' COMMENT '密码',
  `status` tinyint unsigned NOT NULL DEFAULT '1' COMMENT '帐号状态（1正常 0停用）',
  `create_ip_at` varchar(12) NOT NULL DEFAULT '' COMMENT '创建ip',
  `last_login_at` int NOT NULL DEFAULT '0' COMMENT '最后一次登录时间',
  `last_login_ip_at` varchar(12) NOT NULL DEFAULT '' COMMENT '最后一次登录ip',
  `login_count` int NOT NULL DEFAULT '0' COMMENT '登录次数',
  `remark` varchar(500) NOT NULL DEFAULT '' COMMENT '备注',
  `create_by` bigint unsigned NOT NULL DEFAULT '0' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_by` bigint unsigned NOT NULL DEFAULT '0' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_deleted` tinyint unsigned NOT NULL DEFAULT '0' COMMENT '删除标志（0代表存在 1代表删除）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='账户表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account_user`
--

LOCK TABLES `account_user` WRITE;
/*!40000 ALTER TABLE `account_user` DISABLE KEYS */;
INSERT INTO `account_user` VALUES (1,'admin','admin@qq.com','17607952136','$2a$10$KMjutg4g1Rx2CW1WNC0W/.zdGkXDhSGy939Ne3gzO4mToziqxDVA6',1,'',0,'',0,'',0,'2023-08-19 18:51:18',0,'2023-08-19 18:55:44',0);
/*!40000 ALTER TABLE `account_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `admin_user`
--

DROP TABLE IF EXISTS `admin_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admin_user` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '员工id',
  `user_id` bigint unsigned NOT NULL COMMENT '账户id',
  `real_name` varchar(100) NOT NULL DEFAULT '' COMMENT '真名',
  `gender` tinyint(1) NOT NULL DEFAULT '0' COMMENT '性别 0：男，1：女',
  `avatar` varchar(500) NOT NULL DEFAULT '' COMMENT '头像',
  `status` tinyint unsigned NOT NULL DEFAULT '1' COMMENT '帐号状态（1停用 0正常）',
  `remark` varchar(500) NOT NULL DEFAULT '' COMMENT '备注',
  `create_by` bigint unsigned NOT NULL DEFAULT '0' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_by` bigint unsigned NOT NULL DEFAULT '0' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_deleted` tinyint unsigned NOT NULL DEFAULT '0' COMMENT '删除标志（0代表存在 1代表删除）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='管理员表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin_user`
--

LOCK TABLES `admin_user` WRITE;
/*!40000 ALTER TABLE `admin_user` DISABLE KEYS */;
/*!40000 ALTER TABLE `admin_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gateway_route`
--

DROP TABLE IF EXISTS `gateway_route`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `gateway_route` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `router_id` varchar(50) NOT NULL COMMENT '路由ID',
  `sort` tinyint unsigned NOT NULL COMMENT '路由顺序',
  `name` varchar(32) NOT NULL COMMENT '服务名',
  `uri` varchar(32) NOT NULL COMMENT '服务地址',
  `strip_prefix` tinyint unsigned NOT NULL COMMENT '是否忽略前缀0-否 1-是',
  `show_api` tinyint unsigned NOT NULL COMMENT '是否在接口文档中展示:0-否 1-是',
  `status` tinyint unsigned NOT NULL DEFAULT '1' COMMENT '状态:0-禁用 1-启用',
  `remark` varchar(500) NOT NULL DEFAULT '' COMMENT '备注',
  `create_by` bigint unsigned NOT NULL DEFAULT '0' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_by` bigint unsigned NOT NULL DEFAULT '0' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_deleted` tinyint unsigned NOT NULL DEFAULT '0' COMMENT '删除标志（0代表存在 1代表删除）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='网关路由';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gateway_route`
--

LOCK TABLES `gateway_route` WRITE;
/*!40000 ALTER TABLE `gateway_route` DISABLE KEYS */;
INSERT INTO `gateway_route` VALUES (1,'domo',1,'示例','lb://lingcloud-demo',1,1,1,'',0,'2023-10-16 15:19:51',0,'2023-10-16 15:19:51',0);
/*!40000 ALTER TABLE `gateway_route` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gateway_route_item`
--

DROP TABLE IF EXISTS `gateway_route_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `gateway_route_item` (
  `id` int unsigned NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `route_id` bigint unsigned NOT NULL COMMENT '路由表id',
  `param_key` varchar(200) NOT NULL COMMENT '参数key',
  `param_value` varchar(50) NOT NULL COMMENT '参数value',
  `type` tinyint unsigned NOT NULL DEFAULT '1' COMMENT '参数类型，0为 predicate，1为过 filter',
  `status` tinyint unsigned NOT NULL DEFAULT '1' COMMENT '启用状态：0禁用，1启用(默认)',
  `remark` varchar(500) NOT NULL DEFAULT '' COMMENT '备注',
  `create_by` bigint unsigned NOT NULL DEFAULT '0' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_by` bigint unsigned NOT NULL DEFAULT '0' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_deleted` tinyint unsigned NOT NULL DEFAULT '0' COMMENT '删除标志（0代表存在 1代表删除）',
  PRIMARY KEY (`id`),
  KEY `route_id` (`route_id`),
  CONSTRAINT `gateway_route_item_ibfk_1` FOREIGN KEY (`route_id`) REFERENCES `gateway_route` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='网关路由子项';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gateway_route_item`
--

LOCK TABLES `gateway_route_item` WRITE;
/*!40000 ALTER TABLE `gateway_route_item` DISABLE KEYS */;
INSERT INTO `gateway_route_item` VALUES (1,1,'Path','/demo/**',0,1,'',0,'2023-10-16 15:26:36',0,'2023-10-19 10:39:38',0),(2,1,'StripPrefix','1',1,1,'',0,'2023-10-16 15:28:00',0,'2023-10-19 10:39:38',0);
/*!40000 ALTER TABLE `gateway_route_item` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-11-23  9:46:23

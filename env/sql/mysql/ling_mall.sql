-- MySQL dump 10.13  Distrib 8.1.0, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: ling_mall
-- ------------------------------------------------------
-- Server version	8.1.0

/*!40101 SET @OLD_CHARACTER_SET_CLIENT = @@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS = @@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION = @@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE = @@TIME_ZONE */;
/*!40103 SET TIME_ZONE = '+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS = @@UNIQUE_CHECKS, UNIQUE_CHECKS = 0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS = @@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS = 0 */;
/*!40101 SET @OLD_SQL_MODE = @@SQL_MODE, SQL_MODE = 'NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES = @@SQL_NOTES, SQL_NOTES = 0 */;

--
-- Table structure for table `account_authority`
--

DROP TABLE IF EXISTS `account_authority`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account_authority`
(
    `id`             bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '权限 id',
    `authority_type` int unsigned    NOT NULL COMMENT '权限类型',
    `authority_key`  varchar(100) DEFAULT '' COMMENT '权限唯一标识',
    `order_no`       int          DEFAULT '0' COMMENT '显示顺序',
    `create_by`      varchar(64)  DEFAULT '' COMMENT '创建者',
    `create_time`    datetime     DEFAULT NULL COMMENT '创建时间',
    `update_by`      varchar(64)  DEFAULT '' COMMENT '更新者',
    `update_time`    datetime     DEFAULT NULL COMMENT '更新时间',
    `remark`         varchar(200) DEFAULT NULL,
    `is_deleted`     tinyint(1)   DEFAULT '0' COMMENT '逻辑删除标识',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='权限';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account_authority`
--

LOCK TABLES `account_authority` WRITE;
/*!40000 ALTER TABLE `account_authority`
    DISABLE KEYS */;
/*!40000 ALTER TABLE `account_authority`
    ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `account_authority_type`
--

DROP TABLE IF EXISTS `account_authority_type`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account_authority_type`
(
    `id`             bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '权限类型 id',
    `authority_type` int             NOT NULL COMMENT '权限类型',
    `order_no`       int          DEFAULT '0' COMMENT '显示顺序',
    `create_by`      varchar(64)  DEFAULT '' COMMENT '创建者',
    `create_time`    datetime     DEFAULT NULL COMMENT '创建时间',
    `update_by`      varchar(64)  DEFAULT '' COMMENT '更新者',
    `update_time`    datetime     DEFAULT NULL COMMENT '更新时间',
    `remark`         varchar(200) DEFAULT NULL,
    `is_deleted`     tinyint(1)   DEFAULT '0' COMMENT '逻辑删除标识',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='权限类型';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account_authority_type`
--

LOCK TABLES `account_authority_type` WRITE;
/*!40000 ALTER TABLE `account_authority_type`
    DISABLE KEYS */;
/*!40000 ALTER TABLE `account_authority_type`
    ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `account_dept`
--

DROP TABLE IF EXISTS `account_dept`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account_dept`
(
    `id`          bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '部门 id',
    `parent_id`   bigint unsigned DEFAULT '0' COMMENT '父 id',
    `dept_name`   varchar(30)     DEFAULT '' COMMENT '部门名称',
    `order_no`    int             DEFAULT '0' COMMENT '显示顺序',
    `leader`      varchar(20)     DEFAULT NULL COMMENT '负责人',
    `phone`       varchar(11)     DEFAULT NULL COMMENT '联系电话',
    `parent_list` varchar(60)     DEFAULT '' COMMENT '祖级列表',
    `email`       varchar(50)     DEFAULT NULL COMMENT '邮箱',
    `create_by`   varchar(64)     DEFAULT '' COMMENT '创建者',
    `create_time` datetime        DEFAULT NULL COMMENT '创建时间',
    `update_by`   varchar(64)     DEFAULT '' COMMENT '更新者',
    `update_time` datetime        DEFAULT NULL COMMENT '更新时间',
    `remark`      varchar(200)    DEFAULT NULL,
    `is_deleted`  tinyint(1)      DEFAULT '0' COMMENT '逻辑删除标识',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='部门表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account_dept`
--

LOCK TABLES `account_dept` WRITE;
/*!40000 ALTER TABLE `account_dept`
    DISABLE KEYS */;
/*!40000 ALTER TABLE `account_dept`
    ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `account_dept_user`
--

DROP TABLE IF EXISTS `account_dept_user`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account_dept_user`
(
    `id`          bigint unsigned NOT NULL AUTO_INCREMENT,
    `dept_id`     bigint unsigned NOT NULL COMMENT '部门ID',
    `user_id`     bigint unsigned NOT NULL COMMENT '用户ID',
    `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    PRIMARY KEY (`id`),
    KEY `idx_dept_id` (`dept_id`),
    KEY `idx_user_id` (`user_id`),
    CONSTRAINT `fk_account_dept_user_dept` FOREIGN KEY (`dept_id`) REFERENCES `account_dept` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT `fk_account_dept_user_user` FOREIGN KEY (`user_id`) REFERENCES `account_user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='部门用户关联表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account_dept_user`
--

LOCK TABLES `account_dept_user` WRITE;
/*!40000 ALTER TABLE `account_dept_user`
    DISABLE KEYS */;
/*!40000 ALTER TABLE `account_dept_user`
    ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `account_group`
--

DROP TABLE IF EXISTS `account_group`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account_group`
(
    `id`          bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '用户组 id',
    `parent_id`   bigint unsigned DEFAULT '0' COMMENT '父 id',
    `parent_list` varchar(60)     DEFAULT '祖级列表',
    `group_name`  varchar(30)     DEFAULT '' COMMENT '用户组名称',
    `order_no`    int             DEFAULT '0' COMMENT '显示顺序',
    `create_by`   varchar(64)     DEFAULT '' COMMENT '创建者',
    `create_time` datetime        DEFAULT NULL COMMENT '创建时间',
    `update_by`   varchar(64)     DEFAULT '' COMMENT '更新者',
    `update_time` datetime        DEFAULT NULL COMMENT '更新时间',
    `remark`      varchar(200)    DEFAULT NULL,
    `is_deleted`  tinyint(1)      DEFAULT '0' COMMENT '逻辑删除标识',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='用户组';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account_group`
--

LOCK TABLES `account_group` WRITE;
/*!40000 ALTER TABLE `account_group`
    DISABLE KEYS */;
/*!40000 ALTER TABLE `account_group`
    ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `account_group_role`
--

DROP TABLE IF EXISTS `account_group_role`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account_group_role`
(
    `id`          bigint unsigned NOT NULL AUTO_INCREMENT,
    `group_id`    bigint unsigned NOT NULL COMMENT '用户组ID',
    `role_id`     bigint unsigned NOT NULL COMMENT '角色ID',
    `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    PRIMARY KEY (`id`),
    KEY `idx_group_id` (`group_id`),
    KEY `idx_role_id` (`role_id`),
    CONSTRAINT `account_group_role_ibfk_1` FOREIGN KEY (`group_id`) REFERENCES `account_group` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT `account_group_role_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `account_role` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='用户组角色关联表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account_group_role`
--

LOCK TABLES `account_group_role` WRITE;
/*!40000 ALTER TABLE `account_group_role`
    DISABLE KEYS */;
/*!40000 ALTER TABLE `account_group_role`
    ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `account_group_user`
--

DROP TABLE IF EXISTS `account_group_user`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account_group_user`
(
    `id`          bigint unsigned NOT NULL AUTO_INCREMENT,
    `group_id`    bigint unsigned NOT NULL COMMENT '用户组ID',
    `user_id`     bigint unsigned NOT NULL COMMENT '用户ID',
    `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    PRIMARY KEY (`id`),
    KEY `idx_group_id` (`group_id`),
    KEY `idx_user_id` (`user_id`),
    CONSTRAINT `fk_account_group_user_group` FOREIGN KEY (`group_id`) REFERENCES `account_group` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT `fk_account_group_user_user` FOREIGN KEY (`user_id`) REFERENCES `account_user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='用户组用户关联表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account_group_user`
--

LOCK TABLES `account_group_user` WRITE;
/*!40000 ALTER TABLE `account_group_user`
    DISABLE KEYS */;
/*!40000 ALTER TABLE `account_group_user`
    ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `account_platform`
--

DROP TABLE IF EXISTS `account_platform`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account_platform`
(
    `id`             int unsigned     NOT NULL AUTO_INCREMENT COMMENT '自增id',
    `user_id`        int unsigned     NOT NULL DEFAULT '0' COMMENT '账号id',
    `platform_id`    varchar(60)      NOT NULL DEFAULT '' COMMENT '平台id',
    `platform_token` varchar(60)      NOT NULL DEFAULT '' COMMENT '平台access_token',
    `type`           tinyint(1)       NOT NULL DEFAULT '0' COMMENT '平台类型 0:未知,1:facebook,2:google,3:wechat,4:qq,5:weibo,6:twitter',
    `nickname`       varchar(60)      NOT NULL DEFAULT '' COMMENT '昵称',
    `avatar`         varchar(255)     NOT NULL DEFAULT '' COMMENT '头像',
    `remark`         varchar(500)     NOT NULL DEFAULT '' COMMENT '备注',
    `create_by`      bigint unsigned  NOT NULL DEFAULT '0' COMMENT '创建者',
    `create_time`    datetime         NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_by`      bigint unsigned  NOT NULL DEFAULT '0' COMMENT '更新者',
    `update_time`    datetime         NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `is_deleted`     tinyint unsigned NOT NULL DEFAULT '0' COMMENT '删除标志（0代表存在 1代表删除）',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='第三方用户信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account_platform`
--

LOCK TABLES `account_platform` WRITE;
/*!40000 ALTER TABLE `account_platform`
    DISABLE KEYS */;
/*!40000 ALTER TABLE `account_platform`
    ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `account_role`
--

DROP TABLE IF EXISTS `account_role`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account_role`
(
    `id`          bigint unsigned  NOT NULL AUTO_INCREMENT COMMENT '角色 id',
    `role_name`   varchar(30)      NOT NULL COMMENT '角色名称',
    `role_key`    varchar(100)     NOT NULL COMMENT '角色权限字符串',
    `order_no`    int              NOT NULL COMMENT '显示顺序',
    `data_scope`  tinyint unsigned          DEFAULT '1' COMMENT '数据范围（1：全部数据权限 2：自定数据权限 3：本部门数据权限 4：本部门及以下数据权限 5:仅本人权限）',
    `status`      tinyint unsigned NOT NULL DEFAULT '1' COMMENT '角色状态（1 启用 0 禁用）',
    `create_by`   varchar(64)               DEFAULT '' COMMENT '创建者',
    `create_time` datetime                  DEFAULT NULL COMMENT '创建时间',
    `update_by`   varchar(64)               DEFAULT '' COMMENT '更新者',
    `update_time` datetime                  DEFAULT NULL COMMENT '更新时间',
    `remark`      varchar(500)              DEFAULT NULL COMMENT '备注',
    `is_deleted`  tinyint(1)                DEFAULT '0' COMMENT '逻辑删除标识',
    `parent_id`   bigint unsigned           DEFAULT '0' COMMENT '父id',
    `parent_list` varchar(60)               DEFAULT '' COMMENT '父级id列表',
    PRIMARY KEY (`id`),
    KEY `ums_role_status_index` (`status`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='角色表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account_role`
--

LOCK TABLES `account_role` WRITE;
/*!40000 ALTER TABLE `account_role`
    DISABLE KEYS */;
/*!40000 ALTER TABLE `account_role`
    ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `account_role_authority`
--

DROP TABLE IF EXISTS `account_role_authority`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account_role_authority`
(
    `id`           bigint unsigned NOT NULL AUTO_INCREMENT,
    `role_id`      bigint unsigned NOT NULL COMMENT '角色ID',
    `authority_id` bigint unsigned NOT NULL COMMENT '权限ID',
    `create_time`  datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    PRIMARY KEY (`id`),
    KEY `idx_role_id` (`role_id`),
    KEY `idx_authority_id` (`authority_id`),
    CONSTRAINT `fk_account_role_authority_authority` FOREIGN KEY (`authority_id`) REFERENCES `account_authority` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT `fk_account_role_authority_role` FOREIGN KEY (`role_id`) REFERENCES `account_role` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='角色权限关联表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account_role_authority`
--

LOCK TABLES `account_role_authority` WRITE;
/*!40000 ALTER TABLE `account_role_authority`
    DISABLE KEYS */;
/*!40000 ALTER TABLE `account_role_authority`
    ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `account_role_constraint`
--

DROP TABLE IF EXISTS `account_role_constraint`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account_role_constraint`
(
    `id`                bigint unsigned  NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    `constraint_type`   tinyint unsigned NOT NULL COMMENT '约束类型 0: 角色数量约束 1: 角色互斥约束 2: 先决条件约束',
    `business_type`     tinyint unsigned NOT NULL COMMENT '业务类型 0: 用户角色 1: 用户组角色',
    `business_id`       bigint unsigned  NOT NULL COMMENT '业务ID',
    `role_id`           bigint unsigned  NOT NULL COMMENT '角色ID',
    `target_role_id`    bigint unsigned  NOT NULL COMMENT '目标角色ID',
    `cardinality_count` int unsigned              DEFAULT '0' COMMENT '角色数量(基数约束数量)',
    `create_time`       datetime         NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='角色约束表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account_role_constraint`
--

LOCK TABLES `account_role_constraint` WRITE;
/*!40000 ALTER TABLE `account_role_constraint`
    DISABLE KEYS */;
/*!40000 ALTER TABLE `account_role_constraint`
    ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `account_user`
--

DROP TABLE IF EXISTS `account_user`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account_user`
(
    `id`               bigint unsigned  NOT NULL AUTO_INCREMENT COMMENT '用户id',
    `username`         varchar(30)      NOT NULL COMMENT '用户账号',
    `email`            varchar(50)      NOT NULL DEFAULT '' COMMENT '用户邮箱',
    `tel`              varchar(15)      NOT NULL DEFAULT '' COMMENT '手机号码',
    `password`         varchar(100)     NOT NULL DEFAULT '' COMMENT '密码',
    `status`           tinyint unsigned NOT NULL DEFAULT '1' COMMENT '帐号状态（1正常 0停用）',
    `create_ip_at`     varchar(12)      NOT NULL DEFAULT '' COMMENT '创建ip',
    `last_login_at`    int              NOT NULL DEFAULT '0' COMMENT '最后一次登录时间',
    `last_login_ip_at` varchar(12)      NOT NULL DEFAULT '' COMMENT '最后一次登录ip',
    `login_count`      int              NOT NULL DEFAULT '0' COMMENT '登录次数',
    `remark`           varchar(500)     NOT NULL DEFAULT '' COMMENT '备注',
    `create_by`        bigint unsigned  NOT NULL DEFAULT '0' COMMENT '创建者',
    `create_time`      datetime         NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_by`        bigint unsigned  NOT NULL DEFAULT '0' COMMENT '更新者',
    `update_time`      datetime         NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `is_deleted`       tinyint unsigned NOT NULL DEFAULT '0' COMMENT '删除标志（0代表存在 1代表删除）',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 2
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='账户表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account_user`
--

LOCK TABLES `account_user` WRITE;
/*!40000 ALTER TABLE `account_user`
    DISABLE KEYS */;
INSERT INTO `account_user`
VALUES (1, 'admin', 'admin@qq.com', '17607952136', '$2a$10$KMjutg4g1Rx2CW1WNC0W/.zdGkXDhSGy939Ne3gzO4mToziqxDVA6', 1,
        '', 0, '', 0, '', 0, '2023-08-19 18:51:18', 0, '2023-08-19 18:55:44', 0);
/*!40000 ALTER TABLE `account_user`
    ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `account_user_authority`
--

DROP TABLE IF EXISTS `account_user_authority`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account_user_authority`
(
    `id`           bigint unsigned NOT NULL AUTO_INCREMENT,
    `user_id`      bigint unsigned NOT NULL COMMENT '用户ID',
    `authority_id` bigint unsigned NOT NULL COMMENT '权限ID',
    `type`         tinyint(1)      NOT NULL COMMENT '类型 0授权 1禁用',
    `create_time`  datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    PRIMARY KEY (`id`),
    KEY `authority_id` (`authority_id`),
    KEY `user_id` (`user_id`),
    CONSTRAINT `account_user_authority_ibfk_1` FOREIGN KEY (`authority_id`) REFERENCES `account_authority` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT `account_user_authority_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `account_user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='用户权限关联表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account_user_authority`
--

LOCK TABLES `account_user_authority` WRITE;
/*!40000 ALTER TABLE `account_user_authority`
    DISABLE KEYS */;
/*!40000 ALTER TABLE `account_user_authority`
    ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `account_user_role`
--

DROP TABLE IF EXISTS `account_user_role`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account_user_role`
(
    `id`          bigint unsigned NOT NULL AUTO_INCREMENT,
    `user_id`     bigint unsigned NOT NULL COMMENT '用户ID',
    `role_id`     bigint unsigned NOT NULL COMMENT '角色ID',
    `create_time` datetime        NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    PRIMARY KEY (`id`),
    KEY `idx_user_id` (`user_id`),
    KEY `idx_role_id` (`role_id`),
    CONSTRAINT `fk_account_user_role_role` FOREIGN KEY (`role_id`) REFERENCES `account_role` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT `fk_account_user_role_user` FOREIGN KEY (`user_id`) REFERENCES `account_user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='用户角色关联表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account_user_role`
--

LOCK TABLES `account_user_role` WRITE;
/*!40000 ALTER TABLE `account_user_role`
    DISABLE KEYS */;
/*!40000 ALTER TABLE `account_user_role`
    ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `admin_user`
--

DROP TABLE IF EXISTS `admin_user`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admin_user`
(
    `id`          bigint unsigned  NOT NULL AUTO_INCREMENT COMMENT '员工id',
    `user_id`     bigint unsigned  NOT NULL COMMENT '账户id',
    `real_name`   varchar(100)     NOT NULL DEFAULT '' COMMENT '真名',
    `gender`      tinyint(1)       NOT NULL DEFAULT '0' COMMENT '性别 0：男，1：女',
    `avatar`      varchar(500)     NOT NULL DEFAULT '' COMMENT '头像',
    `status`      tinyint unsigned NOT NULL DEFAULT '1' COMMENT '帐号状态（1停用 0正常）',
    `remark`      varchar(500)     NOT NULL DEFAULT '' COMMENT '备注',
    `create_by`   bigint unsigned  NOT NULL DEFAULT '0' COMMENT '创建者',
    `create_time` datetime         NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_by`   bigint unsigned  NOT NULL DEFAULT '0' COMMENT '更新者',
    `update_time` datetime         NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `is_deleted`  tinyint unsigned NOT NULL DEFAULT '0' COMMENT '删除标志（0代表存在 1代表删除）',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='管理员表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin_user`
--

LOCK TABLES `admin_user` WRITE;
/*!40000 ALTER TABLE `admin_user`
    DISABLE KEYS */;
/*!40000 ALTER TABLE `admin_user`
    ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gateway_route`
--

DROP TABLE IF EXISTS `gateway_route`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `gateway_route`
(
    `id`           bigint unsigned  NOT NULL AUTO_INCREMENT COMMENT '自增id',
    `router_id`    varchar(50)      NOT NULL COMMENT '路由ID',
    `sort`         tinyint unsigned NOT NULL COMMENT '路由顺序',
    `name`         varchar(32)      NOT NULL COMMENT '服务名',
    `uri`          varchar(32)      NOT NULL COMMENT '服务地址',
    `strip_prefix` tinyint unsigned NOT NULL COMMENT '是否忽略前缀0-否 1-是',
    `show_api`     tinyint unsigned NOT NULL COMMENT '是否在接口文档中展示:0-否 1-是',
    `status`       tinyint unsigned NOT NULL DEFAULT '1' COMMENT '状态:0-禁用 1-启用',
    `remark`       varchar(500)     NOT NULL DEFAULT '' COMMENT '备注',
    `create_by`    bigint unsigned  NOT NULL DEFAULT '0' COMMENT '创建者',
    `create_time`  datetime         NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_by`    bigint unsigned  NOT NULL DEFAULT '0' COMMENT '更新者',
    `update_time`  datetime         NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `is_deleted`   tinyint unsigned NOT NULL DEFAULT '0' COMMENT '删除标志（0代表存在 1代表删除）',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 2
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='网关路由';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gateway_route`
--

LOCK TABLES `gateway_route` WRITE;
/*!40000 ALTER TABLE `gateway_route`
    DISABLE KEYS */;
INSERT INTO `gateway_route`
VALUES (1, 'domo', 1, '示例', 'lb://lingcloud-demo', 1, 1, 1, '', 0, '2023-10-16 15:19:51', 0, '2023-10-16 15:19:51',
        0);
/*!40000 ALTER TABLE `gateway_route`
    ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gateway_route_item`
--

DROP TABLE IF EXISTS `gateway_route_item`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `gateway_route_item`
(
    `id`          int unsigned     NOT NULL AUTO_INCREMENT COMMENT '自增id',
    `route_id`    bigint unsigned  NOT NULL COMMENT '路由表id',
    `param_key`   varchar(200)     NOT NULL COMMENT '参数key',
    `param_value` varchar(50)      NOT NULL COMMENT '参数value',
    `type`        tinyint unsigned NOT NULL DEFAULT '1' COMMENT '参数类型，0为 predicate，1为过 filter',
    `status`      tinyint unsigned NOT NULL DEFAULT '1' COMMENT '启用状态：0禁用，1启用(默认)',
    `remark`      varchar(500)     NOT NULL DEFAULT '' COMMENT '备注',
    `create_by`   bigint unsigned  NOT NULL DEFAULT '0' COMMENT '创建者',
    `create_time` datetime         NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_by`   bigint unsigned  NOT NULL DEFAULT '0' COMMENT '更新者',
    `update_time` datetime         NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `is_deleted`  tinyint unsigned NOT NULL DEFAULT '0' COMMENT '删除标志（0代表存在 1代表删除）',
    PRIMARY KEY (`id`),
    KEY `route_id` (`route_id`),
    CONSTRAINT `gateway_route_item_ibfk_1` FOREIGN KEY (`route_id`) REFERENCES `gateway_route` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB
  AUTO_INCREMENT = 13
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='网关路由子项';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gateway_route_item`
--

LOCK TABLES `gateway_route_item` WRITE;
/*!40000 ALTER TABLE `gateway_route_item`
    DISABLE KEYS */;
INSERT INTO `gateway_route_item`
VALUES (1, 1, 'Path', '/demo/**', 0, 1, '', 0, '2023-10-16 15:26:36', 0, '2023-10-19 10:39:38', 0),
       (2, 1, 'StripPrefix', '1', 1, 1, '', 0, '2023-10-16 15:28:00', 0, '2023-10-19 10:39:38', 0);
/*!40000 ALTER TABLE `gateway_route_item`
    ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE = @OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE = @OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS = @OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS = @OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT = @OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS = @OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION = @OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES = @OLD_SQL_NOTES */;

-- Dump completed on 2024-03-22 17:41:53

-- MySQL dump 10.13  Distrib 8.1.0, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: nacos_config
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
-- Table structure for table `config_info`
--

DROP TABLE IF EXISTS `config_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `config_info` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `data_id` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL COMMENT 'data_id',
  `group_id` varchar(128) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL COMMENT 'group_id',
  `content` longtext CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL COMMENT 'content',
  `md5` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL COMMENT 'md5',
  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  `src_user` text CHARACTER SET utf8mb3 COLLATE utf8mb3_bin COMMENT 'source user',
  `src_ip` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL COMMENT 'source ip',
  `app_name` varchar(128) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL COMMENT 'app_name',
  `tenant_id` varchar(128) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT '' COMMENT '租户字段',
  `c_desc` varchar(256) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL COMMENT 'configuration description',
  `c_use` varchar(64) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL COMMENT 'configuration usage',
  `effect` varchar(64) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL COMMENT '配置生效的描述',
  `type` varchar(64) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL COMMENT '配置的类型',
  `c_schema` text CHARACTER SET utf8mb3 COLLATE utf8mb3_bin COMMENT '配置的模式',
  `encrypted_data_key` text CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL COMMENT '密钥',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_configinfo_datagrouptenant` (`data_id`,`group_id`,`tenant_id`)
) ENGINE=InnoDB AUTO_INCREMENT=173 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin COMMENT='config_info';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `config_info`
--

LOCK TABLES `config_info` WRITE;
/*!40000 ALTER TABLE `config_info` DISABLE KEYS */;
INSERT INTO `config_info` VALUES (19,'com.ling.account.api.RemoteAccountService','mapping','ling-account,dubbo-ling-account','ebd09b57e11e9af4f57e18efba39d5b1','2023-08-19 22:48:01','2023-08-20 11:59:44',NULL,'192.168.1.2','','dev',NULL,NULL,NULL,'text',NULL,''),(20,'com.ling.account.api.RemoteAccountService:::provider:ling-account','DUBBO_GROUP','{\"annotations\":[],\"canonicalName\":\"com.ling.account.api.RemoteAccountService\",\"codeSource\":\"file:/D:/Course/main/ling-mall/ling-api/ling-api-account/target/classes/\",\"methods\":[{\"annotations\":[],\"name\":\"loginByUsername\",\"parameterTypes\":[\"java.lang.String\",\"java.lang.String\"],\"parameters\":[],\"returnType\":\"java.lang.String\"}],\"parameters\":{\"interface\":\"com.ling.account.api.RemoteAccountService\",\"metadata-type\":\"remote\",\"side\":\"provider\",\"application\":\"ling-account\",\"pid\":\"22228\",\"dubbo\":\"2.0.2\",\"anyhost\":\"true\",\"release\":\"3.2.5\",\"executor-management-mode\":\"isolation\",\"file-cache\":\"true\",\"methods\":\"loginByUsername\",\"logger\":\"slf4j\",\"deprecated\":\"false\",\"service-name-mapping\":\"true\",\"register-mode\":\"instance\",\"qos.enable\":\"false\",\"generic\":\"false\",\"bind.port\":\"20880\",\"bind.ip\":\"192.168.1.2\",\"prefer.serialization\":\"fastjson2,hessian2\",\"background\":\"false\",\"ipv6\":\"240e:3b2:32dc:9a40:cdbe:5f49:5dd9:33fe\",\"dynamic\":\"true\",\"timestamp\":\"1692501619461\"},\"types\":[{\"enums\":[],\"items\":[],\"properties\":{},\"type\":\"java.lang.String\"}],\"uniqueId\":\"com.ling.account.api.RemoteAccountService@file:/D:/Course/main/ling-mall/ling-api/ling-api-account/target/classes/\"}','3b1f979fd3f0b85b0dce2e699caa305a','2023-08-19 22:48:01','2023-08-20 11:20:21',NULL,'192.168.1.2','','dev',NULL,NULL,NULL,'text',NULL,''),(21,'ling-account','e5e344b184fe5d5891e32a67bd9bc91e','{\"app\":\"ling-account\",\"revision\":\"e5e344b184fe5d5891e32a67bd9bc91e\",\"services\":{\"com.ling.account.api.RemoteAccountService:dubbo\":{\"name\":\"com.ling.account.api.RemoteAccountService\",\"params\":{\"side\":\"provider\",\"release\":\"3.2.2\",\"methods\":\"loginByUsername\",\"logger\":\"slf4j\",\"deprecated\":\"false\",\"dubbo\":\"2.0.2\",\"interface\":\"com.ling.account.api.RemoteAccountService\",\"service-name-mapping\":\"true\",\"generic\":\"false\",\"metadata-type\":\"remote\",\"application\":\"ling-account\",\"prefer.serialization\":\"fastjson2,hessian2\",\"dynamic\":\"true\"},\"path\":\"com.ling.account.api.RemoteAccountService\",\"port\":20880,\"protocol\":\"dubbo\"}}}','d41e7e513e26b3bf29045a59f9830be0','2023-08-19 22:48:01','2023-08-19 22:48:01',NULL,'192.168.1.2','','dev',NULL,NULL,NULL,'text',NULL,''),(24,'ling-account','0ce55f72eb5bc8b7b96905f7c6e8ad21','{\"app\":\"ling-account\",\"revision\":\"0ce55f72eb5bc8b7b96905f7c6e8ad21\",\"services\":{\"com.ling.account.api.RemoteAccountService:dubbo\":{\"name\":\"com.ling.account.api.RemoteAccountService\",\"params\":{\"side\":\"provider\",\"release\":\"3.2.5\",\"methods\":\"loginByUsername\",\"logger\":\"slf4j\",\"deprecated\":\"false\",\"dubbo\":\"2.0.2\",\"interface\":\"com.ling.account.api.RemoteAccountService\",\"service-name-mapping\":\"true\",\"generic\":\"false\",\"metadata-type\":\"remote\",\"application\":\"ling-account\",\"prefer.serialization\":\"fastjson2,hessian2\",\"dynamic\":\"true\"},\"path\":\"com.ling.account.api.RemoteAccountService\",\"port\":20880,\"protocol\":\"dubbo\"}}}','434e0c05074694dc3e4a60c1a1fad24c','2023-08-19 23:24:41','2023-08-20 11:20:21',NULL,'192.168.1.2','','dev',NULL,NULL,NULL,'text',NULL,''),(35,'com.ling.account.api.RemoteAccountService:::provider:dubbo-ling-account','DUBBO_GROUP','{\"annotations\":[],\"canonicalName\":\"com.ling.account.api.RemoteAccountService\",\"codeSource\":\"file:/D:/Course/main/ling-mall/ling-api/ling-api-account/target/classes/\",\"methods\":[{\"annotations\":[],\"name\":\"test\",\"parameterTypes\":[],\"parameters\":[],\"returnType\":\"java.lang.String\"},{\"annotations\":[],\"name\":\"loginByUsername\",\"parameterTypes\":[\"java.lang.String\",\"java.lang.String\"],\"parameters\":[],\"returnType\":\"java.lang.String\"}],\"parameters\":{\"application\":\"dubbo-ling-account\",\"dubbo\":\"2.0.2\",\"interface\":\"com.ling.account.api.RemoteAccountService\",\"pid\":\"5788\",\"metadata-type\":\"remote\",\"anyhost\":\"true\",\"side\":\"provider\",\"release\":\"3.2.5\",\"executor-management-mode\":\"isolation\",\"file-cache\":\"true\",\"methods\":\"loginByUsername,test\",\"logger\":\"slf4j\",\"deprecated\":\"false\",\"service-name-mapping\":\"true\",\"qos.enable\":\"false\",\"bind.port\":\"20880\",\"register-mode\":\"instance\",\"generic\":\"false\",\"bind.ip\":\"192.168.1.2\",\"prefer.serialization\":\"fastjson2,hessian2\",\"ipv6\":\"240e:3b2:32dc:9a40:cdbe:5f49:5dd9:33fe\",\"background\":\"false\",\"dynamic\":\"true\",\"validation\":\"jvalidationNew\",\"timestamp\":\"1692506258783\"},\"types\":[{\"enums\":[],\"items\":[],\"properties\":{},\"type\":\"java.lang.String\"}],\"uniqueId\":\"com.ling.account.api.RemoteAccountService@file:/D:/Course/main/ling-mall/ling-api/ling-api-account/target/classes/\"}','b3c2dc7be5109a2059c95173f176e3e4','2023-08-20 11:59:44','2023-08-20 12:37:40',NULL,'192.168.1.2','','dev',NULL,NULL,NULL,'text',NULL,''),(36,'dubbo-ling-account','14b5e6687bba905f2f0101fc0454df70','{\"app\":\"dubbo-ling-account\",\"revision\":\"14b5e6687bba905f2f0101fc0454df70\",\"services\":{\"com.ling.account.api.RemoteAccountService:dubbo\":{\"name\":\"com.ling.account.api.RemoteAccountService\",\"params\":{\"side\":\"provider\",\"release\":\"3.2.5\",\"methods\":\"loginByUsername\",\"logger\":\"slf4j\",\"deprecated\":\"false\",\"dubbo\":\"2.0.2\",\"interface\":\"com.ling.account.api.RemoteAccountService\",\"service-name-mapping\":\"true\",\"generic\":\"false\",\"metadata-type\":\"remote\",\"application\":\"dubbo-ling-account\",\"prefer.serialization\":\"fastjson2,hessian2\",\"dynamic\":\"true\"},\"path\":\"com.ling.account.api.RemoteAccountService\",\"port\":20880,\"protocol\":\"dubbo\"}}}','1cac61f637c4a3ac5033448645a584bc','2023-08-20 11:59:44','2023-08-20 11:59:44',NULL,'192.168.1.2','','dev',NULL,NULL,NULL,'text',NULL,''),(38,'dubbo-ling-account','fea10e1985bcf6b58fb7c189670b2c8e','{\"app\":\"dubbo-ling-account\",\"revision\":\"fea10e1985bcf6b58fb7c189670b2c8e\",\"services\":{\"com.ling.account.api.RemoteAccountService:dubbo\":{\"name\":\"com.ling.account.api.RemoteAccountService\",\"params\":{\"side\":\"provider\",\"release\":\"3.2.5\",\"methods\":\"loginByUsername,test\",\"logger\":\"slf4j\",\"deprecated\":\"false\",\"dubbo\":\"2.0.2\",\"interface\":\"com.ling.account.api.RemoteAccountService\",\"service-name-mapping\":\"true\",\"generic\":\"false\",\"metadata-type\":\"remote\",\"application\":\"dubbo-ling-account\",\"prefer.serialization\":\"fastjson2,hessian2\",\"dynamic\":\"true\"},\"path\":\"com.ling.account.api.RemoteAccountService\",\"port\":20880,\"protocol\":\"dubbo\"}}}','954aa1807ba388ea021de08d63e2f383','2023-08-20 12:02:17','2023-08-20 12:37:40',NULL,'192.168.1.2','','dev',NULL,NULL,NULL,'text',NULL,''),(64,'com.ling.account.api.RemoteAccountService:::provider:dubbo-ling-account','DUBBO_GROUP','{\"annotations\":[],\"canonicalName\":\"com.ling.account.api.RemoteAccountService\",\"codeSource\":\"file:/D:/Course/main/ling-mall/ling-api/ling-api-account/target/classes/\",\"methods\":[{\"annotations\":[],\"name\":\"test\",\"parameterTypes\":[],\"parameters\":[],\"returnType\":\"java.lang.String\"},{\"annotations\":[],\"name\":\"loginByUsername\",\"parameterTypes\":[\"java.lang.String\",\"java.lang.String\"],\"parameters\":[],\"returnType\":\"java.lang.String\"}],\"parameters\":{\"dubbo\":\"2.0.2\",\"side\":\"provider\",\"anyhost\":\"true\",\"metadata-type\":\"local\",\"interface\":\"com.ling.account.api.RemoteAccountService\",\"application\":\"dubbo-ling-account\",\"release\":\"3.2.6\",\"pid\":\"26456\",\"executor-management-mode\":\"isolation\",\"file-cache\":\"true\",\"methods\":\"loginByUsername,test\",\"logger\":\"slf4j\",\"deprecated\":\"false\",\"service-name-mapping\":\"true\",\"qos.enable\":\"false\",\"bind.port\":\"20880\",\"register-mode\":\"instance\",\"generic\":\"false\",\"bind.ip\":\"192.168.1.5\",\"prefer.serialization\":\"fastjson2,hessian2\",\"ipv6\":\"240e:3b2:32de:ebc0:70f4:289:d9f3:99f7\",\"background\":\"false\",\"dynamic\":\"true\",\"validation\":\"jvalidationNew\",\"timestamp\":\"1694959850469\"},\"types\":[{\"enums\":[],\"items\":[],\"properties\":{},\"type\":\"java.lang.String\"}],\"uniqueId\":\"com.ling.account.api.RemoteAccountService@file:/D:/Course/main/ling-mall/ling-api/ling-api-account/target/classes/\"}','0cb5ed1dffabe9f76322753b2d231eff','2023-08-20 13:39:12','2023-09-17 22:10:54',NULL,'192.168.1.5','','dubbo',NULL,NULL,NULL,'text',NULL,''),(65,'com.ling.account.api.RemoteAccountService','mapping','dubbo-ling-account','9457a796d0d8e493e145c8fabfe50c6e','2023-08-20 13:39:12','2023-08-20 13:39:12',NULL,'192.168.1.2','','dubbo',NULL,NULL,NULL,'text',NULL,''),(87,'dubbo-ling-account','9220a5896cec4edee77c1c98227e9ce5','{\"app\":\"dubbo-ling-account\",\"revision\":\"9220a5896cec4edee77c1c98227e9ce5\",\"services\":{\"com.ling.account.api.RemoteAccountService:dubbo\":{\"name\":\"com.ling.account.api.RemoteAccountService\",\"params\":{\"side\":\"provider\",\"release\":\"3.2.5\",\"methods\":\"loginByUsername,test\",\"logger\":\"slf4j\",\"deprecated\":\"false\",\"dubbo\":\"2.0.2\",\"interface\":\"com.ling.account.api.RemoteAccountService\",\"service-name-mapping\":\"true\",\"generic\":\"false\",\"serialization\":\"hessian2\",\"metadata-type\":\"remote\",\"application\":\"dubbo-ling-account\",\"prefer.serialization\":\"hessian2\",\"dynamic\":\"true\"},\"path\":\"com.ling.account.api.RemoteAccountService\",\"port\":20880,\"protocol\":\"dubbo\"}}}','abfc7f3ef8f245a305feb7e31cbf8822','2023-09-16 20:28:23','2023-09-16 21:15:39',NULL,'192.168.1.5','','dubbo',NULL,NULL,NULL,'text',NULL,''),(109,'dubbo-ling-account','daa2b174fcad24de14de3f21bb607b01','{\"app\":\"dubbo-ling-account\",\"revision\":\"daa2b174fcad24de14de3f21bb607b01\",\"services\":{\"com.ling.account.api.RemoteAccountService:dubbo\":{\"name\":\"com.ling.account.api.RemoteAccountService\",\"params\":{\"side\":\"provider\",\"release\":\"3.2.6\",\"methods\":\"loginByUsername,test\",\"logger\":\"slf4j\",\"deprecated\":\"false\",\"dubbo\":\"2.0.2\",\"interface\":\"com.ling.account.api.RemoteAccountService\",\"service-name-mapping\":\"true\",\"generic\":\"false\",\"serialization\":\"hessian2\",\"metadata-type\":\"remote\",\"application\":\"dubbo-ling-account\",\"prefer.serialization\":\"hessian2\",\"dynamic\":\"true\"},\"path\":\"com.ling.account.api.RemoteAccountService\",\"port\":20880,\"protocol\":\"dubbo\"}}}','381ffb778b633e92a515fa263082b51c','2023-09-16 21:20:58','2023-09-16 22:07:33',NULL,'192.168.1.5','','dubbo',NULL,NULL,NULL,'text',NULL,''),(137,'lingcloud-common-other.yaml','LING_CLOUD_GROUP','spring:\n  messages:\n    # 国际化资源文件路径\n    basename: i18n/messages\n    encoding: UTF-8\n  # redis通用配置 子服务可以自行配置进行覆盖\n  data:\n    redis:\n      host: localhost\n      port: 6379\n      # 密码(如没有密码请注释掉)\n      password: \"12345678\"\n      database: 0\n      timeout: 10s\n\n\nsa-token:\n  # jwt秘钥\n  jwt-secret-key: UgdpVp2s6WYbf8UgtQqCKlaCCea7RHjPdxEPx5ex1TqW\n\n# MyBatisPlus配置\n# https://baomidou.com/config/\nmybatis-plus:\n  # 扫描包配置\n  mapperPackage: com.ling.lingcloud.**.mapper\n  # 对应的 XML 文件位置\n  mapperLocations: classpath*:mapper/**/*Mapper.xml\n  # 实体扫描，多个package用逗号或者分号分隔\n  typeAliasesPackage: com.ling.lingcloud.**.domain,com.ling.lingcloud.**.api.domain\n  # 针对 typeAliasesPackage，如果配置了该属性，则仅仅会扫描路径下以该类作为父类的域对象\n  #typeAliasesSuperType: Class<?>\n  # 如果配置了该属性，SqlSessionFactoryBean 会把该包下面的类注册为对应的 TypeHandler\n  #typeHandlersPackage: null\n  # 如果配置了该属性，会将路径下的枚举类进行注入，让实体类字段能够简单快捷的使用枚举属性\n  #typeEnumsPackage: null\n  # 启动时是否检查 MyBatis XML 文件的存在，默认不检查\n  checkConfigLocation: false\n  # 通过该属性可指定 MyBatis 的执行器，MyBatis 的执行器总共有三种：\n  # SIMPLE：该执行器类型不做特殊的事情，为每个语句的执行创建一个新的预处理语句（PreparedStatement）\n  # REUSE：该执行器类型会复用预处理语句（PreparedStatement）\n  # BATCH：该执行器类型会批量执行所有的更新语句\n  executorType: SIMPLE\n  configuration:\n    # 自动驼峰命名规则（camel case）映射\n    # 如果您的数据库命名符合规则无需使用 @TableField 注解指定数据库字段名\n    mapUnderscoreToCamelCase: true\n    # 默认枚举处理类,如果配置了该属性,枚举将统一使用指定处理器进行处理\n    # org.apache.ibatis.type.EnumTypeHandler : 存储枚举的名称\n    # org.apache.ibatis.type.EnumOrdinalTypeHandler : 存储枚举的索引\n    # com.baomidou.mybatisplus.extension.handlers.MybatisEnumTypeHandler : 枚举类需要实现IEnum接口或字段标记@EnumValue注解.\n    defaultEnumTypeHandler: org.apache.ibatis.type.EnumTypeHandler\n    # 当设置为 true 的时候，懒加载的对象可能被任何懒属性全部加载，否则，每个属性都按需加载。需要和 lazyLoadingEnabled 一起使用。\n    aggressiveLazyLoading: true\n    # MyBatis 自动映射策略\n    # NONE：不启用自动映射\n    # PARTIAL：只对非嵌套的 resultMap 进行自动映射\n    # FULL：对所有的 resultMap 都进行自动映射\n    autoMappingBehavior: PARTIAL\n    # MyBatis 自动映射时未知列或未知属性处理策\n    # NONE：不做任何处理 (默认值)\n    # WARNING：以日志的形式打印相关警告信息\n    # FAILING：当作映射失败处理，并抛出异常和详细信息\n    autoMappingUnknownColumnBehavior: NONE\n    # Mybatis一级缓存，默认为 SESSION\n    # SESSION session级别缓存，同一个session相同查询语句不会再次查询数据库\n    # STATEMENT 关闭一级缓存\n    localCacheScope: SESSION\n    # 开启Mybatis二级缓存，默认为 true\n    cacheEnabled: true\n  global-config:\n\n    # 是否打印 Logo banner\n    banner: true\n    # 是否初始化 SqlRunner\n    enableSqlRunner: false\n    dbConfig:\n      # 主键类型\n      # AUTO 数据库ID自增\n      # NONE 空\n      # INPUT 用户输入ID\n      # ASSIGN_ID 全局唯一ID\n      # ASSIGN_UUID 全局唯一ID UUID\n      idType: AUTO\n      # 表名前缀\n      tablePrefix: null\n      # 字段 format,例: %s,(对主键无效)\n      columnFormat: null\n      # 表名是否使用驼峰转下划线命名,只对表名生效\n      tableUnderline: true\n      # 大写命名,对表名和字段名均生效\n      capitalMode: false\n      # 全局的entity的逻辑删除字段属性名\n      logicDeleteField: is_deleted\n      # 逻辑已删除值\n      logicDeleteValue: 1\n      # 逻辑未删除值\n      logicNotDeleteValue: 0\n      # 字段验证策略之 insert,在 insert 的时候的字段验证策略\n      # IGNORED 忽略判断\n      # NOT_NULL 非NULL判断\n      # NOT_EMPTY 非空判断(只对字符串类型字段,其他类型字段依然为非NULL判断)\n      # DEFAULT 默认的,一般只用于注解里\n      # NEVER 不加入 SQL\n      insertStrategy: NOT_EMPTY\n      # 字段验证策略之 update,在 update 的时候的字段验证策略\n      updateStrategy: NOT_EMPTY\n      # 字段验证策略之 where,空字符串与null不添加条件\n      where-strategy: NOT_EMPTY\n\n# redisson 配置\nredisson:\n  # redis key前缀\n  keyPrefix:\n  # 线程池数量\n  threads: 4\n  # Netty线程池数量\n  nettyThreads: 8\n  # 单节点配置\n  singleServerConfig:\n    # 客户端名称\n    clientName: ${spring.application.name}\n    # 最小空闲连接数\n    connectionMinimumIdleSize: 8\n    # 连接池大小\n    connectionPoolSize: 32\n    # 连接空闲超时，单位：毫秒\n    idleConnectionTimeout: 10000\n    # 命令等待超时，单位：毫秒\n    timeout: 3000\n    # 发布和订阅连接池大小\n    subscriptionConnectionPoolSize: 50\n\n\ndubbo:\n  application:\n    name: dubbo-${spring.application.name}\n    logger: slf4j\n    # 元数据中心 local 本地 remote 远程 这里使用远程便于其他服务获取\n    metadataType: remote\n    # 可选值 interface、instance、all，默认是 all，即接口级地址、应用级地址都注册\n    register-mode: instance\n    service-discovery:\n      # FORCE_INTERFACE，只消费接口级地址，如无地址则报错，单订阅 2.x 地址\n      # APPLICATION_FIRST，智能决策接口级/应用级地址，双订阅\n      # FORCE_APPLICATION，只消费应用级地址，如无地址则报错，单订阅 3.x 地址\n      migration: FORCE_APPLICATION\n    qos-enable: false\n    metadata-type: local\n  protocol:\n    # 设置为 tri 即可使用 Triple 3.0 新协议\n    # 性能对比 dubbo 协议并没有提升 但基于 http2 用于多语言异构等 http 交互场景\n    # 使用 dubbo 协议通信\n    name: dubbo\n    # dubbo 协议端口(-1表示自增端口,从20880开始)\n    port: -1\n    # 指定dubbo协议注册ip\n    # host: 192.168.0.100\n  # 注册中心配置\n  registry:\n    address: nacos://${spring.cloud.nacos.server-addr}\n    username: ${spring.cloud.nacos.username}\n    password: ${spring.cloud.nacos.password}\n    group: DUBBO_GROUP\n    parameters:\n      namespace: dubbo\n  provider:\n    validation: jvalidationNew\n  # 消费者相关配置\n  consumer:\n    # 结果缓存(LRU算法)\n    # 会有数据不一致问题 建议在注解局部开启\n    cache: false\n    # 支持校验注解\n    validation: jvalidationNew\n    # 超时时间\n    timeout: 3000\n    # 初始化检查\n    check: false\n  scan:\n    # 接口实现类扫描\n    base-packages: com.ling.**.dubbo\n  # 自定义配置\n  custom:\n    # 全局请求log\n    request-log: true\n    # info 基础信息 param 参数信息 full 全部\n    log-level: info','770a6f7168d05cefa55ca6588ccfaec4','2023-09-25 14:10:18','2023-10-16 15:05:06','nacos','113.89.232.108','','e3918c99-f219-4d44-9845-1766f7d79dac','','','','yaml','',''),(138,'lingcloud-common-resources.yaml','LING_CLOUD_GROUP','spring:\n  datasource:\n    url: jdbc:mysql://localhost:3306/ling-cloud?useUnicode=true&characterEncoding=utf-8&serverTimezone=Asia/Shanghai&allowMultiQueries=true\n    username: root\n    password: 12345678\n    druid:\n      initial-size: 5 #连接池初始化大小\n      min-idle: 10 #最小空闲连接数\n      max-active: 20 #最大连接数\n      web-stat-filter:\n        exclusions: \"*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*\" #不统计这些请求数据\n      stat-view-servlet: #访问监控网页的登录用户名和密码\n        login-username: druid\n        login-password: druid\n      validation-query: SELECT 1','5e0154546a8a3ef75979cdc062c80817','2023-09-25 14:10:18','2023-10-16 15:13:09','nacos','113.89.232.108','','e3918c99-f219-4d44-9845-1766f7d79dac','','','','yaml','',''),(139,'lingcloud-demo-service.yaml','LING_CLOUD_GROUP','a: 不愧是我','fb0fe08f614522ca5840d295f76e3b9d','2023-09-25 14:10:18','2023-09-25 14:10:18',NULL,'183.17.228.55','','e3918c99-f219-4d44-9845-1766f7d79dac',NULL,NULL,NULL,'yaml',NULL,''),(140,'lingcloud-gateway-service.yaml','LING_CLOUD_GROUP','spring:\n  cloud:\n    # 网关配置\n    gateway:\n      # 打印请求日志(自定义)\n      requestLog: true\n      discovery:\n        locator:\n          lowerCaseServiceId: true\n          enabled: true\n      # routes:\n      #   - id: demo\n      #     uri: lb://lingcloud-demo\n      #     predicates:\n      #       - Path=/demo/**\n      #     filters:\n      #       - StripPrefix=1\n','d6ea9a048c669651083ba50e5da42f0e','2023-09-25 14:10:18','2023-10-18 11:54:41','nacos','113.89.232.108','','e3918c99-f219-4d44-9845-1766f7d79dac','','','','yaml','',''),(141,'lingcloud-account-service.yaml','LING_CLOUD_GROUP','a: aaa','05e543068f56cef938e5919563c25408','2023-09-28 22:24:28','2023-09-28 22:24:28','nacos','119.137.3.251','','e3918c99-f219-4d44-9845-1766f7d79dac',NULL,NULL,NULL,'yaml',NULL,''),(156,'com.ling.lingcloud.gateway.api.RemoteGatewayService','mapping','dubbo-gateway','3f3010bc50078e0bc97a610f0fa0ea3b','2023-10-18 17:31:35','2023-10-18 17:31:35',NULL,'192.168.177.1','','dubbo',NULL,NULL,NULL,'text',NULL,''),(157,'com.ling.lingcloud.gateway.api.RemoteGatewayService:::provider:dubbo-gateway','DUBBO_GROUP','{\"annotations\":[],\"canonicalName\":\"com.ling.lingcloud.gateway.api.RemoteGatewayService\",\"codeSource\":\"file:/D:/main/ling-cloud/sources/basics/api/gateway-api/target/classes/\",\"methods\":[{\"annotations\":[],\"name\":\"loadRouter\",\"parameterTypes\":[],\"parameters\":[],\"returnType\":\"void\"},{\"annotations\":[],\"name\":\"saveGatewayRoute\",\"parameterTypes\":[\"com.ling.lingcloud.gateway.api.dto.GatewayRouteDTO\"],\"parameters\":[],\"returnType\":\"java.lang.Boolean\"},{\"annotations\":[],\"name\":\"listPageGatewayRoute\",\"parameterTypes\":[\"com.ling.lingcloud.gateway.api.dto.GatewayRouteDTO\",\"com.ling.lingcloud.common.mp.domain.PageQuery\"],\"parameters\":[],\"returnType\":\"com.ling.lingcloud.common.mp.domain.PageInfo\"},{\"annotations\":[],\"name\":\"updateGatewayRouteById\",\"parameterTypes\":[\"com.ling.lingcloud.gateway.api.dto.GatewayRouteDTO\"],\"parameters\":[],\"returnType\":\"java.lang.Boolean\"},{\"annotations\":[],\"name\":\"removeGatewayRouteById\",\"parameterTypes\":[\"java.lang.Long\"],\"parameters\":[],\"returnType\":\"java.lang.Boolean\"}],\"parameters\":{\"side\":\"provider\",\"release\":\"3.2.6\",\"dubbo\":\"2.0.2\",\"metadata-type\":\"local\",\"pid\":\"21908\",\"interface\":\"com.ling.lingcloud.gateway.api.RemoteGatewayService\",\"anyhost\":\"true\",\"application\":\"dubbo-gateway\",\"executor-management-mode\":\"isolation\",\"file-cache\":\"true\",\"methods\":\"listPageGatewayRoute,loadRouter,removeGatewayRouteById,saveGatewayRoute,updateGatewayRouteById\",\"logger\":\"slf4j\",\"deprecated\":\"false\",\"service-name-mapping\":\"true\",\"register-mode\":\"instance\",\"qos.enable\":\"false\",\"generic\":\"false\",\"bind.port\":\"20881\",\"bind.ip\":\"172.29.192.1\",\"prefer.serialization\":\"fastjson2,hessian2\",\"background\":\"false\",\"dynamic\":\"true\",\"validation\":\"jvalidationNew\",\"timestamp\":\"1700633924729\"},\"types\":[{\"enums\":[],\"items\":[],\"properties\":{\"pageSize\":\"java.lang.Long\",\"orderBy\":\"java.lang.String\",\"pageNum\":\"java.lang.Long\"},\"type\":\"com.ling.lingcloud.common.mp.domain.PageQuery\"},{\"enums\":[],\"items\":[],\"properties\":{},\"type\":\"void\"},{\"enums\":[],\"items\":[],\"properties\":{},\"type\":\"byte\"},{\"enums\":[],\"items\":[\"com.ling.lingcloud.gateway.api.domain.GatewayRouteItem\"],\"properties\":{},\"type\":\"java.util.List<com.ling.lingcloud.gateway.api.domain.GatewayRouteItem>\"},{\"enums\":[],\"items\":[],\"properties\":{\"total\":\"long\",\"code\":\"int\",\"message\":\"java.lang.String\",\"timestamp\":\"long\",\"isSuccess\":\"java.lang.Boolean\"},\"type\":\"com.ling.lingcloud.common.mp.domain.PageInfo\"},{\"enums\":[],\"items\":[],\"properties\":{\"date\":\"java.time.LocalDate\",\"time\":\"java.time.LocalTime\"},\"type\":\"java.time.LocalDateTime\"},{\"enums\":[],\"items\":[],\"properties\":{},\"type\":\"java.lang.Integer\"},{\"enums\":[],\"items\":[],\"properties\":{},\"type\":\"int\"},{\"enums\":[],\"items\":[],\"properties\":{},\"type\":\"long\"},{\"enums\":[],\"items\":[],\"properties\":{},\"type\":\"java.lang.Long\"},{\"enums\":[],\"items\":[],\"properties\":{\"stripPrefix\":\"java.lang.Integer\",\"updateTime\":\"java.time.LocalDateTime\",\"remark\":\"java.lang.String\",\"showApi\":\"java.lang.Integer\",\"sort\":\"java.lang.Integer\",\"uri\":\"java.lang.String\",\"createBy\":\"java.lang.Long\",\"isDeleted\":\"java.lang.Byte\",\"gatewayRouteItemList\":\"java.util.List<com.ling.lingcloud.gateway.api.domain.GatewayRouteItem>\",\"createTime\":\"java.time.LocalDateTime\",\"updateBy\":\"java.lang.Long\",\"routerId\":\"java.lang.String\",\"name\":\"java.lang.String\",\"id\":\"java.lang.Long\",\"status\":\"java.lang.Integer\"},\"type\":\"com.ling.lingcloud.gateway.api.dto.GatewayRouteDTO\"},{\"enums\":[],\"items\":[],\"properties\":{\"month\":\"short\",\"year\":\"int\",\"day\":\"short\"},\"type\":\"java.time.LocalDate\"},{\"enums\":[],\"items\":[],\"properties\":{\"hour\":\"byte\",\"nano\":\"int\",\"minute\":\"byte\",\"second\":\"byte\"},\"type\":\"java.time.LocalTime\"},{\"enums\":[],\"items\":[],\"properties\":{},\"type\":\"short\"},{\"enums\":[],\"items\":[],\"properties\":{},\"type\":\"java.lang.Boolean\"},{\"enums\":[],\"items\":[],\"properties\":{},\"type\":\"java.lang.String\"},{\"enums\":[],\"items\":[],\"properties\":{},\"type\":\"java.lang.Byte\"},{\"enums\":[],\"items\":[],\"properties\":{\"paramKey\":\"java.lang.String\",\"createBy\":\"java.lang.Long\",\"routeId\":\"java.lang.Long\",\"isDeleted\":\"java.lang.Byte\",\"createTime\":\"java.time.LocalDateTime\",\"updateBy\":\"java.lang.Long\",\"updateTime\":\"java.time.LocalDateTime\",\"remark\":\"java.lang.String\",\"id\":\"java.lang.Long\",\"type\":\"java.lang.Integer\",\"paramValue\":\"java.lang.String\",\"status\":\"java.lang.Integer\"},\"type\":\"com.ling.lingcloud.gateway.api.domain.GatewayRouteItem\"}],\"uniqueId\":\"com.ling.lingcloud.gateway.api.RemoteGatewayService@file:/D:/main/ling-cloud/sources/basics/api/gateway-api/target/classes/\"}','00d54a19d7c1b721440d73dbd9201d27','2023-10-18 17:31:35','2023-11-22 06:18:45',NULL,'192.168.177.1','','dubbo',NULL,NULL,NULL,'text',NULL,''),(162,'com.ling.lingcloud.account.api.RemoteAccountService:::provider:dubbo-account','DUBBO_GROUP','{\"annotations\":[],\"canonicalName\":\"com.ling.lingcloud.account.api.RemoteAccountService\",\"codeSource\":\"file:/D:/main/ling-cloud/sources/basics/api/account-api/target/classes/\",\"methods\":[{\"annotations\":[],\"name\":\"loginByUsername\",\"parameterTypes\":[\"java.lang.String\",\"java.lang.String\"],\"parameters\":[],\"returnType\":\"java.lang.String\"}],\"parameters\":{\"release\":\"3.2.6\",\"metadata-type\":\"local\",\"anyhost\":\"true\",\"application\":\"dubbo-account\",\"side\":\"provider\",\"dubbo\":\"2.0.2\",\"interface\":\"com.ling.lingcloud.account.api.RemoteAccountService\",\"pid\":\"31796\",\"executor-management-mode\":\"isolation\",\"file-cache\":\"true\",\"methods\":\"loginByUsername\",\"logger\":\"slf4j\",\"deprecated\":\"false\",\"service-name-mapping\":\"true\",\"register-mode\":\"instance\",\"qos.enable\":\"false\",\"generic\":\"false\",\"bind.port\":\"20880\",\"bind.ip\":\"172.29.192.1\",\"prefer.serialization\":\"fastjson2,hessian2\",\"background\":\"false\",\"dynamic\":\"true\",\"validation\":\"jvalidationNew\",\"timestamp\":\"1700646890916\"},\"types\":[{\"enums\":[],\"items\":[],\"properties\":{},\"type\":\"java.lang.String\"}],\"uniqueId\":\"com.ling.lingcloud.account.api.RemoteAccountService@file:/D:/main/ling-cloud/sources/basics/api/account-api/target/classes/\"}','9f6b5b997ea64d01ef54e42cb870c507','2023-10-19 16:37:05','2023-11-22 09:54:51',NULL,'192.168.177.1','','dubbo',NULL,NULL,NULL,'text',NULL,''),(163,'com.ling.lingcloud.account.api.RemoteAccountService','mapping','dubbo-account','8bc5905bdf7fca3cfb27913687148861','2023-10-19 16:37:05','2023-10-19 16:37:05',NULL,'192.168.177.1','','dubbo',NULL,NULL,NULL,'text',NULL,'');
/*!40000 ALTER TABLE `config_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `config_info_aggr`
--

DROP TABLE IF EXISTS `config_info_aggr`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `config_info_aggr` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `data_id` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL COMMENT 'data_id',
  `group_id` varchar(128) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL COMMENT 'group_id',
  `datum_id` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL COMMENT 'datum_id',
  `content` longtext CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL COMMENT '内容',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  `app_name` varchar(128) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL COMMENT 'app_name',
  `tenant_id` varchar(128) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT '' COMMENT '租户字段',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_configinfoaggr_datagrouptenantdatum` (`data_id`,`group_id`,`tenant_id`,`datum_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin COMMENT='增加租户字段';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `config_info_aggr`
--

LOCK TABLES `config_info_aggr` WRITE;
/*!40000 ALTER TABLE `config_info_aggr` DISABLE KEYS */;
/*!40000 ALTER TABLE `config_info_aggr` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `config_info_beta`
--

DROP TABLE IF EXISTS `config_info_beta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `config_info_beta` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `data_id` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL COMMENT 'data_id',
  `group_id` varchar(128) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL COMMENT 'group_id',
  `app_name` varchar(128) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL COMMENT 'app_name',
  `content` longtext CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL COMMENT 'content',
  `beta_ips` varchar(1024) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL COMMENT 'betaIps',
  `md5` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL COMMENT 'md5',
  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  `src_user` text CHARACTER SET utf8mb3 COLLATE utf8mb3_bin COMMENT 'source user',
  `src_ip` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL COMMENT 'source ip',
  `tenant_id` varchar(128) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT '' COMMENT '租户字段',
  `encrypted_data_key` text CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL COMMENT '密钥',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_configinfobeta_datagrouptenant` (`data_id`,`group_id`,`tenant_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin COMMENT='config_info_beta';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `config_info_beta`
--

LOCK TABLES `config_info_beta` WRITE;
/*!40000 ALTER TABLE `config_info_beta` DISABLE KEYS */;
/*!40000 ALTER TABLE `config_info_beta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `config_info_tag`
--

DROP TABLE IF EXISTS `config_info_tag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `config_info_tag` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `data_id` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL COMMENT 'data_id',
  `group_id` varchar(128) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL COMMENT 'group_id',
  `tenant_id` varchar(128) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT '' COMMENT 'tenant_id',
  `tag_id` varchar(128) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL COMMENT 'tag_id',
  `app_name` varchar(128) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL COMMENT 'app_name',
  `content` longtext CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL COMMENT 'content',
  `md5` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL COMMENT 'md5',
  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  `src_user` text CHARACTER SET utf8mb3 COLLATE utf8mb3_bin COMMENT 'source user',
  `src_ip` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL COMMENT 'source ip',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_configinfotag_datagrouptenanttag` (`data_id`,`group_id`,`tenant_id`,`tag_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin COMMENT='config_info_tag';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `config_info_tag`
--

LOCK TABLES `config_info_tag` WRITE;
/*!40000 ALTER TABLE `config_info_tag` DISABLE KEYS */;
/*!40000 ALTER TABLE `config_info_tag` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `config_tags_relation`
--

DROP TABLE IF EXISTS `config_tags_relation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `config_tags_relation` (
  `id` bigint NOT NULL COMMENT 'id',
  `tag_name` varchar(128) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL COMMENT 'tag_name',
  `tag_type` varchar(64) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL COMMENT 'tag_type',
  `data_id` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL COMMENT 'data_id',
  `group_id` varchar(128) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL COMMENT 'group_id',
  `tenant_id` varchar(128) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT '' COMMENT 'tenant_id',
  `nid` bigint NOT NULL AUTO_INCREMENT COMMENT 'nid, 自增长标识',
  PRIMARY KEY (`nid`),
  UNIQUE KEY `uk_configtagrelation_configidtag` (`id`,`tag_name`,`tag_type`),
  KEY `idx_tenant_id` (`tenant_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin COMMENT='config_tag_relation';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `config_tags_relation`
--

LOCK TABLES `config_tags_relation` WRITE;
/*!40000 ALTER TABLE `config_tags_relation` DISABLE KEYS */;
/*!40000 ALTER TABLE `config_tags_relation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `group_capacity`
--

DROP TABLE IF EXISTS `group_capacity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `group_capacity` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `group_id` varchar(128) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL DEFAULT '' COMMENT 'Group ID，空字符表示整个集群',
  `quota` int unsigned NOT NULL DEFAULT '0' COMMENT '配额，0表示使用默认值',
  `usage` int unsigned NOT NULL DEFAULT '0' COMMENT '使用量',
  `max_size` int unsigned NOT NULL DEFAULT '0' COMMENT '单个配置大小上限，单位为字节，0表示使用默认值',
  `max_aggr_count` int unsigned NOT NULL DEFAULT '0' COMMENT '聚合子配置最大个数，，0表示使用默认值',
  `max_aggr_size` int unsigned NOT NULL DEFAULT '0' COMMENT '单个聚合数据的子配置大小上限，单位为字节，0表示使用默认值',
  `max_history_count` int unsigned NOT NULL DEFAULT '0' COMMENT '最大变更历史数量',
  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_group_id` (`group_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin COMMENT='集群、各Group容量信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `group_capacity`
--

LOCK TABLES `group_capacity` WRITE;
/*!40000 ALTER TABLE `group_capacity` DISABLE KEYS */;
/*!40000 ALTER TABLE `group_capacity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `his_config_info`
--

DROP TABLE IF EXISTS `his_config_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `his_config_info` (
  `id` bigint unsigned NOT NULL COMMENT 'id',
  `nid` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT 'nid, 自增标识',
  `data_id` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL COMMENT 'data_id',
  `group_id` varchar(128) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL COMMENT 'group_id',
  `app_name` varchar(128) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL COMMENT 'app_name',
  `content` longtext CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL COMMENT 'content',
  `md5` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL COMMENT 'md5',
  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  `src_user` text CHARACTER SET utf8mb3 COLLATE utf8mb3_bin COMMENT 'source user',
  `src_ip` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL COMMENT 'source ip',
  `op_type` char(10) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL COMMENT 'operation type',
  `tenant_id` varchar(128) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT '' COMMENT '租户字段',
  `encrypted_data_key` text CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL COMMENT '密钥',
  PRIMARY KEY (`nid`),
  KEY `idx_gmt_create` (`gmt_create`),
  KEY `idx_gmt_modified` (`gmt_modified`),
  KEY `idx_did` (`data_id`)
) ENGINE=InnoDB AUTO_INCREMENT=203 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin COMMENT='多租户改造';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `his_config_info`
--

LOCK TABLES `his_config_info` WRITE;
/*!40000 ALTER TABLE `his_config_info` DISABLE KEYS */;
INSERT INTO `his_config_info` VALUES (162,194,'com.ling.lingcloud.account.api.RemoteAccountService:::provider:dubbo-account','DUBBO_GROUP','','{\"annotations\":[],\"canonicalName\":\"com.ling.lingcloud.account.api.RemoteAccountService\",\"codeSource\":\"file:/D:/main/ling-cloud/sources/basics/api/account-api/target/classes/\",\"methods\":[{\"annotations\":[],\"name\":\"loginByUsername\",\"parameterTypes\":[\"java.lang.String\",\"java.lang.String\"],\"parameters\":[],\"returnType\":\"java.lang.String\"}],\"parameters\":{\"metadata-type\":\"local\",\"pid\":\"8988\",\"application\":\"dubbo-account\",\"dubbo\":\"2.0.2\",\"release\":\"3.2.6\",\"interface\":\"com.ling.lingcloud.account.api.RemoteAccountService\",\"anyhost\":\"true\",\"side\":\"provider\",\"executor-management-mode\":\"isolation\",\"file-cache\":\"true\",\"methods\":\"loginByUsername\",\"logger\":\"slf4j\",\"deprecated\":\"false\",\"service-name-mapping\":\"true\",\"register-mode\":\"instance\",\"qos.enable\":\"false\",\"generic\":\"false\",\"bind.port\":\"20880\",\"bind.ip\":\"172.18.240.1\",\"prefer.serialization\":\"fastjson2,hessian2\",\"background\":\"false\",\"dynamic\":\"true\",\"validation\":\"jvalidationNew\",\"timestamp\":\"1697704623874\"},\"types\":[{\"enums\":[],\"items\":[],\"properties\":{},\"type\":\"java.lang.String\"}],\"uniqueId\":\"com.ling.lingcloud.account.api.RemoteAccountService@file:/D:/main/ling-cloud/sources/basics/api/account-api/target/classes/\"}','5f9fa659e762b0e5c243f99bce8028a8','2023-11-22 14:11:41','2023-11-22 06:11:41',NULL,'192.168.177.1','U','dubbo',''),(157,195,'com.ling.lingcloud.gateway.api.RemoteGatewayService:::provider:dubbo-gateway','DUBBO_GROUP','','{\"annotations\":[],\"canonicalName\":\"com.ling.lingcloud.gateway.api.RemoteGatewayService\",\"codeSource\":\"file:/D:/main/ling-cloud/sources/basics/api/gateway-api/target/classes/\",\"methods\":[{\"annotations\":[],\"name\":\"loadRouter\",\"parameterTypes\":[],\"parameters\":[],\"returnType\":\"void\"},{\"annotations\":[],\"name\":\"updateGatewayRouteById\",\"parameterTypes\":[\"com.ling.lingcloud.gateway.api.dto.GatewayRouteDTO\"],\"parameters\":[],\"returnType\":\"java.lang.Boolean\"},{\"annotations\":[],\"name\":\"listPageGatewayRoute\",\"parameterTypes\":[\"com.ling.lingcloud.gateway.api.dto.GatewayRouteDTO\",\"com.ling.lingcloud.common.mp.domain.PageQuery\"],\"parameters\":[],\"returnType\":\"com.ling.lingcloud.common.mp.domain.PageInfo\"},{\"annotations\":[],\"name\":\"removeGatewayRouteById\",\"parameterTypes\":[\"java.lang.Long\"],\"parameters\":[],\"returnType\":\"java.lang.Boolean\"},{\"annotations\":[],\"name\":\"saveGatewayRoute\",\"parameterTypes\":[\"com.ling.lingcloud.gateway.api.dto.GatewayRouteDTO\"],\"parameters\":[],\"returnType\":\"java.lang.Boolean\"}],\"parameters\":{\"application\":\"dubbo-gateway\",\"release\":\"3.2.6\",\"anyhost\":\"true\",\"interface\":\"com.ling.lingcloud.gateway.api.RemoteGatewayService\",\"pid\":\"860\",\"metadata-type\":\"local\",\"side\":\"provider\",\"dubbo\":\"2.0.2\",\"executor-management-mode\":\"isolation\",\"file-cache\":\"true\",\"methods\":\"listPageGatewayRoute,loadRouter,removeGatewayRouteById,saveGatewayRoute,updateGatewayRouteById\",\"logger\":\"slf4j\",\"deprecated\":\"false\",\"service-name-mapping\":\"true\",\"register-mode\":\"instance\",\"qos.enable\":\"false\",\"generic\":\"false\",\"bind.port\":\"20880\",\"bind.ip\":\"172.18.240.1\",\"prefer.serialization\":\"fastjson2,hessian2\",\"background\":\"false\",\"dynamic\":\"true\",\"validation\":\"jvalidationNew\",\"timestamp\":\"1697684442115\"},\"types\":[{\"enums\":[],\"items\":[],\"properties\":{\"pageSize\":\"java.lang.Integer\",\"orderBy\":\"java.lang.String\",\"pageNum\":\"java.lang.Integer\"},\"type\":\"com.ling.lingcloud.common.mp.domain.PageQuery\"},{\"enums\":[],\"items\":[],\"properties\":{},\"type\":\"void\"},{\"enums\":[],\"items\":[],\"properties\":{},\"type\":\"byte\"},{\"enums\":[],\"items\":[\"com.ling.lingcloud.gateway.api.domain.GatewayRouteItem\"],\"properties\":{},\"type\":\"java.util.List<com.ling.lingcloud.gateway.api.domain.GatewayRouteItem>\"},{\"enums\":[],\"items\":[],\"properties\":{\"total\":\"long\",\"code\":\"int\",\"message\":\"java.lang.String\",\"timestamp\":\"long\",\"isSuccess\":\"java.lang.Boolean\"},\"type\":\"com.ling.lingcloud.common.mp.domain.PageInfo\"},{\"enums\":[],\"items\":[],\"properties\":{\"date\":\"java.time.LocalDate\",\"time\":\"java.time.LocalTime\"},\"type\":\"java.time.LocalDateTime\"},{\"enums\":[],\"items\":[],\"properties\":{},\"type\":\"java.lang.Integer\"},{\"enums\":[],\"items\":[],\"properties\":{},\"type\":\"int\"},{\"enums\":[],\"items\":[],\"properties\":{},\"type\":\"long\"},{\"enums\":[],\"items\":[],\"properties\":{},\"type\":\"java.lang.Long\"},{\"enums\":[],\"items\":[],\"properties\":{\"stripPrefix\":\"java.lang.Integer\",\"updateTime\":\"java.time.LocalDateTime\",\"remark\":\"java.lang.String\",\"showApi\":\"java.lang.Integer\",\"sort\":\"java.lang.Integer\",\"uri\":\"java.lang.String\",\"createBy\":\"java.lang.Long\",\"isDeleted\":\"java.lang.Byte\",\"gatewayRouteItemList\":\"java.util.List<com.ling.lingcloud.gateway.api.domain.GatewayRouteItem>\",\"createTime\":\"java.time.LocalDateTime\",\"updateBy\":\"java.lang.Long\",\"routerId\":\"java.lang.String\",\"name\":\"java.lang.String\",\"id\":\"java.lang.Long\",\"status\":\"java.lang.Integer\"},\"type\":\"com.ling.lingcloud.gateway.api.dto.GatewayRouteDTO\"},{\"enums\":[],\"items\":[],\"properties\":{\"month\":\"short\",\"year\":\"int\",\"day\":\"short\"},\"type\":\"java.time.LocalDate\"},{\"enums\":[],\"items\":[],\"properties\":{\"hour\":\"byte\",\"nano\":\"int\",\"minute\":\"byte\",\"second\":\"byte\"},\"type\":\"java.time.LocalTime\"},{\"enums\":[],\"items\":[],\"properties\":{},\"type\":\"short\"},{\"enums\":[],\"items\":[],\"properties\":{},\"type\":\"java.lang.Boolean\"},{\"enums\":[],\"items\":[],\"properties\":{},\"type\":\"java.lang.String\"},{\"enums\":[],\"items\":[],\"properties\":{},\"type\":\"java.lang.Byte\"},{\"enums\":[],\"items\":[],\"properties\":{\"paramKey\":\"java.lang.String\",\"createBy\":\"java.lang.Long\",\"routeId\":\"java.lang.Long\",\"isDeleted\":\"java.lang.Byte\",\"createTime\":\"java.time.LocalDateTime\",\"updateBy\":\"java.lang.Long\",\"updateTime\":\"java.time.LocalDateTime\",\"remark\":\"java.lang.String\",\"id\":\"java.lang.Long\",\"type\":\"java.lang.Integer\",\"paramValue\":\"java.lang.String\",\"status\":\"java.lang.Integer\"},\"type\":\"com.ling.lingcloud.gateway.api.domain.GatewayRouteItem\"}],\"uniqueId\":\"com.ling.lingcloud.gateway.api.RemoteGatewayService@file:/D:/main/ling-cloud/sources/basics/api/gateway-api/target/classes/\"}','d288cb9fae9ac7cdd2633595634ec977','2023-11-22 14:18:45','2023-11-22 06:18:45',NULL,'192.168.177.1','U','dubbo',''),(162,196,'com.ling.lingcloud.account.api.RemoteAccountService:::provider:dubbo-account','DUBBO_GROUP','','{\"annotations\":[],\"canonicalName\":\"com.ling.lingcloud.account.api.RemoteAccountService\",\"codeSource\":\"file:/D:/main/ling-cloud/sources/basics/api/account-api/target/classes/\",\"methods\":[{\"annotations\":[],\"name\":\"loginByUsername\",\"parameterTypes\":[\"java.lang.String\",\"java.lang.String\"],\"parameters\":[],\"returnType\":\"java.lang.String\"}],\"parameters\":{\"anyhost\":\"true\",\"application\":\"dubbo-account\",\"side\":\"provider\",\"pid\":\"17176\",\"release\":\"3.2.6\",\"metadata-type\":\"local\",\"interface\":\"com.ling.lingcloud.account.api.RemoteAccountService\",\"dubbo\":\"2.0.2\",\"executor-management-mode\":\"isolation\",\"file-cache\":\"true\",\"methods\":\"loginByUsername\",\"logger\":\"slf4j\",\"deprecated\":\"false\",\"service-name-mapping\":\"true\",\"register-mode\":\"instance\",\"qos.enable\":\"false\",\"generic\":\"false\",\"bind.port\":\"20880\",\"bind.ip\":\"172.29.192.1\",\"prefer.serialization\":\"fastjson2,hessian2\",\"background\":\"false\",\"dynamic\":\"true\",\"validation\":\"jvalidationNew\",\"timestamp\":\"1700633500838\"},\"types\":[{\"enums\":[],\"items\":[],\"properties\":{},\"type\":\"java.lang.String\"}],\"uniqueId\":\"com.ling.lingcloud.account.api.RemoteAccountService@file:/D:/main/ling-cloud/sources/basics/api/account-api/target/classes/\"}','e08fdf10a273c8d56fb281132efb794a','2023-11-22 16:54:53','2023-11-22 08:54:53',NULL,'192.168.177.1','U','dubbo',''),(162,197,'com.ling.lingcloud.account.api.RemoteAccountService:::provider:dubbo-account','DUBBO_GROUP','','{\"annotations\":[],\"canonicalName\":\"com.ling.lingcloud.account.api.RemoteAccountService\",\"codeSource\":\"file:/D:/main/ling-cloud/sources/basics/api/account-api/target/classes/\",\"methods\":[{\"annotations\":[],\"name\":\"loginByUsername\",\"parameterTypes\":[\"java.lang.String\",\"java.lang.String\"],\"parameters\":[],\"returnType\":\"java.lang.String\"}],\"parameters\":{\"interface\":\"com.ling.lingcloud.account.api.RemoteAccountService\",\"side\":\"provider\",\"metadata-type\":\"local\",\"pid\":\"18408\",\"anyhost\":\"true\",\"release\":\"3.2.6\",\"application\":\"dubbo-account\",\"dubbo\":\"2.0.2\",\"executor-management-mode\":\"isolation\",\"file-cache\":\"true\",\"methods\":\"loginByUsername\",\"logger\":\"slf4j\",\"deprecated\":\"false\",\"service-name-mapping\":\"true\",\"register-mode\":\"instance\",\"qos.enable\":\"false\",\"generic\":\"false\",\"bind.port\":\"20880\",\"bind.ip\":\"172.29.192.1\",\"prefer.serialization\":\"fastjson2,hessian2\",\"background\":\"false\",\"dynamic\":\"true\",\"validation\":\"jvalidationNew\",\"timestamp\":\"1700643292816\"},\"types\":[{\"enums\":[],\"items\":[],\"properties\":{},\"type\":\"java.lang.String\"}],\"uniqueId\":\"com.ling.lingcloud.account.api.RemoteAccountService@file:/D:/main/ling-cloud/sources/basics/api/account-api/target/classes/\"}','046c82e8b2a332545864066735e8b5fd','2023-11-22 17:00:06','2023-11-22 09:00:07',NULL,'192.168.177.1','U','dubbo',''),(162,198,'com.ling.lingcloud.account.api.RemoteAccountService:::provider:dubbo-account','DUBBO_GROUP','','{\"annotations\":[],\"canonicalName\":\"com.ling.lingcloud.account.api.RemoteAccountService\",\"codeSource\":\"file:/D:/main/ling-cloud/sources/basics/api/account-api/target/classes/\",\"methods\":[{\"annotations\":[],\"name\":\"loginByUsername\",\"parameterTypes\":[\"java.lang.String\",\"java.lang.String\"],\"parameters\":[],\"returnType\":\"java.lang.String\"}],\"parameters\":{\"dubbo\":\"2.0.2\",\"metadata-type\":\"local\",\"side\":\"provider\",\"release\":\"3.2.6\",\"interface\":\"com.ling.lingcloud.account.api.RemoteAccountService\",\"application\":\"dubbo-account\",\"anyhost\":\"true\",\"pid\":\"5456\",\"executor-management-mode\":\"isolation\",\"file-cache\":\"true\",\"methods\":\"loginByUsername\",\"logger\":\"slf4j\",\"deprecated\":\"false\",\"service-name-mapping\":\"true\",\"register-mode\":\"instance\",\"qos.enable\":\"false\",\"generic\":\"false\",\"bind.port\":\"20880\",\"bind.ip\":\"172.29.192.1\",\"prefer.serialization\":\"fastjson2,hessian2\",\"background\":\"false\",\"dynamic\":\"true\",\"validation\":\"jvalidationNew\",\"timestamp\":\"1700643606351\"},\"types\":[{\"enums\":[],\"items\":[],\"properties\":{},\"type\":\"java.lang.String\"}],\"uniqueId\":\"com.ling.lingcloud.account.api.RemoteAccountService@file:/D:/main/ling-cloud/sources/basics/api/account-api/target/classes/\"}','1424ff88361ef84169c80efaeb8c64c2','2023-11-22 17:13:13','2023-11-22 09:13:14',NULL,'192.168.177.1','U','dubbo',''),(162,199,'com.ling.lingcloud.account.api.RemoteAccountService:::provider:dubbo-account','DUBBO_GROUP','','{\"annotations\":[],\"canonicalName\":\"com.ling.lingcloud.account.api.RemoteAccountService\",\"codeSource\":\"file:/D:/main/ling-cloud/sources/basics/api/account-api/target/classes/\",\"methods\":[{\"annotations\":[],\"name\":\"loginByUsername\",\"parameterTypes\":[\"java.lang.String\",\"java.lang.String\"],\"parameters\":[],\"returnType\":\"java.lang.String\"}],\"parameters\":{\"side\":\"provider\",\"pid\":\"18708\",\"interface\":\"com.ling.lingcloud.account.api.RemoteAccountService\",\"dubbo\":\"2.0.2\",\"application\":\"dubbo-account\",\"anyhost\":\"true\",\"metadata-type\":\"local\",\"release\":\"3.2.6\",\"executor-management-mode\":\"isolation\",\"file-cache\":\"true\",\"methods\":\"loginByUsername\",\"logger\":\"slf4j\",\"deprecated\":\"false\",\"service-name-mapping\":\"true\",\"register-mode\":\"instance\",\"qos.enable\":\"false\",\"generic\":\"false\",\"bind.port\":\"20880\",\"bind.ip\":\"172.29.192.1\",\"prefer.serialization\":\"fastjson2,hessian2\",\"background\":\"false\",\"dynamic\":\"true\",\"validation\":\"jvalidationNew\",\"timestamp\":\"1700644393036\"},\"types\":[{\"enums\":[],\"items\":[],\"properties\":{},\"type\":\"java.lang.String\"}],\"uniqueId\":\"com.ling.lingcloud.account.api.RemoteAccountService@file:/D:/main/ling-cloud/sources/basics/api/account-api/target/classes/\"}','3771680a9afeedf4aa24f33ccc84faec','2023-11-22 17:16:48','2023-11-22 09:16:48',NULL,'192.168.177.1','U','dubbo',''),(162,200,'com.ling.lingcloud.account.api.RemoteAccountService:::provider:dubbo-account','DUBBO_GROUP','','{\"annotations\":[],\"canonicalName\":\"com.ling.lingcloud.account.api.RemoteAccountService\",\"codeSource\":\"file:/D:/main/ling-cloud/sources/basics/api/account-api/target/classes/\",\"methods\":[{\"annotations\":[],\"name\":\"loginByUsername\",\"parameterTypes\":[\"java.lang.String\",\"java.lang.String\"],\"parameters\":[],\"returnType\":\"java.lang.String\"}],\"parameters\":{\"release\":\"3.2.6\",\"application\":\"dubbo-account\",\"pid\":\"28188\",\"anyhost\":\"true\",\"interface\":\"com.ling.lingcloud.account.api.RemoteAccountService\",\"dubbo\":\"2.0.2\",\"side\":\"provider\",\"metadata-type\":\"local\",\"executor-management-mode\":\"isolation\",\"file-cache\":\"true\",\"methods\":\"loginByUsername\",\"logger\":\"slf4j\",\"deprecated\":\"false\",\"service-name-mapping\":\"true\",\"register-mode\":\"instance\",\"qos.enable\":\"false\",\"generic\":\"false\",\"bind.port\":\"20880\",\"bind.ip\":\"172.29.192.1\",\"prefer.serialization\":\"fastjson2,hessian2\",\"background\":\"false\",\"dynamic\":\"true\",\"validation\":\"jvalidationNew\",\"timestamp\":\"1700644607762\"},\"types\":[{\"enums\":[],\"items\":[],\"properties\":{},\"type\":\"java.lang.String\"}],\"uniqueId\":\"com.ling.lingcloud.account.api.RemoteAccountService@file:/D:/main/ling-cloud/sources/basics/api/account-api/target/classes/\"}','9bebcce9764f1f2dbefa35e070442b12','2023-11-22 17:36:09','2023-11-22 09:36:10',NULL,'192.168.177.1','U','dubbo',''),(162,201,'com.ling.lingcloud.account.api.RemoteAccountService:::provider:dubbo-account','DUBBO_GROUP','','{\"annotations\":[],\"canonicalName\":\"com.ling.lingcloud.account.api.RemoteAccountService\",\"codeSource\":\"file:/D:/main/ling-cloud/sources/basics/api/account-api/target/classes/\",\"methods\":[{\"annotations\":[],\"name\":\"loginByUsername\",\"parameterTypes\":[\"java.lang.String\",\"java.lang.String\"],\"parameters\":[],\"returnType\":\"java.lang.String\"}],\"parameters\":{\"interface\":\"com.ling.lingcloud.account.api.RemoteAccountService\",\"side\":\"provider\",\"metadata-type\":\"local\",\"pid\":\"12360\",\"anyhost\":\"true\",\"application\":\"dubbo-account\",\"release\":\"3.2.6\",\"dubbo\":\"2.0.2\",\"executor-management-mode\":\"isolation\",\"file-cache\":\"true\",\"methods\":\"loginByUsername\",\"logger\":\"slf4j\",\"deprecated\":\"false\",\"service-name-mapping\":\"true\",\"register-mode\":\"instance\",\"qos.enable\":\"false\",\"generic\":\"false\",\"bind.port\":\"20880\",\"bind.ip\":\"172.29.192.1\",\"prefer.serialization\":\"fastjson2,hessian2\",\"background\":\"false\",\"dynamic\":\"true\",\"validation\":\"jvalidationNew\",\"timestamp\":\"1700645769209\"},\"types\":[{\"enums\":[],\"items\":[],\"properties\":{},\"type\":\"java.lang.String\"}],\"uniqueId\":\"com.ling.lingcloud.account.api.RemoteAccountService@file:/D:/main/ling-cloud/sources/basics/api/account-api/target/classes/\"}','4ed90683a32a5c8ee7955ccbda6863aa','2023-11-22 17:52:42','2023-11-22 09:52:42',NULL,'192.168.177.1','U','dubbo',''),(162,202,'com.ling.lingcloud.account.api.RemoteAccountService:::provider:dubbo-account','DUBBO_GROUP','','{\"annotations\":[],\"canonicalName\":\"com.ling.lingcloud.account.api.RemoteAccountService\",\"codeSource\":\"file:/D:/main/ling-cloud/sources/basics/api/account-api/target/classes/\",\"methods\":[{\"annotations\":[],\"name\":\"loginByUsername\",\"parameterTypes\":[\"java.lang.String\",\"java.lang.String\"],\"parameters\":[],\"returnType\":\"java.lang.String\"}],\"parameters\":{\"anyhost\":\"true\",\"side\":\"provider\",\"application\":\"dubbo-account\",\"pid\":\"34800\",\"release\":\"3.2.6\",\"metadata-type\":\"local\",\"interface\":\"com.ling.lingcloud.account.api.RemoteAccountService\",\"dubbo\":\"2.0.2\",\"executor-management-mode\":\"isolation\",\"file-cache\":\"true\",\"methods\":\"loginByUsername\",\"logger\":\"slf4j\",\"deprecated\":\"false\",\"service-name-mapping\":\"true\",\"register-mode\":\"instance\",\"qos.enable\":\"false\",\"generic\":\"false\",\"bind.port\":\"20880\",\"bind.ip\":\"172.29.192.1\",\"prefer.serialization\":\"fastjson2,hessian2\",\"background\":\"false\",\"dynamic\":\"true\",\"validation\":\"jvalidationNew\",\"timestamp\":\"1700646761643\"},\"types\":[{\"enums\":[],\"items\":[],\"properties\":{},\"type\":\"java.lang.String\"}],\"uniqueId\":\"com.ling.lingcloud.account.api.RemoteAccountService@file:/D:/main/ling-cloud/sources/basics/api/account-api/target/classes/\"}','3738f04902155c4a7ae5eb91e7d87608','2023-11-22 17:54:51','2023-11-22 09:54:51',NULL,'192.168.177.1','U','dubbo','');
/*!40000 ALTER TABLE `his_config_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `permissions`
--

DROP TABLE IF EXISTS `permissions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `permissions` (
  `role` varchar(50) NOT NULL COMMENT 'role',
  `resource` varchar(255) NOT NULL COMMENT 'resource',
  `action` varchar(8) NOT NULL COMMENT 'action',
  UNIQUE KEY `uk_role_permission` (`role`,`resource`,`action`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `permissions`
--

LOCK TABLES `permissions` WRITE;
/*!40000 ALTER TABLE `permissions` DISABLE KEYS */;
/*!40000 ALTER TABLE `permissions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `roles` (
  `username` varchar(50) NOT NULL COMMENT 'username',
  `role` varchar(50) NOT NULL COMMENT 'role',
  UNIQUE KEY `idx_user_role` (`username`,`role`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES ('nacos','ROLE_ADMIN');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tenant_capacity`
--

DROP TABLE IF EXISTS `tenant_capacity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tenant_capacity` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `tenant_id` varchar(128) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL DEFAULT '' COMMENT 'Tenant ID',
  `quota` int unsigned NOT NULL DEFAULT '0' COMMENT '配额，0表示使用默认值',
  `usage` int unsigned NOT NULL DEFAULT '0' COMMENT '使用量',
  `max_size` int unsigned NOT NULL DEFAULT '0' COMMENT '单个配置大小上限，单位为字节，0表示使用默认值',
  `max_aggr_count` int unsigned NOT NULL DEFAULT '0' COMMENT '聚合子配置最大个数',
  `max_aggr_size` int unsigned NOT NULL DEFAULT '0' COMMENT '单个聚合数据的子配置大小上限，单位为字节，0表示使用默认值',
  `max_history_count` int unsigned NOT NULL DEFAULT '0' COMMENT '最大变更历史数量',
  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_tenant_id` (`tenant_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin COMMENT='租户容量信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tenant_capacity`
--

LOCK TABLES `tenant_capacity` WRITE;
/*!40000 ALTER TABLE `tenant_capacity` DISABLE KEYS */;
/*!40000 ALTER TABLE `tenant_capacity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tenant_info`
--

DROP TABLE IF EXISTS `tenant_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tenant_info` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `kp` varchar(128) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL COMMENT 'kp',
  `tenant_id` varchar(128) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT '' COMMENT 'tenant_id',
  `tenant_name` varchar(128) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT '' COMMENT 'tenant_name',
  `tenant_desc` varchar(256) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL COMMENT 'tenant_desc',
  `create_source` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL COMMENT 'create_source',
  `gmt_create` bigint NOT NULL COMMENT '创建时间',
  `gmt_modified` bigint NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_tenant_info_kptenantid` (`kp`,`tenant_id`),
  KEY `idx_tenant_id` (`tenant_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin COMMENT='tenant_info';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tenant_info`
--

LOCK TABLES `tenant_info` WRITE;
/*!40000 ALTER TABLE `tenant_info` DISABLE KEYS */;
INSERT INTO `tenant_info` VALUES (1,'1','e3918c99-f219-4d44-9845-1766f7d79dac','dev','开发环境','nacos',1688654147063,1688654147063),(2,'1','55c8bb3e-7205-46e8-99cf-11ce3ff2ed49','prod','生产环境','nacos',1688654174728,1688654174728),(3,'1','dubbo','dubbo','dubbo 的空间','nacos',1692509768724,1692509768724);
/*!40000 ALTER TABLE `tenant_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `username` varchar(50) NOT NULL COMMENT 'username',
  `password` varchar(500) NOT NULL COMMENT 'password',
  `enabled` tinyint(1) NOT NULL COMMENT 'enabled',
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES ('nacos','$2a$10$DL7tgC4ZJ3wqdgvbCjaRYuiCFuArqBFQ7OEk4H4OoNXb1NNct5oZy',1);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-11-23  9:54:51

# ling-mall

[![License](https://img.shields.io/badge/License-MIT-blue.svg)](https://github.com/zhongshuyi/ling-mall/LICENSE)
[![使用 IntelliJ IDEA 开发维护](https://img.shields.io/badge/IntelliJ%20IDEA-提供支持-blue.svg)](https://www.jetbrains.com)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.1.3-blue.svg)](https://spring.io/projects/spring-boot)
[![JDK-11](https://img.shields.io/badge/JDK-21-green.svg)](https://www.java.com/zh-CN/)

目标是 JDK21 + SpringBoot3 + SpringCloud Alibaba 实现一个商城系统

目前实现了：

- [x] 使用 Springboot3、JDK21、SpringCloud Alibaba 创建项目
- [x] 使用 Nacos 作为服务注册中心与配置中心
- [x] 整合 Dubbo 作为RPC远程服务调用方案，使用 Nacos 作为 Dubbo 的注册中心
- [x] 使用 Gateway 实现微服务网关
- [x] 使用 Redisson 作为 Redis 客户端
- [x] 使用 Sa-token 作为安全框架
- [x] 整合 Mybatis-Plus 作为持久层 Mybatis 的增强
- [x] 多模块国际化
- [x] 整合 SpringDoc 实现 通过 JavaDoc 生成 OpenAPI 的 JSON 格式的文档
- [x] 将网关路由存储到数据库以及 Redis 缓存，实现动态配置网关路由

近期计划：

## 内容列表

- [ling-mall](#ling-mall)
    - [内容列表](#内容列表)
    - [背景](#背景)
    - [安装](#安装)
    - [用法](#用法)
    - [附加内容](#附加内容)
    - [API 文档](#api-文档)
    - [主要维护人员](#主要维护人员)
    - [参与贡献方式](#参与贡献方式)
    - [许可证](#许可证)

## 背景

一直想做一个商城系统，因为商城涉及到的东西太多了，很锻炼人，所以有了这个项目，参考 [RuoYi-Cloud-Plus](https://gitee.com/dromara/RuoYi-Cloud-Plus)
与 [SkrShop 电商设计手册](http://skrshop.tech/#/)

## 安装

使用前需要准备环境：

- [JDK 21](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
- [MySQL 8.0 及以上](https://www.mysql.com)
- [Redis](https://redis.io)
- [Nacos 2.x](https://nacos.io/zh-cn/)
- [Git](https://git-scm.com)

克隆仓库

```bash
git clone https://github.com/zhongshuyi/ling-mall
```

创建数据库 `ling-mall`，导入 [SQL 文件](/sql/mysql.sql)（/sql/mysql.sql）

修改 config 文件夹中的 Nacos 配置，将数据库与 Redis 地址及账号密码修改为自己的

导入 config 中的配置至 Nacos

## 用法

在 `ling-modules` 中新建你自己的模块，选择 `ling-common` 中你需要的组件进行引入

## 附加内容

## API 文档

待整合

## 主要维护人员

[@钟舒艺](https://github.com/zhongshuyi)

## 参与贡献方式

详细请阅读文档 [参与贡献](https://github.com/zhongshuyi/developer-knowledge-base/blob/main/%E5%85%B6%E4%BB%96/%E5%8F%82%E4%B8%8E%E8%B4%A1%E7%8C%AE.md)
与 [协作开发流程](https://github.com/zhongshuyi/developer-knowledge-base/blob/main/%E5%B7%A5%E5%85%B7/Git/Git%20%E5%8D%8F%E4%BD%9C%E5%BC%80%E5%8F%91%E6%B5%81%E7%A8%8B%E4%B8%8E%E8%A7%84%E8%8C%83.md)
并按其中的规范与流程进行贡献

提问请到 [Issues](https://github.com/zhongshuyi/ling-mall/issues)

接受
PR，具体请看 [协作开发流程](https://github.com/zhongshuyi/developer-knowledge-base/blob/main/%E5%B7%A5%E5%85%B7/Git/Git%20%E5%8D%8F%E4%BD%9C%E5%BC%80%E5%8F%91%E6%B5%81%E7%A8%8B%E4%B8%8E%E8%A7%84%E8%8C%83.md)

## 许可证

[MIT](LICENSE) © 2022 [zhongshuyi](https://github.com/zhongshuyi)

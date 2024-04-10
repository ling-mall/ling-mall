package com.ling.lingcloud.common.redis.config.properties;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.redisson.config.TransportMode;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * RedissonConfig 配置信息.
 *
 * @author 钟舒艺
 **/
@Data
@ConfigurationProperties(prefix = "redisson")
public class RedissonConfigProperties {

    /**
     * 单机服务配置.
     */
    private SingleServerConfig singleServerConfig;

    /**
     * 线程池数量(默认 2).
     */
    private Integer threads = 2;

    /**
     * Netty线程池数量.
     */
    private Integer nettyThreads = 2;

    /**
     * 传输模式 (默认值：TransportMode.NIO).
     */
    private String transportMode = TransportMode.NIO.name();


    /**
     * 单节点模式.
     */
    @Data
    @NoArgsConstructor
    public static class SingleServerConfig {

        /**
         * 客户端名称.
         */
        private String clientName;

        /**
         * 连接空闲超时，单位：毫秒.
         */
        private Integer idleConnectionTimeout = 10000;

        /**
         * 连接超时，单位：毫秒.
         */
        private Integer connectTimeout = 10000;

        /**
         * 命令等待超时，单位：毫秒.
         */
        private Integer timeout = 3000;

        /**
         * 命令失败重试次数.
         */
        private Integer retryAttempts = 3;

        /**
         * 命令重试发送时间间隔，单位：毫秒.
         */
        private Integer retryInterval = 1500;

        /**
         * 单个连接最大订阅数量.
         */
        private Integer subscriptionsPerConnection = 5;

        /**
         * 发布和订阅连接的最小空闲连接数.
         */
        private Integer subscriptionConnectionMinimumIdleSize = 1;

        /**
         * 发布和订阅连接池大小.
         */
        private Integer subscriptionConnectionPoolSize = 50;

        /**
         * 最小空闲连接数.
         */
        private Integer connectionMinimumIdleSize = 32;

        /**
         * 连接池大小.
         */
        private Integer connectionPoolSize = 64;

        /**
         * DNS监测时间间隔，单位：毫秒.
         */
        private Integer dnsMonitoringInterval = 5000;
    }
}

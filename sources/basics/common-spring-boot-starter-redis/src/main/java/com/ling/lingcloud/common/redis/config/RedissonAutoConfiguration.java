package com.ling.lingcloud.common.redis.config;

import java.util.HashMap;
import java.util.Map;


import com.ling.lingcloud.common.redis.config.properties.RedissonConfigProperties;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RedissonClient;
import org.redisson.codec.JsonJacksonCodec;
import org.redisson.spring.cache.CacheConfig;
import org.redisson.spring.cache.RedissonSpringCacheManager;
import org.redisson.spring.starter.RedissonAutoConfigurationCustomizer;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

/**
 * redisson配置.
 * 配置文档: <a href="https://github.com/redisson/redisson/wiki/2.-%E9%85%8D%E7%BD%AE%E6%96%B9%E6%B3%95">...</a>.
 *
 * @author 钟舒艺
 * @version 1.0
 **/
@Slf4j
@EnableCaching
@AutoConfiguration
@RequiredArgsConstructor
@EnableConfigurationProperties(RedissonConfigProperties.class)
public class RedissonAutoConfiguration {

    /**
     * 从 Nacos 读取的配置.
     */
    private final RedissonConfigProperties redissonConfigProperties;


    /**
     * 初始化 Redisson.
     *
     * @return RedissonAutoConfigurationCustomizer
     */
    @Bean
    public RedissonAutoConfigurationCustomizer redissonCustomizer() {
        return config -> {
            config.setThreads(redissonConfigProperties.getThreads())
                    .setNettyThreads(redissonConfigProperties.getNettyThreads());
            RedissonConfigProperties.SingleServerConfig
                    singleServerConfig = redissonConfigProperties.getSingleServerConfig();
            // 使用单机模式
            config.useSingleServer()
                    .setTimeout(singleServerConfig.getTimeout())
                    .setClientName(singleServerConfig.getClientName())
                    .setIdleConnectionTimeout(singleServerConfig.getIdleConnectionTimeout())
                    .setSubscriptionConnectionPoolSize(singleServerConfig.getSubscriptionConnectionPoolSize())
                    .setConnectionMinimumIdleSize(singleServerConfig.getConnectionMinimumIdleSize())
                    .setConnectionPoolSize(singleServerConfig.getConnectionPoolSize())
                    .setSubscriptionConnectionPoolSize(singleServerConfig.getSubscriptionConnectionPoolSize())
                    .setSubscriptionConnectionMinimumIdleSize(
                            singleServerConfig.getSubscriptionConnectionMinimumIdleSize())
                    .setDnsMonitoringInterval(singleServerConfig.getDnsMonitoringInterval());
            log.info("初始化 redisson 配置");
        };
    }

    /**
     * 整合spring-cache.
     *
     * @param redissonClient redisson
     * @return 缓存管理器
     */
    @Bean
    public CacheManager cacheManager(final RedissonClient redissonClient) {
        final Map<String, CacheConfig> config = new HashMap<>(16);
        return new RedissonSpringCacheManager(redissonClient, config, JsonJacksonCodec.INSTANCE);
    }
}

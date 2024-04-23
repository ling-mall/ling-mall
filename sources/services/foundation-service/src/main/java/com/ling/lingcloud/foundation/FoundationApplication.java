package com.ling.lingcloud.foundation;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 基础服务.
 * Class created on 2024/4/10 by 钟舒艺
 *
 * @author 钟舒艺
 */
@EnableDubbo
@SpringBootApplication
@EnableDiscoveryClient
public class FoundationApplication {

    public static void main(String[] args) {
        SpringApplication.run(FoundationApplication.class, args);
    }

}

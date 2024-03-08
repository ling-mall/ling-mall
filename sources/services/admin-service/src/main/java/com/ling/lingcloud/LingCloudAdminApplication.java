package com.ling.lingcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 后台服务.
 * Class created on 2024/2/28 by 钟舒艺
 *
 * @author 钟舒艺
 */
@SpringBootApplication
@EnableDiscoveryClient
public class LingCloudAdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(LingCloudAdminApplication.class, args);
    }
}

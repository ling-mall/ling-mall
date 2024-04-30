package com.ling.lingcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


/**
 * 演示应用
 *
 * @author 钟舒艺
 */
@SpringBootApplication
@EnableDiscoveryClient
public class LingCloudDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(LingCloudDemoApplication.class, args);
    }
}

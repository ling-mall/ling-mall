package com.ling.lingcloud;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


/**
 * 凌云演示应用
 *
 * @author 钟舒艺
 * @date 2023-09-30
 */
@SpringBootApplication
@EnableDiscoveryClient
public class LingCloudDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(LingCloudDemoApplication.class, args);
    }
}

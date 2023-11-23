package com.ling.lingcloud.account;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 简短描述啦.
 * 详细说说
 * Class created on 2023/7/7 by 钟舒艺
 *
 * @author 钟舒艺
 */
@EnableDubbo
@SpringBootApplication
@EnableDiscoveryClient
public class AccountApplication {


    public static void main(String[] args) {
        SpringApplication.run(AccountApplication.class, args);
    }


}

package com.ling.lingcloud.gateway.runner;

import com.ling.lingcloud.gateway.api.RemoteGatewayService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

/**
 * Gateway 网关 启动执行.
 * Class created on 2023/10/18 by 钟舒艺
 *
 * @author 钟舒艺
 */
@Slf4j
@Configuration
@RequiredArgsConstructor
public class GatewayRunner implements CommandLineRunner {

    private final RemoteGatewayService gatewayService;

    @Override
    public void run(String... args) {
        log.info("GatewayRunner-加载路由");
        // 从数据库加载路由
        gatewayService.loadRouter();
    }
}

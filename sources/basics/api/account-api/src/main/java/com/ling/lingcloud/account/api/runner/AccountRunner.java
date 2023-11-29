package com.ling.lingcloud.account.api.runner;

import com.ling.lingcloud.account.api.enums.UserErrorCodeEnum;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

/**
 * 启动前运行，此处主要用于加载模块的资源文件.
 *
 * @author 钟舒艺
 */
@Slf4j
@Configuration
@RequiredArgsConstructor
public class AccountRunner implements CommandLineRunner {

    private final ResourceBundleMessageSource messageSource;

    @Override
    public void run(String... args) {
        log.info("加载 account 资源文件");
        messageSource.addBasenames("i18n/account/messages");
    }
}

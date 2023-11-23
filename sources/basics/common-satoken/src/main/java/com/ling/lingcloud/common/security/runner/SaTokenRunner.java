package com.ling.lingcloud.common.security.runner;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.support.ResourceBundleMessageSource;

/**
 * Sa Token模块初始化时执行.
 * 加载国际化资源文件
 * Class created on 2023/8/23 by 钟舒艺
 *
 * @author 钟舒艺
 */
@Slf4j
@RequiredArgsConstructor
public class SaTokenRunner implements CommandLineRunner {

    private final ResourceBundleMessageSource messageSource;

    @Override
    public void run(String... args) {
        log.info("加载 satoken 资源文件");
        messageSource.addBasenames("i18n/satoken/messages");
    }
}

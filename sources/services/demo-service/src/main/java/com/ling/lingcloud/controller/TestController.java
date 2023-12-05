package com.ling.lingcloud.controller;


import com.ling.lingcloud.common.i18n.utils.MessageUtils;
import com.ling.lingcloud.entity.Demo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

/**
 * 测试.
 * 详细说说
 * Class created on 2023/9/30 by 钟舒艺
 *
 * @author 钟舒艺
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/test")
public class TestController {


    /**
     * 测试
     *
     * @return {@link String}
     */
    @GetMapping("/test")
    public String test(@Validated Demo demo) throws IOException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        Enumeration<URL> resources = classLoader.getResources("META-INF/services/javax.validation.spi.ValidationProvider");
        if (resources.hasMoreElements()) {
            log.info("存在 resource 文件");
        } else {
            // 不存在 resource 文件
            log.info("不存在 resource 文件");
        }
        return MessageUtils.message("validation.id");
    }

}

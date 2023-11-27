package com.ling.lingcloud.common.i18n.config;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.context.MessageSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;

/**
 * i18n 配置文件.
 * Class created on 2023/11/27 by 钟舒艺
 *
 * @author 钟舒艺
 */
@AutoConfiguration(before = MessageSourceAutoConfiguration.class )
public class I18nAutoConfiguration {

    @Bean
    public ResourceBundleMessageSource messageSource() {
        ResourceBundleMessageSource source = new ResourceBundleMessageSource();
        source.setBasename("i18n/messages");
        return source;
    }
}

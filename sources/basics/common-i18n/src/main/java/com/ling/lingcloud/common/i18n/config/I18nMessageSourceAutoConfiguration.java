package com.ling.lingcloud.common.i18n.config;

import com.ling.lingcloud.common.i18n.dynamic.DynamicMessageSource;
import com.ling.lingcloud.common.i18n.dynamic.I18nMessageProvider;
import com.ling.lingcloud.common.i18n.dynamic.MessageSourceHierarchicalChanger;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.context.MessageSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.AbstractApplicationContext;

/**
 * @author hccake
 */
@AutoConfiguration(after = {CustomMessageSourceAutoConfiguration.class, MessageSourceAutoConfiguration.class})
public class I18nMessageSourceAutoConfiguration {

    /**
     * 动态消息源，当容器中存在 I18nMessageProvider 接口的实现类时，且没有 messageSource 时加载
     *
     * @param i18nMessageProvider i18nMessageProvider
     * @return DynamicMessageSource
     */
    @ConditionalOnBean(I18nMessageProvider.class)
    @ConditionalOnMissingBean(name = AbstractApplicationContext.MESSAGE_SOURCE_BEAN_NAME)
    @Bean(name = AbstractApplicationContext.MESSAGE_SOURCE_BEAN_NAME)
    public DynamicMessageSource messageSource(I18nMessageProvider i18nMessageProvider) {
        return new DynamicMessageSource(i18nMessageProvider);
    }

    /**
     * 动态消息源，在容器中存在 messageSource 时，且类型为 I18nMessageProvider 时加载
     *
     * @param i18nMessageProvider i18nMessageProvider
     * @return DynamicMessageSource
     */
    @ConditionalOnBean(name = AbstractApplicationContext.MESSAGE_SOURCE_BEAN_NAME, value = I18nMessageProvider.class)
    @Bean(name = DynamicMessageSource.DYNAMIC_MESSAGE_SOURCE_BEAN_NAME)
    public DynamicMessageSource dynamicMessageSource(I18nMessageProvider i18nMessageProvider) {
        return new DynamicMessageSource(i18nMessageProvider);
    }

    /**
     * 用于修改 MessageSource 的层级关系，保证 DynamicMessageSource 在父级位置
     */
    @ConditionalOnBean(name = {AbstractApplicationContext.MESSAGE_SOURCE_BEAN_NAME,
            DynamicMessageSource.DYNAMIC_MESSAGE_SOURCE_BEAN_NAME})
    @Bean
    public MessageSourceHierarchicalChanger messageSourceHierarchicalChanger() {
        return new MessageSourceHierarchicalChanger();
    }

}

package com.ling.lingcloud.common.i18n.config;

import com.ling.lingcloud.common.i18n.WildcardReloadableResourceBundleMessageSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.autoconfigure.condition.*;
import org.springframework.boot.autoconfigure.context.MessageSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.context.MessageSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.Ordered;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.util.ConcurrentReferenceHashMap;
import org.springframework.util.StringUtils;

import java.time.Duration;

/**
 * i18n 配置文件.
 * Class created on 2023/11/27 by 钟舒艺
 *
 * @author 钟舒艺
 */
@Slf4j
@AutoConfiguration(before = MessageSourceAutoConfiguration.class)
@ConditionalOnMissingBean(name = AbstractApplicationContext.MESSAGE_SOURCE_BEAN_NAME, search = SearchStrategy.CURRENT)
@AutoConfigureOrder(Ordered.HIGHEST_PRECEDENCE)
@Conditional(CustomMessageSourceAutoConfiguration.ResourceBundleCondition.class)
@EnableConfigurationProperties
public class CustomMessageSourceAutoConfiguration {

    private static final Resource[] NO_RESOURCES = {};

    @Bean
    @ConfigurationProperties(prefix = "spring.messages")
    @ConditionalOnMissingBean
    public MessageSourceProperties messageSourceProperties() {
        return new MessageSourceProperties();
    }

    @Bean
    public MessageSource messageSource(MessageSourceProperties properties) {
        log.error("messageSource");
        WildcardReloadableResourceBundleMessageSource messageSource = new WildcardReloadableResourceBundleMessageSource();
        if (StringUtils.hasText(properties.getBasename())) {
            messageSource.setBasenames(StringUtils
                    .commaDelimitedListToStringArray(StringUtils.trimAllWhitespace(properties.getBasename())));
        }
        if (properties.getEncoding() != null) {
            messageSource.setDefaultEncoding(properties.getEncoding().name());
        }
        messageSource.setFallbackToSystemLocale(properties.isFallbackToSystemLocale());
        Duration cacheDuration = properties.getCacheDuration();
        if (cacheDuration != null) {
            messageSource.setCacheMillis(cacheDuration.toMillis());
        }
        messageSource.setAlwaysUseMessageFormat(properties.isAlwaysUseMessageFormat());
        messageSource.setUseCodeAsDefaultMessage(properties.isUseCodeAsDefaultMessage());
        return messageSource;
    }

    protected static class ResourceBundleCondition extends SpringBootCondition {

        private static final ConcurrentReferenceHashMap<String, ConditionOutcome> cache = new ConcurrentReferenceHashMap<>();

        @Override
        public ConditionOutcome getMatchOutcome(ConditionContext context, AnnotatedTypeMetadata metadata) {

            String basename = context.getEnvironment().getProperty("spring.messages.basename", "messages");
            log.error("basename: {}", basename);
            ConditionOutcome outcome = cache.get(basename);
            if (outcome == null) {
                outcome = getMatchOutcomeForBasename(context, basename);
                cache.put(basename, outcome);
            }
            return outcome;
        }

        private ConditionOutcome getMatchOutcomeForBasename(ConditionContext context, String basename) {
            log.error("getMatchOutcomeForBasename");
            ConditionMessage.Builder message = ConditionMessage.forCondition("ResourceBundle");
            for (String name : StringUtils.commaDelimitedListToStringArray(StringUtils.trimAllWhitespace(basename))) {
                for (Resource resource : getResources(context.getClassLoader(), name)) {
                    if (resource.exists()) {
                        return ConditionOutcome.match(message.found("bundle").items(resource));
                    }
                }
            }
            return ConditionOutcome.noMatch(message.didNotFind("bundle with basename " + basename).atAll());
        }

        private Resource[] getResources(ClassLoader classLoader, String name) {
            log.error("getResources");
            String target = name.replace('.', '/');
            try {
                return new PathMatchingResourcePatternResolver(classLoader)
                        .getResources("classpath*:" + target + ".properties");
            }
            catch (Exception ex) {
                return NO_RESOURCES;
            }
        }

    }

}

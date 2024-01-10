/*
 * Copyright 2023 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.ling.lingcloud.common.i18n.config;

import com.ling.lingcloud.common.validation.EmptyCurlyToDefaultMessageInterpolator;
import jakarta.validation.MessageInterpolator;
import jakarta.validation.Validator;
import jakarta.validation.executable.ExecutableValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnResource;
import org.springframework.boot.autoconfigure.validation.ValidationAutoConfiguration;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Role;
import org.springframework.core.Ordered;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.validation.beanvalidation.MessageSourceResourceBundleLocator;


/**
 * 支持国际化的校验配置，order 为最高优先级，用于覆盖 starter-web 中的配置
 *
 * @author hccake
 */
@Slf4j
@AutoConfigureOrder(Ordered.HIGHEST_PRECEDENCE)
@AutoConfiguration(before = ValidationAutoConfiguration.class, after = I18nMessageSourceAutoConfiguration.class)
@ConditionalOnClass(ExecutableValidator.class)
@ConditionalOnResource(resources = "classpath:META-INF/services/jakarta.validation.spi.ValidationProvider")
public class I18nValidationConfiguration {

	@Bean
	@ConditionalOnBean(MessageSource.class)
	@ConditionalOnMissingBean({ Validator.class, MessageInterpolator.class })
	public EmptyCurlyToDefaultMessageInterpolator messageInterpolator(MessageSource messageSource) {
		log.error("EmptyCurlyToDefaultMessageInterpolator");
		return new EmptyCurlyToDefaultMessageInterpolator(new MessageSourceResourceBundleLocator(messageSource));
	}

	@Bean
	@Role(BeanDefinition.ROLE_INFRASTRUCTURE)
	@ConditionalOnMissingBean(Validator.class)
	@ConditionalOnBean(MessageInterpolator.class)
	public static LocalValidatorFactoryBean defaultValidator(MessageInterpolator messageInterpolator) {
		log.error("LocalValidatorFactoryBean");
		LocalValidatorFactoryBean factoryBean = new LocalValidatorFactoryBean();
		factoryBean.setMessageInterpolator(messageInterpolator);
		return factoryBean;
	}

}

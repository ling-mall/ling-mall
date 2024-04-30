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
package com.ling.lingcloud.common.datascope.test.datapermission;

import com.ling.lingcloud.common.datascope.interceptor.DataPermissionAnnotationAdvisor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author hccake
 */
@EnableAspectJAutoProxy
@Configuration(proxyBeanMethods = false)
public class DataPermissionTestConfiguration {

    @Bean
    public TestServiceImpl testService() {
        return new TestServiceImpl();
    }

    /**
     * 数据权限注解 Advisor，用于处理数据权限的链式调用关系
     *
     * @return DataPermissionAnnotationAdvisor
     */
    @Bean
    @ConditionalOnMissingBean(DataPermissionAnnotationAdvisor.class)
    public DataPermissionAnnotationAdvisor dataPermissionAnnotationAdvisor() {
        return new DataPermissionAnnotationAdvisor();
    }

}

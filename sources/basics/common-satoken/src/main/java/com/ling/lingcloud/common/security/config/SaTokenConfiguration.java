package com.ling.lingcloud.common.security.config;


import com.ling.lingcloud.common.security.service.SecurityService;
import com.ling.lingcloud.common.security.service.SecurityServiceImpl;

import cn.dev33.satoken.interceptor.SaInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Sa token 配置类.
 * Class created on 2023/7/9 by 钟舒艺
 *
 * @author 钟舒艺
 */
@AutoConfiguration
@RequiredArgsConstructor
public class SaTokenConfiguration implements WebMvcConfigurer {


    // 注册 Sa-Token 拦截器，打开注解式鉴权功能
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 注册 Sa-Token 拦截器，打开注解式鉴权功能
        registry.addInterceptor(new SaInterceptor()).addPathPatterns("/**");
    }


    @Bean
    public SecurityService getSecurityService() {
        return new SecurityServiceImpl();
    }

}

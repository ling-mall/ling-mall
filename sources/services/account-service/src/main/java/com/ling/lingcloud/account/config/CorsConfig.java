package com.ling.lingcloud.account.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * 跨域配置.
 *
 * @author 钟舒艺
 **/
@Slf4j
@Configuration
public class CorsConfig {


    /**
     * 开启跨域访问拦截器.
     *
     * @return 跨域拦截器
     */
    @Bean
    public CorsFilter corsFilter() {
        log.info("开启跨域访问拦截器");
        //创建CorsConfiguration对象后添加配置
        final CorsConfiguration corsConfiguration = new CorsConfiguration();
        //设置放行哪些原始域
        corsConfiguration.addAllowedOrigin("*");
        //放行哪些原始请求头部信息
        corsConfiguration.addAllowedHeader("*");
        //放行哪些请求方式
        corsConfiguration.addAllowedMethod("*");

        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        //2. 添加映射路径
        source.registerCorsConfiguration("/**", corsConfiguration);
        return new CorsFilter(source);
    }
}

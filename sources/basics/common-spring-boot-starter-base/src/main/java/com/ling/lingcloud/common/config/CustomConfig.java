package com.ling.lingcloud.common.config;

import com.ling.lingcloud.common.config.properties.AppProperties;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 自定义的配置.
 * Class created on 2024/3/15 by 钟舒艺
 *
 * @author 钟舒艺
 */
@Data
@Component
@ConfigurationProperties(prefix = "custom")
public class CustomConfig {

    /**
     * 应用配置
     */
    private AppProperties app;
}

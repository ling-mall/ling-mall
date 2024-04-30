package com.ling.lingcloud.account.config;

import cn.dev33.satoken.config.SaSsoConfig;
import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import cn.hutool.json.JSONUtil;
import com.ling.lingcloud.common.web.domain.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

/**
 * 简短描述啦.
 * 详细说说
 * Class created on 2023/10/14 by 钟舒艺
 *
 * @author 钟舒艺
 */
@Slf4j
@Configuration
public class SaSSOConfig {
    /**
     * 配置SSO相关参数
     */
    @Autowired
    private void configSso(SaSsoConfig sso) {
        // 配置：未登录时返回的View
        sso.setNotLoginView(() -> JSONUtil.toJsonStr(R.success(401, "未登录")));

        // 配置：登录处理函数
        sso.setDoLoginHandle((name, pwd) -> {
            log.error(name);
            log.error(pwd);
            // 此处仅做模拟登录，真实环境应该查询数据进行登录
            if ("sa".equals(name) && "123456".equals(pwd)) {
                StpUtil.login(10001);
                return SaResult.ok("登录成功！").setData(StpUtil.getTokenValue());
            }
            return SaResult.error("登录失败！");
        });
    }
}

package com.ling.lingcloud.account.controller;

import com.ling.lingcloud.common.domain.R;
import com.ling.lingcloud.common.security.dto.LoginBody;

import cn.dev33.satoken.sso.SaSsoConsts;
import cn.dev33.satoken.sso.SaSsoUtil;
import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaFoxUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 简短描述啦.
 * 详细说说
 * Class created on 2023/10/14 by 钟舒艺
 *
 * @author 钟舒艺
 */
@Slf4j
@Validated
@RestController
@RequiredArgsConstructor
public class SsoServerController {

    @PostMapping("/sso/doLogin")
    public R<Void> ssoDoLogin(@RequestBody LoginBody loginBody) {
        if (loginBody.getUsername().equals("zhong") && loginBody.getPassword().equals("12345678")) {
            StpUtil.login(1);
        }
        return R.success("登录成功");
    }

    @RequestMapping("/sso/getRedirectUrl")
    private R<String> getRedirectUrl(String redirect, String mode, String client) {
        log.info(String.valueOf(StpUtil.isLogin()));
        // 未登录情况下，返回 code=401
        if (!StpUtil.isLogin()) {
            return R.failed(401, "未登录", "");
        }
        // 已登录情况下，构建 redirectUrl
        if (SaSsoConsts.MODE_SIMPLE.equals(mode)) {
            // 模式一
            SaSsoUtil.checkRedirectUrl(SaFoxUtil.decoderUrl(redirect));
            return R.success(redirect, "已登录");
        } else {
            // 模式二或模式三
            String redirectUrl = SaSsoUtil.buildRedirectUrl(StpUtil.getLoginId(), client, redirect);
            return R.success(redirectUrl, "已登录");
        }
    }

}

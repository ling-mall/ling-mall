package com.ling.lingcloud.controller;

import cn.dev33.satoken.sso.SaSsoProcessor;
import cn.dev33.satoken.sso.SaSsoUtil;
import cn.dev33.satoken.stp.StpUtil;
import com.ling.lingcloud.common.web.domain.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 简短描述啦.
 * 详细说说
 * Class created on 2023/10/19 by 钟舒艺
 *
 * @author 钟舒艺
 */
@Slf4j
@RestController
public class SsoClientController {


//    @GetMapping("/sso/isLogin")
//    public R<Boolean> login() {
//        return R.success(StpUtil.isLogin());
//    }
//
//    // 返回SSO认证中心登录地址
//    @GetMapping("/sso/getSsoAuthUrl")
//    public R<String> getSsoAuthUrl(String clientLoginUrl, String backUrl) {
//        String serverAuthUrl = SaSsoUtil.buildServerAuthUrl(clientLoginUrl, backUrl);
//        return R.success(serverAuthUrl, "获取成功");
//    }
//
//
//    @GetMapping("/sso/doLoginByTicket")
//    public R<Map<String, Object>> doLoginByTicket(String ticket) {
//        log.info("ticket:" + ticket);
//        Object loginId = SaSsoProcessor.instance.checkTicket(ticket, "/sso/doLoginByTicket");
//        if (loginId != null) {
//            StpUtil.login(loginId);
//            return R.success(Map.of("token", StpUtil.getTokenValue()));
//        }
//        return R.failed(400, "ticket无效", null);
//    }
//
//    @GetMapping("/sso/logout")
//    public R<Void> logout() {
//        StpUtil.logout();
//        return R.success();
//    }
}

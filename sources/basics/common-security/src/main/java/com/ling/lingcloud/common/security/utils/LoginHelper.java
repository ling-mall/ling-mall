package com.ling.lingcloud.common.security.utils;


import cn.hutool.extra.spring.SpringUtil;
import com.ling.lingcloud.common.security.model.LoginUser;
import com.ling.lingcloud.common.security.service.SecurityService;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * 简短描述啦.
 * 详细说说
 * Class created on 2023/8/18 by 钟舒艺
 *
 * @author 钟舒艺
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LoginHelper {

    public static SecurityService getSecurityService() {
        return SpringUtil.getBean(SecurityService.class);
    }


    /**
     * 登录方法.
     *
     * @param loginUser 用户信息
     */
    public static void login(LoginUser loginUser) {
        getSecurityService().login(loginUser);
    }


}

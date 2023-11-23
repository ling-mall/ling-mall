package com.ling.lingcloud.common.security.service;


import cn.dev33.satoken.context.SaHolder;
import cn.dev33.satoken.secure.BCrypt;
import cn.dev33.satoken.session.SaSession;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.util.ObjectUtil;
import com.ling.lingcloud.common.security.model.LoginUser;

/**
 * 安全模块的服务实现.
 * Class created on 2023/8/18 by 钟舒艺
 *
 * @author 钟舒艺
 */
public class SecurityServiceImpl implements SecurityService {

    public static final String LOGIN_USER_KEY = "loginUser";

    @Override
    public void login(LoginUser loginUser) {
        SaHolder.getStorage().set(LOGIN_USER_KEY, loginUser);
        StpUtil.login(loginUser.getUserId());
        StpUtil.getTokenSession().set(LOGIN_USER_KEY, loginUser);
    }

    @Override
    public LoginUser getLoginUser() {
        LoginUser loginUser = (LoginUser) SaHolder.getStorage().get(LOGIN_USER_KEY);
        if (loginUser != null) {
            return loginUser;
        }
        SaSession session = StpUtil.getTokenSession();
        if (ObjectUtil.isNull(session)) {
            return null;
        }
        loginUser = (LoginUser) session.get(LOGIN_USER_KEY);
        SaHolder.getStorage().set(LOGIN_USER_KEY, loginUser);
        return loginUser;
    }

    @Override
    public String getToken() {
        return StpUtil.getTokenValue();
    }

    @Override
    public String passwordEncryption(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    @Override
    public boolean checkPassword(String plaintext, String ciphertext) {
        return BCrypt.checkpw(plaintext, ciphertext);
    }

    @Override
    public void logout() {
        StpUtil.logout();
    }
}

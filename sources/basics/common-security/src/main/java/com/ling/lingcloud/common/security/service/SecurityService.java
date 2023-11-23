package com.ling.lingcloud.common.security.service;

import com.ling.lingcloud.common.security.model.LoginUser;

/**
 * 简短描述啦.
 * 详细说说
 * Class created on 2023/8/12 by 钟舒艺
 *
 * @author 钟舒艺
 */
public interface SecurityService {


    void login(LoginUser loginUser);

    /**
     * 获取当前用户.
     *
     * @return 当前用户对象
     */
    LoginUser getLoginUser();

    /**
     * 获取token.
     *
     * @return token 值
     */
    String getToken();


    /**
     * 给密码加密.
     *
     * @param password 密码
     * @return 加密后的密码
     */
    String passwordEncryption(String password);


    /**
     * 检查明文密码文本是否匹配加密后的文本.
     *
     * @param plaintext  明文密码
     * @param ciphertext 密文
     * @return 是否匹配
     */
    boolean checkPassword(String plaintext, String ciphertext);


    /**
     * 注销登录
     */
    void logout();
}

package com.ling.lingcloud.account.api;

/**
 * 用户服务接口.
 * Class created on 2023/8/12 by 钟舒艺
 *
 * @author 钟舒艺
 */
public interface RemoteAccountService {


    /**
     * 通过用户名登录.
     *
     * @param username 用户名
     * @param password 密码
     * @return token
     */
    String loginByUsername(String username, String password);
}

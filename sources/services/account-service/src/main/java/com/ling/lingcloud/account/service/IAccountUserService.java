package com.ling.lingcloud.account.service;


import com.ling.lingcloud.account.api.entity.AccountUser;

/**
 * 账户服务接口.
 *
 * @author 钟舒艺
 */
public interface IAccountUserService {

    /**
     * 根据用户名查询账号.
     *
     * @param username 用户名
     * @return 用户信息
     */
    AccountUser getUserByUserName(String username);
}

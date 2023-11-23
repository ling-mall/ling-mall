package com.ling.lingcloud.account.api.exception;

/**
 * 用户已被封禁.
 * Class created on 2023/8/19 by 钟舒艺
 *
 * @author 钟舒艺
 */
public class AccountDisableException extends AccountException {
    public AccountDisableException(String username) {
        super("exception.login.userDisable", username);
    }
}

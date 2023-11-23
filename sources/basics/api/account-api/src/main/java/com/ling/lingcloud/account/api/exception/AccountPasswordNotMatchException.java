package com.ling.lingcloud.account.api.exception;

import java.io.Serial;

/**
 * 用户密码不正确或不符合规范异常类.
 *
 * @author 钟舒艺
 */
public class AccountPasswordNotMatchException extends AccountException {
    @Serial
    private static final long serialVersionUID = 1L;

    public AccountPasswordNotMatchException() {
        super("exception.login.invalidCredentials");
    }
}

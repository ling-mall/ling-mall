package com.ling.lingcloud.account.api.exception;

import java.io.Serializable;


import com.ling.lingcloud.common.exception.BaseException;

import lombok.NoArgsConstructor;

/**
 * 账户异常基类.
 * Class created on 2023/8/19 by 钟舒艺
 *
 * @author 钟舒艺
 */
@NoArgsConstructor
public class AccountException extends BaseException {
    public AccountException(String code, Serializable... args) {
        super("account", code, args, null);
    }
}

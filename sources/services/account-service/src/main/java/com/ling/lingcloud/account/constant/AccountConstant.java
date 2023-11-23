package com.ling.lingcloud.account.constant;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * 关于账户的常量.
 *
 * @author 钟舒艺
 */
@SuppressWarnings("unused")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AccountConstant {

    /**
     * 用户状态.
     */
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class UserStatus {

        /**
         * 正常状态.
         */
        public static final Byte NORMAL = 1;

        /**
         * 封禁状态.
         */
        public static final Byte DISABLE = 0;

    }

}

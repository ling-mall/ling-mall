package com.ling.lingcloud.common.mp.exception;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Order 参数异常.
 * Class created on 2023/10/17 by 钟舒艺
 *
 * @author 钟舒艺
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OrderParameterException extends CommonMpException {

    /**
     * Oder by 参数异常
     *
     * @param columnName 列名
     */
    public OrderParameterException(String columnName) {
        super("exception.common.mp.OrderParameterError", columnName);
    }
}

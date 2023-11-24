package com.ling.lingcloud.common.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

/**
 * 基础异常.
 *
 * @author ruoyi
 */

@Data
@AllArgsConstructor
@SuppressWarnings("unused")
@NoArgsConstructor(force = true)
@EqualsAndHashCode(callSuper = true)
public class BaseException extends RuntimeException {


    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 所属模块.
     */
    private final String module;

    /**
     * 错误码.
     */
    private final String code;

    /**
     * 错误码对应的参数.
     */
    private final Serializable[] args;

    /**
     * 错误消息.
     */
    private final String defaultMessage;

    public BaseException(String module, String code, Serializable[] args) {
        this(module, code, args, null);
    }

    public BaseException(String module, String defaultMessage) {
        this(module, null, null, defaultMessage);
    }

    public BaseException(String code, Serializable[] args) {
        this(null, code, args, null);
    }

    public BaseException(String defaultMessage) {
        this(null, null, null, defaultMessage);
    }
}

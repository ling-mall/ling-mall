package com.ling.lingcloud.common.exception;

import lombok.AccessLevel;
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
@SuppressWarnings("unused")
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@EqualsAndHashCode(callSuper = true)
public class BusinessException extends RuntimeException {


    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 错误码
     */
    private final IErrorCode errorCode;

    /**
     * 国际化 参数.
     */
    private final Serializable[] args;


    public BusinessException(IErrorCode errorCode, Serializable... args) {
        this.errorCode = errorCode;
        this.args = args;
    }

    public BusinessException(IErrorCode errorCode) {
        this.errorCode = errorCode;
        this.args = new String[]{};
    }
}

package com.ling.lingcloud.common.domain;

import java.io.Serial;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;

import cn.hutool.http.HttpStatus;
import lombok.Data;

/**
 * 通用返回对象.
 *
 * @param <T> 需要返回的类型
 * @author 钟舒艺
 **/
@Data
@SuppressWarnings("unused")
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class R<T> implements Serializable {

    @Serial
    private static final long serialVersionUID = -2339115200498941889L;

    /**
     * 状态码.
     */
    private int code;

    /**
     * 提示信息.
     */
    private String message;

    /**
     * 数据封装.
     */
    private transient T result;


    /**
     * response timestamp.
     */
    private long timestamp;

    /**
     * 类型.
     */
    private Boolean isSuccess;

    protected R() {
    }

    protected R(
            final int code,
            final String message,
            final T data,
            final Boolean isSuccess
    ) {
        this.code = code;
        this.message = message;
        this.result = data;
        this.isSuccess = isSuccess;
        this.timestamp = System.currentTimeMillis();
    }

    /**
     * 成功返回结果.
     *
     * @return 通用返回类
     */
    public static R<Void> success() {
        return new R<>(HttpStatus.HTTP_OK, "操作成功", null, Boolean.TRUE);
    }


    /**
     * 成功返回结果.
     *
     * @param data 获取的数据
     * @param <T>  要返回的类型
     * @return 通用返回
     */
    public static <T> R<T> success(final T data) {
        return new R<>(HttpStatus.HTTP_OK, "操作成功", data, Boolean.TRUE);
    }

    /**
     * 成功返回结果.
     *
     * @param data    获取的数据
     * @param message 提示信息
     * @param <T>     要返回的类型
     * @return 通用返回
     */
    public static <T> R<T> success(
            final T data,
            final String message
    ) {
        return new R<>(HttpStatus.HTTP_OK, message, data, Boolean.TRUE);
    }

    /**
     * 成功返回结果.
     *
     * @param message 提示信息
     * @param <T>     要返回的类型
     * @return 通用返回
     */
    public static <T> R<T> success(final String message) {
        return new R<>(HttpStatus.HTTP_OK, message, null, Boolean.TRUE);
    }

    /**
     * 失败返回类型.
     *
     * @return 通用返回类
     */
    public static R<Void> failed() {
        return new R<>(HttpStatus.HTTP_INTERNAL_ERROR, "操作失败", null, Boolean.FALSE);
    }

    /**
     * 失败返回结果.
     *
     * @param msg 信息
     * @return 通用返回结果
     */
    public static R<Void> failed(final String msg) {
        return new R<>(HttpStatus.HTTP_INTERNAL_ERROR, msg, null, Boolean.FALSE);
    }


    /**
     * 失败返回结果.
     *
     * @param code 状态码
     * @param msg  提示信息
     * @return 通用返回类型
     */
    public static R<Void> failed(
            final Integer code,
            final String msg
    ) {
        return new R<>(code, msg, null, Boolean.FALSE);
    }

    /**
     * 失败返回结果.
     *
     * @param code 状态码
     * @param msg  信息
     * @param data 数据
     * @param <T>  数据类型
     * @return 通用返回类
     */
    public static <T> R<T> failed(
            final Integer code,
            final String msg,
            final T data
    ) {
        return new R<>(code, msg, data, Boolean.FALSE);
    }
}

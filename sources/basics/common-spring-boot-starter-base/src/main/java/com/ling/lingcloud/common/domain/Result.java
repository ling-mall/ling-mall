package com.ling.lingcloud.common.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

/**
 * 通用返回对象.
 *
 * @param <T> 需要返回的类型
 * @author 钟舒艺
 **/
@Data
@SuppressWarnings("unused")
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class Result<T> implements Serializable {

    @Serial
    private static final long serialVersionUID = -2339115200498941889L;

    /**
     * 状态码.
     */
    private String code;

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
}

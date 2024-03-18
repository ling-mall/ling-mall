package com.ling.lingcloud.common.web.domain;

import com.ling.lingcloud.common.domain.Result;
import com.ling.lingcloud.common.exception.IErrorCode;
import com.ling.lingcloud.common.exception.CommonCodeEnum;
import com.ling.lingcloud.common.web.util.MessageUtils;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

/**
 * web 通用返回对象.
 * Class created on 2024/3/13 by 钟舒艺
 *
 * @author 钟舒艺
 */

@Data
@EqualsAndHashCode(callSuper = true)
public class R<T> extends Result<T> {

    private final static String DEFAULT_SUCCESS_MESSAGE = "成功";

    @Serial
    private static final long serialVersionUID = 1L;

    public R(String code, String message, T result, long timestamp, Boolean isSuccess) {
        super(code, message, result, timestamp, isSuccess);
    }

    public static R<Void> success() {
        String messageCode = CommonCodeEnum.SUCCESS.getMessageCode();
        String message = MessageUtils.message(messageCode);
        if (message.equals(messageCode)) {
            message = DEFAULT_SUCCESS_MESSAGE;
        }
        return new R<>(CommonCodeEnum.SUCCESS.builderCode(), message, null, System.currentTimeMillis(), true);
    }

    /**
     * 成功返回结果.
     *
     * @param message 提示信息
     * @return 通用返回
     */
    public R<Void> success(String message) {
        return new R<>(CommonCodeEnum.SUCCESS.builderCode(), message, null, System.currentTimeMillis(), true);
    }

    /**
     * 成功返回结果.
     *
     * @param data    数据
     * @param message 提示信息
     */
    public static <T> R<T> success(T data, String message) {
        return new R<>(CommonCodeEnum.SUCCESS.builderCode(), message, data, System.currentTimeMillis(), true);
    }

    /**
     * 错误信息
     *
     * @param errorCode 错误码
     */
    public static R<Void> error(IErrorCode errorCode, Object... args) {
        return new R<>(errorCode.builderCode(), MessageUtils.message(errorCode.getMessageCode(), args), null, System.currentTimeMillis(), false);
    }
}

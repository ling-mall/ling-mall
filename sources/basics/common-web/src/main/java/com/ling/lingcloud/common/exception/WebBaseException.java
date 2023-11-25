package com.ling.lingcloud.common.exception;

import cn.hutool.core.text.CharSequenceUtil;
import com.ling.lingcloud.common.util.MessageUtils;
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
@SuppressWarnings("unused")
@EqualsAndHashCode(callSuper = true)
public class WebBaseException extends BaseException implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    public WebBaseException(String module, String code, Serializable[] args, String defaultMessage) {
        super(module, code, args, defaultMessage);
    }

    public WebBaseException() {
    }

    public WebBaseException(String module, String code, Serializable[] args) {
        super(module, code, args);
    }

    public WebBaseException(String module, String defaultMessage) {
        super(module, defaultMessage);
    }

    public WebBaseException(String code, Serializable[] args) {
        super(code, args);
    }

    public WebBaseException(String defaultMessage) {
        super(defaultMessage);
    }

    @Override
    public String getMessage() {
        String message = null;
        if (!CharSequenceUtil.isEmpty(getCode())) {
            message = MessageUtils.message(getCode(), (Object[]) getArgs());
        }
        if (message == null) {
            message = getDefaultMessage();
        }
        return message;
    }

}

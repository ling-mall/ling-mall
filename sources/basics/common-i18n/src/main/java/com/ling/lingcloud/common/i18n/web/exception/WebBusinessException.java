package com.ling.lingcloud.common.i18n.web.exception;

import cn.hutool.core.text.CharSequenceUtil;

import com.ling.lingcloud.common.exception.BusinessException;
import com.ling.lingcloud.common.exception.IErrorCode;
import com.ling.lingcloud.common.i18n.utils.MessageUtils;

import lombok.Data;
import lombok.EqualsAndHashCode;

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
public class WebBusinessException extends BusinessException implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    public WebBusinessException(IErrorCode errorCode, Serializable... args) {
        super(errorCode, args);
    }

    @Override
    public String getMessage() {
        String message = null;
        if (!CharSequenceUtil.isEmpty(getErrorCode().getMessageCode())) {
            message = MessageUtils.message(getErrorCode().getMessageCode(), (Object[]) getArgs());
        }
        return message;
    }

}

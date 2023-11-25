package com.ling.lingcloud.common.security.handler;


import com.ling.lingcloud.common.domain.R;
import com.ling.lingcloud.common.i18n.MessageUtils;

import cn.dev33.satoken.exception.NotLoginException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Sa token 异常捕获.
 * Class created on 2023/8/20 by 钟舒艺
 *
 * @author 钟舒艺
 */
@Slf4j
@RestControllerAdvice
public class SaTokenExceptionHandler {

    /**
     * 处理 Sa-token 的未登录异常.
     *
     * @param nle 异常信息
     * @return 通用返回结果
     */
    @ExceptionHandler(NotLoginException.class)
    public R<Void> handlerNotLoginException(NotLoginException nle) {

        String message = "";

        if (nle.getType().equals(NotLoginException.NOT_TOKEN)) {
            message = "exception.satoken.notToken";
        } else if (nle.getType().equals(NotLoginException.INVALID_TOKEN)) {
            message = "exception.satoken.invalidToken";
        } else if (nle.getType().equals(NotLoginException.TOKEN_TIMEOUT)) {
            message = "exception.satoken.tokenTimeout";
        } else if (nle.getType().equals(NotLoginException.BE_REPLACED)) {
            message = "exception.satoken.beReplaced";
        } else if (nle.getType().equals(NotLoginException.KICK_OUT)) {
            message = "exception.satoken.kickOut";
        } else {
            message = "exception.satoken.notLogin";
        }
        log.error(nle.getMessage());
        // 返回给前端
        return R.failed(401, MessageUtils.message(message));
    }
}

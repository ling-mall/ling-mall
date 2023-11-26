package com.ling.lingcloud.common.web.handler;

import java.util.Objects;


import com.ling.lingcloud.common.domain.R;
import com.ling.lingcloud.common.i18n.utils.MessageUtils;
import com.ling.lingcloud.common.web.exception.WebBaseException;

import cn.hutool.http.HttpStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理.
 * Class created on 2023/8/8 by 钟舒艺
 *
 * @author 钟舒艺
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 自定义验证异常.
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public R<Void> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        log.error(e.getMessage(), e);
        String message = Objects.requireNonNull(e.getBindingResult().getFieldError()).getDefaultMessage();
        return R.failed(HttpStatus.HTTP_BAD_REQUEST, MessageUtils.message(message));
    }

    /**
     * 业务异常.
     */
    @ExceptionHandler(WebBaseException.class)
    public R<Void> handleMethodArgumentNotValidException(WebBaseException e) {
        log.error(e.getMessage(), e);
        log.error("捕获到 {} 模块异常: {}", e.getModule(), e.getMessage());
        return R.failed(HttpStatus.HTTP_INTERNAL_ERROR, MessageUtils.message(e.getMessage()));
    }


}

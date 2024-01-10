package com.ling.lingcloud.common.web.handler;

import com.ling.lingcloud.common.domain.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

/**
 * 简短描述啦.
 * 详细说说
 * Class created on 2023/12/5 by 钟舒艺
 *
 * @author 钟舒艺
 */
@Slf4j
@RestControllerAdvice
public class WebGlobalExceptionHandler {

    /**
     * 参数校验异常.
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public R<Void> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        log.error(e.getMessage(), e);
        final BindingResult result = e.getBindingResult();
        final StringBuilder errorMsg = new StringBuilder();
        if (result.hasErrors()) {
            final List<FieldError> fieldErrors = result.getFieldErrors();
            fieldErrors.forEach(error -> errorMsg.append(error.getDefaultMessage()).append("! ;"));
        }
        return R.failed(400, errorMsg.toString());
    }
}

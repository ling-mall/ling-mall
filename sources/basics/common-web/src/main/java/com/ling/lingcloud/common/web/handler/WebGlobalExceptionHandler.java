package com.ling.lingcloud.common.web.handler;

import com.ling.lingcloud.common.web.domain.R;
import com.ling.lingcloud.common.web.exception.CommonCodeEnum;
import com.ling.lingcloud.common.web.exception.CommonWebErrorCodeEnum;
import com.ling.lingcloud.common.web.exception.WebBusinessException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.List;
import java.util.Map;

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
     * 业务异常.
     */
    @ExceptionHandler(WebBusinessException.class)
    public R<Void> handleMethodArgumentNotValidException(WebBusinessException e) {
        log.error(e.getMessage(), e);
        log.error("捕获到 {} 服务 {} 模块异常: {}", e.getErrorCode().getServerName(), e.getErrorCode().getModuleName(), e.getMessage());
        return R.error(e.getErrorCode());
    }

    /**
     * 处理 404.
     */
    @ExceptionHandler(NoHandlerFoundException.class)
    public R<Void> handleMethodArgumentNotValidException(NoHandlerFoundException e, HttpServletRequest request) {
        return R.error(CommonWebErrorCodeEnum.NOT_FOUND,  request.getRequestURI());
    }

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
//        return R.failed(400, errorMsg.toString());
        return R.success();
    }
}

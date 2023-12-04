package com.ling.lingcloud.common.i18n.web.handler;


import com.ling.lingcloud.common.domain.R;
import com.ling.lingcloud.common.i18n.web.exception.WebBusinessException;

import lombok.extern.slf4j.Slf4j;
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
public class I18nWebGlobalExceptionHandler {

    /**
     * 业务异常.
     */
    @ExceptionHandler(WebBusinessException.class)
    public R<Void> handleMethodArgumentNotValidException(WebBusinessException e) {
        log.error(e.getMessage(), e);
        log.error("捕获到 {} 服务 {} 模块异常: {}", e.getErrorCode().getServerName(), e.getErrorCode().getModuleName(), e.getMessage());
        return R.failed(e.getErrorCode().builderCode(), e.getMessage());
    }


}

package com.ling.lingcloud.common.web.exception;

import com.ling.lingcloud.common.exception.IErrorCode;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Web 错误码.
 * Class created on 2024/3/12 by 钟舒艺
 *
 * @author 钟舒艺
 */
public interface ICommonWebErrorCode extends IErrorCode {


    /**
     * 模块名
     */
    String MODULE_NAME = "web";

    /**
     * 模块id
     */
    Integer MODULE_ID = 1;


    @Override
    default Integer getModuleId() {
        return MODULE_ID;
    }

    @Override
    default String getModuleName() {
        return MODULE_NAME;
    }
}

package com.ling.lingcloud.foundation.api.generate.exception;

import com.ling.lingcloud.common.exception.IErrorCode;

/**
 * 基础服务生成模块错误码.
 * Class created on 2024/4/15 by 钟舒艺
 *
 * @author 钟舒艺
 */
public interface IFoundationGenerateErrorCode extends IErrorCode {
    /**
     * 模块名
     */
    String MODULE_NAME = "generate";

    /**
     * 模块id
     */
    Integer MODULE_ID = 1;

    @Override
    default Integer getModuleId() {
        return MODULE_ID;
    }

    @Override
    default String  getModuleName() {
        return MODULE_NAME;
    }
}

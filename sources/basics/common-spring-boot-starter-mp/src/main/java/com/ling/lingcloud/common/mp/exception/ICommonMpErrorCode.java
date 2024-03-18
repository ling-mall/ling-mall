package com.ling.lingcloud.common.mp.exception;

import com.ling.lingcloud.common.exception.IErrorCode;

/**
 * Mybatis plus异常码 接口.
 * Class created on 2023/11/29 by 钟舒艺
 *
 * @author 钟舒艺
 */
public interface ICommonMpErrorCode extends IErrorCode {

    /**
     * 模块名
     */
    String MODULE_NAME = "mp";

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

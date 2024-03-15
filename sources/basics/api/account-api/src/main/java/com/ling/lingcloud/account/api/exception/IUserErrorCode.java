package com.ling.lingcloud.account.api.exception;

import com.ling.lingcloud.common.exception.IErrorCode;

/**
 * 用户模块错误码.
 * Class created on 2023/11/28 by 钟舒艺
 *
 * @author 钟舒艺
 */
public interface IUserErrorCode extends IErrorCode {

    /**
     * 模块名
     */
    String MODULE_NAME = "user";

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

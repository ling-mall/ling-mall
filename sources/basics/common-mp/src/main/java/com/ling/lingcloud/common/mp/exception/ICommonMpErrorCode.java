package com.ling.lingcloud.common.mp.exception;

import com.ling.lingcloud.common.exception.IErrorCode;

/**
 * 简短描述啦.
 * 详细说说
 * Class created on 2023/11/29 by 钟舒艺
 *
 * @author 钟舒艺
 */
public interface ICommonMpErrorCode extends IErrorCode {

    /**
     * 服务id
     */
    Integer SERVER_ID = 1;

    /**
     * 服务名称
     */
    String SERVER_NAME = "common";

    /**
     * 模块名
     */
    String MODULE_NAME = "mp";

    /**
     * 模块id
     */
    Integer MODULE_ID = 1;


    @Override
    default Integer getServerId() {
        return SERVER_ID;
    }

    @Override
    default String getServerName() {
        return SERVER_NAME;
    }

    @Override
    default Integer getModuleId() {
        return MODULE_ID;
    }

    @Override
    default String getModuleName() {
        return MODULE_NAME;
    }
}

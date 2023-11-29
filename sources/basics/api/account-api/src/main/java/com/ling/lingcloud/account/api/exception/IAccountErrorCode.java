package com.ling.lingcloud.account.api.exception;

import com.ling.lingcloud.common.exception.IErrorCode;

/**
 * 简短描述啦.
 * Class created on 2023/11/28 by 钟舒艺
 *
 * @author 钟舒艺
 */
public interface IAccountErrorCode extends IErrorCode {
    /**
     * 服务名
     */
    String SERVER_NAME = "account";

    /**
     * 服务id
     */
    Integer SERVER_ID = 2;


    @Override
    default Integer getServerId() {
        return SERVER_ID;
    }

    @Override
    default String getServerName() {
        return SERVER_NAME;
    }
}

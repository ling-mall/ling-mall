package com.ling.lingcloud.account.api.enums;

import com.ling.lingcloud.account.api.exception.IUserErrorCode;
import com.ling.lingcloud.common.exception.ErrorManager;
import lombok.Getter;

/**
 * 简短描述啦.
 * 详细说说
 * Class created on 2023/11/28 by 钟舒艺
 *
 * @author 钟舒艺
 */
@Getter
public enum UserErrorCodeEnum implements IUserErrorCode {
    /**
     * 用户名或密码不匹配
     */
    PASSWORD_NOT_MATCH(1, 1, "account.user.login.exception.invalidCredentials", new String[]{}),
    /**
     * 用户被禁用
     */
    USER_DISABLED(1, 2, "account.user.login.exception.userDisable", new String[]{"username"});

    /**
     * 责任方
     * <ul>
     *     <li>0: 保留，无责任方标识（此时错误码应该固定为7位0，标识调用成功，无错误）</li>
     *     <li>1: 保留，标识调用方</li>
     *     <li>2: 保留，标识第三方服务</li>
     *     <li>3: 保留，标识业务服务</li>
     * </ul>
     */
    private final Integer responsibleParty;

    /**
     * 流水标识
     */
    private final Integer serialId;

    /**
     * 错误信息 i18 code
     */
    private final String messageCode;

    /**
     * i18n 参数名称列表
     */
    private final String[] parameters;


    UserErrorCodeEnum(Integer responsibleParty, Integer serialId, String messageCode, String[] parameters) {
        this.responsibleParty = responsibleParty;
        this.serialId = serialId;
        this.messageCode = messageCode;
        this.parameters = parameters;

        ErrorManager.register(this);
    }
}

package com.ling.lingcloud.common.web.exception;

import com.ling.lingcloud.common.exception.ErrorManager;
import lombok.Getter;

/**
 * Web 错误码枚举.
 * Class created on 2024/3/12 by 钟舒艺
 *
 * @author 钟舒艺
 */
@Getter
public enum CommonWebErrorCodeEnum implements ICommonWebErrorCode {

    /**
     * 路径不存在
     */
    NOT_FOUND(1, 1, "common.web.request.exception.notFound", new String[]{"url"}),
    /**
     * 未知错误
     */
    UNKNOWN_ERROR(3, 2, "common.web.request.exception.unknown", new String[]{}),
    /**
     * 请求参数错误
     */
    PARAMETER_ERROR(1, 1, "common.web.request.error.parameter", new String[]{"errorMessage"}),
    /**
     * 服务端错误
     */
    SERVER_ERROR(3, 2, "common.web.request.error.server", new String[]{}),
    /**
     * 第三方服务错误
     */
    THIRD_PARTY_ERROR(2, 3, "common.web.request.error.thirdParty", new String[]{"errorMessage"});

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

    CommonWebErrorCodeEnum(Integer responsibleParty, Integer serialId, String messageCode, String[] parameters) {
        this.responsibleParty = responsibleParty;
        this.serialId = serialId;
        this.messageCode = messageCode;
        this.parameters = parameters;

        ErrorManager.register(this);
    }
}

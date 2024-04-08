package com.ling.lingcloud.common.exception;

import com.ling.lingcloud.common.exception.ErrorManager;
import com.ling.lingcloud.common.exception.IErrorCode;
import lombok.Getter;

/**
 * 通用状态码.
 * Class created on 2024/3/13 by 钟舒艺
 *
 * @author 钟舒艺
 */
@Getter
public enum CommonCodeEnum implements IErrorCode {

    /**
     * 操作成功
     */
    SUCCESS(0, 0, "common.web.request.success", new String[]{});

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


    @Override
    public Integer getResponsibleParty() {
        return 0;
    }

    @Override
    public Integer getServerId() {
        return 0;
    }

    @Override
    public Integer getModuleId() {
        return 0;
    }

    @Override
    public String getModuleName() {
        return "common";
    }

    CommonCodeEnum(Integer responsibleParty, Integer serialId, String messageCode, String[] parameters) {
        this.responsibleParty = responsibleParty;
        this.serialId = serialId;
        this.messageCode = messageCode;
        this.parameters = parameters;

        ErrorManager.register(this);
    }
}

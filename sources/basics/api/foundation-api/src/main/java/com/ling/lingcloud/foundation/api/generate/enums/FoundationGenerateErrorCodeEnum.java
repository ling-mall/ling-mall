package com.ling.lingcloud.foundation.api.generate.enums;

import com.ling.lingcloud.common.exception.ErrorManager;
import com.ling.lingcloud.foundation.api.generate.exception.IFoundationGenerateErrorCode;
import lombok.Getter;

/**
 * 基础服务生成错误码枚举.
 * Class created on 2024/4/15 by 钟舒艺
 *
 * @author 钟舒艺
 */
@Getter
public enum FoundationGenerateErrorCodeEnum implements IFoundationGenerateErrorCode {

    /**
     * 模板组名称重复.
     */
    GROUP_NAME_REPEAT(1, 1, "foundation.generate.group.exception.name.repeat", new String[]{"groupName"}),
    ;

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


    FoundationGenerateErrorCodeEnum(Integer responsibleParty, Integer serialId, String messageCode, String[] parameters) {
        this.responsibleParty = responsibleParty;
        this.serialId = serialId;
        this.messageCode = messageCode;
        this.parameters = parameters;

        ErrorManager.register(this);
    }
}

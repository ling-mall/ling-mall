package com.ling.lingcloud.common.exception;

import lombok.Getter;

/**
 * 错误码.
 * Class created on 2023/11/28 by 钟舒艺
 *
 * @author 钟舒艺
 */
public interface IErrorCode {

    /**
     * 责任方
     * <ul>
     *     <li>0: 保留，无责任方标识（此时错误码应该固定为7位0，标识调用成功，无错误）</li>
     *     <li>1: 保留，标识调用方</li>
     *     <li>2: 保留，标识第三方服务</li>
     *     <li>3: 保留，标识业务服务</li>
     * </ul>
     */
    Integer getResponsibleParty();

    /**
     * 微服务标识（一级宏观错误码）
     */
    Integer getServerId();

    /**
     * 服务名
     */
    String getServerName();

    /**
     * 模块id （二级宏观错误码）
     */
    Integer getModuleId();

    /**
     * 模块名
     */
    String getModuleName();

    /**
     * 流水标识
     */
    Integer getSerialId();

    /**
     * 错误信息 i18 code
     */
    String getMessageCode();

    /**
     * 构建错误码
     *
     * @return 错误码
     */
    default Integer builderCode() {
        return Integer.valueOf(
                getResponsibleParty().toString() +
                        String.format("%02d", getServerId()) +
                        String.format("%02d", getModuleId()) +
                        String.format("%02d", getSerialId())
        );
    }
}


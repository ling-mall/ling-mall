package com.ling.lingcloud.common.exception;

import cn.hutool.core.util.StrUtil;

import java.util.HashMap;

/**
 * 错误码管理.
 * Class created on 2023/11/28 by 钟舒艺
 *
 * @author 钟舒艺
 */
public class ErrorManager {

    /**
     * 全局错误码 map
     */
    public final static HashMap<String, IErrorCode> ERROR_CODE_MAP = new HashMap<>();

    /**
     * 服务名 map
     */
    public final static HashMap<Integer, String> ERROR_SERVICE_MAP = new HashMap<>();

    /**
     * 模块名 map
     */
    public final static HashMap<Integer[], String> ERROR_MODULE_MAP = new HashMap<>();

    /**
     * 注册错误码
     *
     * @param errorCode 错误码对象
     */
    public static void register(IErrorCode errorCode) {
        // 公共错误码不校验
        if ("common".equals(errorCode.getServerName()) && "common".equals(errorCode.getModuleName())) {
            return;
        }

        if (errorCode.getResponsibleParty() == null) {
            throw new IllegalArgumentException("责任方不能为空");
        }

        if (StrUtil.isEmpty(errorCode.getServerName())) {
            throw new IllegalArgumentException("服务名不能为空");
        }

        if (errorCode.getServerId() == null || errorCode.getServerId() == 0) {
            throw new IllegalArgumentException("服务id不能为空且不能为0");
        }

        if (StrUtil.isEmpty(errorCode.getModuleName())) {
            throw new IllegalArgumentException("模块名不能为空");
        }

        if (errorCode.getModuleId() == null || errorCode.getModuleId() == 0) {
            throw new IllegalArgumentException("模块id不能为空且不能为0");
        }

        if (errorCode.getSerialId() == null || errorCode.getSerialId() == 0) {
            throw new IllegalArgumentException("错误码序号不能为空且不能为0");
        }

        String serviceName = ERROR_SERVICE_MAP.get(errorCode.getServerId());
        if (serviceName != null && !serviceName.equals(errorCode.getServerName())) {
            throw new IllegalArgumentException("服务 ID 重复，该 ID 已分配");
        }

        String moduleName = ERROR_MODULE_MAP.get(new Integer[]{errorCode.getServerId(), errorCode.getModuleId()});
        if (moduleName != null && !moduleName.equals(errorCode.getModuleName())) {
            throw new IllegalArgumentException("模块 ID 重复，该 ID 已分配");
        }

        ERROR_SERVICE_MAP.put(errorCode.getServerId(), errorCode.getServerName());
        ERROR_MODULE_MAP.put(new Integer[]{errorCode.getServerId(), errorCode.getModuleId()}, errorCode.getModuleName());

        String code = errorCode.builderCode();
        assert !ERROR_CODE_MAP.containsKey(code) : "错误码重复";
        ERROR_CODE_MAP.put(code, errorCode);
    }
}

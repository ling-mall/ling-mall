package com.ling.lingcloud.gateway.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 网关相关常量.
 * Class created on 2023/10/18 by 钟舒艺
 *
 * @author 钟舒艺
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class GatewayConstant {

    /**
     * lb uri 正则
     */
    public static final String LB_URI_REGEX = "^lb://.*$";

    /**
     * 谓词工厂键
     */
    public static final List<String> PREDICATE_KEYS = List.of(
            "After",
            "Before",
            "Between",
            "Cookie",
            "Header",
            "Host",
            "Method",
            "Path",
            "Query",
            "RemoteAddr",
            "Weight");

    /**
     * 过滤器工厂
     */
    public static final List<String> FILTER_KEYS = List.of(
            "AddRequestHeader",
            "AddRequestParameter",
            "AddResponseHeader",
            "DedupeResponseHeader",
            "CircuitBreaker",
            "FallbackHeaders",
            "MapRequestHeader",
            "PrefixPath",
            "PreserveHostHeader",
            "RequestRateLimiter",
            "RedirectTo",
            "RemoveRequestHeader",
            "RemoveResponseHeader",
            "RemoveRequestParameter",
            "RewritePath",
            "RewriteLocationResponseHeader",
            "RewriteResponseHeader",
            "SaveSession",
            "SecureHeaders",
            "SetPath",
            "SetRequestHeader",
            "SetResponseHeader",
            "SetStatus",
            "StripPrefix",
            "Retry",
            "RequestSize",
            "SetRequestHost",
            "ModifyRequestBody",
            "ModifyResponseBody"
    );
}

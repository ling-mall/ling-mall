package com.ling.lingcloud.gateway.api.domain;

import com.ling.lingcloud.common.domain.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

/**
 * 简短描述啦.
 * 详细说说
 * Class created on 2023/10/15 by 钟舒艺
 *
 * @author 钟舒艺
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class GatewayRouteItem extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 路由表id
     */
    private Long routeId;

    /**
     * 参数key
     */
    private String paramKey;

    /**
     * 参数value
     */
    private String paramValue;

    /**
     * 参数类型，0为 predicate，1为过 filter
     */
    private Integer type;

    /**
     * 启用状态：0禁用(默认)
     */
    private Integer status;
}

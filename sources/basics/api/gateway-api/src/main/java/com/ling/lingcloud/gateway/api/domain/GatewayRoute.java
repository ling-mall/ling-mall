package com.ling.lingcloud.gateway.api.domain;

import com.ling.lingcloud.common.domain.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 简短描述啦.
 * 详细说说
 * Class created on 2023/10/15 by 钟舒艺
 *
 * @author 钟舒艺
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class GatewayRoute extends BaseEntity implements Serializable {

    /**
     * 路由id
     */
    private String routerId;

    /**
     * 路由顺序
     */
    private Integer sort;

    /**
     * 服务名
     */
    private String name;

    /**
     * 服务地址
     */
    private String uri;

    /**
     * 是否忽略前缀0-否 1-是
     */
    private Integer stripPrefix;

    /**
     * 是否在接口文档中展示:0-否 1-是
     */
    private Integer showApi;

    /**
     * 状态:0-禁用 1-启用
     */
    private Integer status;
}

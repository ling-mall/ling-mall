package com.ling.lingcloud.gateway.api.dto;

import com.ling.lingcloud.gateway.api.domain.GatewayRouteItem;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 简短描述啦.
 * 详细说说
 * Class created on 2023/10/15 by 钟舒艺
 *
 * @author 钟舒艺
 */
@Data
public class GatewayRouteDTO {
    /**
     * 主键id.
     */
    private Long id;

    /**
     * 删除标志（0 代表未删除， 1 代表删除）.
     */
    private Byte isDeleted;

    /**
     * 创建者.
     */
    private Long createBy;

    /**
     * 创建时间.
     */
    private LocalDateTime createTime;

    /**
     * 更新者.
     */
    private Long updateBy;

    /**
     * 更新时间.
     */
    private LocalDateTime updateTime;

    /**
     * 备注.
     */
    private String remark;

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

    /**
     * 路由配置
     */
    private List<GatewayRouteItem> gatewayRouteItemList;
}

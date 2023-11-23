package com.ling.lingcloud.gateway.api;

import com.ling.lingcloud.common.mp.domain.PageInfo;
import com.ling.lingcloud.common.mp.domain.PageQuery;
import com.ling.lingcloud.gateway.api.domain.GatewayRoute;
import com.ling.lingcloud.gateway.api.dto.GatewayRouteDTO;

/**
 * 网关服务.
 * Class created on 2023/10/18 by 钟舒艺
 *
 * @author 钟舒艺
 */
public interface RemoteGatewayService {

    /**
     * 分页查询网关路由
     *
     * @param dto       查询条件
     * @param pageQuery 分页信息
     * @return 查询结果
     */
    PageInfo<GatewayRoute> listPageGatewayRoute(GatewayRouteDTO dto, PageQuery pageQuery);

    /**
     * 新增网关路由，新增后刷新配置
     *
     * @param gatewayRoute 路由对象
     * @return 是否成功
     */
    Boolean saveGatewayRoute(GatewayRouteDTO gatewayRoute);

    /**
     * 更新网关路由，更新后刷新配置
     *
     * @param gatewayRoute 路由信息
     * @return 是否成功
     */
    Boolean updateGatewayRouteById(GatewayRouteDTO gatewayRoute);

    /**
     * 根据id删除网关路由
     *
     * @param id id
     * @return 是否成功
     */
    Boolean removeGatewayRouteById(Long id);

    /**
     * 加载路由到配置
     */
    void loadRouter();
}

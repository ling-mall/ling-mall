package com.ling.lingcloud.gateway.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ling.lingcloud.gateway.api.domain.GatewayRoute;
import com.ling.lingcloud.gateway.api.dto.GatewayRouteDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 简短描述啦.
 * 详细说说
 * Class created on 2023/10/15 by 钟舒艺
 *
 * @author 钟舒艺
 */
@Repository
public interface GatewayRouteMapper extends BaseMapper<GatewayRoute> {


    /**
     * 级联查询所有路由，用于加载配置
     *
     * @return 所有路由配置
     */
    List<GatewayRouteDTO> listAllGatewayRoute();

}

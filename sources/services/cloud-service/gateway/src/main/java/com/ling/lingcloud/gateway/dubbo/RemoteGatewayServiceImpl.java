package com.ling.lingcloud.gateway.dubbo;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ReUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.ling.lingcloud.common.constants.Regular;
import com.ling.lingcloud.common.mp.domain.PageInfo;
import com.ling.lingcloud.common.mp.domain.PageQuery;
import com.ling.lingcloud.gateway.api.RemoteGatewayService;
import com.ling.lingcloud.gateway.api.domain.GatewayRoute;
import com.ling.lingcloud.gateway.api.dto.GatewayRouteDTO;
import com.ling.lingcloud.gateway.constants.GatewayConstant;
import com.ling.lingcloud.gateway.dynamicroute.DynamicRouteService;
import com.ling.lingcloud.gateway.enums.GatewayRouteItemTypeEnums;
import com.ling.lingcloud.gateway.mapper.GatewayRouteMapper;
import com.ling.lingcloud.gateway.mapper.GatewayRouteItemMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.cloud.gateway.filter.FilterDefinition;
import org.springframework.cloud.gateway.handler.predicate.PredicateDefinition;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

/**
 * 服务实现.
 * Class created on 2023/10/18 by 钟舒艺
 *
 * @author 钟舒艺
 */
@Service
@Slf4j
@DubboService
@RequiredArgsConstructor
public class RemoteGatewayServiceImpl implements RemoteGatewayService {

    private final GatewayRouteMapper gatewayRouteMapper;

    private final GatewayRouteItemMapper gatewayRouteItemMapper;

    private final DynamicRouteService dynamicRouteService;

    @Override
    public PageInfo<GatewayRoute> listPageGatewayRoute(GatewayRouteDTO dto, PageQuery pageQuery) {
        return PageInfo.build(
                gatewayRouteMapper.selectPage(
                        pageQuery.build(),
                        Wrappers.lambdaQuery(BeanUtil.copyProperties(dto, GatewayRoute.class))
                )
        );
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean saveGatewayRoute(GatewayRouteDTO gatewayRouteDTO) {
        GatewayRoute gatewayRoute = BeanUtil.copyProperties(gatewayRouteDTO, GatewayRoute.class);
        boolean isSuccess = gatewayRouteMapper.insert(gatewayRoute) >= 1;
        gatewayRouteDTO.getGatewayRouteItemList().forEach(gatewayRouteItem -> {
            gatewayRouteItem.setRouteId(gatewayRoute.getId());
        });
        isSuccess = gatewayRouteItemMapper.insertBatch(gatewayRouteDTO.getGatewayRouteItemList()) && isSuccess;
        if (isSuccess) {
            loadRouter();
        }
        return isSuccess;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean updateGatewayRouteById(GatewayRouteDTO gatewayRouteDTO) {
        GatewayRoute gatewayRoute = BeanUtil.toBean(gatewayRouteDTO, GatewayRoute.class);
        // 删除所有子项
        Boolean isSuccess = gatewayRouteItemMapper.deleteByRouteId(gatewayRoute.getId());
        isSuccess = gatewayRouteMapper.updateById(gatewayRoute) >= 1 && isSuccess;
        isSuccess = gatewayRouteItemMapper.insertBatch(gatewayRouteDTO.getGatewayRouteItemList()) && isSuccess;
        if (isSuccess) {
            loadRouter();
        }
        return isSuccess;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean removeGatewayRouteById(Long id) {
        Boolean isSuccess = gatewayRouteItemMapper.deleteByRouteId(id);
        isSuccess = gatewayRouteMapper.deleteById(id) >= 1 && isSuccess;
        if (isSuccess) {
            loadRouter();
        }
        return isSuccess;
    }


    @Override
    public void loadRouter() {
        log.info("从数据库加载路由");
        // 清空缓存
        dynamicRouteService.cleanAll();

        gatewayRouteMapper.listAllGatewayRoute().forEach(gatewayRouteDTO -> {

            List<PredicateDefinition> predicates = new ArrayList<>();
            List<FilterDefinition> filters = new ArrayList<>();

            gatewayRouteDTO.getGatewayRouteItemList().forEach(gatewayRouterItem -> {
                        // 谓语
                        if (GatewayRouteItemTypeEnums.PREDICATE.ordinal() == gatewayRouterItem.getType()) {
                            predicates.add(new PredicateDefinition(gatewayRouterItem.getParamKey() + "=" + gatewayRouterItem.getParamValue()));
                        }
                        // 过滤器
                        if (GatewayRouteItemTypeEnums.FILTER.ordinal() == gatewayRouterItem.getType()) {
                            filters.add(new FilterDefinition(gatewayRouterItem.getParamKey() + "=" + gatewayRouterItem.getParamValue()));
                        }
                    }
            );

            URI uri = builderUri(gatewayRouteDTO.getUri());
            RouteDefinition routeDefinition = DynamicRouteService.buildRouteDefinition(gatewayRouteDTO.getRouterId(), uri, predicates, filters);
            dynamicRouteService.addRoute(routeDefinition);
        });
        dynamicRouteService.publish();

    }

    /**
     * @param uriStr uri 字符串
     * @return URI 对象
     */
    private static URI builderUri(String uriStr) {
        // lb
        if (ReUtil.isMatch(GatewayConstant.LB_URI_REGEX, uriStr)) {
            return UriComponentsBuilder.fromUriString(uriStr).build().toUri();
        }
        // http
        if (ReUtil.isMatch(Regular.INTERNET_URL, uriStr)) {
            return UriComponentsBuilder.fromHttpUrl(uriStr).build().toUri();
        }
        // ws 等
        return UriComponentsBuilder.fromUriString(uriStr).build().toUri();
    }
}

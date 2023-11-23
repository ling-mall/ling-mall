package com.ling.lingcloud.gateway.dynamicroute;

import cn.hutool.json.JSONUtil;
import com.ling.lingcloud.common.redis.utils.RedisUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.gateway.route.RouteDefinitionRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

/**
 * 自定义 路由加载 Redis 实现.
 * Class created on 2023/10/15 by 钟舒艺
 *
 * @author 钟舒艺
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class CustomRedisRouteDefinitionRepository implements RouteDefinitionRepository {

    /**
     * 路由信息缓存 键
     */
    public static final String GATEWAY_ROUTES_CACHE_KEY = "gateway:routes";


    @Override
    public Flux<RouteDefinition> getRouteDefinitions() {
        List<RouteDefinition> routeDefinitions = new ArrayList<>();

        log.debug("加载 Gateway 网关路由");
        RedisUtils.<String>getCacheMap(GATEWAY_ROUTES_CACHE_KEY).forEach((k, v) -> {
            routeDefinitions.add(JSONUtil.toBean(v, RouteDefinition.class));
        });
        return Flux.fromIterable(routeDefinitions);
    }

    @Override
    public Mono<Void> save(Mono<RouteDefinition> route) {
        return route.flatMap(routeDefinition -> {
            RedisUtils.setCacheMapValue(GATEWAY_ROUTES_CACHE_KEY, routeDefinition.getId(), JSONUtil.toJsonStr(routeDefinition));
            return Mono.empty();
        });
    }

    @Override
    public Mono<Void> delete(Mono<String> routeId) {
        return routeId.flatMap(id -> {
            RedisUtils.delCacheMapKey(GATEWAY_ROUTES_CACHE_KEY, id);
            return Mono.empty();
        });
    }

    /**
     * 清空缓存
     */
    public void cleanAll() {
        log.info("清除路由缓存...");
        RedisUtils.delCacheList(GATEWAY_ROUTES_CACHE_KEY);
    }
}

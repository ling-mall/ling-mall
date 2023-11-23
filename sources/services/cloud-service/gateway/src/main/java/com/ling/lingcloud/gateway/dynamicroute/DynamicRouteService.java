package com.ling.lingcloud.gateway.dynamicroute;

import jakarta.annotation.Nonnull;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.gateway.event.RefreshRoutesEvent;
import org.springframework.cloud.gateway.filter.FilterDefinition;
import org.springframework.cloud.gateway.handler.predicate.PredicateDefinition;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.List;

/**
 * Gateway 动态路由服务.
 * Class created on 2023/10/15 by 钟舒艺
 *
 * @author 钟舒艺
 */
@Service
@RequiredArgsConstructor
public class DynamicRouteService implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher applicationEventPublisher;

    private final CustomRedisRouteDefinitionRepository customRedisRouteDefinitionRepository;

    @Override
    public void setApplicationEventPublisher(@Nonnull ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    /**
     * 构建路由
     *
     * @param routerId   routerId
     * @param uri        URL
     * @param predicates 谓词
     * @param filters    过滤器
     * @return 路由定义
     */
    public static RouteDefinition buildRouteDefinition(String routerId, URI uri, List<PredicateDefinition> predicates, List<FilterDefinition> filters) {
        RouteDefinition routeDefinition = new RouteDefinition();
        routeDefinition.setId(routerId);
        routeDefinition.setUri(uri);
        routeDefinition.setPredicates(predicates);
        routeDefinition.setFilters(filters);
        return routeDefinition;
    }

    /**
     * 添加路由
     *
     * @param definition 路由定义
     */
    public void addRoute(RouteDefinition definition) {
        customRedisRouteDefinitionRepository.save(Mono.just(definition)).subscribe();
    }

    /**
     * 发布
     */
    public void publish() {
        applicationEventPublisher.publishEvent(new RefreshRoutesEvent(this));
    }

    /**
     * 清空路由
     */
    public void cleanAll() {
        customRedisRouteDefinitionRepository.cleanAll();
    }


}

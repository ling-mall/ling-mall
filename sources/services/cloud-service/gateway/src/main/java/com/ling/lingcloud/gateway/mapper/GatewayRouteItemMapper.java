package com.ling.lingcloud.gateway.mapper;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.ling.lingcloud.common.mp.BaseMapperPlus;
import com.ling.lingcloud.gateway.api.domain.GatewayRouteItem;
import org.springframework.stereotype.Repository;

/**
 * 简短描述啦.
 * 详细说说
 * Class created on 2023/10/15 by 钟舒艺
 *
 * @author 钟舒艺
 */
@Repository
public interface GatewayRouteItemMapper extends BaseMapperPlus<GatewayRouteItem> {

    /**
     * 根据 路由id 删除子项
     *
     * @param id id
     * @return 是否成功
     */
    default Boolean deleteByRouteId(Long id) {
        return delete(Wrappers.<GatewayRouteItem>lambdaQuery().eq(GatewayRouteItem::getRouteId, id)) >= 1;
    }

}

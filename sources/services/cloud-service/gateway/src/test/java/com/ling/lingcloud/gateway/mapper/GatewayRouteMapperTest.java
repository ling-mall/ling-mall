package com.ling.lingcloud.gateway.mapper;

import com.ling.lingcloud.gateway.api.domain.GatewayRouteItem;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * 简短描述啦.
 * 详细说说
 * Class created on 2023/10/16 by 钟舒艺
 *
 * @author 钟舒艺
 */
@SpringBootTest
public class GatewayRouteMapperTest {

    @Autowired
    private GatewayRouteMapper gatewayRouteMapper;

    @Autowired
    private GatewayRouteItemMapper gatewayRouteItemMapper;

    @Test
    void listAllGatewayRoute() {
        System.out.println(gatewayRouteMapper.listAllGatewayRoute().toString());
    }

    @Test
    void insertBatchItem() {
        List<GatewayRouteItem> gatewayRouteItems = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            GatewayRouteItem item = new GatewayRouteItem();
            item.setRouteId(1L);
            item.setType(0);
            item.setParamKey("Path");
            item.setParamValue("/demo/**");
            item.setStatus(1);
            item.setCreateBy(1L);
            item.setUpdateBy(1L);
            item.setUpdateTime(LocalDateTime.now());
            item.setCreateTime(LocalDateTime.now());
            gatewayRouteItems.add(item);
        }

        gatewayRouteItemMapper.insertBatch(gatewayRouteItems);


    }


}

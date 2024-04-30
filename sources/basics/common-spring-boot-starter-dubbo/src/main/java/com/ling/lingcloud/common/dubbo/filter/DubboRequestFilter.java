package com.ling.lingcloud.common.dubbo.filter;

import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.common.constants.CommonConstants;
import org.apache.dubbo.common.extension.Activate;
import org.apache.dubbo.rpc.*;
import org.apache.dubbo.rpc.service.GenericService;

/**
 * dubbo日志过滤器.
 * Class created on 2023/8/12 by 钟舒艺
 *
 * @author 钟舒艺
 */
@Slf4j
@Activate(group = {CommonConstants.PROVIDER, CommonConstants.CONSUMER}, order = Integer.MAX_VALUE)
public class DubboRequestFilter implements Filter {

    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {

        String client = CommonConstants.PROVIDER;
        if (RpcContext.getServiceContext().isConsumerSide()) {
            client = CommonConstants.CONSUMER;
        }
        StringBuilder baseLog = new StringBuilder()
                .append("Client[").append(client).append("],")
                .append("InterfaceName=[").append(invocation.getInvoker().getInterface().getSimpleName()).append("],")
                .append("MethodName=[").append(invocation.getMethodName()).append("]");

        long startTime = System.currentTimeMillis();
        // 执行接口调用逻辑
        Result result = invoker.invoke(invocation);
        // 调用耗时
        long elapsed = System.currentTimeMillis() - startTime;
        // 如果发生异常 则打印异常日志
        if (result.hasException() && invoker.getInterface().equals(GenericService.class)) {
            log.error("DUBBO - 服务异常: {},Exception={}", baseLog, result.getException().getMessage());
        } else {
            log.info(
                    "DUBBO - 服务响应: {},SpendTime=[{}ms],Response={}",
                    baseLog, elapsed, JSONUtil.toJsonStr(new Object[]{result.getValue()})
            );
        }
        return result;
    }
}

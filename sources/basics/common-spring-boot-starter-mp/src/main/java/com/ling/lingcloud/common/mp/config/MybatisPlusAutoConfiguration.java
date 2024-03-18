package com.ling.lingcloud.common.mp.config;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.BlockAttackInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * mybatis plus 自定义自动配置.
 * <p>
 * {@link AutoConfiguration} 开启自动配置 <br>
 * </p>
 * <p>
 * {@link EnableTransactionManagement}(proxyTargetClass  = true)
 * 注解是 Spring 框架中用于启用声明式事务管理的注解之一。通过使用该注解，可以将一个类标记为启用事务处理，同时告知 Spring 在哪些方法中应该开启事务。
 * </p>
 * <p>
 * {@link MapperScan} 读取配置文件中的 mybatis-plus.mapperPackage 作为扫描包的路径
 * </P>
 * Class created on 2023/7/1 by 钟舒艺
 *
 * @author 钟舒艺
 */
@Slf4j
@AutoConfiguration
@EnableTransactionManagement(proxyTargetClass = true)
@MapperScan("${mybatis-plus.mapperPackage}")
public class MybatisPlusAutoConfiguration {

    /**
     * 插件配置.
     *
     * @return 配置好拦截器
     */
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        log.info("mybatisPlus 自动配置加载");
        final MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        // 分页插件
        interceptor.addInnerInterceptor(paginationInnerInterceptor());
        // 乐观锁插件
        interceptor.addInnerInterceptor(optimisticLockerInnerInterceptor());
        // 阻断插件
        interceptor.addInnerInterceptor(blockAttackInnerInterceptor());
        return interceptor;
    }


    /**
     * 乐观锁插件.
     * <a href="https://baomidou.com/pages/0d93c0/#optimisticlockerinnerinterceptor">官方文档</a>
     *
     * @return 乐观锁插件配置
     */
    private OptimisticLockerInnerInterceptor optimisticLockerInnerInterceptor() {
        return new OptimisticLockerInnerInterceptor();
    }

    /**
     * 防全表更新与删除插件，如果是对全表的删除或更新操作，就会终止该操作.
     * <a href="https://baomidou.com/pages/c571bc/#blockattackinnerinterceptor">官方文档</a>
     *
     * @return 全表操作拦截器
     */
    private BlockAttackInnerInterceptor blockAttackInnerInterceptor() {
        return new BlockAttackInnerInterceptor();
    }

    /**
     * 分页插件，自动识别数据库类型.
     * <a href="https://baomidou.com/pages/97710a/#paginationinnerinterceptor">官方文档</a>
     *
     * @return 分页插件配置
     */
    private PaginationInnerInterceptor paginationInnerInterceptor() {
        final PaginationInnerInterceptor paginationInnerInterceptor = new PaginationInnerInterceptor();
        // 设置最大单页限制数量，默认 500 条，-1 不受限制
        paginationInnerInterceptor.setMaxLimit(-1L);
        // 分页合理化
        paginationInnerInterceptor.setOverflow(true);
        return paginationInnerInterceptor;
    }
}

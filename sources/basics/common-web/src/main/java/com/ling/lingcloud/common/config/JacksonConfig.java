package com.ling.lingcloud.common.config;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.TimeZone;

import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer;
import com.ling.lingcloud.common.jackson.BigNumberSerializer;

import cn.hutool.core.date.DatePattern;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * Jackson 配置类 for RuoYi Plus.
 *
 * @author 钟舒艺
 **/
@Slf4j
@AutoConfiguration(before = JacksonAutoConfiguration.class)
public class JacksonConfig {
    /**
     * 编辑器
     * 自定义序列化.
     *
     * @return {@link Jackson2ObjectMapperBuilderCustomizer}
     */
    @Bean
    public Jackson2ObjectMapperBuilderCustomizer customizer() {
        return builder -> {
            // 全局配置序列化返回 JSON 处理
            JavaTimeModule javaTimeModule = new JavaTimeModule();
            // 处理超出 JS Number 范围的 Long 与 BigInteger
            javaTimeModule.addSerializer(Long.class, BigNumberSerializer.BIG_NUMBER_SERIALIZER_INSTANCE);
            javaTimeModule.addSerializer(Long.TYPE, BigNumberSerializer.BIG_NUMBER_SERIALIZER_INSTANCE);
            javaTimeModule.addSerializer(BigInteger.class, BigNumberSerializer.BIG_NUMBER_SERIALIZER_INSTANCE);
            // BigDecimal 无论大小直接转为字符串
            javaTimeModule.addSerializer(BigDecimal.class, ToStringSerializer.instance);
            // 处理日期
            javaTimeModule.addSerializer(
                    LocalDateTime.class, new LocalDateTimeSerializer(DatePattern.NORM_DATETIME_FORMATTER)
            );

            javaTimeModule.addDeserializer(
                    LocalDateTime.class,
                    new LocalDateTimeDeserializer(DatePattern.NORM_DATETIME_FORMATTER)
            );

            javaTimeModule.addSerializer(LocalDate.class, new LocalDateSerializer(DatePattern.NORM_DATE_FORMATTER));
            javaTimeModule.addDeserializer(LocalDate.class, new LocalDateDeserializer(DatePattern.NORM_DATE_FORMATTER));
            javaTimeModule.addSerializer(LocalTime.class, new LocalTimeSerializer(DatePattern.NORM_TIME_FORMATTER));
            javaTimeModule.addDeserializer(LocalTime.class, new LocalTimeDeserializer(DatePattern.NORM_TIME_FORMATTER));
            builder.modules(javaTimeModule);
            builder.timeZone(TimeZone.getDefault());
            log.info("初始化 jackson 配置");
        };
    }
}

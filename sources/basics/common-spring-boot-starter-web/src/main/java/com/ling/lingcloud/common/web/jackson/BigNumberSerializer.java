package com.ling.lingcloud.common.web.jackson;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.fasterxml.jackson.databind.ser.std.NumberSerializer;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

/**
 * 超出 JS 最大最小值 处理.
 *
 * @author 钟舒艺 for RuoYi Plus.
 */
@JacksonStdImpl
@Slf4j
public class BigNumberSerializer extends NumberSerializer {

    /**
     * 提供实例.
     */
    public static final BigNumberSerializer BIG_NUMBER_SERIALIZER_INSTANCE = new BigNumberSerializer(Number.class);
    /**
     * 根据 JS Number.MAX_SAFE_INTEGER 与 Number.MIN_SAFE_INTEGER 得来
     */
    private static final long MAX_SAFE_INTEGER = 9007199254740991L;
    private static final long MIN_SAFE_INTEGER = -9007199254740991L;

    public BigNumberSerializer(Class<? extends Number> rawType) {
        super(rawType);
    }

    @Override
    public void serialize(Number value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        // 超出范围 序列化为字符串
        if (value.longValue() > MIN_SAFE_INTEGER && value.longValue() < MAX_SAFE_INTEGER) {
            super.serialize(value, gen, provider);
        } else {
            gen.writeString(value.toString());
        }
    }
}

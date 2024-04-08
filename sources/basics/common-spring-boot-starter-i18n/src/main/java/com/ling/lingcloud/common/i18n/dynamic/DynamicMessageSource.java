package com.ling.lingcloud.common.i18n.dynamic;

import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.support.AbstractMessageSource;
import org.springframework.lang.Nullable;

import java.text.MessageFormat;
import java.util.Locale;

/**
 * 动态获取的 MessageSource，比如从数据库 或者 redis 中获取 message 信息
 *
 * @author hccake
 */
@RequiredArgsConstructor
public class DynamicMessageSource extends AbstractMessageSource {

    public static final String DYNAMIC_MESSAGE_SOURCE_BEAN_NAME = "dynamicMessageSource";

    private final I18nMessageProvider i18nMessageProvider;

    @Override
    @Nullable
    protected MessageFormat resolveCode(@NotNull String code, @NotNull Locale locale) {
        I18nMessage i18nMessage = i18nMessageProvider.getI18nMessage(code, locale);
        if (i18nMessage != null) {
            return createMessageFormat(i18nMessage.getMessage(), locale);
        }
        return null;
    }

}

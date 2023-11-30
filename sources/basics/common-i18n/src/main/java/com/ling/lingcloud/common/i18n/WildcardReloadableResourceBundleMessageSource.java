/*
 * Copyright 2023 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.ling.lingcloud.common.i18n;

import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * 通配符支持的 ResourceBundleMessageSource，方便读取多个 jar 包中的资源文件.
 * <p>
 * 默认的 ReloadableResourceBundleMessageSource，对于多个同名文件，只会读取找到的第一个。
 *
 * @author Nicolás Miranda
 * @author hccake
 * @see <a href=
 * "https://stackoverflow.com/questions/3888832/does-spring-messagesource-support-multiple-class-path">Does
 * Spring MessageSource Support Multiple Class Path?</a>
 */
@Slf4j
public class WildcardReloadableResourceBundleMessageSource extends ReloadableResourceBundleMessageSource {

    private static final String PROPERTIES_SUFFIX = ".properties";

    private final PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();

    /**
     * 获取文件名列表，过滤掉有通配符的 basename
     *
     * @param basename the basename of the bundle
     * @param locale   the locale
     * @return the List of filenames to check
     * @see #setFallbackToSystemLocale
     * @see #calculateFilenamesForLocale
     */
    @NotNull
    @Override
    protected List<String> calculateAllFilenames(@NotNull String basename, @NotNull Locale locale) {
        // 父类默认的方法会将 basename 也放入 filenames 列表
        List<String> filenames = super.calculateAllFilenames(basename, locale);
        // 当 basename 有匹配符时，从 filenames 中移除，否则扫描文件将抛出 Illegal char <*> 的异常
        if (basename.contains("*")) {
            filenames.remove(basename);
        }
        return filenames;
    }

    /**
     * 根据配置中的 basename，获取到匹配的资源文件名，扩展通配符写法，当国际化的时候首先执行此方法
     *
     * @param basename 配置中的 basename
     * @param locale   需要匹配的语言
     * @return 匹配的资源文件名集合
     */
    @NotNull
    @Override
    protected List<String> calculateFilenamesForLocale(@NotNull String basename, @NotNull Locale locale) {

        log.error("basename: {}", basename);
        // 支持 basename 用 . 表示文件层级
        basename = basename.replace(".", "/");

        // 资源文件名
        List<String> fileNames = new ArrayList<>();
        // 获取到待匹配的国际化信息文件名集合
        List<String> matchFilenames = super.calculateFilenamesForLocale(basename, locale);
        for (String matchFilename : matchFilenames) {
            try {
                Resource[] resources = resolver.getResources("classpath*:" + matchFilename + PROPERTIES_SUFFIX);
                for (Resource resource : resources) {
                    String sourcePath = resource.getURI().toString().replace(PROPERTIES_SUFFIX, "");
                    fileNames.add(sourcePath);
                }
            } catch (IOException ex) {
                log.error("读取国际化信息文件异常", ex);
            }
        }
        return fileNames;
    }

}

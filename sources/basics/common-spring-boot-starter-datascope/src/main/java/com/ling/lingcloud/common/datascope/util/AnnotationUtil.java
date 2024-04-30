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
package com.ling.lingcloud.common.datascope.util;

import lombok.experimental.UtilityClass;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @author Hccake 2021/1/27
 */
@UtilityClass
public final class AnnotationUtil {

    /**
     * 获取数据权限注解 优先获取方法上的注解，再获取类上的注解
     *
     * @param mappedStatementId 类名.方法名
     * @return 数据权限注解
     */
    public <A extends Annotation> A findAnnotationByMappedStatementId(String mappedStatementId, Class<A> aClass) {
        if (mappedStatementId == null || "".equals(mappedStatementId)) {
            return null;
        }
        // 1.得到类路径和方法路径
        int lastIndexOfDot = mappedStatementId.lastIndexOf(".");
        if (lastIndexOfDot < 0) {
            return null;
        }
        String className = mappedStatementId.substring(0, lastIndexOfDot);
        String methodName = mappedStatementId.substring(lastIndexOfDot + 1);
        if ("".equals(className) || "".equals(methodName)) {
            return null;
        }

        // 2.字节码
        Class<?> clazz = null;
        try {
            clazz = Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        if (clazz == null) {
            return null;
        }

        A annotation = null;
        // 3.得到方法上的注解
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            String name = method.getName();
            if (methodName.equals(name)) {
                annotation = method.getAnnotation(aClass);
                break;
            }
        }
        if (annotation == null) {
            annotation = clazz.getAnnotation(aClass);
        }
        return annotation;
    }

}

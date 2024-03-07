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

import java.util.Collection;

/**
 * Collection 工具类
 *
 * @author hccake
 */
@UtilityClass
public final class CollectionUtils {

	/**
	 * 校验集合是否为空
	 * @param collection 集合
	 * @return boolean
	 */
	public boolean isEmpty(Collection<?> collection) {
		return collection == null || collection.isEmpty();
	}

	/**
	 * 校验集合是否不为空
	 * @param collection 集合
	 * @return boolean
	 */
	public boolean isNotEmpty(Collection<?> collection) {
		return !isEmpty(collection);
	}

}

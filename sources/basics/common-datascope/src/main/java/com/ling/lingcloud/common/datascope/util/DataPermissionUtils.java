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

import com.ling.lingcloud.common.datascope.function.Action;
import com.ling.lingcloud.common.datascope.function.ResultAction;
import com.ling.lingcloud.common.datascope.handler.DataPermissionRule;
import com.ling.lingcloud.common.datascope.holder.DataPermissionRuleHolder;
import lombok.experimental.UtilityClass;

/**
 * @author hccake
 */
@UtilityClass
public final class DataPermissionUtils {

	/**
	 * 使用指定的数据权限执行任务
	 * @param action 待执行的动作
	 */
	public void executeAndIgnoreAll(Action action) {
		DataPermissionRule ignoreAll = new DataPermissionRule(true);
		executeWithDataPermissionRule(ignoreAll, action);
	}

	/**
	 * 使用指定的数据权限执行任务
	 * @param resultAction 待执行的动作
	 */
	public <T> T executeAndIgnoreAll(ResultAction<T> resultAction) {
		DataPermissionRule ignoreAll = new DataPermissionRule(true);
		return executeWithDataPermissionRule(ignoreAll, resultAction);
	}

	/**
	 * 使用指定的数据权限执行任务
	 * @param dataPermissionRule 当前任务执行时使用的数据权限规则
	 * @param action 待执行的动作
	 */
	public void executeWithDataPermissionRule(DataPermissionRule dataPermissionRule, Action action) {
		DataPermissionRuleHolder.push(dataPermissionRule);
		try {
			action.execute();
		}
		finally {
			DataPermissionRuleHolder.poll();
		}
	}

	/**
	 * 使用指定的数据权限执行任务
	 * @param dataPermissionRule 当前任务执行时使用的数据权限规则
	 * @param resultAction 待执行的动作
	 */
	public <T> T executeWithDataPermissionRule(DataPermissionRule dataPermissionRule, ResultAction<T> resultAction) {
		DataPermissionRuleHolder.push(dataPermissionRule);
		try {
			return resultAction.execute();
		}
		finally {
			DataPermissionRuleHolder.poll();
		}
	}

}

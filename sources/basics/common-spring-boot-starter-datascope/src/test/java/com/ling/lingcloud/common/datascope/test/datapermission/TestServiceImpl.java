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
package com.ling.lingcloud.common.datascope.test.datapermission;

import com.ling.lingcloud.common.datascope.annotation.DataPermission;
import com.ling.lingcloud.common.datascope.handler.DataPermissionRule;
import com.ling.lingcloud.common.datascope.holder.DataPermissionRuleHolder;
import org.springframework.stereotype.Component;

/**
 * @author hccake
 */
@Component
@DataPermission(excludeResources = {"class"})
public class TestServiceImpl implements TestService {

    @Override
    @DataPermission(excludeResources = {"order"})
    public DataPermissionRule methodA() {
        return DataPermissionRuleHolder.peek();
    }

    @Override
    public DataPermissionRule methodB() {
        return DataPermissionRuleHolder.peek();
    }

    @Override
    public DataPermissionRule methodC() {
        return DataPermissionRuleHolder.peek();
    }

}

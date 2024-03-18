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
package com.ling.lingcloud.common.datascope.test.datarule.service;

import com.ling.lingcloud.common.datascope.annotation.DataPermission;
import com.ling.lingcloud.common.datascope.test.datarule.datascope.ClassDataScope;
import com.ling.lingcloud.common.datascope.test.datarule.datascope.SchoolDataScope;
import com.ling.lingcloud.common.datascope.test.datarule.entity.Student;
import com.ling.lingcloud.common.datascope.test.datarule.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hccake
 */
@Service
public class StudentService {

	@Autowired
	private StudentMapper studentMapper;

	public List<Student> listStudent() {
		return studentMapper.listStudent();
	}

	@DataPermission(includeResources = ClassDataScope.RESOURCE_NAME)
	public List<Student> listStudentOnlyFilterClass() {
		return studentMapper.listStudent();
	}

	@DataPermission(includeResources = SchoolDataScope.RESOURCE_NAME)
	public List<Student> listStudentOnlyFilterSchool() {
		return studentMapper.listStudent();
	}

	@DataPermission(ignore = true)
	public List<Student> listStudentWithoutDataPermission() {
		return studentMapper.listStudent();
	}

}

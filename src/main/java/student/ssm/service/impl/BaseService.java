package student.ssm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import student.ssm.mapper.SclassMapper;
import student.ssm.mapper.StudentMapper;
import student.ssm.mapper.TeacherMapper;

public abstract class BaseService {

	@Autowired
	protected StudentMapper studentMapper;
	@Autowired
	protected TeacherMapper teacherMapper;
	@Autowired
	protected SclassMapper sclassMapper;
}

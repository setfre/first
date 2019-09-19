package student.ssm.mapper;


import java.util.List;

import student.ssm.pojo.Student;


public interface StudentMapper extends BaseMapper<Student>{

	List<Student> retrieveAllGrade();

	Integer retrieveSize();
}

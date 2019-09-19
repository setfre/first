package student.ssm.service;

import java.util.List;

import student.ssm.pojo.Pagination;
import student.ssm.pojo.Sclass;
import student.ssm.pojo.Student;
import student.ssm.pojo.Teacher;

public interface SysParamService {

	List<Student> retrieveAllGrade();

	String createStudent(Student student);
	
	String deleteStudent(Student student);
	
	String updateStudent(Student student);

	String createTeacher(Teacher teacher); 
	
	public List<Sclass> retrieveAllSclass();

	void batchIn();

	List<Student> retrieveAllStudent();

	Pagination<Student> paginationStudent(Integer currentIndex);
	
	String updateShowSize(Integer showSize);
}

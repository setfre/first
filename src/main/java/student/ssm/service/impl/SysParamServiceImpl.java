package student.ssm.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import student.ssm.mapper.StudentMapper;
import student.ssm.mapper.TeacherMapper;
import student.ssm.pojo.Sclass;
import student.ssm.pojo.Student;
import student.ssm.pojo.Teacher;
import student.ssm.service.SysParamService;

@Service
public class SysParamServiceImpl extends BaseService implements SysParamService{

	
	private String str="abcdefghijklmnopqrstuvwxyz";
	private String[] sex= {"ÄÐ","Å®"};
	public void batchIn() {
		batchInTeacher();
		batchInSclass();
	}
	public void batchInStudent() {
		for(int i = 0;i < 10;i++) {
			Student bean = new Student();
			StringBuffer sb = new StringBuffer();
			for(int j = 0;j<5;j++) {
				sb.append(str.charAt((int) (Math.random()*str.length())));
			}
			bean.setName(sb.toString());
			bean.setAge((int) (Math.random()*50+10));
			bean.setBirth(new Date());
			bean.setSex("ÄÐ");
			System.out.println(bean);
			studentMapper.create(bean);
		}
	}
	private void batchInSclass() {
		for(int i = 0;i < 10;i++) {
			Sclass bean = new Sclass();
			StringBuffer sb = new StringBuffer();
			for(int j = 0;j<5;j++) {
				sb.append(str.charAt((int) (Math.random()*str.length())));
			}
			bean.setName(sb.toString());
			bean.setAddress("123213213213");
			System.out.println(bean);
			sclassMapper.create(bean);
		}
	}
	private void batchInTeacher() {
		for(int i = 0;i < 10;i++) {
			Teacher bean = new Teacher();
			StringBuffer sb = new StringBuffer();
			for(int j = 0;j<5;j++) {
				sb.append(str.charAt((int) (Math.random()*str.length())));
			}
			bean.setName(sb.toString());
			bean.setTel("123213213213");
			bean.setWork(new Date());
			bean.setSex("ÄÐ");
			System.out.println(bean);
			teacherMapper.create(bean);
		}
	}
	@Override
	public List<Student> retrieveAllGrade() {
		// TODO Auto-generated method stub
		return studentMapper.retrieveAllGrade();
	}

	@Override
	public String createStudent(Student student) {
		if(student == null) {
			return "error";
		}
		studentMapper.create(student);
		return "success";
	}

	@Override
	public String createTeacher(Teacher teacher) {
		if(teacher == null) {
			return "error";
		}
		//teacherMapper.create(teacher);
		return "success";
	}

	@Override
	public String deleteStudent(Student student) {
		if(student == null) {
			return "error";
		}
		studentMapper.delete(student);
		return "success";
	}

	@Override
	public String updateStudent(Student student) {
		if(student == null) {
			return "error";
		}
		studentMapper.update(student);
		return "success";
	} 

	
}

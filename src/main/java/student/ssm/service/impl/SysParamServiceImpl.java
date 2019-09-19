package student.ssm.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import student.ssm.mapper.StudentMapper;
import student.ssm.mapper.TeacherMapper;
import student.ssm.pojo.Pagination;
import student.ssm.pojo.Sclass;
import student.ssm.pojo.Student;
import student.ssm.pojo.Teacher;
import student.ssm.service.SysParamService;

@Service
public class SysParamServiceImpl extends BaseService implements SysParamService{

	
	private String str="abcdefghijklmnopqrstuvwxyz";
	private String[] sex= {"男","女"};
	Pagination<Student> students = new Pagination<Student>();
	
	@PostConstruct
	public void init() {
		students.setRecordShowSize(10);
	}
	
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
			bean.setSex("男");
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
			bean.setSex("男");
			System.out.println(bean);
			teacherMapper.create(bean);
		}
	}
	/**
	 * 查询所有学生成绩
	 */
	@Override
	public List<Student> retrieveAllGrade() {
		// TODO Auto-generated method stub
		return studentMapper.retrieveAllGrade();
	}
	/**
	 * 查询所有班级
	 */
	public List<Sclass> retrieveAllSclass(){
		return sclassMapper.retrieveAll();
	}
	/**
	 * 查询所有学生
	 */
	@Override
	public List<Student> retrieveAllStudent() {
		// TODO Auto-generated method stub
		return studentMapper.retrieveAll();
	}
	/**
	 * 增加学生信息
	 */
	@Override
	public String createStudent(Student student) {
		if(student == null) {
			return "error";
		}
		studentMapper.create(student);
		return "success";
	}
	/**
	 * 删除学生信息
	 */
	@Override
	public String deleteStudent(Student student) {
		if(student == null) {
			return "error";
		}
		studentMapper.delete(student);
		return "success";
	}
	/**
	 * 更新学生信息
	 */
	@Override
	public String updateStudent(Student student) {
		if(student == null) {
			return "error";
		}
		studentMapper.update(student);
		return "success";
	} 
	/**
	 * 增加教师
	 */
	@Override
	public String createTeacher(Teacher teacher) {
		if(teacher == null) {
			return "error";
		}
		//teacherMapper.create(teacher);
		return "success";
	}
	/**
	 * 分页显示
	 */
	@Override
	public Pagination<Student> paginationStudent(Integer currentIndex) {
		// TODO Auto-generated method stub
		
		students.setCurrentIndex(currentIndex);
		students.setRecordSize(studentMapper.retrieveSize());
		students.setBean(studentMapper.pagination(students.getIndex()));
		return students;
	}
	/**
	 * 更新页面显示记录数
	 */
	@Override
	public String updateShowSize(Integer showSize) {
		if(showSize <0) {
			return "不行！！";
		}
		students.setRecordShowSize(showSize);
		return "可以";
	}
	
	
}

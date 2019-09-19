package student.ssm.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import student.ssm.pojo.Pagination;
import student.ssm.pojo.Sclass;
import student.ssm.pojo.Student;
import student.ssm.pojo.Teacher;
import student.ssm.service.SysParamService;

@Controller
@RequestMapping("sysparam")
public class SysParamController {

	@Autowired
	private SysParamService sysParamService;
	
	@RequestMapping("retrieveAllGrade")
	@ResponseBody
	public List<Student> retrieveAllGrade(){
		List<Student> students = sysParamService.retrieveAllGrade();
		System.out.println(students);
		return students;
	}
	
	@RequestMapping("batchInStudent")
	public void batchInStudent() {
		sysParamService.batchIn();
	}
	
	@RequestMapping("retrieveAllSclass")
	@ResponseBody
	public List<Sclass> retrieveAllSclass() {
		List<Sclass> sclasses = sysParamService.retrieveAllSclass();
		System.out.println(sclasses);
		return sclasses;
	}
	
	@RequestMapping("retrieveAllStudent")
	@ResponseBody
	public List<Student> retrieveAllStudent(){
		return sysParamService.retrieveAllStudent();
	}
	
	@RequestMapping("paginationStudent")
	@ResponseBody
	public Pagination<Student> paginationStudent(
			@RequestParam(value = "index",required = true)Integer currentIndex){
		return sysParamService.paginationStudent(currentIndex);
	}
	
	@RequestMapping("updateShowSize")
	@ResponseBody
	public String updateShowSize(
			@RequestParam(value = "showSize",required = true)Integer showSize) {
		return sysParamService.updateShowSize(showSize);
	}
	
	@RequestMapping("createStudent")
	@ResponseBody
	public String createStudent(Student student) {
		return sysParamService.createStudent(student); 
	}
	
	@RequestMapping("createTeacher")
	@ResponseBody
	public String createTeacher(Teacher teacher) {
		return sysParamService.createTeacher(teacher);
	}
	
	@InitBinder
	protected void initBinder(HttpServletRequest request,ServletRequestDataBinder binder) throws Exception{
		/*springmvc接收data必须重写initBinder*/
		binder.registerCustomEditor(
			Date.class,
			new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
	}
}

package student.ssm.pojo;

import java.util.List;

public class Sclass {

	private Integer id;
	private String name;
	private String address;
	private Teacher teacher;
	private List<Student> students;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	@Override
	public String toString() {
		return "Sclass [id=" + id + ", name=" + name + ", address=" + address + ", teacher=" + teacher + ", students="
				+ students + "]";
	}
	
}

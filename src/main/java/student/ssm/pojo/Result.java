package student.ssm.pojo;

import java.io.Serializable;
import java.util.Date;

public class Result  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer courseId;
	private Integer studentId;
	private float grade;
	private Date time;//øº ‘ ±º‰
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCourseId() {
		return courseId;
	}
	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}
	public Integer getStudentId() {
		return studentId;
	}
	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public float getGrade() {
		return grade;
	}
	public void setGrade(float grade) {
		this.grade = grade;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "Result [id=" + id + ", courseId=" + courseId + ", studentId=" + studentId + ", grade=" + grade
				+ ", time=" + time + "]";
	}
	
}

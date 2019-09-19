package student.ssm.pojo;

import java.io.Serializable;
import java.util.Date;

public class Teaching  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer courseId;
	private Integer teacherId;
	private Integer sclassId;
	private Date time;//ÉÏ¿ÎÊ±¼ä
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
	public Integer getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}
	public Integer getSclassId() {
		return sclassId;
	}
	public void setSclassId(Integer sclassId) {
		this.sclassId = sclassId;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	
}

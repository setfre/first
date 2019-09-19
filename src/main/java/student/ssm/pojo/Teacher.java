package student.ssm.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Teacher  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private String sex;
	private String tel;
	private Date work;	//入职年份
	private Sclass sclass;
	private List<Teaching> teachings = new ArrayList<Teaching>();
	public List<Teaching> getTeachings() {
		return teachings;
	}
	public void setTeachings(List<Teaching> teachings) {
		this.teachings = teachings;
	}

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
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public Date getWork() {
		return work;
	}
	public void setWork(Date work) {
		this.work = work;
	}
	public Sclass getSclass() {
		return sclass;
	}
	public void setSclass(Sclass sclass) {
		this.sclass = sclass;
	}
	
}

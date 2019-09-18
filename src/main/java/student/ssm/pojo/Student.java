package student.ssm.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Student {

	private Integer id;
	private String name;
	private String sex;
	private Integer age;
	private Date birth;
	private Sclass sclass;
	private List<Result> results = new ArrayList<Result>();
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

	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public List<Result> getResults() {
		return results;
	}
	public void setResults(List<Result> results) {
		this.results = results;
	}
	public Sclass getSclass() {
		return sclass;
	}
	public void setSclass(Sclass sclass) {
		this.sclass = sclass;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", sex=" + sex + ", age=" + age + ", birth=" + birth
				+ ", sclass=" + sclass + ", results=" + results + "]";
	}
	
}

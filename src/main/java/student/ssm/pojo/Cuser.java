package student.ssm.pojo;

public class Cuser {

	private Integer id;
	private Integer roleId;
	private String usercode;
	private String password;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public String getUsercode() {
		return usercode;
	}
	public void setUsercode(String usercode) {
		this.usercode = usercode;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Cuser [id=" + id + ", roleId=" + roleId + ", usercode=" + usercode + ", password=" + password + "]";
	}
	
	
}

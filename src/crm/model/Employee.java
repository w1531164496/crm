package crm.model;

public class Employee {
	

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", telephone=" + telephone + ", Address=" + Address
				+ ", Nativeplace=" + Nativeplace + ", Password=" + Password + ", Gender=" + Gender + ", Username="
				+ Username + ", Remarks=" + Remarks + ", nickname=" + nickname + ", role=" + role + ", headportrait="
				+ headportrait + ", Schoolid=" + Schoolid + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getname() {
		return name;
	}
	public void setname(String name) {
		this.name = name;
	}
	public String gettelephone() {
		return telephone;
	}
	public void settelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getNativeplace() {
		return Nativeplace;
	}
	public void setNativeplace(String nativeplace) {
		Nativeplace = nativeplace;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getRemarks() {
		return Remarks;
	}
	public void setRemarks(String remarks) {
		Remarks = remarks;
	}
	private int id;
	private String name;
	private String telephone;
	private String Address;
	private String Nativeplace;
	private String Password;
	private String Gender;
	private String Username;
	private String Remarks;
	private String nickname;
	private String role;
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getHeadportrait() {
		return headportrait;
	}
	public void setHeadportrait(String headportrait) {
		this.headportrait = headportrait;
	}
	public int getSchoolid() {
		return Schoolid;
	}
	public void setSchoolid(int Schoolid) {
		this.Schoolid = Schoolid;
	}
	private String headportrait;
	private int Schoolid;
	


}

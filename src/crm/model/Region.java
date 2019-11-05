package crm.model;

public class Region {
	
		
	
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	public String getSchoolintroduce() {
		return Schoolintroduce;
	}
	public void setSchoolintroduce(String schoolintroduce) {
		Schoolintroduce = schoolintroduce;
	}
	public String getSchoolhead() {
		return Schoolhead;
	}
	public void setSchoolhead(String schoolhead) {
		Schoolhead = schoolhead;
	}
	public String getTelephone() {
		return Telephone;
	}
	public void setTelephone(String telephone) {
		Telephone = telephone;
	}
	private String schoolName; 
	@Override
	public String toString() {
		return "Region [id=" + id + ", schoolName=" + schoolName + ", Schoolintroduce=" + Schoolintroduce
				+ ", Schoolhead=" + Schoolhead + ", Telephone=" + Telephone + "]";
	}
	private String Schoolintroduce;
	private String Schoolhead;
	private String Telephone;
	
	

	
}

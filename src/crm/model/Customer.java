package crm.model;

public class Customer {
	private int id;
	
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", telephone=" + telephone + ", status=" + status + ", record="
				+ record + ", Region=" + Region + ", Employeeid=" + Employeeid + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getRecord() {
		return record;
	}
	public void setRecord(String record) {
		this.record = record;
	}
	public String getRegion() {
		return Region;
	}
	public void setRegion(String region) {
		Region = region;
	}
	private String name;
	private String telephone;
	private String status;
	private String record;
	private String Region;
	
	private int Employeeid;
	public int getEmployeeid() {
		return Employeeid;
	}
	public void setEmployeeid(int Employeeid) {
		this.Employeeid = Employeeid;
	}
	
	
}

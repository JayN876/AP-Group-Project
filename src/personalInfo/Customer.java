package personalInfo;

public class Customer {
	
	private String cusID;
	private String fName;
	private String lName;
	private String company;
	private String emergencyNo;
	private Address address;
	private String telephone;
	private String email;
	private String status;
	
	
	public Customer(String cusID,String fName,String lName,String emergencyNo, Address address,
			String telephone, String email, String company,String status) {
		this.cusID = cusID;
		address.setId(cusID);
		this.fName=fName;
		this.lName=lName;
		this.emergencyNo = emergencyNo;
		this.address = address;
		this.telephone = telephone;
		this.email = email;
		this.status = status;
		this.company = company;
	}
	
	public Customer(Customer customer) {
		this.cusID = customer.cusID;
		this.fName = customer.fName;
		this.lName = customer.lName;
		this.company = customer.company;	
		this.emergencyNo = customer.emergencyNo;
		this.address = customer.address;
		this.telephone = customer.telephone;
		this.email = customer.email;
		this.status = customer.status;
		
	}
	
	public Customer() {
		this.cusID = "";
		this.fName = "";
		this.lName = "";
		this.company = "";
		this.emergencyNo = "";
		this.address = new Address();
		this.telephone = "";
		this.email = "";
		this.status = "";
		
	}
	
	public String getCusID() {
		return cusID;
	}
	public void setCusID(String cusID) {
		this.cusID = cusID;
	}
	public String getEmergencyNo() {
		return emergencyNo;
	}
	public void setEmergencyNo(String emergencyNo) {
		this.emergencyNo = emergencyNo;
	}
	public Address getAddress() {
		return address;
	}
	
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}
	


	@Override
	public String toString() {
		return "Customer [cusID=" + cusID + ", fName=" + fName + ", lName=" + lName + ", company=" + company
				+ ", emergency No=" + emergencyNo + "address = " + address
				+ ", telephone=" + telephone + ", email=" + email + ", status=" + status + "]";
	}
	
	
	
	
}

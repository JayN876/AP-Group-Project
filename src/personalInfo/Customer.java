package personalInfo;

public class Customer {
	
	private String cusID;
	private String fName;
	private String lName;
	private String company;
	private String contactPerson;
	private Address address1;
	private Address address2;
	private String telephone;
	private String email;
	private String status;
	
	
	public Customer(String cusID,String fName,String lName,String contactPerson, Address address1, Address address2,
			String telephone, String email, String company,String status) {
		this.cusID = cusID;
		address1.setId(cusID);
		address2.setId(cusID);
		this.fName=fName;
		this.lName=lName;
		this.contactPerson = contactPerson;
		this.address1 = address1;
		this.address2 = address2;
		this.telephone = telephone;
		this.email = email;
		this.status = status;
		this.company = company;
	}
	
	public Customer(Customer customer) {
		this.cusID = customer.cusID;
		this.contactPerson = customer.contactPerson;
		this.address1 = customer.address1;
		this.address2 = customer.address2;
		this.telephone = customer.telephone;
		this.email = customer.email;
		this.status = customer.status;
		
	}
	
	public Customer() {
		this.cusID = "";
		this.contactPerson = "";
		this.address1 = new Address();
		this.address2 = new Address();
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
	public String getContactPerson() {
		return contactPerson;
	}
	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}
	public Address getAddress1() {
		return address1;
	}
	public void setAddress1(Address address1) {
		this.address1 = address1;
	}
	public Address getAddress2() {
		return address2;
	}
	public void setAddress2(Address address2) {
		this.address2 = address2;
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
				+ ", contactPerson=" + contactPerson + ", address1=" + address1 + ", address2=" + address2
				+ ", telephone=" + telephone + ", email=" + email + ", status=" + status + "]";
	}
	
	
	
	
}

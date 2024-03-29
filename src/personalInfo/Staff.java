package personalInfo;

public class Staff {
	
    protected String staffID;
    protected String firstName;
    protected String lastName;
    protected Date dob; 
    protected Address address;
    protected String telephone;
    protected String email;
    protected String position;
    protected String status;
    protected String password;
	
    // Constructor
    public Staff(String staffID, String password,String firstName, String lastName, Date dob, Address address, String telephone, String email, String position, String status) {
        this.staffID = staffID;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.address = address;
        this.telephone = telephone;
        this.email = email;
        this.position = position;
        this.status = status;
    }
    
    public Staff() {
        this.staffID = "";
        this.password = "";
        this.firstName = "";
        this.lastName = "";
        this.dob = new Date();
        this.address = new Address();
        this.telephone = "000-000-0000";
        this.email = "";
        this.position = "";
        this.status = "";
    	
    }
    
    public Staff(Staff staff) {
    	 this.staffID = staff.staffID;
    	 this.password = staff.password;
         this.firstName = staff.firstName;
         this.lastName = staff.lastName;
         this.dob = staff.dob;
         this.address = staff.address;
         this.telephone = staff.telephone;
         this.email = staff.email;
         this.position = staff.position;
         this.status = staff.status;
         
    }
    
    
    
    public String getStaffID() {
		return staffID;
	}

	public void setStaffID(String staffID) {
		this.staffID = staffID;
	}

	// Getters and setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

    // toString method to represent object as a string
    @Override
    public String toString() {
        return "Staff:" +
                "\nStaffID=" + staffID +
                "\nFirstName='" + firstName  +
                "\nLastName='" + lastName  +
                "\nDob=" + dob +
                "\nAddress1='" + address  +
                "\nTelephone='" + telephone  +
                "\nEmail='" + email  +
                "\nPosition='" + position  +
                "\nStatus='" + status;
                
    }
}




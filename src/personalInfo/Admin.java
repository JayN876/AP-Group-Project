package personalInfo;

public class Admin extends Staff{
	
	private String adminID;
	private String action;
	private String adminPosition;
	
	
	public Admin(String staffID, String password,String firstName, String lastName, Date dob, Address address1,
			Address address2, String telephone, String email, String staffPosition, String status, String adminID,
			String action, String adminPosition) {
		super(staffID, password,firstName, lastName, dob, address1, address2, telephone, email, staffPosition, status);
		this.adminID = adminID;
		this.action = action;
		this.adminPosition = adminPosition;
	}


	public Admin() {
		super();
		this.adminID = "";
		this.action = "";
		this.adminPosition = "";
	}


	public Admin(Admin admin) {
		super(admin);
		this.adminID = admin.adminID;
		this.action = admin.action;
		this.adminPosition = admin.adminPosition;
	}
	
	public Admin(Staff staff,String adminID,String position) {
		super(staff);
		this.adminID= adminID;
		this.adminPosition=position;
		
	}


	public String getAdminID() {
		return adminID;
	}


	public void setAdminID(String adminID) {
		this.adminID = adminID;
	}


	public String getAction() {
		return action;
	}


	public void setAction(String action) {
		this.action = action;
	}


	public String getAdminPosition() {
		return adminPosition;
	}


	public void setAdminPosition(String adminPosition) {
		this.adminPosition = adminPosition;
	}


	@Override
	public String toString() {
		return super.toString()+"\nAdmin [adminID=" + adminID + ", action=" + action + ", adminPosition=" + adminPosition + "]";
	}
	
}

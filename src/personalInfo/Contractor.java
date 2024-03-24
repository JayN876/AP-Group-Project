package personalInfo;

public class Contractor extends Staff {
	
	private String contratorID;

	public Contractor(String staffID,String password ,String firstName, String lastName, Date dob, Address address1, Address address2,
			String telephone, String email, String position, String status, String contratorID) {
		super(staffID, password, firstName, lastName, dob, address1, address2, telephone, email, position, status);
		this.contratorID = contratorID;
	}
	
	public Contractor() {
		super();
		contratorID ="";
	}
	
	public Contractor(Staff staff,String conID) {
		super(staff);
		this.contratorID = conID;
	}

	public String getContractorID() {
		return contratorID;
	}

	public void setContratorID(String contratorID) {
		this.contratorID = contratorID;
	}

	@Override
	public String toString() {	
		return super.toString()+"\nContractor [contratorID=" + contratorID + "]";
	}
	
}

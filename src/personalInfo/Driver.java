package personalInfo;

public class Driver extends Contractor{
	
	private String plateNumber;

	public Driver(String staffID, String password ,String firstName, String lastName, Date dob, Address address,
			String telephone, String email, String position, String status, String contratorID,
			String plateNumber) {
		super(staffID, password,firstName, lastName, dob, address, telephone, email, position, status, contratorID);
		this.plateNumber = plateNumber;
	}

	public Driver() {
		super();
		this.plateNumber = "";
	}

	public Driver(Staff staff,String contractorID,String plateNumber) {
		super(staff,contractorID);
		setContratorID(contractorID);
		this.plateNumber = plateNumber;
	}

	public String getPlateNumber() {
		return plateNumber;
	}

	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}

	@Override
	public String toString() {
		return super.toString()+"\nDriver [plateNumber=" + plateNumber + "]";
	}


	
	
}

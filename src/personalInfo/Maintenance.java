package personalInfo;

public class Maintenance extends Contractor{

	private String skillSet;

	public Maintenance(String staffID, String password,String firstName, String lastName, Date dob, Address address1,
			Address address2, String telephone, String email, String position, String status, String contratorID,
			String skillSetString) {
		super(staffID, password,firstName, lastName, dob, address1, address2, telephone, email, position, status, contratorID);
		this.skillSet = skillSetString;
	}
	
	
	public Maintenance() {
		super();
		this.skillSet = "";
	}
	
	public Maintenance(Staff staff,String contractorId ,String skillSet) {
		super(staff,contractorId);
		this.skillSet = skillSet;
	}


	public String getSkillSet() {
		return skillSet;
	}


	public void setSkillSet(String skillSet) {
		this.skillSet = skillSet;
	}


	@Override
	public String toString() {
		return super.toString()+"\nMaintenance [skillSet=" + skillSet + "]";
	}
	
	
	
	
}

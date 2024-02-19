package personalInfo;

public class Address {

	private String streetName;
	private String community;
	private String parish;
	
	
	public Address() {
		this.streetName = "";
		this.community = "";
		this.parish = "";
	}
	
	public Address(String streetName, String community, String parish) {
		this.streetName = streetName;
		this.community = community;
		this.parish = parish;
	}
	
	public Address(Address address) {
		this.streetName = address.streetName;
		this.community = address.community;
		this.parish = address.parish;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getCommunity() {
		return community;
	}

	public void setCommunity(String community) {
		this.community = community;
	}

	public String getParish() {
		return parish;
	}

	public void setParish(String parish) {
		this.parish = parish;
	}

	@Override
	public String toString() {
		return "Address:\nStreet Name: " + streetName + ""
				+ "\nCommunity: " + community 
				+ "\nParish: " + parish ;
	}
	
	
	
	
}

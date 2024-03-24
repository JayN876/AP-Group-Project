package personalInfo;

public class Address {
	
	private String id;
	private String streetName;
	private String community;
	private String parish;
	
	
	public Address() {
		this.id="";
		this.streetName = "";
		this.community = "";
		this.parish = "";
	}
	
	public Address(String id,String streetName, String community, String parish) {
		this.id = id;
		this.streetName = streetName;
		this.community = community;
		this.parish = parish;
	}
	
	public Address(Address address) {
		this.id = address.id;
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", streetName=" + streetName + ", community=" + community + ", parish=" + parish
				+ "]";
	}

	public boolean isEmpty() {
		int addressStringLength=streetName.length()+ community.length()+parish.length();
		if (addressStringLength>0) {
			return false;
		}
		return true;
	}

	
	
}

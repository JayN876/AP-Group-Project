package personalInfo;

public class Address {
	
	private String id;
	private String addressLine1;
	private String addressLine2;
	private String community;
	private String parish;
	private String country;
	
	
	public Address() {
		this.id="";
		this.addressLine1 = "";
		this.addressLine2 = "";
		this.community = "";
		this.parish = "";
		this.country = "";
	}
	
	

	public Address(String id, String addressLine1, String addressLine2, String community, String parish, String country) {
		this.id = id;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.community = community;
		this.parish = parish;
		this.country = country;
	}
	
	public Address(String id, String addressLine1, String community, String parish) {
		this.id = id;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.community = community;
		this.parish = parish;
		this.country = country;
	}
	
	
	public Address(Address address) {
		this.id = address.id;
		this.addressLine1 = address.addressLine1;
		this.addressLine2 = address.addressLine2;
		this.community = address.community;
		this.parish = address.parish;
		this.country = address.country;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
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

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public boolean isEmpty() {
		int addressStringLength=addressLine1.length() +addressLine2.length()+ community.length()+parish.length()+country.length();
		if (addressStringLength>0) {
			return false;
		}
		return true;
	}

}

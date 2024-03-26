package beans;

public class CompanyRepresentative {
	private String customerId;
	
	public CompanyRepresentative(String customerId, String customer) {
		super();
		this.customerId = customerId;
		this.customer = customer;
	}
	
	private String customer;
	
	
	
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	
	public String getCustomer() {
		return customer;
	}
	public void setCustomer(String customer) {
		this.customer = customer;
	}
	
	@Override 
	public String toString() {
		return this.customer;
	}

}

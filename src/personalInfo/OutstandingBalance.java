
package personalInfo;

public class OutstandingBalance {
    private String customerId;
    private String customerName;
    private double totalPayment;
    private double rate;
    private String status;

    public OutstandingBalance(String customerId, String customerName, double totalPayment, double rate, String status) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.totalPayment = totalPayment;
        this.rate = rate;
        this.status = status;
    }
    
    public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public double getTotalPayment() {
		return totalPayment;
	}

	public void setTotalPayment(double totalPayment) {
		this.totalPayment = totalPayment;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
    public String toString() {
        return "OutstandingBalance [customerId=" + customerId + ", customerName=" + customerName
                + ", totalPayment=" + totalPayment + ", rate=" + rate + ", status=" + status + "]";
    }
}
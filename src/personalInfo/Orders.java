package personalInfo;

public class Orders {
	
	private String invoiceNo;
	private String company;
	private Date paymentDueDate;
	private Date dateOfOrder;
	
	
	public Orders(String invoiceNo, String company, Date paymentDueDate, Date dateOfOrder) {
		this.invoiceNo = invoiceNo;
		this.company = company;
		this.paymentDueDate = paymentDueDate;
		this.dateOfOrder = dateOfOrder;
	}
	
	public Orders() {
		this.invoiceNo = "";
		this.company = "";
		this.paymentDueDate = new Date();
		this.dateOfOrder = new Date();
	}

	public String getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public Date getPaymentDueDate() {
		return paymentDueDate;
	}

	public void setPaymentDueDate(Date paymentDueDate) {
		this.paymentDueDate = paymentDueDate;
	}

	public Date getDateOfOrder() {
		return dateOfOrder;
	}

	public void setDateOfOrder(Date dateOfOrder) {
		this.dateOfOrder = dateOfOrder;
	}

	@Override
	public String toString() {
		return "Orders [invoiceNo=" + invoiceNo + ", company=" + company + ", paymentDueDate=" + paymentDueDate
				+ ", dateOfOrder=" + dateOfOrder + "]";
	}
	
	
}

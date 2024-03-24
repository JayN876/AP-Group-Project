package personalInfo;

public class Transactions {
	private String transactionNo;
	private Date transactionDate;
	private double payment;
	
	public Transactions(String transactionNo, Date transactionDate, double payment) {
		this.transactionNo = transactionNo;
		this.transactionDate = transactionDate;
		this.payment = payment;
	}
	
	public Transactions() {
		this.transactionNo = "";
		this.transactionDate = new Date();
		this.payment = 0.0;
	}

	public String getTransactionNo() {
		return transactionNo;
	}

	public void setTransactionNo(String transactionNo) {
		this.transactionNo = transactionNo;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public double getPayment() {
		return payment;
	}

	public void setPayment(double payment) {
		this.payment = payment;
	}

	@Override
	public String toString() {
		return "Transactions [transactionNo=" + transactionNo + ", transactionDate=" + transactionDate + ", payment="
				+ payment + "]";
	}

}

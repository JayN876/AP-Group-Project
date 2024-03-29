package personalInfo;


public class EmployeeSalary {

	private String paySlipID;
	private int staffId;
	private String startDate;
	private String endDate;
	private Double salary;
	public EmployeeSalary(String paySlipID, int staffId, String startDate, String endDate, Double salary) {
		super();
		this.paySlipID = paySlipID;
		this.staffId = staffId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.salary = salary;
	}
	public String getPaySlipID() {
		return paySlipID;
	}
	public void setPaySlipID(String paySlipID) {
		this.paySlipID = paySlipID;
	}
	public int getStaffId() {
		return staffId;
	}
	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	
	


}
package beans;

public class DeliveryDriver {
	private String contractorId;
	private String staffId;
	private String plateNumber;
	private String fullName;

	public DeliveryDriver(String contractorId, String staffId, String plateNumber, String fullName) {
		super();
		this.contractorId = contractorId;
		this.staffId = staffId;
		this.plateNumber = plateNumber;
		this.fullName = fullName;
	}

	public String getContractorId() {
		return contractorId;
	}

	public void setContractorId(String contractorId) {
		this.contractorId = contractorId;
	}

	public String getStaffId() {
		return staffId;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}

	public String getPlateNumber() {
		return plateNumber;
	}

	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	@Override
	public String toString() {
		
		return this.fullName;
	}
}

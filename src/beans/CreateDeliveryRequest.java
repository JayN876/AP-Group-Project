package beans;

import java.time.LocalDate;

public class CreateDeliveryRequest {
	private String customerId;
	private String routeId;
	private String plateNumber;
	private String adminId;
	private LocalDate orderDate;
	
	public CreateDeliveryRequest(String customerId, String routeId, String plateNumber, String adminId, LocalDate dateOfOrder) {
		super();
		this.customerId = customerId;
		this.routeId = routeId;
		this.plateNumber = plateNumber;
		this.adminId  = adminId;
		this.orderDate = dateOfOrder;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getRouteId() {
		return routeId;
	}

	public void setRouteId(String routeId) {
		this.routeId = routeId;
	}

	public String getPlateNumber() {
		return plateNumber;
	}

	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}

	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}
	
	
	
}

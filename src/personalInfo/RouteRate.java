package personalInfo;

public class RouteRate {
	
	private String routeID;
	private Address sourceAddress;
	private Address destinationAddress;
	private double rate;
	
	
	public RouteRate(String routeID, Address sourceAddress, Address destinationAddress, double rate) {
		this.routeID = routeID;
		this.sourceAddress = sourceAddress;
		this.destinationAddress = destinationAddress;
		this.rate = rate;
	}
	
	public RouteRate() {
		this.routeID = "";
		this.sourceAddress = new Address();
		this.destinationAddress = new Address();
		this.rate = 0.0;
	}

	public String getRouteID() {
		return routeID;
	}

	public void setRouteID(String routeID) {
		this.routeID = routeID;
	}

	public Address getSourceAddress() {
		return sourceAddress;
	}

	public void setSourceAddress(Address sourceAddress) {
		this.sourceAddress = sourceAddress;
	}

	public Address getDestinationAddress() {
		return destinationAddress;
	}

	public void setDestinationAddress(Address destinationAddress) {
		this.destinationAddress = destinationAddress;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	@Override
	public String toString() {
		return "RouteRate [routeID=" + routeID + ", sourceAddress=" + sourceAddress + ", destinationAddress="
				+ destinationAddress + ", rate=" + rate + "]";
	}
	
	
	
}

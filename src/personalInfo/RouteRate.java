package personalInfo;

public class RouteRate {
	
	private String routeID;
	private Address sourceAddress;
	private Address destinationAddress;
	private double rate;
	private double distance;
	
	
	public RouteRate(String routeID, Address sourceAddress, Address destinationAddress, double rate,double distance) {
		this.routeID = routeID;
		this.sourceAddress = sourceAddress;
		this.destinationAddress = destinationAddress;
		this.rate = rate;
		this.distance = distance;
	}
	
	public RouteRate() {
		this.routeID = "";
		this.sourceAddress = new Address();
		this.destinationAddress = new Address();
		this.rate = 0.0;
		this.distance = 0.0;
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

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	@Override
	public String toString() {
		return "RouteRate [routeID=" + routeID + ", sourceAddress=" + sourceAddress + ", destinationAddress="
				+ destinationAddress + ", rate=" + rate + ", distance=" + distance + "]";
	}
	
}

package beans;

public class DeliveryRoute {

	private String routeId;
	private String route;

	public DeliveryRoute(String routeId, String route) {
		super();
		this.routeId = routeId;
		this.route = route;
	}

	public String getRouteId() {
		return routeId;
	}

	public void setRouteId(String routeId) {
		this.routeId = routeId;
	}

	public String getRoute() {
		return route;
	}

	public void setRoute(String route) {
		this.route = route;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.route;
	}
}

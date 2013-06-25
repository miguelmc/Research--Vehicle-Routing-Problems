package vrpApp;

import java.util.ArrayList;
import java.util.List;

//MODEL
public class Client {
	private int number;
	private double x;
	private double y;
	private double demand;
	private int serviceTime;
	private int timeWindowStart;
	private int timeWindowEnd;
	private boolean isTimeWindowFlexible;
	private List<Double> distances;
	private List<Integer> times;
	private int truckArrivalTime;
	private int beginOfServiceTime;
	private double distanceToHereInRoute;

	public void setDefaults() {
		number = 0;
		x = -1;
		y = -1;
		demand = 0;
		serviceTime = 0;
		timeWindowStart = 0;
		timeWindowEnd = 0;
		truckArrivalTime = 0;
		beginOfServiceTime = 0;
		distanceToHereInRoute = 0;
		isTimeWindowFlexible = false;
		distances = null;
		times = null;
	}

	// Since client numbers are unique, if they have the same client number,
	// they are the same.
	public boolean equals(Client client) {
		if (this.number == client.getNumber())
			return true;
		else
			return false;
	}

	/* +++++++++++++++++++ Getters and Setters +++++++++++++++++++++++++++++ */

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getDemand() {
		return demand;
	}

	public void setDemand(double demand) {
		this.demand = demand;
	}

	public int getServiceTime() {
		return serviceTime;
	}

	public void setServiceTime(int serviceTime) {
		this.serviceTime = serviceTime;
	}

	public int getTimeWindowStart() {
		return timeWindowStart;
	}

	public void setTimeWindowStart(int timeWindowStart) {
		this.timeWindowStart = timeWindowStart;
	}

	public int getTimeWindowEnd() {
		return timeWindowEnd;
	}

	public void setTimeWindowEnd(int timeWindowEnd) {
		this.timeWindowEnd = timeWindowEnd;
	}

	public boolean isTimeWindowFlexible() {
		return isTimeWindowFlexible;
	}

	public void setTimeWindowFlexible(boolean isTimeWindowFlexible) {
		this.isTimeWindowFlexible = isTimeWindowFlexible;
	}

	public int getTruckArrivalTime() {
		return truckArrivalTime;
	}

	public void setTruckArrivalTime(int truckArrivalTime) {
		this.truckArrivalTime = truckArrivalTime;
	}

	public int getBeginOfServiceTime() {
		return beginOfServiceTime;
	}

	public void setBeginOfServiceTime(int beginOfServiceTime) {
		this.beginOfServiceTime = beginOfServiceTime;
	}

	public double getDistanceToHereInRoute() {
		return distanceToHereInRoute;
	}

	public void setDistanceToHereInRoute(double distanceToHereInRoute) {
		this.distanceToHereInRoute = distanceToHereInRoute;
	}
}

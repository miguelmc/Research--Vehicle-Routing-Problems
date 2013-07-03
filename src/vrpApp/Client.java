package vrpApp;

import java.util.List;

//MODEL
// This class will be first created and should be preserved unmodified thorough the program.

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

	public void setDefaults() {
		number = 0;
		x = -1;
		y = -1;
		demand = 0;
		serviceTime = 0;
		timeWindowStart = 0;
		timeWindowEnd = 0;
		isTimeWindowFlexible = false;
		distances = null;
		times = null;
	}

	// Since client numbers are unique, if they have the same client number,
	// they are the same.
	public boolean equals(Client client) {
		if (this.number == client.getClientNumber())
			return true;
		else
			return false;
	}
	
	public double getDistanceTo(int clientNumber){
		return distances.get(clientNumber);
	}
	
	public int getTimeTo(int clientNumber){
		return times.get(clientNumber);
	}

	/* +++++++++++++++++++ Getters and Setters +++++++++++++++++++++++++++++ */

	public void setDistances(List<Double> distances){
		this.distances = distances;
	}
	
	public void setTimes(List<Integer> times){
		this.times = times;
	}
	
	public int getClientNumber() {
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
}

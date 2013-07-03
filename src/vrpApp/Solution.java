package vrpApp;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

//MODEL

public class Solution {
	private List<Route> routes;
	private int totalTime;
	private double totalDistance;
	private double totalAptitude;
	private int executionTimeInMillis;
	private Calendar date;

	public Solution() {
		routes = new ArrayList<Route>();
		totalTime = 0;
		totalDistance = 0;
		totalAptitude = 0;
		executionTimeInMillis = 0;
		
	}
	
	public Solution(Solution solution) {
		// Create a deep copy for this solution of the same data in the other routes
		routes = new ArrayList<Route>();
		for(Route route: solution.getRoutes()){
			routes.add(new Route(route));
		}
		
		// Copy all other primitive types
		totalTime = solution.getTotalTime();
		totalDistance = solution.getTotalDistance();
		totalAptitude = solution.getTotalAptitude();
		executionTimeInMillis = 0;
		
	}

	public void recomputeData() {
		computeDistance();
		computeTime();
	}

	public void recomputeDataInAllRoutes() {
		for (Route route : routes) {
			route.recomputeData();
		}
		recomputeData();
	}

	public void addRoute(Route route) {
		routes.add(route);
	}

	public void clear() {
		routes.clear();
		totalTime = 0;
		totalDistance = 0;
		totalAptitude = 0;
		executionTimeInMillis = 0;
	}

	private void computeDistance() {
		totalDistance = 0;
		for (Route route : routes) {
			totalDistance += route.getDistance();
		}
	}

	private void computeTime() {
		totalTime = 0;
		for (Route route : routes) {
			totalTime += route.getTime();
		}
	}

	// GETTERS and SETTERS------------------------------------------------------
	public void setRoutes(List<Route> routes) {
		this.routes = routes;
	}

	public List<Route> getRoutes() {
		return routes;
	}

	public int getTotalTime() {
		return totalTime;
	}

	public void setTotalTime(int totalTime) {
		this.totalTime = totalTime;
	}

	public double getTotalDistance() {
		return totalDistance;
	}

	public void setTotalDistance(double totalDistance) {
		this.totalDistance = totalDistance;
	}

	public double getTotalAptitude() {
		return totalAptitude;
	}

	public void setTotalAptitude(double totalAptitude) {
		this.totalAptitude = totalAptitude;
	}

	public int getExecutionTimeInMillis() {
		return executionTimeInMillis;
	}

	public void setExecutionTimeInMillis(int executionTimeInMillis) {
		this.executionTimeInMillis = executionTimeInMillis;
	}

	public Calendar getDate() {
		return date;
	}

	public void setCurrentDate() {
		date = Calendar.getInstance();
	}
	
	public int getRouteCount(){
		return routes.size();
	}

	public Route getRouteAt(int index) {
		return routes.get(index);
	}

	public void deleteRoute(int index) {
		routes.remove(index);
		recomputeData();
	}
}

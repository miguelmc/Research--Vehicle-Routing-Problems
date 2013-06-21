import java.util.ArrayList;
import java.util.List;

//MODEL

public class Solution {
	private List<Route> routes;
	private int totalTime;
	private double totalDistance;
	private double totalAptitude;
	private int executionTimeInMillis;
	// TODO check if calendar is better??
	private int dateDay;
	private int dateMonth;
	private int dateYear;

	public Solution(){
		routes = new ArrayList<Route>();
	}
	
	public void recomputeData() {
		// TODO
	}

	public void recomputeDataInAllRoutes() {
		// TODO
	}

	//TODO: inconsistence... Route's addClient is type boolean, this one is void. CHANGE ONE
	public void addRoute(Route route) {
		routes.add(route);
	}

	public void clear() {
		// TODO
	}

	private void computeDistance() {
		// TODO
	}

	private void computeTime() {
		// TODO
	}

	// GETTERS and SETTERS------------------------------------------------------
	public void setRoutes(List<Route> routes){
		this.routes = routes;
	}
	
	public List<Route> getRoutes(){
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

	public int getDateDay() {
		return dateDay;
	}

	public int getDateMonth() {
		return dateMonth;
	}

	public int getDateYear() {
		return dateYear;
	}

	public void setDate(int dateYear, int dateMonth, int dateDay) {
		this.dateYear = dateYear;
		this.dateMonth = dateMonth;
		this.dateDay = dateDay;
	}
	// ---------------------------------------------------------------------------

}

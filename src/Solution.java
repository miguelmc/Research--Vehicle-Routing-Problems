import java.util.List;

//MODEL

public class Solution {
	private List<Route> routes;
	private int totalTime;
	private double totalDistance;
	private double totalAptitude;
	private int executionTimeInMillis;
	//TODO check if calendar is better??
	private int dateDay;
	private int dateMonth;
	private int dateYear;
	
	public void recomputeData(){
		//TODO
	}
	public void recomputeDataInAllRoutes(){
		//TODO
	}
	public void addRoute(Route route){
		//TODO
	}
	public void clear(){
		//TODO
	}
	private void computeDistance(){
		//TODO
	}
	
	
	//GETTERS and SETTERS------------------------------------------------------
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
	public void setDateDay(int dateDay) {
		this.dateDay = dateDay;
	}
	public int getDateMonth() {
		return dateMonth;
	}
	public void setDateMonth(int dateMonth) {
		this.dateMonth = dateMonth;
	}
	public int getDateYear() {
		return dateYear;
	}
	public void setDateYear(int dateYear) {
		this.dateYear = dateYear;
	}
	//---------------------------------------------------------------------------
	
}

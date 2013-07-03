package vrpApp;

//Model
// Wrapper for a Client adding certain important data related to the route it belongs to.

public class ClientLog {
	Client client;
	private int truckArrivalTime;
	private int beginOfServiceTime;
	private double distanceToHereInRoute;
	
	public ClientLog(Client client){
		this.client= client;
		truckArrivalTime = 0;
		beginOfServiceTime = 0;
		distanceToHereInRoute = 0;
	}
	
	public ClientLog(ClientLog clientLog){
		// We can assign client directly, withouth making a copy because the data in it is the same for all clientLogs
		client= clientLog.getClient();
		truckArrivalTime = clientLog.getTruckArrivalTime();
		beginOfServiceTime = clientLog.getBeginOfServiceTime();
		distanceToHereInRoute = clientLog.getDistanceToHereInRoute();
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
	
	public Client getClient(){
		return client;
	}
	
	//Access to the fields of client	
	public double getDistanceTo(int clientNumber){
			return client.getDistanceTo(clientNumber);
	}
	
	public int getClientNumber(){
		return client.getClientNumber();
	}
		
	public int getTimeTo(int clientNumber){
		return client.getTimeTo(clientNumber);
	}
	
	public int getServiceTime() {
		return client.getServiceTime();
	}
	
	public int getTimeWindowStart() {
		return client.getTimeWindowStart();
	}
	
	public int getTimeWindowEnd() {
		return client.getTimeWindowEnd();
	}
	
	public boolean isTimeWindowFlexible() {
		return client.isTimeWindowFlexible();
	}
	
	public double getDemand() {
		return client.getDemand();
	}
}

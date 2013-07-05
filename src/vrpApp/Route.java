package vrpApp;

import java.util.ArrayList;
import java.util.List;

//MODEL
public class Route {
	// Routes have the depot as the first client in its List of clients
	private List<ClientLog> clientLogs;
	private double distance;
	private int time;
	private double demand;
	private int vehicleCapacity;

	public Route(Client depot, int vehicleCapacity) {
		clientLogs = new ArrayList<ClientLog>();
		clientLogs.add(new ClientLog(depot));
		distance = 0;
		time = 0;
		demand= 0;
		this.vehicleCapacity = vehicleCapacity;
	}
	
	public Route(Route route) {
		// Create a deep copy of the client logs in this route
		clientLogs = new ArrayList<ClientLog>();
		for(ClientLog clientLog : route.getClientLogs()){
			clientLogs.add(new ClientLog(clientLog));
		}
		
		// Copy all primitive data
		distance = route.getDistance();
		time = route.getTime();
		demand= route.getDemand();
		vehicleCapacity = route.getVehicleCapacity();
	}
	
	//This has to be called from a consistent state. It uses the data in the last client to compute the total distance and total time
	public void recomputeData() {
		computeDistance();
		computeTime();
		computeDemand();
	}

	public int getClientCount() {
		return clientLogs.size() - 1;
	}

	// Take into account that the positions start in 1, not in 0.
	public boolean insertClientAt(Client client, int pos) {
		
		//Check that position is in the range [1,n+1]. n+1 means that the client is going to be inserted at the end.
		if(pos < 1 || pos > getClientCount() + 1 ){
			ErrorHandler.showError(12,"Route.insertClientAt(Client,int)", true);
		}
		
		//Insert the client in the position specified.
		clientLogs.add(pos, new ClientLog(client));
				
		//Change the data in the log of the clients following the inserted client (and including it!)
		ClientLog previous;
		ClientLog current;
		for(int index = pos; index <= getClientCount(); index++){
			current = clientLogs.get(index);
			previous = clientLogs.get(index-1);
			current.setDistanceToHereInRoute( previous.getDistanceToHereInRoute() + previous.getDistanceTo(current.getClientNumber()) );
			current.setTruckArrivalTime( previous.getBeginOfServiceTime() + previous.getServiceTime() + previous.getTimeTo(current.getClientNumber()) );
			current.setBeginOfServiceTime( Math.max(current.getTimeWindowStart(), current.getTruckArrivalTime()) );
		}
		
		//Change the data in the route (demand, time, distance)
		recomputeData();
		
		// Then we call isFeasible to confirm that we can insert the client.  If we cannot,  we revert the changes and return false.
		if (isFeasible())
			return true;
		else {
			deleteClient(pos);
			return false;
		}
	}

	// Take into account that the positions start in 1, not in 0.
	public boolean addClientAtEnd(Client client) {
		return insertClientAt(client, getClientCount() + 1);
	}

	// Take into account that the positions start in 1, not in 0.
	public void deleteClient(int pos) {
		
		//Check that pos  is in the range [1,n]
		if( pos < 1 || pos > getClientCount()){
			ErrorHandler.showError(11, "Route.deleteClient(int)", true);
		}
				 
		//Delete client from List of clients
		clientLogs.remove(pos);
		
		// Change the data in the log of clients that follow it.
		ClientLog previous;
		ClientLog current;
		for(int index = pos; index <= getClientCount(); index++){
			current = clientLogs.get(index);
			previous = clientLogs.get(index-1);
			current.setDistanceToHereInRoute( previous.getDistanceToHereInRoute() + previous.getDistanceTo(current.getClientNumber()) );
			current.setTruckArrivalTime( previous.getBeginOfServiceTime() + previous.getServiceTime() + previous.getTimeTo(current.getClientNumber()) );
			current.setBeginOfServiceTime( Math.max(current.getTimeWindowStart(), current.getTruckArrivalTime()) );
		}
		
		// Change the data in the route. 
		recomputeData();	
	}

	public boolean isEmpty() {
		return (clientLogs.size() <= 1);
	}

	//This will check any condition that should be met by the routes
	private boolean isFeasible() {
		//TODO
		
		//Check vehicle capacity is not exceeded by demand
		if( demand > vehicleCapacity){
			return false;
		}
		
		//Check that all time windows in clients that should be respected are respected
		ClientLog clientLog;
		for(int index = 1; index < clientLogs.size(); index++){
			clientLog= clientLogs.get(index);
			if(!clientLog.isTimeWindowFlexible()){
				if(clientLog.getTruckArrivalTime() > clientLog.getTimeWindowEnd()){
					return false;
				}
			}
		}
		
		//Check the global time window is respected if it should be respected.
		Client depot = getDepot();
		if(!depot.isTimeWindowFlexible()){
			if(getTime() > depot.getTimeWindowEnd()){
				return false;
			}
		}
			
		return true;
	}

	//Note that clear does not reset the vehicleCapacity, it is , it only clear the contents of the route but it's not a totally
	//new route. If one wants to create a new route, the use new Route()
	public void clear() {
		//Delete all clients in route but preserve depot
		Client depot = getDepot();
		clientLogs.clear();
		clientLogs.add(new ClientLog(depot));
		
		distance = 0;
		time = 0;
		demand = 0;
	}

	// To compute the distance we use the fact that when a client is added some data is stored in the client as bookkeeping.
	private void computeDistance() {
		ClientLog lastClientInRoute = clientLogs.get(getClientCount());
		distance = lastClientInRoute.getDistanceToHereInRoute() + lastClientInRoute.getDistanceTo(0);
	}
	
	// To compute the time we use the data stored in the clients.
	private void computeTime() {
		ClientLog lastClientInRoute = clientLogs.get(getClientCount());
		time = lastClientInRoute.getBeginOfServiceTime() + lastClientInRoute.getServiceTime() + lastClientInRoute.getTimeTo(0);
	}
	
	// To compute the time we use the data stored in the clients.
	private void computeDemand() {
		demand=0;
		for(int index = 1; index < clientLogs.size(); index++){
			demand += clientLogs.get(index).getDemand();
		}
	}

	// Getters and Setters----------------------------
	public List<Client> getClients() {
		List<Client> clientsToReturn= new ArrayList<Client>();
		for(int index = 1; index <clientLogs.size(); index++){
			clientsToReturn.add(clientLogs.get(index).getClient());
		}
		return clientsToReturn;
	}
	
	public List<Client> getClientsIncludingDepot() {
		List<Client> clientsToReturn= new ArrayList<Client>();
		for(ClientLog clientLog: clientLogs){
			clientsToReturn.add(clientLog.getClient());
		}
		return clientsToReturn;
	}
	
	public List<ClientLog> getClientLogs(){
		return clientLogs;
	}

	//getClientAt(0) = getDepot()
	public Client getClientAt(int pos) {
		return clientLogs.get(pos).getClient();
	}

	public double getDistance() {
		return distance;
	}

	public int getTime() {
		return time;
	}
	
	public double getDemand(){
		return demand;
	}

	public int getVehicleCapacity() {
		return vehicleCapacity;
	}

	public Client getDepot(){
		return getClientAt(0);
	}

	public ClientLog getClientLogAt(int pos) {
		return clientLogs.get(pos);
	}
	
	//Before adding setters for the depot and the vehicle capacity, take into account that the route
	//could become infeasible if those parameters are set directly
	// -----------------------------------------------
}

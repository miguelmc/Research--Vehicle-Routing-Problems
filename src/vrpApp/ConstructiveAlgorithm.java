package vrpApp;
import java.util.List;

public class ConstructiveAlgorithm extends Algorithm {

	private ConstructiveHeuristicContext heuristic;
	
	public ConstructiveAlgorithm(){
		solution = new Solution();
		heuristic = new ConstructiveHeuristicContext();
	}
	
	//Provides the specific implementation of the constructive algorithm
	public Solution executeAlgorithm(Problem problem) {
		solution= new Solution();
		
		//Start the timer for the execution time of the algorithm
		startSolutionTimer();
		
		//Check if a solution is possible. This call is optional
		if(isACompleteSolutionPossible(problem) == false){
			ErrorHandler.showError(1, "ConstructiveAlgorithm.executeAlgorithm(Problem)", true);
		}
		
		// Construct the solution by adding the routes given by the heuristic every time is called. 
		// The constructive heuristic will return a new route formed by some or all of the clients passed to it.
		// This will not cycle given that either all the clients minus the depot will be assigned and the while
		// will end normally or we will run out of vehicles to assign. 
		Route route;
		List<Client> clients = problem.getClients();
		List<Vehicle> vehicles= problem.getVehicles();
		Vehicle vehicleAssignedToRoute;
		do{
			//Select a vehicle for the next route
			vehicleAssignedToRoute = selectNextVehicleToBeUsed(vehicles);
			if(vehicleAssignedToRoute ==  null){ //There is not any available vehicle
				ErrorHandler.showError(10, "ConstructiveAlgorithm.executeAlgorithm(Problem)", true);
			}
			else{ // Valid vehicle received. Decrease the number of available vehicles.
				vehicleAssignedToRoute.setVehicleCount(vehicleAssignedToRoute.getVehicleCount()-1);
			}
				
			// Create the route. If an empty route is returned it means that the heuristic couldn't
			// assign a client to this vehicle (because the demand was exceed). Note: it does not mean
			// that any client could be assigned to this vehicle but only that this heuristic couldn't.
			route = heuristic.createNewRoute(clients, vehicleAssignedToRoute.getCapacity());
			route = finalizeRoute(route);
			
			//Add route to the current solution
			solution.addRoute(route);
		
		}while(clients.size()>1);
		
		// Put the vehicles assigned to an empty route in the list of vehicles that were not used
		putUnusedVehiclesInList(vehicles);
		
		//Do all final computations before returning a solution
		finalizeSolution();
		
		return solution;
	}
	
	//This function selects the next vehicle to be used by taking the first one available of the list of vehicles
	//This is supposed to be changed if one wants to select vehicles using a different metric
	private Vehicle selectNextVehicleToBeUsed(List<Vehicle> vehicles) {
		for(Vehicle vehicle: vehicles){
			if(vehicle.getVehicleCount() > 0){
				return vehicle;
			}
		}
		return null;
	}

	//Sets the heuristic to be used by the algorithm depending of the entry in configParams
	protected void setHeuristic(ConfigurationParams configParams) {
		switch(configParams.getHeuristicName()){
		case "Random1":
			heuristic.setStrategy(new Random1());
			break;
		case "NAH":
			heuristic.setStrategy(new NAH());
			break;
		case "NNH":
			heuristic.setStrategy(new NNH());
			break;
		default:
			ErrorHandler.showError(8,"ConstructiveAlgorithm.setHeuristic(ConfigurationParams)",true);
			break;
		}
		heuristic.applyConfiguration(configParams);
	}

	@Override
	protected void applySpecificConfiguration() {
		heuristic.setObjectiveFunction(objectiveFunction);
	}

	//Note: This is not the same as finalize solution.
	private Route finalizeRoute(Route route) {
		route.recomputeData();
		return route;
	}

	private void putUnusedVehiclesInList(List<Vehicle> vehicles){
		Route routeForChecks;
		Vehicle vehicleNotUsed;
		int routeCapacity;
		for(int index = 0; index < solution.getRouteCount(); index++){
			routeForChecks = solution.getRouteAt(index);
			if(routeForChecks.isEmpty()){
				
				routeCapacity = routeForChecks.getVehicleCapacity();
				
				for(int i =0; i<vehicles.size(); i++){
					vehicleNotUsed = vehicles.get(i);
					if(vehicleNotUsed.getCapacity() == routeCapacity){
						vehicleNotUsed.setVehicleCount(vehicleNotUsed.getVehicleCount()+1);
						break;
					}
				}
				
				solution.deleteRoute(index);
			}
		}
		
		//Delete all vehicle types that don't have any vehicle.
		for(int index =0; index < vehicles.size(); index++){
			if(vehicles.get(index).getVehicleCount() == 0){
				vehicles.remove(index);
			}
		}
		
	}
	
	// This function is not extensive, but tries to identify if a solution is not possible early in the process to avoid computation.
	// See, for example, that if you have 4 clients with demand 3 and 3 vehicles with capacity 5 a solution is impossible, though
	// this function will not catch such error. The call to this function is optional.
	// This function does NOT change the object Problem
	private boolean isACompleteSolutionPossible(Problem problem) {
		List<Client> clientList= problem.getClients();
		
		//Calculating total demand, total capacity and maximum vehicle capacity to be used in the checks later.
		double totalDemand = 0;
		int totalCapacity = 0;
		int maxVehicleCapacity = 0;
		//Notice it runs from 1 to n because the depot is in index 0.
		for(int index = 1; index < clientList.size(); index++){
			totalDemand += clientList.get(index).getDemand();
		}
		for(Vehicle vehicle: problem.getVehicles()){
			totalCapacity += (vehicle.getCapacity() * vehicle.getVehicleCount());
			if(vehicle.getCapacity()>maxVehicleCapacity){
				maxVehicleCapacity = vehicle.getCapacity();
			}
		}
		
		//If total demand of clients exceeds total capacity of vehicles a solution is impossible
		//See  that, here, we are implicitly assuming that every vehicle can only do one route a day.
		if(totalDemand > totalCapacity){
			return false;
		}
		
		// If any client by its own cannot be introduced in an empty route with maximum vehicle capacity it means this client
		// cannot be introduced in any place in any route, so a solution (using this client) is impossible.
		// See that, here, we are assuming that the demand of a client has to be satisfied entirely in one delivery.
		boolean isAdditionOK;
		Route routeForChecks = new Route(clientList.get(0), maxVehicleCapacity);
		//Notice again the for-loop begins in 1 because the depot is at index = 0
		for(int index = 1; index < clientList.size(); index++){
			isAdditionOK = routeForChecks.addClientAtEnd(clientList.get(index));
			if(!isAdditionOK){
				return false;
			}
			routeForChecks.clear();
		}
		
		return true;
	}
}

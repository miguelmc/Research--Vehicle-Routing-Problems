package vrpApp;

import java.util.List;

// Nearest neighbor heuristic: This client creates a route by assigning as the first client the client 'closer' to the depot
// Then keeps adding clients  choosing the client  which is 'closer' to the last client added. The route ends when the addition 
// of a new client makes it infeasible.
// Closer is calculated using the ObjectiveFunction2. For details look at its implementation

public class NNH extends ConstructiveHeuristic {

	private ObjectiveFunctionContext objectiveFunction;

	public Route createNewRoute(List<Client> clients, int vehicleCapacity) {
		Route route = new Route(clients.get(0), vehicleCapacity);
		int indexOfCloserClient;
		ClientLog lastClientInRoute;
		double bestAptitudeYet;
		double currentAptitude;
		
		do{
			
			//Initialize values to begin a new insertion
			lastClientInRoute = route.getClientLogAt(route.getClientCount());
			bestAptitudeYet = Double.MAX_VALUE; // We use max_value because we are trying to minimize
			indexOfCloserClient = -1;
			

			//Select the index of the best feasible client to insert. (closer to the last one)
			for(int index = 1; index< clients.size(); index++){
				
				//Checks if the insertion is feasible. We delete the client after so the route will remain unchanged
				if(route.addClientAtEnd(clients.get(index))){
					
					//Compare with the best client until now and select the best one 
					currentAptitude = objectiveFunction.computeAptitude( lastClientInRoute, route.getClientLogAt(route.getClientCount()) );
					if(currentAptitude < bestAptitudeYet){
						bestAptitudeYet = currentAptitude;
						indexOfCloserClient = index;
					}
					
					//Delete the client that was inserted to keep comparing
					route.deleteClient(route.getClientCount());
				}
			}
			
			//If closer client found, insert the client at end of route and delete it from the list of clients.
			if(indexOfCloserClient>0){
				route.addClientAtEnd(clients.get(indexOfCloserClient));
				clients.remove(indexOfCloserClient);
			}
			
		// indexOfCloserClient = -1 if there was not a possible addition, it is if all client are infeasible, and thus
		// the route is complete.
		}while(indexOfCloserClient>0);

		return route;
	}

	public void setObjectiveFunction(ObjectiveFunctionContext objFunction) {
		objectiveFunction = objFunction;
	}
}

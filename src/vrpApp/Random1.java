package vrpApp;

import java.util.List;

public class Random1 extends ConstructiveHeuristic {

	//This will create a new route by adding a new client at the end of the current route until a client is impossible to add.
	public Route createNewRoute(List<Client> clients, int vehicleCapacity) {
		Route route = new Route(clients.get(0), vehicleCapacity);
		int indexOfClient;
		boolean isAdditionOK;
		
		while(clients.size() > 1){
			//Generate random integer for the next chosen client
			indexOfClient = generateRandomInteger(1, clients.size()-1);
			
			//Add client to the current route and check if the route is still feasible.
			//If not break the cycle to return the current route.
			isAdditionOK = route.addClientAtEnd(clients.get(indexOfClient));
			if(!isAdditionOK){
				break;
			}
			
			//Delete client from list of clients so that it won't be picked in the next iteration.
			clients.remove(indexOfClient);
		}
		
		return route;
	}

	//This will generate a random Integer in the range given, inclusive*
	private int generateRandomInteger(int lowerLimit, int upperLimit) {
		int randomInt;
		randomInt = lowerLimit + (int)(Math.random() * ((upperLimit - lowerLimit) + 1));
		return randomInt;
	}

}

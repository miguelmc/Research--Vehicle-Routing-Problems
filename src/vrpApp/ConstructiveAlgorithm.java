package vrpApp;
import java.util.List;

public class ConstructiveAlgorithm extends Algorithm {

	private ConstructiveHeuristicContext heuristic;

	//Provides the specific implementation of the constructive algorithm
	public Solution executeAlgorithm(Problem problem) {
		// TODO
		return null;
	}

	//Sets the heuristic to be used by the algorithm depending of the entry in configParams
	protected void setHeuristic(ConfigurationParams configParams) {
		switch(configParams.getHeuristicName()){
		case "Random1": heuristic.setStrategy(new Random1());
		case "NAH": heuristic.setStrategy(new NAH());
		case "NNH": heuristic.setStrategy(new NNH());
		default: ErrorHandler.showError(8,"ConstructiveAlgorithm.setHeuristic(ConfigurationParams)",true);
		}
		heuristic.applyConfiguration(configParams);
	}

	@Override
	protected void applySpecificConfiguration() {
		heuristic.setObjectiveFunction(objectiveFunction);
	}

	//Note: This is not the same as finalize solution.
	private void finalizeRoute() {
		// TODO
	}

	//Removes the clients from the current List of clients that appear in the Route route.
	//It is called after adding a Route to the solution so the algorithm will not consider the clients in the added route 
	// in the construction of the next route.
	private List<Client> removeClientsInRouteFromList(List<Client> clients, Route route) {
		List<Client> clientsOut= route.getClients();
		clients.removeAll(clientsOut);
		return clients;
	}

}

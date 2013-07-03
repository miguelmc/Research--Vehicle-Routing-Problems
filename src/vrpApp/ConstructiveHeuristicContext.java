package vrpApp;

import java.util.List;

public class ConstructiveHeuristicContext {
	private ConstructiveHeuristic heuristic;

	public void setStrategy(ConstructiveHeuristic constrHeuristic) {
		heuristic = constrHeuristic;
	}

	public void applyConfiguration(ConfigurationParams configParams) {
		heuristic.applyConfiguration(configParams);
	}

	public Route createNewRoute(List<Client> clients, int vehicleCapacity) {
		return heuristic.createNewRoute(clients, vehicleCapacity);

	}

	public void setObjectiveFunction(ObjectiveFunctionContext objFunction) {
		heuristic.setObjectiveFunction(objFunction);
	}
}

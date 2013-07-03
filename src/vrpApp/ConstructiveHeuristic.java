package vrpApp;

import java.util.List;
import java.util.Map;

//This is an abstract class supposed to be extended to define new specific instances of constructive heuristics
//It is defined as abstract because an algorithm cannot have a heuristic of type ConstructiveHeuristic but only a specific
//implementation of this class.(e.g. Random, NAH, NNH, etc.)
public abstract class ConstructiveHeuristic {
	protected Map<String, String> configuration;

	public void applyConfiguration(ConfigurationParams configParams) {
		saveCopyOfConfigParams(configParams);
	}

	private void saveCopyOfConfigParams(ConfigurationParams configParams) {
		configuration = configParams.getHeuristicParams();
	}

	public void setObjectiveFunction(ObjectiveFunctionContext objFunction) {}

	public abstract Route createNewRoute(List<Client> clients, int vehicleCapacity);
}

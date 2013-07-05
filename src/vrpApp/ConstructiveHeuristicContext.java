package vrpApp;

import java.util.List;

public class ConstructiveHeuristicContext {
	private ConstructiveHeuristic heuristic;

	public void setStrategy(ConstructiveHeuristic constrHeuristic) {
		heuristic = constrHeuristic;
	}

	public void applyConfiguration(ConfigurationParams configParams) {
		try{
			heuristic.applyConfiguration(configParams);
		}catch(NullPointerException e){
			ErrorHandler.showError(20, "ConstructiveHeuristicContext.applyConfiguration(ConfigurationParams)" , true);
		}
	}

	public Route createNewRoute(List<Client> clients, int vehicleCapacity) {
		Route r=null;
		try{
			r = heuristic.createNewRoute(clients, vehicleCapacity);
		}catch(NullPointerException e){
			ErrorHandler.showError(20, "ConstructiveHeuristicContext.createNewRoute(List<Client>, int)" , true);
		}
		return r;

	}

	public void setObjectiveFunction(ObjectiveFunctionContext objFunction) {
		try{
			heuristic.setObjectiveFunction(objFunction);
		}catch(NullPointerException e){
			ErrorHandler.showError(20, "ConstructiveHeuristicContext.setObjectiveFunction(ObjectiveFunctionContext)" , true);
		}
	}
}

package vrpApp;
import java.util.Calendar;
import java.util.Map;

// This class is defined as abstract because every time the program is run we will need an specific instantiation of the algorithm
// (e.g. Constructive, HillClimbing, SimulatedAnneaing, etc.)
 public abstract class Algorithm {
	protected Map<String, String> configuration;
	protected ObjectiveFunctionContext objectiveFunction;
	protected Solution solution;
	private long solutionTimeInMillis;

	//Applies configuration to the entire system. Check SSD Setup
	public void applyConfiguration(ConfigurationParams configParams) {
		//Save current copy of the configuration parameters
		saveCopyOfConfigParams(configParams);
		
		//Apply the configuration for the base system in improvement heuristics		
		applyBaseConfiguration(configuration.get("base_config_file"));
		
		//Set ObjectiveFunction depending on the function received in the confgi file
		switch(configParams.getObjectiveFunctionName()){
		case "ObjectiveFunction1": objectiveFunction.setStrategy(new ObjectiveFunction1());
		//case "ObjectiveFunction2": objectiveFunction.setStrategy(new ObjectiveFunction2());
		default: ErrorHandler.showError(7,"Algorithm.applyConfiguration(ConfigurationParams)",true);
		}
		
		//Set the heuristic. This is implemented in every algorithm.
		setHeuristic(configParams);
		
		//Apply final special configuration before running the algorithm.
		//If an algorithm needs any special configuration it should overwrite this* function.
		applySpecificConfiguration();	
	}

	public abstract Solution executeAlgorithm(Problem problem);

	private void saveCopyOfConfigParams(ConfigurationParams configParams) {
		configuration=configParams.getAlgorithmParams();
	}

	protected abstract void setHeuristic(ConfigurationParams configParams);

	//Applies a configuration to the solver used to obtain a base Solution.
	//Implemented by the algorithms who need to obtain a base solution before running(improvement algorithms).
	protected void applyBaseConfiguration(String baseConfigPath){}

	// Any specific configuration to the algorithm . Implemented by the specific algorithms who need it.
	protected void applySpecificConfiguration(){};

	//Applies final steps before returning the solution.
	protected void finalizeSolution() {
		//Update the data in Solution in case some route changed before the last update
		solution.recomputeData();
		
		//Set the Solution aptitude
		solution.setTotalAptitude(objectiveFunction.computeAptitude(solution));
		
		//Set date parameters
		solution.setCurrentDate();
		
		//Set execution time
		int executionTimeInMillis = stopSolutionTimer();
		solution.setExecutionTimeInMillis(executionTimeInMillis);
		
	}

	protected void startSolutionTimer() {
		solutionTimeInMillis= Calendar.getInstance().getTimeInMillis();
	}

	protected int stopSolutionTimer() {
		solutionTimeInMillis = Calendar.getInstance().getTimeInMillis() - solutionTimeInMillis;		
		//This cast is exact as long as the rest is less than 2,147,483,647 (around 25 days).
		return (int) solutionTimeInMillis;
	}

	protected boolean isACompleteSolutionPosible(Problem problem) {
		boolean check;
		Route routeForChecks = new Route();
		
		// If any client by its own when cannot be introduced in an empty route it means this client cannot be introduced in 
		// any place, so a solution (using this client) is impossible and this function will return false.
		for(Client client: problem.getClients()){
			check = routeForChecks.addClientAtEnd(client);
			if(check == false){
				ErrorHandler.showError(1, "Algorithm.isACompleteSolutionPossible(Problem)", true);
			}
			routeForChecks.clear();
		}
		return true;
	}
}

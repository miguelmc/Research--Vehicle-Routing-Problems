package vrpApp;

import java.util.Map;

// This class is defined as abstract because every time the program is run we will need an specific instantiation of the algorithm
// (e.g. Constructive, HillClimbing, SimulatedAnneaing, etc.)
 public abstract class Algorithm {
	protected Map<String, String> configuration;
	protected ObjectiveFunctionContext objectiveFunction;
	protected Solution solution;
	private long solutionTimeInMillis;

	public Algorithm(){
		objectiveFunction = new ObjectiveFunctionContext();
		solutionTimeInMillis = 0;
	}
	
	//Applies configuration to the entire system. Check SSD Setup
	public void applyConfiguration(ConfigurationParams configParams) {
		//Save current copy of the configuration parameters
		saveCopyOfConfigParams(configParams);
		
		//Apply the configuration for the base system in improvement heuristics		
		applyBaseConfiguration(configuration.get("baseConfigFile"));
		
		//Set ObjectiveFunction depending on the function received in the config file
		switch (configParams.getObjectiveFunctionName()) {
		case "ObjectiveFunction1":
			objectiveFunction.setStrategy(new ObjectiveFunction1());
			break;
		
		case "ObjectiveFunction2": 
			objectiveFunction.setStrategy(new ObjectiveFunction2());
			break;
			
		case "ObjectiveFunction3": 
			objectiveFunction.setStrategy(new ObjectiveFunction3());
			break;
			
		default:
			objectiveFunction.setStrategy(new ObjectiveFunction());
			break;
		}
		objectiveFunction.applyConfiguration(configParams);
		
		//Set the heuristic. This is implemented in every algorithm.
		setHeuristic(configParams);
		
		//Apply final special configuration before running the algorithm.
		//If an algorithm needs any special configuration it should overwrite this* function.
		applySpecificConfiguration();	
	}

	public abstract Solution executeAlgorithm(Problem problem);

	private void saveCopyOfConfigParams(ConfigurationParams configParams) {
		configuration = configParams.getAlgorithmParams();
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
		solutionTimeInMillis= System.currentTimeMillis();
	}

	protected int stopSolutionTimer() {
		solutionTimeInMillis = System.currentTimeMillis() - solutionTimeInMillis;		
		//This cast is exact as long as the rest is less than 2,147,483,647 (around 25 days).
		return (int) solutionTimeInMillis;
	}
 }
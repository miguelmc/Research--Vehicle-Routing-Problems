package vrpApp;
public class HillClimbing extends Algorithm {

	private Solver baseSolver;
	private Readr baseConfReader;
	private ImprovementHeuristicContext heuristic;
	
	public HillClimbing(){
		baseSolver= new Solver();
		baseConfReader = new Readr();
	}
	
	//Provides the specific implementation of the constructive algorithm
	public Solution executeAlgorithm(Problem problem) {
		// TODO
		return null;
	}

	// Provides
	protected void applyBaseConfiguration(String baseConfigPath) {
		if(baseConfigPath == null){
			ErrorHandler.showError(6, "HillClimbing.applyBaseConfiguration(String)",true);
		}
		else{
			//Obtain configuration for the generator of the base solution.
			ConfigurationParams config = baseConfReader.readConfiguration(baseConfigPath);
			//Apply configuration to the solver of the base solution.
			baseSolver.applyConfiguration(config);
		}
	}

	//Generates the base solution that will be improved.
	private void generateBaseSolution(Problem problem) {
		solution = baseSolver.solveOneInstance(problem);
	}

	//Sets the heuristic to be used by the algorithm depending of the entry in configParams
	protected void setHeuristic(ConfigurationParams configParams) {
		
		switch(configParams.getHeuristicName()){
		case "Exchange": heuristic.setStrategy(new Exchange());
		case "Relocate": heuristic.setStrategy(new Relocate());
		case "CrossExchange": heuristic.setStrategy(new CrossExchange());
		default: ErrorHandler.showError(8,"HillClimbing.setHeuristic(ConfigurationParams)",true);
		}
		
		heuristic.applyConfiguration(configParams);
	}

}

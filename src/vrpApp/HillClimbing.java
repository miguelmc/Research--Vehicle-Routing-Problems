package vrpApp;
public class HillClimbing extends Algorithm {

	private Solver baseSolver;
	private Readr baseConfReader;
	private ImprovementHeuristicContext heuristic;
	
	public HillClimbing(){
		baseSolver= new Solver();
		baseConfReader = new Readr();
		heuristic = new ImprovementHeuristicContext();
	}
	
	//Provides the specific implementation of the constructive algorithm
	public Solution executeAlgorithm(Problem problem) {
		
		this.startSolutionTimer();
		this.generateBaseSolution(problem);
		
		Solution newSolution;
		int timesCurrentSolutionIsBetter = 0;
		int timesBeforeAccepting = 0;
		try{
			timesBeforeAccepting = Integer.parseInt(configuration.get("comparisonTolerance"));
		}catch(NumberFormatException e){
			e.printStackTrace();
			ErrorHandler.showError(15, "HillClimbing.computeAptitude(Solution)", true);
		}
		
		while(timesCurrentSolutionIsBetter < timesBeforeAccepting){
			newSolution = heuristic.generateAlternativeSolution(solution);
			if(objectiveFunction.computeAptitude(newSolution) < objectiveFunction.computeAptitude(solution)){
				solution = newSolution;
			}
			else
				++timesCurrentSolutionIsBetter;
		}
		
		this.finalizeSolution();
		return solution;
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

	// Generates the base solution that will be improved.
	// Note When this function is called the content of problem is modified. The List of clients is left with only clients
	// that were not assigned (or only the depot). And the List of vehicles is left with the vehicles that were not used.
	private void generateBaseSolution(Problem problem) {
		solution = baseSolver.solveOneInstance(problem);
	}

	//Sets the heuristic to be used by the algorithm depending of the entry in configParams
	protected void setHeuristic(ConfigurationParams configParams) {
		
		switch(configParams.getHeuristicName()){
		case "Relocate":
			heuristic.setStrategy(new Relocate());
			break;
		case "Exchange":
			heuristic.setStrategy(new Exchange());
			break;
		case "CrossExchange":
			heuristic.setStrategy(new CrossExchange());
			break;
		default: 
			ErrorHandler.showError(8,"HillClimbing.setHeuristic(ConfigurationParams)",true);
			break;
		}
		
		heuristic.applyConfiguration(configParams);
	}

}

package vrpApp;

public class Solver {

	private AlgorithmContext algorithm;
	
	public Solver(){
		algorithm = new AlgorithmContext();
	}

	public void applyConfiguration(ConfigurationParams configParams) {

		// Set type of Algorithm
		switch (configParams.getAlgorithmName()) {
		case "ConstructiveAlgorithm":
			algorithm.setStrategy(new ConstructiveAlgorithm());
			break;
		case "HillClimbing":
			algorithm.setStrategy(new HillClimbing());
			break;
		case "SimulatedAnnealing":
			algorithm.setStrategy(new SimulatedAnnealing());
			break;
		default:
			ErrorHandler.showError(3,"Solver.applyConfiguration(ConfigurationParams)", true);
			break;
		}

		// Configure the Algorithm.
		algorithm.applyConfiguration(configParams);
	}

	public Solution solveOneInstance(Problem problem) {
		return algorithm.executeAlgorithm(problem);
	}

}

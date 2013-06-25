package vrpApp;

public class Solver {

	private AlgorithmContext algorithm;

	public void applyConfiguration(ConfigurationParams configParams) {

		// Set type of Algorithm
		switch (configParams.getAlgorithmName()) {
		case "ConstructiveAlgorithm":
			algorithm.setStrategy(new ConstructiveAlgorithm());
		case "HillClimbing":
			algorithm.setStrategy(new HillClimbing());
		case "SimulatedAnnealing":
			algorithm.setStrategy(new SimulatedAnnealing());
		default:
			ErrorHandler.showError(3,
					"Solver.applyConfiguration(ConfigurationParams)", true);
		}

		// Configure the Algorithm.
		algorithm.applyConfiguration(configParams);
	}

	public Solution solveOneInstance(Problem problem) {
		return algorithm.executeAlgorithm(problem);
	}

}

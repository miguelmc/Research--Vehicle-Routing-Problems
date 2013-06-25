package vrpApp;

public class AlgorithmContext {
	private Algorithm algorithm;

	public void setStrategy(Algorithm algorithm) {
		this.algorithm = algorithm;
	}

	public void applyConfiguration(ConfigurationParams configParams) {
		algorithm.applyConfiguration(configParams);
	}

	public Solution executeAlgorithm(Problem problem) {
		return algorithm.executeAlgorithm(problem);
	}
}

package vrpApp;

public class AlgorithmContext {
	private Algorithm algorithm;

	public void setStrategy(Algorithm algorithm) {
		this.algorithm = algorithm;
	}

	public void applyConfiguration(ConfigurationParams configParams) {
		try{
			algorithm.applyConfiguration(configParams);
		}catch(NullPointerException e){
			ErrorHandler.showError(19,"AlgorithmContext.applyConfiguration(ConfigurationParams)", true);
		}
	}

	public Solution executeAlgorithm(Problem problem) {
		Solution s = null;
		try{
			s = algorithm.executeAlgorithm(problem);
		}catch(NullPointerException e){
			ErrorHandler.showError(19,"AlgorithmContext.executeAlgorithm(Problem)", true);
		}
		return s;
	}
}

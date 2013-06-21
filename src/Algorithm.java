import java.util.Map;

//ABSTRACT
abstract class Algorithm {
	protected Map<String, String> configuration;
	protected ObjectiveFunctionContext objectiveFunction;
	protected Solution solution;
	private int solutionTimeInMillis;

	public void applyConfiguration(ConfigurationParams configParams) {
		// TODO
	}

	public abstract Solution executeAlgorithm(Problem problem);

	private void saveCopyOfConfigParams(ConfigurationParams configParams) {
		// TODO
	}

	protected abstract void setHeuristic(ConfigurationParams configParams);

	protected void applyBaseConfiguration(String baseConfigPath) {
	}

	protected void applySpecificConfiguration() {
		// TODO
	}

	protected void finalizeSolution() {
		// TODO
	}

	protected void startSolutionTimer() {
		// TODO
	}

	protected int stopSolutionTimer() {
		// TODO
		return 0;
	}

	protected boolean isACompleteSolutionPosible(Problem problem) {
		// TODO
		return true;
	}
}

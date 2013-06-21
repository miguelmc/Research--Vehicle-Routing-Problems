import java.util.Map;

abstract class ImprovementHeuristic {

	protected Map<String, String> configuration;

	public void applyConfiguration(ConfigurationParams configParams) {
		// TODO
	}

	public abstract Solution generateAlternativeSolution(Solution solution);

	private void saveCopyOfConfigParams(ConfigurationParams configParams) {
		// TODO
	}

	protected int generateRandomInteger(int lowerLimit, int upperLimit) {
		// TODO
		return -1;
	}
}

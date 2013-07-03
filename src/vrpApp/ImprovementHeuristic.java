package vrpApp;

import java.util.Map;

//This is an abstract class supposed to be extended to define new specific instances of improvement heuristics
//It is defined as abstract because an algorithm cannot have a heuristic of type ConstructiveHeuristic but only a specific
//implementation of this class. (e.g. Relocate, Exchange, CrossExchange, etc.)
public abstract class ImprovementHeuristic {

	protected Map<String, String> configuration;

	public void applyConfiguration(ConfigurationParams configParams) {
		saveCopyOfConfigParams(configParams);
	}

	public abstract Solution generateAlternativeSolution(Solution solution);

	private void saveCopyOfConfigParams(ConfigurationParams configParams) {
		configuration = configParams.getHeuristicParams();
	}

	protected int generateRandomInteger(int lowerLimit, int upperLimit) {
		int randomInt;
		randomInt = lowerLimit + (int)(Math.random() * ((upperLimit - lowerLimit) + 1));
		return randomInt;
	}
	
}

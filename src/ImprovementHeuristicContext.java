public class ImprovementHeuristicContext {

	private ImprovementHeuristic heuristic;

	public void setStrategy(ImprovementHeuristic improvHeuristic) {
		heuristic = improvHeuristic;
	}

	public void applyConfiguration(ConfigurationParams configParams) {
		heuristic.applyConfiguration(configParams);
	}

	public Solution generateAlternativeSolution(Solution solution) {
		return heuristic.generateAlternativeSolution(solution);
	}
}

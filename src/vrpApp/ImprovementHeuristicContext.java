package vrpApp;

public class ImprovementHeuristicContext {

	private ImprovementHeuristic heuristic;

	public void setStrategy(ImprovementHeuristic improvHeuristic) {
		heuristic = improvHeuristic;
	}

	public void applyConfiguration(ConfigurationParams configParams) {
		try {
			heuristic.applyConfiguration(configParams);
		}catch(NullPointerException e){
			ErrorHandler.showError(21, "ImprovementHeuristicContextapplyConfiguration(ConfigurationParams)" , true);
		}
	}

	public Solution generateAlternativeSolution(Solution solution) {
		Solution s = null;
		try{
			s = heuristic.generateAlternativeSolution(solution);
		}catch(NullPointerException e){
			ErrorHandler.showError(21, "ImprovementHeuristicContext.generateAlternativeSolution(Solution)" , true);
		}
		return s;
	}
}

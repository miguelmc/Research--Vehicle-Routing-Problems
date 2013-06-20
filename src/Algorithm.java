import java.util.Map;

//ABSTRACT
abstract class Algorithm {
	protected Map<String,String> configuration;
	protected ObjectiveFunctionContext objectiveFunction;
	protected Solution solution;
	private int solutionTimeInMillis;
	

	abstract Solution executeAlgorithm(Problem problem);
	abstract protected void setHeuristic(ConfigurationParams configParams);
	
	protected void applyBaseConfiguration(String baseConfig){}

	
	public void applyConfiguration(ConfigurationParams configParams){
		//TODO
	}
	
	private void saveCopyOfConfigParams (ConfigurationParams configParams){
		//TODO
	}
	
	protected void applySpecificConfiguration(){
		//TODO
	}
	protected void finalizeSolution(){
		//TODO
	}
	protected void startSolutionTimer(){
		//TODO
	}
	protected int stopSolutionTimer(){
		//TODO
		return 0;
	}
	protected boolean isACompleteSolutionPosible(Problem problem){
		//TODO
		return true;
	}
}

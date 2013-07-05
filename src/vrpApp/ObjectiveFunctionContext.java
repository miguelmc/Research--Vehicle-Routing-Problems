package vrpApp;

public class ObjectiveFunctionContext {
	private ObjectiveFunction objectiveFunction;
	
	public void setStrategy(ObjectiveFunction objFunction) {
		objectiveFunction = objFunction;
	}

	public void applyConfiguration(ConfigurationParams configParams) {
		try{
			objectiveFunction.applyConfiguration(configParams);
		}catch(NullPointerException e){
			ErrorHandler.showError(22, "ObjectiveFunctionContext.applyConfiguration(ConfigurationParams)" , true);
		}
	}

	public double computeAptitude(Solution solution) {
		double a = 0.0;
		try{
			a = objectiveFunction.computeAptitude(solution);
		}catch(NullPointerException e){
			ErrorHandler.showError(22, "ObjectiveFunctionContext.computeAptitude(Solution)" , true);
		}
		return a;
	}

	public double computeAptitude(Route route) {
		double a = 0.0;
		try{
			a = objectiveFunction.computeAptitude(route);
		}catch(NullPointerException e){
			ErrorHandler.showError(22, "ObjectiveFunctionContext.computeAptitude(Route)" , true);
		}
		return a;
	}

	public double computeAptitude(ClientLog client1, ClientLog client2) {
		double a = 0.0;
		try{
			a = objectiveFunction.computeAptitude(client1, client2);
		}catch(NullPointerException e){
			ErrorHandler.showError(22, "ObjectiveFunctionContext.computeAptitude(Client, Client)" , true);
		}
		return a;
	}
	
	public double computeAptitude(Problem problem, Solution solution) {
		double a = 0.0;
		try{
			a = objectiveFunction.computeAptitude(problem, solution);
		}catch(NullPointerException e){
			ErrorHandler.showError(22, "ObjectiveFunctionContext.computeAptitude(Porblem, Solution)" , true);
		}
		return a;
	}
}

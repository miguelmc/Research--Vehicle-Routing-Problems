package vrpApp;

public class ObjectiveFunctionContext {
	private ObjectiveFunction objectiveFunction;

	public void setStrategy(ObjectiveFunction objFunction) {
		objectiveFunction = objFunction;
	}

	public void applyConfiguration(ConfigurationParams configParams) {
		objectiveFunction.applyConfiguration(configParams);
	}

	public double computeAptitude(Solution solution) {
		return objectiveFunction.computeAptitude(solution);
	}

	public double computeAptitude(Route route) {
		return objectiveFunction.computeAptitude(route);
	}

	public double computeAptitude(Client client1, Client client2) {
		return objectiveFunction.computeAptitude(client1, client2);
	}
}

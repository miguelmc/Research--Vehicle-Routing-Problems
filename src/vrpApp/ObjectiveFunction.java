package vrpApp;

import java.util.Map;

// This is NOT defined as abstract because we want this class to be the default implementation of its functions.
// So if an algorithm does not need to define an objective function we will instantiate this class as default.
public class ObjectiveFunction {
	protected Map<String, String> configuration;

	public void applyConfiguration(ConfigurationParams configParams) {
		saveCopyOfConfigParams(configParams);
	}

	public double computeAptitude(Solution solution) {
		return -1;
	}

	public double computeAptitude(Route route) {
		return -1;
	}

	public double computeAptitude(ClientLog client1, ClientLog client2) {
		return -1;
	}
	
	public double computeAptitude(Problem problem, Solution solution) {
		return -1;
	}

	private void saveCopyOfConfigParams(ConfigurationParams configParams) {
		configuration = configParams.getOFParams(); 
	}
}

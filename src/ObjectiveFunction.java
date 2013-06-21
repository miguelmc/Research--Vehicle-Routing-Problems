import java.util.Map;

//ABSTRACT
abstract class ObjectiveFunction {
	protected Map<String, String> configuration;

	public void applyConfiguration(ConfigurationParams configParams) {
		// TODO
	}

	public double computeAptitude(Solution solution) {
		return -1;
	}

	public double computeAptitude(Route route) {
		// TODO
		return -1;
	}

	public double computeAptitude(Client client1, Client client2) {
		return -1;
	}

	private void saveCopyOfConfigParams(ConfigurationParams configParams) {
		// TODO
	}
}

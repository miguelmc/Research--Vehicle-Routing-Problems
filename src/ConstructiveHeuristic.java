import java.util.List;
import java.util.Map;

//ABSTRACT
abstract class ConstructiveHeuristic {
	protected Map<String, String> configuration;

	public void applyConfiguration(ConfigurationParams configParams) {

	}

	private void saveCopyOfConfigParams(ConfigurationParams configParams) {

	}

	public void setObjectiveFunction(ObjectiveFunctionContext objFunction) {

	}

	public abstract Route createNewRoute(List<Client> clients);
}

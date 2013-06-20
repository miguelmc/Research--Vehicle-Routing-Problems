import java.util.List;
import java.util.Map;

//ABSTRACT
abstract class ConstructiveHeuristic {
	private Map<String,String> configuration;
	
	public void applyConfiguration(ConfigurationParams configParams){
		
	}
	private void saveCopyOfConfigParams (ConfigurationParams configParams){
		
	}
	public void setObjectiveFunction (ObjectiveFunctionContext objFunctionContext){
		
	}
	
	abstract Route createNewRoute(List<Client> clients);
}

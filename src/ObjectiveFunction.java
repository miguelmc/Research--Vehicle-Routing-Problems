import java.util.Map;

//ABSTRACT
abstract class ObjectiveFunction {
	protected Map<String,String> configuration;

	public void applyConfiguration(ConfigurationParams configParams){
		//TODO
	}
	public double computeAptitude(Solution solution){
		//TODO
		return 0;
	}
	public double computeAptitude(Route route){
		//TODO
		return 0;
	}
	public double computeAptitude(Client client1, Client client2){
		//TODO
		return 0;
	}
	private void saveCopyOfConfigParams(ConfigurationParams configParams){
		//TODO
	}
}

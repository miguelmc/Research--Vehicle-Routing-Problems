import java.util.HashMap;
import java.util.Map;

/**
 * <<MODEL>>
 */

public class ConfigurationParams {
	private Map<String,String> heuristicParams;
	private Map<String,String> algorithmParams;
	private Map<String,String> objectiveFunctionParams;
	private Map<String,String> miscelaneous;
	private String heuristicName;
	private String algorithmName;
	private String objectiveFunctionName;
	
	public ConfigurationParams()
	{
		heuristicParams = new HashMap<String, String>();
		algorithmParams = new HashMap<String, String>();
		objectiveFunctionParams = new HashMap<String, String>();
		miscelaneous = new HashMap<String, String>();
		heuristicName = "";
		algorithmName = "";
		objectiveFunctionName = "";
	}
	
	//Getters
	public String getHeuristicParam(String attr) {
		String param = heuristicParams.get(attr);
		return param;
	}
	public String getAlgorithmParam(String attr) {
		String param = algorithmParams.get(attr);
		return param;
	}
	public String getOFParam(String attr) {
		String param = objectiveFunctionParams.get(attr);
		return param;
	}
	public String getMiscParam(String attr) {
		String param = miscelaneous.get(attr);
		return param;
	}
	
	public String getHeuristicName() {
		return heuristicName;
	}
	public String getAlgorithmName() {
		return algorithmName;
	}
	public String getobjectiveFunctionName() {
		return objectiveFunctionName;
	}
	
	//Setters
	//These for methods ADDS a name-value pair to the map.
	public void setHeuristicParam(String name, String value) {
		heuristicParams.put(name, value);
	}
	public void setAlgorithmParam(String name, String value) {
		algorithmParams.put(name, value);
	}
	public void setOFParam(String name, String value) {
		objectiveFunctionParams.put(name, value);
	}
	public void setMiscParam(String name, String value) {
		miscelaneous.put(name, value);
	}
	
	public void setHeuristicName(String heuristicName) {
		this.heuristicName = heuristicName;
	}
	public void setAlgorithmName(String algorithmName) {
		this.algorithmName = algorithmName;
	}
	public void setObjectiveFunctionName(String objectiveFunctionName) {
		this.objectiveFunctionName = objectiveFunctionName;
	}
}

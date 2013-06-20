import java.io.File;


public class Readr {

	private IConfigReader configReader;
	private IProblemReader problemReader;
	
	
	public ConfigurationParams readConfiguration(File configFile) {
		configReader = new XMLConfigReader();
		return configReader.createConfigurationParams(configFile);
	}

	public Problem readProblem(File problemFile) {
		problemReader = new XMLProblemReader();
		return problemReader.createProblem(problemFile);
	}
	
	public ConfigurationParams readConfiguration(String configPath) {
		configReader = new XMLConfigReader();
		return configReader.createConfigurationParams(new File(configPath));
	}

	//TODO:
	public Problem readProblem(String problemPath) {
		problemReader = new XMLProblemReader();
		return problemReader.createProblem(new File(problemPath));
	}

}

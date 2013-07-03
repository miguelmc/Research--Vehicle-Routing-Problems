package vrpApp;

import java.io.File;

public class Readr {

	private IConfigReader configReader;
	private IProblemReader problemReader;

	public ConfigurationParams readConfiguration(File configFile){
		configReader = new XMLConfigReader();
		return configReader.createConfigurationParams(configFile);
	}

	public Problem readProblem(File problemFile) {
		problemReader = new XMLProblemReader();
		return problemReader.createProblem(problemFile);
	}

	public ConfigurationParams readConfiguration(String configPath) {
		configReader = new XMLConfigReader();
		File configFile = new File(configPath);
		return configReader.createConfigurationParams(configFile);
	}

	// TODO:
	public Problem readProblem(String problemPath) {
		problemReader = new XMLProblemReader();
		File problemFile = new File(problemPath);
		return problemReader.createProblem(problemFile);
	}

}

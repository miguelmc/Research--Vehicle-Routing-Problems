import java.io.File;


public class Readr {

	private IConfigReader configReader;
	private IProblemReader problemReader;
	
	
	public ConfigurationParams readConfiguration(File configFile) {
		configReader = new XMLConfigReader();
		configReader.read(configFile);
		return null;
	}

	public Problem readProblem(File[] problemsFile) {
		problemReader = new XMLProblemReader();
		problemReader.read(problemsFile[0]);
		return null;
	}

}

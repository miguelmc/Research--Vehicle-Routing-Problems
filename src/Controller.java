import java.io.File;

import javax.security.auth.login.Configuration;

public class Controller {
	
	private Readr reader;
	private Solver solver;
	private WriterContext writer;
	
	public Controller()
	{
		//Reads config and problem data
		reader = new Readr();
		//Outputs solution
		writer = new WriterContext();
		//Process problem, gets solution
		solver = new Solver();
	}
	
	//The 2 following methods process each problem independently
	
	//Process the problem handling Files
	void processProblem(File configFile, File[] problemsFile)
	{
		ConfigurationParams config = reader.readConfiguration(configFile);
		solver.applyConfiguration(config);
		for(int i=0; i<problemsFile.length; i++)
		{
			Problem problem= reader.readProblem(problemsFile[i]);
			solver.solveOneInstance(problem);
			//TODO write.
		}
	}
	
	//but also string paths
	void processProblem(String configPath, String[] problemPaths)
	{
		ConfigurationParams config = reader.readConfiguration(configPath);
		solver.applyConfiguration(config);
		for(int i=0; i<problemPaths.length; i++)
		{
			Problem problem = reader.readProblem(problemPaths[i]);
			solver.solveOneInstance(problem);
			//TODO write.
		}
	}

	//TODO
	private void setWriterType(String type)
	{
		//default
	}
}

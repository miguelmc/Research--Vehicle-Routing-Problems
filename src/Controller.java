import java.io.File;

import javax.security.auth.login.Configuration;

public class Controller {
	
	private Readr reader;
	private Solver solver;
	private WriterContext writer;
	
	public Controller()
	{
		reader = new Readr();
		writer = new WriterContext();
		solver = new Solver();
	}
	
	void solveProblem(File configFile, File[] problemsFile)
	{
		ConfigurationParams config = reader.readConfiguration(configFile);
		solver.applyConfiguration(config);
		Problem problem= reader.readProblem(problemsFile);
		solver.solveOneInstance();
	}

	private void setWriterType(String type)
	{
		//default
	}
}

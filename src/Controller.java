import java.io.File;

import javax.security.auth.login.Configuration;

public class Controller {

	private Readr reader;
	private Solver solver;
	private WriterContext writer;

	public Controller() {
		// Reads config and problem data
		reader = new Readr();
		// Outputs solution
		writer = new WriterContext();
		// Process problem, gets solution
		solver = new Solver();
	}

	// The 2 following methods process each problem independently

	// Process the problem handling Files
	public void processProblem(File configFile, File[] problemFile) {
		ConfigurationParams config = reader.readConfiguration(configFile);
		solver.applyConfiguration(config);
		for (int i = 0; i < problemFile.length; i++) {
			Problem problem = reader.readProblem(problemFile[i]);
			solver.solveOneInstance(problem);
			// TODO write.
		}
	}

	// but also string paths
	public void processProblem(String configPath, String[] problemPath) {
		ConfigurationParams config = reader.readConfiguration(configPath);
		solver.applyConfiguration(config);
		for (int i = 0; i < problemPath.length; i++) {
			Problem problem = reader.readProblem(problemPath[i]);
			solver.solveOneInstance(problem);
			// TODO write.
		}
	}

	// TODO
	private void setWriterType(String type) {
		// default
	}
}

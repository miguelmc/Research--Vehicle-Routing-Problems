package vrpApp;

import java.io.File;

//This class is in charge of receiving the File objects obtaining the problem specification(s) and the Configuration parameters
//via Readr, apply the current configuration to the system and pass the problem(s) to the Solver. Then it will present the solution
// using WriterContext.
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

	// Read solve and show the problems receiving File Objects
	// Main function of this class.
	public void processProblem(File configFile, File[] problemFiles, File outputFile) {
		// Read and apply Configuration to the system
		ConfigurationParams config = reader.readConfiguration(configFile);
		solver.applyConfiguration(config);

		// Set type of writer
		setWriterType("simple");
		// Only the simple writer is implemented by now, later this could be a
		// parameter passed in the config file under miscellaneous

		// Set the file path where the output would be written 
		//DON'T DELETE. Needed for SimpleWriter.
		writer.setOutputFolder(outputFile);
		Problem problem;
		Solution solution;
		// Solve problems and show solutions in the selected writer
		for (File problemFile : problemFiles) {
			problem = reader.readProblem(problemFile);
			solution = solver.solveOneInstance(problem);
			writer.write(problem.getInstanceName(), solution, config);
		}
	}

	// Read solve and show the problems receiving String Objects
	public void processProblem(String configPath, String[] problemPaths, String outputPath) {
		// Obtain all File handlers for the paths received
		File configFile = null;
		File[] problemFiles = new File[problemPaths.length];
		configFile = new File(configPath);
		for (int i = 0; i < problemPaths.length; i++) {
			problemFiles[i] = new File(problemPaths[i]);
		}

		// Call the main function with the Files obtained
		processProblem(configFile, problemFiles, new File(outputPath));
	}

	// To add more types of writers one has to add another line in this function
	// and modify the section "Set writer"
	// above in the processProblem to receive some way this new parameter, maybe
	// it could read it from the ConfigurationParams Object
	private void setWriterType(String type) {
		switch (type) {
		case "simple":
			writer.setStrategy(new SimpleWriter());
			break;
		case "graphical":
			writer.setStrategy(new GraphicalWriter());
			break;
		default:
			writer.setStrategy(new SimpleWriter());
			break;
		}
	}
}

package vrpApp;

import java.util.HashMap;
import java.util.Map;

public final class ErrorHandler {

	static Map<Integer, String> errorDescription;

	// Static initializer
	static {
		errorDescription = new HashMap<Integer, String>();
		errorDescription.put(1, "Fatal error: There is not a possible solution for the problem.");
		errorDescription.put(2, "NullPointerException while opening a File object for a Problem or ConfigurationParams.");
		errorDescription.put(3, "An invalid algorithm name was received in the config file.");
		errorDescription.put(4, "Configuration file does not exist on specified path or it is badly formed.");
		errorDescription.put(5, "Problem file does not exist on specified path");
		errorDescription.put(6, "Base configuration file not found in the config file.");
		errorDescription.put(7, "An invalid objective function name was received in the config file.");
		errorDescription.put(8, "An invalid heuristic name was received in the config file.");
		errorDescription.put(9, "Error while writing on the output file: Input/Output problematic.");
		errorDescription.put(10, "Not enough vehicles to complete the solution");
		errorDescription.put(11, "Out of range deletion in Route");
		errorDescription.put(12, "Out of range insertion in Route");
		errorDescription.put(13, "Objective Function is not receiving the parameters needed");
		errorDescription.put(14, "Heuristic is not receiving the parameters needed");
		errorDescription.put(15, "Algorithm is not receiving the parameters needed");
		errorDescription.put(16, "Default output path does not exist");
		errorDescription.put(17, "Output Folder not specified or setOutputFolder not called (needed for SimpleWriter)");
		errorDescription.put(18, "Writr was not set before using it.");
		errorDescription.put(18, "Writr was not set before using it.");
		errorDescription.put(19, "Algorithm was not set before using it.");
		errorDescription.put(20, "Constructive heuristic was not set before using it.");
		errorDescription.put(21, "Improvement heuristic was not set before using it.");
		errorDescription.put(22, "Objective function was not set before using it.");
		errorDescription.put(23, "XML sent in configuration is not a configuration file.");
		errorDescription.put(24, "XML('s) sent in problem is not a problem file.");
	}

	// This private Constructor is just so that this class cannot be
	// instantiated. Java does not offer statics class.
	private ErrorHandler() {
	};

	public static void showError(int code, boolean stopProgram) {
		System.out.println(errorDescription.get(code));
		if (stopProgram) {
			System.exit(code);
		}
	}

	public static void showError(int code, String placeOfError,
			boolean stopProgram) {
		System.out.println(errorDescription.get(code) + " at " + placeOfError);
		if (stopProgram) {
			System.exit(code);
		}
	}
}

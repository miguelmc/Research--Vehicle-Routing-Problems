package vrpApp;

import java.util.HashMap;
import java.util.Map;

public final class ErrorHandler {

	static Map<Integer, String> errorDescription;

	// Static initializer
	static {
		errorDescription = new HashMap<Integer, String>();
		errorDescription
				.put(1,
						"Fatal error: There is not a possible solution for the problem.");
		errorDescription
				.put(2,
						"NullPointerException while opening a File object for a Problem or ConfigurationParams.");
		errorDescription.put(3,
				"An invalid algorithm name was received in the config file.");
		errorDescription.put(4,
				"Configuration file does not exist on specified path.");
		errorDescription
				.put(5, "Problem file does not exist on specified path");
		errorDescription.put(6,
				"Base configuration file not found in the config file.");
		errorDescription
				.put(7,
						"An invalid objective function name was received in the config file.");
		errorDescription.put(8,
				"An invalid heuristic name was received in the config file.");
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

import java.util.HashMap;
import java.util.Map;

public final class ErrorHandler {

	static Map<Integer, String> errorDescription;
	
	//Static initializer
	static{
		errorDescription = new HashMap<Integer, String>();
		errorDescription.put(1, "error 1");
		errorDescription.put(1, "error 2");
		// ...
		errorDescription.put(1, "error n-1");
		errorDescription.put(1, "error n");
	}
	
	//Just so that this class cannot be instantiated. Java does not offer statics class.
	private ErrorHandler(){};

	public static void showError(int n) {
		System.out.println(errorDescription.get(n));
	}

	public static void showError(int n, String s) {
		System.out.println(errorDescription.get(n) + " at " + s);
	}
}

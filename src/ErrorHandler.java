import java.util.HashMap;
import java.util.Map;


public class ErrorHandler {
	static Map<Integer,String> errorDescription;
	
	public ErrorHandler()
	{
		errorDescription = new HashMap();
		errorDescription.put(1, "error 1");
		errorDescription.put(1, "error 2");
		//...
		errorDescription.put(1, "error n-1");
		errorDescription.put(1, "error n");
	}
	
	static void showError(int n)
	{
		System.out.println(errorDescription.get(n));
	}
	static void showError(int n, String s)
	{
		System.out.println(errorDescription.get(n) + " at " + s);
	}
}

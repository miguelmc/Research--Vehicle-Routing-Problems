package tests;

import java.io.File;
import java.util.Map.Entry;

import vrpApp.ConfigurationParams;
import vrpApp.XMLConfigReader;

/**
 * Class with sole purpose of checking if XMLConfig reader works right.
 * 
 * @author mike
 * 
 */

public class XMLConfigReaderTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		XMLConfigReader a = new XMLConfigReader();

		// Test 1
		System.out.println("Test 1 (No fields missing)");
		ConfigurationParams b = a.createConfigurationParams(new File(
				"/home/mike/TestsVRP/Reader/test1.xml"));

		System.out.println("Algorithm name: " + b.getAlgorithmName());
		System.out.println("Algorithm params:");
		for (Entry<String, String> i : b.getAlgorithmParams().entrySet()) {
			System.out.println("\t" + i.getKey() + ":\t" + i.getValue());
		}

		System.out.println("Heuristic name: " + b.getHeuristicName());
		System.out.println("Heuristic params:");
		for (Entry<String, String> i : b.getHeuristicParams().entrySet()) {
			System.out.println("\t" + i.getKey() + ":\t" + i.getValue());
		}

		System.out.println("OF name: " + b.getObjectiveFunctionName());
		System.out.println("OF params:");
		for (Entry<String, String> i : b.getOFParams().entrySet()) {
			System.out.println("\t" + i.getKey() + ":\t" + i.getValue());
		}

		// ------------------------------------------------------------------

		// Test 2
		System.out.println("\n\n\nTest 2 (All fields missing)");

		b = a.createConfigurationParams(new File(
				"/home/mike/TestsVRP/Reader/test2.xml"));

		System.out.println("Algorithm name: " + b.getAlgorithmName());
		System.out.println("Algorithm params:");
		for (Entry<String, String> i : b.getAlgorithmParams().entrySet()) {
			System.out.println("\t" + i.getKey() + ":\t" + i.getValue());
		}

		System.out.println("Heuristic name: " + b.getHeuristicName());
		System.out.println("Heuristic params:");
		for (Entry<String, String> i : b.getHeuristicParams().entrySet()) {
			System.out.println("\t" + i.getKey() + ":\t" + i.getValue());
		}

		System.out.println("OF name: " + b.getObjectiveFunctionName());
		System.out.println("OF params:");
		for (Entry<String, String> i : b.getOFParams().entrySet()) {
			System.out.println("\t" + i.getKey() + ":\t" + i.getValue());
		}
	}

}

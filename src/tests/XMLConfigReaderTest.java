package tests;


import ConfigurationParams;
import XMLConfigReader;

import java.io.File;

/**
 * Class with sole purpose of checking if XMLConfig reader works right.
 * @author mike
 *
 */

public class XMLConfigReaderTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		XMLConfigReader a = new XMLConfigReader();
		
		//Change
		ConfigurationParams b = a.createConfigurationParams(new File("/home/mike/test.txt"));
		
		System.out.println("Algorithm name: " + b.getAlgorithmName());
		System.out.println("Algorithm params:");
		System.out.println("\tEggs: " + b.getAlgorithmParam("Eggs"));
		System.out.println("\tWings: " + b.getAlgorithmParam("Wings"));
		
		System.out.println("Heuristic name: " + b.getHeuristicName());
		System.out.println("Heuristic params:");
		System.out.println("\tEgg: " + b.getHeuristicParam("Egg"));
		System.out.println("\ttail: " + b.getHeuristicParam("tail"));
		
		System.out.println("OF name: " + b.getobjectiveFunctionName());
		System.out.println("OF params:");
		System.out.println("\tCiel: " + b.getOFParam("Ciel"));
		System.out.println("\ttest: " + b.getOFParam("test"));
		
		System.out.println("MISC params:");
		System.out.println("\tSome: " + b.getMiscParam("Some"));
		System.out.println("\tanother: " + b.getMiscParam("another"));
		//------------------------
	}

}

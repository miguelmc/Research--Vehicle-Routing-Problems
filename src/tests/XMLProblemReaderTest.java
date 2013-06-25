package tests;

import java.io.File;

import vrpApp.Problem;
import vrpApp.XMLProblemReader;

public class XMLProblemReaderTest {
	
	public static void main(String[] args){
		XMLProblemReader x = new XMLProblemReader();
		Problem p = x.createProblem(new File("problemTest1.xml"));
		
		
	}
}

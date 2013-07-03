package tests;

import java.io.File;
import java.io.IOException;

import vrpApp.Client;
import vrpApp.ConfigurationParams;
import vrpApp.Route;
import vrpApp.SimpleWriter;
import vrpApp.Solution;

public class TestXMLWriter {
	public static void main(String[] args) throws IOException {

		// Test 1
		ConfigurationParams cp = new ConfigurationParams();
		cp.setAlgorithmName("Duck Sort");
		cp.setAlgorithmParam("cuack", "meep");
		cp.setAlgorithmParam("cuack", "meep");
		cp.setHeuristicName("Santa");
		cp.setObjectiveFunctionName("JOJOJO");

		Solution s = new Solution();
		Client c;
		Route r;
		for (int i = 0; i < 5; i++) {
			r = new Route(new Client(), 5);
			for (int j = 1; j < 7; j++) {
				c = new Client();
				c.setNumber(j);
				r.addClientAtEnd(c);
			}
			s.addRoute(r);
		}
		s.setCurrentDate();
		s.setExecutionTimeInMillis(2000);
		s.setTotalAptitude(10);
		s.setTotalDistance(1000);
		s.setTotalTime(1002);

		SimpleWriter x = new SimpleWriter();
		x.setOutputFolder(new File("/home/mike"));
		x.write("test1", s, cp);

		// Test 2
		cp = new ConfigurationParams();

		s = new Solution();
		for (int i = 0; i < 5; i++) {
			r = new Route(new Client(), 5);
			for (int j = 1; j < 7; j++) {
				c = new Client();
				c.setNumber(j);
				r.addClientAtEnd(c);
			}
			s.addRoute(r);
		}
		s.setCurrentDate();

		x = new SimpleWriter();
		x.write("test2", s, cp);
	}
}

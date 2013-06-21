package tests;
import Client;
import ConfigurationParams;
import Route;
import SimpleWriter;
import Solution;

import java.io.IOException;


public class TestXMLWriter {
	public static void main(String[] args) throws IOException{
		ConfigurationParams cp = new ConfigurationParams();
		cp.setAlgorithmName("Duck Sort");
		cp.setAlgorithmParam("cuack", "meep");
		cp.setAlgorithmParam("cuack", "meep");
		cp.setHeuristicName("Santa");
		cp.setObjectiveFunctionName("JOJOJO");
		
		Solution s = new Solution();
		Client c;
		Route r;
		for(int i=0;i<5; i++){
			r = new Route();
			for(int j=1; j<7; j++){
				c = new Client();
				c.setNumber(j);
				r.addClientAtEnd(c);
			}
			s.addRoute(r);
		}
		s.setDate(1, 3, 1993);
		s.setExecutionTimeInMillis(2000);
		s.setTotalAptitude(10);
		s.setTotalDistance(1000);
		s.setTotalTime(1002);
		
		SimpleWriter x = new SimpleWriter();
		x.write(s, cp);
	}
}

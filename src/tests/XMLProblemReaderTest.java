package tests;

import java.io.File;

import vrpApp.Client;
import vrpApp.Problem;
import vrpApp.Vehicle;
import vrpApp.XMLProblemReader;

public class XMLProblemReaderTest {
	
	public static void main(String[] args){
		XMLProblemReader x = new XMLProblemReader();
		Problem p = x.createProblem(new File("/home/mike/problemTest1.xml"));
		
		System.out.println("Type:\t" + p.getType());
		System.out.println("Instance Name:\t" + p.getInstanceName());
		System.out.println("Vehicles:");
		for(Vehicle v : p.getVehicles()){
			System.out.println("\tCapacity:\t" + v.getCapacity());
			System.out.println("\tVehicleCount:\t" + v.getVehicleCount());
		}
		System.out.println("Clients:");
		for(Client c : p.getClients()){
			System.out.println("\tNumber:\t" + c.getNumber());
		}
	}
}

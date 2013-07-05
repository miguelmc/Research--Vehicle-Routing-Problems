package vrpApp;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class XMLProblemReader extends DefaultHandler implements IProblemReader {

	private final double INFINITE_DISTANCE = Double.MAX_VALUE/2;
	private final int INFINITE_TIME = Integer.MAX_VALUE/2;
	
	// variables used to store the values received in the File.
	private Vehicle vehicle;
	private Client client;
	private List<Double> distances;
	private List<Integer> times;
	private Problem problem = new Problem();
	private String valueInsideATag;
	private boolean tagDistances = false;
	private boolean tagTimes = false;
	//checks if XML is actually a configuration file;
	private boolean tagInstance = false;
	private int numClients;
	private String temp;
	
	public Problem createProblem(File problemFile) {
		// ConfigurationParams object that will be returned.
		XMLProblemReader handler = null;
		try{
			//Create a "parser factory" for creating SAX parsers
			SAXParserFactory spfac = SAXParserFactory.newInstance();

			//Now use the parser factory to create a SAXParser object
			SAXParser sp = spfac.newSAXParser();

			//Create an instance of this class; it defines all the handler methods
			handler = new XMLProblemReader();

			//Finally, tell the parser to parse the input and notify the handler
			sp.parse(problemFile, handler);
		}
		catch(Exception e){
			e.printStackTrace();
			ErrorHandler.showError(5,"XMLProblemReader.createConfigurationParams(File)",true);
		}
		
		return handler.getProblem();
	}
	
	//looks for tag
	public void startElement(String uri, String localName,
			String qName, Attributes attributes)
			throws SAXException {

		// Control of which tag is curretly open. Needed since
		// inside all these elements it is all the same
		if (qName.equalsIgnoreCase("instance")) {
			tagInstance = true;
		}
		
		if (qName.equalsIgnoreCase("set")) {
			vehicle = new Vehicle();
		}
		if (qName.equalsIgnoreCase("client")) {
			client = new Client();
		}
		if (qName.equalsIgnoreCase("distances")) {
			distances = new ArrayList<Double>(numClients+1);
			//fills the array
			for(int i=0; i<26; i++)
				distances.add(INFINITE_DISTANCE);
			tagDistances = true;
		}
		if (qName.equalsIgnoreCase("times")) {
			times = new ArrayList<Integer>(numClients+1);
			//fills the array
			for(int i=0; i<26; i++)
				times.add(INFINITE_TIME);
			tagTimes = true;
		}
	}

	public void endElement(String uri, String localName,
			String qName) throws SAXException {

		//Error check
		if(!tagInstance)
			ErrorHandler.showError(24, "XMLProblemReader.createConfigurationParams(File)", true);
		
		//General
		if(qName.equalsIgnoreCase("type")){
			problem.setType(valueInsideATag);
		}
		else if(qName.equalsIgnoreCase("name")){
			problem.setInstanceName(valueInsideATag);
		}
			
			
		// Vehicle subtree
		else if (qName.equalsIgnoreCase("set")) {
			problem.addVehicle(vehicle);
		} else if (qName.equalsIgnoreCase("vehicle_count")) {
			vehicle.setVehicleCount(Integer.parseInt(valueInsideATag));
		} else if (qName.equalsIgnoreCase("capacity")) {
			vehicle.setCapacity(Integer.parseInt(valueInsideATag));
		}
		// Client subtree
		else if (qName.equalsIgnoreCase("client")) {
			problem.addClient(client);
		} else if (qName.equalsIgnoreCase("client_count")){
			numClients = Integer.parseInt(valueInsideATag);
		}else if (qName.equalsIgnoreCase("number")) {
			client.setNumber(Integer.parseInt(valueInsideATag));
		} else if (qName.equalsIgnoreCase("x")) {
			client.setX(Integer.parseInt(valueInsideATag));
		} else if (qName.equalsIgnoreCase("y")) {
			client.setY(Integer.parseInt(valueInsideATag));
		} else if (qName.equalsIgnoreCase("demand")) {
			client.setDemand(Integer.parseInt(valueInsideATag));
		} else if (qName.equalsIgnoreCase("service_time")) {
			client.setServiceTime(Integer.parseInt(valueInsideATag));
		} else if (qName.equalsIgnoreCase("start")){
			client.setTimeWindowStart(Integer.parseInt(valueInsideATag));
		} else if (qName.equalsIgnoreCase("end")){
			client.setTimeWindowEnd(Integer.parseInt(valueInsideATag));
		} else if (qName.equalsIgnoreCase("flexible")){
			if(valueInsideATag.equalsIgnoreCase("y"))
				client.setTimeWindowFlexible(true);
			else
				client.setTimeWindowFlexible(false);
		}
		
		
		//Distances subtree
		else if(qName.equalsIgnoreCase("distances")){
			client.setDistances(distances);
			tagDistances = false;
		}
		else if(tagDistances && qName.matches("client_\\d+")){
			temp = qName;
			distances.set(Integer.parseInt(temp.split("_")[1]), Double.parseDouble(valueInsideATag));
			//distances.add(Double.parseDouble(valueInsideATag));
		}
		
		//Times subtree
		else if(qName.equalsIgnoreCase("times")){
			client.setTimes(times);
			tagTimes = false;
		}
		else if(tagTimes && qName.matches("client_\\d+")){
			temp = qName;
			times.set(Integer.parseInt(temp.split("_")[1]), Integer.parseInt(valueInsideATag));
			//times.add(Integer.parseInt(valueInsideATag));
		}
	}

	public void characters(char ch[], int start, int length)
			throws SAXException {

		valueInsideATag = new String(ch, start, length);
	}
	
	public Problem getProblem(){
		return problem;
	}
}
		
		
		

		//FOR REFERENCE, delete when not needed

//		try {
//
//			SAXParserFactory factory = SAXParserFactory.newInstance();
//			SAXParser saxParser = factory.newSAXParser();
//			DefaultHandler handler = new DefaultHandler() {
//
//				// gets access to the value inside an element (if it applies)
//				String valueInsideATag;
//
//				// looks for tag
//				public void startElement(String uri, String localName,
//						String qName, Attributes attributes)
//						throws SAXException {
//
//					// Control of which tag is curretly open. Needed since
//					// inside all these elements it is all the same
//					if (qName.equalsIgnoreCase("set")) {
//						vehicle = new Vehicle();
//					}
//					if (qName.equalsIgnoreCase("client")) {
//						client = new Client();
//					}
//				}
//
//				public void endElement(String uri, String localName,
//						String qName) throws SAXException {
//
//					//General
//					if(qName.equalsIgnoreCase("type")){
//						problem.setType(valueInsideATag);
//					}
//					else if(qName.equalsIgnoreCase("name")){
//						problem.setInstanceName(valueInsideATag);
//					}
//						
//						
//					// Vehicle subtree
//					else if (qName.equalsIgnoreCase("set")) {
//						problem.addVehicle(vehicle);
//					} else if (qName.equalsIgnoreCase("vehicle_count")) {
//						vehicle.setVehicleCount(Integer.parseInt(valueInsideATag));
//					} else if (qName.equalsIgnoreCase("capacity")) {
//						vehicle.setCapacity(Integer.parseInt(valueInsideATag));
//					}
//					// Client subtree
//					else if (qName.equalsIgnoreCase("client")) {
//						problem.addClient(client);
//					} else if (qName.equalsIgnoreCase("number")) {
//						client.setNumber(Integer.parseInt(valueInsideATag));
//					} else if (qName.equalsIgnoreCase("x")) {
//						client.setX(Integer.parseInt(valueInsideATag));
//					} else if (qName.equalsIgnoreCase("y")) {
//						client.setY(Integer.parseInt(valueInsideATag));
//					} else if (qName.equalsIgnoreCase("demand")) {
//						client.setDemand(Integer.parseInt(valueInsideATag));
//					} else if (qName.equalsIgnoreCase("service_time")) {
//						client.setServiceTime(Integer.parseInt(valueInsideATag));
//					}
//				}
//
//				public void characters(char ch[], int start, int length)
//						throws SAXException {
//
//					valueInsideATag = new String(ch, start, length);
//				}
//			};
//
//			try {
//				saxParser.parse(problemFile, handler);
//			} catch (Exception e) {
//				ErrorHandler.showError(5,
//						"XMLProblemReader.createConfigurationParams(File)",
//						true);
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		return problem;
//	}

//}

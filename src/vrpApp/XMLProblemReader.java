package vrpApp;

import java.io.File;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class XMLProblemReader implements IProblemReader {

	// variables used to store the values received in the File.
	private Vehicle vehicle;
	private Client client;
	private Problem problem;

	public Problem createProblem(File problemFile) {
		// ConfigurationParams object that will be returned.
		problem = new Problem();

		try {

			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser saxParser = factory.newSAXParser();
			DefaultHandler handler = new DefaultHandler() {

				// gets access to the value inside an element (if it applies)
				String temp;

				// looks for tag
				public void startElement(String uri, String localName,
						String qName, Attributes attributes)
						throws SAXException {

					// Control of which tag is curretly open. Needed since
					// inside all these elements it is all the same
					if (qName.equalsIgnoreCase("set")) {
						vehicle = new Vehicle();
					}
					if (qName.equalsIgnoreCase("client")) {
						client = new Client();
					}
				}

				public void endElement(String uri, String localName,
						String qName) throws SAXException {

					// Vehicle subtree
					if (qName.equalsIgnoreCase("set")) {
						problem.addVehicle(vehicle);
					} else if (qName.equalsIgnoreCase("vehicle_count")) {
						vehicle.setVehicleCount(Integer.parseInt(temp));
					} else if (qName.equalsIgnoreCase("capacity")) {
						vehicle.setCapacity(Integer.parseInt(temp));
					}
					// Client subtree
					else if (qName.equalsIgnoreCase("client")) {
						problem.addClient(client);
					} else if (qName.equalsIgnoreCase("number")) {
						client.setNumber(Integer.parseInt(temp));
					} else if (qName.equalsIgnoreCase("x")) {
						client.setX(Integer.parseInt(temp));
					} else if (qName.equalsIgnoreCase("y")) {
						client.setY(Integer.parseInt(temp));
					} else if (qName.equalsIgnoreCase("demand")) {
						client.setDemand(Integer.parseInt(temp));
					} else if (qName.equalsIgnoreCase("service_time")) {
						client.setServiceTime(Integer.parseInt(temp));
					}
				}

				public void characters(char ch[], int start, int length)
						throws SAXException {

					temp = new String(ch, start, length);
				}
			};

			try {
				saxParser.parse(problemFile, handler);
			} catch (Exception e) {
				ErrorHandler.showError(5,
						"XMLProblemReader.createConfigurationParams(File)",
						true);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return problem;
	}

}

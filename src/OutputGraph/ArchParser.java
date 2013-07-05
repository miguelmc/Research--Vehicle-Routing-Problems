package OutputGraph;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import vrpApp.ErrorHandler;

public class ArchParser extends DefaultHandler{

	ArrayList<Route> routes = new ArrayList<Route>();
	String valueInsideATag;
	// temporary
	Route route;
	ArrayList<Point> points;
	int index, curr;
	
	public void setPoints( ArrayList<Point> points) {
		this.points = points;
	}
	
	public ArrayList<Route> getArches(File solution) {
		try{
			//Create a "parser factory" for creating SAX parsers
			SAXParserFactory spfac = SAXParserFactory.newInstance();

			//Now use the parser factory to create a SAXParser object
			SAXParser sp = spfac.newSAXParser();

			//Finally, tell the parser to parse the input and notify the handler
			sp.parse(solution, this);
		}
		catch(Exception e){
			e.printStackTrace();
			ErrorHandler.showError(5,"XMLProblemReader.createConfigurationParams(File)",true);
		}

		return routes;
	}

	// looks for tag
	public void startElement(String uri, String localName,
			String qName, Attributes attributes)
					throws SAXException {

		if(qName.equalsIgnoreCase("route"))
				route = new Route();

		
	}

	public void endElement(String uri, String localName,
			String qName) throws SAXException {
		
		if(qName.equalsIgnoreCase("route"))
			routes.add(route);
		
		//if(qName.equalsIgnoreCase("client_count"))
		//	route.setLength(Integer.parseInt(valueInsideATag));
		
		if(qName.matches("client_\\d+")) {
			curr = Integer.parseInt(valueInsideATag);
			index = Integer.parseInt(qName.split("_")[1]) -1 ;
			System.out.println(curr + " " + index);
			route.addPoint(index, points.get(curr));
		}
	}

	public void characters(char ch[], int start, int length)
			throws SAXException {

		valueInsideATag = new String(ch, start, length);
	}
	
}

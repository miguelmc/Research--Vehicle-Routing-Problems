package OutputGraph;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import vrpApp.ErrorHandler;

public class PointParser extends DefaultHandler{

	ArrayList<Point> points = new ArrayList<Point>();
	String valueInsideATag;
	int currentClient;
	// temporary
	Point point = new Point();
	
	public ArrayList<Point> getPoints(File problem) {
		try{
			//Create a "parser factory" for creating SAX parsers
			SAXParserFactory spfac = SAXParserFactory.newInstance();

			//Now use the parser factory to create a SAXParser object
			SAXParser sp = spfac.newSAXParser();

			//Finally, tell the parser to parse the input and notify the handler
			sp.parse(problem, this);
		}
		catch(Exception e){
			e.printStackTrace();
			ErrorHandler.showError(5,"XMLProblemReader.createConfigurationParams(File)",true);
		}

		return points;
	}

	// looks for tag
	public void startElement(String uri, String localName,
			String qName, Attributes attributes)
			throws SAXException {

	}

	public void endElement(String uri, String localName,
			String qName) throws SAXException {
		
		if (qName.equalsIgnoreCase("client_count")) {
			int clientCount = Integer.parseInt(valueInsideATag);
			points = new ArrayList<Point>(clientCount+1);
			for(int i=0; i<clientCount+1;i++)
				points.add(new Point());
		}
		if (qName.equalsIgnoreCase("number")) {
			currentClient = Integer.parseInt(valueInsideATag);
		}
		if (qName.equalsIgnoreCase("x")) {
			points.get(currentClient).setX(Double.parseDouble(valueInsideATag));
		}
		if (qName.equalsIgnoreCase("y")) {
			points.get(currentClient).setY(Double.parseDouble(valueInsideATag));
		}

	}

	// Once it finds a tag, it enters this method, only useful for
	// <x> and <y>
	public void characters(char ch[], int start, int length)
			throws SAXException {

		valueInsideATag = new String(ch, start, length);
	}
	
}

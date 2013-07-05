package vrpApp;

/**
 * Actual implementation of the XML parser (using SAX parser).
 * Implements IConfigReader for it to be able to read other types of configuration files in
 * some future.
 * 
 * @author Miguel Mtz, miguelmtz93@gmail.com
 *
 */

import java.io.File;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class XMLConfigReader extends DefaultHandler implements IConfigReader {

	private ConfigurationParams configParams = new ConfigurationParams();
	// Variable assures that the XML has a name for all 3 obligatory
	// fields.
	private boolean tagAlgorithm = false;
	private boolean tagHeuristic = false;
	private boolean tagObjectiveFunction = false;
	private boolean tagMiscelaneous = false;
	private boolean tagParameter = false;
	//checks if XML is actually a configuration file;
	private boolean tagConfiguration = false;
	// used to store the value "name" inside one parameter before it
	// is stored
	private String nameVal;
	// gets access to the value inside an element (if it applies)
	private String valueInsideATag = "";

	public ConfigurationParams createConfigurationParams(File configFile) {

		// ConfigurationParams object that will be returned.
		try{
			//Create a "parser factory" for creating SAX parsers
			SAXParserFactory spfac = SAXParserFactory.newInstance();

			//Now use the parser factory to create a SAXParser object
			SAXParser sp = spfac.newSAXParser();

			//Finally, tell the parser to parse the input and notify the handler
			sp.parse(configFile, this);
		}
		catch(Exception e){
			ErrorHandler.showError(4,"XMLConfigReader.createConfigurationParams(File)",true);
		}
		
		return configParams;
	}
	// looks for tag
	@Override
	public void startElement(String uri, String localName,
			String qName, Attributes attributes) {

		// Control of which tag is curretly open. Needed since
		// inside all these elements it is all the same
		if (qName.equalsIgnoreCase("configuration")) {
			tagConfiguration = true;
		}
		
		if (qName.equalsIgnoreCase("algorithm")) {
			tagAlgorithm = true;
		}

		if (qName.equalsIgnoreCase("heuristic")) {
			tagHeuristic = true;
		}

		if (qName.equalsIgnoreCase("objective_function")) {
			tagObjectiveFunction = true;
		}

		if (qName.equalsIgnoreCase("miscelaneous")) {
			tagMiscelaneous = true;
		}

		if (qName.equalsIgnoreCase("parameter")) {
			tagParameter = true;
		}
	}

	@Override
	public void endElement(String uri, String localName,
			String qName) {

		/*
		 * Means it didn't find the obligatory "algorithm",
		 * "heuristic", and "objective_function tags. XML/txt not
		 * valid. Sends error
		 */
		if(!tagConfiguration)
			ErrorHandler.showError(23, "XMLConfigReader.createConfigurationParams(File)", true);

		if (qName.equalsIgnoreCase("algorithm")) {

			tagAlgorithm = false;
		}

		if (qName.equalsIgnoreCase("heuristic")) {
			tagHeuristic = false;
		}

		if (qName.equalsIgnoreCase("objective_function")) {
			tagObjectiveFunction = false;
		}

		if (qName.equalsIgnoreCase("miscelaneous")) {
			tagMiscelaneous = false;
		}

		if (qName.equalsIgnoreCase("parameter")) {
			tagParameter = false;
		}

		if (tagAlgorithm) {

			if (qName.equalsIgnoreCase("name")) {
				// name element belongs to algorithm
				if (!tagParameter) {
					configParams.setAlgorithmName(valueInsideATag);
				}
				// belongs to parameter inside algorithm element
				else
					nameVal = valueInsideATag;
			} else if (qName.equalsIgnoreCase("value")) {

				configParams.setAlgorithmParam(nameVal,
						valueInsideATag);
			}

		} else if (tagHeuristic) {

			if (qName.equalsIgnoreCase("name")) {
				// name element belongs to algorithm
				if (!tagParameter) {
					configParams.setHeuristicName(valueInsideATag);
				}
				// belongs to parameter inside algorithm element
				else
					nameVal = valueInsideATag;
			} else if (qName.equalsIgnoreCase("value")) {
				configParams.setHeuristicParam(nameVal,
						valueInsideATag);
			}

		} else if (tagObjectiveFunction) {

			if (qName.equalsIgnoreCase("name")) {
				// name element belongs to algorithm
				if (!tagParameter) {
					configParams
					.setObjectiveFunctionName(valueInsideATag);
				}
				// belongs to parameter inside algorithm element
				else
					nameVal = valueInsideATag;
			} else if (qName.equalsIgnoreCase("value")) {
				configParams.setOFParam(nameVal, valueInsideATag);
			}

		} else if (tagMiscelaneous) {

			if (qName.equalsIgnoreCase("name")) {
				nameVal = valueInsideATag;
			} else if (qName.equalsIgnoreCase("value")) {
				configParams.setMiscParam(nameVal, valueInsideATag);
			}
		}
	}
	@Override
	public void characters(char ch[], int start, int length) {
		valueInsideATag = new String(ch, start, length);
	}
}
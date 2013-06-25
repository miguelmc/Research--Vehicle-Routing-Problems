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

public class XMLConfigReader implements IConfigReader {

	private ConfigurationParams configParams = new ConfigurationParams();

	public ConfigurationParams createConfigurationParams(File configFile) {

		// ConfigurationParams object that will be returned.
		configParams = new ConfigurationParams();
		try {
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser saxParser = factory.newSAXParser();
			DefaultHandler handler = new DefaultHandler() {

				// Variable assures that the XML has a name for all 3 obligatory
				// fields.
				// int valid = 0;
				boolean tagAlgorithm = false;
				boolean tagHeuristic = false;
				boolean tagObjectiveFunction = false;
				boolean tagMiscelaneous = false;
				boolean tagParameter = false;
				// used to store the value "name" inside one parameter before it
				// is stored
				String nameVal;
				// gets access to the value inside an element (if it applies)
				String valueInsideATag = "";

				// looks for tag
				public void startElement(String uri, String localName,
						String qName, Attributes attributes) {

					// Control of which tag is curretly open. Needed since
					// inside all these elements it is all the same
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

				public void endElement(String uri, String localName,
						String qName) {

					/*
					 * Means it didn't find the obligatory "algorithm",
					 * "heuristic", and "objective_function tags. XML/txt not
					 * valid. Sends error
					 */
					/*
					 * if(qName.equalsIgnoreCase("configuration") && valid <3){
					 * ErrorHandler.showError(4,
					 * "XMLConfigReader.createConfigurationParams(File)", true);
					 * }
					 */

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
								// ++valid;
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
								// ++valid;
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
								// ++valid;
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

				public void characters(char ch[], int start, int length) {
					valueInsideATag = new String(ch, start, length);
				}
			};
			try {
				saxParser.parse(configFile, handler);
			} catch (Exception e) {
				e.printStackTrace();
				ErrorHandler
						.showError(
								4,
								"XMLConfigReader.createConfigurationParams(File)",
								true);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return configParams;
	}
}

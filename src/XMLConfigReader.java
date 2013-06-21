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
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class XMLConfigReader implements IConfigReader {

	public ConfigurationParams createConfigurationParams(File configFile) {
		// ConfigurationParams object that will be returned.
		//final
		final ConfigurationParams configParams = new ConfigurationParams();
		try {
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser saxParser = factory.newSAXParser();
			DefaultHandler handler = new DefaultHandler() {

				// true if currently inside element's tag
				int valid = 0;
				boolean tagAlgorithm = false;
				boolean tagHeuristic = false;
				boolean tagObjectiveFunction = false;
				boolean tagMiscelaneous = false;
				boolean tagParameter = false;
				// used to store the value "name" inside one parameter before it
				// is stored
				String nameVal;
				// gets access to the value inside an element (if it applies)
				String temp;

				// looks for tag
				public void startElement(String uri, String localName,
						String qName, Attributes attributes)
						throws SAXException {

					// Control of which tag is curretly open. Needed since
					// inside all these elements it is all the same
					if (qName.equalsIgnoreCase("algorithm")) {
						++valid;
						tagAlgorithm = true;
					}

					if (qName.equalsIgnoreCase("heuristic")) {
						++valid;
						tagHeuristic = true;
					}

					if (qName.equalsIgnoreCase("objective_function")) {
						++valid;
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
						String qName) throws SAXException {

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
							if (!tagParameter)
								configParams.setAlgorithmName(temp);
							// belongs to parameter inside algorithm element
							else
								nameVal = temp;
						} else if (qName.equalsIgnoreCase("value")) {
							configParams.setAlgorithmParam(nameVal, temp);
						}

					} else if (tagHeuristic) {

						if (qName.equalsIgnoreCase("name")) {
							// name element belongs to algorithm
							if (!tagParameter)
								configParams.setHeuristicName(temp);
							// belongs to parameter inside algorithm element
							else
								nameVal = temp;
						} else if (qName.equalsIgnoreCase("value")) {
							configParams.setHeuristicParam(nameVal, temp);
						}

					} else if (tagObjectiveFunction) {

						if (qName.equalsIgnoreCase("name")) {
							// name element belongs to algorithm
							if (!tagParameter)
								configParams.setObjectiveFunctionName(temp);
							// belongs to parameter inside algorithm element
							else
								nameVal = temp;
						} else if (qName.equalsIgnoreCase("value")) {
							configParams.setOFParam(nameVal, temp);
						}

					} else if (tagMiscelaneous) {

						if (qName.equalsIgnoreCase("name")) {
							nameVal = temp;
						} else if (qName.equalsIgnoreCase("value")) {
							configParams.setMiscParam(nameVal, temp);
						}

					}

				}

				public void characters(char ch[], int start, int length)
						throws SAXException {

					temp = new String(ch, start, length);
				}
			};

			saxParser.parse(configFile, handler);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return configParams;
	}
}

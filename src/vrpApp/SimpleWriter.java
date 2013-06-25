package vrpApp;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Calendar;
import java.util.Map.Entry;

public class SimpleWriter implements IWriter {

	public void write(String problemName, Solution solution,
			ConfigurationParams configParams) throws IOException {
		FileOutputStream outfile = new FileOutputStream("/home/mike/"
				+ problemName + "SOL.xml");
		OutputStreamWriter output = new OutputStreamWriter(outfile, "UTF-8");

		output.write("<?xml version=\"1.0\"?>\n" + "<solution>\n"
				+ "\t<instance>\n");
		// TODO
		output.write("\t\t<name>" + problemName + "</name>\n");

		// ALGORITHM
		output.write("\t\t<algorithm>\n");
		output.write("\t\t\t<name>" + configParams.getAlgorithmName()
				+ "</name>\n");
		output.write("\t\t\t<parameter>\n");

		for (Entry<String, String> elem : configParams.getAlgorithmParams()
				.entrySet()) {
			output.write("\t\t\t\t<name>" + elem.getKey() + "</name>\n");
			output.write("\t\t\t\t<value>" + elem.getValue() + "</value>\n");
		}
		output.write("\t\t\t</parameter>\n");
		output.write("\t\t</algorithm>\n");

		// HEURISTIC
		output.write("\t\t<heuristic>\n");
		output.write("\t\t\t<name>" + configParams.getHeuristicName()
				+ "</name>\n");
		output.write("\t\t\t<parameter>\n");

		for (Entry<String, String> elem : configParams.getHeuristicParams()
				.entrySet()) {
			output.write("\t\t\t\t<name>" + elem.getKey() + "</name>\n");
			output.write("\t\t\t\t<value>" + elem.getValue() + "</value>\n");
		}

		output.write("\t\t\t</parameter>\n");
		output.write("\t\t</heuristic>\n");

		// OBJECTIVE FUNCTION
		output.write("\t\t<objective_function>\n");
		output.write("\t\t\t<name>" + configParams.getObjectiveFunctionName()
				+ "</name>\n");
		output.write("\t\t\t<parameter>\n");

		for (Entry<String, String> elem : configParams.getOFParams().entrySet()) {
			output.write("\t\t\t\t<name>" + elem.getKey() + "</name>\n");
			output.write("\t\t\t\t<value>" + elem.getValue() + "</value>\n");
		}

		output.write("\t\t\t</parameter>\n");
		output.write("\t\t</objective_function>\n");

		output.write("\t\t<total_distance>" + solution.getTotalDistance()
				+ "</total_distance>\n");
		output.write("\t\t<total_time>" + solution.getTotalTime()
				+ "</total_time>\n");
		output.write("\t\t<total_aptitude>" + solution.getTotalAptitude()
				+ "</total_aptitude>\n");

		// DATES
		// The month index in java.util.Calendar begins with January=0 so that
		// we have to add 1 to the month.
		Calendar date = solution.getDate();
		output.write("\t\t<date>\n");
		output.write("\t\t\t<day>" + date.get(Calendar.DAY_OF_MONTH)
				+ "</day>\n");
		output.write("\t\t\t<month>" + (date.get(Calendar.MONTH) + 1)
				+ "</month>\n");
		output.write("\t\t\t<year>" + date.get(Calendar.YEAR) + "</year>\n");
		output.write("\t\t</date>\n");

		output.write("<execution_time>" + solution.getExecutionTimeInMillis()
				+ "</execution_time>\n");

		// PC SPECS
		output.write("\t\t<pc_specification>\n");
		output.write("\t\t\t<os_name>" + System.getProperty("os.name")
				+ "</os_name>\n");
		output.write("\t\t\t<os_architeture>"
				+ System.getProperty("sun.arch.data.model")
				+ "</os_architeture>\n");
		output.write("\t\t\t<processor_count>"
				+ Runtime.getRuntime().availableProcessors()
				+ "</processor_count>\n");
		output.write("\t\t</pc_specification>\n");

		output.write("\t<routes>\n");
		for (Route route : solution.getRoutes()) {
			output.write("\t\t<route>\n");
			output.write("\t\t\t<client_count>" + route.getClientCount()
					+ "</client_count>\n\t\t\t");
			for (int i = 1; i <= route.getClients().size(); i++) {
				output.write("<client_" + i + ">"
						+ route.getClientAt(i).getNumber() + "</client_" + i
						+ ">");
			}
			output.write("\n\t\t</route>\n");
		}
		output.write("\t</routes>\n");
		output.write("\t</instance>\n");
		output.write("</solution>\n");
		output.close();
	}

}

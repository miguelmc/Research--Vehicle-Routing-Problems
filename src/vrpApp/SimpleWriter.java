package vrpApp;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Calendar;
import java.util.Map.Entry;

public class SimpleWriter extends Writr {
	
	public void write(String problemName, Solution solution,
			ConfigurationParams configParams){
		
		String lineSep = System.getProperty("line.separator");
		
		if(outputFolder == null){
			ErrorHandler.showError(17, "SimpleWriter.write()", true);
		}
		
		try{
			outputFolder.mkdir();
			File outFile = new File(outputFolder.getPath() 
					+ System.getProperty("file.separator") + problemName + "SOL.xml");
			outFile.setWritable(true);
			outFile.setExecutable(true);
			outFile.setReadable(true);
			FileOutputStream outfile = new FileOutputStream(outFile);
			OutputStreamWriter output = new OutputStreamWriter(outfile, "UTF-8");


			output.write("<?xml version=\"1.0\"?>" + lineSep + "<solution>" + lineSep + "\t<instance>" + lineSep);
			output.write("\t\t<name>" + problemName + "</name>" + lineSep);

			// ALGORITHM-----------------------------------------------------------------------------
			output.write("\t\t<algorithm>" + lineSep);
			output.write("\t\t\t<name>" + configParams.getAlgorithmName() + "</name>" + lineSep);
			for (Entry<String, String> elem : configParams.getAlgorithmParams().entrySet()) {
				output.write("\t\t\t<parameter>" + lineSep);
				output.write("\t\t\t\t<name>" + elem.getKey() + "</name>" + lineSep);
				output.write("\t\t\t\t<value>" + elem.getValue() + "</value>" + lineSep);
				output.write("\t\t\t</parameter>" + lineSep);
			}
			
			output.write("\t\t</algorithm>" + lineSep);
			//---------------------------------------------------------------------------------------
			// HEURISTIC
			output.write("\t\t<heuristic>" + lineSep);
			output.write("\t\t\t<name>" + configParams.getHeuristicName() + "</name>" + lineSep);

			for (Entry<String, String> elem : configParams.getHeuristicParams().entrySet()) {
				output.write("\t\t\t<parameter>" + lineSep);
				output.write("\t\t\t\t<name>" + elem.getKey() + "</name>" + lineSep);
				output.write("\t\t\t\t<value>" + elem.getValue() + "</value>" + lineSep);
				output.write("\t\t\t</parameter>" + lineSep);
			}
			
			output.write("\t\t</heuristic>" + lineSep);

			// OBJECTIVE FUNCTION--------------------------------------------------------------------
			output.write("\t\t<objective_function>" + lineSep);
			output.write("\t\t\t<name>" + configParams.getObjectiveFunctionName() + "</name>" + lineSep);
			
			for (Entry<String, String> elem : configParams.getOFParams().entrySet()) {
				output.write("\t\t\t<parameter>" + lineSep);
				output.write("\t\t\t\t<name>" + elem.getKey() + "</name>" + lineSep);
				output.write("\t\t\t\t<value>" + elem.getValue() + "</value>" + lineSep);
				output.write("\t\t\t</parameter>" + lineSep);
			}

			output.write("\t\t</objective_function>" + lineSep);

			output.write("\t\t<total_distance>" + solution.getTotalDistance() + "</total_distance>" + lineSep);
			output.write("\t\t<total_time>" + solution.getTotalTime() + "</total_time>" + lineSep);
			output.write("\t\t<total_aptitude>" + solution.getTotalAptitude() + "</total_aptitude>" + lineSep);

			// DATES----------------------------------------------------------------------------------
			// The month index in java.util.Calendar begins with January=0 so that
			// we have to add 1 to the month.
			Calendar date = solution.getDate();
			output.write("\t\t<date>" + lineSep);
			output.write("\t\t\t<day>" + date.get(Calendar.DAY_OF_MONTH) + "</day>" + lineSep);
			output.write("\t\t\t<month>" + (date.get(Calendar.MONTH) + 1) + "</month>" + lineSep);
			output.write("\t\t\t<year>" + date.get(Calendar.YEAR) + "</year>" + lineSep);
			output.write("\t\t</date>" + lineSep);

			output.write("\t\t<execution_time>" + solution.getExecutionTimeInMillis()
					+ "</execution_time>" + lineSep);

			// PC SPECS
			output.write("\t\t<pc_specification>" + lineSep);
			output.write("\t\t\t<os_name>" + System.getProperty("os.name") + "</os_name>" + lineSep);
			output.write("\t\t\t<os_architeture>" + System.getProperty("sun.arch.data.model") + "</os_architeture>" + lineSep);
			output.write("\t\t\t<processor_count>" + Runtime.getRuntime().availableProcessors() + "</processor_count>" + lineSep);
			output.write("\t\t</pc_specification>" + lineSep);

			output.write("\t\t<routes>" + lineSep);
			for (Route route : solution.getRoutes()) {
				output.write("\t\t\t<route>" + lineSep);
				output.write("\t\t\t\t<total_demand>" + route.getDemand() + "</total_demand>" + lineSep);
				output.write("\t\t\t\t<vehicle_capacity>" + route.getVehicleCapacity() + "</vehicle_capacity>" + lineSep);
				output.write("\t\t\t\t<client_count>" + route.getClientCount() + "</client_count>\n\t\t\t\t");
				for (int i = 1; i <= route.getClientCount(); i++) {
					output.write("<client_" + i + ">" + route.getClientAt(i).getClientNumber() + "</client_" + i + ">\n\t\t\t\t");
				}
				output.write("\n\t\t\t</route>" + lineSep);
			}
			output.write("\t\t</routes>" + lineSep);
			output.write("\t</instance>" + lineSep);
			output.write("</solution>" + lineSep);
			output.close();
		}catch(IOException e){
			e.printStackTrace();
			ErrorHandler.showError(9, "SimpleWriter.write(String, Solution, ConfigurationParams)", true);
		}
	}

}

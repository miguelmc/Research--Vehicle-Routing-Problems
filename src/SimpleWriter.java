import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class SimpleWriter implements IWriter {

	public void write(Solution solution, ConfigurationParams configParams) throws IOException {
		//TODO: what name?
		FileOutputStream outfile = new FileOutputStream("/home/mike/needABetterName.xml");
		OutputStreamWriter output = new OutputStreamWriter(outfile, "UTF-8");

		output.write("<?xml version=\"1.0\"?>\n" +
						"<solution>\n" +
							"\t<instance>\n");
		//TODO
		output.write("\t\t<name> missing param </name>\n");
		
		//ALGORITHM
		output.write("\t\t<algorithm>\n");
		output.write("\t\t\t<name>" + configParams.getAlgorithmName() + "</name>\n");
		output.write("\t\t\t<parameter>\n");
			//TODO: configParams cannot give its key value params.
		output.write("\t\t\t</parameter\n>");
		output.write("\t\t</algorithm>\n");
		
		//HEURISTIC
		output.write("\t\t<heuristic>\n");
		output.write("\t\t\t<name>" + configParams.getHeuristicName() + "</name>\n");
		output.write("\t\t\t<parameter>\n");
			//TODO: configParams cannot give its key value params.
		output.write("\t\t\t</parameter>\n");
		output.write("\t\t</heuristic>\n");
		
		//OBJECTIVE FUNCTION
		output.write("\t\t<objective_function>\n");
		output.write("\t\t\t<name>" + configParams.getobjectiveFunctionName() + "</name>\n");
		output.write("\t\t\t<parameter>\n");
			//TODO: configParams cannot give its key value params.
		output.write("\t\t\t</parameter>\n");
		output.write("\t\t</objective_function>\n");
		
		//TODO: MISCELANEOUS???????
		
		output.write("\t\t<total_distance>"+ solution.getTotalDistance() +"</total_distance>\n");
		output.write("\t\t<total_time>"+ solution.getTotalTime() +"</total_time>\n");
		output.write("\t\t<total_aptitude>"+ solution.getTotalAptitude() +"</total_aptitude>\n");
		
		//TODO: check if calendar is better
		output.write("\t\t<date>\n");
		output.write("\t\t\t<day>"+ solution.getDateDay() +"</day>\n");
		output.write("\t\t\t<month>"+ solution.getDateMonth() +"</month>\n");
		output.write("\t\t\t<year>"+ solution.getDateYear() +"</year>\n");
		output.write("\t\t</date>\n");
		
		output.write("<execution_time>"+ solution.getExecutionTimeInMillis() +"</execution_time>\n");
		
		//PC SPECS
		output.write("\t\t<pc_specification>\n");
		output.write("\t\t\t<os_name>"+ System.getProperty("os.name") +"</os_name>\n");
		output.write("\t\t\t<os_architeture>"+ System.getProperty("sun.arch.data.model") +"</os_architeture>\n");
		output.write("\t\t\t<processor_count>"+ Runtime.getRuntime().availableProcessors() +"</processor_count>\n");
		output.write("\t\t</pc_specification>\n");
		
		//TODO: check if it is better to enclose all routes on a <routes> tag
		
		for(Route route : solution.getRoutes()){
			output.write("\t\t<route>\n");
			output.write("\t\t\t<client_count>" + route.getClientCount() + "</client_count>\n\t\t\t");
			for(int i=1; i<=route.getClients().size(); i++){
				output.write("<client_" + i +">" + route.getClients().get(i-1).getNumber() + "</client_"+ i+">");
			}
			output.write("\n\t\t</route>\n");
		}
		output.write("\t</instance>\n");
		output.write("</solution>\n");
		output.close();
	}

}

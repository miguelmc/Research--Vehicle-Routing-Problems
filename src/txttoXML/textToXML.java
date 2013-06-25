package txttoXML;

/*
 * Miguel Martinez
 * miguelmtz93@gmail.com
 * 10 de junio 2013
 */

import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class textToXML {
	public static void convert(String inputName, String outputName)
			throws IOException {
		Scanner input = new Scanner(new FileReader(inputName));
		FileOutputStream outfile = new FileOutputStream(outputName);
		OutputStreamWriter output = new OutputStreamWriter(outfile, "UTF-8");

		// gets all coordinates before beginning.
		ArrayList<int[]> coords = new ArrayList<int[]>();
		getCoords(coords, input);

		input = new Scanner(new FileReader(inputName));

		output.write("<?xml version=\"1.0\"?>\n<instance>\n");
		output.write("\t<type>CVRPTW</type>\n");
		output.write("\t<name>" + input.nextLine() + "</name>\n");
		output.write("\t<vehicles>\n");

		// There's only one type of vehicle...
		output.write("\t\t<set>\n");

		input.nextLine();
		input.nextLine();
		input.nextLine();

		output.write("\t\t\t<vehicle_count>" + input.nextInt()
				+ "</vehicle_count>\n");
		output.write("\t\t\t<capacity>" + input.nextInt() + "</capacity>\n");
		output.write("\t\t</set>\n");
		output.write("\t</vehicles>\n");

		input.nextLine();
		input.nextLine();
		input.nextLine();
		input.nextLine();

		// actual client the program is dealing
		int actual = 0;
		while (input.hasNextInt()) {
			output.write("\t<client>\n");
			output.write("\t\t<number>" + input.nextInt() + "</number>\n");
			output.write("\t\t<x>" + input.nextInt() + "</x>\n");
			output.write("\t\t<y>" + input.nextInt() + "</y>\n");
			output.write("\t\t<demand>" + input.nextInt() + "</demand>\n");

			output.write("\t\t<time_window>\n");
			output.write("\t\t\t<start>" + input.nextInt() + "</start>\n");
			output.write("\t\t\t<end>" + input.nextInt() + "</end>\n");

			// Yes for all clients, not for deposit.
			output.write("\t\t\t<flexible>");
			if (actual == 0) {
				output.write("n");
			} else
				output.write("y");
			output.write("</flexible>\n");

			output.write("\t\t</time_window>\n");

			output.write("\t\t<service_time>" + input.nextInt()
					+ "</service_time>\n");

			output.write("\t\t<distances>\n");

			// client currently on loop
			double[] distances = new double[coords.size()];
			int curr = 0;
			for (int[] i : coords) {
				double distance = Math.sqrt(Math.pow(i[0]
						- coords.get(actual)[0], 2)
						+ Math.pow(i[1] - coords.get(actual)[1], 2));
				distances[curr] = distance;

				output.write("\t\t\t<client_" + curr + ">" + distance
						+ "</client_" + curr + ">\n");
				++curr;
			}
			output.write("\t\t</distances>\n");

			output.write("\t\t<times>\n");
			for (int i = 0; i < distances.length; i++)
				output.write("\t\t\t<client_" + i + ">" + distances[i]
						+ "</client_" + i + ">\n");
			output.write("\t\t</times>\n");

			output.write("\t</client>\n");
			++actual;
		}
		output.write("</instance>");
		input.close();
		output.close();

	}

	private static void getCoords(ArrayList<int[]> coords, Scanner input) {

		// skip to coordinates
		for (int i = 0; i < 9; i++)
			input.nextLine();

		while (input.hasNextInt()) {
			int[] pair = new int[2];

			// ignored field
			input.nextInt();

			pair[0] = input.nextInt();
			pair[1] = input.nextInt();
			coords.add(pair);

			// ignored fields
			for (int i = 0; i < 4; i++)
				input.nextInt();
		}
		input.close();
	}
}
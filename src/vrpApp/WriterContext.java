package vrpApp;

import java.io.File;

public class WriterContext {

	private Writr writer;

	public void setStrategy(Writr writer) {
		this.writer = writer;
	}

	// Needs exception because of further Writer classes
	public void write(String problemName, Solution solution,
			ConfigurationParams configParams) {
		writer.write(problemName, solution, configParams);
	}
	
	public void setOutputFolder(File outputFolder){
		writer.setOutputFolder(outputFolder);
	}
}

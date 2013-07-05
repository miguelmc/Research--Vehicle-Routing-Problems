package vrpApp;

import java.io.File;

public class WriterContext {

	private Writr writer;

	public void setStrategy(Writr writer) {
		this.writer = writer;
	}

	public void write(String problemName, Solution solution, ConfigurationParams configParams) {
		try{
			writer.write(problemName, solution, configParams);
		}catch(NullPointerException e){
			ErrorHandler.showError(18, "WriterContext.write(String,Solution,ConfigurationParams)", true);
		}
	}
	
	public void setOutputFolder(File outputFolder){
		try{
			writer.setOutputFolder(outputFolder);
		}catch(NullPointerException e){
			ErrorHandler.showError(18, "WriterContext.setOutputFolder(File)", true);
		}
	}
}

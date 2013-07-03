package vrpApp;

import java.io.File;

public class Writr {
	protected File outputFolder;
	
	public Writr(){
		outputFolder = null;
	}
	
	public void write(String problemName, Solution solution,
			ConfigurationParams configParams){}
	
	public void setOutputFolder(File outputFolder){
		this.outputFolder = outputFolder;
	}
}

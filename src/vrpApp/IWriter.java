package vrpApp;

import java.io.IOException;

public interface IWriter {
	public void write(String problemName, Solution solution,
			ConfigurationParams configParams) throws IOException;
}

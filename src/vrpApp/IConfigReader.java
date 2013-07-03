package vrpApp;

import java.io.File;

public interface IConfigReader{
	// Read configuration parameters from a file.
	public ConfigurationParams createConfigurationParams(File f);
}

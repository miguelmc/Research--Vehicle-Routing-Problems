import java.io.File;


public interface IConfigReader {
	abstract ConfigurationParams read(File f);
}

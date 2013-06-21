import java.io.IOException;

public class WriterContext {

	private IWriter writer;

	public void setStrategy(IWriter writer) {
		this.writer = writer;
	}

	//Needs exception because of further Writer classes
	public void write(Solution solution, ConfigurationParams configParams) throws IOException {
		writer.write(solution, configParams);
	}
}

import java.io.File;


public interface IProblemReader {
	//reads problem file and returns a problem class with all its parameters
	abstract Problem createProblem(File f);
}

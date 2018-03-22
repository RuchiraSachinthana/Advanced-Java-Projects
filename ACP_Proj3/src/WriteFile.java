import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class WriteFile extends IOException {
	
	private PrintWriter outputstream = null;
	
	public void write(String fileName) {
		try {
			//attempt to open the file
			outputstream = new PrintWriter(new FileOutputStream(fileName));
			outputstream.println(fileName);
			outputstream.close();
		}
		catch (FileNotFoundException e) {
			System.out.println("WARNING: Log file not found.");
			System.exit(0);
		}
	}

}

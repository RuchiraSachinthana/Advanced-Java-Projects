import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Log {
	
	private String logName;
	PrintWriter pw = null;
	Scanner in = null;
	
	
	public Log(String logName) {
		super();
		this.logName = logName;
	}



	public String getLogName() {
		return logName;
	}



	public void setLogName(String logName) {
		this.logName = logName;
	}



	public void writeFile(String addToLog) {
		try {
			// open the file
			File file = new File(logName);
			FileWriter fw = new FileWriter(file, true);
			
			// write to file
			pw = new PrintWriter(fw);
			pw.println(addToLog);
			
			// read from the file
			in = new Scanner(new File(logName));
			while(in.hasNextLine()) {
				System.out.println(in.nextLine());
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		finally {
			if(pw!=null) {
				pw.close();
			}
		}
	}
}



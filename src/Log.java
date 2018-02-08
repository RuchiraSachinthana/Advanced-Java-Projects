import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Log {
	
	private String logName;
	
	
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


	// create log file
	public void createLog(String logName) {
		// identifies the name of the logger
		Logger logger = Logger.getLogger(logName);
		
		// FileHandler is used to store all the log messages in a log file
		FileHandler fh;
		
		try {
			// configure the logger with handler and formatter
			fh = new FileHandler("dbOperations.log");
			logger.addHandler(fh);
			SimpleFormatter formatter = new SimpleFormatter();
			fh.setFormatter(formatter);
			
			// use to log messages
			logger.info("Database connected");
		}
		catch(SecurityException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
	logger.info("Database created.");	
	}

}



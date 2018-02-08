import java.io.File;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;



/**
 * @author Keenal Shah
 * COP 4027 Advanced Computer Programming
 * Project 1
 * File Name: Database.java
 * 
 * This class improves the structure of testDB, automates the creation of a database table, add records to the table, and to issue basic queries on the database.  
 */


public class Database {
	
	// Step 1: Create a table in the database
	// Step 2: Add records to the table
	// Step 3: Issue basic queries on db
	
	
	// Load the db driver variables
	private static final String driver = "org.apache.derby.jdbc.EmbeddedDriver";
	private static final String protocol = "jdbc:derby:";
	
	// Connecting to db variables
	private String dbName = "";
	private String logName = "dbOperations.log";
	private Connection conn = null;
	private Statement s = null;
	
	// log variables
	private Log log = null; 
	
	// load driver
	public void loadDriver() {
		try {
			Class.forName(driver);
			System.out.println("Loaded the embedded driver");
		}
		// catches the ClassNotFoundExcpetion, InstantiationException and IllegalAccessException
		catch(Exception err) {
			System.err.println("Unable to load the embedded driver");
			err.printStackTrace(System.err);
			System.exit(0);
		}
	}
	
	// connect to the db 
	public Log createDB(String dbName) {
	
		log = new Log("dbOperations.log");
		File file = new File(logName);
		System.out.println(logName + "created");

		// create db
		try {
			System.out.println("Connecting to and creating the database.");
			conn = DriverManager.getConnection(protocol + dbName + ";create=true");
			log.writeFile(protocol + dbName + ";create=true");
			System.out.println("Database created");
			
		}
		catch(SQLException err) {
			System.err.println("SQL Error");
			err.printStackTrace(System.err);
			System.exit(0);
		}
		
		return log;
	}
	
	////////////////////////////////////////////////////
		
	
	public void createTable(ArrayList<String> fields) {
		String dataType = "(make varchar(50), model varchar(50), weight double, engineSize double, numOfDoors int, isImport boolean)";
		System.out.println(dataType);
		
		try {
			s = conn.createStatement();
			s.execute("DROP TABLE Vehicle");
			s.execute("CREATE TABLE Vehicle" + dataType);
			log.writeFile("CREATE TABLE Vehicle" + dataType);
			System.out.println("Created 'Vehicle' table");
		}
		catch (SQLException err) {
			System.err.println("SQL error.");
			err.printStackTrace(System.err);
			System.exit(0);
		}
	}

	private String extractFields(ArrayList<String> instanceValues) {
		String value;
		String valueString = "(";
		String type;
		for (int i = 0; i < instanceValues.size()/2; i++) {
			value = instanceValues.get(i * 2 + 1);			
			type = instanceValues.get(i * 2);
			if (type.equalsIgnoreCase("String")) {
				valueString += "'" + value + "'";
			}
			else {
				valueString += value;
			}
			if ((i + 1) < (instanceValues.size()/2)) {
				valueString += ", ";
			}
		}
		valueString += ")";
		
		return valueString;
	}	
	
	
		public void addToTable(ArrayList<String> instanceValues) {
			String attributes = extractFields(instanceValues);
			try {
				s.execute("INSERT INTO Vehicle" + " VALUES " + attributes);
				System.out.println("Record successfully inserted into table: Vehicle");
				log.writeFile("INSERT INTO Vehicle"  + " VALUES " + attributes);
			}
			catch (SQLException err) {
				System.err.println("SQL error.");
				err.printStackTrace(System.err);
				System.exit(0);
			}
		}
		
	
	private String extractString(ArrayList<String> instanceFields) {
		String field;
		String selectString = "SELECT ";
		for (int index = 0; index < instanceFields.size()/2; index++) {
			field = instanceFields.get(index * 2 + 1);
			selectString += field;
			if ((index + 1) < (instanceFields.size()/2)) {
				selectString += ", ";
			}
		}
		selectString += " FROM ";
		return selectString;
	}		
	
	
	
	public void readTable(ArrayList<String> instanceFields) throws SQLException {
		String selectString = extractString(instanceFields);
		ResultSet resultSet = s.executeQuery(selectString + "Vehicle");
		log.writeFile(selectString + "Vehicle");
		System.out.println("\nHere are all records from the table Vehicle");
		while(resultSet.next()) {
			display(resultSet);
		}
	}
	
	
	
	private void display(ResultSet resultSet) throws SQLException {
		ResultSetMetaData rsmd = resultSet.getMetaData();
		do {
			for (int index = 1; index <= rsmd.getColumnCount(); index++) {
				if (index > 1) {
					System.out.print(", ");
				}
				String columnValue = resultSet.getString(index);
				System.out.print(columnValue);
			}
			System.out.println();
		}  while (resultSet.next());
	}
	

	
	
	
	
	

}

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
	private static final String protocol = "jdbc.derby:";
	
	// Connecting to db variables
	private String dbName = "";
	private Connection conn = null;
	private Statement s = null;
	
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
	public void createDB(String dbName) {
		
		// create db
		try {
			System.out.println("Connecting to and creating the database.");
			conn = DriverManager.getConnection(protocol + dbName + ";create=true");
			System.out.println("Database created");
			
		}
		catch(SQLException err) {
			System.err.println("SQL Error");
			err.printStackTrace(System.err);
			System.exit(0);
		}
	}
	
	// create table
	private void createTable() {
		
	//	s = conn.createStatement();
	//	ResultSet result = s.executeQuery(sql);
		
		
	}
	
	private String insertFields(ArrayList<String> fields) {
		String fieldString;
		
		fieldString = "(String, double, int, boolean)";
		return fieldString;
	}


}

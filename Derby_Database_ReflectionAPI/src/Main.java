import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
/**
 * 
 * @author Keenal
 * COP 4027 Advanced Computer Programming
 * Project 1
 * File Name: Main.java
 * 
 * This is the tester class. 
 */
public class Main {
	
	public static void main(String[] args) throws SQLException {
		
		// create a db 
		Database db = new Database();
		Log log = db.createDB("Vehicle");
		
		// uses reflection
		Reflection ref = new Reflection();
		ArrayList<String> fields = ref.getFields("Vehicle", log);
		
		// create command for db
		db.createTable(fields);
		
		// create vehicle objs
		Vehicle vh = new Vehicle("make", "model", 0, 0, 0, false);
		vh.getVehicleList();
		
		// populate random Vehicle objs & display records
		Vehicle[] vhList = vh.getVehicleArr();
		for(int i = 0; i < 10 ; i++) {
			ArrayList<String> val = ref.getFieldValues(vhList[i], log);
			db.addToTable(val);
		}
	
		
	}
	

}


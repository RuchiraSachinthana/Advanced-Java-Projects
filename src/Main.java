import java.sql.SQLException;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
	
	public static void main(String[] args) throws SQLException {
		String dbName = "Vehicle";
		
		// create a db
		Database db = new Database();
		Log log = db.createDB(dbName);
		
		// use reflection 
		
		// create sql command
		db.createTable(tableName, fields);
		
		// create vehicle objs
		Vehicle vh = new Vehicle();
		vh.createNewVehicle();
		
		Vehicle[] vehicleArr = vh.getVehicleArr();
		for(int i = 0; i < 10; i++) {
			
		}
	}
	

}


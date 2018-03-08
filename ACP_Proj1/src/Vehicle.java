import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Keenal Shah
 * COP 4027 Advanced Computer Programming
 * Project 1
 * File Name: Vehicle.java
 * 
 * This class creates the Vehicle class as well as generates random Vehicle objects.  
 */
public class Vehicle {
	
	// instance fields
	private String make;
	private String model;
	private double weight;
	private double engineSize;
	private int numOfDoors;
	private boolean isImport;
	
	
	// parameterized constructor
	public Vehicle(String make, String model, double weight, double engineSize, int numOfDoors, boolean isImport) {
		this.make = make;
		this.model = model;
		this.weight = weight;
		this.engineSize = engineSize;
		this.numOfDoors = numOfDoors;
		this.isImport = isImport;
	}
	
	
	// getters and setters
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	public double getEngineSize() {
		return engineSize;
	}
	public void setEngineSize(double engineSize) {
		this.engineSize = engineSize;
	}
	
	public int getNumOfDoors() {
		return numOfDoors;
	}
	public void setNumOfDoors(int numOfDoors) {
		this.numOfDoors = numOfDoors;
	}
	
	public boolean isImport() {
		return isImport;
	}
	public void setIsImport(boolean isImport) {
		isImport = isImport;
	}
	
	// shows most useful information about Vehicle
	public String toString() {
		return "Vehicle: " + make + 
				"Model: " + model +
				"Number of Doors: " + numOfDoors +
				"Engine Size: " + engineSize +
				"Import? " + isImport;
	}
	
	// fields needed to create Vehicle objs
		public int numOfVehicle = 10;
		private Vehicle[] vehicleArr = new Vehicle[numOfVehicle];
		private Random rand = new Random();
		
		// getters and setters for vehicleArr 
	public Vehicle[] getVehicleArr() {
			return vehicleArr;
		}
		public void setVehicleArr(Vehicle[] vehicleArr) {
			this.vehicleArr = vehicleArr;
		}
		
		// get vehicle list
		public void getVehicleList() {
			for(int i = 0; i < 10; i++) {
				vehicleArr[i] = createNewVehicle();
			}
		}
	// automates the creation of a new vehicle
	public Vehicle createNewVehicle() {
		String make = randomMake();
		String model = randomModel();
		double weight = randomWeight(model);
		double engineSize = randomEngineSize(model);
		int numOfDoors = randomNumOfDoors(model);
		boolean isImport = randomIsImport(engineSize);
		
		Vehicle vehicle = new Vehicle(make, model, weight, engineSize, numOfDoors, isImport);	
		
		return vehicle;
	}
	
	public void vehicleList() {
		for(int i = 0; i < 10; i++) {
			vehicleArr[i] = createNewVehicle();
		}
	}
	// random make of Vehicle obj
	private String randomMake() {
		String[] randomMake = {"Chevy", "Ford", "Toyota", "Nissan", "Hyundai"};
		int index =  rand.nextInt(randomMake.length);
		String make = (randomMake[index]);
		return make;
	}	
	
	// random model of Vehicle obj
	private String randomModel() {
		String[] randomModel = {"Compact", "Intermediate", "fullSized", "van", "SUV", "pickup"};
		int index =  rand.nextInt(randomModel.length);
		String model = (randomModel[index]);
		return model;
	}
	
	// random weight of Vehicle obj
	private double randomWeight(String randomModel) {
		if(randomModel.equalsIgnoreCase("compact")) {
			return weight = ThreadLocalRandom.current().nextDouble(1500,2000);
		}
		else if(randomModel.equalsIgnoreCase("itermediate")) {
			return weight = ThreadLocalRandom.current().nextDouble(2001,2500);
		}
		else {
			return weight = ThreadLocalRandom.current().nextDouble(2501,4000);
		}
	}
		// random weight of Vehicle obj
	private double randomEngineSize(String randomModel) {
		if(randomModel.equalsIgnoreCase("compact")) {
			return engineSize = ThreadLocalRandom.current().nextDouble(3,6);
		}
		else if(randomModel.equalsIgnoreCase("itermediate")) {
			return engineSize = ThreadLocalRandom.current().nextDouble(7,10);
		}
		else {
			return engineSize = ThreadLocalRandom.current().nextDouble(11,14);
		}
	}
	
	// numOfDoors of Vehicle obj
	private int randomNumOfDoors(String randomModel) {
		if(randomModel.equalsIgnoreCase("compact")) {
			return 2;
		}
		else {
			return 4;
		}
	}
	
	// randomly chooses if a vehicle is importer (true) or not (false)
	private boolean randomIsImport(Double engineSize) {
		if(engineSize > 8) {
			return true;
		}
		else {
			return false;
		}
	}
	

	
}

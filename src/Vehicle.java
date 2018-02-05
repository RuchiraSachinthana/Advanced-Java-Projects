/**
 * @author Keenal
 * COP 4027 Advanced Computer Programming
 * Project 1
 * File Name: Vehicle.java
 * 
 * This class uses refactoring to improve structure, works with Derby database
 * and the Java Reflection API, and automates database creation from class definitions
 * and instances.
 */
public class Vehicle {
	
	// instance fields
	private String make;
	private String model;
	private double weight;
	private double engineSize;
	private int numOfDoors;
	private boolean IsImport;

	// parameterized constructor
	public Vehicle(String model, double weight, double engineSize, int numOfDoors, boolean isImport) {
		this.model = model;
		this.weight = weight;
		this.engineSize = engineSize;
		this.numOfDoors = numOfDoors;
		this.IsImport = isImport;
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
	
	public boolean isIsImport() {
		return IsImport;
	}
	public void setIsImport(boolean isImport) {
		IsImport = isImport;
	}
	
	// shows most useful information about Vehicle
	public String toString() {
		return "Vehicle: " + make + 
				"Model: " + model +
				"Number of Doors: " + numOfDoors +
				"Engine Size: " + engineSize +
				"Import? " + IsImport;
	}
	
	
}

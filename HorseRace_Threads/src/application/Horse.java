package controller;

import java.util.Random;

public class Horse {
	private Random rand = new Random();
	private int horseID = 0; 
	private int loc = 0;
	
	
	
	public Horse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Horse(int horseID) {
		super();
		this.horseID = horseID;
	}
	
	public Random getRand() {
		return rand;
	}
	public void setRand(Random rand) {
		this.rand = rand;
	}
	public int getHorseID() {
		return horseID;
	}
	public void setHorseID(int horseID) {
		this.horseID = horseID;
	}
	public int getLoc() {
		return loc;
	}
	public void setLoc(int loc) {
		this.loc = loc;
	} 
	
	
	
	
	

}

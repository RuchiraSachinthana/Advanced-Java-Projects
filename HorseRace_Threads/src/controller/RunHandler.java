package controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import javafx.scene.image.ImageView;

public class RunHandler {
	Horse horse = new Horse();
	private ArrayList<Horse> horses = new ArrayList<Horse>();
	private Horse horseID;
	private int dist = 0;
	
	public void showHorses() {
		for(int i = 0; i < 5; i++) {
			horses.add(horseID);
		}
	}
	
	
	public void moveHorse() {
		dist+= (horse.getRand().nextInt(3));
		horse.setLoc(dist);
		
	}
	


		
}
	

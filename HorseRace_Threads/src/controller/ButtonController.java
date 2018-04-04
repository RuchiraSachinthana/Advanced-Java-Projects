package controller;

public class ButtonController {
	
	RunHandler running = new RunHandler();
	Timer timer = new Timer();
	ResetHandler resetting = new ResetHandler();
	
	public void raceButtonClicked() {
		
		running.showHorses();
		
		timer.start();
		/*
		for(int i = 0; i < 5; i++) {
			running.startRace(i);
		}
		*/
		 
		
	}
	
	public void resetButtonClicked() {
		
		resetting.testMethod2();
		
	}
	
	public void quitButtonClicked() {
		
		System.out.println("Quitting");
		System.exit(0);
		
	}

}

package controller;

public class ButtonController {
	
	RunHandler running = new RunHandler();
	ResetHandler resetting = new ResetHandler();
	
	public void raceButtonClicked() {
		
		
		running.testMethod();
		
	}
	
	public void resetButtonClicked() {
		
		resetting.testMethod2();
		
	}
	
	public void quitButtonClicked() {
		System.out.println("Quitting");
		System.exit(0);
	}

}

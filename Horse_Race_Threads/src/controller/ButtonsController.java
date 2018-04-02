package controller;

public class ButtonsController {
	
	private RunFunc runf;
	private ResetFunc resetf;
	
	public void runButtonClicked() {
		System.out.println("testing race button");
		runf = new RunFunc();
		runf.testMethod();
		runf.testMethod2();
		
	}
	
	
	public void resetButtonClicked() {
		System.out.println("testing reset button");
		
	}
	
	public void quitButtonClicked() {
		System.out.println("Quitting the program.");
		System.exit(0);
	}
	
	

}

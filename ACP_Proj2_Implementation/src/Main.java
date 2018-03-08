/**
 * @author Keenal Shah
 * COP 4027 Advanced Computer Programming
 * Project 2
 * File Name: Main.java
 * 
 * This is the tester class 
 */

public class Main {

	public static void main(String[] args) {

		//Read in the file
		ReadFile rf = new ReadFile();
		rf.readFile("addsAndSubtracts");
		rf.formatEquation();

		// calculate the answer
		Calculate cal = new Calculate();
		
		for (int i = 0; i < rf.getformattedString().size(); i++) {
			System.out.println(cal.calculate(rf.getformattedString().get(i)));
		}

		//Display the answer
		for (int i = 0; i < rf.getformattedString().size(); i++) {
		 rf.getformattedString().get(i).toString();
		}
		
	}

}

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * @author Keenal Shah
 * COP 4027 Advanced Computer Programming
 * Project 2
 * File Name: ReadFile.java
 * 
 * This class read the file "addsAndSubtracts" and splits the numbers along with their operators so calculations can be performed on them 
 */

public class ReadFile {
	private static ArrayList<String> records = new ArrayList<String>();
	private static ArrayList<Equation> formattedString = new ArrayList<Equation>();
	
	// get the formatted String after splitting the numbers with their operators and signs
	public static ArrayList<Equation> getformattedString() {
		return formattedString;
	}

	// read file
	public void readFile(String filename) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(filename));
			String line; 
			while((line = br.readLine()) != null) {
				records.add(line);
			}
			br.close();
		}
		catch (Exception e) {
			System.err.format("Exception occurred trying to read '%s'.", filename);
			e.printStackTrace();
		}
		
	}

	// get the numbers positioned in its proper place to calculate the results
	public void formatEquation() {
		for (int i = 0; i < records.size(); i++) {
			String[] tokens = splitString(records.get(i));
			
			String firstOpSign;
			String checkFSign = tokens[0].substring(0, 1);
			if (checkFSign.equals("+")) {
				firstOpSign = "+";
			}
			if (checkFSign.equals("-")) {
				firstOpSign = "-";
			}
			else {
				firstOpSign = "+";
			}
			
			String firstOp  = getOperand(tokens[0]);
			String operator = tokens[1];
			
			String secondOpSign;
			String checkSSign = tokens[0].substring(0, 1);
			if (checkSSign.equals("+")) {
				secondOpSign = "+";
			}
			if (checkSSign.equals("-")) {
				secondOpSign = "-";
			}
			else {
				secondOpSign = "+";
			}
			
			String secondOp  = getOperand(tokens[2]);

			// compare and see which operand is bigger
			boolean firstOpIsBigger;
			if (firstOp.length() > secondOp.length()) {
				firstOpIsBigger = true;
			}
			else if (firstOp.length() == secondOp.length()) {
					if (firstOp.compareTo(secondOp) > 0) {
						firstOpIsBigger = true;
					}
					else {
						firstOpIsBigger = false;
					}
			}
			else {
				firstOpIsBigger = false;
			}
			
			Equation equation = new Equation(firstOp , firstOpSign, secondOp , secondOpSign, operator, firstOpIsBigger);
			
			// pad zeros in front of the numbers
			String firstOp0 = equation.getfirstOp();
			String secondOp0 = equation.getsecondOp();
			
			if(equation.isfirstOpIsBigger() == true) {
				firstOp0 = ("0" + firstOp0);
				while (firstOp0.length() != secondOp0.length()) {
					secondOp0 = ("0" + secondOp0);
				}
			}  else {
				secondOp0 = ("0" + secondOp0);
				while (secondOp0.length() != firstOp0.length()) {
					firstOp0 = ("0" + firstOp0);
				}
			}
			equation.setfirstOp(firstOp0);
			equation.setsecondOp(secondOp0);
			
			formattedString.add(equation);
		}
	}
	
	// splits the string by a space, index #3 represents the space
	private String[] splitString(String stringToSplit) {
		int i = 0;
		String[] tokenArray = new String[3];
		StringTokenizer tokens = new StringTokenizer(stringToSplit);
		while (tokens.hasMoreTokens()) {
			tokenArray[i++] = tokens.nextToken();
		}
		return tokenArray;
	}

	// gets the operand
	private String getOperand(String strOperand) {
		String checkSign = strOperand.substring(0, 1);
		if (checkSign.equals("+")) {
			return strOperand.substring(1, strOperand.length());
		}
		if (checkSign.equals("-")) {
			return strOperand.substring(1, strOperand.length());
		}
		else {
			return strOperand;
		}
	}


	
	
}

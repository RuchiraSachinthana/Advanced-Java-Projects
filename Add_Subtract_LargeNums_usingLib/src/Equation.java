
/**
 * @author Keenal Shah
 * COP 4027 Advanced Computer Programming
 * Project 2
 * File Name: Equation.java
 * 
 * This class creates the equation.
 */

public class Equation {
	private String firstOp = ""; 
	private String firstOpSign = "";
	private String secondOp = "";
	private String secondOpSign = "";
	private String operator = "";
	private boolean firstOpIsBigger = false;
	private String solution = "";
	
	/**
	 * @param firstOp
	 * @param firstOpSign
	 * @param secondOp
	 * @param secondOpSign
	 * @param operator
	 * @param firstOpIsBigger
	 */
	public Equation(String firstOp, String firstOpSign, String secondOp, String secondOpSign,
			String operator, boolean firstOpIsBigger) {
		super();
		this.firstOp = firstOp;
		this.firstOpSign = firstOpSign;
		this.secondOp = secondOp;
		this.secondOpSign = secondOpSign;
		this.operator = operator;
		this.firstOpIsBigger = firstOpIsBigger;
	}

	/**
	 * @return the firstOp
	 */
	public String getfirstOp() {
		return firstOp;
	}

	/**
	 * @param firstOp the firstOp to set
	 */
	public void setfirstOp(String firstOp) {
		this.firstOp = firstOp;
	}

	/**
	 * @return the firstOpSign
	 */
	public String getfirstOpSign() {
		return firstOpSign;
	}

	/**
	 * @param firstOpSign the firstOpSign to set
	 */
	public void setfirstOpSign(String firstOpSign) {
		this.firstOpSign = firstOpSign;
	}

	/**
	 * @return the secondOp
	 */
	public String getsecondOp() {
		return secondOp;
	}

	/**
	 * @param secondOp the secondOp to set
	 */
	public void setsecondOp(String secondOp) {
		this.secondOp = secondOp;
	}

	/**
	 * @return the secondOpSign
	 */
	public String getsecondOpSign() {
		return secondOpSign;
	}

	/**
	 * @param secondOpSign the secondOpSign to set
	 */
	public void setsecondOpSign(String secondOpSign) {
		this.secondOpSign = secondOpSign;
	}

	/**
	 * @return the operator
	 */
	public String getOperator() {
		return operator;
	}

	/**
	 * @param operator the operator to set
	 */
	public void setOperator(String operator) {
		this.operator = operator;
	}

	/**
	 * @return the firstOpIsBigger
	 */
	public boolean isfirstOpIsBigger() {
		return firstOpIsBigger;
	}

	/**
	 * @param firstOpIsBigger the firstOpIsBigger to set
	 */
	public void setfirstOpIsBigger(boolean firstOpIsBigger) {
		this.firstOpIsBigger = firstOpIsBigger;
	}

	/**
	 * @return the solution
	 */
	public String getSolution() {
		return solution;
	}

	/**
	 * @param solution the solution to set
	 */
	public void setSolution(String solution) {
		this.solution = solution;
	}
	
	/**
	 * Formats and returns the String representation of the Equation to solve plus solution.
	 * @return Equation = the Equation to solve w/ solution in a formated String representation
	 */
	public String toString() {
		String thirdLine = "";
		for (int i = 0; i < getsecondOp().length() + getOperator().length() + 2; i++) {
			thirdLine += "-";
		}
		
		String Equation = "  " + getfirstOpSign() + getfirstOp() + "\n" 
				+ getOperator() + " " + getsecondOpSign() + getsecondOp() + "\n"
				+ thirdLine + "\n" + "   " + getSolution() + "\n"; 
		
		System.out.println(Equation);
		return Equation;
	}

	
}


/**
 * @author Keenal Shah
 * 
 * COP 4027 Advanced Computer Programming
 * Project 2
 * File Name: Calculate.java
 * 
 * This class adds or subtracts two numbers
 */

public class Calculate {
	private boolean addCarry = false;
	private boolean subBorrow = false;

	
	// sees if the operator is + or - and acts upon that 
	public String calculate(Equation calEq) {
		String sol = "";
		String firstOpSign = calEq.getfirstOpSign();
		String secondOpSign = calEq.getsecondOpSign();
		String operator = calEq.getOperator();
		if (operator.equals("+")) {
			if (firstOpSign.equals("+") && secondOpSign.equals("+")) {
				sol = addOperation(calEq);
			}
			else if (firstOpSign.equals("-") && secondOpSign.equals("-")) {
				sol = "-" + addOperation(calEq);
			} else {
				sol = subtractOperation(calEq);
			}
		}
		if (operator.equals("-")) {
			if (firstOpSign.equals("+") && secondOpSign.equals("+")) {
				sol = subtractOperation(calEq);
			}
			else if (firstOpSign.equals("-") && secondOpSign.equals("-")) {
				sol = subtractOperation(calEq);
			} else if (firstOpSign.equals("+") && secondOpSign.equals("-")) {
				sol = addOperation(calEq);
			} else {
				sol = "-" + addOperation(calEq);
			}
		}
		return sol;
		
	}
	
	// adds the numbers onto the stack 
	private String addOperation(Equation addEq) {
		String solution = "";
		StackUsingLinkedList firstOpStack = new StackUsingLinkedList();
		StackUsingLinkedList secondOpStack = new StackUsingLinkedList();
		StackUsingLinkedList resultStack = new StackUsingLinkedList();
		

		String firstOp = addEq.getfirstOp();
		for (int i = 0; i < firstOp.length(); i++) {
			firstOpStack.push(firstOp.charAt(i));
		}
		String secondOp = addEq.getsecondOp();
		for (int i = 0; i < secondOp.length(); i++) {
			secondOpStack.push(secondOp.charAt(i));
		}

		while (!firstOpStack.isEmpty()) {
			resultStack.push(add(firstOpStack.pop(), secondOpStack.pop()));
		}

		while (!resultStack.isEmpty()) {
			solution += resultStack.pop();
		}
		return solution;
	}
	
	// subtracts the number
	private String subtractOperation(Equation subEq) {
		String solution = "";
		Boolean firstOpIsBigger = subEq.isfirstOpIsBigger();
		String firstOpSign = subEq.getfirstOpSign();
		String secondOpSign = subEq.getsecondOpSign();
		String operator = subEq.getOperator();
		StackUsingLinkedList firstOpStack = new StackUsingLinkedList();
		StackUsingLinkedList secondOpStack = new StackUsingLinkedList();
		StackUsingLinkedList resultStack = new StackUsingLinkedList();

		String firstOp = subEq.getfirstOp();
		for (int i = 0; i < firstOp.length(); i++) {
			firstOpStack.push(firstOp.charAt(i));
		}
		String secondOp = subEq.getsecondOp();
		for (int i = 0; i < secondOp.length(); i++) {
			secondOpStack.push(secondOp.charAt(i));
		}

		if (firstOpIsBigger) {
			if ((firstOpSign.equals("+") && secondOpSign.equals("+") && operator.equals("-")) ||
					(firstOpSign.equals("+") && secondOpSign.equals("-") && operator.equals("+"))) {
				while (!firstOpStack.isEmpty()) {
					resultStack.push(subtract(firstOpStack.pop(), secondOpStack.pop()));
				}
				while (!resultStack.isEmpty()) {
					solution += resultStack.pop();
				}
				return solution;
			} else {
				while (!firstOpStack.isEmpty()) {
					resultStack.push(subtract(firstOpStack.pop(), secondOpStack.pop()));
				}
				while (!resultStack.isEmpty()) {
					solution += resultStack.pop();
				}
				return "-" + solution;
			}
		} else {
			if ((firstOpSign.equals("+") && secondOpSign.equals("+") && operator.equals("-")) ||
					(firstOpSign.equals("+") && secondOpSign.equals("-") && operator.equals("+"))) {
				while (!firstOpStack.isEmpty()) {
					resultStack.push(subtract(secondOpStack.pop(), firstOpStack.pop()));
				}
				while (!resultStack.isEmpty()) {
					solution += resultStack.pop();
				}
				return "-" + solution;
			} else {
				while (!firstOpStack.isEmpty()) {
					resultStack.push(subtract(secondOpStack.pop(), firstOpStack.pop()));
				}
				while (!resultStack.isEmpty()) {
					solution += resultStack.pop();
				}
				return solution;
			}
		}
	}
	
	 
	private Character add(Character chrToAdd, Character secCharToAdd) {

		int carry = 0;
		if (addCarry == true) {
			carry = 1;
		} 
		addCarry = false;
		int addResult = Integer.parseInt(chrToAdd.toString()) + Integer.parseInt(secCharToAdd.toString()) + carry;

		
		if (addResult > 9) {
			addCarry = true;
			int lastDigit = (addResult - 10);
			char[] conAddResult = Character.toChars('0' + lastDigit);
			return conAddResult[0];
		} else {
			char[] conAddResult = Character.toChars('0' + addResult);
			return conAddResult[0];
		}
		
	}
	

	private Character subtract(Character chrToSub, Character secCharToSub) {
		Integer intCharToSub = Integer.parseInt(chrToSub.toString());
		Integer intSecCharToSub = Integer.parseInt(secCharToSub.toString());
		
	
		if(this.subBorrow == true) {
			intCharToSub -= 1;
			this.subBorrow = false;
		} 

		if (intCharToSub.compareTo(intSecCharToSub) < 0) {
			intCharToSub += 10;
			this.subBorrow = true;
		}
	
		int subRes = intCharToSub - intSecCharToSub;
		char[] conSub = Character.toChars('0' + subRes);
		return conSub[0];
	}
	
	
}

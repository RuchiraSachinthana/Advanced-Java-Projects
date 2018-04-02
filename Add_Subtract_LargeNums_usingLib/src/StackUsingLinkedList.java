import java.util.LinkedList;
/**
 * @author Keenal Shah
 * 
 * COP 4027 Advanced Computer Programming
 * Project 2
 * File Name: StackUsingLinkedList.java
 * 
 * This class uses stack and pushes the character onto stack and pops the data to get back the result
 */

public class StackUsingLinkedList {
	LinkedList<Character> list = new LinkedList<Character>();

	public boolean isEmpty() {
		return list.isEmpty();
	}

	public void push(Character characterToPushOnStack) {
		list.push(characterToPushOnStack);
	}

	public Character pop() {
		return (Character) list.pop();
	}
	

}

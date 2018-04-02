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
	private Node top = null;
	
	public boolean isEmpty() {
		return top == null;
	}
	
	public void push(Character chr) {
		Node temp = new Node();
		temp.setData(chr);
		temp.setNextNode(top);
		top = temp;
	}
	
	public Character pop() {
		char data = top.getData();
		top = top.getNextNode();
		return data;
	}
	

}

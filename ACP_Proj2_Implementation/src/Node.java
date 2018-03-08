
/**
 * @author Keenal Shah
 * COP 4027 Advanced Computer Programming
 * Project 2
 * File Name: Node.java
 * 
 * This class creates the node for the linked list 
 */

public class Node {
	private Character data = ' ';
	private Node nextNode = null;

	public Node() {
	}
	

	public Node(Character data, Node nextNode) {
		this.data = data;
		this.nextNode = nextNode;
	}

	public Character getData() {
		return data;
	}

	void setData(Character data) {
		this.data = data;
	}


	public Node getNextNode() {
		return nextNode;
	}


	public void setNextNode(Node nextNode) {
		this.nextNode = nextNode;
	}
	
}

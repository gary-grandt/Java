package BKTM.venediktov.stackQueList;

public class Node {
	//Variables
	private Node next;
	private Object content;
	
	//Constructos
	public Node() {
		this.next = null;
		this.content = null;
	}
	
	public Node(Node next) {
		this.next = next;
		this.content = null;
	}
	
	public Node(Object content) {
		this.next = null;
		this.content = content;
	}
	
	public Node(Node next, Object content) {
		this.next = next;
		this.content = content;
	}
	
	//Getter
	public Node getNext() {
		return next;
	}
	
	public Object getContent() {
		return content;
	}
	
	//Setter
	public void setNext(Node input) {
		next = input;
	}
	
	public void setContent(Object input) {
		content = input;
	}
	
}

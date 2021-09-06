package BKTM.venediktov.stackQueList;

public class Stack {
	//Variables
	private Node kopf;
	
	//Constructors
	public Stack() {
		kopf = null;
	}
	
	//---------------
	//--- Methods ---
	//---------------
	public boolean isEmpty() {
		return (kopf == null);
	}
	
	//pObject --> top Stappel
	//pObject == null --> doNothing
	public void push(Object pObject) {
		if(pObject == null) return;
		Node newNode = new Node(kopf, pObject);
		kopf = newNode;
	}
	
	//TopObject --> remove & return
	//If(isEmpty) --> Nothing
	public void pop() {
		if(kopf == null) return;
		kopf = kopf.getNext();
	}
	
	//Get TopObejct
	//if(isEmpty) --> return null;
	public Object top() {
		if (kopf == null) return null;
		return kopf.getContent();
	}
}

package BKTM.venediktov.stackQueList;

public class Queue {
	//Variables
	private Node kopf;
	private Node fuss;
	
	//Constructors
	public Queue() {
		kopf = fuss = null;
	}
	
	//---------------
	//--- Methods ---
	//---------------
	public boolean isEmpty() {
		return (kopf == null);
	}
	
	//Top Object --> delete 
	//Null --> doNothing
	public void deQueue() { // = Stack --> pop
		if(kopf == null) return;
		kopf = kopf.getNext();
	}
	
	//Get TopObject
	//if(kopf == null) return null
	public Object front() {
		if(kopf == null) return null;
		return kopf.getContent();
	}
	
	//pObject --> an Schlange angehändt
	//if(pObject == null) --> doNothing
	public void enQueue(Object pObject) {
		if(pObject == null) return;
		
		Node newNode = new Node(null, pObject);
		
		if(fuss != null) {
			fuss.setNext(newNode);
			fuss = newNode;
		} else {
			kopf = fuss= newNode;
		}
	}
	
}
package BKTM.venediktov.stackQueList;

public class List {
	
	private Node head;
	private Node foot;
	private Node current;
	
	
	
	public boolean isEmpty() {
		return head == null;
	}
	
	public boolean hasAccess() {
		return current != null;
	}
	
	public void next() {
		if(!isEmpty() && hasAccess() && current != foot) {
			current = current.getNext();
		}else {
			current = null;
		}
	}
	
	public void toFirst() {
		if(isEmpty()) return;
		current = head;
	}
	
	public Object getObject() {
		if(!hasAccess()) return null;
		return current.getContent();
	}
	
	public void setObject(Object pObject) {
		if(!hasAccess() || pObject == null) return;
		current.setContent(pObject);
	}
	
	public void append(Object pObject) {
		if(pObject == null) {
			return;
		}else if(hasAccess()) {
			foot.setNext(new Node(null, pObject));
			foot = foot.getNext();
		}else {
			head = foot = new Node(null, pObject);
		}
	}
	
	public void connact(List pList) {
		if(pList == null || pList.isEmpty()) return;

		if(isEmpty()) {
			head = pList.head;
			foot = pList.foot;
		}else {
			foot.setNext(pList.head);
			foot = pList.foot;
		}
	}
	
	public void insert(Object pObject) {
		if(pObject == null || (!hasAccess() &&  !isEmpty())) return;
		
		if(isEmpty()) {
			append(pObject);
			return;
		}
		
		if(head == current) {
			head = new Node(head, pObject);
		}else {
			Node buffer = head;
			while(buffer.getNext() != null) {
				if(buffer.getNext() == current) {
					buffer.setNext(new Node(buffer.getNext(), pObject));
				}

				buffer = buffer.getNext();
			}
		}
	}
	
	public void remove() {
		if(!hasAccess() || !isEmpty()) return;
		if(head == current) {
			head = current = current.getNext();
			if(head == null) foot = null;
		}else {
			
			Node buffer = head;
			while(buffer.getNext() != null) {
				
				if(buffer.getNext() == current) {
					buffer.setNext(current.getNext());
					current = current.getNext();
					if(buffer.getNext() == foot) foot = buffer;
				}
				buffer = buffer.getNext();
			}
			
		}
	}
	
}

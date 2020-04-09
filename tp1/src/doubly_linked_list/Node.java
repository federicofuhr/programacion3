package doubly_linked_list;

public class Node {

	private Object info;
	private Node previous;
	private Node next;

	public Node() {
		this.previous = null;
		this.info = null;
		this.next = null;
	}
	
	public Node(Object o, Node p, Node n) {
		this.setInfo(o);
		this.setPrevious(p);
		this.setNext(n);
	}
	
	
	
	public Node getPrevious() {
		return previous;
	}

	public void setPrevious(Node previous) {
		this.previous = previous;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public Object getInfo() {
		return info;
	}

	public void setInfo(Object info) {
		this.info = info;
	}

}

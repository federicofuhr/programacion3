package tp1;

public class Pila {
	private MySimpleLinkedList list;
	
	public Pila() {
		super();
		this.list = new MySimpleLinkedList();
	}
	
	public Object pop() {
		Object o = null;
		if (!list.isEmpty()) {
			list.extractFront();
		}
		return o;
	}
	
	public void push(Object o) {
		list.insertFront(o);
	}
	
	public Object top() {
		return this.list.getFrontElement();
	}
	
	public int size() {
		return (this.list.size());
	}

	@Override
	public String toString() {
		return (list.toString());
	}
	
	public void reverse() {
		this.list.reverse();
	}
	
}

package tp1;

import java.util.Iterator;

public class MySimpleLinkedList implements Iterable<Object>{
	
	protected Node first;
	protected int size;
	
	
	public MySimpleLinkedList() {
		this.first = null;
		this.size = 0;
	}
	
	public void insertFront(Object o) {
		Node tmp = new Node(o,null);
		tmp.setNext(this.first);
		this.first = tmp;
		this.size++;
	}
	
	public Object extractFront() {
		// TODO
		if (!this.isEmpty()) {	
			Node tmp = this.first;
			this.first = this.first.getNext();
			tmp.setNext(null);
			this.size--;
			return tmp.getInfo();
		}
		return null;
	}
	
	public Object getFrontElement() {
		if (!this.isEmpty()) {
			return this.first.getInfo();
		}
		return null;
 	}

	public boolean isEmpty() {
		// TODO
		return (this.size() == 0);
	}

	public int size() {
		// TODO
		return this.size;
	}
	
	public Object get(int index) {
		// TODO
		if (this.size > index) {
			Node n = this.first;
			int i = 1;
			while (i != index) {
				n = n.getNext();
				i++;
			}
			return n.getInfo();
		}
		return null;
	}
	
	public int indexOf(Object o) {
		if (!this.isEmpty()) {
			Node n = this.first;
			int index = 0;
			while ((n != null) && (!n.getInfo().equals(o))) {
				index++;
				n = n.getNext();
			}
			if ((n != null) && (n.getInfo().equals(o)))
				return index;
		}
		return -1;
	}

	@Override
	public String toString() {
		if (!this.isEmpty()) {
			String s = "[";
			Node n = this.first;
			for (int i = 0; i < this.size(); i++) {
				if (i < (this.size() - 1))
					s += n.getInfo() + ", ";
				else
					s += n.getInfo();
				n = n.getNext();
			}
			s += "]";
			return s;
		}
		return "LISTA VACIA";
	}
	
	
	public void reverse() {
		MySimpleLinkedList l = new MySimpleLinkedList();
		
		Node n = this.first;
		
		while (n != null) {
			l.insertFront(n.getInfo());
			n = n.getNext();
		}
		
		this.first = l.first;
	}

	@Override
	public Iterator<Object> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

}

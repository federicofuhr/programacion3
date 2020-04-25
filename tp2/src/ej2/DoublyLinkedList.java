package ej2;

public class DoublyLinkedList{
	
	protected Node first;
	protected Node last;
	protected int size;
	
	
	public DoublyLinkedList() {
		// TODO Auto-generated constructor stub
		this.first = null;
		this.last = null;
		this.size = 0;
	}
	
	public void insertFront(Object o) {
		Node tmp = new Node(o,null,null);
		
		if (!this.isEmpty()) {
			tmp.setNext(this.first);
			this.first.setPrevious(tmp);
			this.first = tmp;
		} else {
			this.first = tmp;
			this.last = this.first;
		}
		
		this.size++;
	}
	
	public void insertLast(Object o) {
		Node tmp = new Node(o, null, null);
		
		if (!this.isEmpty()) {
			tmp.setPrevious(this.last);
			this.last.setNext(tmp);
			this.last = tmp;	
		} else {
			this.last = tmp;
		}
		
		this.size++;
		
		if (this.size() == 1) {
			this.first = last;
		}
	}
	
	public void insertOrdered(Object o) {
		if (!this.isEmpty()) {
			if ((Integer)this.first.getInfo() > (Integer)o) {
				insertFront(o);
			} else if ((Integer)this.last.getInfo() < (Integer)o) {
				insertLast(o);
			} else {
				Node nuevo = new Node(o, null ,null);
				
				Node n = this.first;
				Node n2 = null;
				
				while ((n != null) && ((Integer)n.getInfo() < (Integer)o)) {
					n2 = n;
					n = n.getNext();
				}
				
				n2.setNext(nuevo);
				nuevo.setPrevious(n2);
				nuevo.setNext(n);
				n.setPrevious(nuevo);
				
				this.size++;
			}
		} else {
			this.insertFront(o);
			this.last = first;
		}
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
			int i = 0;
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
			
			s += "[";
			n = this.last;
			for (int i = this.size(); i > 0; i--) {
				if (i > 1)
					s += n.getInfo() + ", ";
				else
					s += n.getInfo();
				n = n.getPrevious();
			}
			s += "]";
			
			return s;
		}
		return "LISTA VACIA";
	}
	
	
	public void reverse() {
		DoublyLinkedList l = new DoublyLinkedList();
		
		Node n = this.first;
		
		while (n != null) {
			l.insertFront(n.getInfo());
			n = n.getNext();
		}
		
		this.first = l.first;
	}
	
	public DoublyLinkedList getOrderList(DoublyLinkedList l) {
		
		DoublyLinkedList r = new DoublyLinkedList();
		
		int i = 0;
		
		while (i < this.size()) {
			int j = 0;
			while (j < l.size()) {
				if (this.get(i).equals(l.get(j))) {
					r.insertOrdered(this.get(i));
				}
				j++;
			}
			i++;
		}
		
		return r;
		
	}
	
	public boolean contains(Object o) {
		boolean r = false;
		
		Node n = this.first;
		
		while ((n != null) && (!r)) {
			if (n.getInfo().equals(o))
				r = true;
			n = n.getNext();
		}
		
		return r;
	}
	
	public DoublyLinkedList difference(DoublyLinkedList l) {
		DoublyLinkedList r = new DoublyLinkedList();
		
		int i = 0;
		
		while (i < this.size()) {
			
			if (!l.contains(this.get(i))) {
				r.insertOrdered(this.get(i));
			}
				
			i++;
		}
		
		return r;
	}
	
	public boolean isPalindrome() {
		boolean res = true;
		
		Node l = this.first;
		Node r = this.last;
		
		while ((l != r) && (res)) {
			if (!l.getInfo().equals(r.getInfo())) {
				res = false;
			}
			l = l.getNext();
			r = r.getPrevious();
		}
		
		return res;
	}

}

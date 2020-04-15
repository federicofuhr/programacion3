package tp_entregable;

public class MySimpleLinkedList{
	
	//ATRIBUTOS DE LA CLASE
	protected Node first;
	protected Node last;
	protected int size;
	
	
	public MySimpleLinkedList() {
		//INICIALIZACION DE LOS ATRIBUTOS
		this.first = null;
		this.last = null;
		this.size = 0;
	}
	
	public void insertFront(Object o) {
		//INSERTAR EN EL PRIMER LUGAR
		Node tmp = new Node(o,null);
		tmp.setNext(this.first);
		this.first = tmp;
		this.size++;
	}
	
	public void insertLast(Object o) {
		//INSERTAR EN EL ULTIMO LUGAR
		Node tmp = new Node(o, null);
		if (!this.isEmpty()) {
			this.last.setNext(tmp);
		} else {
			this.first = tmp;
		}
		this.last = tmp;
		this.size++;
	}
	
	public void insertOrdered(Object o) {
		//INSERTAR EL ELEMENTO DE MANERA ORDENADA
		if (!this.isEmpty()) {
			if ((Integer)this.first.getInfo() > (Integer)o) {
				insertFront(o);
			} else if ((Integer)this.last.getInfo() < (Integer)o) {
				insertLast(o);
			} else {
				Node nuevo = new Node(o, null);
				
				Node n = this.first;
				Node n2 = null;
				
				while ((n != null) && ((Integer)n.getInfo() < (Integer)o)) {
					n2 = n;
					n = n.getNext();
				}
				
				n2.setNext(nuevo);
				nuevo.setNext(n);
				
				this.size++;
			}
		} else {
			this.insertFront(o);
			this.last = first;
		}
	}
	
	public Object extractFront() {
		// OBTENER Y ELIMINAR EL PRIMER ELEMENTO
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
		//OBTENER EL PRIMER ELEMENTO
		if (!this.isEmpty()) {
			return this.first.getInfo();
		}
		return null;
 	}
	
	public Object getLastElement() {
		if (!this.isEmpty()) {
			return this.last.getInfo();
		}
		return null;
	}

	public boolean isEmpty() {
		// OBTENER UN BOOLEANO PARA SABER SI ESTA VACIA LA LISTA
		return (this.size() == 0);
	}

	public int size() {
		// RETORNA EL TAMAÑO DE LA LISTA
		return this.size;
	}
	
	public Object get(int index) {
		// OBTENER EL ELEMENTO EN UNA POSICION DETERMINADA
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
		// RETORNA UN NUMERO PARA SABER SI EL ELEMENTO SE ENCUENTRA EN LA ESTRUCTURA
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
		// METODO TOSTRING
		if (!this.isEmpty()) {
			String s = "[";
			Node n = this.first;
			for (int i = 0; i < this.size(); i++) {
				if (i < (this.size() - 1))
					s += n.toString() + ", ";
				else
					s += n.toString();
				n = n.getNext();
			}
			s += "]";
			return s;
		}
		return "LISTA VACIA";
	}
	
	
	public void reverse() {
		//INVERTIR EL ORDEN DE LA ESTRUCTURA
		MySimpleLinkedList l = new MySimpleLinkedList();
		
		Node n = this.first;
		
		while (n != null) {
			l.insertFront(n.getInfo());
			n = n.getNext();
		}
		
		this.first = l.first;
	}
	
	public MySimpleLinkedList getOrderList(MySimpleLinkedList l) {
		//OBTENER UNA NUEVA LISTA ORDENADA DE LOS ELEMENTOS REPETIDOS EN AMBAS LISTAS
		
		MySimpleLinkedList r = new MySimpleLinkedList();
		
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
	
	public MySimpleLinkedList difference(MySimpleLinkedList l) {
		//RETORNA UNA NUEVA LISTA CON LA DIFERENCIA ENTRE DOS LISTAS
		
		MySimpleLinkedList r = new MySimpleLinkedList();
		
		int i = 0;
		
		while (i < this.size()) {
			
			if (l.indexOf(this.get(i)) != -1)
				r.insertOrdered(this.get(i));
			i++;
		}
		
		return r;
	}
	
	
	public MySimpleLinkedList obtenerSecuencias() {
		
		MySimpleLinkedList res = new MySimpleLinkedList();
		
		if (!this.isEmpty()) {
			int i = 0;

			MySimpleLinkedList l1 = new MySimpleLinkedList();
			
			while (i < this.size()) {
				if (l1.isEmpty()) {
					l1.insertLast(this.get(i));
				} else if ((int)this.get(i) > (int)l1.getLastElement()) {
					l1.insertLast(this.get(i));
				} else {
					if (l1.size() >= 2) {
						res.insertLast(l1);
					}
					l1 = new MySimpleLinkedList();
					l1.insertLast(this.get(i));
				}
				i++;
			}
			
			if ((!l1.isEmpty()) && (l1.size() >= 2)) {
				res.insertLast(l1);
			}
		}
		return res;
	}
}

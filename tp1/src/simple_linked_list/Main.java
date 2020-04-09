package simple_linked_list;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MySimpleLinkedList list = new MySimpleLinkedList();
		
		list.insertFront(1); 
		list.insertFront(7); 
		list.insertFront(4); 		
		list.insertFront(10);
		list.insertFront(6);
		list.insertFront(11);
		list.insertFront(5);
		list.insertFront(27);
		list.insertFront(26);
		
		
		int index = 3;
		Object o1 = 5;
		Object o2 = 100;
		
		System.out.println("LISTA: " + list);
		System.out.println("LA CANTIDAD ES: " + list.size);
		System.out.println("ELEMENTO EN EL LUGAR " + index + " : " + list.get(index));
		System.out.println("ESTA EL ELEMENTO " + o1 + ": " + list.indexOf(o1));
		System.out.println("ESTA EL ELEMENTO " + o2 + ": " + list.indexOf(o2));
		
		
		MySimpleLinkedList list2 = new MySimpleLinkedList();
		
		list2.insertFront(57); 
		list2.insertFront(68); 
		list2.insertFront(4); 		
		list2.insertFront(1);
		list2.insertFront(6);
		list2.insertFront(25);
		list2.insertFront(45);
		list2.insertFront(27);
		list2.insertFront(26);
		
		System.out.println("LISTA 2: " + list2);
		System.out.println("NUEVA LISTA MISMOS ELEMENTOS ORDENADA: " + list.getOrderList(list2).toString());
		System.out.println("NUEVA LISTA CON LA DIFERENCIA: " + list.difference(list2).toString());
		System.out.println("-------------------------------------------------");
		
		/////////////////////////////////////////////////////////////////////////
		
		Pila p = new Pila();
		
		p.push(1);
		p.push(3);
		p.push(5);
		p.push(7);
		p.push(9);
		p.push(11);
		
		System.out.println("PILA: " + p.toString());
		System.out.println("TOPE: " + p.top());
		p.pop();
		System.out.println("BORRO TOPE");
		System.out.println("TOPE: " + p.top());
		p.pop();
		System.out.println("BORRO TOPE");
		System.out.println("TOPE: " + p.top());
		
		p.reverse();
		System.out.println("PILA CON REVERSA: " + p.toString());
		System.out.println("-------------------------------------------------");
		
		/////////////////////////////////////////////////////////////////////////
		
	}

}

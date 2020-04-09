package tp1;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MySimpleLinkedList list = new MySimpleLinkedList();
		
		list.insertFront(1); //4
		list.insertFront(3); //3
		list.insertFront(5); //2
		list.insertFront(7); //1
		list.insertFront(9); //0
		
		int index = 3;
		Object o1 = 5;
		Object o2 = 10;
		
		System.out.println("LISTA: " + list);
		System.out.println("LA CANTIDAD ES: " + list.size);
		System.out.println("ELEMENTO EN EL LUGAR " + index + " : " + list.get(index));
		System.out.println("ESTA EL ELEMENTO " + o1 + ": " + list.indexOf(o1));
		System.out.println("ESTA EL ELEMENTO " + o2 + ": " + list.indexOf(o2));
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
		System.out.println("PILA: " + p.toString());
		
		/////////////////////////////////////////////////////////////////////////
		
	}

}

package tp_entregable;

public class Main {

	public static void main(String[] args) {
		
		MySimpleLinkedList list1 = new MySimpleLinkedList();
		
		System.out.println("ENTRADA: " + list1);
		System.out.println("SALIDA: " + list1.obtenerSecuencias());
		
		System.out.println("------------------------------------------");
		
		MySimpleLinkedList list2 = new MySimpleLinkedList();
		
		list2.insertLast(1); 
		list2.insertLast(2); 
		list2.insertLast(3); 
		
		System.out.println("ENTRADA: " + list2);
		System.out.println("SALIDA: " + list2.obtenerSecuencias());
		
		System.out.println("------------------------------------------");
		
		MySimpleLinkedList list3 = new MySimpleLinkedList();
		
		list3.insertLast(1); 
		list3.insertLast(2); 
		list3.insertLast(2); 
		
		System.out.println("ENTRADA: " + list3);
		System.out.println("SALIDA: " + list3.obtenerSecuencias());
		
		System.out.println("------------------------------------------");
		
		MySimpleLinkedList list4 = new MySimpleLinkedList();
		
		list4.insertLast(3); 
		list4.insertLast(5); 
		list4.insertLast(2); 		
		list4.insertLast(7);
		list4.insertLast(19);
		list4.insertLast(14);
		list4.insertLast(28);
		
		System.out.println("ENTRADA: " + list4);
		System.out.println("SALIDA: " + list4.obtenerSecuencias());

		System.out.println("------------------------------------------");
		
		MySimpleLinkedList list5 = new MySimpleLinkedList();
		
		list5.insertLast(3); 
		list5.insertLast(5); 
		list5.insertLast(2); 		
		list5.insertLast(2);
		list5.insertLast(7);
		list5.insertLast(19);
		list5.insertLast(14);
		list5.insertLast(28);
		
		System.out.println("ENTRADA: " + list5);
		System.out.println("SALIDA: " + list5.obtenerSecuencias());
	}

}

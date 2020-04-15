package tp_entregable;

public class Main {

	public static void main(String[] args) {
		
		MySimpleLinkedList list1 = new MySimpleLinkedList();
		
		MySimpleLinkedList list2 = new MySimpleLinkedList();
		list2.obtenerSecuencias(list1);
		
		System.out.println("ENTRADA: " + list1);
		System.out.println("SALIDA: " + list2);
		
		System.out.println("------------------------------------------");
		
		MySimpleLinkedList list3 = new MySimpleLinkedList();
		
		list3.insertLast(1); 
		list3.insertLast(2); 
		list3.insertLast(3); 
		
		MySimpleLinkedList list4 = new MySimpleLinkedList();
		list4.obtenerSecuencias(list3);
		
		System.out.println("ENTRADA: " + list3);
		System.out.println("SALIDA: " + list4);
		
		System.out.println("------------------------------------------");
		
		MySimpleLinkedList list5 = new MySimpleLinkedList();
		
		list5.insertLast(1); 
		list5.insertLast(2); 
		list5.insertLast(2); 
		
		MySimpleLinkedList list6 = new MySimpleLinkedList();
		list6.obtenerSecuencias(list5);
		
		System.out.println("ENTRADA: " + list5);
		System.out.println("SALIDA: " + list6);
		
		System.out.println("------------------------------------------");
		
		MySimpleLinkedList list7 = new MySimpleLinkedList();
		
		list7.insertLast(3); 
		list7.insertLast(5); 
		list7.insertLast(2); 		
		list7.insertLast(7);
		list7.insertLast(19);
		list7.insertLast(14);
		list7.insertLast(28);
		
			
		MySimpleLinkedList list8 = new MySimpleLinkedList();
		list8.obtenerSecuencias(list7);
		
		System.out.println("ENTRADA: " + list7);
		System.out.println("SALIDA: " + list8);

		System.out.println("------------------------------------------");
		
		MySimpleLinkedList list9 = new MySimpleLinkedList();
		
		list9.insertLast(3); 
		list9.insertLast(5); 
		list9.insertLast(2); 		
		list9.insertLast(2);
		list9.insertLast(7);
		list9.insertLast(19);
		list9.insertLast(14);
		list9.insertLast(28);
		
			
		MySimpleLinkedList list10 = new MySimpleLinkedList();
		list10.obtenerSecuencias(list9);
		
		System.out.println("ENTRADA: " + list9);
		System.out.println("SALIDA: " + list10);
	}

}

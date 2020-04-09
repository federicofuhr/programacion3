package doubly_linked_list;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DoublyLinkedList l1 = new DoublyLinkedList();
		
		l1.insertFront(5);
		l1.insertFront(4);
		l1.insertFront(3);
		l1.insertFront(2);
		l1.insertFront(1);
		
		l1.insertLast(5);
		l1.insertLast(4);
		l1.insertLast(33);
		l1.insertLast(2);
		l1.insertLast(1);
		
		System.out.println(l1.toString());
		System.out.println("ES CAPICUA?: " + l1.isPalindrome());
		
	}

}

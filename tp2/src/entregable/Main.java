package entregable;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tree t = new Tree();
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		
//		int max_elements = 15;
//		int interval = 40;
//		while (list.size() != max_elements) {
//			Integer i = (int)(Math.random() * interval + 1);
//			if (!list.contains(i)) {
//				list.add(i);
//			}
//		}
		
		list.add(10);
		list.add(4);
		list.add(25);
		list.add(1);
		list.add(6);
		list.add(15);
		list.add(50);
		list.add(5);
		list.add(7);
		list.add(12);
		list.add(20);
		list.add(30);
		list.add(55);
		list.add(26);
		list.add(100);
		
		System.out.println("Lista de elementos:" + list);
		
		for (Integer integer : list) {
			t.insert(integer);
		}
		
		t.printPreOrder();
		t.printInOrder();
		t.printPosOrder();
		
		
		System.out.println("Altura: " + t.getHeight());
		System.out.println("Frontera: " + t.getFrontier());
		
		
		Integer elem = 99;
		System.out.println("Se encuentra el elemento " + elem + "?: " + t.hasElem(elem));
		
		elem = (int)(Math.random() * list.size());
		System.out.println("Se encuentra el elemento " + list.get(elem) + "?: " + t.hasElem(list.get(elem)));
		
		int level = 5;
		System.out.println("Elementos del nivel " + level + ": " + t.getElemAtLevel(level));
		
		System.out.println("El elemento mas grande es: " + t.getMaxElem());
		
		System.out.println("Rama más grande: " + t.getLongestBranch());
		
		int borrar = 100;
		System.out.println("BORRAR ELEMENTO " + borrar + ": " + t.delete(borrar));
		
		t.printPreOrder();
		System.out.println("Altura: " + t.getHeight());
		System.out.println("Rama más grande: " + t.getLongestBranch());
		
		
	}

}

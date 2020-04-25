package ej6;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tree t = new Tree();
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		int max_elements = 15;
		int interval = 40;
		while (list.size() != max_elements) {
			Integer i = (int)(Math.random() * interval + 1);
			if (!list.contains(i)) {
				list.add(i);
			}
		}
		
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
		
		int level = 3;
		System.out.println("Elementos del nivel " + level + ": " + t.getElemAtLevel(level));
		
	}

}

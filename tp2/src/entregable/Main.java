package entregable;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// CREADO EL ARBOL
		Tree t = new Tree();
		
		// CREO UNA LISTA PARA GUARDAR VALORES ALEATORIOS
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		int max_elements = 15;
		int interval = 40;
		while (list.size() != max_elements) {
			Integer i = (int)(Math.random() * interval + 1);
			if (!list.contains(i)) {
				list.add(i);
			}
		}
		
		for (Integer integer : list) {
			t.insert(integer);
		}

		System.out.println("Lista de elementos: " + list);
		
		System.out.println();
		t.printPreOrder();
		t.printInOrder();
		t.printPosOrder();
		
		System.out.println();
		System.out.println("Altura: " + t.getHeight());
		System.out.println("Frontera: " + t.getFrontier());
		
		
		System.out.println();
		Integer elem = 99;
		System.out.println("Se encuentra el elemento " + elem + "?: " + t.hasElem(elem));
		
		elem = (int)(Math.random() * list.size());
		System.out.println("Se encuentra el elemento " + list.get(elem) + "?: " + t.hasElem(list.get(elem)));
		
		
		System.out.println();
		int level = 5;
		System.out.println("Elementos del nivel " + level + ": " + t.getElemAtLevel(level));

		
		System.out.println();
		System.out.println("El elemento mas grande es: " + t.getMaxElem());
		
		System.out.println();
		System.out.println("Rama más grande: " + t.getLongestBranch());
		
		System.out.println("Se pudo borrar el elemento " + list.get(elem) + "?: " + t.delete(list.get(elem)));
		
		System.out.println();
		t.printPreOrder();
		System.out.println("Altura: " + t.getHeight());
		System.out.println("Rama más grande: " + t.getLongestBranch());
		
		
	}

}

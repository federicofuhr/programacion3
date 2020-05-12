package entregable;

import java.util.ArrayList;

public class Main {
	
	public static void randomTree(Tree t) {
		// ESTA FUNCION CARGA UN ARBOL CON 15 ELEMENTOS ALEATORIOS
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
	}

	public static void main(String[] args) {
		// CREADO EL ARBOL
		Tree t = new Tree();
		
		t.insert(10);
		t.insert(4);
		t.insert(25);
		t.insert(1);
		t.insert(6);
		t.insert(15);
		t.insert(50);
		t.insert(5);
		t.insert(7);
		t.insert(12);
		t.insert(20);
		t.insert(30);
		t.insert(55);
		t.insert(26);
		t.insert(100);
		
		System.out.println("CASO DE PRUEBA:");
		System.out.println();
		
		System.out.println("ELEMENTOS EN PRE ORDER: " + t.printPreOrder());
		System.out.println("ELEMENTOS EN IN ORDER: " + t.printInOrder());
		System.out.println("ELEMENTOS EN POS ORDER: " + t.printPosOrder());
		
		
		System.out.println();
		System.out.println("Altura: " + t.getHeight());
		System.out.println("Frontera: " + t.getFrontier());
		
		
		System.out.println();
		Integer elem = 99;
		System.out.println("Se encuentra el elemento " + elem + "?: " + t.hasElem(elem));
		
		elem = 50;
		System.out.println("Se encuentra el elemento " + elem + "?: " + t.hasElem(elem));
		
		
		System.out.println();
		int level = 5;
		System.out.println("Elementos del nivel " + level + ": " + t.getElemAtLevel(level));

		
		System.out.println();
		System.out.println("El elemento mas grande es: " + t.getMaxElem());
		
		System.out.println();
		System.out.println("Rama más grande: " + t.getLongestBranch());
		
		int borrar = 10;
		System.out.println("Se pudo borrar el elemento " + borrar + "? Que es el caso de 2 hijos: " + t.delete(borrar));
		
		System.out.println();
		t.printPreOrder();
		System.out.println("Altura: " + t.getHeight());
		System.out.println("Rama más grande: " + t.getLongestBranch());
		
		borrar = 26;
		System.out.println();
		System.out.println("Se pudo borrar el elemento " + borrar + "? Que es el caso de ser hoja: " + t.delete(borrar));
		
		System.out.println();
		t.printPreOrder();
		System.out.println("Altura: " + t.getHeight());
		System.out.println("Rama más grande: " + t.getLongestBranch());
		
		borrar = 6;
		System.out.println();
		System.out.println("Se pudo borrar el elemento " + borrar + ": " + t.delete(borrar));
		System.out.println("Se pudo borrar el elemento " + 5 + ": " + t.delete(5));
		System.out.println("Se pudo borrar el elemento " + 12 + ": " + t.delete(12));
		System.out.println("Se pudo borrar el elemento " + 20 + ": " + t.delete(20));
		System.out.println("Se pudo borrar el elemento " + 100 + ": " + t.delete(100));
		System.out.println("Se pudo borrar el elemento " + 30 + ": " + t.delete(30));
		System.out.println("Se pudo borrar el elemento " + 55 + ": " + t.delete(55));

		
		System.out.println();
		System.out.println("ELEMENTOS EN PRE ORDER: " + t.printPreOrder());
		System.out.println("Altura: " + t.getHeight());
		System.out.println("Rama más grande: " + t.getLongestBranch());
		System.out.println("Elemento más grande: " + t.getMaxElem());
		
		System.out.println("-------------------------------------------------------------");
		
		System.out.println("GENERAR ARBOL ALEATORIO: ");
		Tree t1 = new Tree();		
		randomTree(t1);
		
		System.out.println("ELEMENTOS EN PRE ORDER: " + t1.printPreOrder());
		System.out.println("Altura: " + t1.getHeight());
	}

}

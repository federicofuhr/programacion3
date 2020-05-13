package entregable;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		ArrayList<Tarea> a = new ArrayList<>();
		GrafoDirigido<Integer> g = new GrafoDirigido<>();
		
		// Cargo las tareas en una estructura
		a.add(new Tarea("Tarea 0", "Descripcion tarea 0", 0));
		a.add(new Tarea("Tarea 1", "Descripcion tarea 1", 1));
		a.add(new Tarea("Tarea 2", "Descripcion tarea 2", 2));
		a.add(new Tarea("Tarea 3", "Descripcion tarea 3", 3));
		a.add(new Tarea("Tarea 4", "Descripcion tarea 4", 4));
		a.add(new Tarea("Tarea 5", "Descripcion tarea 5", 5));
		a.add(new Tarea("Tarea 6", "Descripcion tarea 6", 6));
		a.add(new Tarea("Tarea 7", "Descripcion tarea 7", 7));
		a.add(new Tarea("Tarea 8", "Descripcion tarea 8", 8));
		a.add(new Tarea("Tarea 9", "Descripcion tarea 9", 9));
		a.add(new Tarea("Tarea 10", "Descripcion tarea 10", 10));
		a.add(new Tarea("Tarea 11", "Descripcion tarea 11", 11));
		a.add(new Tarea("Tarea 12", "Descripcion tarea 11", 12));
		
		// Cargo los vertices
		g.agregarVertice(0);
		g.agregarVertice(1);
		g.agregarVertice(2);
		g.agregarVertice(3);
		g.agregarVertice(4);
		g.agregarVertice(5);
		g.agregarVertice(6);
		g.agregarVertice(7);
		g.agregarVertice(8);
		g.agregarVertice(9);
		g.agregarVertice(10);
		g.agregarVertice(11);
		g.agregarVertice(12);
		
		// Cargo los arcos con los costos
		g.agregarArco(0, 1, 0);
		g.agregarArco(0, 2, 0);
		g.agregarArco(1, 3, 3);
		g.agregarArco(2, 5, 1);
		g.agregarArco(2, 7, 18);
		g.agregarArco(3, 4, 5);
		g.agregarArco(3, 6, 8);
		g.agregarArco(3, 4, 5);
		g.agregarArco(4, 11, 3);
		g.agregarArco(5, 6, 2);
		g.agregarArco(6, 12, 2);
		g.agregarArco(6, 10, 6);
		g.agregarArco(7, 8, 7);
		g.agregarArco(8, 9, 4);
		g.agregarArco(9, 10, 1);
		g.agregarArco(11, 12, 9);
		
		System.out.println(g);
		
	}

}

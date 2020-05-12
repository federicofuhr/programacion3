package entregable;

public class Main {

	public static void main(String[] args) {
		GrafoDirigido<Integer> g = new GrafoDirigido<>();
		
		g.agregarVertice(0, new Tarea("Tarea 0", "Tarea inicial", 0));
		g.agregarVertice(1, new Tarea("Tarea 1", "Descripcion tarea 1..", 4));
		g.agregarVertice(2, new Tarea("Tarea 2", "Descripcion tarea 2..", 18));
		g.agregarVertice(3, new Tarea("Tarea 3", "Descripcion tarea 3..", 4));
		g.agregarVertice(4, new Tarea("Tarea 4", "Descripcion tarea 4..", 13));
		g.agregarVertice(5, new Tarea("Tarea 5", "Descripcion tarea 5..", 22));
		g.agregarVertice(6, new Tarea("Tarea 6", "Descripcion tarea 6..", 18));
		g.agregarVertice(7, new Tarea("Tarea 7", "Descripcion tarea 7..", 12));
		g.agregarVertice(8, new Tarea("Tarea 8", "Descripcion tarea 8..", 3));
		g.agregarVertice(9, new Tarea("Tarea 9", "Descripcion tarea 9..", 2));
		g.agregarVertice(10, new Tarea("Tarea 10", "Descripcion tarea 10..", 3));
		g.agregarVertice(11, new Tarea("Tarea 11", "Descripcion tarea 11..", 1));
		g.agregarVertice(12, new Tarea("Tarea 12", "Descripcion tarea 12..", 5));
		
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

package entregable;

import java.util.ArrayList;
import java.util.Iterator;

import grafo.Arco;
import grafo.GrafoDirigido;

public class Main {

	public static void DFS_Visit(int vertice, char[] color, GrafoDirigido<Integer> grafo, ArrayList<Tarea> tareas,
		ArrayList<Integer> ramaActual, ArrayList<Integer> ramaMaxima, int pesoActual) {
		/*
		 * Este DFS_Visit modificado va cargando una lista con la secuencia de ejecucion critica que va encontrando.
		 * Su complejidad es O(V * A) siendo V la cantidad de vertices y A la cantidad de arcos
		 */
		int pesoMaximo = 0;
		if (ramaMaxima.size() > 0) {
			pesoMaximo = ramaMaxima.get(ramaMaxima.size() - 1);
		}
		ramaActual.add(vertice);
		pesoActual += tareas.get(vertice).getDuracion();
		color[vertice] = 'A';
		Iterator<Integer> itA = grafo.obtenerAdyacentes(vertice);
		if (itA.hasNext()) {
			while (itA.hasNext()) {
				int adyacente = itA.next();
				if (color[adyacente] == 'B') {
					Arco<Integer> arco = grafo.obtenerArco(vertice, adyacente);
					DFS_Visit(adyacente, color, grafo, tareas, ramaActual, ramaMaxima, pesoActual + arco.getEtiqueta());
				}
			}
		} else if (pesoActual > pesoMaximo) {
			ramaMaxima.clear();
			ramaMaxima.addAll(ramaActual);
			ramaMaxima.add(pesoActual);
		}
		ramaActual.remove((Object) vertice);
		color[vertice] = 'B';
	}

	public static ArrayList<Integer> DFS(GrafoDirigido<Integer> grafo, ArrayList<Tarea> tareas) {
		/* Este algoritmo es un DFS modificado que tiene como objetivo retornar la secucuencia de ejecucion
		* critica  recorriendo todos los vertices del grafo y a su vez sus aristas con el DFS_Visit
		* Su complejidad es O(V * A) siendo V la cantidad de vertices y A la cantidad de arcos
		*/
		ArrayList<Integer> ramaMaxima = new ArrayList<Integer>();
		Iterator<Integer> itV = grafo.obtenerVertices();
		char[] color = new char[grafo.cantidadVertices()];
		for (int i = 0; i < color.length; i++) {
			color[i] = 'B';
		}
		while (itV.hasNext()) {
			int vertice = itV.next();
			if (color[vertice] == 'B') {
				int pesoActual = 0;
				ArrayList<Integer> ramaActual = new ArrayList<Integer>();
				DFS_Visit(vertice, color, grafo, tareas, ramaActual, ramaMaxima, pesoActual);
			}
		}
		if (ramaMaxima.size() > 0)
			ramaMaxima.remove(ramaMaxima.size() - 1);
		return ramaMaxima;
	}

	public static void main(String[] args) {
		System.out.println("Grafo para probar funcionalidades minimas:");
		System.out.println();
		
		// Creo un grafo dirigdo donde las etiquetas de los arcos son valores Integer
		GrafoDirigido<Integer> grafito = new GrafoDirigido<>();

		// Agrego los vertices
		grafito.agregarVertice(1);
		grafito.agregarVertice(2);
		grafito.agregarVertice(3);
		grafito.agregarVertice(4);

		// Genero los arcos
		grafito.agregarArco(1, 2, 20);
		grafito.agregarArco(1, 3, 40);
		grafito.agregarArco(2, 3, 25);
		grafito.agregarArco(2, 4, 30);
		grafito.agregarArco(3, 4, 15);

		System.out.println(grafito);

		// Obtengo un iterador a los vertices del grafo
		System.out.println("Todos los vertices del grafo:");
		Iterator<Integer> it = grafito.obtenerVertices();
		while (it.hasNext()) {
			System.out.println(it.next());
		}

		// Obtengo un iterador a una lista de los arcos del vertice pasado por parametro
		System.out.println("");
		int num = 3;
		Iterator<Arco<Integer>> it2 = grafito.obtenerArcos(num);
		System.out.println("Lista de arcos del vertice " + num);
		while (it2.hasNext()) {
			System.out.println(it2.next());
		}

		// Obtengo un iterador a una lista de adyacentes del vertice solicitado
		System.out.println("");
		num = 2;
		Iterator<Integer> it3 = grafito.obtenerAdyacentes(num);
		System.out.println("Lista de vertices adyacentes a " + num + ":");
		while (it3.hasNext()) {
			System.out.println(it3.next());
		}

		// Obtengo un iterador a una lista con todos los arcos del grafo
		System.out.println("");
		Iterator<Arco<Integer>> it4 = grafito.obtenerArcos();
		System.out.println("Todos los arcos del grafo:");
		while (it4.hasNext()) {
			System.out.println(it4.next());
		}
		
		// Borro el vertice 4
		System.out.println();
		System.out.println("Grafo sin vertice 4:");
		grafito.borrarVertice(4);
		System.out.println(grafito);
		
		
		System.out.println("---------------------------------------");
		System.out.println();

		/////////////////////////////////////////////////////////

		System.out.println("Resolucion del entregable:");
		System.out.println();
		
		ArrayList<Tarea> tareas = new ArrayList<>();
		GrafoDirigido<Integer> grafo = new GrafoDirigido<>();

		// Cargo las tareas en una estructura
		tareas.add(new Tarea("Tarea 0", "Descripcion tarea 0", 0));
		tareas.add(new Tarea("Tarea 1", "Descripcion tarea 1", 4));
		tareas.add(new Tarea("Tarea 2", "Descripcion tarea 2", 18));
		tareas.add(new Tarea("Tarea 3", "Descripcion tarea 3", 4));
		tareas.add(new Tarea("Tarea 4", "Descripcion tarea 4", 13));
		tareas.add(new Tarea("Tarea 5", "Descripcion tarea 5", 22));
		tareas.add(new Tarea("Tarea 6", "Descripcion tarea 6", 18));
		tareas.add(new Tarea("Tarea 7", "Descripcion tarea 7", 12));
		tareas.add(new Tarea("Tarea 8", "Descripcion tarea 8", 3));
		tareas.add(new Tarea("Tarea 9", "Descripcion tarea 9", 2));
		tareas.add(new Tarea("Tarea 10", "Descripcion tarea 10", 3));
		tareas.add(new Tarea("Tarea 11", "Descripcion tarea 11", 1));
		tareas.add(new Tarea("Tarea 12", "Descripcion tarea 12", 5));

		// Cargo los vertices
		grafo.agregarVertice(0);
		grafo.agregarVertice(1);
		grafo.agregarVertice(2);
		grafo.agregarVertice(3);
		grafo.agregarVertice(4);
		grafo.agregarVertice(5);
		grafo.agregarVertice(6);
		grafo.agregarVertice(7);
		grafo.agregarVertice(8);
		grafo.agregarVertice(9);
		grafo.agregarVertice(10);
		grafo.agregarVertice(11);
		grafo.agregarVertice(12);

		// Cargo los arcos con los costos
		grafo.agregarArco(0, 1, 0);
		grafo.agregarArco(0, 2, 0);
		grafo.agregarArco(1, 3, 3);
		grafo.agregarArco(2, 5, 1);
		grafo.agregarArco(2, 7, 18);
		grafo.agregarArco(3, 4, 5);
		grafo.agregarArco(3, 6, 8);
		grafo.agregarArco(4, 11, 3);
		grafo.agregarArco(5, 6, 2);
		grafo.agregarArco(6, 12, 2);
		grafo.agregarArco(6, 10, 6);
		grafo.agregarArco(7, 8, 7);
		grafo.agregarArco(8, 9, 4);
		grafo.agregarArco(9, 10, 1);
		grafo.agregarArco(11, 12, 9);

		// Muestra el grafo por pantalla
		System.out.println(grafo);

		// Muestra por pantalla la secuencia de ejecucion critica del grafo
		System.out.println("Secuencia de ejecucion critica: " + DFS(grafo, tareas));

	}

}

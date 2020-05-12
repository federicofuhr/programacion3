package grafo;

import java.util.Iterator;

public class Main {

	public static void main(String[] args) {

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
		
		// Borro el arco de 2 -> 4
		//grafito.borrarArco(2, 4);
		
		// Borro el vertice 3
		//grafito.borrarVertice(3);
		
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
		System.out.println("Lista de vertices adyacentes a " + num +":");
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
	}

}

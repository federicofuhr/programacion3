package entregable;

import java.util.ArrayList;
import java.util.Iterator;

public class IteradorVertice<T> implements Iterator<Integer>{
	
	private Iterator<Vertice<T>> it;

	public IteradorVertice(ArrayList<Vertice<T>> vertices) {
		/*
		 * El iterador propio de la clase se vuelve el iterador de la lista de vertices
		 * pasada por parametro.
		 * Su complejidad es O(1)
		 */
		this.it = vertices.iterator();
	}

	@Override
	public boolean hasNext() {
		/*
		 * Retorna V o F si existe un siguiente
		 * Su complejidad es O(1)
		 */
		return it.hasNext();
	}

	@Override
	public Integer next() {
		/*
		 *  Retorna el id del elemento actual donde se encuentra el iterador.
		 *  Su complejidad es O(1)
		 */
		return it.next().getId();
	}
	
}

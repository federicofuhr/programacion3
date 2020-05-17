package entregable;

import java.util.ArrayList;
import java.util.Iterator;

public class IteradorArcos<T> implements Iterator<Arco<T>> {
	
	/*
	 * Clase de mi iterador para los arcos
	 */
	
	private Iterator<Arco<T>> it;
	
	public IteradorArcos(ArrayList<Arco<T>> arcos) {
		/*
		 * Se le asigna el iterador de la lista de arcos pasada por parametro
		 * al iterador propio de esta clase. Por lo que su complejidad es O(1)
		 */
		this.it = arcos.iterator();
	}

	@Override
	public boolean hasNext() {
		/*
		 * Retorna un V o F segun si el iterador tiene un siguiente o no
		 */
		return it.hasNext();
	}

	@Override
	public Arco<T> next() {
		/*
		 * Retorna el arco actual del iterador
		 */
		return it.next();
	}

}

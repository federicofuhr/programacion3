package grafo;

import java.util.ArrayList;
import java.util.Iterator;

public class IteradorVertice<T> implements Iterator<Integer>{
	
	private Iterator<Vertice<T>> it;

	public IteradorVertice(ArrayList<Vertice<T>> vertices) {
		this.it = vertices.iterator();
	}

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return it.hasNext();
	}

	@Override
	public Integer next() {
		// TODO Auto-generated method stub
		return it.next().getId();
	}
	
}

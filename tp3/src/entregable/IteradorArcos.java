package entregable;

import java.util.ArrayList;
import java.util.Iterator;

public class IteradorArcos<T> implements Iterator<Arco<T>> {
	
	private Iterator<Arco<T>> it;
	
	public IteradorArcos(ArrayList<Arco<T>> arcos) {
		// TODO Auto-generated constructor stub
		this.it = arcos.iterator();
	}

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return it.hasNext();
	}

	@Override
	public Arco<T> next() {
		// TODO Auto-generated method stub
		return it.next();
	}

}

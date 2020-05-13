package entregable;

import java.util.ArrayList;
import java.util.Iterator;

public class Vertice<T> {
	private int id;
	private ArrayList<Arco<T>> arcos;
	
	public Vertice(int verticeId) {
		id = verticeId;
		arcos = new ArrayList<Arco<T>>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public void addArco(Arco<T> arco) {
		if (!this.existeArco(arco)) {
			arcos.add(arco);
		}
	}

	public ArrayList<Arco<T>> getArcos() {
		return arcos;
	}
	
	public Arco<T> getArco(int verticeId) {
		return (this.obtenerArco(verticeId));
	}
	
	public boolean existeArco(Arco<T> arco) {
		Iterator<Arco<T>> it = arcos.iterator();
		while (it.hasNext()) {
			if (it.next().getVerticeDestino() == arco.getVerticeDestino())
				return true;
		}
		return false;
	}
	
	public void borrarArco(int verticeId) {
		this.arcos.remove(this.obtenerArco(verticeId));
	}
	
	private Arco<T> obtenerArco(int verticeId) {
		Iterator<Arco<T>> it = this.arcos.iterator();
		boolean exit = false;
		while (!exit && (it.hasNext())) {
			Arco<T> a = it.next();
			if (a.getVerticeDestino() == verticeId) {
				exit = true;
				return a;
			}
		}
		return null;
	}

	@Override
	public String toString() {
		String s = "Vertice: " + id + "\n";
		if (!arcos.isEmpty())
			for (Arco<T> arco : arcos) {
				s += "      " + arco + "\n";
			}
		return s;
	}

}

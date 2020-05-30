package e6;

import java.util.ArrayList;
import java.util.Iterator;

public class Vertice<T> {
	/*
	 *  Atributos de la clase vertice
	 */
	private int id;
	private ArrayList<Arco<T>> arcos;
	
	public Vertice(int verticeId) {
		/*
		 *  Constructor de la clase vertice
		 */
		id = verticeId;
		arcos = new ArrayList<Arco<T>>();
	}

	public int getId() {
		/*
		 *  Retorna el atributo id por lo que tiene complejidad O(1)
		 */
		
		return id;
	}

	public void setId(int id) {
		/*
		 *  Ingresa un valor a la etiqueta id por lo que tiene complejidad O(1)
		 */
		this.id = id;
	}
	
	public void addArco(Arco<T> arco) {
		/*
		 * Este metodo agrega un arco a la lista de arcos si este no existe
		 * por lo que al llamar al metodo que lo busca la complejidad es O(N)
		 * siendo N la cantidad de arcos
		 */
		if (!this.existeArco(arco)) {
			arcos.add(arco);
		}
	}

	public ArrayList<Arco<T>> getArcos() {
		/*
		 * Retorna el atributo arcos por lo que la complejidad es O(1)
		 */
		return arcos;
	}
	
	public Arco<T> getArco(int verticeId) {
		/*
		 * Retorna el arco que existe entre este vertice y el id destino pasado
		 * por parametro. La complejidad es O(N) siendo N la cantidad de arcos
		 * por llamar al metodo obtenerArco
		 */
		return (this.obtenerArco(verticeId));
	}
	
	public boolean existeArco(Arco<T> arco) {
		/* 
		 * Retorna V o F si existe o no el arco pasado por parametro
		 * por lo que su complejidad es O(N) siendo N la cantidad de arcos
		 */
		Iterator<Arco<T>> it = arcos.iterator();
		while (it.hasNext()) {
			if (it.next().getVerticeDestino() == arco.getVerticeDestino())
				return true;
		}
		return false;
	}
	
	public void borrarArco(int verticeId) {
		/*
		 * Este metodo borra un arco entre el vertice actual y el vertice pasado
		 * por parametro. Su complejidad es O(N) siendo N la cantidad de arcos ya que tiene que llamar al metodo
		 * obtener arco.
		 */
		this.arcos.remove(this.obtenerArco(verticeId));
	}
	
	private Arco<T> obtenerArco(int verticeId) {
		/*
		 * Este metodo retorna el arco entre el vertice actual y el vertice con id
		 * pasado por parametro. Como tiene que buscar el arco su complejidad es O(N)
		 * O(V + A) siendo V la cantidad de vertices y A la cantidad de aristas
		 */
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

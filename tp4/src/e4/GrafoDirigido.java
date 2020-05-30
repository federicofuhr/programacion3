package e4;

import java.util.ArrayList;
import java.util.Iterator;

public class GrafoDirigido<T> implements Grafo<T> {
	
	private ArrayList<Vertice<T>> vertices;
	
	public GrafoDirigido() {
		// Constructor de la clase GrafoDirigido
		vertices = new ArrayList<Vertice<T>>();
	}

	@Override
	public void agregarVertice(int verticeId) {
		/*
		 *  Agrego un vertice en el grafo, primero verificando que no exista.
		 *  Por lo tanto su complejidad es O(N) siendo N la cantidad de vertices
		 */
		Vertice<T> v = new Vertice<T>(verticeId);
		if (!this.contieneVertice(verticeId)) {
			this.vertices.add(v);
		}
	}

	@Override
	public void borrarVertice(int verticeId) {
		/*
		 * Busco el vertice y si existe lo borro un vertice del grafo,
		 * eliminando su referencia tambien a todos los arcos
		 * por lo que su complejidad es O(V + A) siendo V la cantidad de vertices
		 * y A la cantidad de arcos
		 */
		if (this.contieneVertice(verticeId)) {
			this.vertices.remove(this.obtenerVertice(verticeId));
			for (Vertice<T> vertice : vertices) {
				vertice.borrarArco(verticeId);
			}
		}
	}

	@Override
	public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {
		/*
		 * Busca si existen los 2 vertices pasados por parametro,
		 * si existen verifica que no exista ese arco y si no existe
		 * lo crea. Su complejidad es O(V + A) siendo V los vertices y A
		 * los arcos
		 */
		if (contieneVertice(verticeId1) && contieneVertice(verticeId2))
			if (!this.existeArco(verticeId1, verticeId2)) {
				Arco<T> a = new Arco<T>(verticeId1, verticeId2, etiqueta);
				Vertice<T> v = this.obtenerVertice(verticeId1);
				v.addArco(a);
			}	
	}

	@Override
	public void borrarArco(int verticeId1, int verticeId2) {
		/*
		 *  Busco el vertice origen y si existe borro el arco entrando en su lista de arcos.
		 *  Su complejidad es O(V + A) siendo V los vertices y A los arcos
		 */
		if (this.existeArco(verticeId1, verticeId2)) {
			Vertice<T> v = this.obtenerVertice(verticeId1);
			v.borrarArco(verticeId2);
		}
	}

	@Override
	public boolean contieneVertice(int verticeId) {
		/*
		 *  Responde con V o F si el grafo contiene un vertice con el id pasado por parametro
		 *  La complejidad es O(N) siendo N el numero de vertices
		 */
		Iterator<Vertice<T>> it = this.vertices.iterator();
		boolean exist = false;
		while ((!exist) && (it.hasNext())) {
			if (it.next().getId() == verticeId)
				exist = true;
		}
		return exist;
	}

	@Override
	public boolean existeArco(int verticeId1, int verticeId2) {
		/*
		 *  Responde si existe o no un arco
		 *  Siendo su complejidad O(V + A) con V de la cantidad de vertices y
		 *  A de la cantidad de adyacentes
		 */
		if ((contieneVertice(verticeId1)) && (contieneVertice(verticeId2))) {
			Arco<T> a = new Arco<T>(verticeId1, verticeId2);
			Vertice<T> v = this.obtenerVertice(verticeId1);
			return v.existeArco(a);
		}
		return false;
	}

	@Override
	public Arco<T> obtenerArco(int verticeId1, int verticeId2) {
		/*
		 *  Retorna el arco de los id solicitados si existe
		 *  Su complejidad es O(V + A) siendo V la cantidad de vertices
		 *  y A la cantidad de Arcos
		 */
		if (existeArco(verticeId1, verticeId2)) {
			Vertice<T> v = this.obtenerVertice(verticeId1);
			return v.getArco(verticeId2);
		}
		return null;
	}

	@Override
	public int cantidadVertices() {
		/*
		 *  Retorna la cantidad de vertices por lo que la complejidad es O(1)
		 */
		return vertices.size();
	}

	@Override
	public int cantidadArcos() {
		/*
		 *  Retorna la cantidad de arcos del grafo por lo que su complejidad
		 *  es O(N) siendo N la cantidad de vertices
		 */
		int res = 0;
		for (Vertice<T> vertice : vertices) {
			res += vertice.getArcos().size();
		}
		return res;
	}

	@Override
	public Iterator<Integer> obtenerVertices() {
		/*
		 *  Retorno un iterador para iterar en la lista de vertices
		 *  por lo que la complejidad es O(1)
		 */
		return (new IteradorVertice<T>(this.vertices));
	}

	@Override
	public Iterator<Integer> obtenerAdyacentes(int verticeId) {
		/*
		 * Retorna el iterador de la lista de todos los id de los vertices adyacentes
		 * de un vertice pasado por parametro.
		 * Su complejidad es O(V + A) siendo V la cantidad de vertices y 
		 * A la cantidad de adyacentes
		 */
		ArrayList<Integer> res = new ArrayList<Integer>();
		Vertice<T> v = this.obtenerVertice(verticeId);
		Iterator<Arco<T>> it = v.getArcos().iterator();
		while (it.hasNext()) {
			res.add(it.next().getVerticeDestino());
		}
		return res.iterator();
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos() {
		/*
		 * Retorna el iterador de una lista que tiene todos los arcos del grafo
		 * La complejidad es O(N) siendo la cantidad de vertices
		 */
		if (cantidadVertices() > 0) {
			ArrayList<Arco<T>> res = new ArrayList<Arco<T>>();
			for (Vertice<T> vertice : this.vertices) {
				res.addAll(vertice.getArcos());
			}
			return (res.iterator());
		}
		return (new ArrayList<Arco<T>>().iterator());
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos(int verticeId) {
		/*
		 * Retorno un iterador de una lista de arcos de un id de un vertice dado.
		 * La complejidad es O(N) siendo N todos los vertices del grafo
		 */
		if (contieneVertice(verticeId)) {
			Vertice<T> v = this.obtenerVertice(verticeId);
			return (v.getArcos().iterator());
		}
		return (new ArrayList<Arco<T>>()).iterator();
	}
	
	private Vertice<T> obtenerVertice(int verticeId) {
		/*
		 * Retorno un vertice con el id pasado por parametro.
		 * Su complejidad es O(N) siendo N la cantidad de vertices del grafo
		 */
		if (contieneVertice(verticeId)) {
			Iterator<Vertice<T>> it = this.vertices.iterator();
			while (it.hasNext()) {
				Vertice<T> v = it.next();
				if (v.getId() == verticeId) {
					return v;
				}
			}
		}
		return null;
	}
	
	public boolean estaVacio() {
		return (this.cantidadVertices() == 0);
	}

	@Override
	public String toString() {
		// Metodo toString
		String s = "Grafo dirigido: \n";
		for (Vertice<T> vertice : vertices) {
			s += vertice;
			if (vertice.getArcos().isEmpty())
				s += "\n";
		}
		return s;
	}
	
}

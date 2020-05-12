package grafo;

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
		// Agrego un vertice en el grafo, primero verificando que no exista
		Vertice<T> v = new Vertice<T>(verticeId);
		if (!this.contieneVertice(verticeId)) {
			this.vertices.add(v);
		}
	}

	@Override
	public void borrarVertice(int verticeId) {
		// Borro un vertice del grafo, eliminando tambien todos los arcos
		if (this.contieneVertice(verticeId)) {
			this.vertices.remove(this.obtenerVertice(verticeId));
			for (Vertice<T> vertice : vertices) {
				vertice.borrarArco(verticeId);
			}
		}
	}

	@Override
	public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {
		// Agrega un nuevo arco al grafo
		if (contieneVertice(verticeId1) && contieneVertice(verticeId2))
			if (!this.existeArco(verticeId1, verticeId2)) {
				Arco<T> a = new Arco<T>(verticeId1, verticeId2, etiqueta);
				Vertice<T> v = this.obtenerVertice(verticeId1);
				v.addArco(a);
			}	
	}

	@Override
	public void borrarArco(int verticeId1, int verticeId2) {
		// Busco el vertice origen y luego borro el arco entrando en su lista de arcos
		if (this.existeArco(verticeId1, verticeId2)) {
			Vertice<T> v = this.obtenerVertice(verticeId1);
			v.borrarArco(verticeId2);
		}
	}

	@Override
	public boolean contieneVertice(int verticeId) {
		// Responde con V o F si el grafo contiene un vertice con el id pasado por parametro
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
		// Responde si existe o no un arco
		if ((contieneVertice(verticeId1)) && (contieneVertice(verticeId2))) {
			Arco<T> a = new Arco<T>(verticeId1, verticeId2);
			Vertice<T> v = this.obtenerVertice(verticeId1);
			return v.existeArco(a);
		}
		return false;
	}

	@Override
	public Arco<T> obtenerArco(int verticeId1, int verticeId2) {
		// Retorna el arco de los id solicitados si existe
		if (existeArco(verticeId1, verticeId2)) {
			Vertice<T> v = this.obtenerVertice(verticeId1);
			v.getArco(verticeId2);
		}
		return null;
	}

	@Override
	public int cantidadVertices() {
		// Retorna la cantidad de vertices
		return vertices.size();
	}

	@Override
	public int cantidadArcos() {
		// TODO Auto-generated method stub
		int res = 0;
		for (Vertice<T> vertice : vertices) {
			res += vertice.getArcos().size();
		}
		return res;
	}

	@Override
	public Iterator<Integer> obtenerVertices() {
		// Retorno un iterador para iterar en la lista de vertices
		return (new IteradorVertice<T>(this.vertices));
	}

	@Override
	public Iterator<Integer> obtenerAdyacentes(int verticeId) {
		// TODO Auto-generated method stub
		ArrayList<Integer> res = new ArrayList<Integer>();
		Vertice<T> v = this.obtenerVertice(verticeId);
		Iterator<Arco<T>> it = new IteradorArcos<>(v.getArcos());
		while (it.hasNext()) {
			res.add(it.next().getVerticeDestino());
		}
		return res.iterator();
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos() {
		// TODO Auto-generated method stub
		if (cantidadVertices() > 0) {
			ArrayList<Arco<T>> res = new ArrayList<Arco<T>>();
			for (Vertice<T> vertice : this.vertices) {
				res.addAll(vertice.getArcos());
			}
			return (new IteradorArcos<>(res));
		}
		return (new IteradorArcos<>(new ArrayList<Arco<T>>()));
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos(int verticeId) {
		// Retorno un iterador para iterar en la lista de arcos de un vertice
		if (contieneVertice(verticeId)) {
			Vertice<T> v = this.obtenerVertice(verticeId);
			return (new IteradorArcos<>(v.getArcos()));
		}
		return (new IteradorArcos<>(new ArrayList<Arco<T>>()));
	}
	
	private Vertice<T> obtenerVertice(int verticeId) {
		// Retorno un vertice con el id pasado por parametro
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

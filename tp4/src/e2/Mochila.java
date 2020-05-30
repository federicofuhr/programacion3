package e2;

import java.util.ArrayList;

public class Mochila {
	private ArrayList<Objeto> objetos;
	private int capacidad;
	
	public Mochila(int capacidad) {
		// TODO Auto-generated constructor stub
		this.objetos = new ArrayList<Objeto>();
		this.capacidad = capacidad;
	}
	
	public int getCantidadObjetos() {
		return (this.objetos.size());
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public ArrayList<Objeto> getObjetos() {
		return objetos;
	}
	
	public void addObjeto(Objeto o) {
		objetos.add(o);
	}
}

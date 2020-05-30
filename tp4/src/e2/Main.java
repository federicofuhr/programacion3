package e2;

import java.util.ArrayList;
import java.util.Iterator;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Objeto> objetos = new ArrayList<Objeto>();
		
		objetos.add(new Objeto(10,20));
		objetos.add(new Objeto(20,30));
		objetos.add(new Objeto(30,66));
		objetos.add(new Objeto(40,40));
		objetos.add(new Objeto(50,60));
		
		Mochila mochila = new Mochila(100);
		
		System.out.println("Resultado: " + obtenerMejorLlenado(mochila, objetos));
	}

	private static ArrayList<Double> obtenerMejorLlenado(Mochila mochila, ArrayList<Objeto> objetos) {
		// TODO Auto-generated method stub
		ArrayList<Double> fracciones = new ArrayList<Double>();
		for (int i = 0; i < objetos.size(); i++) {
			fracciones.add(0.0);
		}
		int peso = 0;
		while (peso < mochila.getCapacidad()) {
			int i = seleccion(objetos);
			if (peso + objetos.get(i).getPeso() < mochila.getCapacidad()) {
				fracciones.set(i, 1.0);
				peso += objetos.get(i).getPeso();
			} else {
				double operacion = ((double)mochila.getCapacidad() - (double)peso) / objetos.get(i).getPeso();
				fracciones.set(i, operacion);
				peso = mochila.getCapacidad();
			}
			objetos.set(i, new Objeto(0,0));
		}
		return fracciones;
	}

	private static int seleccion(ArrayList<Objeto> objetos) {
		// TODO Auto-generated method stub
		double vpMaximo = 0;
		Objeto objetoDeseado = null;
		for (int i = 0; i < objetos.size(); i++) {
			Objeto objeto = objetos.get(i);
			if (objeto.getValorXPeso() > vpMaximo) {
				vpMaximo = objeto.getValorXPeso();
				objetoDeseado = new Objeto(objeto);
			}
		}
		return obtenerIndice(objetos, objetoDeseado);
	}

	private static int obtenerIndice(ArrayList<Objeto> objetos, Objeto objetoDeseado) {
		// TODO Auto-generated method stub
		int i = 0;
		boolean exit = false;
		Iterator<Objeto> it = objetos.iterator();
		while ((!exit) && (it.hasNext())) {
			Objeto o = it.next();
			if (o.equals(objetoDeseado))
				exit = true;
			else
				i++;
		}
		return i;
	}

}

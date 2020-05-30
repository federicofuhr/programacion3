package e1;

import java.util.ArrayList;
import java.util.Iterator;

public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> billetes = new ArrayList<Integer>();
		
		billetes.add(10);
		billetes.add(5);
		billetes.add(100);
		billetes.add(1);
		billetes.add(25);
		
		int dinero = 289;
		
		ArrayList<Integer> billetesEntregados = greedy(billetes, dinero);
		System.out.println("Conjunto solucion: " + billetesEntregados);
	}

	private static ArrayList<Integer> greedy(ArrayList<Integer >billetes, int dineroNecesitado) {
		// TODO Auto-generated method stub
		ArrayList<Integer> conjuntoSolucion = new ArrayList<Integer>();
		int dineroActual = 0;
		while (!billetes.isEmpty() && (!solucion(dineroActual, dineroNecesitado))) {
			int billete = seleccionar(billetes, dineroActual, dineroNecesitado);
			dineroActual += billete;
			if ((dineroActual + billete) > dineroNecesitado) {
				billetes.remove((Object)billete);
			}
			conjuntoSolucion.add(billete);
		}
		return conjuntoSolucion;
	}

	private static int seleccionar(ArrayList<Integer> billetes, int dineroActual, int dineroNecesitado) {
		// TODO Auto-generated method stub
		Iterator<Integer> it = billetes.iterator();
		Integer mejorBillete = 0;
		int sumaMaxima = 0;
		while (it.hasNext()) {
			int billeteActual = it.next();
			int suma = billeteActual + dineroActual;
			if (suma <= dineroNecesitado) {
				if (suma > sumaMaxima) {
					mejorBillete = billeteActual;
					sumaMaxima = suma;
				}
			}
		}
		return mejorBillete;
	}

	private static boolean solucion(int dineroActual, int dinero) {
		// TODO Auto-generated method stub
		return (dineroActual == dinero);
	}

}

package e3;

import java.util.ArrayList;
import java.util.Collections;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Actividad> actividades = new ArrayList<Actividad>();
		
		actividades.add(new Actividad('C', 5, 7));
		actividades.add(new Actividad('H', 12, 16));
		actividades.add(new Actividad('F', 8, 11));
		actividades.add(new Actividad('D', 3, 9));
		actividades.add(new Actividad('E', 6, 10));
		actividades.add(new Actividad('B', 0, 6));
		actividades.add(new Actividad('G', 8, 12));
		actividades.add(new Actividad('A', 1, 4));
		System.out.println(actividades);
		
		System.out.println("Mejor eleccion de actividades:\n" + selectorActividad(actividades));
	}

	private static ArrayList<Actividad >selectorActividad(ArrayList<Actividad> actividades) {
		// La complejidad es O(N * log(N)) siendo N la cantidad de actividades
		// Ya que tengo que ordenar primero por el tiempo de finalizacion ascendentemente
		Collections.sort(actividades);
		ArrayList<Actividad> resultado = new ArrayList<Actividad>();
		resultado.add(actividades.get(0));
		int k = 0;
		for (int i = 1; i < actividades.size(); i++) {
			if (actividades.get(i).getC() >= actividades.get(k).getF()) {
				resultado.add(actividades.get(i));
				k = i;
			}
		}
		return resultado;
	}

}

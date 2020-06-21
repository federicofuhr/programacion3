package entregable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
	
	public static void main(String... args) {
		
		CSVReader reader = new CSVReader("./data/familias-1.csv");
		
		ArrayList<Familia> familias = reader.read();

		CSVReader reader2 = new CSVReader("./data/familias-2.csv");
		
		ArrayList<Familia> familias2 = reader2.read();
		
		Cronograma cronograma = new Cronograma();
		
		for (int i = 1; i <= 10; i++) {
			cronograma.agregarDia(i);
		}
		
		int indice = 0;
		
		AtomicInteger cantidadEstados = new AtomicInteger(0);
		
		Cronograma cronogramaSolucion = new Cronograma();
		cronogramaSolucion.setCostoTotal(Integer.MAX_VALUE);
		
		backtracking(familias, indice, cronograma, cronogramaSolucion, cantidadEstados);
		
		System.out.println(cronogramaSolucion);
		System.out.println("Cantidad de estados: " + cantidadEstados);
	}
	
	public static void backtracking(ArrayList<Familia> familias, int indice, Cronograma cronograma, Cronograma cronogramaSolucion, AtomicInteger cantidadEstados) {
		cantidadEstados.incrementAndGet();
		if (cronograma.getCantidadTotalFamilias() == familias.size()) {
			if ((cronogramaSolucion.getCostoTotal() == 0) || (cronograma.getCostoTotal() <= cronogramaSolucion.getCostoTotal())) {
				cronogramaSolucion.copiarInformacion(cronograma);
			}
		} else {
			for (int i = 0; i < 3; i++) {
				Familia familia = familias.get(indice);
				int dia = familia.preferenciaEn(i);
				int bonoActual = obtenerCalculoBono(familia, dia);
					if (cronograma.getCantidadPersonas(dia) + familia.miembros() <= 30) {
						if (i != 0) {
							if (poda(cronograma.getCostoTotal(), bonoActual, cronogramaSolucion.getCostoTotal())) {
								cronograma.agregarFamilia(dia, familia, bonoActual);
								backtracking(familias, indice + 1, cronograma, cronogramaSolucion, cantidadEstados);
								cronograma.sacarFamilia(dia, familia, bonoActual);															
							}
						} else {
							cronograma.agregarFamilia(dia, familia, 0);
							backtracking(familias, indice + 1, cronograma, cronogramaSolucion, cantidadEstados);
							cronograma.sacarFamilia(dia, familia, 0);
						}
					}
			}
		}	
	}
	
	public static boolean poda(int costoTotal, int bonoActual, int mejorCosto) {
		return ((costoTotal + bonoActual) < mejorCosto);
	}
	
	public static int obtenerCalculoBono(Familia f, int dia) {
		return (25 + (10 * f.miembros()) + (5 * f.indiceDePreferencia(dia)));
	}
}

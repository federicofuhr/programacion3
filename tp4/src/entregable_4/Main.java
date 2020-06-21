package entregable_4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

	public static void main(String... args) {
		
		CSVReader reader = new CSVReader("./data/familias.csv");
		
		ArrayList<Familia> familias = reader.read();
		
		int diasDisponibles = 100;
		int capacidadMaxima = 340;
		
		AtomicInteger bonoActual = new AtomicInteger(0);
		
		Hashtable<Integer, ArrayList<Familia>> cronograma = organizarFamilias(familias, diasDisponibles, capacidadMaxima, bonoActual);
		
		Hashtable<Integer, ArrayList<Familia>> cronogramaNuevo = aplicarTransformacion(cronograma, capacidadMaxima);
		
		Enumeration<Integer> e = cronogramaNuevo.keys();
		while (e.hasMoreElements()) {
			Integer diaActual = e.nextElement();
			ArrayList<Familia> idFamilias = cronogramaNuevo.get(diaActual);
			System.out.println("Dia " + diaActual + " tiene un total de " + idFamilias.size() + " familias");
			for (Familia familia : idFamilias) {
				System.out.println("Familia " + familia.getId() + " con " + familia.miembros() + " cantidad de miembros");
			}
			System.out.println();
		}
		
		System.out.println("Bono minimo actual: " + bonoActual);
		System.out.println("Bono con la transformacion: " + calcularBono(cronogramaNuevo));
		
	}
	
	private static int calcularBono(Hashtable<Integer, ArrayList<Familia>> cronograma) {
		// ESTE METODO RECORRE TODA LA HASHTABLE DE CRONOGRAMA PARA CALCULAR EL BONO TOTAL
		int bono = 0;
		
		Set<Integer> keys = cronograma.keySet();
		
		for (Integer dia : keys) {
			ArrayList<Familia> familias = cronograma.get(dia);
			for (Familia familia : familias) {
				int indiceActual = familia.indiceDePreferencia(dia);
				if (familia.diaPreferido() != dia)
					bono += obtenerBono(familia, indiceActual);
			}
		}
		
		return bono;
	}

	private static Hashtable<Integer, ArrayList<Familia>> aplicarTransformacion(
		Hashtable<Integer, ArrayList<Familia>> cronograma, int capacidadMaxima) {
		// ESTE METODO APLICA UNA TRANSFORMACION PARA TRATAR DE BAJAR EL COSTO DE LOS BONOS
		
		int[] cantidadPersonasPorDia = new int[100];
		
		for (int i = 0; i < cantidadPersonasPorDia.length; i++) {
			cantidadPersonasPorDia[i] = 0;
		}
		
		Set<Integer> keys3 = cronograma.keySet();
		for (Integer i : keys3) {
			ArrayList<Familia> familias = cronograma.get(i);
			for (Familia familia : familias) {
				cantidadPersonasPorDia[i-1] = cantidadPersonasPorDia[i-1] + familia.miembros();				
			}
		}
		
		Set<Integer> keys = cronograma.keySet();
		
		for (int i = 1; i <= keys.size(); i++) {
			Familia familiaA = cronograma.get(i).get(cronograma.get(i).size() - 1);
			for (int j = 1; j <= keys.size(); j++) {
				Familia familiaB = cronograma.get(j).get(cronograma.get(j).size() - 1);
				if (familiaA.miembros() < familiaB.miembros())
					if ((familiaB.diaPreferido() == i) && (cantidadPersonasPorDia[i-1] - familiaA.miembros() + familiaB.miembros() <= capacidadMaxima)) {
						cronograma.get(j).remove(familiaB);
						cantidadPersonasPorDia[j-1] = cantidadPersonasPorDia[j-1] - familiaB.miembros();
						cronograma.get(j).add(familiaA);
						cantidadPersonasPorDia[j-1] = cantidadPersonasPorDia[j-1] + familiaA.miembros();
						cronograma.get(i).remove(familiaA);
						cantidadPersonasPorDia[i-1] = cantidadPersonasPorDia[i-1] - familiaA.miembros();
						cronograma.get(i).add(familiaB);
						cantidadPersonasPorDia[i-1] = cantidadPersonasPorDia[i-1] + familiaB.miembros();
					}
				j++;
			}
			i++;
		}
		
		return cronograma;
	}

	private static Hashtable<Integer, ArrayList<Familia>> organizarFamilias(ArrayList<Familia> familias, int diasDisponibles, int capacidadMaxima, AtomicInteger bonoActual) {
		Hashtable<Integer, ArrayList<Familia>> cronograma = new Hashtable<Integer, ArrayList<Familia>>();
		// ESTE METODO BUSCA COMPLETAR EL CRONOGRAMA DE FAMILIAS TRATAN DE OBTENER EL MINIMO BONO TOTAL
		
		int[] cantidadPersonasPorDia = new int[100];
		
		for (int i = 0; i < cantidadPersonasPorDia.length; i++) {
			cantidadPersonasPorDia[i] = 0;
		}
		
		Collections.sort(familias, new ComparadorMiembrosDiasPreferidos());
		
		Iterator<Familia> it = familias.iterator();
		while (it.hasNext()) {
			Familia familiaActual = it.next();
			boolean exit = false;
			int posicionDiaPreferidoDisponible = 0;
			int i = 0;
			while (!exit && (i < familiaActual.cantidadDiasPreferidos())) {
				if ((cantidadPersonasPorDia[familiaActual.preferenciaEn(i) - 1] + familiaActual.miembros()) <= capacidadMaxima) {
					exit = true;
					posicionDiaPreferidoDisponible = i;
					if (i != 0) {
						int bono = bonoActual.get();
						bono += obtenerBono(familiaActual, i);
						bonoActual.set(bono);
					}
					int diaPreferido = familiaActual.preferenciaEn(i);
					Set<Integer> keys = cronograma.keySet();
					if (!keys.contains(diaPreferido)) {
						ArrayList<Familia> listaFamilias = new ArrayList<Familia>();
						listaFamilias.add(familiaActual);
						cronograma.put(diaPreferido, listaFamilias);
					} else {
						cronograma.get(familiaActual.preferenciaEn(i)).add(familiaActual);
					}
				} else {				
					i++;					
				}
			}
			cantidadPersonasPorDia[familiaActual.preferenciaEn(posicionDiaPreferidoDisponible) - 1] += familiaActual.miembros();
		}
		return cronograma;
	}


	private static double obtenerBono(Familia familiaActual, int indiceDia) {
		// ESTE METODO REALIZA EL CALCULO PARA OBTENER EL BONO PARA UNA FAMILIA DADA
		return (25 + (10 * familiaActual.miembros()) + (5 * indiceDia));
	}

}

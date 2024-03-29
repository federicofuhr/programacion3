package entregable_4;

import java.util.Arrays;

/* Una familia, con su cantidad de dias, y una arreglo con el top de 4 dias preferidos */
public class Familia implements Comparable<Familia> {

	private int id;
	private int miembros;
	private int[] diasPreferidos;
	
	public Familia(int id, int miembros, int... diasPreferidos) {
		this.id = id;
		this.miembros = miembros;
		this.diasPreferidos = diasPreferidos;
	}

	/* Id de la familia */
	public int getId() {
		return id;
	}


	/* Retorna la cantidad de miembros de la familia. */
	public int miembros() {
		return miembros;
	}

	public int cantidadDiasPreferidos() {
		return this.diasPreferidos.length;
	}
	
	public double obtenerPromedioDias() {
		double suma = 0;
		for (int i = 0; i < diasPreferidos.length; i++) {
			suma += diasPreferidos[i];
		}
		return (suma/cantidadDiasPreferidos());
	}
	
	/* Dado un indice entre 0 y 4, retorna el d�a preferido por la familia para ese indice. */
	public int preferenciaEn(int indice) {
		return this.diasPreferidos[indice];
	}
	
	/* Retorna el d�a preferido de la familia */
	public int diaPreferido() {
		return preferenciaEn(0);
	}
	
	/* Dado un dia pasado por parametro, indica el orden de ese dia en el top 5 de preferencias.
	Si el dia no forma parte de las preferencias del usuario, se retorna -1. */ 
	public int indiceDePreferencia(int dia) {
		for (int indice = 0; indice < diasPreferidos.length; indice++)
			if (dia == diasPreferidos[indice])
				return indice;
		return -1;
	}

	@Override
	public String toString() {
		return "Familia: id=" + id + ", miembros=" + miembros + ", preferencias=" + Arrays.toString(diasPreferidos);
	}

	@Override
	public int compareTo(Familia f) {
		// TODO Auto-generated method stub
		if (f.miembros() > this.miembros())
			return -1;
		else if (f.miembros() < this.miembros())
			return 1;
		return 0;
	}
}

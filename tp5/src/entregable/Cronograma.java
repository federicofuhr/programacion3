package entregable;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;


public class Cronograma {
	private Hashtable<Integer, ArrayList<Familia>> cronograma;
	private int cantidadTotalFamilias;
	private int costoTotal;

	public Cronograma() {
		super();
		cronograma = new Hashtable<Integer, ArrayList<Familia>>();
		cantidadTotalFamilias = 0;
		costoTotal = 0;
	}
	
	public Cronograma(Cronograma c) {
		this.cronograma = c.obtenerCopia();
		this.cantidadTotalFamilias = c.getCantidadTotalFamilias();
		this.costoTotal = c.getCostoTotal();
	}

	public void agregarDia(int dia) {
		cronograma.put(dia, new ArrayList<Familia>());
	}
	
	public void agregarFamilia(int dia, Familia f, int bono) {
		Set<Integer> keys = cronograma.keySet();
		if (!keys.contains(dia)) {
			ArrayList<Familia> listaFamilias = new ArrayList<Familia>();
			listaFamilias.add(f);
			cronograma.put(dia, listaFamilias);
		} else {
			cronograma.get(dia).add(f);
		}		
		cantidadTotalFamilias += 1;
		costoTotal += bono;
	}

	public int getCostoTotal() {
		return costoTotal;
	}

	public int getCantidadTotalFamilias() {
		return cantidadTotalFamilias;
	}
	
	public void sacarFamilia(int dia, Familia f, int bono) {
		cronograma.get(dia).remove(f);
		cantidadTotalFamilias -= 1;
		costoTotal -= bono;
	}
	
	public int getCantidadPersonas(int dia) {
		int suma = 0;
		ArrayList<Familia> familias = cronograma.get(dia);
		for (int i = 0; i < familias.size(); i++) {
			suma += familias.get(i).miembros();
		}
		return suma;
	}
	
	public Hashtable<Integer, ArrayList<Familia>> obtenerCopia() {
		Hashtable<Integer, ArrayList<Familia>> copia = new Hashtable<Integer, ArrayList<Familia>>();
		
		Set<Integer> keys = this.cronograma.keySet();
		for (Integer key : keys) {
			ArrayList<Familia> familias = this.cronograma.get(key);
			ArrayList<Familia> copiaFamilias = new ArrayList<Familia>();
			for (Familia familia : familias) {
				copiaFamilias.add(new Familia(familia.getId(), familia.miembros(), familia.diaPreferido()));
			}
			copia.put(key, copiaFamilias);
		}
		
		return copia;
	}

	@Override
	public String toString() {
		String s = "";
		Set<Integer> keys = this.cronograma.keySet();
		for (Integer key : keys) {
			s += "Dia " + key + "\n";
			s += cronograma.get(key).toString() + "\n";
		}
		s += "Cantidad total de familias: " + this.getCantidadTotalFamilias() + "\nBono: " + this.getCostoTotal();
		return s;
	}
	
	public boolean contains(Familia f) {
		boolean existe = false;
		Set<Integer> keys = this.cronograma.keySet();
		Iterator<Integer> it = keys.iterator();
		while (!existe && it.hasNext()) {
			ArrayList<Familia> familias = cronograma.get(it.next());
			existe = familias.contains(f);
		}
		return existe;
	}

	public void copiarInformacion(Cronograma cronograma) {
		// TODO Auto-generated method stub
		this.cronograma = cronograma.obtenerCopia();
		this.cantidadTotalFamilias = cronograma.getCantidadTotalFamilias();
		this.costoTotal = cronograma.getCostoTotal();
		
	}

	public void setCostoTotal(int n) {
		// TODO Auto-generated method stub
		costoTotal = n;
	}
}

package entregable_4;

import java.util.Comparator;

public class ComparadorMiembrosDiasPreferidos implements Comparator<Familia>{

	@Override
	public int compare(Familia f1, Familia f2) {
		// TODO Auto-generated method stub
		if (f1.miembros() > f2.miembros())
			return 1;
		else if (f1.miembros() < f2.miembros())
			return -1;
		else if (f1.miembros() == f2.miembros()) {
			if (f1.diaPreferido() > f2.diaPreferido())
				return -1;
			else if (f1.diaPreferido() < f2.diaPreferido())
				return 1;
		}
		return 0;
	}

}

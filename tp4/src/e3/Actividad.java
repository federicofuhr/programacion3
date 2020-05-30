package e3;

public class Actividad implements Comparable<Actividad>{
	private char id;
	private int c;
	private int f;
	
	public Actividad(char id, int c, int f) {
		super();
		this.id = id;
		this.c = c;
		this.f = f;
	}
	
	public Actividad(Actividad a) {
		this.id = a.getId();
		this.c = a.getC();
		this.f = a.getF();
	}

	public int getC() {
		return c;
	}

	public void setC(int c) {
		this.c = c;
	}

	public int getF() {
		return f;
	}

	public void setF(int f) {
		this.f = f;
	}

	public char getId() {
		return id;
	}

	public void setId(char id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "[C=" + getC() + ", F=" + getF() + ", ID=" + getId() + "]";
	}

	@Override
	public int compareTo(Actividad a) {
		// TODO Auto-generated method stub
		if (a.getF() > this.getF())
			return -1;
		else if (a.getF() == this.getF())
			return 0;
		else
			return 1;
	}
	
}

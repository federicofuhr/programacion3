package e2;

public class Objeto {
	private int peso, valor;

	public Objeto(int peso, int valor) {
		super();
		this.peso = peso;
		this.valor = valor;
	}

	public Objeto(Objeto objeto) {
		// TODO Auto-generated constructor stub
		this.peso = objeto.getPeso();
		this.valor = objeto.getValor();
	}

	public boolean equals(Objeto obj) {
		// TODO Auto-generated method stub
		return ((this.getPeso() == obj.getPeso()) && (this.getValor() == obj.getValor()));
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}
	
	public double getValorXPeso() {
		if (this.getPeso() != 0)
			return ((double)this.valor / (double)this.peso);
		return 0f;
	}

	@Override
	public String toString() {
		return "[peso=" + peso + ", valor=" + valor + ", v/p=" + this.getValorXPeso() + "]\n";
	}
	
}

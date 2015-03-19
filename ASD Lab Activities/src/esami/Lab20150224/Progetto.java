package esami.Lab20150224;

public class Progetto {
	private String nome;
	private int codice;
	
	
	public Progetto (String n) {
		this.nome = n;
		this.codice = this.hashCode();
	}

	public int getCodice () {
		return codice;
	}
	
	public String getNome () {
		return nome;
	}
}

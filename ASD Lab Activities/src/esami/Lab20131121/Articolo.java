package esami.Lab20131121;

public class Articolo implements Comparable {
	String nome;
	String misura;

	public Articolo(String nome, String misura) {
		this.nome = nome;
		this.misura = misura;

	}
	
	public String toString () {
		return nome + " " + misura;
	}

	public int compareTo(Object o) {
		Articolo a = (Articolo) o;
		return this.toString().compareTo(a.toString());
	}

}

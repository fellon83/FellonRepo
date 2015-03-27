package esami.Lab20130917;

public class Prodotto {

	private String nome;
	private int prezzo;
	
	public Prodotto(String nome, int prezzo) {
		this.nome=nome;
		this.prezzo=prezzo;
	}
	
	public String getNome() {
		return nome;
	}
	
	public int getPrezzo() {
		return prezzo;
	}
}

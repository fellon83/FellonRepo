package esami.Lab20130221.Carrello;

import esami.Lab20130221.Articoli.Articolo;

public class Item {
	private Articolo articolo;
	private int quantita;


	public Item(Articolo art, int quan) {
		this.articolo = art;
		this.quantita = quan;
	}

	public Articolo getArticolo() {
		return this.articolo;
	}
	
	public int getQuantita() {
		return this.quantita;
	}
}

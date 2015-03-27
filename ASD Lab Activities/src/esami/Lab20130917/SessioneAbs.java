package esami.Lab20130917;

public abstract class SessioneAbs implements Iterable<Prodotto> {

	protected AddOnlyList<Prodotto> prodotti;
	private int nProd = 0;
	
	
	public void addProdotto(String nome, int prezzo) {
		Prodotto p = new Prodotto(nome, prezzo);
		prodotti.add(p);
		nProd++;
	}
	
	public String toString() {
		String str = "";
		for (Prodotto p: prodotti) {
			str += "Prodotto: " + p.getNome() + "    Prezzo: " + p.getPrezzo() + "€\n";
		}
		return str;
	}
	

}

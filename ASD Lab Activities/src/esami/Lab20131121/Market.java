package esami.Lab20131121;

public class Market {
	protected Articolo[] merce;
	protected Carrello[] acquisti;
	
	
	public Market (Articolo[] prodottiDisp, Carrello[] speseEff) {
		merce = prodottiDisp;
		acquisti = speseEff;
	}
	/**
	 * stampa i singoli prodotti
	 */
	public void stampa() {
		for (int i=0; i<acquisti.length; i++) {
			int j=i+1;
			System.out.println("--- CARRELLO " + (j) + " ---" );
			for (Object obj : acquisti[i]) {
				Articolo a = (Articolo) obj;
				System.out.println("Articolo : " + a.toString() + " Quantità: " + acquisti[i].quantità(a));				
			}
			System.out.println();
		}
	}
	
	/**
	 * stampa la quantita di ogni articolo acquistato
	 */
	public void istogramma() {
		System.out.println("--- ISTOGRAMMA ---");
		for (Articolo a: merce) {
			int nElemArt = 0;
			for (Carrello c: acquisti) {
				if (c.appartiene(a))
					nElemArt += c.quantità(a);
					
			}
			System.out.println("Articolo: " + a.toString() + " - Quantità: " + nElemArt );
		}		
	}
}

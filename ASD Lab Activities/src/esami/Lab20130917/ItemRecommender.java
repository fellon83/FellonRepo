package esami.Lab20130917;

import java.util.Random;

public class ItemRecommender {
	Sessioni sessioni;
	final static String[] PRODOTTI_DISP = { "CD Audio", "Film DVD",
			"Risma Carta", "Set Penne", "Orologio", "Tappetino mouse",
			"Set Quaderni", "Libro" };
	final static int[] PREZZI_PROD = { 5, 14, 3, 2, 25, 5, 4, 9 };
	final static int ACQUISTI_MAX = 5;

	public ItemRecommender(int n) {
		sessioni = new Sessioni();
		for (int i = 0; i < n; i++) {
			SessioneLL s = new SessioneLL();
			Random r = new Random();
			int numProdAcquistati = r.nextInt(ACQUISTI_MAX+1);
			if (numProdAcquistati < 2)
				numProdAcquistati += 2;
			for (int j = 0; j < numProdAcquistati; j++) {
				int idxProd = r.nextInt(PRODOTTI_DISP.length);
				s.addProdotto(PRODOTTI_DISP[idxProd], PREZZI_PROD[idxProd]);
			}
			sessioni.addSessione(s);
		}

	}

	public int acquistiAssociati(Prodotto a, Prodotto b) {
		int occorrenze = 0;
		boolean flagProdA = false;
		boolean flagProdB = false;
		for (SessioneLL s : sessioni) {
			for (Prodotto p : s) {
				if (p.getNome().equals(a.getNome())) {
					flagProdA = true;
					break;
				}
			}
			for (Prodotto p : s) {
				if (p.getNome().equals(b.getNome())) {
					flagProdB = true;
					break;
				}
			}
		if (flagProdA && flagProdB)
			occorrenze++;
		}

		return occorrenze;
	}
	
	public String toString () {
		String str="";
		int i=1;
		for (SessioneLL s: this.sessioni) {
			str += "---SESSIONE: " + i + "---\n";
			str += s.toString() + "\n\n"; 
			i++;
		}
		
		return str;
	}
}

package esami.Lab20131121;

import java.util.Random;

public class Test {

	public static void main(String[] args) {
		Articolo a1 = new Articolo("Frollini Dixie", "500g");
		Articolo a2 = new Articolo("Patatine SC", "80g");
		Articolo a3 = new Articolo("Yogurt P", "3pz");
		Articolo a4 = new Articolo("Cereali ABC", "380g");
		Articolo a5 = new Articolo("Uova di companga", "6pz");
		Articolo a6 = new Articolo("Pasta doc", "500g");
		Articolo a7 = new Articolo("Prodotto", "fake");
		Articolo[] prodottiDisp = { a1, a2, a3, a4, a5, a6, a7};
		
		Carrello[] carrelli = new Carrello[10];

		for (int nCarr = 0; nCarr < carrelli.length; nCarr++) {
			carrelli[nCarr] = new Carrello();
			Random r = new Random();
			int numAcq = r.nextInt(10)+1; // +1 per permettere almeno un acquisto
			for (int i = 0; i < numAcq; i++) {
				(carrelli[nCarr]).aggArticolo(prodottiDisp[r.nextInt(6)]);
			}
		}
	
		Market m = new Market(prodottiDisp, carrelli);
		m.stampa();
		m.istogramma();

	}

}

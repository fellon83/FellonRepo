package lab.Dizionario.HashTable;

import lab.Dizionario.Dizionario;

/*
 * è stata realizzata direttamente la TabellaHashApertaBis
 * implementando il delete tramite marcatore
 * e passando come parametri al costruttore sia la funzione HashDivisione
 * sia la funzione scansione lineare per il calcolo della posizione degli elementi
 */

public class TabellaHashApertaBis implements Dizionario {

	Coppia s[];
	Scansione cfun;
	Hash hfun;
	
	private static Object canc = new Object();
	
	private class Coppia {
		Object elem;
		Comparable key;
		
		Coppia (Object e, Comparable k) {
			this.elem = e;
			this.key = k;
		}
		
	}

	public TabellaHashApertaBis(Hash f, Scansione c, int m) {
		s = new Coppia[m];
		hfun = f;
		cfun = c;

	}

	/**
	 * Se la posizione individuata è "null" oppure marcata con "canc", allora si può 
	 * inserire la nuova coppia, altrimenti si passa ad un'altra posizione
	 */
	public void insert(Object e, Comparable k) {
		int hk = hfun.h(k, s.length);
		for (int i=0; i<s.length; i++) {
			int pos = cfun.c(hk, i, s.length);
			if ((s[pos]==null) || (s[pos].elem.equals(canc))) {
				s[pos] = new Coppia (e,k);
				return;
			}
		}
	

	}

	/**
	 * Se la posizione individuata è "null" , si interrompe (non esiste la chiave)oppure marcata con "canc", allora si può 
	 * altrimenti se la chiave si individua e la posizione non è stata marcata con canc allora è stata individuata la coppia
	 * da eliminare
	 */
	public void delete(Comparable k) {
		int hk = hfun.h(k, s.length);
		for (int i=0; i<s.length; i++) {
			int pos=cfun.c(hk, i, s.length);
			if (s[pos]==null)
				break;
			if ((s[pos].key.equals(k)) && (!s[pos].elem.equals(canc))){
				s[pos].elem = canc;
				break;
			}
		}
	

	}

	/**
	 * Se nella posizione individuata la chiave corrisponde e l'elemento non è marcato con "canc", allora si restituisce
	 * l'elemento, altrimenti si procede alla ricerca
	 */
	public Object search(Comparable k) {
		int hk = hfun.h(k, s.length);
		for (int i=0; i<s.length; i++) {
			int pos = cfun.c(hk, i, s.length);
			if (s[pos] == null)
				break;
			if (s[pos].key.equals(k) && !s[pos].elem.equals(canc))
				return s[pos].elem;
		}
	
		return null;
	}
	
	
	
	
	public static void main (String[] args) {
		Hash hFun = new HashDivisione();
		Scansione cFun = new ScansioneLineare();
		int tableDim = 10;
		TabellaHashApertaBis d = new TabellaHashApertaBis(hFun, cFun, tableDim);
		d.insert("1234", "Antonio");
		d.insert("4567", "Mario");
		d.insert("8901", "Giovanni");
		d.insert("2345", "Filippo");
		d.insert("6789", "Gianfranco");

		System.out.println(d.search("Antonio").toString());
		System.out.println(d.search("Mario").toString());

		d.delete("Mario");
		d.delete("Giovanni");
		d.delete("Filippo");
		d.delete("Gianfranco");

		d.insert("4567", "Mario");
		d.insert("8901", "Giovanni");
	}

}

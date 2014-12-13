package lab.Dizionario.HashTable;

import lab.Dizionario.Dizionario;
import lab.Dizionario.StrutturaCollegata;

/*
 * Dizionario basato su un array di Liste collegate
 * e una funzione Hash per l'individuazione della posizione
 *
 */
public class TabellaHashListeCollisione implements Dizionario {

	StrutturaCollegata[] s;
	Hash hFun;
	
	TabellaHashListeCollisione (Hash h, int dimStrutt) {
		s = new StrutturaCollegata[dimStrutt];	
	    hFun = h;
	}
	
	/**
	 * Se la pos individuata è "null" si crea una nuova StrutturaCollegata
	 * altrimenti se già presente si procede all'inserimento della coppia.
	 */
	public void insert(Object e, Comparable k) {
		int pos = hFun.h(k, s.length);
		if (s[pos]==null)
			s[pos]=new StrutturaCollegata();
		s[pos].insert(e, k);
	

	}

	
	/*
	 * Se la posizione individuata è null (non c'è una struttura collegata) allora l'elemento cercato non esiste
	 * altrimente si procede all'eleminazione dell'elemento nella struttura individuata
	 */
	public void delete(Comparable k) {
		int pos = hFun.h(k, s.length);
		if (s[pos]==null)
			return;
		s[pos].delete(k);
	
	}


	/*
	 * Se la posizione individuata è null (non c'è una struttura collegata) allora l'elemento cercato non esiste
	 * altrimente si procede alla restituzione dell'elemento abbinato alla chiave nella struttura individuata
	 */
	public Object search(Comparable k) {
		int pos = hFun.h(k, s.length);
		if (s[pos]==null)
			return null;
		return s[pos].search(k);
	}
	
	
	public static void main (String[] args) {
		Hash hFun = new HashDivisione();
		int tableDim = 10;
		Dizionario d = new TabellaHashListeCollisione (hFun,tableDim);
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

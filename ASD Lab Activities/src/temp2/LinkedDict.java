package temp2;

import java.util.Iterator;

public class LinkedDict<V> implements Dictionary<V> {

	private Coppia inizio = null;
	int numElem = 0;

	private class Coppia {

		public V elem;
		public Comparable chiave;
		public Coppia next;
		public Coppia prev;

		public Coppia(Comparable k, V e) {

			this.elem = e;
			this.chiave = k;
			next = prev = null;

		}
	}

	@Override
	public Iterator<Comparable> iterator() {

		return new Iterator<Comparable>() {

			Coppia p = inizio;
			int nScan = 0;

			@Override
			public boolean hasNext() {

				return nScan < numElem;
			}

			@Override
			public Comparable next() {
				Coppia p1 = p;
				p = p.next;
				nScan++;
				return p1.chiave;
			}

			@Override
			public void remove() {
				// TODO Auto-generated method stub

			}

		};
	}

	@Override
	public void insert(Comparable key, V value) {

		if (search(key) != null)
			throw new EccezioneElementoGiàPresente("Record già presente.");
		Coppia r = new Coppia(key, value);
		if (numElem == 0)
			inizio = r;
		else {
			r.next = inizio;
			inizio.prev = r;
			inizio = r;
		}

		numElem++;
	}

	@Override
	public void delete(Comparable key) {
		if (numElem == 0)
			throw new EccezioneStrutturaVuota("Struttura vuota.");
		if (search(key) == null)
			throw new EccezioneArticoloNonPresente("Record non trovato");
		if (inizio.chiave.equals(key) && numElem == 1)
			inizio = null;
		else {
			if (inizio.chiave.equals(key)) {
				inizio.next.prev = null;
				inizio = inizio.next;
			} else {
				for (Coppia p = inizio.next;; p = p.next) {
					if (p.chiave.equals(key)) {
						if (p.next != null) {
							p.next.prev = p.prev;
							p.prev.next = p.next;
							break;
						} else {
							p.prev.next = null;
						}
					}

				}
			}

		}
		numElem--;
	}

	@Override
	public V search(Comparable key) {

		/*
		 * if(inizio == null){ return null; }else{ for(Coppia p = inizio;;p =
		 * p.next){
		 * 
		 * if(p.chiave.equals(key)){ return p.elem; }
		 * 
		 * } }
		 */

		Coppia tmp = inizio;
		while (tmp != null) {
			if (tmp.chiave.equals(key))
				return tmp.elem;
			tmp = tmp.next;
		}

		return null;

	}

}

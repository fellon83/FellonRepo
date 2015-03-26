package esami.Lab20131121;

import java.util.Iterator;

public class LinkedDict<V> implements Dictionary<V> {
	private Record inizio = null;
	private int nElem = 0;

	private class Record {
		V item;
		Comparable key;
		Record next;
		Record prev;

		Record(Comparable key, V item) {
			this.item = item;
			this.key = key;
		}

	}

	public void insert(Comparable key, V value) {
		if (search(key) != null)
			throw new RecordAlreadyPresentException("Record già presente.");
		Record r = new Record(key, value);
		if (nElem == 0)
			inizio = r;
		else {
			r.next = inizio;
			inizio.prev = r;
			inizio = r;
		}
		nElem++;

	}

	public void delete(Comparable key) {
		if (nElem == 0)
			throw new EmptyStructureException("Struttura vuota.");
		if (search(key) == null)
			throw new RecordNotPresentException("Record non trovato");
		if (inizio.key.equals(key) && nElem == 1)
			inizio = null;
		else {
			if (inizio.key.equals(key)) {
				inizio.next.prev = null;
				inizio = inizio.next;
			} else {
				Record tmp = inizio.next;
				while (tmp != null) {
					if (tmp.next == null) {
						tmp.prev.next = null;
					} else {
						if (tmp.key.equals(key)) {
							tmp.next.prev = tmp.prev;
							tmp.prev.next = tmp.next;

						}
					}
					tmp = tmp.next;
				}
			}
		}

		nElem--;
	}

	public V search(Comparable key) {
		Record tmp = inizio;
		while (tmp != null) {
			if (tmp.key.equals(key))
				return tmp.item;
			tmp = tmp.next;
		}

		return null;
	}

	public Iterator<Comparable> iterator() {
		return new Iterator<Comparable>() {
			Record tmp = inizio;

			public boolean hasNext() {

				return tmp!=null;
			}

			public Comparable next() {
				Comparable result = tmp.key;
				tmp = tmp.next;
				return result;
			}

		};
	}
}

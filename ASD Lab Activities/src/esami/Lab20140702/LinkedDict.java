package esami.Lab20140702;

import java.util.Iterator;

public class LinkedDict<K, V> implements Dictionary<K, V> {
	private int nElem = 0;
	private Record inizio;

	private class Record {
		K key;
		V value;
		Record next;
		Record prev;

		Record(K key, V value) {
			this.key = key;
			this.value = value;
			next = prev = null;
		}
	}

	public void insert(K key, V value) {
		if (search(key) != null)
			throw new ItemAlreadyPresentException("Elemento presente.");
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

	public void delete(K key) {
		if (nElem == 0)
			throw new EmptyStructureException("Struttura vuota");
		if (inizio.key.equals(key) && nElem == 1) {
			inizio = null;
		} else {
			if (inizio.key.equals(key)) {
				inizio.next.prev = null;
				inizio.next = inizio;
			} else {
				for (Record tmp = inizio.next;; tmp = tmp.next) {
					if (tmp.key.equals(key)) {
						if (tmp.next != null) {
							tmp.next.prev = tmp.prev;
							tmp.prev = tmp.next;
						} else {
							tmp.prev.next = null;
							tmp.prev = null;
						}
						break;
					}
				}
			}
		}
		nElem--;
	}

	public V search(K key) {
		Record tmp = inizio;
		while (tmp != null) {
			if (tmp.key.equals(key))
				return tmp.value;
			tmp = tmp.next;
		}

		return null;
	}

	public String toString() {
		String s = "";
		Record tmp = inizio;
		while (tmp != null) {
			s += tmp.value + ", ";
			tmp = tmp.next;
		}
		return s;
	}

	public Iterator<K> iterator() {
		return new Iterator<K>() {
			int nScan = 0;
			Record tmp = inizio;

			public boolean hasNext() {

				return nScan < nElem;
			}

			public K next() {
				K result = tmp.key;
				tmp = tmp.next;
				nScan++;
				return result;
			}
		};
	}
}

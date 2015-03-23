package esami.Lab20141120;

import java.util.Iterator;

public class ArrayDict<K, V> implements Dictionary<K, V> {

	private Pair[] dict = new Pair[1];
	private int nElementi = 0;

	private class Pair<A, B> {
		A key;
		B elem;

		Pair(A key, B elem) {
			this.key = key;
			this.elem = elem;
		}
	}

	public void insert(K key, V value) {
		if (key == null)
			throw new IllegalKeyException("Chiave non valida!");
		Pair<K, V> p = new Pair<K, V>(key, value);
		dict[nElementi] = p;
		nElementi++;
		if (dict.length == nElementi) {
			Pair[] temp = new Pair[dict.length * 2];
			for (int i = 0; i < nElementi; i++) {
				temp[i] = dict[i];
			}
			dict = temp;
		}

	}

	public void delete(K key) {
		if (nElementi == 0)
			throw new VoidStructureException("Struttura vuota");
		if ((key == null) || (search(key) == null))
			throw new IllegalKeyException("Chiave non valida!");
		int i, j;
		for (i = 0; i < nElementi; i++) {
			if (dict[i].key.equals(key))
				break;
		}
		for (j = i + 1; j < nElementi - 1; j++) {
			dict[j - 1] = dict[j];
		}
		nElementi--;
		if (nElementi == dict.length / 4) {
			Pair[] temp = new Pair[dict.length / 2];
			for (int k = 0; k < nElementi; k++) {
				temp[k] = dict[k];
			}
			dict = temp;
		}
	}

	public V search(K key) {
		if (nElementi != 0) {
			if (key == null)
				throw new IllegalKeyException("Chiave non valida!");
			for (int i = 0; i < nElementi; i++) {
				if (dict[i].key.equals(key))
					return (V) dict[i].elem;
			}
		}
		return null;
	}

	public Iterator<K> iterator() {

		return new Iterator<K>() {
			int nScan = 0;

			public boolean hasNext() {
				return nScan < nElementi;
			}

			public K next() {
				return (K) dict[nScan++].key;
			}
		};
	}
}

package esami.Lab20140415;

import java.util.Iterator;

import varie.Studente.Studente;

public class SortedArray<S> implements Dictionary<S> {

	private Record[] dict = new Record[0];

	private class Record<S> {
		S elem;
		Comparable key;

		Record(S e, Comparable k) {
			this.elem = e;
			this.key = k;
		}

	}

	public void insert(S e, Comparable k) {
		if (search(k) != null)
			throw new EccezioneElementoEsistente("Elemento già presente,");
		if (search(k) == null) {
			int i, j;
			Record[] temp = new Record[dict.length + 1];
			for (i = 0; i < dict.length; i++) {
				temp[i] = dict[i];
			}
			dict = temp;
			for (i = 0; i < dict.length - 1; i++) {
				if (dict[i].key.compareTo(k) >= 0) {
					break;
				}
			}
			for (j = dict.length - 1; j > i; j--) {
				dict[j] = dict[j - 1];
			}
			dict[i] = new Record<S>(e, k);
		}

	}

	public S search(Comparable k) {
		int i = 0;
		int j = dict.length;
		int m;
		while (i < j) {
			m = (i + j) / 2;
			if (dict[m].key.equals(k))
				return (S) dict[m].elem;
			if (dict[m].key.compareTo(k) < 0)
				j = m;
			else
				i = m + 1;
		}
		return null;
	}

	@Override
	public void delete(Comparable k) {
		if (search(k) != null) {
			int i, j;
			Record[] temp = new Record[dict.length - 1];
			for (i = 0; i < dict.length - 1; i++) {
				if (!dict[i].key.equals(k))
					temp[i] = dict[i];
				else
					break;
			}
			for (j = i; j < dict.length - 1; j++)
				temp[j] = dict[j + 1];
			dict = temp;
		}
	}

	@Override
	public Iterator<Comparable> iterator() {
		return new Iterator<Comparable>() {
			int n = 0;

			@Override
			public boolean hasNext() {
				return n < dict.length;
			}

			@Override
			public Comparable next() {
				return dict[n++].key;
			}

			@Override
			public void remove() throws UnsupportedOperationException {
				throw new UnsupportedOperationException();

			}

		};
	}
}

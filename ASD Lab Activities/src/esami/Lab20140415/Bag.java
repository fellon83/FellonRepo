package esami.Lab20140415;

import java.util.ArrayList;
import java.util.Iterator;

public class Bag implements Iterable<String> {
	protected Dictionary<Integer> freqParole = new SortedArray<Integer>();
	private ArrayList<Comparable> words = new ArrayList<Comparable>();

	public void addItem(Comparable k) {
		int n = occurrences(k);
		if (n != 0) {
			freqParole.delete(k);
			freqParole.insert(n++, k);
		} else {
			freqParole.insert(1, k);
		}
		words.add(k);
	}

	public void delItem(Comparable k) {
		int n = occurrences(k);
		if (isEmpty())
			throw new EccezioneStrutturaVuota("Struttura vuota");
		if (n == 0)
			return;
		else {
			if (n > 1) {
				freqParole.delete(k);
				freqParole.insert(n - 1, k);
			} else {
				freqParole.delete(k);
				words.remove(k);
			}
		}
		
	}

	public Integer occurrences(Comparable k) {
		Integer n = freqParole.search(k);
		if (n == null)
			return 0;
		else
			return n;

	}

	public boolean isEmpty() {
		return words.isEmpty();
	}

	public Iterator<String> iterator() {
		return new Iterator<String>() {

			int n = 0;
			@Override
			public boolean hasNext() {

				return (n<words.size());
			}

			@Override
			public String next() {

				return (String) words.get(n++);
			}

			@Override
			public void remove() throws UnsupportedOperationException {
				throw new UnsupportedOperationException();

			}

		};
	}

}

package esami.Lab20150224;

import java.util.Iterator;

public class WOListLinked implements ListaOrdinata {
	private int numElementi = 0;
	Record inizio = null;

	public void insert(Comparable e) {
		if (numElementi == 0)
			inizio = (Record) e;
		else {
			if (inizio.next == null || e.compareTo(inizio) > 0) {
				Record tmp = (Record) e;
				if (e.compareTo(inizio) > 0) {
					tmp.next = inizio;
					inizio = tmp;
				} else {
					inizio.next = tmp;
				}
			} else {
				Record tmp = inizio;
				while (tmp != null) {
					Record next = tmp.next;
					if (next != null) {
						if (e.compareTo(tmp) < 0 && e.compareTo(next) >= 0) {
							tmp.next = (Record) e;
							tmp.next.next = next;
							break;
						}
					} else {
						tmp.next = (Record) e;
						break;
					}
					tmp = tmp.next;
				}
			}
		}
		numElementi++;
	}

	public int numElementi() {
		return numElementi;
	}

	@Override
	public Iterator iterator() {
		return new Iterator<Record>() {
			Record tmp = inizio;

			@Override
			public boolean hasNext() {

				return tmp != null;
			}

			@Override
			public Record next() {
				Record rec = tmp;
				tmp = tmp.next;
				return rec;
			}
		};
	}
}

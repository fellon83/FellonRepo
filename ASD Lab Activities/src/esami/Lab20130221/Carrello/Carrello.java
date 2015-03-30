package esami.Lab20130221.Carrello;

import java.util.Iterator;

public class Carrello<S> implements AddOnlyList<S> {

	private Record dummy = new Record(null);
	private Record fine = null;
	Record punt = dummy.next;
	private int nElem = 0;
	boolean FORWARD = true;

	private class Record {
		S elem;
		Record next;
		Record prev;

		public Record(S elem) {
			this.elem = elem;
			next = prev = null;
		}
	}

	public void add(S e) {
		Record r = new Record(e);
		if (nElem == 0) {
			dummy.next = fine = r;
		} else {
			fine.next = r;
			r.prev = fine;
			fine = r;
		}
		fine.next = dummy;
		dummy.prev = fine;
		nElem++;
	}

	@Override
	public void forward() {
		FORWARD = true;
	}

	@Override
	public void backward() {
		FORWARD = false;

	}

	@Override
	public Iterator<S> iterator() {
		return new Iterator<S>() {
			Record tmp = dummy;
			int nScan;

			public boolean hasNext() {

				return nScan < nElem;
			}

			public S next() {
				S value = null;
				if (FORWARD) {
					value = (S) tmp.next.elem;
					tmp = tmp.next;
				} else {
					value = (S) tmp.prev.elem;
					tmp = tmp.prev;
				}
				nScan++;
				return value;
			}
		};
	}
}

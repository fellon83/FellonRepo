package esami.Lab20140904;

import java.util.Iterator;

public class IndexedLL<T> implements IndexedList<T> {
	private int nElem;
	private Record inizio, fine;

	private class Record {
		T elem;
		int pos;
		Record next;
		Record prev;

		Record(T e, int i) {
			this.elem = e;
			this.pos = i;
			next = prev = null;
		}
	}

	public IndexedLL() {
		inizio = fine = null;
	}

	public boolean isEmpty(int i) {
		if (inizio == null)
			return true;
		Record tmp = inizio;
		for (int cont = 0; cont < nElem; cont++) {
			if (tmp.pos == i)
				return false;
			tmp = tmp.next;
		}
		return true;
	}

	public void addItem(T e, int i) {
		if (!isEmpty(i))
			throw new ItemAlreadyPresent("Posizione non vuota.");
		Record r = new Record(e, i);
		if (inizio == null) {
			inizio = fine = r;
		} else {
			if (i < inizio.pos) {
				r.next = inizio;
				inizio.prev = r;
				inizio = r;
			} else {
				Record tmp = inizio.next;
				boolean ins = false;
				if (tmp != null) {
					while (tmp != null) {
						if (i < tmp.pos) {
							tmp.prev.next = r;
							r.prev = tmp.prev;
							r.next = tmp;
							tmp.prev = r;
							ins = true;
							break;
						}
						tmp = tmp.next;
					}
				}
				if (!ins) {
					fine.next = r;
					r.prev = fine;
					fine = r;
				}

			}
		}
		nElem++;
	}

	public void delItem(int i) {
		if (nElem == 0)
			throw new EmptyStructureException("Struttura vuota.");
		if (isEmpty(i))
			throw new ItemNotPresent("Posizione vuota");
		if (inizio.pos == i && nElem == 1) {
			inizio = fine = null;
		} else {
			if (inizio.pos == i) {
				inizio.next.prev = null;
				inizio = inizio.next;
			} else {
				Record tmp = inizio.next;
				while (tmp != null) {
					if (tmp.pos == i) {
						tmp.prev.next = tmp.next;
						tmp.next.prev = tmp.prev;
						break;
					}
					tmp = tmp.next;
				}
			}
		
		}
		nElem--;
	}

	public T getItem(int i) {
		if (nElem == 0)
			throw new EmptyStructureException("Struttura vuota.");
		if (isEmpty(i))
			throw new ItemNotPresent("Posizione vuota");
		Record tmp = inizio;
		while (tmp != null) {
			if (tmp.pos == i)
				return tmp.elem;
			tmp = tmp.next;
		}
		return null;
	}

	public int numberItems() {
		return nElem;
	}

	public Iterator<T> iterator() {

		return new Iterator<T>() {
			private int nScan = 0;
			Record tmp = inizio;

			public boolean hasNext() {

				return nScan < nElem;
			}

			public T next() {
				T result = tmp.elem;
				tmp = tmp.next;
				nScan++;
				return result;
			}
		};
	}

	public static void main(String[] args) {
		IndexedLL<String> t = new IndexedLL<String>();
		try {
			t.addItem("a", 0);
			t.addItem("c", 3);
			t.addItem("B", 2);
			t.addItem("tra A e B", 1);
			t.addItem("Eccezione", 3);
		} catch (ItemAlreadyPresent e) {
			System.err.println(e.getMessage());
		}
		try {
			t.delItem(2);
			t.delItem(0);
			t.delItem(1);
			t.delItem(3);
			t.delItem(3);
		} catch (ItemNotPresent e) {
			System.err.println(e.getMessage());
		} catch (EmptyStructureException e) {
			System.err.println(e.getMessage());
		}
	}
}

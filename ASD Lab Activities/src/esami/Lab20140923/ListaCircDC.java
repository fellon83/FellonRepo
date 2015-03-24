package esami.Lab20140923;

import java.util.Iterator;

public class ListaCircDC<T> implements CircList<T> {

	private Item inizio;
	private Item fine;
	private int nElem;

	private class Item {
		T elem;
		Item next;
		Item prev;

		Item(T elem) {
			this.elem = elem;
			next = prev = null;
		}
	}

	public ListaCircDC() {
		inizio = fine = null;
		nElem=0;
	}

	public void addCircList(T item) {
		Item r = new Item(item);
		if (isEmpty()) {
			inizio = fine = r;
		} else {
			if (inizio == fine) {
				inizio.next = r;
				r.prev = inizio;
				fine = r;
			} else {
				fine.next = r;
				r.prev = fine;
				fine = r;
			}
		}
		fine.next=inizio;
		inizio.prev=fine;
		nElem++;
	}

	public void delCircList() {
		if (isEmpty())
			throw new EmptyStructureException("Struttura vuota.");
		if (nElem == 1) {
			inizio = fine = null;
		} else {
			inizio.next.prev = fine;
			fine.next=inizio.next;
			inizio=inizio.next;
		}
		nElem--;
	}

	public T value() {
		if (isEmpty())
			throw new EmptyStructureException("Struttura vuota");
		return inizio.elem;
	}

	public boolean isEmpty() {			
		return nElem==0;
	}

	public void ruotaAvanti() {
		if (isEmpty())
			throw new EmptyStructureException("Struttura vuota");
		inizio = inizio.next;
		fine = fine.next;

	}

	public void ruotaIndietro() {
		if (isEmpty())
			throw new EmptyStructureException("Struttura vuota");
		inizio = inizio.prev;
		fine = fine.prev;
	}

	public int numItem() {
		return nElem;
	}

	public Iterator<T> iterator() {
		return new Iterator<T>() {
			private int nScan;
			private Item tmp = inizio;
			
			public boolean hasNext() {
				return nScan<numItem();
			}

			public T next() {
				Item result = tmp;
				tmp = tmp.next;
				nScan++;
				return result.elem;
			}
		};
	}

	public static void main(String[] args) {
		ListaCircDC<String> test = new ListaCircDC<String>();
		test.addCircList("nord");
		test.addCircList("nord-est");
		test.addCircList("est");
		test.addCircList("sud-est");
		test.addCircList("sud");
		test.addCircList("sud-ovest");
		test.addCircList("ovest");
		test.addCircList("nord-ovest");
		System.out.println("---Lista Completa---");
		for (String e: test) {
			System.out.println(e);
		}
		System.out.println("\n---Rotazione in avanti di 2 elementi");
		test.ruotaAvanti();
		test.ruotaAvanti();
		System.out.println("Il primo elemento è: " + test.value());
		System.out.println("\n---Rimozione primo elemnto---");
		test.delCircList();
		System.out.println("Il primo elemento è: " + test.value());
		System.out.println("\n---Nuova Lista Completa---");
		for (String e: test) {
			System.out.println(e);
		}
	}
}

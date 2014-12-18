package esami.Lab20140220;

import java.util.Iterator;

public class PQA<Item> implements PQ<Item> {
	protected Record coda;
	private int numElem = 0;

	private class Record {
		public Item elem;
		public int priority;
		public Record next = null;

		Record(Item e, int p) {
			this.elem = e;
			this.priority = p;
		}
	}

	@Override
	public void insert(Item i, int p) {
		if (isNew()) {
			coda = new Record(i, p);

		} else {
			if (coda.next == null || p < coda.priority) {
				Record temp = new Record(i, p);
				if (p < coda.priority) {
					temp.next = coda;
					coda = temp;
				} else {
					coda.next = temp;
				}
			} else {
				Record temp = coda;
				while (temp != null) {
					Record next = temp.next;
					if (next != null) {
						if (p >= temp.priority && p < next.priority) {
							temp.next = new Record(i, p);
							temp.next.next = next;
							break;
						}

					} else {
						temp.next = new Record(i, p);
						break;
					}
					temp = temp.next;
				}

			}
		}

		numElem++;
	}

	@Override
	public boolean isNew() {
		return numElem == 0;

	}

	@Override
	public Item first() {
		if (isNew())
			throw new EccezioneStrutturaVuota("Struttura vuota");
		return coda.elem;
	}

	@Override
	public void delFirst() {
		if (isNew())
			throw new EccezioneStrutturaVuota("Struttura vuota");
		if (numElem == 1)
			coda = null;
		else
			coda = coda.next;
		numElem--;
	}

	@Override
	public void changePriority(Item i, int p) {
		if (isNew())
			throw new EccezioneStrutturaVuota("Struttura vuota");
		if (coda.elem.equals(i)) {
			if (coda.priority == p) {
				return;
			} else {
				coda = coda.next;
				insert(i, p);
				numElem--; //compensa l'aumento di elementi per via dell'insert, ma in realtà facciamo solo un update
				return;
			}
		} else {
			Record temp = coda;
			while (temp != null) {
				Record next = temp.next;
				if (next == null) {
					throw new EccezioneElementoMancante(
							"Nessun elemento trovato");
				}
				if (next.elem.equals(i)) {
					if (p == next.priority)
						return;
					temp.next = next.next;
					insert(i, p);
					numElem--; //compensa l'aumento di elementi per via dell'insert, ma in realtà facciamo solo un update
					return;
				}
				temp = next;
			}
			throw new EccezioneElementoMancante("Nessun elemento trovato");
		}

	}

	@Override
	public int getPriority(Item i) {
		if (isNew())
			throw new EccezioneStrutturaVuota("Struttura vuota");
		Record temp = coda;
		while (temp != null) {
			if (temp.elem.equals(i))
				return temp.priority;
			temp = temp.next;
		}
		throw new EccezioneElementoMancante("Nessun elemento trovato.");
	}

	@Override
	public int size() {
		return numElem;
	}

	@Override
	public Iterator<Item> iterator() {
		return new Iterator<Item>() {
			Record temp = coda;

			@Override
			public boolean hasNext() {
				return temp != null;
			}

			@Override
			public Item next() {
				Item e = temp.elem;
				temp = temp.next;
				return e;
			}

			@Override
			public void remove() {
				throw new UnsupportedOperationException();
			}
		};
	}

	public static void main(String[] args) {
		PQ<String> coda = new PQA<String>();
		coda.insert("a", 20);
		coda.insert("b", 50);
		coda.insert("Tra a e b", 30);
		coda.insert("Prima di a", 10);
		coda.insert("Ultima posizione", 50);

		System.out.println("Stampo la coda");
		for (String temp : coda) {
			System.out.println("Elemento: " + temp.toString() + " - Priorità: "
					+ coda.getPriority(temp));
		}

		coda.changePriority("a", 80);
		System.out.println("\nLa dimensione della coda è: " + coda.size());
		System.out.println("\nRistampo la lista con a portato in ultima posizione.");
		Iterator<String> it = coda.iterator();
		while (it.hasNext()) {
			String next = it.next();
			System.out.println("Elemento: " + next + " - Priorità: "
					+ coda.getPriority(next));
		}
		
		System.out.println("\nCancello il primo elemento");
		coda.delFirst();
		System.out.println("\nIl primo elemento in coda è: " + coda.first());
		System.out.println("\nLa dimensione della coda è: " + coda.size());
		
		
	}

}

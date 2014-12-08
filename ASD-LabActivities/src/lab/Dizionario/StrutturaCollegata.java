package lab.Dizionario;

public class StrutturaCollegata implements Dizionario {

	private Record list;

	private final class Record {
		public Object elem;
		public Comparable key;
		public Record prev;
		public Record next;

		Record(Object e, Comparable k) {
			this.elem = e;
			this.key = k;
			next = prev = null;
		}

	}

	/*
	 * Se la lista è vuota, il record inserito diventa list (il record di testa)
	 * altrimenti il nuovo record viene inserito in posizione successiva a
	 * quello di testa
	 */
	public void insert(Object e, Comparable k) {
		Record p = new Record(e, k);
		if (list == null) {
			list = p.next = p.prev = p;
		} else {
			p.next = list.next;
			p.prev = list;
			list.next.prev = p;
			list.next = p;
		}

	}

	/* 
	 * Se la lista è vuota o se l'elemento non è nella struttura la cancellazione non viene eseguita
	 * 
	 * Se l'elemento da cancellare è il primo della lista, la struttura si annulla
	 * 
	 * Altrimenti si scorre la struttura fino all'elemento desiderato e si aggiornano i puntatori
	 */
	public void delete(Comparable k) {
		if ((list != null) && (search(k) != null)) {
			if (list.key.equals(k))
				list = null;
			else {
				for (Record p = list.next;; p = p.next) {
					if (p.key.equals(k)) {
						p.prev.next = p.next;
						p.next.prev = p.prev;
						break;
					}
				}
			}
		}

	}

	public Object search(Comparable k) {
		if (list == null) {
			return null;
		} else {
			for (Record p = list;; p = p.next) {
				if (p.key.equals(k))
					return p.elem;
				if (p == list.prev)
					return null;

			}
		}
	}

	public static void main(String args[]) {
		StrutturaCollegata d = new StrutturaCollegata();
		d.insert("1234", "Antonio");
		d.insert("4567", "Mario");
		d.insert("8901", "Giovanni");
		d.insert("2345", "Filippo");
		d.insert("6789", "Gianfranco");

		System.out.println(d.search("Antonio").toString());
		System.out.println(d.search("Mario").toString());

		d.delete("Mario");
		d.delete("Giovanni");
		d.delete("Filippo");
		d.delete("Gianfranco");

		d.insert("4567", "Mario");
		d.insert("8901", "Giovanni");
	}

}

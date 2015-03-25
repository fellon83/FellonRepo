package esami.Lab20140904;

public class Skype implements Comparable {
	private IndexedList<Pacchetto> comunicazione = new IndexedLL<Pacchetto>();

	public void addPacchetto(Pacchetto p) {
		try {
			comunicazione.addItem(p, p.identificativo);
		} catch (ItemAlreadyPresent e) {
			System.err.println(e.getMessage());
		}
	}

	public boolean complete() {
		for (Object e : comunicazione) {
			Pacchetto p = (Pacchetto) e;
			if (p.ultimo)
				return true;
		}
		return false;
	}

	public String toString() {
		String str = "";
		for (Object e : comunicazione) {
			Pacchetto p = (Pacchetto) e;
			str += p.dati + " ";
		}
		return str;
	}

	public int compareTo(Object o) {
		Skype c = (Skype) o;
		if (!(this.complete() && c.complete()))
			throw new IllegalOperationException("Pacchetti non completi.");

		return (this.toString().compareTo(c.toString()));

	}

}

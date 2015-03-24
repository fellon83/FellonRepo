package esami.Lab20140923;

public class Record {
	private Cardinale direzione;
	private int istante;

	Record(Cardinale dir, int ist) {
		this.direzione = dir;
		this.istante = ist;
	}

	public Cardinale getDirezione() {
		return direzione;
	}

	public int getIstante() {
		return istante;
	}

}

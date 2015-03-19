package esami.Lab20150224;

public class Record<T> implements Comparable<T> {

	private T progetto;
	private float punteggio;
	Record next;

	private final float punteggioMin = 0;
	private final float punteggioMax = 15;

	public Record(T r, float p) {
		this.progetto = r;
		if (p < punteggioMin || p > punteggioMax)
			throw new PunteggioNonValidoException("Punteggio non valido!");
		this.punteggio = p;
		next = null;

	}

	public float getPunteggio() {
		return punteggio;
	}
	
	public T getProgetto() {
		return progetto;
	}
	
	public int compareTo(T r) {
		Record rec = (Record) r;
		if (this.punteggio < rec.punteggio)
			return -1;
		else if (this.punteggio > rec.punteggio)
			return 1;
		else
			return 0;
	}

}

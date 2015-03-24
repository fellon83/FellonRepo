package esami.Lab20141120;

import java.util.Iterator;

import esami.Lab20141120.IllegalPositionException;
import esami.Lab20141120.IllegalVolumeException;

public abstract class BibliotecaAbs<K> implements Iterable<K> {

	protected Dictionary<String, Record<Volume>> volumi;
	int nElementi = 0;
	final boolean PRESTATO = true;
	final boolean DISPONIBILE = false;

	public boolean bibliotecaVuota() {
		return nElementi == 0;
	}

	public void addVol(String posizione, Volume volume) {
		if (volumi.search(posizione) != null)
			throw new IllegalPositionException("Posizione non valida!");
		if (volume == null)
			throw new IllegalVolumeException("Nessun volume.");
		Record<Volume> rec = new Record<Volume>(volume, DISPONIBILE);
		volumi.insert(posizione, rec);
		nElementi++;

	}

	public Volume volume(String posizione) {
		if (posizione == null)
			throw new IllegalPositionException("Posizione non valida!");
		Record<Volume> r = volumi.search(posizione);
		if (r == null)
			throw new IllegalVolumeException("Volume non esistente!");
		return r.vol;
	}

	public void prestito(String posizione) {
		if (posizione == null)
			throw new IllegalPositionException("Posizione non valida!");
		Record<Volume> r = volumi.search(posizione);
		if (r == null)
			throw new IllegalVolumeException("Volume non esistente!");
		r.flag = PRESTATO;
		nElementi--;
	}

	public void restituzione(String posizione) {
		if (posizione == null)
			throw new IllegalPositionException("Posizione non valida!");
		Record<Volume> r = volumi.search(posizione);
		if (r == null)
			throw new IllegalVolumeException("Volume non esistente!");
		r.flag = DISPONIBILE;
		nElementi++;
	}

	public boolean prestato(String posizione) {
		if (posizione == null)
			throw new IllegalPositionException("Posizione non valida!");
		Record<Volume> r = volumi.search(posizione);
		return r.flag;
	}

	public AddOnlyList<String> posizione(Volume volume) {
		AddOnlyList<String> posList = new DoubleLinkedList<String>();
		for (String s : volumi) {
			Record<Volume> r = volumi.search(s);
			if (!(r.flag) && (r.vol.compareVolume(volume))) {
				posList.add(s);
			}
		}
		return posList;
	}

	public Iterator<K> iterator() {
		return (Iterator<K>) this.volumi.iterator();
	}
}

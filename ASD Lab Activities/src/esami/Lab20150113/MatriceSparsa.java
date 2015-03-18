package esami.Lab20150113;

import java.util.ArrayList;
import java.util.Iterator;

public class MatriceSparsa<T> implements Iterable<T> {

	private int colonne;
	private int righe;
	private T valoreDefault;

	protected ArrayList<Record<T>>[] valori;

	class Record<E> {
		int colonna;
		E valore;

		Record(int c, E val) {
			colonna = c;
			valore = val;
		}

	}

	MatriceSparsa(int col, int rig, T valDef) {
		colonne = col;
		righe = rig;
		valoreDefault = valDef;

		valori = new ArrayList[colonne];

		for (int i = 0; i < colonne; i++) {
			valori[i] = new ArrayList<>();
			for (int j = 0; j < righe; j++) {
				Record def = new Record<T>(i, valoreDefault);
				valori[i].add(def);
			}
		}

	}

	void cambiaValore(int rig, int col, T val) {
		if ( (valori[col].get(rig).valore).equals(val))
			throw new valoreNonCorrettoException("Valore inserito uguale a quello presente");
		else {
		Record r = new Record<T>(col, val);
		valori[col].set(rig, r);
		}

	}

	T valore(int rig, int col) {

		return (T) (valori[col].get(rig)).valore;
	}

	int numRighe() {
		return righe;
	}

	int numColonne() {
		return colonne;
	}

	int numValoriSignificativi() {
		int valSign = 0;

		for (int i = 0; i < colonne; i++) {
			for (int j = 0; j < righe; j++) {
				if (!((valori[i].get(j).valore).equals(valoreDefault)))
					valSign++;
			}
		}
		return valSign;
	}

	public Iterator<T> iterator() {
		return new Iterator<T>() {
			int scanC = 0;
			int scanR = 0;
			T tmp;

			@Override
			public boolean hasNext() {
				if (scanR < righe) {
					tmp = (T) valori[scanC].get(scanR).valore;
					if (scanC == colonne - 1) {
						scanR++;
						scanC = 0;
					} else
						scanC++;

					return true;
				} else
					return false;
			}

			@Override
			public T next() {

				return tmp;
			}

		};
	}
}

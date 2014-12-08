package lab.HashTable;

import lab.Dizionario.Dizionario;

public class TabellaHash implements Dizionario {

	Object S[];
	Hash fHash;

	public TabellaHash(Hash f, int n) {
		S = new Object[n];
		fHash = f;
	}

	@Override
	public void insert(Object e, Comparable k) {
		S[fHash.h(k,S.length)]=e;

	}

	@Override
	public void delete(Comparable k) {
		S[fHash.h(k,S.length)]=null;

	}

	@Override
	public Object search(Comparable k) {
		return S[fHash.h(k,S.length)];
	}

}

package esami.Lab20150203;

import java.util.Iterator;
import java.util.LinkedList;

public class HashDict<S> implements Dictionary<S> {

	class Record<S> {
		S item;
		Comparable key;

		Record(S item, Comparable k) {
			this.item = item;
			this.key = k;

		}
	}

	private LinkedList<Record<S>>[] s;
	private int numListe = 0;

	HashDict(int n) {
		s = new LinkedList[n];
		
		for (int i=0; i<n; i++) {
			s[i] = new LinkedList<Record<S>>();
		}
	}

	private int h(Comparable k) {
		return Math.abs(k.hashCode()) % s.length;
	}

	@Override
	public void insert(S e, Comparable k) {
		int pos = h(k);
		for (Object obj : s[pos]) {
			Record<S> r = (Record<S>) obj;
			if (r.key.equals(k))
				throw new EccezioneKiaveEsistente("Chiave esistente");
		}
		s[pos].add(new Record<S>(e, k));
	}

	@Override
	public void delete(Comparable k) {
		boolean found = false;
		int i;
		int pos = h(k);
		for (i=0; i<s[pos].size(); i++) {
			Record<S> r = s[pos].get(i);
			found = (r.key.equals(k));
			if (found)
				break;
		} 
		if (!found)
			throw new EccezioneChiaveNonValida("Chiave non esistente!");		
		s[pos].remove(i);

	}

	public S search(Comparable k) {
		int pos = h(k);
		S item = null;
		if (s[pos] != null) {
			for (Object t : s[pos]) {
				Record<S> r = (Record<S>) t;
				if (r.key.equals(k))
					item = r.item;
			}
		}
		if (item == null)
			throw new EccezioneChiaveNonValida("Chiave non valida!");
		else
			return item;
	}

	@Override
	public Iterator<Comparable> iterator() {
		return new Iterator<Comparable>() {
			int i = 0;
			Record<S> r;
			Iterator<Record<S>> it = null;
			
			@Override
			public boolean hasNext() {
				if(it == null)
					it = s[0].iterator();
				
				while(!it.hasNext()){
					if(++i < s.length)
						it = s[i].iterator();
					else
						return false;
				}
				
				r = it.next();
				return true;
			}

			@Override
			public Comparable next() {
				return r.key;
			}};

	}
}

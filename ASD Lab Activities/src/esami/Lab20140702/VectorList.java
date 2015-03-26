package esami.Lab20140702;

import java.util.Iterator;

public class VectorList<S> implements AddOnlyList<S> {

	private Object[] vl = new  Object[1];
	private int nElem = 0;
	
	
	public void add(S e) {
		vl[nElem] = e;
		nElem++;
		if (nElem==vl.length) {
			Object[] tmp = new Object[vl.length*2];
			for (int i=0; i<nElem; i++) {
				tmp[i] = vl[i];
			}
			vl = tmp;
		}
	}

	public String toString() {
		String s = "";
		for (int i=0; i<nElem; i++) {
			s += vl[i].toString() + "   ";
		}
		return s;
	}
	
	
	public Iterator<S> iterator() {
	
		return new Iterator<S>() {
			int i=0;
	
			public boolean hasNext() {
	
				return i<nElem;
			}

	
			public S next() {
	
				return (S) vl[++i];
			}
		};
	}
}

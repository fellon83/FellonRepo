package esami.Lab20130917;

import java.util.Iterator;

public class LinkedList<S> implements AddOnlyList<S> {
	private int nElem=0;
	private Record inizio=null;
	
	private class Record {
		S item;
		Record next;
		
		Record (S item) {
			this.item=item;
			next=null;
		}
	}


	public void add(S e) {
		Record r = new Record(e);
		if (nElem==0){
			inizio=r;
		} else {
			for (Record tmp=inizio;;tmp=tmp.next) {
				if (tmp.next==null) {
					tmp.next=r;
					break;
				}
			}
		}

		nElem++;
	}

	
	public Iterator<S> iterator() {
		
		return new Iterator<S>() {
			private int nScan=0;
			private Record tmp = inizio;
			
			public boolean hasNext() {

				return nScan<nElem;
			}


			public S next() {
				S item = tmp.item;
				tmp=tmp.next;
				nScan++;
				return item;
			}
		};
	}

}

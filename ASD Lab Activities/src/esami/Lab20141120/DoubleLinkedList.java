package esami.Lab20141120;

import java.util.Iterator;

public class DoubleLinkedList<S> implements AddOnlyList<S> {
	
	private Cell<S> inizio, fine;
	private int nElementi;
	
	private class Cell<S> {
		S elem;
		Cell<S> next;
		Cell<S> prev;
		
		Cell (S e) {
			this.elem = e;
			next=null;
			prev=null;
		}
	}
	

	public DoubleLinkedList() {
		inizio = fine = null;
		nElementi=0;
	}
	
	public void add(S e) {
		Cell<S> r = new Cell<S>(e);
		if (nElementi==0) {
			inizio = fine = r;
		} else {
			if (inizio==fine){
				fine = r;
				inizio.next=fine;
				fine.prev=inizio;
			} else {
				r.prev = fine;
				fine.next = r;
				fine = r;
				
			}
		}
		nElementi++;
	}
	
	
	public String toString () {
		String result = "";
		for (Object e: this) {
			result += e.toString() + " ";
		}
		return result;
	}
	
	
	public Iterator<S> iterator() {
		return new Iterator<S>() {
			Cell<S> copia = inizio;
			public boolean hasNext() {
				return copia!=null;
			}

			
			
			public S next() {
				Cell<S> tmp;
				tmp = copia;
				copia = copia.next;
				return tmp.elem;
			}
		};
	}
}

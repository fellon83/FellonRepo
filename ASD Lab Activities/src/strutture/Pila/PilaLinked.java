package strutture.Pila;

import java.util.Iterator;

import esami.Lab20140220.EccezioneStrutturaVuota;

public class PilaLinked<T> implements Pila<T> {
	private int nElem = 0;
	Record fine = null; 
	
	private class Record {
		T elem;
		Record next;
		Record prev;
		
		Record (T elem) {
			this.elem=elem;
			next = prev = null;
		}
	}
	
	
	public boolean isEmpty() {		
		return nElem==0;
	}

	
	public void push(T e) {
		Record r = new Record(e);
		if (nElem==0) {
			fine = r;
		} else {
			fine.next = r;
			r.prev = fine;
			fine = r;
		} 
		nElem++;

	}

	
	public T top() {
		if (isEmpty())
			throw new EccezioneStrutturaVuota("Struttura vuota");
		return fine.elem;
	}

	
	public void pop() {
		if (isEmpty())
			throw new EccezioneStrutturaVuota("Struttura vuota");
		fine = fine.prev;
		nElem--;
	}

	public Iterator iterator() {
		return new Iterator<T>() {
			private int nScan = 0;
			Record tmp = fine;
			
			public boolean hasNext() {
				return nScan<nElem;
			}

			@Override
			public T next() {
				T value = tmp.elem;
				tmp = tmp.prev;
				nScan++;
				return value;
			}
			
		};
	}
	
	public static void main (String[] args) {
		Pila<String> p = new PilaLinked<String>();
		
		System.out.println(p.isEmpty());
		p.push("Antonio");
		p.push("Mario");
		p.push("Giovanni");
		p.push("Filippo");
		p.push("Gianfranco");

		System.out.println(p.top().toString());
		p.pop();
		System.out.println(p.top().toString());

		System.out.println(p.isEmpty());
		
		p.pop();
		p.pop();
		p.pop();
		p.pop();
		
		System.out.println(p.isEmpty());
		
		//prova di gestione dell'eccezione struttura vuota
		try {
		p.pop();
		}
		catch (EccezioneStrutturaVuota e) {
			System.err.println(e.getMessage());
		}

		p.push("Mario");
		System.out.println(p.top().toString());
		
	}
}

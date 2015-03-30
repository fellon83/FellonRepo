package strutture.Coda.codadoppia;

import strutture.Eccezioni.EccezioneStrutturaVuota;

/**
 * Implementazione di una coda percorribile da entrambi i versi basata su array 
 * con la tecnica del raddoppiamento/dimezzamento
 * 
 * @author Fedele Amoruso
 *
 */
public class CodaDoppiaArray<T> implements CodaDoppia<T> {
	private int n = 0;
	private T[] s = (T[]) new Object[1];
	private int inizio = 0;
	private int fine = 0;

	/**
	 * verifica se la coda è vuota, 
	 * vero se n=0, falso altrimenti 
	 */
	public boolean isEmpty() {
		return n == 0;
	}

	/**
	 * Accoda un elemento alla fine della coda.
	 * Se l'array è vuoto viene posto in prima posizione, altrimenti viene accodato all'ultima posizione
	 * se nel caso non ci sia posto perché raggiunta la fine dell'array, viene riallocato l'array e aggiornati 
	 * gli indici (stessa cosa dello shiftare tutto a sinistra di un posto)
	 * 
	 * se al termine dell'accodamento l'array è completamente pieno, viene raddoppiato.
	 */
	public void enqueue(T e) {
		if (isEmpty()) {
			s[0] = e;
		} else {
			if ((fine == s.length - 1)) {
				System.arraycopy(s, inizio, s, inizio-1, n);
				inizio--;
				fine--;
			}
			s[fine + 1] = e;
			fine++;
		}
		n++;
		if (n == s.length) {
			T[] temp = (T[]) new Object[2 * n];
			System.arraycopy(s, inizio, temp, inizio, n);
			s = temp;
			inizio = 0;
			fine = n - 1;
		}

	}

	/**
	 * Inserisce un elemento in testa alla coda.
	 * Se l'array è vuoto viene posto in prima posizione, 
	 * se vi è posto prima del primo elemento disponibile viene inserito e aggiornato l'indice del primo elemento
	 * altrimenti gli elementi dell'array vengono scalati di una posizione verso destra e inserito l'elemento all'inizio
	 * 
	 * vengono aggiornati gli indici di inizio e fine (quest'ultimo solo nel secondo caso)
	 * 
	 * se al termine dell'accodamento l'arrya è completamente pieno, viene raddoppiato.
	 */
	public void push(T e) {
		if (isEmpty()) {
			s[0] = e;
		} else {
			if (inizio == 0) {
				for (int j = fine; j >= inizio; j--) {
					s[j + 1] = s[j];
				}
				fine++;
				inizio++;
			}
			s[inizio - 1] = e;
			inizio--;
		}
		n++;
		if (n == s.length) {
			T[] temp = (T[]) new Object[2 * n];
			System.arraycopy(s, 0, temp, 0, n);
			s = temp;
			inizio = 0;
			fine = n - 1;
		}
	}

	/**
	 * viene restituito l'elemento presente all'inizio della coda
	 */
	public T first() {
		if (isEmpty())
			throw new EccezioneStrutturaVuota("Coda vuota");
		return (T) s[inizio];
	}

	/**
	 * Viene restituito l'elemento alla fine della coda
	 */
	public T last() {
		if (isEmpty())
			throw new EccezioneStrutturaVuota("Coda vuota");
		return (T) s[fine];
	}

	/**
	 * Viene eliminato l'elemento a fine coda e aggiornato l'indice di fine coda
	 * se il numero degli elementi è un quarto della capacità dell'array, esso viene dimezzato, riallocato
	 * e aggiornati gli indici relativi
	 */
	public void dequeue() {
		if (isEmpty())
			throw new EccezioneStrutturaVuota("Coda vuota");
		s[fine] = null;
		if (n>1)
			fine--;
		n--;
		if ((n >= 1) && (n == s.length / 4)) {
			T[] temp = (T[]) new Object[s.length / 2];
			System.arraycopy(s, inizio, temp, 0, n);
			s = temp;
			inizio = 0;
			fine = n - 1;
		}

	}
	
	/**
	 * Viene eliminato l'elemento in testa alla coda e aggiornato l'indice di inizio coda
	 * se il numero degli elementi è un quarto della capacità dell'array, esso viene dimezzato, riallocato
	 * e aggiornati gli indici relativi
	 */
	public void pop() {
		if (isEmpty())
			throw new EccezioneStrutturaVuota("Coda vuota");
		s[inizio] = null;
		if (n > 1)
			inizio++;
		n--;
		if ((n >= 1) && (n == s.length / 4)) {
			T[] temp = (T[]) new Object[s.length / 2];
			System.arraycopy(s, inizio, temp, 0, n);
			s = temp;
			inizio = 0;
			fine = n - 1;

		}
	}

	/*
	 * Serie di istruzioni per testare i vari accodamenti e inserimenti in testa
	 * e i vari casi limiti 
	 */
	public static void main(String[] args) {
		CodaDoppia<String> cd = new CodaDoppiaArray<String>();
		cd.enqueue("1");
		cd.enqueue("2");
		cd.push("3");
		cd.pop();
		cd.enqueue("4");
		cd.enqueue("5");
		cd.enqueue("9");
		System.out.println(cd.first());
		System.out.println(cd.last());
		cd.push("10");
		cd.pop();
		cd.pop();
		cd.push("6");
		cd.enqueue("7");
		System.out.println(cd.first());
		System.out.println(cd.last());
		cd.push("11");
		cd.pop();
		cd.pop();
		cd.pop();
		cd.pop();
		cd.enqueue("8");
		cd.enqueue("12");
		System.out.println(cd.first());
		System.out.println(cd.last());
		// svuotamento
		cd.dequeue();
		cd.pop();
		cd.pop();
		cd.dequeue();
		cd.dequeue();
		// prove eccezioni
		try {
			cd.pop();
		} catch (EccezioneStrutturaVuota e) {
			System.err.println(e.getMessage());
		}
		try {
			cd.dequeue();
		} catch (EccezioneStrutturaVuota e) {
			System.err.println(e.getMessage());
		}
		try {
			cd.last();
		} catch (EccezioneStrutturaVuota e) {
			System.err.println(e.getMessage());
		}
		try {
			cd.first();
		} catch (EccezioneStrutturaVuota e) {
			System.err.println(e.getMessage());
		}
	}

}

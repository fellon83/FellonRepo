package lab.Pila;

import lab.eccezioni.EccezioneStrutturaVuota;

/**
 * Pila basata su un array di oggetti generici T e con la tecnica del raddoppiamento/dimezzamento
 * All'inizio l'array è di lunghezza 1 per ospitare il primo elemento.
 * 
 * @author Fedele Amoruso
 *
 */

public class PilaArray<T> implements Pila<T> {
	private int n = 0;
	private T[] pila = (T[]) new Object[1];

	/**
	 * Contolla se la struttura è vuota
	 * true se e sole se inizio è uguale a null, falso altrimenti
	 */
	public boolean isEmpty() {
		return n == 0;
	}

	/**
	 * immetti "in testa" alla pila un nuovo elemento
	 * se la pila è piena, viene raddoppiata la dimensione dell'array
	 */
	public void push(T e) {
		pila[n] = e;
		n++;
		if (n == pila.length) {
			T[] temp = (T[]) new Object[2 * pila.length];
			System.arraycopy(pila, 0, temp, 0, n);
			pila = temp;
		}
	}

	/**
	 * restituisce l'elemento "in testa" alla pila
	 */
	public T top() {
		if (isEmpty())
			throw new EccezioneStrutturaVuota("Pila vuota");
		return pila[n - 1];
	}

	/**
	 * Elimina il primo elemento in testa della pila, aggiornando
	 * il numero n di elementi presenti
	 * 
	 * se il numero di elementi nella pila è inferiore ad un quarto della lunghezza dell'array
	 * viene dimezzata la dimensione di quest'ultimo
	 */
	public void pop() {
		if (isEmpty())
			throw new EccezioneStrutturaVuota("Pila vuota");
		n--;
		if ((n > 1) && (n == pila.length / 4)) {
			T[] temp = (T[]) new Object[pila.length / 2];
			System.arraycopy(pila, 0, temp, 0, n);
			pila=temp;
		}

	}
	
	public static void main (String[] args) {
		PilaArray<String> p = new PilaArray<>();
		
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
		catch (RuntimeException e) {
			System.err.println(e);
		}

		p.push("Mario");
		System.out.println(p.top().toString());
		
	}

}

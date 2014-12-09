package lab.CodaDoppia;

import lab.eccezioni.EccezioneStrutturaVuota;

/**
 * Implementazione di una Coda percorribile in entrambi i versi ed è basata su una struttura collegata di record
 * 
 * @author Fedele Amoruso
 *
 */

public class CodaDoppiaCollegata<T> implements CodaDoppia<T> {

	Record inizio, fine = null;

	private class Record {
		T elem;
		Record next;
		Record prev;

		Record(T e) {
			this.elem = e;
		}
	}

	/**
	 * Verifica se la coda è vuota verificando la presenza del primo elemento.
	 */
	public boolean isEmpty() {
		return (inizio == null);
	}

	/**
	 * Accoda un elemento alla fine della coda.
	 * Se la coda è vuota, il primo e l'ultimo elemento saranno il nuovo elemento
	 * altrimenti il nuovo record è l'ultimo elemento e vengono aggiornati i relativi puntatori.
	 */
	public void enqueue(T e) {
		if (isEmpty()) {
			inizio = fine = new Record(e);
		} else {
			fine.next = new Record(e);
			fine.next.prev = fine;
			fine = fine.next;
		}
	}

	/**
	 * Aggiunge un elemento "in testa" alla coda.
	 * Se la coda è vuota, il primo e l'ultimo elemento saranno il nuovo elemento
	 * altrimenti il nuovo recorda è il primo della coda e vengono aggiornati i puntatori
	 * del record iniziale 
	 */
	public void push(T e) {
		if (isEmpty()) {
			inizio = fine = new Record(e);
		} else {
			inizio.prev = new Record(e);
			inizio.prev.next = inizio;
			inizio = inizio.prev;
		}
	}

	/**
	 * Visualizza il primo elemento in coda
	 */
	public T first() {
		if (isEmpty())
			throw new EccezioneStrutturaVuota("CodaDoppia vuota");
		return inizio.elem;
	}

	/**
	 * Visualizza l'ultimo elemento in coda
	 */
	public T last() {
		if (isEmpty())
			throw new EccezioneStrutturaVuota("CodaDoppia vuota");
		return fine.elem;
	}

	/**
	 * Rimuove l'elemento all'inizio della coda
	 * se il record presente è l'unico, inizio e fine vengono settati come null
	 * altrimenti vengono aggiornati il record iniziale e relativo puntatore
	 */
	public void pop() {
		if (isEmpty())
			throw new EccezioneStrutturaVuota("CodaDoppia vuota");
		if (inizio.next == null) {
			inizio = fine = null;
		} else {
			inizio.next.prev = null;
			inizio = inizio.next;
		}

	}

	/**
	 * Rimuove l'elemento alla fine della coda
	 * se il record presente è l'unico, inizio e fine vengono settati come null
	 * altrimenti vengono aggiornati il record finale e relativo puntatore
	 */
	public void dequeue() {
		if (isEmpty())
			throw new EccezioneStrutturaVuota("CodaDoppia vuota");
		if (fine.prev == null) {
			inizio = fine = null;
		} else {
			fine.prev.next = null;
			fine = fine.prev;
		}

	}

	
	/*
	 * Serie di comandi posti in maniera casuale affinchè venga testata la funzionalità
	 * della coda in entrambi i versi
	 */
	public static void main(String[] args) {

		CodaDoppiaCollegata<String> c = new CodaDoppiaCollegata<String>();

		System.out.println(c.isEmpty());
		c.enqueue("Antonio");
		c.enqueue("Mario");
		c.push("Giovanni");
		c.dequeue();
		c.dequeue();
		c.push("Filippo");
		c.enqueue("Maria");
		c.enqueue("Rosa");
		c.pop();
		c.pop();
		c.push("Ilaria");
		c.enqueue("Marco");
		c.push("Francesco");

		System.out.println(c.first().toString());
		c.dequeue();
		System.out.println(c.last().toString());

		System.out.println(c.isEmpty());

		c.dequeue();

		c.dequeue();

		System.out.println(c.isEmpty());

		// prova di gestione dell'eccezione struttura vuota
		try {
			c.dequeue();
		} catch (RuntimeException e) {
			System.err.println(e);
		}

		c.push("Rosa");

		System.out.println(c.last().toString());
		c.pop();
		System.out.println(c.first().toString());

		System.out.println(c.isEmpty());

		c.pop();


		System.out.println(c.isEmpty());

		// prova di gestione dell'eccezione struttura vuota
		try {
			c.pop();
		} catch (RuntimeException e) {
			System.err.println(e);
		}

		c.push("Graziana");
		System.out.println(c.last().toString());

	}

}

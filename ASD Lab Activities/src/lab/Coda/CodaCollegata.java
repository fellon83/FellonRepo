package lab.Coda;

import lab.eccezioni.EccezioneStrutturaVuota;


/**
 * Coda realizzata mediante una struttura collegata di record, ogni record ha il puntatore al record successivo
 * È basata sull'interfaccia Coda
 * @author Fedele Amoruso
 *
 * @param <T>
 * 			Oggetto generico impilabile
 */
public class CodaCollegata<T> implements Coda<T> {

	Record inizio, fine = null;

	private class Record {
		T elem;
		Record next;

		Record(T e) {
			this.elem = e;
		}
	}

	/**
	 * Contolla se la struttura è vuota
	 * true se e sole se inizio è uguale a null, falso altrimenti
	 */
	public boolean isEmpty() {
		return inizio == null;
	}

	/**
	 * Accoda un elemento.
	 * Se la struttura è vuota inizio e fine saranno lo stesso elemento (coda di 1 elemento)
	 * altrimenti si accoda all'ultimo elemento aggiornando il puntatore next al nuovo elemento 
	 * e aggiornando il nuovo elemento finale
	 */
	public void enqueue(T e) {
		if (isEmpty()) {
			inizio = fine = new Record(e);
		} else {
			fine.next = new Record(e);
			fine = fine.next;
		}

	}

	/**
	 * Visualizza il primo elemento della coda
	 */
	public T first() throws EccezioneStrutturaVuota {
		if (isEmpty())
			throw new EccezioneStrutturaVuota("Coda vuota");
		return (T) inizio.elem;
	}

	/**
	 * Elimina il primo elemento della coda aggiornando il puntatore al successivo
	 * e impostandolo come primo elemento della coda
	 * 
	 * Se la coda era formato solo da 1 elemento, eliminandolo, inizio e fine della coda diventano null.
	 */
	public void dequeue() {
		if (isEmpty())
			throw new EccezioneStrutturaVuota("Coda vuota");
		if (inizio.next==null)
			inizio = fine = null;
			else
				inizio = inizio.next;
	}
	
	

	public static void main(String[] args) {

		CodaCollegata<String> c = new CodaCollegata<String>();

		System.out.println(c.isEmpty());
		c.enqueue("Antonio");
		c.enqueue("Mario");
		c.enqueue("Giovanni");
		c.enqueue("Filippo");
		c.enqueue("Gianfranco");

		System.out.println(c.first().toString());
		c.dequeue();
		System.out.println(c.first().toString());

		System.out.println(c.isEmpty());

		c.dequeue();
		c.dequeue();
		c.dequeue();
		c.dequeue();
		
		System.out.println(c.isEmpty());
		
		//prova di gestione dell'eccezione struttura vuota
		try {
		c.dequeue();
		}
		catch (RuntimeException e) {
			System.err.println(e);
		}


		c.enqueue("Mario");
		System.out.println(c.first().toString());
		c.enqueue("Giovanni");
	}
}

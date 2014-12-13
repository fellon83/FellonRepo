package lab.Lista;

import java.util.Iterator;

import lab.Eccezioni.EccezioneStrutturaVuota;

/**
 * Lista di oggetti generici basata su array con tecnica del
 * raddoppiamento/dimezzamento
 * 
 * @author Fedele Amoruso
 *
 */
public class ListDoubling<T> implements Lista<T> {

	private T[] list = (T[]) new Object[1];
	private int n = 0;

	public boolean isEmpty() {
		return n == 0;
	}

	/**
	 * Controlla che la posizione passata sia valida
	 * 
	 * @param p
	 *            la posizione da controllare
	 * @return vero se e solo se, l'indice in ingresso è maggiore di 0 e minore
	 *         del numero di elementi presenti nella lista
	 */
	protected boolean checkPosition(Posizione p) {
		Indice i = (Indice) p;
		return (i.indice >= 0 || i.indice <= n);
	}

	/**
	 * Restituisce l'elemento della lista in una determinata posizione
	 */
	public T readList(Posizione p) {
		if (!checkPosition(p))
			throw new IndexOutOfBoundsException("Posizione non valida");
		return (T) list[((Indice) p).indice];
	}

	/**
	 * Sovrascrive l'elemento in ingresso in una posizione determinata. Viene
	 * verificato che la posizione inoltrata sia corretta
	 */
	public void writeList(T e, Posizione p) {
		if (!checkPosition(p))
			throw new IndexOutOfBoundsException(
					"Posizione di inserimento non valida");
		list[((Indice) p).indice] = e;
	}

	/**
	 * restiituisce la prima posizione della lista
	 */
	public Posizione firstList() {
		return new Indice();
	}

	/**
	 * Verifica che la posizione passata sia l'ultima della lista
	 *
	 */
	public boolean endList(Posizione p) {
		return ((Indice) p).indice == n;
	}

	/**
	 * Restituisce la posizione successiva ad una determinata posizione a meno
	 * che non sia l'ultima della lista
	 */
	public Posizione succ(Posizione p) {
		if (endList(p))
			throw new IndexOutOfBoundsException(
					"l'indice passato è l'ultimo della lista");
		Indice pos = new Indice();
		pos.indice = ((Indice) p).indice + 1;
		return pos;
	}

	/**
	 * Restituisce la posizione precedente ad una determinata posizione a meno
	 * che non sia minore della prima della lista della lista
	 */
	public Posizione pred(Posizione p) {
		if (((Indice) p).indice < ((Indice) firstList()).indice)
			throw new IndexOutOfBoundsException("attaccati al cazzo!");
		Indice pos = new Indice();
		pos.indice = ((Indice) p).indice - 1;
		return pos;
	}

	/**
	 * Inserisce un elemento all'interno della lista in una detereminata
	 * posizione Vengono spostati tutti gli elementi successivi alla posizione
	 * desiderata affinchè si "crei" il posto per l'elemento
	 * 
	 * se la nuova lista riempie totalmente l'array, quest'ultimo verrà
	 * raddoppiato.
	 */
	public void insert(T e, Posizione p) {
		if (!checkPosition(p))
			throw new IndexOutOfBoundsException(
					"Posizione di inserimento non valida");
		for (int i = n; i > ((Indice) p).indice; i--)
			list[i] = list[i - 1];
		list[((Indice) p).indice] = e;
		n++;
		if (n == list.length) {
			T[] temp = (T[]) new Object[2 * list.length];
			for (Indice pos = (Indice) firstList(); !endList(pos); pos = (Indice) succ(pos))
				temp[pos.indice] = list[pos.indice];
			list = temp;
		}

	}

	/**
	 * Rimuove un elemento dalla lista nella posizione desiderata se la lista
	 * non è vuota e se la posizione è corretta
	 * 
	 * se al termine della rimozione la lista è 1/4 dell'array, quest'ultimo
	 * viene dimezzato
	 */
	public void remove(Posizione p) {
		if (isEmpty())
			throw new EccezioneStrutturaVuota("Lista vuota");
		if (!checkPosition(p))
			throw new IndexOutOfBoundsException(
					"Posizione di inserimento non valida");

		for (int i = ((Indice) p).indice; i < n - 1; i++) {
			list[i] = list[i + 1];
		}
		n--;
		if ((n > 1) && (n == list.length / 4)) {
			T[] temp = (T[]) new Object[list.length / 2];
			for (Indice i = (Indice) firstList(); !endList(i); i = (Indice) succ(i)) {
				temp[i.indice] = list[i.indice];
			}
			list = temp;
		}

	}

	/**
	 * Iteratore per la scansione degli elementi presenti nella lista
	 */
	public Iterator<T> iterator() {
		return new ListIterator<T>(this);
	}

	/*
	 * Serie di istruzioni per testare inserimento, rimozione, sovrascrittura e
	 * iteratore
	 */
	public static void main(String[] args) {
		Lista<String> list = new ListDoubling<String>();
		System.out.println("la lista è vuota: " + list.isEmpty() + "\n");
		list.insert("a", list.firstList());
		list.insert("b", list.firstList());
		list.insert("c", list.firstList());
		list.insert("d", list.firstList());
		list.insert("e", list.firstList());
		System.out.println("inserisco f in seconda posizione \n");
		list.insert("f", list.succ(list.firstList()));
		System.out.println("Si stampa la lista");
		Iterator<String> it = list.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		System.out.println("\n rimoz. 4 Elem. in prima posizione");
		list.remove(list.firstList());
		list.remove(list.firstList());
		System.out.println("\nSovrascrivo il terzo elemento \n");
		list.writeList("z", list.succ(list.succ(list.firstList())));
		list.remove(list.firstList());
		list.remove(list.firstList());
		it = list.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		System.out.println("\nStampo la lista con metodo equivalente all'iteratore");
		/*
		 * ogni valore stringa della lista viene messo nella variabile ls ed eseguita (in questo caso stampata a video)
		 */
		for (String ls : list) {
			System.out.println(ls);
		}
	}

}

package strutture.Lista;

import java.util.Iterator;

/**
 * Lista collegata basata su record e puntatore all'elemento successivo
 * 
 * @author Fedele Amoruso
 *
 */
public class ListLinked<T> implements Lista<T> {

	private Puntatore inizioLista = null;

	@Override
	public Iterator<T> iterator() {
		return null;
	}

	@Override
	public boolean isEmpty() {
		return inizioLista == null;
	}

	@Override
	public T readList(Posizione p) {
		if (isEmpty())
			throw new IndexOutOfBoundsException("Lista vuota");
		if (p == firstList())
			return (T) inizioLista.link.elemento;
		else
			return (T) ((Puntatore) p).link.successivo.link.elemento;
	}

	
	public void writeList(T e, Posizione p) {
		if (endList(p))
			throw new IndexOutOfBoundsException(
					"Posizione fine lista non valida");
		else
			((Puntatore) p).link.successivo.link.elemento = e;
	}

	public Posizione firstList() {
		return null;
	}

	public boolean endList(Posizione p) {
		if (isEmpty())
			return true;
		if (p == firstList())
			return false;
		else
			return ((Puntatore) p).link.successivo == null;
	}

	public Posizione succ(Posizione p) {
		if (endList(p))
			throw new IndexOutOfBoundsException(
					"Posizione fine lista non valida");
		if (isEmpty())
			throw new IndexOutOfBoundsException("Lista vuota");
		if (p == firstList())
			return inizioLista;
		else
			return ((Puntatore) p).link.successivo;
	}

	public Posizione pred(Posizione p) {
		if (p == firstList())
			throw new IndexOutOfBoundsException(
					"Posizione inzio lista non valida");
		if (isEmpty())
			throw new IndexOutOfBoundsException("Lista vuota");
		Puntatore pos = (Puntatore) firstList();
		while (!endList(pos)) {
			if (succ(pos) == p)
				return pos;
		}
		throw new IndexOutOfBoundsException(
				"Impossibile trovare l'elemento precedente");
	}

	public void insert(T e, Posizione p) {
		Puntatore temp, q;
		if (!isEmpty()) {
			if (firstList() == p) {
				temp = inizioLista;
				inizioLista = new Puntatore(new Cella(e));
				inizioLista.link.successivo = temp;
			} else {
				temp = ((Puntatore) p).link.successivo;
				q = new Puntatore(new Cella(e));
				((Puntatore) p).link.successivo = q;
				q.link.successivo = temp;
			}
		} else {
			inizioLista = new Puntatore(new Cella(e));
		}

	}

	public void remove(Posizione p) {
		if (isEmpty())
			throw new IndexOutOfBoundsException("Lista vuota");
		if (p == firstList())
			inizioLista = inizioLista.link.successivo;
		else if (endList(p))
			throw new IndexOutOfBoundsException(
					"Posizione fine lista non valida");
		else
			((Puntatore) p).link.successivo = ((Puntatore) p).link.successivo.link.successivo;

	}

	public static void main(String[] args) {
		Lista<String> list = new ListLinked<String>();

		System.out.println("la lista è vuota: " + list.isEmpty() + "\n");
		list.insert("a", list.firstList());
		list.insert("b", list.firstList());
		list.insert("c", list.firstList());
		list.insert("d", list.firstList());
		list.insert("e", list.firstList());
		System.out.println("\nStampo la lista");
		Posizione p = list.firstList();
		while (!list.endList(p)) {
			System.out.println(list.readList(p));
			p = list.succ(p);
		}
		System.out.println("\ninserisco f in seconda posizione \n");
		list.insert("f", list.succ(list.firstList()));

		System.out.println("\n rimoz. 4 Elem. in prima posizione");
		list.remove(list.firstList());
		list.remove(list.firstList());
		System.out.println("\nSovrascrivo il terzo elemento \n");
		list.writeList("z", list.succ(list.succ(list.firstList())));
		list.remove(list.firstList());
		list.remove(list.firstList());

		System.out
				.println("\nStampo la lista");

		p = list.firstList();
		while (!list.endList(p)) {
			System.out.println(list.readList(p));
			p = list.succ(p);
		}
	}
}

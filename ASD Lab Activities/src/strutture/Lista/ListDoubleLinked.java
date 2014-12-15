package strutture.Lista;

import java.util.Iterator;

public class ListDoubleLinked<T> implements Lista<T> {
	
	private PuntatoreDouble inizioLista;

	@Override
	public Iterator<T> iterator() {
		return null;
	}

	@Override
	public boolean isEmpty() {
		return inizioLista==null;
	}

	public T readList(Posizione p) {
		if (isEmpty())
			throw new IndexOutOfBoundsException("Lista vuota");
		if (p == firstList())
			return (T) inizioLista.link.elemento;
		else
			return (T) ((PuntatoreDouble) p).link.successivo.link.elemento;
	}

	public void writeList(T e, Posizione p) {
		if (endList(p))
			throw new IndexOutOfBoundsException(
					"Posizione fine lista non valida");
		else
			((PuntatoreDouble) p).link.successivo.link.elemento = e;
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
			return ((PuntatoreDouble) p).link.successivo == null;
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
			return ((PuntatoreDouble) p).link.successivo;
	}

    @Override
    public Posizione pred(Posizione p) {
        if(p == firstList()) {
            throw new IndexOutOfBoundsException("Posizione inizio lista non valida");
        }
        if(isEmpty()) {
            throw new IndexOutOfBoundsException("Lista vuota");
        }
        return ((PuntatoreDouble) p).link.precedente;
    }


	public void insert(T e, Posizione p) {
		PuntatoreDouble temp,q;
		if (isEmpty()) 
			inizioLista = new PuntatoreDouble(new CellaDouble(e));
		else {
			if (p == firstList()) {
				temp = inizioLista;
				inizioLista = new PuntatoreDouble(new CellaDouble(e));
				inizioLista.link.successivo=temp;
				inizioLista.link.precedente=inizioLista;
			} else {
				temp = ((PuntatoreDouble)p).link.successivo;
				q = new PuntatoreDouble(new CellaDouble(e));
				((PuntatoreDouble)p).link.successivo=q;
				q.link.successivo=temp;
				if (temp != null)
					temp.link.precedente=q;
				q.link.precedente=(PuntatoreDouble) p;
			}
			
		}
		
		
	}

    public void remove(Posizione p) {
        if(endList(p)) {
            throw new IndexOutOfBoundsException("Posizione fine lista non valida");
        }
        if(p == firstList()) {
            inizioLista = inizioLista.link.successivo;
            inizioLista.link.precedente = null;
        } else {
            if(endList(((PuntatoreDouble) p).link.successivo)) {
                ((PuntatoreDouble) p).link.successivo = null;
            } else {
                ((PuntatoreDouble) p).link.successivo = ((PuntatoreDouble) p).link.successivo.link.successivo;
                ((PuntatoreDouble) p).link.precedente = ((PuntatoreDouble) p).link.precedente.link.precedente;
            }
        }
    }
	
    public static void main(String[] args) {
        Lista<String> list = new ListDoubleLinked<String>();

        System.out.println("Creazione di lista 1");
        System.out.println("la lista inizialmente e' vuota: " + list.isEmpty() + "\n");

        list.insert(null, list.firstList());
        list.insert("b", list.firstList());
        list.insert("c", list.firstList());
        list.insert("d", list.firstList());
        list.insert("e", list.firstList());

        System.out.println("Stampo tutti gli elementi");
        Posizione p = list.firstList();

        while (!list.endList(p)) {

            System.out.println(list.readList(p));
            p = list.succ(p);
        }

        System.out.println("inserisco f in seconda posizione \n");
        list.insert("f", list.succ(list.firstList()));

        System.out.println("Stampo tutti gli elementi");
        p = list.firstList();

        while (!list.endList(p)) {

            System.out.println(list.readList(p));
            p = list.succ(p);
        }

        System.out.println("\n eliminazione elemento in prima posizione");
        list.remove(list.firstList());

        p = list.firstList();

        while (!list.endList(p)) {

            System.out.println(list.readList(p));
            p = list.succ(p);
        }


        System.out.println("\n eliminazione elemento in ultima posizione");
        p = list.firstList();
        Posizione q = null;
        while (!list.endList(p)) {
            q = p;
            p = list.succ(p);
        }

        list.remove(q);

        p = list.firstList();

        while (!list.endList(p)) {
            if (list.readList(p) != null)
                System.out.println(list.readList(p));
            p = list.succ(p);
        }

        System.out.println("\n eliminazione elemento in posizione 3");
        q = list.succ(list.succ(list.firstList()));
        list.remove(q);

        p = list.firstList();

        while (!list.endList(p)) {

            System.out.println(list.readList(p));
            p = list.succ(p);
        }


        System.out.println("Inserimento elemento fine in coda");
        list.insert("fine", p);

        p = list.firstList();

        while (!list.endList(p)) {

            System.out.println(list.readList(p));
            p = list.succ(p);
        }

        System.out.println("\n");

        System.out.println("inserimento elemento in posizione 4");
        Posizione posizione4 = list.succ(list.succ(list.succ(list.firstList())));
        list.insert("posizione 4", posizione4);


        p = list.firstList();

        while (!list.endList(p)) {

            System.out.println(list.readList(p));
            p = list.succ(p);
        }

        System.out.println("inserimento elemento posizione predecessore di 4");
        list.insert("posizione 3", list.pred(posizione4));

        p = list.firstList();

        while (!list.endList(p)) {

            System.out.println(list.readList(p));
            p = list.succ(p);
        }

        System.out.println("sovrascivo elemento posizione 4");
        posizione4 = list.succ(list.succ(list.succ(list.firstList())));
        list.writeList("sovrascritto", posizione4);

        p = list.firstList();

        while (!list.endList(p)) {

            System.out.println(list.readList(p));
            p = list.succ(p);
        }

    }
}

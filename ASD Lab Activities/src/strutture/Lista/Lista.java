package strutture.Lista;

public interface Lista<T> extends Iterable<T> {

	public boolean isEmpty();

	public T readList(Posizione p);

	public void writeList(T e, Posizione p);

	public Posizione firstList();

	public boolean endList(Posizione p);

	public Posizione succ(Posizione p);

	public Posizione pred(Posizione p);

	public void insert(T e, Posizione p);

	public void remove(Posizione p);
}

package esami.Lab20150331.Albero;

public interface BDT<E> extends Iterable<E> {
	
	public boolean foglia();
	public E decisione();
	public E predicato();
	public BDT<E> sin(BDT<E> albero);
	public BDT<E> des(BDT<E> albero);

}

package esami.Lab20141120;

public interface AddOnlyList<S> extends Iterable<S> {

	public void add(S e);
	public String toString();
}

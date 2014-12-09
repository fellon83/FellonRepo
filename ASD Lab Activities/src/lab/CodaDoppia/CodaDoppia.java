package lab.CodaDoppia;

public interface CodaDoppia<T> {
	
	public boolean isEmpty();
	public void enqueue(T e);
	public void push(T e);
	public T first();
	public T last();
	public void dequeue();
	public void pop();
}

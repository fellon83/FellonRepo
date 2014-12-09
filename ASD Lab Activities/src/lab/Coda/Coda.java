package lab.Coda;

public interface Coda<T> {
		public boolean isEmpty();
		public void enqueue(T e);
		public T first();
		public void dequeue();
		
}

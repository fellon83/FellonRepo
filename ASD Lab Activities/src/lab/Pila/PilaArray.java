package lab.Pila;

public class PilaArray<T> implements Pila<T> {
	private int n=0;
	private T[] pila = (T[]) new Object[1];

	@Override
	public boolean isEmpty() {
		return n==0;
	}

	@Override
	public void push(T e) {
		pila[n]= e;
		n++;
		if(n==pila.length) {
			T[] temp = (T[]) new Object[2*pila.length];
			System.arraycopy(pila, 0, temp, 0, n);
			pila=temp;
		}
	}

	@Override
	public T top() throws EccezioneStrutturaVuota {
		if (isEmpty())
			throw new EccezioneStrutturaVuota("Pila vuota");
		return pila[n-1];
	}

	@Override
	public void pop() throws EccezioneStrutturaVuota {
		if (isEmpty())
			throw new EccezioneStrutturaVuota("Pila vuota");
		n--;
		if ((n>1) && (n==pila.length/4)) {
			T[] temp = (T[]) new Object[pila.length/2];
			System.arraycopy(pila, 0, temp, 0, n-1);
		}
			

	}

}

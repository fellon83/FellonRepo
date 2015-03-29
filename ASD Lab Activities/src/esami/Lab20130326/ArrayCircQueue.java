package esami.Lab20130326;

import java.util.Iterator;

public class ArrayCircQueue<S> implements CircQueue<S> {
	private int nElem = 0;
	private Object[] queue = new Object[1];
	private boolean rotationFlag = true;
	private int inizio = 0;

	public void add(S e) {
		queue[nElem] = e;
		nElem++;
		if (queue.length == nElem) {
			Object[] tmp = new Object[queue.length * 2];
			for (int i = 0; i < nElem; i++) {
				tmp[i] = queue[i];
			}
			queue = tmp;
		}


	}

	public S value() {
		return (S) queue[inizio];
	}

	public boolean isEmpty() {

		return nElem == 0;
	}

	public void rotateF() {
		if (isEmpty())
			throw new EmptyStructureException("Struttura vuota.");

		if (rotationFlag) {
			inizio++;
			if (inizio == nElem)
				inizio = 0;
		} else {
			System.out.println("Rotazione bloccata.");
		}
	}

	public int size() {

		return nElem;
	}

	public boolean equals(CircQueue<S> s) {
		if ((s.size() != this.size()) || (this.queue[inizio] != s.value()))
			return false;
		boolean equalsFlag = true;
		for (S tmp : this) {
			if (!(tmp.equals(s.value()))) {
				equalsFlag = false;
				break;
			}
			s.rotateF();
		}
		return equalsFlag;
	}

	public void stop() {
		rotationFlag = false;
	}

	public void restart() {
		rotationFlag = true;
	}

	public Iterator<S> iterator() {

		return new Iterator<S>() {
			private int nScan = 0;

			public boolean hasNext() {

				return nScan < nElem;
			}

			public S next() {

				return (S) queue[++nScan];
			}
		};
	}
}

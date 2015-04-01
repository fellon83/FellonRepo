package esami.Lab20150331.Albero;

import java.util.Iterator;

public class BDTPF<E> implements BDT<E> {
	private E radice;
	private BDTPF<E> sin;
	private BDTPF<E> des;

	public BDTPF(E decision) {
		radice = decision;
		sin = null;
		des = null;
	}

	public BDTPF(BDT<E> sin, E u, BDT<E> des) {
		radice = u;
		this.sin = (BDTPF<E>) sin;
		this.des = (BDTPF<E>) des;

	}

	public boolean foglia() {
		if (radice == null) {
			throw new EccezioneNodoNonValido("Nodo non valido");
		}
		return (this.sin == null) && (this.des == null);
	}

	public E decisione() {
		if (!foglia())
			throw new EccezioneNodoNonValido("Nodo non valido");
		return this.radice;
	}

	public E predicato() {
		if (foglia())
			throw new EccezioneNodoNonValido("Nodo non valido");
		return this.radice;
	}

	public BDT<E> sin(BDT<E> albero) {
		if (foglia())
			throw new EccezioneNodoNonValido("Nodo non valido");
		return this.sin;
	}

	public BDT<E> des(BDT<E> albero) {
		if (foglia())
			throw new EccezioneNodoNonValido("Nodo non valido");
		return this.des;
	}

	//TODO: Completare l'implementazione dell'iteratore
	public Iterator<E> iterator() {

		return null;
	}
}

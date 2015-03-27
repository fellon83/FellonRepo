package esami.Lab20130917;

import java.util.Iterator;

public class SessioneLL extends SessioneAbs {

	public SessioneLL () {
		prodotti = new LinkedList<Prodotto>();
	}

	@Override
	public Iterator<Prodotto> iterator() {
		
		return (Iterator<Prodotto>) this.prodotti.iterator();
	}
}

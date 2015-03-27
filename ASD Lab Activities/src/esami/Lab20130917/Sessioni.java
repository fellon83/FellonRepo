package esami.Lab20130917;

import java.util.Iterator;

public class Sessioni implements Iterable<SessioneLL> {
	protected AddOnlyList<SessioneLL> sessioni;
	private int nSess;

	public Sessioni() {
		sessioni = new LinkedList<SessioneLL>();
		nSess=0;
	}
	
	public void addSessione(SessioneLL s) {
		sessioni.add(s);
		nSess++;
	}

	@Override
	public Iterator<SessioneLL> iterator() {
		return (Iterator<SessioneLL>) this.sessioni.iterator();
	}
}

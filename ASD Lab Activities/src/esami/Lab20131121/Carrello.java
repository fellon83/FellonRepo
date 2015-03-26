package esami.Lab20131121;

import java.util.Iterator;

public class Carrello implements Iterable<Articolo> {

	protected Dictionary<Integer> carrello;
	private int nElemDist = 0;

	public Carrello() {
		carrello = new LinkedDict<Integer>();
	}

	public void aggArticolo(Articolo art) {
		Object s = carrello.search(art);
		int qArt = 0;
		if (s!=null)
			qArt = (Integer) s;
		
		if (qArt > 0) {
			carrello.delete(art);
		} else {
			nElemDist++;
		}
		qArt++;
		carrello.insert(art, qArt);
	}

	public void togliArticolo(Articolo art) {
		int qArt = (Integer) carrello.search(art);
		if (qArt==0)
			return;
		qArt--;
		carrello.delete(art);
		if (qArt>0) 
			carrello.insert(art, qArt);
		else
			nElemDist--;
	}

	public int quantit‡(Articolo art) {
		return (Integer) carrello.search(art);
	}

	public boolean ËVuoto() {
		return nElemDist==0;
	}

	public boolean appartiene(Articolo art) {
		return carrello.search(art)!=null;
	}

	public int numArticoliDistinti() {
		return nElemDist;
	}

	public Iterator<Articolo> iterator() {

		return (Iterator) carrello.iterator();
	}

}

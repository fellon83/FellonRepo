package esami.Lab20140923;

import java.util.LinkedList;
import java.util.Random;

public class Navigazione {

	LinkedList<Record> traiettoria;

	public Navigazione() {
		traiettoria = new LinkedList<Record>();
	}

	public void naviga(int n) {
		Bussola b = new Bussola();
		Random r = new Random();
		for (int i = 0; i < n; i++) {
			int prob = r.nextInt(3);
			switch (prob) {
			case 0:
				b.ruotaI();
				break;
			case 1:
				break;
			case 2:
				b.ruotaA();
				break;
			}
			Record rilevazione = new Record(b.direzione(), i);
			traiettoria.add(rilevazione);
		}
	}

	public String toString() {
		String traiettoriaS = "";
		int i = 0;
		for (Object e : traiettoria) {
			i++;
			Record puntoD = (Record) e;
			traiettoriaS += puntoD.getDirezione().toString() + " -> ";
			if (i % 10 == 0)
				traiettoriaS += "\n";
		}
		return traiettoriaS;
	}

	public static void main(String[] args) {
		Navigazione n = new Navigazione();
		n.naviga(30);
		System.out.println("- Traiettoria --");
		System.out.println(n.toString());

	}

}

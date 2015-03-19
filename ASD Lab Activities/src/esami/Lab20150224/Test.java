package esami.Lab20150224;

import java.util.Random;

public class Test {

	final static int numProgetti = 20;
	final static float maxVoto = 15;

	public static void main(String[] args) {
		Graduatoria g = new Graduatoria();
		Graduatoria gEstratta;
		for (int i = 0; i < numProgetti; i++) {
			Random r = new Random();
			float punteggio = r.nextFloat() * (maxVoto);
			Progetto prog = new Progetto("Progetto" + i);
			g.aggG(prog, punteggio);
		}

		gEstratta = g.restoG();
		int dim = gEstratta.dim();
		Graduatoria tmp = new Graduatoria();
		for (int i = 0; i < dim - 1; i++) {
			Progetto p = (Progetto) gEstratta.primoP();
			float punt = gEstratta.primoV();
			tmp.aggG(p, punt);
		}
		gEstratta = tmp;

		System.out.println("La media dei progetti è: " + g.media());

		System.out
				.println("\nLa lista senza primo e ultimo elemento è contenuta nella lista principale: "
						+ g.contenuta(gEstratta));
		dim = g.dim();
		System.out.println("\n- Lista progetti -");
		for (int i = 0; i < dim; i++) {
			Progetto p = (Progetto) g.primoP();
			String nome = p.getNome();
			int id = p.getCodice();
			System.out.println("Progetto id: " + id + " Nome: " + nome
					+ " - Punteggio: " + g.primoV());
			g = g.restoG();
		}
	}

}

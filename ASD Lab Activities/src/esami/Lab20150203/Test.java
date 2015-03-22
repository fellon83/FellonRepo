package esami.Lab20150203;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Test {

	final static String[] NOMI_LISTE = { "Todos Caballeros", "Non ci siamo",
			"Futuro Incerto" };
	final static int ELETTORI = 30;
	final static int PROB_LISTA = 3;
	final static int PROB_VOTO = 10;
	final static int NUM_CANDIDATI = 10;

	static HashMap<String, ListaElettorale<String>> listeEffettive = new HashMap<String, ListaElettorale<String>>();

	public static void main(String[] args) {

		List<String> elencoCandidati = new LinkedList<String>();
		ListaElettorale<String> lista;
		Elezione e = new Elezione(5);
		Voto v;

		for (int i = 1; i <= NUM_CANDIDATI; i++) {
			String nomeCand = "Candidato n." + i;
			elencoCandidati.add(nomeCand);
		}

		for (int i = 0; i < NOMI_LISTE.length; i++) {
			listeEffettive.put(NOMI_LISTE[i], new ListaElettorale<String>(
					NOMI_LISTE[i], elencoCandidati));
		}

		for (int i = 0; i < listeEffettive.size(); i++) {
			lista = listeEffettive.get(NOMI_LISTE[i]);
			e.aggiungiLista(lista);
		}

		for (int i = 0; i < ELETTORI; i++) {
			Random r = new Random();
			TipoVoto votoEffettivo;
			int choose = r.nextInt(PROB_VOTO);
			if (choose<8)
				votoEffettivo = TipoVoto.VALIDA;
			else 
				if (choose>=8 && choose<9)
					votoEffettivo = TipoVoto.BIANCA;
				else
					votoEffettivo=TipoVoto.NULLA;

			if (votoEffettivo == TipoVoto.VALIDA) {
				int numLista = r.nextInt(PROB_LISTA);
				v = new Voto(listeEffettive.get(NOMI_LISTE[numLista]));
			} else {
				if (votoEffettivo == TipoVoto.BIANCA) {
					v = new Voto();
				} else {
					v = new Voto(null);

				}
			}
			e.scrutinaVoto(v);
		}
		
		System.out.println("Le schede bianche sono: " + e.bianche());
		System.out.println("Le schede nulle sono: " + e.nulle());
		System.out.println("\n- Liste e numero voti -");
		LinkedList<ListaElettorale> listaOrdinata = (LinkedList<ListaElettorale>) e.elencoOrdinato();
		for (Object o : listaOrdinata) {
			ListaElettorale<String> l = (ListaElettorale<String>) o;
			l.stampaNomeLista();		
			System.out.println(" voti : "+ e.numVoti(l));
		}
	}
}

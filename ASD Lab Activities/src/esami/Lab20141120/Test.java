package esami.Lab20141120;

public class Test {

	final static String[] LISTA_AUTORI = {
			"Camil Demetrescu, Umberto Ferraro Petrillo, Irene Finocchi, Giuseppe F. Italiano",
			"Alan Bertossi", "Deitel & Deitel", "John Lewis, Joseph Chase" };
	final static String[] LISTA_TITOLI = {
			"Progetto di algoritmi e strutture dati in Java",
			"Algoritmi e Strutture di Dati", "Programmazione Java: Fondamenti",
			"Java Software Structures" };
	final static String[] LISTA_CASAED = { "McGraw Hill",
			"CittaStudi Edizioni", "Pearson-Prentice Hall", "Pearson Education" };
	final static int[] LISTA_ANNI = { 2007, 2009, 2008, 2010 };
	final static int[] copie = { 2, 1, 3, 2 };

	final static int POS_MAX = 100;
	final static int SCAF_MAX = 20;
	final static int ARM_MAX = 10;

	static int LASTPOS = 1;
	static int LASTSCAF = 1;
	static int LASTARM = 1;

	static String posGen() {
		String posizione = "";
		if (LASTPOS == POS_MAX) {
			LASTSCAF++;
			LASTPOS = 1;
			if (LASTSCAF == SCAF_MAX) {
				LASTSCAF = 1;
				LASTARM++;
			}
		}

		posizione = "ARMADIO: " + LASTARM + ", SCAFFALE: " + LASTSCAF
				+ ", POSIZIONE: " + LASTPOS;

		LASTPOS++;
		return posizione;
	}

	public static void main(String[] args) {
		Biblioteca bib = new Biblioteca();

		for (int i = 0; i < LISTA_AUTORI.length; i++) {
			AddOnlyList<String> listaAutori = new DoubleLinkedList<String>();
			String[] autori = LISTA_AUTORI[i].split(", ");
			for (int j = 0; j < autori.length; j++) {
				listaAutori.add(autori[j]);
			}
			Volume v = new Volume(LISTA_TITOLI[i], LISTA_CASAED[i],
					LISTA_ANNI[i], listaAutori);

			for (int k = 0; k < copie[i]; k++) {
				bib.addVol(posGen(), v);
			}
		}
		AddOnlyList<String> autori = new DoubleLinkedList<String>();
		autori.add("John Lewis");
		autori.add("Joseph Chase");
		Volume v = new Volume("Java Software Structures", "Pearson Education,", 2010, autori);
		
		/*
		 *TODO: Verificare il prestito di un libro 
		 */
//		AddOnlyList<String> posizioni = bib.posizione(v);
//		String pos = null;
//		for (String e: posizioni) {
//			pos = e;
//			break;
//		}
//		bib.prestito(pos);
		System.out.println("--- Lista volumi biblioteca ---");
		for (Object e: bib) {
			String s = e.toString();
			Volume vol= bib.volume(s);
			
			System.out.println(vol.listaAutori.toString());
			System.out.println(vol.titolo);
			System.out.println(vol.casaEditrice);
			System.out.println(vol.annoPubb);
			System.out.println("Posizione: " + s);
			System.out.println("Disponibile: " + !bib.prestato(s));
			System.out.println("---");
		}
	}

}

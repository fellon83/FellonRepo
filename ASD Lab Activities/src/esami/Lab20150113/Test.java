package esami.Lab20150113;

public class Test {

	static private String[] dizionario = { "pane", "burro", "marmellata",
			"biscotti", "patatine", "aranciata", "cioccolata", "prosciutto",
			"formaggio" };

	static int colonne = dizionario.length;
	static int righe = 4;
	static int valoreDefault = 0;
	final static int presente = 1;

	public static void main(String[] args) {

		String[] carrello1 = { "pane", "burro", "formaggio" };
		String[] carrello2 = { "cioccolata", "biscotti", "patatine" };
		String[] carrello3 = { "prosciutto", "formaggio", "aranciata" };
		String[] carrello4 = { "pane", "prosciutto", "marmellata", "formaggio",
				"patatine" };
		Object[] carrelli = { carrello1, carrello2, carrello3, carrello4 };

		MatriceSparsa<Integer> ms = new MatriceSparsa(colonne, righe,
				valoreDefault);

		for (int i = 0; i < carrelli.length; i++) {
			String[] tmp = (String[]) carrelli[i];
			for (int j = 0; j < tmp.length; j++) {
				for (int k = 0; k < dizionario.length; k++) {

					if (tmp[j].equalsIgnoreCase(dizionario[k])) {
						ms.cambiaValore(i, k, presente);
						break;
					}

				}
			}

		}

		System.out.println("\n - Similarità - ");
		for (int carr = 0; carr < carrelli.length - 1; carr++) {
			for (int carrSucc = carr + 1; carrSucc < carrelli.length; carrSucc++) {
				int similarita = 0;
				for (int col = 0; col < ms.numColonne(); col++) {
					if ((((Integer) ms.valore(carr, col)).equals(presente))
							&& ((Integer) ms.valore(carr, col))
									.equals((Integer) ms.valore(carrSucc, col)))

						similarita++;
				}
				System.out.println("Similarità tra carrello " + (carr + 1)
						+ " e carrello " + (carrSucc + 1) + " è " + similarita);

			}
			
		}

		System.out.println("\n");
		System.out.println("I valori significati della matrice sparsa sono: " + ms.numValoriSignificativi() + "\n");
		
		System.out.println("- Matrice sparsa - ");
		int count = 0;
		for (Object i : ms) {

			System.out.print(i + " ");
			count++;
			if (count == ms.numColonne()) {
				System.out.println("\n");
				count = 0;
			}

		}
		ms.cambiaValore(0, 0, 1);

	}
}

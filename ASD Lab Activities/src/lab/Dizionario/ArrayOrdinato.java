package lab.Dizionario;

public class ArrayOrdinato implements Dizionario {

	Coppia[] s = new Coppia[0];

	private class Coppia {
		Object elem;
		Comparable key;

		Coppia(Object e, Comparable k) {
			elem = e;
			key = k;
		}
	}

	public void insert(Object e, Comparable k) {
		if (search(k) == null) {
			int i, j;

			Coppia[] temp = new Coppia[s.length + 1];
			Coppia o = new Coppia(e, k);
			for (i = 0; i < s.length; i++) {
				temp[i] = s[i];
			}
			s = temp;
			for (i = 0; i < s.length - 1; i++) {
				if (s[i].key.compareTo(k) >= 0)
					break;

			}
			for (j = s.length - 1; j > i; j--) {
				s[j] = s[j - 1];
			}

			s[i] = o;
		}

	}

	public void delete(Comparable k) {
		if (search(k) != null) {
			Coppia[] temp = new Coppia[s.length - 1];
			int i, j;
			for (i = 0; i < s.length - 2; i++) {
				if (!(s[i].key.equals(k))) {
					temp[i] = s[i];
				} else {
					break;
				}
			}
			for (j = i; j < s.length - 1; j++) {
				temp[j] = s[j + 1];
			}

			s = temp;
		}

	}

	public Object search(Comparable k) {
		int i = 0;
		int j = s.length;
		int m;

		while (i < j) {
			m = (i + j) / 2;
			if (k.equals(s[m].key)) {
				return s[m].elem;
			} else {
				if (k.compareTo(s[m].key) < 0) {
					j = m;
				} else {
					i = m + 1;
				}

			}
		}
		return null;

	}

	public static void main(String args[]) throws InterruptedException {

		/*
		d.insert("1234", "Antonio");
		d.insert("4567", "Mario");
		d.insert("8901", "Giovanni");
		d.insert("2345", "Filippo");
		d.insert("6789", "Gianfranco");

		System.out.println(d.search("Antonio").toString());
		System.out.println(d.search("Mario").toString());

		d.delete("Mario");
		d.delete("Giovanni");
		d.delete("Filippo");
		d.delete("Gianfranco");

		d.insert("4567", "Mario");
		d.insert("8901", "Giovanni");
		 */
		
		
		String nome, numero;
		boolean flag = true;
		Dizionario d = new ArrayOrdinato();
		
		while (flag) {
			System.out.println("\n* * * Operazioni disponibili * * *\n");
			System.out.println("1. Inserimento");
			System.out.println("2. Cancellazione");
			System.out.println("3. Ricerca\n");
			System.out.println("0. Uscita");
			System.out.print("\n\n Scelta: ");
			int scelta = Keyboard.readInt();

			switch (scelta) {
			case 1:
				System.out.println("\n* * * Inserimento * * *\n");
				System.out.print("\nIserisci il numero: ");
				numero = Keyboard.readString();
				System.out.print("Inserisci il nome: ");
				nome = Keyboard.readString();
				d.insert(numero, nome);
				System.out.println("\nInserimento effettuato.");
				break;
			case 2:
				System.out.println("* * * Cancellazione * * *\n");
				System.out.print("\nInserisci il nome: ");
				nome = Keyboard.readString();
				d.delete(nome);
				System.out.println("\nCancellazione effettuata.");
				break;
			case 3:
				System.out.println("\n* * * Ricerca * * *\n");
				System.out.print("\nInserisci il nome: ");
				nome = Keyboard.readString();
				Object risultato = d.search(nome);
				if (risultato != null)
					System.out.println("Il numero è: " + risultato.toString());
				else
					System.out.println("Nessun risultato!");
				break;
			case 0:
				flag = false;
				System.out.println("Uscita effettuata!");
				break;
			default:
				System.out.println("Scelta errata! Riprova!");
				break;
			}
		}
	}

}
package strutture.Dizionario;

public class ArrayDoubling implements Dizionario {

	int numElementi = 0;
	Coppia[] s = new Coppia[1];

	private class Coppia {
		Object elem;
		Comparable chiave;

		Coppia(Object e, Comparable c) {
			this.elem = e;
			this.chiave = c;
		}

	}

	public void insert(Object e, Comparable k) {
		if (search(k) == null) {
			if (numElementi == s.length) {
				Coppia[] temp = new Coppia[s.length * 2];
				for (int i = 0; i < numElementi; i++) {
					temp[i] = s[i];
				}
				s = temp;
			}
			s[numElementi] = new Coppia(e, k);
			numElementi++;
		}
	}

	public void delete(Comparable k) {
		int i;
		for (i = 0; i < numElementi; i++) {
			if (s[i].chiave.equals(k)) {
				break;
			}
		}
		for (int j = i; j < numElementi - 1; j++) {
			s[j] = s[j + 1];
		}
		numElementi--;
		if ((numElementi > 1) && (numElementi <= s.length / 4)) {
			Coppia[] temp = new Coppia[s.length / 2];
			for (i = 0; i < numElementi; i++) {
				temp[i] = s[i];
			}
			s = temp;
		}

	}

	public Object search(Comparable k) {
		for (int i = 0; i < numElementi; i++) {
			if (s[i].chiave.equals(k))
				return s[i].elem;
		}
		return null;
	}

	public static void main(String args[]) {
		Dizionario d = new ArrayDoubling();
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
	}

}

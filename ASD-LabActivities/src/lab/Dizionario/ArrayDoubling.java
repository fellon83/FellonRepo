package lab.Dizionario;

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
		if (search(k) != null) {
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
		int i, j;
		for (i = 0; i < numElementi; i++) {
			if (s[i].chiave.equals(k)) {
				break;
			}
		}
		for (j = i; j < numElementi - 1; j++) {
			s[j] = s[j + 1];
		}
		numElementi--;
		if ((numElementi > 1) && (numElementi <= s.length / 4)) {
			Coppia[] temp = new Coppia[s.length / 4];
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
		ArrayDoubling d = new ArrayDoubling();
		d.insert("Fedele", "+393492615513");
		d.insert("Kim", "+393926869540");
		d.insert("Mamma", "+393280281100");
		d.insert("Babbo", "+393388401402");
		d.insert("Pippo", "+393331234567");

		System.out.println(d.search("+393492615513").toString());
		System.out.println(d.search("+393926869540").toString());

		d.delete("+393926869540");
		d.delete("+393280281100");
		d.delete("+393388401402");
		d.delete("+393331234567");

		d.insert("Kim", "+393926869540");
		d.insert("Mamma", "+393280281100");
	}

}

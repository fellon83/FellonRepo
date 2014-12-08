package lab.Dizionario;

import java.util.HashMap;

public class HashMapDict implements Dizionario {
	
	HashMap<Comparable, Object> coppia = new HashMap<>();
	
	
	
	public void insert(Object e, Comparable k) {
		coppia.put(k, e);

	}

	@Override
	public void delete(Comparable k) {
		coppia.remove(k);

	}

	@Override
	public Object search(Comparable k) {
		return coppia.get(k);
	}

	
	public static void main (String[] args) {
		HashMapDict d = new HashMapDict();
		
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

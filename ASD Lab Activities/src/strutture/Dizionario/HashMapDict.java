package strutture.Dizionario;

import java.util.HashMap;

/*
 * 
 * Realizzazione esterna agli algoritmi previsti dal lab
 * utilizzabile per strutture dati che si basano sull'HashMap 
 * previsto nelle librerie di Java
 *
 *
 */

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
		Dizionario d = new HashMapDict();
		
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

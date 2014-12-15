package strutture.Dizionario.HashTable;

public class ScansioneLineare implements Scansione {

	@Override
	public int c(int hk, int i, int n) {
		return ((hk+i) % n);
	}

}

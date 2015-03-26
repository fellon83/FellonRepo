package esami.Lab20140904;

public class ItemNotPresent extends RuntimeException {

	public ItemNotPresent (String e) {
		super(e);
	}
	
	public ItemNotPresent() {
		super();
	}
}

package esami.Lab20140904;

public class ItemAlreadyPresent extends RuntimeException {
	public ItemAlreadyPresent() {
		super();
	}
	
	public ItemAlreadyPresent(String e) {
		super(e);
	}
}

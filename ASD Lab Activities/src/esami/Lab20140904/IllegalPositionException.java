package esami.Lab20140904;

public class IllegalPositionException extends RuntimeException {
	public IllegalPositionException (String e) {
		super(e);
	}
	
	public IllegalPositionException() {
		super();
	}
}

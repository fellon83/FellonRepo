package esami.Lab20131121;

public class RecordAlreadyPresentException extends RuntimeException {
	public RecordAlreadyPresentException() {
		super();
	}

	public RecordAlreadyPresentException(String e) {
		super(e);
	}
}

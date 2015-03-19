package esami.Lab20150224;

public class PunteggioNonValidoException extends RuntimeException {
	
public PunteggioNonValidoException(String e) {
	System.err.println(e);
		
	}
	
	public PunteggioNonValidoException() {
		
	}

}

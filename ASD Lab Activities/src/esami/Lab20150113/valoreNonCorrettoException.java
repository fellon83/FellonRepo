package esami.Lab20150113;

public class valoreNonCorrettoException extends RuntimeException {
	
	public valoreNonCorrettoException(String e) {
	 System.err.println(e);
	}
	
	public valoreNonCorrettoException() {
		
	}

}

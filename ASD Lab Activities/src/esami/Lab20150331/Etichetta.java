package esami.Lab20150331;

import esami.Lab20150331.Albero.EccezioneNodoNonValido;

public class Etichetta {
	private String attributo;
	private String predicato;
	private String decisione;
	
	Etichetta(String decisione) {
		this.decisione=decisione;
	}
	
	Etichetta(String attributo, String valore) {
		this.attributo=attributo;
		this.predicato=attributo + "=" +valore;
		
	}
	
	public boolean isDecisione(){
		return decisione==null;
	}
	
	public String decisione() {
		return decisione;
	}
	
	public boolean testProprietà(String attributo, String valore) {
		return predicato.equals(attributo+"="+valore);
	}

	public boolean ugualeAttributo(String attributo) {
		return this.attributo==attributo;
	}
}

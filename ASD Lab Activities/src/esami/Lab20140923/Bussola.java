package esami.Lab20140923;

public class Bussola {
	
	CircList<Cardinale> ago;
	
	public Bussola() {
		ago = new ListaCircDC<Cardinale>();
		
		for (Cardinale e : Cardinale.values()) {
			ago.addCircList(e);
			
		}
	}

	public void ruotaA(){
		ago.ruotaAvanti();
	}
	
	public void ruotaI(){
		ago.ruotaIndietro();
	}
	
	public Cardinale direzione() {
		
		return ago.value();
	}
}

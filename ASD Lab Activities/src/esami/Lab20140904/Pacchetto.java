package esami.Lab20140904;

public class Pacchetto {
	Utente mittente;
	Utente destinatario;
	int identificativo;
	String dati;
	boolean ultimo;

	public Pacchetto(Utente mittente, Utente destinatario, int id, String dati,
			boolean flag) {

		this.mittente=mittente;
		this.destinatario=destinatario;
		this.identificativo=id;
		this.dati=dati;
		this.ultimo=flag;
	}

}

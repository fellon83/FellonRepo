package esami.Lab20141120;

public class Volume {
	String titolo;
	String casaEditrice;
	int annoPubb;
	AddOnlyList<String> listaAutori;

	public Volume(String titolo, String casaEditrice, int annoPubb,
			AddOnlyList<String> listaAutori) {
		this.titolo = titolo;
		this.casaEditrice = casaEditrice;
		this.annoPubb = annoPubb;
		this.listaAutori = listaAutori;
	}

	public boolean compareVolume(Volume v) {
		boolean titolo = this.titolo.equals(v.titolo);
		boolean casaEditrice = this.casaEditrice.equals(v.casaEditrice);
		boolean anno = this.annoPubb == v.annoPubb;
		boolean autori = this.listaAutori.toString().equals(
				v.listaAutori.toString());
		return (titolo && casaEditrice && anno && autori);
	}

}

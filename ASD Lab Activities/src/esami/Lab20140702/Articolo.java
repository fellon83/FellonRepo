package esami.Lab20140702;

public class Articolo {
	private AddOnlyList<String> autori;
	private int volume;
	
	public Articolo() {
		this.autori = new VectorList<String>();

	}
	
	public void addAutore(String autore) {
		autori.add(autore);
	}
	
	public void setVolume (int vol) {
		this.volume=vol;
	}
	
	public String printAutori() {
		return autori.toString();
	}
	
	public int getVolume() {
		return volume;
	}
}

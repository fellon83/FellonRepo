package esami.Lab20140702;

public class Rivista {

	protected Dictionary<String, Articolo> articoli;
	protected Dictionary<Integer, Boolean> volumi;

	final boolean PUBBLICATO = true;
	final boolean NON_PUBBLICATO = false;

	public Rivista() {
		articoli = new LinkedDict<String, Articolo>();
		volumi = new LinkedDict<Integer, Boolean>();
	}

	public boolean rivistaNuova() {
		boolean flag = false;
		for (Object e : volumi) {
			int vol = (Integer) e;
			flag = volumi.search(vol);

		}
		return flag;
	}

	public void addArt(String titolo, int volume) {
		if (volumi.search(volume)==null)
			volumi.insert(volume, NON_PUBBLICATO);
		if (articoli.search(titolo) != null)
			throw new EccezioneArticoloPresente ("Articolo già presente");
		Articolo a = new Articolo();
		a.setVolume(volume);
		
		articoli.insert(titolo, a);

	}

	public void addAut(String titolo, String autore) {
		Articolo a = articoli.search(titolo);
		if (a == null)
			throw new EccezioneArticoloNonPresente("Articolo non registrato");
		int vol = a.getVolume();
		if (volumi.search(vol))
			throw new EccezioneVolumePubblicato("Volume già pubblicato");
		a.addAutore(autore);
	}

	public void pubblicaVol(int volume) {
		if (pubblicato(volume))
			throw new EccezioneVolumePubblicato("Volume già pubblicato");
		volumi.delete(volume);
		volumi.insert(volume, PUBBLICATO);

	}
	
	public String toString () {
		String stampa="";
		for (String s : articoli) {
			Articolo a = articoli.search(s);
			stampa += "Autori: " + a.printAutori() + "\n";
			stampa += "Titolo: " + s + "\n";
			stampa += "Volume: " + String.valueOf(a.getVolume()) +"\n\n";
		}
		
		return stampa;
	}

	public boolean pubblicato(int vol) {
		return volumi.search(vol);
	}

}

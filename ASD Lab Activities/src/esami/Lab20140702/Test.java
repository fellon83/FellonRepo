package esami.Lab20140702;

public class Test {

	public static void main(String[] args) {

		Rivista riv = new Rivista();

		try {
		riv.addArt("A Relational perspective on spatial data mining", 1);
		riv.addArt("Multi-label large margin hierarchical perceptron", 1);
		riv.addArt("Privacy preserving record linkage approaches", 2);		
		riv.addArt("On the selection of k efficient paths by clustering techniques",
				3);
		}catch (EccezioneArticoloPresente e) {
			System.err.println(e.getMessage());
			
		}

		
		try {
		riv.addAut("A Relational perspective on spatial data mining",
				"Donato Malerba");
		riv.addAut("Multi-label large margin hierarchical perceptron",
				"Clay Woolam");
		riv.addAut("Multi-label large margin hierarchical perceptron",
				"Latifur Khan");
		riv.addAut("Privacy preserving record linkage approaches",
				"Vassilios S. Verykios");
		riv.addAut("Privacy preserving record linkage approaches",
				"Alexandros Karakasidis");
		riv.pubblicaVol(2);
		riv.addAut("Privacy preserving record linkage approaches",
				"Vassilios K. Mitrogiannis");
		riv.addAut("On the selection of k efficient paths by clustering techniques",
				"Massimiliano Caramia");
		riv.addAut("On the selection of k efficient paths by clustering techniques",
				"Stefano Giordani");
		} catch (EccezioneArticoloNonPresente e) {
			System.err.println(e.getMessage());
		}catch (EccezioneVolumePubblicato e) {
			System.err.println(e.getMessage());
		}

		try {
		riv.pubblicaVol(1);
		riv.pubblicaVol(2);
		riv.pubblicaVol(3);
		} catch (EccezioneVolumePubblicato e) {
			System.err.println(e.getMessage());
		}
		
		System.out.println(riv.toString());
	}
}

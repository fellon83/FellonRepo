package esami.Lab20140904;

import java.util.ArrayList;
import java.util.Random;

public class SkypeTest {

	final static String frase1 = "Questo programma fa schifo assai tantissimo molto";
	final static String frase2 = "Lorem ipsum dolor sit amet, consectetur adipisci elit, sed";
	final static String frase3 = "Cantami, o'diva, del pelide Achille l'ira funesta che infiniti addusse lutti agli Achei";

	public static void main(String[] args) {

		Skype com1 = new Skype();
		Skype com2 = new Skype();
		Skype com3 = new Skype();
		
		String[] dati1 = frase1.split(" ");
		String[] dati2 = frase2.split(" ");
		String[] dati3 = frase3.split(" ");
	
		Utente<String> mitt = new Utente<String>("Mittente");
		Utente<String> dest = new Utente<String>("Destinatario");
		
		ArrayList<Pacchetto> p1 = new ArrayList<Pacchetto>();
		ArrayList<Pacchetto> p2 = new ArrayList<Pacchetto>();
		ArrayList<Pacchetto> p3 = new ArrayList<Pacchetto>();
		
		for (int i=0; i<dati1.length; i++) {
			boolean flag = (i==dati1.length-1);				
			p1.add(new Pacchetto(mitt, dest, i, dati1[i], flag));
			
		}
		
		for (int i=0; i<dati2.length; i++) {
			boolean flag = (i==dati2.length-1);				
			p2.add(new Pacchetto(mitt, dest, i, dati2[i], flag));
			
		}
		
		for (int i=0; i<dati3.length; i++) {
			boolean flag = (i==dati3.length-1);				
			p3.add(new Pacchetto(mitt, dest, i, dati3[i], flag));
			
		}
	
		int i=0;
		while (i<7) {
			int ind = new Random().nextInt(p1.size());
			com1.addPacchetto(p1.get(ind));
			p1.remove(ind);
			i++;
		}
		
		System.out.println("Comunicazione 1: " + com1.toString());
		
		i=0;
		while (i<9) {
			int ind = new Random().nextInt(p2.size());
			com2.addPacchetto(p2.get(ind));
			p2.remove(ind);		
			i++;
		}
		
		System.out.println("Comunicazione 2: " + com2.toString());
		
		i=0;
		while (i<13) {
			int ind = new Random().nextInt(p3.size());
			com3.addPacchetto(p3.get(ind));
			p3.remove(ind);
			i++;
		}
	
		System.out.println("Comunicazione 3: " + com3.toString());
		
		
		if (com1.compareTo(com2)<0)
			System.out.println("Com1 < Com2");
		else
			if (com1.compareTo(com2)>0 )
			 System.out.println("Com1 > Com2");
			else 
				System.out.println("Le due stringhe sono uguali");
	}
}

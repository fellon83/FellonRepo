package esami.Lab20140415;

import java.util.Iterator;

public class Test {

	

	public static void main (String[] args) {
		
		String txt1 = "Questo è un sistema innovativo per la scoperta automatica di plagi";
		String txt2 = "Questo sistema innovativo permette la scoperta automatica di plagi";
		String txt3 = "Questo sistema non fa proprio nulla di interessante";
		
		BagOfWords bag1 = new BagOfWords();
		BagOfWords bag2 = new BagOfWords();
		BagOfWords bag3 = new BagOfWords();
		
		bag1.addText(txt1);
		bag2.addText(txt2);
		bag3.addText(txt3);
		
		System.out.print("Bag1:");
		Iterator<String> it = bag1.bagOfWords.iterator();
		while (it.hasNext()) {
			System.out.print(it.next() + " " );			
		}
		
		System.out.print("\n\nBag2:");
		it = bag2.bagOfWords.iterator();
		while (it.hasNext()) {
			System.out.print(it.next() + " " );			
		}
		
		System.out.print("\n\nBag3: ");
		it = bag3.bagOfWords.iterator();
		while (it.hasNext()) {
			System.out.print(it.next() + " " );			
		}
		
		float sim12 = bag1.similarita(bag2);
		float sim13 = bag1.similarita(bag3);
		float sim23 = bag2.similarita(bag3);
 		
		System.out.println("\n\nLa similiratià tra la stringa 1 e 2 è: " + sim12);
		System.out.println("La similiratià tra la stringa 1 e 3 è: " + sim13);
		System.out.println("La similiratià tra la stringa 2 e 3 è: " + sim23);
	}

}

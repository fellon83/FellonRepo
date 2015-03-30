package esami.Lab20130221;

import java.util.HashMap;
import java.util.Random;

import esami.Lab20130221.Articoli.*;
import esami.Lab20130221.Carrello.Carrello;
import esami.Lab20130221.Carrello.Item;
import esami.Lab20130221.Market.MarketBasketAnalysis;

public class Test {

	public static void main(String[] args) {

		HashMap<Integer, Object> articoli = new HashMap<Integer, Object>();
		articoli.put(0, new Pane());
		articoli.put(1, new Burro());
		articoli.put(2, new Spaghetti());
		articoli.put(3, new Cereali());
		articoli.put(4, new Sapone());
		articoli.put(5, new Dentifricio());
		articoli.put(6, new Tovagliolini());
		articoli.put(7, new Piatti());
		
		MarketBasketAnalysis mba = new MarketBasketAnalysis();
		
		Random r = new Random();
		
		for (int i=0; i<10; i++) {
			Carrello<Item> c = new Carrello<Item>();
			System.out.println("---Carrello " + (i+1) + "---");
			for (int k=0; k<r.nextInt(5)+2; k++) {
				Item itm = new Item((Articolo) articoli.get(r.nextInt(8)), r.nextInt(4)+1);
				c.add(itm);
			}
			mba.add(c);
			System.out.println();
		}
		
		System.out.println(mba.toString());
		System.out.println();

	}
}

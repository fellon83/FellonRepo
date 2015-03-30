package esami.Lab20130221.Market;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import com.sun.javafx.collections.MappingChange.Map;

import esami.Lab20130221.Articoli.Articolo;
import esami.Lab20130221.Carrello.*;
import esami.Lab20130221.Articoli.*;

public class MarketBasketAnalysis {

	HashMap<Class, Integer> qTotArticolo;

	public MarketBasketAnalysis() {
		qTotArticolo = new HashMap<Class, Integer>();
		qTotArticolo.put(Alimenti.class, 0);
		qTotArticolo.put(Igiene.class, 0);
		qTotArticolo.put(Casalinghi.class, 0);
	}

	public void add(Carrello<Item> trolley) {
		for (Item a : trolley) {
			int quanArt = 0;
			System.out.println(String.valueOf(a.getArticolo().getClass()
					.getSimpleName()));
			Class artClass = a.getArticolo().getClass();
			if (qTotArticolo.get(artClass) != null) {
				quanArt = a.getQuantita();
				qTotArticolo.replace(artClass, qTotArticolo.get(artClass) + quanArt);
			} else {
				quanArt = a.getQuantita();
				qTotArticolo.put(artClass, quanArt);
			}
			if (a.getArticolo() instanceof Alimenti) {
				qTotArticolo.replace(Alimenti.class,
						qTotArticolo.get(Alimenti.class) + quanArt);
			}
			if (a.getArticolo() instanceof Casalinghi) {
				qTotArticolo.replace(Casalinghi.class,
						qTotArticolo.get(Casalinghi.class) + quanArt);
			}
			if (a.getArticolo() instanceof Igiene) {
				qTotArticolo.replace(Igiene.class,
						qTotArticolo.get(Igiene.class) + quanArt);
			}
		}
	}

	public String toString() {
		String str = "";
		for (Class c : qTotArticolo.keySet()) {
			str += c.getSimpleName() + "   "
					+ qTotArticolo.get(c) + "\n";
		}
		return str;
	}
}


package temp2;

public class Test {

	
	public static void main(String[] args){ 
		
		Market negozio = new Market(12);
		
		
		Articolo[] merce = new Articolo[12];
		merce[0] = new Articolo("pane","1 kg");
		merce[1] = new Articolo("pasta","500 g");
		merce[2] = new Articolo("latte","1L");
		merce[3] = new Articolo("uova","100 g");
		merce[4] = new Articolo("prosciutto","200 g");
		merce[5] = new Articolo("sapone","70 cl");
		merce[6] = new Articolo("acqua","2L");
		merce[7] = new Articolo("cola","50 cl");
		merce[8] = new Articolo("zucchero","500 g");
		merce[9] = new Articolo("sale","500 g");
		merce[10] = new Articolo("olio","1 L");
		merce[11] = new Articolo("vino","1 L");
		
		Carrello<Articolo> a = new Carrello<Articolo>();
		a.aggArticolo(merce[1]);
		a.aggArticolo(merce[1]);
		a.aggArticolo(merce[4]);
		
		Carrello<Articolo> b = new Carrello<Articolo>();
		b.aggArticolo(merce[3]);
		b.aggArticolo(merce[8]);
		b.aggArticolo(merce[11]);
		
		Carrello<Articolo> c = new Carrello<Articolo>();
		c.aggArticolo(merce[11]);
		c.aggArticolo(merce[2]);
		c.aggArticolo(merce[2]);
		
		Carrello<Articolo> d = new Carrello<Articolo>();
		d.aggArticolo(merce[1]);
		d.aggArticolo(merce[5]);
		d.aggArticolo(merce[9]);
		
		Carrello[] carrelli = {a,b,c,d};
		
		negozio.merce = merce;
		negozio.acquisti = carrelli;
		
		negozio.stampa();
		negozio.istogramma();
		
	}
	
}

package temp2;

import java.util.Iterator;

public class Carrello<T> implements Iterable<Articolo> {

	protected Dictionary<Integer> carrello;
	
	
	public Carrello(){ 
		
		carrello = new LinkedDict<Integer>();
		
	}
	 
	public void aggArticolo(Articolo a){ 
		
		/*if(carrello.search(a) == null){
			carrello.insert(a,0);
		}else { 
			int qt = (Integer) carrello.search(a);
			carrello.delete(a);
			carrello.insert(a,qt+1);
			
		}*/
		Object s = carrello.search(a);
		int qArt = 0;
		if (s!=null)
			qArt = (Integer) s;
		
		if (qArt > 0) {
			carrello.delete(a);
		} 
		qArt++;
		carrello.insert(a, qArt);
		
	 }
	public void togliArticolo(Articolo a){ 
		try{
		carrello.delete(a);
		}catch (EccezioneArticoloNonPresente e){ 
			System.err.println(e.getMessage());
		}
		
		/*int qArt = (Integer) carrello.search(a);
		if (qArt==0)
			return;
		qArt--;
		carrello.delete(a);
		if (qArt>0) 
			carrello.insert(a, qArt);*/
		
	 }
	public int quantit‡(Articolo a) { 
		
		 if(carrello.search(a) == null){ 
			 throw new EccezioneArticoloNonPresente("elemento non presente");
		 }else{ 
			
			 return carrello.search(a);
		 }
		 
	 }
	public boolean ËVuoto() { 
		
		 return carrello == null;
		 
	 }
	public boolean appartiene(Articolo a) { 
		 
		 return carrello.search(a) == null;
		 
	 }
	public int numArticoliDistinti(){ 
		 
		if(carrello == null){ 
			throw new EccezioneStrutturaVuota("struttura vuota");
		}
		 int num = 0;
		 Articolo art;
		 for(Object p : carrello){ 
			 art = (Articolo) p;
			 if(carrello.search(art) == 1){ 
				 num++;
			 }
			 
			 
		 }
		 return num;
		 
	 }
	
	
    public Iterator<Articolo> iterator() {
		
		
		return new Iterator<Articolo>(){

			
			Iterator<Comparable> it = carrello.iterator();

			@Override
			public boolean hasNext() {
				return it.hasNext();
			}

			@Override
			public Articolo next() {
				return (Articolo)it.next();
			}
			@Override
			public void remove() {
				// TODO Auto-generated method stub
				
			} 
			
		};
	}

}

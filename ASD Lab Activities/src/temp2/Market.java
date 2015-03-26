package temp2;

public class Market {

	protected Articolo[] merce;
	protected Carrello[] acquisti;

	public Market(int nroAcq){ 
		
		acquisti = new Carrello[nroAcq];
		
	}

	public void stampa(){ 
		
		System.out.println("acquisti: \n");
		
		int i = 1;
		
		for(Carrello<Articolo> c : acquisti){ 
			
			System.out.println("carrello " + i + " : \n");
			
			for(Articolo p : c){ 
				
				System.out.println(p.toString());
				
			}
			
			i++;
		
		}
		
		
	}
	
	public void istogramma(){ 
		
		for(Articolo art: merce){
			
			int quantità = 0;
			
			for(Carrello<Articolo> c: acquisti){ 
				
				for(Articolo p : c){
				
					if(p.compareTo(art) == 0){ 
					
					quantità++;
				
				    }	
				}
			}
			
			System.out.println("Articolo: " + art.toString() + " Quantità : " + quantità);
	
		}
		
	}

	
	
}

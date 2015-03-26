package temp2;

public class Articolo implements Comparable{

	String nome;
	String misura; 
	
	public Articolo(String n,String m){ 

		this.nome = n;
		this.misura = m;
		
	}
	
	
	public String toString(){ 
		
		String str = nome + " " + misura ;
		
		return str;
	}
	
	
	@Override
	public int compareTo(Object o) {
		
		Articolo art = (Articolo) o;
		return this.toString().compareTo(art.toString());
		
	}
	

}

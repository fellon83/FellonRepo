package esami.Lab20150203;

import java.util.List;

public class ListaElettorale<T> implements Comparable<T> {
	
	private String nomeLista;
	private List candidati;
	
	public ListaElettorale(String nomeL, List listaCand) {
		candidati = listaCand;
		nomeLista = nomeL;
	}
	
	
	public void stampaNomeLista () {
		System.out.print(nomeLista.toUpperCase());
	}
	
	public int compareTo(T lista) {
		if ((this.nomeLista).compareTo(((ListaElettorale) lista).nomeLista)>0)
		return 1;
		else
			if ((this.nomeLista).compareTo(((ListaElettorale) lista).nomeLista)<0)
			return -1;
			else
				return 0;
	}

}

package strutture.Grafo;

import java.util.List;

public interface Grafo {
	
	public boolean grafoVuoto();
	public Nodo creaNodo(Object info);
	public Arco creaArco(Nodo x, Nodo y, Object info);
	public void aggiungiNodo(Nodo v);
	public void aggiungiArco(Arco a);
	public void rimuoviNodo(Nodo v);
	public void rimuoviArco(Arco a);
	public Object infoNodo(Nodo v);
	public Object infoArco(Arco a);
	public void cambiaInfoNodo(Nodo v, Object info);
	public void cambiaInfoArco(Arco a, Object info);
	public List nodiAdiacenti(Nodo v);
	public Arco arcoIncidente(Nodo u, Nodo v);

}

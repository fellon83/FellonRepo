package strutture.Grafo;

import java.util.LinkedList;
import java.util.List;

import strutture.Eccezioni.EccezioneArcoEsistente;
import strutture.Eccezioni.EccezioneNodoNonValido;

public class GrafoLA implements Grafo {

	private NodoLA[] nodi = new NodoLA[0];
	private ArcoLA[] archi = new ArcoLA[0];

	public boolean grafoVuoto() {
		return (nodi.length == 0);
	}

	
	public Nodo creaNodo(Object info) {

		NodoLA nodoLA = new NodoLA(info, null);
		return nodoLA;
	}

	
	public Arco creaArco(Nodo x, Nodo y, Object info) {
		if (checkNodo(x))
			throw new EccezioneNodoNonValido();
		if (checkNodo(y))
			throw new EccezioneNodoNonValido();
		if (arcoIncidente(x, y) != null)
			throw new EccezioneArcoEsistente();
		ArcoLA arcoLA = new ArcoLA((NodoLA) x, (NodoLA) y, info);
		return arcoLA;
	}

	private boolean checkNodo(Nodo v) {
		return ((v == null) || (((NodoLA) v).grafo != this));
	}

	
	public void aggiungiNodo(Nodo v) {
		if (v == null)
			throw new EccezioneNodoNonValido();
		NodoLA[] temp = new NodoLA[nodi.length + 1];
		((NodoLA) v).grafo = this;
		System.arraycopy(nodi, 0, temp, 0, nodi.length);
		temp[nodi.length] = (NodoLA) v;
		nodi = temp;

	}

	
	public void aggiungiArco(Arco a) {
		ArcoLA arcoLA = (ArcoLA) a;
		for (int i = 0; i < archi.length; i++) {
			if (archi[i] == a)
				throw new EccezioneArcoEsistente();
		}
		ArcoLA[] temp = new ArcoLA[archi.length + 1];
		System.arraycopy(archi, 0, temp, 0, archi.length);
		temp[archi.length] = arcoLA;
		archi = temp;
	}

	
	public void rimuoviNodo(Nodo v) {
		if (checkNodo(v))
			throw new EccezioneNodoNonValido();
		NodoLA nodo = (NodoLA) v;
		ArcoLA a1, a2;
		boolean found = false;
		int i;
		List<NodoLA> nodiAdiacenti = nodiAdiacenti(nodo);
		for (NodoLA n : nodiAdiacenti) {
			a1 = (ArcoLA) arcoIncidente(n, v);
			a2 = (ArcoLA) arcoIncidente(v, n);
			
			if( a1 != null) 
				rimuoviArco(a1);
			if (a2 != null)
				rimuoviArco(a2);
		}
		NodoLA[] temp = new NodoLA[nodi.length-1];
		
		for (i = 0; i < nodi.length; i++) {
			if (nodi[i] == nodo) {
				found = true;
				break;
			}
		}
		if (found) {
			System.arraycopy(nodi, i + 1, nodi, i, nodi.length - 1);
			System.arraycopy(nodi, 0, temp, 0, temp.length);
			nodi = temp;
		}
		
		
		
	}

	
	public void rimuoviArco(Arco a) {
		ArcoLA arco = (ArcoLA) a;
		int i;
		boolean found = false;
		ArcoLA[] temp = new ArcoLA[archi.length - 1];
		for (i = 0; i < archi.length; i++) {
			if (archi[i] == arco) {
				found = true;
				break;
			}
		}
		if (found) {
			System.arraycopy(archi, i + 1, archi, i, archi.length - 1);
			System.arraycopy(archi, 0, temp, 0, temp.length);
			archi = temp;
		}
	}

	
	public Object infoNodo(Nodo v) {
		if (!checkNodo(v))
			return ((NodoLA) v).info;
		return null;
	}

	
	public Object infoArco(Arco a) {
		return ((ArcoLA) a).info;
	}

	
	public void cambiaInfoNodo(Nodo v, Object info) {
		if (checkNodo(v))
			throw new EccezioneNodoNonValido();
		((NodoLA) v).info = info;

	}

	
	public void cambiaInfoArco(Arco a, Object info) {
		ArcoLA arcoLA = (ArcoLA) a;
		if (arcoIncidente(arcoLA.orig, arcoLA.dest) != null)
			throw new EccezioneArcoEsistente();

	}

	
	public List<NodoLA> nodiAdiacenti(Nodo v) {
		List<NodoLA> nodiAdiacenti = new LinkedList<NodoLA>();
		NodoLA nodo = (NodoLA) v;
		for (int i = 0; i < archi.length; i++) {
			if (archi[i].orig == nodo)
				nodiAdiacenti.add((NodoLA) archi[i].dest);
			if (archi[i].dest == nodo)
				nodiAdiacenti.add(nodo);

		}
		return nodiAdiacenti;
	}

	
	public Arco arcoIncidente(Nodo u, Nodo v) {
		if (checkNodo(v) || checkNodo(u))
			throw new EccezioneNodoNonValido();
		for (int i = 0; i < archi.length; i++) {
			if ((archi[i].orig == (NodoLA) u) && (archi[i].dest == (NodoLA) v))
				return archi[i];
		}
		return null;
	}

	public static void main (String[] args) {
		
		GrafoLA grafo = new GrafoLA();
		NodoLA n1 = new NodoLA("Bari", grafo);
		NodoLA n2 = new NodoLA("Milano", grafo);
		ArcoLA abm = new ArcoLA(n1, n2, 700);
		grafo.aggiungiNodo(n1);
		grafo.aggiungiNodo(n2);
		grafo.aggiungiArco(abm);
		
		grafo.rimuoviNodo(n1);
		System.out.println("Ciao");
		
	}
}

package strutture.Grafo;

public class NodoLA implements Nodo {
	public Object info;
	public GrafoLA grafo;

	public NodoLA(Object info, GrafoLA grafo) {
		this.info = info;
		this.grafo = grafo;
	}
}

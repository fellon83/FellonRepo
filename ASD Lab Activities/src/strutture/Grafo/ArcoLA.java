package strutture.Grafo;

public class ArcoLA implements Arco {
	
	public Object info;
	public NodoLA orig, dest;

	public ArcoLA(NodoLA x, NodoLA y, Object info) {
		this.info = info;
		orig = x;
		dest = y;
	}


}

package esami.Lab20130326;

public class Orologio<S> {
	protected CircQueue<S> orologioS;
	private int nFrazTot = 0;
	private int nFrazIns = 0;
	
	public Orologio(int n) {
		orologioS = new ArrayCircQueue<S>();
		nFrazTot = n;
	}
	
	public void add (S frazione) {
		if (isFull()) 
		throw new FullStructureException("Struttura piena");
		orologioS.add(frazione);
		nFrazIns++;
	}
	
	public S value () {
		return orologioS.value();
	}
	
	public boolean isFull() {
		return nFrazIns==nFrazTot;
	}
	
	public void rotateF(){
		try {
			orologioS.rotateF();
		} catch (EmptyStructureException e) {
			System.err.println(e.getMessage());
		}
		
	}
	
	public int size() {
		return orologioS.size();
	}
	
	public void stop() {
		orologioS.stop();
	}
	
	public void restart (){
		orologioS.restart();
	}
	
	public boolean equals(CircQueue<S> orol) {
		return this.equals(orol);
	}
}

package esami.Lab20130326;

public class Test {
	
	public static void main (String[] args) {
		
		
		OrologioDaPolso o1 = new OrologioDaPolso();
		OrologioDaPolso o2 = new OrologioDaPolso();
		
		o1.start();
		Ora ore1 = new Ora(String.valueOf(3));
		Minuto min1 = new Minuto(String.valueOf(59));
		
		o2.stopAt(ore1, min1);
		
		System.out.println("\no1 è uguale a o2: " + o1.equals(o2));
		
		o2.start();
		
		Ora ore2 = new Ora(String.valueOf(0));
		Minuto min2 = new Minuto(String.valueOf(0));
		
		o2.stopAt(ore2, min2);
		
		System.out.println("\no1 è uguale a o2: " + o1.equals(o2));
		
		
		
	}

}

package esami.Lab20130326;

public class OrologioDaPolso {
	Orologio<Ora> ore;
	Orologio<Minuto> minuti;
	
	private final int nOre = 24;
	private final int nMinuti = 60;
	
	public OrologioDaPolso () {
		ore = new Orologio<Ora>(nOre);
		minuti = new Orologio<Minuto>(nMinuti);
		
		//creazione delle frazioni
		int i=0;
		try {
		while (!ore.isFull()) {
			ore.add(new Ora(String.valueOf(i)));
			i++;
		}
		
		i=0;
		while (!minuti.isFull()) {
			minuti.add(new Minuto(String.valueOf(i)));
			i++;
		}
		}catch (FullStructureException e) {
			System.err.println(e.getMessage());
		}
		
		
		//stampa delle frazioni
		for (int k=0; k<ore.size(); k++) {
			System.out.print(ore.value().getNome() + " ");
			ore.rotateF();
		}
		System.out.println();
		
		for (int k=0; k<minuti.size(); k++) {
			System.out.print(minuti.value().getNome() + " ");
			minuti.rotateF();
		}
		System.out.println();
	}
	
	public void stopAt(Ora o, Minuto m) {
		String ora = o.getNome();
		String minuto = m.getNome();
		for (int i=0; i<ore.size(); i++) {
			if (ore.value().getNome().equals(ora)) {
				ore.stop();
				for (int k=0; k<minuti.size(); k++) {
					if (minuti.value().getNome().equals(minuto)) {
						minuti.stop();
						break;
					}
					else
						minuti.rotateF();
				}
			} else {
				ore.rotateF();
			}
		}
		System.out.println("Orario: " + ore.value().getNome() + ":" + minuti.value().getNome());
	}
	
	public void start(){
		ore.restart();
		minuti.restart();
	}
	
	public boolean equals (OrologioDaPolso o) {
		Orologio<Ora> ora = o.ore;
		Orologio<Minuto> minuti = o.minuti;
		boolean equalsOre = ora.equals(this.ore);
		boolean equalsMin =  minuti.equals(this.ore);;
		
		return equalsOre && equalsMin;
	}

}

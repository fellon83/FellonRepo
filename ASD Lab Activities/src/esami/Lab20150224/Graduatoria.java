package esami.Lab20150224;

public class Graduatoria {
	private ListaOrdinata graduatoria;

	public Graduatoria() {
		graduatoria = new WOListLinked();
	}

	public void aggG(Progetto prog, float punt) {
		Record<Progetto> r = new Record<Progetto>(prog, punt);
		graduatoria.insert(r);

	}

	public float primoV() {
		for (Object r : graduatoria) {
			Record p = (Record) r;
			if (p==null) throw new StrutturaVuotaException("La graduatoria Ë vuota.");
			return p.getPunteggio();
		}
		return 0;
	}

	public Progetto primoP() {
		boolean flag = true;
		for (Object r: graduatoria) {
			Record p = (Record) r;
			if (p==null) throw new StrutturaVuotaException("La graduatoria Ë vuota.");
			return (Progetto) p.getProgetto();			
		}
		
		return null;
	}

	public Graduatoria restoG() {
		Graduatoria resto = new Graduatoria();
		int c = ((Progetto) this.primoP()).getCodice();
		for (Object e : this.graduatoria) {
			Record r = (Record) e;
			Progetto tmp = (Progetto) r.getProgetto();
			if ((tmp.getCodice()) != c) {
				resto.aggG(tmp, r.getPunteggio());
			}
		}
		return resto;
	}

	public int dim() {
		return graduatoria.numElementi();
	}

	public boolean ËVuota() {
		return graduatoria.numElementi() == 0;
	}

	public float media() {
		float somma = 0;
		for (Object r : graduatoria) {
			Record tmp = (Record) r;
			somma = somma + tmp.getPunteggio();
		}
		return somma / (graduatoria.numElementi());
	}

	public boolean contenuta(Graduatoria sl) {
		ListaOrdinata secondaLista = sl.graduatoria;
		boolean flag = true;
		boolean present = true;
		for (Object r : secondaLista) {
			if (flag) {
				flag = false;
				Record tmp1 = (Record) r;
				for (Object l : this.graduatoria) {
					Record tmp2 = (Record) l;
					if (tmp1.compareTo(tmp2) == 0) {
						flag = true;
						break;
					}
				}
			} else {
				present = false;
				break;
			}
		}
		return present;
	}

}

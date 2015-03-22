package esami.Lab20150203;

import java.util.LinkedList;
import java.util.List;

public class Elezione {

	private int schedeBianche = 0;
	private int schedeNulle = 0;
	protected Dictionary<Integer> listeElettorali;

	public Elezione(int dim) {
		listeElettorali = new HashDict<Integer>(dim);
	}

	public void aggiungiLista(ListaElettorale<String> lista) {
		listeElettorali.insert(0, lista);
	}

	public void scrutinaVoto(Voto v) {
		if (v.bianca()) {
			schedeBianche++;
		} else {
			if (v.nullo()) {
				schedeNulle++;
			} else {
				int voti = listeElettorali.search(v.voto()) + 1;
				listeElettorali.delete(v.voto());
				listeElettorali.insert(voti, v.voto());
			}
		}
	}

	public int numVoti(ListaElettorale<String> lista) {
		return listeElettorali.search(lista);
	}

	public int nulle() {
		return schedeNulle;
	}

	public int bianche() {
		return schedeBianche;
	}

	public List<ListaElettorale> elencoOrdinato() {
		List<ListaElettorale> elencoListe = new LinkedList<ListaElettorale>();

		for (Object l : listeElettorali) {
			boolean flag = false;
			ListaElettorale listaL = (ListaElettorale) l;
			int votiL = listeElettorali.search(listaL);

			if (elencoListe.isEmpty())
				elencoListe.add(listaL);
			else {
				for (int i = 0; i < elencoListe.size(); i++) {
					int votiTmp = listeElettorali.search(elencoListe.get(i));
					if (votiL <= votiTmp) {
						elencoListe.add(i, listaL);
						flag = true;
						break;
					}
				}
				if (!flag) {
					elencoListe.add(listaL);
				}
			}

		}

		return elencoListe;
	}

}

package esami.Lab20150331;

import java.util.HashMap;

import esami.Lab20150331.Albero.*;

public class Test {

	public static void main(String[] args) {
		final HashMap<Integer, String> attributi = new HashMap<Integer, String>();
		{
			attributi.put(0, "meteo");
			attributi.put(1, "temperatura");
			attributi.put(2, "umidita");
		}

		final String[][] tabella = { { "piove", "alta", "elevata" },
				{ "piove", "bassa", "bassa" }, { "sereno", "alta", "elevata" },
				{ "nevica", "bassa", "bassa" } };

		Etichetta eGioca = new Etichetta("gioca");
		Etichetta eNonGioca = new Etichetta("non gioca");

		BDT<Etichetta> gioca = new BDTPF<Etichetta>(eGioca);
		BDT<Etichetta> nonGioca = new BDTPF<Etichetta>(eNonGioca);

		Etichetta eTemp = new Etichetta("temperatura", "bassa");
		BDT<Etichetta> temp = new BDTPF<Etichetta>(nonGioca, eTemp, gioca);

		Etichetta eUmid = new Etichetta("umidita", "elevata");
		BDT<Etichetta> umid = new BDTPF<Etichetta>(nonGioca, eUmid, gioca);

		Etichetta eMeteo = new Etichetta("meteo", "piove");
		BDT<Etichetta> rad = new BDTPF<Etichetta>(temp, eMeteo, umid);

		// TODO: manca la stampa di tutti i nodi per via della non
		// implementazione dell'iteratore

		// classificazione
		for (int i = 0; i < tabella.length; i++) {
			System.out.println("--- Classificazione caso: " + (i + 1) + " ---");
			String[] row = tabella[i];
			BDT<Etichetta> nodo = rad;
			int j = 0;
			while (nodo != null) {
				if (nodo.foglia()) {
					try {
						System.out.println(nodo.decisione().decisione());
						break;
					} catch (EccezioneNodoNonValido e) {
						System.err.println(e.getMessage());
						break;
					}

				}
				System.out.print(attributi.get(j) + "=" + row[j] + " -> ");
				if (nodo.predicato().testProprietà(attributi.get(j), row[j])) {
					try {
						nodo = nodo.sin(nodo);
					} catch (EccezioneNodoNonValido e) {
						System.err.println(e.getMessage());

					} finally {
						j++;
					}

				} else {
					try {
						nodo = nodo.des(nodo);
					} catch (EccezioneNodoNonValido e) {
						System.err.println(e.getMessage());

					} finally {
						j=j+2;
					}
				}
			}
			System.out.println();
		}

	}
}

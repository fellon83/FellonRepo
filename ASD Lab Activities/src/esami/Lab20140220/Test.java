package esami.Lab20140220;

import java.util.HashMap;
import java.util.Random;

public class Test {

	final static int N_PROCESSI = 17;
	final static int MIN_PRIORITA = 100;
	final static int MAX_PRIORITA = 0;
	final static int NUM_ESECUZIONI = 20;
	final static String PATH = "c:/process/";
	final static String[] NOME_CODA = { "unrunnable", "runnable", "stopped" };
	final static int PROB = 100;
	static String nomeCodaCasuale;

	static HashMap<String, PQ<Process>> code = new HashMap<String, PQ<Process>>();

	private static void changeStatePriority(Process p) {
		Random r = new Random();
		int probValue = r.nextInt(PROB);
		int priorita;
		String nuovoNomeCoda = null;
		PQ<Process> nuovaCoda;
		
		if (probValue < 20) {
			priorita = r.nextInt(MIN_PRIORITA);
		} else {
			priorita = code.get(nomeCodaCasuale).getPriority(p);
		}
		switch (nomeCodaCasuale) {
		case "unrunnable":
			nuovoNomeCoda = NOME_CODA[1];
			break;
		case "runnable":
			boolean tf = r.nextBoolean();
			if (tf)
				nuovoNomeCoda = NOME_CODA[0];
			else
				nuovoNomeCoda = NOME_CODA[2];
			break;
		case "stopped":
			nuovoNomeCoda = NOME_CODA[1];
			break;
		}
		nuovaCoda = code.get(nuovoNomeCoda);
		code.remove(nuovoNomeCoda);
		nuovaCoda.insert(p, priorita);
		code.put(nuovoNomeCoda, nuovaCoda);

	}

	public static void main(String[] args) {

		for (int i = 0; i < NOME_CODA.length; i++) {
			code.put(NOME_CODA[i], new PQA<Process>());
		}

		for (int i = 0; i < N_PROCESSI; i++) {
			Random r = new Random();
			int priority = r.nextInt(MIN_PRIORITA);
			Process proc = new Process(PATH);
			code.get(NOME_CODA[0]).insert(proc, priority);
		}

		System.out.println("Stampo la coda dei processi " + NOME_CODA[0]);
		int n = 1;
		for (Process temp : code.get(NOME_CODA[0])) {
			System.out.println("Processo n." + n++ + ": " + temp.toString()
					+ " Priorità: "
					+ (code.get(NOME_CODA[0])).getPriority(temp));
		}

		for (int i = 0; i < NUM_ESECUZIONI; i++) {
			Random r = new Random();
			int indice = r.nextInt(NOME_CODA.length);
			nomeCodaCasuale = NOME_CODA[indice];
			PQ<Process> codaSel = (PQ<Process>) code.get(nomeCodaCasuale);
			
			if (!codaSel.isNew()) {
				Process proc = codaSel.first();
				changeStatePriority(proc);
				codaSel.delFirst();
				code.remove(nomeCodaCasuale);
				code.put(nomeCodaCasuale, codaSel);
			}

		}
		
		System.out.println("\n\n - Ristampo le code dopo gli spostamenti dei processi - ");
		System.out.println("\nCoda dei processi " + NOME_CODA[0]);
		 n = 1;
		for (Process temp : code.get(NOME_CODA[0])) {
			System.out.println("Processo n." + n++ + ": " + temp.toString()
					+ " Priorità: "
					+ (code.get(NOME_CODA[0])).getPriority(temp));
		}
		
		System.out.println("\nCoda dei processi " + NOME_CODA[1]);
		n = 1;
		for (Process temp : code.get(NOME_CODA[1])) {
			System.out.println("Processo n." + n++ + ": " + temp.toString()
					+ " Priorità: "
					+ (code.get(NOME_CODA[1])).getPriority(temp));
		}
		
		System.out.println("\nCoda dei processi " + NOME_CODA[2]);
		n = 1;
		for (Process temp : code.get(NOME_CODA[2])) {
			System.out.println("Processo n." + n++ + ": " + temp.toString()
					+ " Priorità: "
					+ (code.get(NOME_CODA[2])).getPriority(temp));
		}
	}
}

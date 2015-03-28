package esami.Lab20130917;

public class Test {

	public static void main(String[] args) {
		ItemRecommender itr = new ItemRecommender(20);
		System.out.println(itr.toString());

		System.out.println("\n\n--- Coppie prodotti -> Co-Occorrenze ---");
		for (int i = 0; i < ItemRecommender.PRODOTTI_DISP.length - 1; i++) {
			Prodotto prodA = new Prodotto(ItemRecommender.PRODOTTI_DISP[i],
					ItemRecommender.PREZZI_PROD[i]);
			for (int j = i + 1; j < ItemRecommender.PRODOTTI_DISP.length; j++) {
				Prodotto prodB = new Prodotto(ItemRecommender.PRODOTTI_DISP[j],
						ItemRecommender.PREZZI_PROD[j]);
				int coOcc = itr.acquistiAssociati(prodA, prodB);
				System.out.println("Coppia Prodotti: " + prodA.getNome() + "-"
						+ prodB.getNome() + "   Co-Occorrenze: "
						+ String.valueOf(coOcc));
			}
		}

	}
}

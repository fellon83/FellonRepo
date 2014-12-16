package esami.Lab20140415;

public class BagOfWords {
	protected Bag bagOfWords = new Bag();
	protected int occurrences = 0;

	void addText(String txt) {
		String[] words = txt.split(" ");
		for (int i = 0; i < words.length; i++) {
			bagOfWords.addItem(words[i].toLowerCase());
			occurrences++;
		}

	}

	float similarita(BagOfWords bow){
		float sim = 0;
        for(Object w : bagOfWords) {
            float p1 = ((float) (bagOfWords.occurrences((Comparable) w) + 1) / (occurrences + 2));
            float p2 = ((float) (bow.bagOfWords.occurrences((Comparable) w) + 1) / (bow.occurrences + 2));
            sim += p1 + p2;
        }
        for(Object w : bow.bagOfWords) {
            float p1 = ((float) (bagOfWords.occurrences((Comparable) w) + 1) / (occurrences + 2));
            float p2 = ((float) (bow.bagOfWords.occurrences((Comparable) w) + 1) / (bow.occurrences + 2));
            sim += p1 + p2;
        }
        return sim;
    }
}

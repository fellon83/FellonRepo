package esami.Lab20140220;

public interface PQ<Item> extends Iterable<Item> {
	
	public void insert(Item i, int p);
	public boolean isNew();
	public Item first();
	public void delFirst();
	public void changePriority(Item i, int p);
	public int getPriority (Item i);
	public int size();
	
	
}

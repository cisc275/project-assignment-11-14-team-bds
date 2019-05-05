package entities;

public class StickCounter {
	private int count = 0;
	
	public int getCount() {
		return count;
	}
	
	protected void increment() {
		count++;
	}
}

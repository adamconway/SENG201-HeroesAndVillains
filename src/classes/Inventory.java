package classes;
import java.util.HashMap;
import java.util.LinkedHashMap;

/** 
 * Inventory is a class for the Heroes And Villains application.
 * 
 * @author Adam Conway
 * @author Flynn Doherty
 */

public class Inventory {
	private LinkedHashMap<Item, Integer> items;
	
	public Inventory() {
		items = new LinkedHashMap<Item, Integer>();
	}	

	/**
	 * @param item to be added to the inventory
	 */
	public void addItem(Item item) {
		int count = items.containsKey(item) ? items.get(item) : 0;
		items.put(item, count + 1);
	}
	
	/**
	 * @param item to be counted
	 * @return the number of time the item occurs 
	 */
	public int getCount(Item item) {
		int count = items.containsKey(item) ? items.get(item) : 0;
		return count;
	}
	
	/**
	 * @param item to be remved from the inventory
	 */
	public void removeItem(Item item) {
		int count = items.get(item);
		items.put(item, count - 1);
	}
	
	// Getters and Setters
	
	public HashMap<Item, Integer> getInventory(){		
		return items;
		
	}
}

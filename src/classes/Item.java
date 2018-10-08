package classes;

import javax.swing.ImageIcon;

/** 
 * Item is an extendable class for the Heroes And Villains application.
 * 
 * @author Adam Conway
 * @author Flynn Doherty
 */

public class Item {
	
	private String itemName, itemDescription;
	private int itemCost;
	private ImageIcon icon;
	
	/**
	 * @param name of the item 
	 * @param description of the item
	 * @param iconUrl a string reference to the location of the items icon
	 * @param cost of the item
	 */
	Item(String name, String description, String iconUrl, int cost){
		this.icon = new ImageIcon(Item.class.getResource(iconUrl));
		itemName = name;
		itemDescription = description;
		itemCost = cost;
	}
	
	// Getters and Setters
	
	public String getName() {
		return itemName;
	}
	
	public String getDescription() {
		return itemDescription;
	}
	
	public int getCost() {
		return itemCost;
	}
	
	public ImageIcon getIcon() {
		return icon;
	}
	
}


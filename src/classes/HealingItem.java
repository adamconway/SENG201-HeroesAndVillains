package classes;

/** 
 * HealingItem is a child class for the Heroes And Villains application.
 * 
 * It is an extension of @Item .
 * 
 * @author Adam Conway
 * @author Flynn Doherty
 */

public class HealingItem extends Item{
	
	private double healAmount;
	private int healTime;
	
	/**
	 * @param name of the healing item
	 * @param description of the healing item
	 * @param iconUrl the reference to the healing icon on file
	 * @param cost of the healing item
	 * @param amount of health the healing item replenishes
	 * @param time taken for the health item to be applied
	 */
	public HealingItem(String name, String description, String iconUrl, int cost, double amount, int time) {
		super(name, description, iconUrl, cost);
		healAmount = amount;
		healTime = time;
	}
	
	// Getters and Setters
	
	public double getHealAmount() {
		return healAmount;
	}

	public int getHealTime() {
		return healTime;
	}	
}

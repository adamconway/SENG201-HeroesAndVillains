package classes;
import java.util.ArrayList;

/** 
 * Party is a class for the Heroes And Villains application.
 * 
 * @author Adam Conway
 * @author Flynn Doherty
 */

public class Party {
	
	private String partyName;
	private ArrayList<Hero> heroList;
	private Inventory powerUps;
	private Inventory healingItems;
	private int gold;
	private int maps; 
	
	/**
	 * @param name is the name of the party
	 */
	public Party(String name) {
		this.partyName = name;
		heroList = new ArrayList<>();
		powerUps = new Inventory();
		healingItems = new Inventory();
		gold = 1000;
		maps = 0;
	}
	
	public ArrayList<Hero> getHeroList() {
		return heroList;
	}
	
	public Inventory getPowerUps() {
		return powerUps;
	}
	
	public Inventory getHealingItems() {
		return healingItems;
	}
	
	/**
	 * @param item is the healing item to add to the party's inventory
	 */
	public void addHealingItem(Item item) {
		healingItems.addItem(item);
	}
	
	/**
	 * @param item is the powerup item to add to the party's inventory
	 */
	public void addPowerUp(Item item) {
		powerUps.addItem(item);
	}
	
	/**
	 * @param item is the powerup item to remove from the party's inventory
	 */
	public void removePowerUp(Item item) {
		powerUps.removeItem(item);
	}
	
	public int currentGold() {
		return gold;
	}
	
	/**
	 * @param amount The amount of gold to add to the party's gold counter
	 */
	public void addGold(int amount) {
		gold += amount;
	}
	
	/**
	 * @param amount The amount of gold to remove from the party's gold counter
	 */
	public void removeGold(int amount) {
		gold -= amount;
	}
	
	/**
	 * @param index the index of the powerup item
	 * @param item the powerup item to give to the party
	 */
	public void givePowerUp(int index, PowerUp item) {
		heroList.get(index).giveItem(item);
		powerUps.removeItem(item);
	}
	
	public void addHero(Hero hero) {
		heroList.add(hero);		
	}
	
	public void removeHero(Hero hero) {
		heroList.remove(hero);
	}
	
	public Hero getHero(int index) {
		return heroList.get(index);
	}

	
	public boolean isEmpty() {
		if (heroList.size() == 0) {
			return true;
		} else {
			return false;
		}
	}

	public int getMaps() {
		return maps;
	}

	public void addMap() {
		maps += 1;
	}
	
	public void removeMap() {
		maps -= 1;
	}


	public String getPartyName() {
		return partyName;
	}

	public void setPartyName(String partyName) {
		this.partyName = partyName;
	}
	
	//These are the methods for the special abilities of the Heros
	
	/**
	 * @return the discount for the party
	 */
	public double merchantDiscount() {
		double discount = 1;
		for (int i=0; i < heroList.size(); i++) {
			if (heroList.get(i).getType() == "Merchant") {
				discount = 0.8;
			}
		}		
		return discount;
	}
	
	/**
	 * @return the heal bonus for the party
	 */
	public double HealBonus() {
		double bonus = 1;
		for (int i=0; i < heroList.size(); i++) {
			if (heroList.get(i).getType() == "Medic") {
				bonus = 1.1;
			}
		}		
		return bonus;
	}
}


package classes;
import java.util.ArrayList;

/** 
 * GameVariables is a helper class for the Heroes And Villains application.
 * 
 * It provides data for game objects.
 * 
 * @author Adam Conway
 * @author Flynn Doherty
 */

public class GameVariables {
	
	/**
	 *	Adds the three different types of consumable healing items to the healingItems arrayList
	 */
	public static ArrayList<HealingItem> healingItems = new ArrayList<>();	
	static {
		healingItems.add(new HealingItem("Small Health Elixir", "Heals 25% of Max HP", "/images/items/healthpotion.png", 100, 1, 20));
		healingItems.add(new HealingItem("Medium Health Elixir", "Heals 50% of Max HP", "/images/items/healthpotion.png", 150, 2, 15));
		healingItems.add(new HealingItem("Large Health Elixir", "Heals 100% of Max HP", "/images/items/healthpotion.png", 250, 4, 10));
		}
	
	/**
	 * 	Adds the three different types of consumable powerup items to the powerUps arrayList
	 */
	public static ArrayList<PowerUp> powerUps = new ArrayList<>();	
	static {
		powerUps.add(new PowerUp("Long Sword", "+5 Attack", "/images/items/sword.png",300, 5, 0, 0));
		powerUps.add(new PowerUp("Health Crystal", "+10 Max HP", "/images/items/sword.png",200, 0, 0, 5));
		powerUps.add(new PowerUp("Leather Armour", "+3 Defense", "/images/items/sword.png",100, 0, 2, 0));
	}
	
	/**
	 * 	Adds the six different types of playable heroes to the heroTypes arrayList
	 */
	public static ArrayList<HeroType> heroTypes = new ArrayList<>();
	static {
		heroTypes.add(new HeroType("Merchant", "/images/heroes/merchant.png", 40, 3, 100, "Description", "Save 10% on store items when in the party"));
		heroTypes.add(new HeroType("Medic", "/images/heroes/medic.png", 40, 5, 100, "Description", "Healing items provide 10% more heals on all party members"));
		heroTypes.add(new HeroType("Tank", "/images/heroes/tank.png", 20, 10, 200, "Description", "Health items give tanks 20% more bonus HP"));
		heroTypes.add(new HeroType("Assassin", "/images/heroes/assassin.png", 75, 0, 40, "Description", "Will survive their first lethal hit on 1HP. Bonus Health items have no effect"));
		heroTypes.add(new HeroType("Explorer", "/images/heroes/default.png", 40, 3, 100, "Description", "Provides a permanent map while alive in the party"));
		heroTypes.add(new HeroType("Vampire", "/images/heroes/explorer.png", 35, 3, 75, "Description", "Regens back 30% of damage done in combat"));
	}

}

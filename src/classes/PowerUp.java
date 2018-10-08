package classes;

/** 
 * PowerUp is a class of the Heroes and Villains application.
 * 
 * It extends the @Item class and creates in-game objects that provide buffs to the player's party. 
 * 
 * @author Adam Conway
 * @author Flynn Doherty
 */

public class PowerUp extends Item {
	
	private int attackBuff, defenseBuff, maxHealthBuff;

	/** 
	 * Construct the @PowerUp given the following parameters:
	 * 
	 * @param name is the name of the powerup (string).
	 * @param description is a short explanation of the powerup (string).
	 * @param cost is the price required to purchase the powerup (int).
	 * @param attack is the amount the powerup alters the attack strength by (int).				TODO REVISIT
	 * @param defense is the amount the powerup alters the defense strength by (int).			TODO REVISIT
	 * @param maxHealth is the amount the powerup alters the max health by (int).				TODO REVISIT
	 */
	public PowerUp(String name, String description, String iconUrl, int cost, int attack, int defense, int maxHealth) {
		super(name, description, iconUrl, cost);
		// TODO Auto-generated constructor stub
		attackBuff = attack;
		defenseBuff = defense;
		maxHealthBuff = maxHealth;
	}
	
	/**
	 * @return the powerup's attack buff (int).
	 */
	public int getItemAttack() {
		return attackBuff;
	}
	
	/**
	 * @return the powerup's defense buff (int).
	 */
	public int getItemDefense() {
		return defenseBuff;
	}
	
	/**
	 * @return the powerup's max health buff (int).
	 */
	public int getItemMaxHealth() {
		return maxHealthBuff;
	}

}

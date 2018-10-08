package classes;

/** 
 * HeroType is a class for the Heroes And Villains application.
 * 
 * @author Adam Conway
 * @author Flynn Doherty
 */

public class HeroType {
	private String name, iconUrl, description, shortDescription;
	private int attack, defense, hp;
	
	/**
	 * @param name of the hero
	 * @param iconUrl reference to the heros icon image
	 * @param attack value of the hero
	 * @param defense value of the hero
	 * @param hp value of the hero
	 * @param description of the hero
	 * @param shortDescipription displayable description of the hero
	 */
	HeroType(String name, String iconUrl, int attack, int defense, int hp, String description, String shortDescipription){
		this.name = name;
		this.iconUrl = iconUrl;
		this.attack = attack;
		this.defense = defense;
		this.hp = hp;
		this.description = description;
		this.shortDescription = shortDescipription;
	}

	// Getters and Setters
	
	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public int getAttack() {
		return attack;
	}

	public int getDefense() {
		return defense;
	}

	public int getHp() {
		return hp;
	}
	
	public String getIconUrl() {
		return iconUrl;
	}
	

}

package classes;

/** 
 * Hero is a child class for the Heroes And Villains application.
 * 
 * It extends the character class.
 * 
 * @author Adam Conway
 * @author Flynn Doherty
 */


public class Hero extends Character{
	
	private String type;
	private String description;
	private String shortDescription;
	private int typeBonus;

	/**
	 * @param name is the hero's name
	 * @param iconUrl is the location of the file containing the hero's icon image
	 * @param attack is the hero's attack value
	 * @param defense is the hero's defense value
	 * @param maxHealth is the maximum health the hero has
	 * @param type is the hero's type. It can be one of either: Merchant, Medic, Tank, Assassin, Explorer and Vampire
	 * @param description is the hero's description
	 * @param shortDescription is the displayed version of the hero description. This describes the functionality of the hero type
	 */
	public Hero(String name, String iconUrl, int attack, int defense, int maxHealth, String type, String description, String shortDescription) {
		super(name, iconUrl, attack, defense, maxHealth);
		this.typeBonus = 1;
		this.type = type;
		this.description = description;
		this.shortDescription = iconUrl;
	}

	/* (non-Javadoc)
	 * @see classes.Character#dealDamage()
	 */
	public int dealDamage() {
		if (type == "Vampire") {
			this.heal((int)Math.round(this.attack*0.30));
		}
		return this.attack;
	}
	
	/* (non-Javadoc)
	 * @see classes.Character#giveItem(classes.PowerUp)
	 */
	public void giveItem(PowerUp item) {
		items.add(item);
		increaseAttack(item.getItemAttack());
		increaseDefense(item.getItemDefense());
		if (this.type == "Tank") {
			increaseMaxHealth((int) Math.round(item.getItemMaxHealth()*1.2));
		} else if (this.type == "Assassin") {
			increaseMaxHealth((int) Math.round(item.getItemMaxHealth()*0));
		} else {
			increaseMaxHealth(item.getItemMaxHealth());
		}		
	}
	
	/* (non-Javadoc)
	 * @see classes.Character#takeDamage(int)
	 */
	public void takeDamage(int damageAmount) {
		currentHealth -= (damageAmount);
		if (type == "Assassin" && typeBonus == 1) {
			if (currentHealth <= 0) {
				typeBonus = 0;
				currentHealth = 1;
			}
		} else {
			if (currentHealth < 0) {
				currentHealth = 0;
			}
		}
		
	}
	
	// Getters and Setters
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
    public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}
}

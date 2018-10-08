package classes;

import java.util.ArrayList;
import javax.swing.ImageIcon;

/** 
 * Character is a class for the Heroes And Villains application.
 * It is the superclass of @Hero and @Villain.
 * 
 * @author Adam Conway
 * @author Flynn Doherty
 */

public class Character {
		
	private String name;
	protected int attack;
	private int defense;
	protected int currentHealth;
	private int maxHealth;	
	private ImageIcon icon;
	protected ArrayList<Item> items = new ArrayList<>();
	
	/**
	 * @param name of the character
	 * @param iconUrl which is the link to the character's image icon on file
	 * @param attack value of the character
	 * @param defense value of the character
	 * @param maxHealth maximum health value of the character
	 */
	public Character(String name, String iconUrl,  int attack, int defense, int maxHealth) {
		this.icon = new ImageIcon(Character.class.getResource(iconUrl));
		this.name = name;
		this.attack = attack;
		this.defense = defense;
		this.maxHealth = maxHealth;
		currentHealth = maxHealth;
	}

	/**
	 * @return true or false if character is alive or dead respectively
	 */
	public boolean getStatus() {
		if (currentHealth == 0){
			return false;
		} else {
			return true;
		}
	}

	/**
	 * @param healAmount is the amount to heal the character by
	 */
	public void heal(int healAmount) {
		currentHealth += healAmount;
		if (currentHealth > maxHealth) {
			currentHealth = maxHealth;
		}
	}
	
	/**
	 * @return the character's current health as a fraction of it's total health
	 */
	public String getHpString() {
		return currentHealth + "/" + maxHealth;
	}
	
	/**
	 * @param amount to increase the character's attack by
	 */
	public void increaseAttack(int amount) {
		setAttack(getAttack() + amount);
	}
	
	/**
	 * @param amount to increase the character's defense by
	 */
	public void increaseDefense(int amount) {
		setDefense(getDefense() + amount);
	}
	
	/**
	 * @param amount to increase the character's health by
	 */
	public void increaseMaxHealth(int amount) {
		maxHealth += amount;
		if (amount > 0) {
			currentHealth += amount;
		}
		if (currentHealth > maxHealth) {
			currentHealth = maxHealth;			
		}
	}	
	
	/**
	 * @return the character's attack amount
	 */
	public int dealDamage() {
		return this.attack;
	}
	
	/**
	 * @param damageAmount the amount to damage the character by
	 */
	public void takeDamage(int damageAmount) {
		currentHealth -= (damageAmount);
		if (currentHealth < 0) {
			currentHealth = 0;
		}
	}
	
	/**
	 * @param item to give to the character's inventory
	 */
	public void giveItem(PowerUp item) {
		items.add(item);
		increaseAttack(item.getItemAttack());
		increaseDefense(item.getItemDefense());
		increaseMaxHealth(item.getItemMaxHealth());
	}
	
	// Getters and Setters
	
	public ArrayList<Item> getItems(){
		return items;
	}
	
	public Item getItem(int index){
		return getItems().get(index);
	}		

	public String getName() {
		return name;
	}	

	public void setName(String name) {
		this.name = name;
	}	

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}
	
	public int getDefense() {
		return defense;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}
	
	public int getMaxHealth() {
		return maxHealth;
	}

	public void setMaxHealth(int maxHealth) {
		this.maxHealth = maxHealth;
		this.currentHealth = maxHealth;
	}

	public int getCurrentHealth() {
		return currentHealth;
	}

	public void setIcon(String iconUrl) {
		this.icon = new ImageIcon(Character.class.getResource(iconUrl));
	}

	public ImageIcon getIcon() {
		return icon;
	}
}


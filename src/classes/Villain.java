package classes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/** 
 * Villain is a child class of the Heroes and Villains application.
 * 
 * It extends the @Character class and creates opponents for the player's party. 
 * 
 * @author Adam Conway
 * @author Flynn Doherty
 */ 

public class Villain extends Character {
	
	private String villainQuote;
	private static ArrayList<String> nameList = new ArrayList<>(Arrays.asList("Sauron", "Morgoth", "Gothmog", "Cacaroth", "Dracula", "Cthulu",
			"Lord Soth", "Jormungand", "Nyrrdhaeg", "Arioch", "Baron Sarosto"));	
	private static ArrayList<String> villainQuotes = new ArrayList<>(Arrays.asList("I will win", "I cannot lose", "Prepare to Die!!", 
			"Nothing can stop me!!!", "Kneel before me", "You cannot win", "I think all of us have a hero and a villain in us", "You either die a hero or you live long enough to see yourself become the villain"));;
	
	/** 
	 * Construct the @Villain using the @Character superclass.
	 * 
	 * @param name is the name of the villain (string).
	 * @param attack is the amount of attack damage the villain does (int).
	 * @param defense is an attribute that reduces damage done to the villain (int).
	 * @param maxHealth is the maximum health the villain has (int).
	 * 
	 */
	Villain(String name, String iconUrl, int attack, int defense, int maxHealth) {	
		super(name, iconUrl, attack, defense, maxHealth);
		Random randomGenerator = new Random();
		int index = randomGenerator.nextInt(nameList.size());
		this.setName(nameList.get(index));
		nameList.remove(index);
		index = randomGenerator.nextInt(villainQuotes.size());
		villainQuote = villainQuotes.get(index);
		villainQuotes.remove(index);
		}
	
	public String getQuote() {
		return villainQuote;
	}	
}
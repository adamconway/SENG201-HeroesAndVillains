package classes;
import java.util.Random;

/** 
 * HighLow is a class for the Heroes And Villains application.
 * 
 * It is a playable minigame when facing a city's Villain.
 * 
 * @author Adam Conway
 * @author Flynn Doherty
 */
public class HighLow {
	
	private int villainNumber;
	private int heroGuess;	
	
	/**
	 * 	setVillainNumber sets the villain's number for the hero's to guess
	 */
	public void setVillainNumber() {
		Random rand = new Random();
		villainNumber = rand.nextInt(10) + 1;
	}
		
	/**
	 * @return the status of the hero's guess. This can return one of three strings: low, high, correct
	 */
	public String guess() {
		if (heroGuess < villainNumber) {
			return "low";
		} else if (heroGuess > villainNumber) {
			return "high";
		} else if (heroGuess == villainNumber) {
			return "correct";
		}
		return "";
	}
	
	/**
	 * @param i is the integer of the hero's guess
	 */
	public void setHeroGuess(int i) {
		heroGuess = i;
	}
	
	/**
	 * @return if the hero guesses the villain's number correctly return 'win', otherwise, return 'lose'
	 */
	public String getStatus() {
		if (heroGuess == villainNumber) {
			return "win";
		} else {
			return "lose";
		}
	}
	
	/**
	 * @return the villain's number
	 */
	public int getVillainNumber() {
		return villainNumber;
	}
	
	 /**
   * @return the heroes's guess
   */
  public int getHeroesGuess() {
    return heroGuess;
  }
}

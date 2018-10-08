package classes;
import java.util.Random;

/** 
 * DiceGame is a class for the Heroes And Villains application.
 * 
 * It is a playable minigame when facing a city's Villain.
 * 
 * @author Adam Conway
 * @author Flynn Doherty
 */

public class DiceGame {
	
	private int villainRoll;
	private int heroRoll;	
	
	/**
	 * @return the integer (1-6) that the hero has rolled
	 */
	public int heroRoll() {
		Random rand = new Random();
		heroRoll = rand.nextInt(6) + 1;
		return heroRoll;
		
	}
	
	/**
	 * @return the integer (1-6) that the villain has rolled
	 */
	public int villainRoll() {
		Random rand = new Random();
		villainRoll = rand.nextInt(6) + 1;
		return villainRoll;
		
	}
	
	/**
	 * @return the win/loss/draw status of the game
	 */
	public String getStatus() {
		if(heroRoll>villainRoll) {
			return "win";
		} else if (heroRoll < villainRoll) {
			return "lose";
		} else {
			return "draw";
		}
	}

}

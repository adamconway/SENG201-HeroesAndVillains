package classes;
import java.util.Random;

/** 
 * RockPaperScissors is a class for the Heroes And Villains application.
 * 
 * It is a playable minigame when facing a city's Villain.
 * 
 * @author Adam Conway
 * @author Flynn Doherty
 */

public class RockPaperScissors {	

	private int playerMove;
	private int villainMove;
	private String status;
	
	/**
	 * 	villainMove sets the local variable to a random integer between 1 and 3. This is intended to emulate 1:Rock, 2:Paper, 3:Scissors
	 */
	public void villainMove() {
		Random rand = new Random();
		villainMove = rand.nextInt(3) + 1;
	}
	
	/**
	 * 	vs plays the game and sets the game's status respectively. The three possible states are: draw, win, lose.
	 */
	private void vs() {
		if (playerMove == villainMove) {
			status = "draw";
		} else {
			switch (playerMove) {
			case 1:
				status = (villainMove == 2 ? "lose":"win");
				break;
			case 2:
				status = (villainMove == 1 ? "win":"lose");
				break;
			case 3:
				status = (villainMove == 1 ? "lose":"win");
				break;
			}			
		}
	}
	
	// Getters and Setters
	
	public void setPlayerMove(int i) {
		playerMove = i;
		villainMove();
		vs();
	}
	
	public void setVillainMove(int i) {
	  villainMove = i;
	}
	 
	public String getStatus() {
		return status;
	}
	
	public String getVillainMove() {
		switch(villainMove) {
		case 1: 
			return "rock";
		case 2:
			return "paper";
		case 3:
			return "scissors";
		}
		return "None";
	}	
	
}

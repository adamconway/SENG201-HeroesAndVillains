package junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import classes.DiceGame;

class DiceGameTest {

	@Test
	public void testGetStatus() {
		DiceGame dice = new DiceGame();
		int heroRoll = dice.heroRoll();
		int villainRoll = dice.villainRoll();
		
		if (heroRoll > villainRoll) {
			assertEquals(dice.getStatus(), "win");
		} else if (heroRoll < villainRoll){
			assertEquals(dice.getStatus(), "lose");
		} else if (heroRoll == villainRoll){ 
			assertEquals(dice.getStatus(), "draw");
		}
	}
	
}

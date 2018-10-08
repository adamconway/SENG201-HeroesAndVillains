package junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import classes.Character;
import classes.HeroType;

class CharacterTest {

	@Test
	void testGetStatus() {
    Character character = new Character("name","/images/heroes/merchant.png", 33, 3, 100);
    Character characterDead = new Character("dead","/images/heroes/merchant.png", 33, 3, 0);
    assertEquals(character.getStatus(), true);
    assertEquals(characterDead.getStatus(), false);
    
    Character character2 = new Character("name","/images/heroes/merchant.png", 33, 3, 100);
    character2.takeDamage(100);
    assertEquals(character2.getStatus(), false);
  }

	@Test
	void testHeal() {
    Character character = new Character("name","/images/heroes/merchant.png", 33, 3, 100);
    character.takeDamage(50);
    character.heal(20);
    assertEquals(character.getCurrentHealth(), 70);

    Character character2 = new Character("name","/images/heroes/merchant.png", 33, 3, 100);
    character2.heal(20);
    assertEquals(character2.getCurrentHealth(), 100);

	}

	@Test
	void testIncreaseAttack() {
    Character character = new Character("name","/images/heroes/merchant.png", 33, 3, 100);
    character.increaseAttack(27);
    assertEquals(character.getAttack(), 60);	
  }

	@Test
	void testIncreaseDefense() {
	  Character character = new Character("name","/images/heroes/merchant.png", 33, 3, 100);
	  character.increaseDefense(27);
    assertEquals(character.getDefense(), 30);
	}

	@Test
	void testIncreaseMaxHealth() {
    Character character = new Character("name","/images/heroes/merchant.png", 33, 3, 100);
    character.increaseMaxHealth(30);
    assertEquals(character.getMaxHealth(), 130);	
  }

	@Test
	void testTakeDamage() {
    Character character = new Character("name","/images/heroes/merchant.png", 33, 3, 100);
    character.takeDamage(50);
    assertEquals(character.getCurrentHealth(), 50);	
    
    Character character2 = new Character("name","/images/heroes/merchant.png", 33, 3, 100);
    character2.takeDamage(100);
    assertEquals(character2.getCurrentHealth(), 0); 
  }

}

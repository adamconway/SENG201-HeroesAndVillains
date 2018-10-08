package junit;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import classes.HealingItem;
import classes.Hero;
import classes.HeroType;
import classes.Inventory;
import classes.Item;
import classes.Party;
import classes.PowerUp;

class PartyTest {

  @Test
  void testGetHeroList() {
    Party party = new Party("testing");
    Hero hero = new Hero("name","/images/heroes/merchant.png", 33, 3, 100, "Merchant", "Description", "Save 10% on store items when in the party");
    party.addHero(hero);
    ArrayList<Hero> ar = new ArrayList<>();
    ar.add(hero);
    assertEquals(party.getHeroList(), ar);
  }

  @Test
  void testAddHealingItem() {
    Party party = new Party("testing");
    HealingItem healItem = new HealingItem("Small Health Elixir", "Heals 25% of Max HP", "/images/items/healthpotion.png", 100, 1, 20);
    party.addHealingItem(healItem);
    assertEquals(party.getHealingItems(), party.getHealingItems());
  }

  @Test
  void testAddPowerUp() {
    Party party = new Party("testing");
    PowerUp powerup = new PowerUp("Long Sword", "+5 Attack", "/images/items/sword.png",300, 5, 0, 0);
    party.addPowerUp(powerup);
    assertEquals(party.getPowerUps(), party.getPowerUps());  
  }

  @Test
  void testRemovePowerUp() {
    Party party = new Party("testing");
    PowerUp powerup = new PowerUp("Long Sword", "+5 Attack", "/images/items/sword.png",300, 5, 0, 0);
    party.addPowerUp(powerup);
    party.removePowerUp(powerup);
    assertEquals(party.getPowerUps(), party.getPowerUps());   
  }

  @Test
  void testAddGold() {
    Party party = new Party("testing");
    party.addGold(1000);
    assertEquals(party.currentGold(), 2000);   
  }

  @Test
  void testRemoveGold() {
    Party party = new Party("testing");
    party.addGold(1000);
    party.removeGold(500);
    assertEquals(party.currentGold(), 1500); 
  }

  @Test
  void testAddHero() {
    Party party = new Party("testing");
    Hero hero = new Hero("name","/images/heroes/merchant.png", 33, 3, 100, "Merchant", "Description", "Save 10% on store items when in the party");
    party.addHero(hero);
    ArrayList<Hero> ar = new ArrayList<>();
    ar.add(hero);
    assertEquals(party.getHeroList(), ar);
  }

  @Test
  void testRemoveHero() {
    Party party = new Party("testing");
    Hero hero = new Hero("name","/images/heroes/merchant.png", 33, 3, 100, "Merchant", "Description", "Save 10% on store items when in the party");
    party.addHero(hero);
    party.removeHero(hero);
    ArrayList<Hero> ar = new ArrayList<>();
    ar.add(hero);
    ar.remove(hero);
    assertEquals(party.getHeroList(), ar);
  }

  @Test
  void testAddMap() {
    Party party = new Party("testing");
    party.addMap();
    assertEquals(party.getMaps(), 1);
  }

  @Test
  void testRemoveMap() {
    Party party = new Party("testing");
    party.addMap();
    party.addMap();
    party.removeMap();
    assertEquals(party.getMaps(), 1);  }

  @Test
  void testMerchantDiscount() {
    Party party = new Party("testing");
    Hero hero = new Hero("name","/images/heroes/merchant.png", 33, 3, 100, "Merchant", "Description", "Save 10% on store items when in the party");
    party.addHero(hero);
    assertEquals(party.merchantDiscount(), .80);
    
    Party party2 = new Party("testing");
    Hero hero2 = new Hero("name","/images/heroes/merchant.png", 33, 3, 100, "Assassin", "Description", "Save 10% on store items when in the party");
    party2.addHero(hero2);
    assertEquals(party2.merchantDiscount(), 1.0);
  }

  @Test
  void testHealBonus() {
    Party party = new Party("testing");
    Hero hero = new Hero("name","/images/heroes/merchant.png", 33, 3, 100, "Medic", "Description", "Save 10% on store items when in the party");
    party.addHero(hero);
    assertEquals(party.HealBonus(), 1.1);
    
    Party party2 = new Party("testing");
    Hero hero2 = new Hero("name","/images/heroes/merchant.png", 33, 3, 100, "Assassin", "Description", "Save 10% on store items when in the party");
    party2.addHero(hero2);
    assertEquals(party2.HealBonus(), 1.0);
  }
}

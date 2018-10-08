package junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import classes.HighLow;

class HighLowTest {

  @Test
  void test() {
    HighLow hl = new HighLow();
    hl.setHeroGuess(5);
    hl.setVillainNumber();
    
    if (hl.getHeroesGuess() > hl.getVillainNumber()) {
      assertEquals(hl.getStatus(), "lose");
    } else if (hl.getHeroesGuess() < hl.getVillainNumber()) {
      assertEquals(hl.getStatus(), "lose");
    } else if (hl.getHeroesGuess() == hl.getVillainNumber()) {
      assertEquals(hl.getStatus(), "win");
    }
  }
}

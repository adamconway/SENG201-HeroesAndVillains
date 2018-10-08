package gui;

import javax.swing.JFrame;

import classes.GameMap;
import classes.Hero;
import classes.Party;

public class GameTestClass {
	
	JFrame frame;
	
	public static void main(String[] args) {
		Party party = new Party("Name");
		party.addHero(new Hero("Hero 1", "/images/heroes/default.png", 40,40,100,"Merchant","",""));
		GameMap map = new GameMap(3);
		Game game = new Game(party, map);
		
		JFrame frame = new JFrame();
		frame.setSize(900,600);
		frame.add(game);
		frame.setVisible(true);
	}

}

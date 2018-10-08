package gui;

import java.util.ArrayList;

import javax.swing.JPanel;

import classes.Party;
import javax.swing.JButton;
import java.awt.Color;

public class PartyPanel extends JPanel {
	

	private JButton btnClose;
	private ArrayList<HeroStatsPanel> heroes;
	/**
	 * Create the panel.
	 */
	public PartyPanel() {
		setBorder(null);
		setBackground(Color.WHITE);
		setLayout(null);
		setSize(400, 200);
		heroes = new ArrayList<HeroStatsPanel>();		
		btnClose = new JButton("Close");
		
	}
	
	public void update(Party party) {
		
		for (int i = 0; i < party.getHeroList().size(); i++) {	
			HeroStatsPanel hero = new HeroStatsPanel(party.getHero(i));
			heroes.add(hero);
			hero.setBounds(0,0+70*i,350,70);
			add(hero);
		}
		btnClose.setBounds(155, 230, 90, 23);
		add(btnClose);
	}
	
	public JButton getBtnClose() {
		return btnClose;	
	}
	
}

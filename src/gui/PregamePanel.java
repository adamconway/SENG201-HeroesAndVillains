package gui;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

import classes.Party;

public class PregamePanel extends JPanel {

	/**
	 * Create the panel.
	 */
	private ArrayList<JButton> buttons;
	
	
	public PregamePanel() {
		setLayout(null);
		setSize(650,420);		
		buttons = new ArrayList<JButton>();			
	}
	
	
	public void update(Party party) {
		removeAll();
		buttons.clear();
		for (int i = 0; i < party.getHeroList().size(); i++) {
			
			//Create Hero Display Panel
			HeroStatsPanel heroPanel = new HeroStatsPanel(party.getHero(i));
			add(heroPanel);
			heroPanel.setBounds(210, 30+i*80, 400, 70);
			//Create Button to Select Hero
			JButton button = new JButton("Select Hero");
			add(button);
			button.putClientProperty("heroNum", i);
			button.setBounds(40, 50+i*80, 140, 30);
			buttons.add(button);
			button.setEnabled(true);
		}
		revalidate();
		repaint();
		
	}	
	

	
	public ArrayList<JButton> getButtons(){
		return buttons;
	}
 
}

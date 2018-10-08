package gui;

import javax.swing.JPanel;

import classes.HelperFunction;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class DiceGamePanel extends JPanel {

	
	private JButton btnDiceRoll;
	private JLabel lblHeroRoll, lblVillainRoll;
	/**
	 * Create the panel.
	 */
	public DiceGamePanel() {
		setLayout(null);
		setSize(650,420);
		
		btnDiceRoll = new JButton("");
		btnDiceRoll.setIcon(HelperFunction.resizeIcon(new ImageIcon(DiceGamePanel.class.getResource("/images/locations/villainlair/dice.png")), 140, 140));
		btnDiceRoll.setBounds(250, 51, 150, 150);
		btnDiceRoll.setContentAreaFilled(false); 
		btnDiceRoll.setFocusPainted(false); 
		btnDiceRoll.setOpaque(false);
//		btnDiceRolll.setBorderPainted(false);
		add(btnDiceRoll); 
		
		JLabel lblDiceRoll = new JLabel("Click Dice to Roll");
		lblDiceRoll.setHorizontalAlignment(SwingConstants.CENTER);
		lblDiceRoll.setBounds(225, 12, 200, 30);
		add(lblDiceRoll);
		
		JLabel lblYouRolled = new JLabel("You Rolled:");
		lblYouRolled.setHorizontalAlignment(SwingConstants.CENTER);
		lblYouRolled.setBounds(87, 220, 150, 30);
		add(lblYouRolled);
		
		lblHeroRoll = new JLabel("");
		lblHeroRoll.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeroRoll.setFont(new Font("Dialog", Font.BOLD, 70));
		lblHeroRoll.setBounds(87, 256, 150, 150);
		add(lblHeroRoll);
		
		JLabel lblVillainRoll_1 = new JLabel("Villain Roll:");
		lblVillainRoll_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblVillainRoll_1.setBounds(412, 220, 150, 30);
		add(lblVillainRoll_1);
		
		lblVillainRoll = new JLabel("");
		lblVillainRoll.setHorizontalAlignment(SwingConstants.CENTER);
		lblVillainRoll.setFont(new Font("Dialog", Font.BOLD, 70));
		lblVillainRoll.setBounds(412, 256, 150, 150);
		add(lblVillainRoll);
		
	}
	
	public JButton getDiceButton() {
		return btnDiceRoll;		
	}
	
	public JLabel getHeroRoll() {
		return lblHeroRoll;
	}
	
	public JLabel getVillainRoll() {
		return lblVillainRoll;
	}
	
	public void reset() {
		lblHeroRoll.setText("");
		lblVillainRoll.setText("");
	}
}

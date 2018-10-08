package gui;

import javax.swing.JPanel;
import javax.swing.border.MatteBorder;

import classes.TimerTime;
import javax.swing.JLabel;
import java.awt.Color;

public class ActiveHealPanel extends JPanel {
	
	private JLabel heroName, healAmount, timeRemaining;
	/**
	 * Create the panel.
	 */
	public ActiveHealPanel(TimerTime time) {
		setBackground(Color.WHITE);
		setSize(300, 90);
		setLayout(null);
		setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		
		JLabel heroName = new JLabel("Hero:" + time.getHeroName());
		heroName.setBounds(22, 12, 218, 15);
		add(heroName);
		
		JLabel healAmount = new JLabel("Time Remaining: " +time.getTimeRemaining() + " Seconds");
		healAmount.setBounds(22, 64, 218, 15);
		add(healAmount);
		
		JLabel timeRemaining = new JLabel("Heal Amount :" + time.getHealAmount() + "%");
		timeRemaining.setBounds(22, 37, 218, 15);
		add(timeRemaining);
	}

}

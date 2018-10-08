package gui;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import classes.HelperFunction;

public class GameLossPanel extends JPanel {
	/**
	 * Create the panel.
	 */
	public GameLossPanel() {
		setSize(650,420);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(HelperFunction.resizeIcon(new ImageIcon(CityDefeatedPanel.class.getResource("/images/gui/defeatsign.png")),386, 300));
		lblNewLabel.setBounds(117, 12, 386, 320);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("You have been defeated :( Click \"Continue\" to return the main menu.");
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 15));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(35, 298, 582, 80);
		add(lblNewLabel_1);		
	}
}
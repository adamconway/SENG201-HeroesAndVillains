package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import classes.HelperFunction;

import javax.swing.ImageIcon;
import java.awt.Font;

public class CityDefeatedPanel extends JPanel {
	/**
	 * Create the panel.
	 */
	public CityDefeatedPanel() {
		setSize(650,420);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(HelperFunction.resizeIcon(new ImageIcon(CityDefeatedPanel.class.getResource("/images/gui/victorysign.png")),386, 300));
		lblNewLabel.setBounds(117, 12, 386, 320);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("You have defeated the City's Villain!  You have been given 300 Gold! Click \"Next City\" to Advanced!");
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 15));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(35, 298, 582, 80);
		add(lblNewLabel_1);
	}

}

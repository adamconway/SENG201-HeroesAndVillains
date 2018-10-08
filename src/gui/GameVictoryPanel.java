package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class GameVictoryPanel extends JPanel {

	
	private JButton btnReturnToMainMenu;
	/**
	 * Create the panel.
	 */
	public GameVictoryPanel() {
		setLayout(null);
		setSize(900,600);
		
		JLabel lblYouWon = new JLabel("You won the game! Congratulations!");
		lblYouWon.setHorizontalAlignment(SwingConstants.CENTER);
		lblYouWon.setBounds(351, 95, 203, 83);
		add(lblYouWon);
		
		btnReturnToMainMenu = new JButton("Return to Main Menu");
		btnReturnToMainMenu.setBounds(280, 306, 376, 26);
		add(btnReturnToMainMenu);
		
	}
	
	public JButton getMainMenuButton() {
		return btnReturnToMainMenu;
	}

}

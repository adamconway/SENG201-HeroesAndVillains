package gui;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.io.IOException;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.imageio.ImageIO;
import javax.swing.ButtonModel;
import javax.swing.ImageIcon;
import java.awt.Color;

public class MainMenuPanel extends JPanel {
	
	private JButton btnNewGame, btnLoadGame, btnHelp, btnQuit;

	/**
	 * Create the panel.
	 */
	public MainMenuPanel() {
		setLayout(null);
		setSize(900, 600);
		setOpaque(false);
		JLabel lblHeroesAndVillain = new JLabel("Heroes and Villains");
		lblHeroesAndVillain.setForeground(Color.BLACK);
		lblHeroesAndVillain.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeroesAndVillain.setFont(new Font("Tahoma", Font.BOLD, 50));
		lblHeroesAndVillain.setBounds(12, 45, 878, 69);
		add(lblHeroesAndVillain);
		
		btnNewGame = new JButton("New Game");
		btnNewGame.setBounds(350, 276, 200, 50);		
		buttonStyle(btnNewGame);
		
		
		//btnLoadGame = new JButton("Load Game");
		//btnLoadGame.setBounds(350, 276, 200, 50);
		//buttonStyle(btnLoadGame);
		
		btnHelp = new JButton("Help");
		btnHelp.setBounds(350, 342, 200, 50);
		buttonStyle(btnHelp);
		
		btnQuit = new JButton("Quit");
		btnQuit.setBounds(350, 408, 200, 50);
		buttonStyle(btnQuit);
		
		JLabel lblCredits = new JLabel("By Adam Conway and Flynn Doherty");
		lblCredits.setForeground(Color.WHITE);
		lblCredits.setHorizontalAlignment(SwingConstants.LEFT);
		lblCredits.setBounds(10, 540, 880, 14);
		add(lblCredits);
		
		
		setVisible(false);

	}

	public JButton getBtnNewGame() {
		return btnNewGame;
	}
	
	public JButton getBtnLoadGame() {
		return btnLoadGame;
	}

	public JButton getBtnHelp() {
		return btnHelp;
	}

	public JButton getBtnQuit() {
		return btnQuit;
	}
	
	private void buttonStyle(JButton button) {
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Tahoma", Font.BOLD, 20));
		button.setIcon(new ImageIcon(MainMenuPanel.class.getResource("/images/gui/blue_button04.png")));
		button.setHorizontalTextPosition(JButton.CENTER);
		button.setVerticalTextPosition(JButton.CENTER);
		button.setContentAreaFilled(false); 
		button.setFocusPainted(false); 
		button.setOpaque(false);
		button.setBorderPainted(false);
		button.getModel().addChangeListener(new ChangeListener() {
		    @Override
		    public void stateChanged(ChangeEvent e) {
		        ButtonModel model = (ButtonModel) e.getSource();
		        if (model.isRollover()) {
		        	button.setIcon(new ImageIcon(MainMenuPanel.class.getResource("/images/gui/blue_button05.png")));
		        } else {
		        	button.setIcon(new ImageIcon(MainMenuPanel.class.getResource("/images/gui/blue_button04.png")));
		        }
		    }
		});
		add(button);
	}
	
	@Override
	  protected void paintComponent(Graphics g) {

	    super.paintComponent(g);
	        try {
				g.drawImage(ImageIO.read(getClass().getResource("/images/gui/lightmenubackground.png")), 0, 0, getWidth(), getHeight(), null);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}


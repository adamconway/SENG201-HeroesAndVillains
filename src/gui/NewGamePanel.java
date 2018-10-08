package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Color;

import javax.swing.ButtonModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class NewGamePanel extends JPanel {
	
	
	private JButton btnBack, btnNext;
	private JTextField txtPartyName, txtH1Name, txtH2Name, txtH3Name;
	private JLabel lblPartyNameError, lblHeroError;
	private JSlider sldNumberOfHeroes, sldNumberOfCities;
	
	private HeroSelectPanel hero1, hero2, hero3;
	private HeroSelectPanel[] heroPanels;


	/**
	 * Create the panel.
	 */
	public NewGamePanel() {
		setLayout(null);
		setSize(900, 600);
		
		JLabel lblPartyName = new JLabel("Party Name:");
		lblPartyName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPartyName.setBounds(75, 46, 105, 26);
		add(lblPartyName);
		
		JLabel lblNumberOfHeroes = new JLabel("Number of Heroes:");
		lblNumberOfHeroes.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNumberOfHeroes.setBounds(350, 46, 158, 26);
		add(lblNumberOfHeroes);
		
		JLabel lblNumberOfCities = new JLabel("Number of Cities:");
		lblNumberOfCities.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNumberOfCities.setBounds(625, 46, 158, 26);
		add(lblNumberOfCities);

		
		// INTERACTABLES AND DYNAMIC CONTROLS
		btnBack = new JButton("Back");
		btnBack.setBounds(75, 480, 200, 50);
		buttonStyle(btnBack);
		
		btnNext = new JButton("Next");
		btnNext.setBounds(625, 480, 200, 50);
		btnNext.setEnabled(false);
		buttonStyle(btnNext);
		
		txtPartyName = new JTextField();
		txtPartyName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtPartyName.setBounds(75, 75, 200, 26);
		add(txtPartyName);
		txtPartyName.setColumns(10);
		
		lblPartyNameError = new JLabel("Please enter a longer party name.");
		lblPartyNameError.setForeground(Color.RED);
		lblPartyNameError.setBackground(Color.RED);
		lblPartyNameError.setBounds(75, 104, 200, 14);
		add(lblPartyNameError);
		
		sldNumberOfHeroes = new JSlider();
		sldNumberOfHeroes.setValue(3);
		sldNumberOfHeroes.setSnapToTicks(true);
		sldNumberOfHeroes.setPaintTicks(true);
		sldNumberOfHeroes.setPaintLabels(true);
		sldNumberOfHeroes.setMinimum(1);
		sldNumberOfHeroes.setMaximum(3);
		sldNumberOfHeroes.setMajorTickSpacing(1);
		sldNumberOfHeroes.setFont(new Font("Tahoma", Font.PLAIN, 11));
		sldNumberOfHeroes.setBounds(350, 75, 200, 45);
		add(sldNumberOfHeroes);	
		
		sldNumberOfCities = new JSlider();
		sldNumberOfCities.setFont(new Font("Tahoma", Font.PLAIN, 11));
		sldNumberOfCities.setPaintTicks(true);
		sldNumberOfCities.setPaintLabels(true);
		sldNumberOfCities.setMajorTickSpacing(1);
		sldNumberOfCities.setValue(4);
		sldNumberOfCities.setMaximum(6);
		sldNumberOfCities.setMinimum(3);
		sldNumberOfCities.setSnapToTicks(true);
		sldNumberOfCities.setBounds(625, 75, 200, 45);
		add(sldNumberOfCities);
		
		lblHeroError = new JLabel("Please ensure every hero has a unique name.");
		lblHeroError.setEnabled(false);
		lblHeroError.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeroError.setForeground(Color.RED);
		lblHeroError.setBackground(Color.RED);
		lblHeroError.setBounds(285, 498, 330, 14);
		add(lblHeroError);
		
		hero1 = new HeroSelectPanel();
		hero2 = new HeroSelectPanel();
		hero3 = new HeroSelectPanel();
		
		hero1.setBounds(75, 145, 200, 310);
		hero2.setBounds(350, 145, 200, 310);
		hero3.setBounds(625, 145, 200, 310);
		
		heroPanels = new HeroSelectPanel[3];
		heroPanels[0] = hero1;
		heroPanels[1] = hero2;
		heroPanels[2] = hero3;
		
		add(hero1);
		add(hero2);
		add(hero3);
		
		
	}
	
	public JButton getBtnBack() {
		return btnBack;
	}
	
	public JButton getBtnNext() {
		return btnNext;
	}
	
	public JTextField getPartyNameTextField() {
		return txtPartyName;
	}
	
	public String getPartyName() {
		return txtPartyName.getText();
	}
	
	public JLabel getPartyErrorLabel() {
		return lblPartyNameError;
	}
	
	public JLabel getHeroErrorLabel() {
		return lblHeroError;
	}
	
	public JSlider getNumberOfHeroesSlider() {
		return sldNumberOfHeroes;
	}
	
	public int getNumberOfHeroes() {
		return sldNumberOfHeroes.getValue();
	}	
	
	public int getNumberOfCities() {
		return sldNumberOfCities.getValue();
	}

	
	public void setPartyErrorLabel(String label) {
		this.lblPartyNameError.setText(label);
	}
	
	public HeroSelectPanel[] getHeroPanels() {
		return heroPanels;
	}
	
	public void displayError() {
		//TODO add error message :)
	}
	
	public boolean correctHeroNames() {
		if(hero1.getName().equals(hero2.getName())
				|| hero1.getName().equals(hero3.getName())
				|| hero2.getName().equals(hero3.getName())) {
			return false;
		}
		return true;
	}
	
	private void buttonStyle(JButton button) {
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Tahoma", Font.BOLD, 20));
		button.setIcon(new ImageIcon(MainMenuPanel.class.getResource("/images/gui/blue_button04.png")));
		button.setHorizontalTextPosition(JButton.CENTER);
		button.setVerticalTextPosition(JButton.CENTER);
		button.setBorderPainted(false); 
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

}

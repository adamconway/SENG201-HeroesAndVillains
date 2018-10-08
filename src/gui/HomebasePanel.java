package gui;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.awt.Component;
import java.awt.Font;
import javax.swing.SwingConstants;

import classes.HelperFunction;
import classes.Party;
import java.awt.Color;

public class HomebasePanel extends JPanel {
	
	private PartyPanel partyPanel;
	private JButton btnViewParty, btnNorth, btnSouth, btnWest, btnEast;
	private JLabel lblCurrentCity;
	private ArrayList<JButton> travelButtons = new ArrayList<>();
	//DEBUG BUTTONS DELETE BEFORE FINISH TODO
	
	private JButton btnShop;
	private JButton btnLair;
	private JButton btnHospital;
	private JButton btnPowerUpDen;
	private JButton mapButton;
	private JLabel lblCurrentGold;
	private JLabel lblNewLabel_2;


	/**
	 * Create the panel.
	 */
	public HomebasePanel() {
		setLayout(null);
		setSize(900, 600);
		
		partyPanel = new PartyPanel();
		partyPanel.setBounds(250,150,400,260);
		add(partyPanel);
		partyPanel.setVisible(false);
//		
		btnNorth = new JButton("Travel North");
		btnNorth.setForeground(new Color(0, 0, 0));
		btnNorth.putClientProperty("direction", 0);
		btnNorth.putClientProperty("name", "Travel North");
		btnNorth.setBounds(358, 199, 200, 29);
//		btnNorth.setBorderPainted(false);
		travelButtons.add(btnNorth);
		add(btnNorth);
		
		
		btnEast = new JButton("Travel East");
		btnEast.putClientProperty("name", "Travel East");
		btnEast.putClientProperty("direction", 1);
		btnEast.setBounds(521, 280, 174, 29);
		add(btnEast);
		travelButtons.add(btnEast);
		
		btnSouth = new JButton("Travel South");
		btnSouth.setBounds(358, 370, 200, 29);
		btnSouth.putClientProperty("name", "Travel South");
		btnSouth.putClientProperty("direction", 2);
		add(btnSouth);
		travelButtons.add(btnSouth);
		
		btnWest = new JButton("Travel West");
		btnWest.putClientProperty("direction", 3);
		btnWest.putClientProperty("name", "Travel West");
		btnWest.setBounds(207, 280, 174, 29);
		add(btnWest);
		travelButtons.add(btnWest);
		
		JLabel lblNewLabel = new JLabel(HelperFunction.resizeIcon(new ImageIcon(HomebasePanel.class.getResource("/images/locations/homebase/compass250.png")), 120, 120));
		lblNewLabel.setBounds(391, 239, 120, 120);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Homebase");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 50));
		lblNewLabel_1.setBounds(300, 30, 300, 94);
		add(lblNewLabel_1);
		
		btnViewParty = new JButton("View Party");
		btnViewParty.setBounds(58, 496, 200, 50);
		HelperFunction.buttonStyle(btnViewParty);
		add(btnViewParty);
		
		lblCurrentCity = new JLabel("Current City: 0/10");
		lblCurrentCity.setBounds(640, 11, 158, 40);
		add(lblCurrentCity);
		//DEBUG BUTTONS DELETE BEFORE FINISHING TODO
//		btnShop = new JButton("Shop");
//		btnShop.setBounds(32, 48, 116, 23);
//		add(btnShop);
//		
//		btnLair = new JButton("Lair");
//		btnLair.setBounds(32, 82, 116, 23);
//		add(btnLair);
//		 		
//		btnPowerUpDen = new JButton("Den");
//		btnPowerUpDen.setBounds(32, 116, 116, 23);
//		add(btnPowerUpDen);
//		
//		btnHospital = new JButton("Hospital");
//		btnHospital.setBounds(32, 150, 116, 23);
//		add(btnHospital);
		
		lblCurrentGold = new JLabel("Gold: 0");
		lblCurrentGold.setBounds(640, 62, 92, 38);
		add(lblCurrentGold);
		
		lblNewLabel_2 = new JLabel(HelperFunction.resizeIcon(new ImageIcon(getClass().getResource("/images/locations/homebase/travelbutton.png")) , 600, 329));
		lblNewLabel_2.setBounds(146, 135, 600, 329);
		add(lblNewLabel_2);
		
		mapButton = new JButton("Use a Map");
		mapButton.setBounds(634, 496, 200, 50);
		HelperFunction.buttonStyle(mapButton);
		add(mapButton);
		
		
		
		
		partyPanel.getBtnClose().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				partyPanel.setVisible(false);
				Component[] com = getComponents();
				for (int a = 0; a < com.length; a++) {
				     com[a].setEnabled(true);
				}
				
			}
		});
	}
	public void createPartyPanel(Party party) {	
		partyPanel.removeAll();
		partyPanel.update(party);
		partyPanel.setVisible(true);
		
		//Disable Background components
		Component[] com = getComponents();
		for (int a = 0; a < com.length; a++) {
		     com[a].setEnabled(false);
		}		
	}	

	public JLabel getCurrentCityLabel() {
		return lblCurrentCity;
	}	
	
	public JLabel getCurrentGoldLabel() {
		return lblCurrentGold;
	}

	
	public JButton getBtnParty() {
		return btnViewParty;
	}
	
	public ArrayList<JButton> getTravelButtons(){
		return travelButtons;
	}
	
	public JButton getMapButton() {
		return mapButton;
	}
	
	// DEBUG BUTTONS DELETE BEFORE FINISH TODO
//	public JButton getBtnShop() {
//		return btnShop;
//	}
//	public JButton getBtnLair() {
//		return btnLair;
//	}
//	public JButton getBtnHospital() {
//		return btnHospital;
//	}
//	public JButton getBtnPowerUpDen() {
//		return btnPowerUpDen;
//	}
}

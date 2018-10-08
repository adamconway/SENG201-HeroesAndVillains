package gui;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import classes.GameVariables;
import classes.Inventory;
import classes.Item;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class PowerUpDenPanel extends JPanel {
	
	private JScrollPane itemScrollPane;	
	private JPanel itemsPanel;
	private UseItemPanel[] items;
	private JButton btnBack;
	private JLabel lblPowerUpDen;
	/**
	 * Create the panel.
	 */
	public PowerUpDenPanel() {
		
		setBackground(Color.WHITE);
		setSize(900,600);
		setLayout(null);
		
		btnBack = new JButton("Back to HomeBase");
		btnBack.setBounds(68, 523, 165, 23);
		add(btnBack);
		
		itemsPanel = new JPanel();
		itemsPanel.setBorder(null);
		itemsPanel.setBackground(Color.WHITE);
		itemsPanel.setLayout(null);
		itemsPanel.setPreferredSize(new Dimension(300, GameVariables.powerUps.size()*90));
		
		itemScrollPane = new JScrollPane(itemsPanel);
		itemScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		itemScrollPane.setBounds(300, 130, 300, 358);
		add(itemScrollPane);
		
		lblPowerUpDen = new JLabel("Power Up Den");
		lblPowerUpDen.setHorizontalAlignment(SwingConstants.CENTER);
		lblPowerUpDen.setFont(new Font("Serif", Font.PLAIN, 30));
		lblPowerUpDen.setBounds(300, 27, 300, 39);
		add(lblPowerUpDen);
		
		items = new UseItemPanel[GameVariables.powerUps.size()];
		for (int i = 0; i < GameVariables.powerUps.size(); i++) {
			Item item = GameVariables.powerUps.get(i);
			items[i] = new UseItemPanel(item);
			items[i].setBounds(0,i*90,300,90);
			itemsPanel.add(items[i]);
			
		}
	}
	
	public void update(Inventory inventory) {
		int index = 0;
		for (UseItemPanel panel : items) {
			panel.setAmountOwned(inventory.getCount(GameVariables.powerUps.get(index)));
			index++;
			if (panel.getAmountOwned() == 0) {
				panel.getUseButton().setEnabled(false);
			} else {
				panel.getUseButton().setEnabled(true);
			}
			}						
		}

	
//	public void updateAmountOwned(Inventory inventory) {
//		for (int i = 0; i < GameVariables.powerUps.size(); i++) {
//			items[i].setAmountOwned(inventory.getInventory().get(GameVariables.powerUps.get(i)));
//			if (items[i].getAmountOwned() == 0) {
//				items[i].getUseButton().setEnabled(false);
//			} else {
//				items[i].getUseButton().setEnabled(true);
//			}
//		}
//	}

	
	public UseItemPanel[] getItems() {
		return items;
	}
	
	public JButton getBackButton() {
		return btnBack;
	}

}

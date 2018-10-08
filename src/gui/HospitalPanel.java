package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import classes.GameVariables;
import classes.Inventory;
import classes.Item;
import classes.TimerTime;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class HospitalPanel extends JPanel {

	
	private JScrollPane itemScrollPane, healsScrollPane;	
	private JPanel itemsPanel, healsPanel;
	private UseItemPanel[] items;
	private ActiveHealPanel[] heals;
	private JButton btnBack;
	private JLabel lblHospital;
	
	/**
	 * Create the panel.
	 */
	public HospitalPanel() {
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
		itemsPanel.setPreferredSize(new Dimension(300, GameVariables.healingItems.size()*90));
		
		healsPanel = new JPanel();
		healsPanel.setBorder(null);
		healsPanel.setBackground(Color.WHITE);
		healsPanel.setLayout(null);
		healsPanel.setPreferredSize(new Dimension(300, 350));
		
		itemScrollPane = new JScrollPane(itemsPanel);
		itemScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		itemScrollPane.setBounds(106, 129, 300, 358);
		add(itemScrollPane);
		
		healsScrollPane = new JScrollPane(healsPanel);
		healsScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		healsScrollPane.setBounds(450, 129, 300, 358);
		add(healsScrollPane);
		
		lblHospital = new JLabel("Hospital");
		lblHospital.setHorizontalAlignment(SwingConstants.CENTER);
		lblHospital.setFont(new Font("Serif", Font.PLAIN, 30));
		lblHospital.setBounds(300, 26, 300, 39);
		add(lblHospital);
		
		JLabel lblNewLabel = new JLabel("Currently Active Heals");
		lblNewLabel.setBounds(487, 103, 214, 15);
		add(lblNewLabel);
		
		items = new UseItemPanel[GameVariables.healingItems.size()];
		for (int i = 0; i < GameVariables.healingItems.size(); i++) {
			Item item = GameVariables.healingItems.get(i);
			items[i] = new UseItemPanel(item);
			items[i].setBounds(0,i*90,300,90);
			itemsPanel.add(items[i]);
			
		}
		
		
	}
	
	public void update(Inventory inventory, ArrayList<TimerTime> heals) {
		int index = 0;
		for (UseItemPanel panel : items) {
			panel.setAmountOwned(inventory.getCount(GameVariables.healingItems.get(index)));
			index++;
			if (panel.getAmountOwned() == 0) {
				panel.getUseButton().setEnabled(false);
			} else {
				panel.getUseButton().setEnabled(true);
			}
			}			
		healsPanel.removeAll();
		this.heals = new ActiveHealPanel[heals.size()];
		for (int i = 0; i < heals.size(); i++) {
			this.heals[i] = new ActiveHealPanel(heals.get(i));
			this.heals[i].setBounds(0,i*90,300,90);
			healsPanel.add(this.heals[i]);
		}

		

		
	}
	
	public void updateAmountOwned(Inventory inventory) {
		for (int i = 0; i < GameVariables.healingItems.size(); i++) {
			items[i].setAmountOwned(inventory.getInventory().get(GameVariables.healingItems.get(i)));
			if (items[i].getAmountOwned() == 0) {
				items[i].getUseButton().setEnabled(false);
			} else {
				items[i].getUseButton().setEnabled(true);
			}
		}
	}
	
	public UseItemPanel[] getItems() {
		return items;
	}
	
	public JButton getBackButton() {
		return btnBack;
	}
}
package gui;

import javax.swing.JPanel;

import classes.GameVariables;
import classes.Inventory;
import classes.Item;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.Font;

public class ShopPanel extends JPanel {
	
	private int currentGold;
	
	private ArrayList<Item> shopHealingItems = new ArrayList<>();
	private ArrayList<Item> shopPowerUps = new ArrayList<>();
	
	private ShopItemPanel[] healingItems;
	private ShopItemPanel[] powerUps;
	
	private JButton btnBack;
	private JLabel lblCurrentGold;
	private JLabel lblShop;
	private JLabel lblHealingItems;	
	private JLabel lblPowerUps;
	
	private JScrollPane healingItemScrollPane;	
	private JScrollPane powerUpScrollPane;
	private JPanel healingItemsPanel;
	private JPanel powerUpsPanel;
	private JButton btnBuyMap;
	private JLabel lblMapCount;

	/**
	 * Create the panel.
	 */
	public ShopPanel() {
		setBackground(Color.WHITE);
		setSize(900,600);
		setLayout(null);
		
		// Adds Healing items from External File "ItemsLists.java"
		
		for (int i = 0; i < GameVariables.healingItems.size(); i++) {
			shopHealingItems.add(GameVariables.healingItems.get(i));
		}
		
		// Adds Power Ups from External File "ItemLists.java"
		
		for (int i = 0; i < GameVariables.powerUps.size(); i++) {
			shopPowerUps.add(GameVariables.powerUps.get(i));
		}
		
		healingItemsPanel = new JPanel();
		healingItemsPanel.setBorder(null);
		healingItemsPanel.setBackground(Color.WHITE);
		healingItemsPanel.setLayout(null);
		healingItemsPanel.setPreferredSize(new Dimension(300, (shopHealingItems.size())*90));
		
		healingItems = new ShopItemPanel[shopHealingItems.size()];
		for (int i = 0; i < shopHealingItems.size(); i++) {
			Item item = shopHealingItems.get(i);
			healingItems[i] = new ShopItemPanel(i,item.getName(), item.getDescription(), item.getCost(), item.getIcon());
			healingItems[i].setBounds(0, i*90, 300, 90);
			healingItemsPanel.add(healingItems[i]);
		}
		
		powerUpsPanel = new JPanel();
		powerUpsPanel.setBackground(Color.WHITE);
		powerUpsPanel.setLayout(null);
		powerUpsPanel.setPreferredSize(new Dimension(300, (shopPowerUps.size())*90));
		
		powerUps = new ShopItemPanel[shopPowerUps.size()];
		for (int i = 0; i < shopPowerUps.size(); i++) {
			Item item = shopPowerUps.get(i);
			powerUps[i] = new ShopItemPanel(i,item.getName(), item.getDescription(), item.getCost(), item.getIcon());
			powerUps[i].setBounds(0, i*90, 300, 90);
			powerUpsPanel.add(powerUps[i]);
		}
		
		
		
		healingItemScrollPane = new JScrollPane(healingItemsPanel);
		healingItemScrollPane.setBounds(120, 130, 300, 358);
		healingItemScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		add(healingItemScrollPane);
		
		powerUpScrollPane = new JScrollPane(powerUpsPanel);
		powerUpScrollPane.setBounds(480, 130, 300, 358);
		powerUpScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		add(powerUpScrollPane);
		
		// Other Gui
		
		btnBack = new JButton("Back to HomeBase");
		btnBack.setBounds(68, 523, 165, 23);
		add(btnBack);
		
		lblCurrentGold = new JLabel(""+currentGold);
		lblCurrentGold.setBounds(53, 47, 99, 14);
		add(lblCurrentGold);
		
		lblShop = new JLabel("Shop");
		lblShop.setFont(new Font("Serif", Font.PLAIN, 30));
		lblShop.setHorizontalAlignment(SwingConstants.CENTER);
		lblShop.setBounds(382, 27, 133, 39);
		add(lblShop);
		
		lblHealingItems = new JLabel("Healing Items");
		lblHealingItems.setFont(new Font("Serif", Font.PLAIN, 20));
		lblHealingItems.setHorizontalAlignment(SwingConstants.CENTER);
		lblHealingItems.setBounds(214, 78, 133, 29);
		add(lblHealingItems);
		
		lblPowerUps = new JLabel("Power Ups");
		lblPowerUps.setFont(new Font("Serif", Font.PLAIN, 20));
		lblPowerUps.setHorizontalAlignment(SwingConstants.CENTER);
		lblPowerUps.setBounds(571, 78, 165, 29);
		add(lblPowerUps);
		
		btnBuyMap = new JButton("Buy Map");
		btnBuyMap.setBounds(663, 522, 158, 25);
		add(btnBuyMap);
		
		lblMapCount = new JLabel("Maps: 0");
		lblMapCount.setBounds(717, 44, 104, 15);
		add(lblMapCount);
		
		
		
	}
	public JButton buyMap() {
		return btnBuyMap;
	}
	
	public void setMapCount(int i) {
		lblMapCount.setText("Maps: " + i);
	}
	
	
	public JButton getBackButton() {
		return btnBack;
	}

	public ShopItemPanel[] getHealingItems() {
		return healingItems;
	}

	public ShopItemPanel[] getPowerUps() {
		return powerUps;
	}
	
	public void updateGold(int gold) {
		lblCurrentGold.setText(""+gold);
	}
	
	public void update(int gold, Inventory healingInv, Inventory poweUpInv) {
		int index = 0;
		currentGold = gold;
		lblCurrentGold.setText(""+currentGold);
		if(gold < 250) {
			btnBuyMap.setEnabled(false);
		} else{
			btnBuyMap.setEnabled(true);
		}
		for (ShopItemPanel panel : healingItems) {
			panel.setAmountOwned(healingInv.getCount(GameVariables.healingItems.get(index)));
			if(panel.getItemCost() > gold) {
				panel.getBuyButton().setEnabled(false);
			} else {
				panel.getBuyButton().setEnabled(true);
			}
			index++;
		}
		index = 0;
		for (ShopItemPanel panel : powerUps) {
			panel.setAmountOwned(poweUpInv.getCount(GameVariables.powerUps.get(index)));
			if(panel.getItemCost() > gold) {
				panel.getBuyButton().setEnabled(false);
			} else {
				panel.getBuyButton().setEnabled(true);
			}
			index++;
		}
	}
}

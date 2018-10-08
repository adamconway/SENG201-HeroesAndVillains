package gui;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

public class ShopItemPanel extends JPanel {
	
	private int index;
	private String itemName;
	private ImageIcon icon;
	private int itemCost;
	private String itemDescription;
	private JButton buyItem;
	private int amountOwned;
	
	private JLabel lblItemPicture;
	private JLabel lblItemName;
	private JLabel lblDesciprtion;
	private JLabel lblAmountOwned;
	private JLabel lblItemCost;
	/**
	 * Create the panel.
	 */
	public ShopItemPanel(int index,String itemName,String itemDescription, int itemCost, ImageIcon icon) {
		this.index = index;
		this.itemCost = itemCost;
		this.itemName = itemName;
		this.icon = icon;
		this.itemDescription = itemDescription;
		
		setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		setBackground(Color.WHITE);

		setSize(300, 90);
		setLayout(null);
		
		lblItemPicture = new JLabel(icon);
		lblItemPicture.setHorizontalAlignment(SwingConstants.CENTER);
		lblItemPicture.setBounds(16, 10, 50, 50);
		add(lblItemPicture);
		
		buyItem = new JButton("Buy");
		buyItem.setBounds(215, 20, 61, 50);
		add(buyItem);
		
		lblItemName = new JLabel(itemName);
		lblItemName.setHorizontalAlignment(SwingConstants.CENTER);
		lblItemName.setBounds(65, 10, 150, 14);
		add(lblItemName);
		
		lblDesciprtion = new JLabel(itemDescription);
		lblDesciprtion.setHorizontalAlignment(SwingConstants.CENTER);
		lblDesciprtion.setBounds(65, 25, 148, 33);
		add(lblDesciprtion);
		
		lblAmountOwned = new JLabel("You Own: "+amountOwned);
		lblAmountOwned.setHorizontalAlignment(SwingConstants.CENTER);
		lblAmountOwned.setBounds(65, 65, 148, 14);
		add(lblAmountOwned);
		
		lblItemCost = new JLabel("Cost: "+itemCost);
		lblItemCost.setHorizontalAlignment(SwingConstants.CENTER);
		lblItemCost.setBounds(0, 65, 79, 14);
		add(lblItemCost);
	}

	public void setAmountOwned(int amountOwned) {
		this.amountOwned = amountOwned;
		lblAmountOwned.setText("You Own: "+amountOwned);
	}
	
	public JButton getBuyButton() {
		return buyItem;
	}
	
	public void changeButtonState(boolean state) {
		buyItem.setEnabled(state);
	}
	
	public void updateAmount(int amount) {
		setAmountOwned(amount);
		lblAmountOwned.setText("You Own: "+amountOwned);
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public int getItemCost() {
		return itemCost;
	}

}

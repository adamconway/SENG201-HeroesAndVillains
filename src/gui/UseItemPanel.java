package gui;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

import classes.Item;

public class UseItemPanel extends JPanel {
	
	private Item item;
	private String itemName;
	private ImageIcon icon;
	private String itemDescription;
	private JButton useItem;
	private int amountOwned;
	
	private JLabel lblItemPicture;
	private JLabel lblItemName;
	private JLabel lblDesciprtion;
	private JLabel lblAmountOwned;

	/**
	 * Create the panel.
	 */
	public UseItemPanel(Item item) {
		this.item = item;
		this.itemName = item.getName();
		this.icon = item.getIcon();
		this.itemDescription = item.getDescription();
		
		setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		setBackground(Color.WHITE);

		setSize(300, 90);
		setLayout(null);
		
		lblItemPicture = new JLabel(icon);
		lblItemPicture.setHorizontalAlignment(SwingConstants.CENTER);
		lblItemPicture.setBounds(12, 20, 50, 50);
		add(lblItemPicture);
		
		useItem = new JButton("Use");
		useItem.setBounds(215, 20, 61, 50);
		useItem.putClientProperty("item", item);
		add(useItem);
		
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
	}
	
	public void setAmountOwned(int amountOwned) {
		this.amountOwned = amountOwned;
		lblAmountOwned.setText("You Own: "+amountOwned);
		if (this.amountOwned <= 0) {
			useItem.setEnabled(false);
		} else {
			useItem.setEnabled(true);
		}
	}
	
	public JButton getUseButton() {
		return useItem;
	}
	
	public int getAmountOwned() {
		return amountOwned;
	}
	
	public void changeButtonState(boolean state) {
		useItem.setEnabled(state);
	}
	
	public void updateAmount(int amount) {
		setAmountOwned(amount);
		lblAmountOwned.setText("You Own: "+amountOwned);
	}
	
	public Item getItem() {
		return item;
	}
	

}
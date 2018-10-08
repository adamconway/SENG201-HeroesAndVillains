package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import classes.Party;

import javax.swing.JLabel;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SelectHeroDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private Party party;
	private ArrayList<JRadioButton> buttons = new ArrayList<>();
	private ButtonGroup buttonGroup = new ButtonGroup();
	private int result = -1;
	/**
	 * Create the dialog.
	 */
	public SelectHeroDialog(Party party) {
		super();
		setModal(true);
		this.party = party;
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		// Title Labels
		{
			JLabel lblSelectAHero = new JLabel("Select a Hero");
			lblSelectAHero.setBounds(178, 11, 125, 14);
			contentPanel.add(lblSelectAHero);
		}
		{
			JLabel lblHeroName = new JLabel("Hero Name");
			lblHeroName.setBounds(12, 53, 102, 14);
			contentPanel.add(lblHeroName);
		}
		{
			JLabel lblCurrentHp = new JLabel("Current Hp");
			lblCurrentHp.setBounds(112, 53, 102, 14);
			contentPanel.add(lblCurrentHp);
		}
		{
			JLabel lblAttack = new JLabel("Attack");
			lblAttack.setBounds(226, 53, 46, 14);
			contentPanel.add(lblAttack);
		}
		{
			JLabel lblDefense = new JLabel("Defense");
			lblDefense.setBounds(297, 53, 60, 14);
			contentPanel.add(lblDefense);
		}
		{
			JLabel lblType = new JLabel("Type");
			lblType.setBounds(366, 53, 46, 14);
			contentPanel.add(lblType);
		}
	
		{
		for (int i = 0; i < party.getHeroList().size(); i++) {		
			System.out.println(i);
			JRadioButton radioButton = new JRadioButton(party.getHero(i).getName());
			radioButton.setBounds(10, 80+i*50, 120, 23);
			contentPanel.add(radioButton);
			buttons.add(radioButton);
			

			
			JLabel lblHeroHp = new JLabel(party.getHero(i).getHpString() + "HP");
			lblHeroHp.setBounds(112, 80+i*50, 80, 14);
			contentPanel.add(lblHeroHp);
			
			JLabel lblHattackl = new JLabel(""+party.getHero(i).getAttack());
			lblHattackl.setBounds(230, 80+i*50, 46, 14);
			contentPanel.add(lblHattackl);
			
			JLabel lblHdef = new JLabel(""+party.getHero(i).getDefense());
			lblHdef.setBounds(297, 80+i*50, 46, 14);
			contentPanel.add(lblHdef);
			
			JLabel lblHtype = new JLabel(party.getHero(i).getType());
			lblHtype.setBounds(355, 80+i*50, 60, 14);
			contentPanel.add(lblHtype);
		}
		}
		
		for (int i = 0; i < buttons.size(); i++){
			buttonGroup.add(buttons.get(i));
		}
		
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						for (int i = 0; i <buttons.size(); i++) {
							if(buttons.get(i).isSelected()) {
								result = i;
							}
						}
						setVisible(false);
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	public int selectHero(){
		setVisible(true);
		return result;
	}
}

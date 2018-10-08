package gui;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;

import classes.GameVariables;
import classes.HelperFunction;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.Icon;

public class HeroSelectPanel extends JPanel {
	
	private JTextField txtHeroName;
	private JComboBox<String> heroType;
	private JLabel lblDescription, lblIcon;
	private JProgressBar heroHealth, heroAttack, heroDefense;
	/**
	 * Create the panel.
	 */
	public HeroSelectPanel() {
		setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		setBounds(75, 145, 200, 310);
		setLayout(null);
		
		txtHeroName = new JTextField();
		txtHeroName.setBounds(91, 22, 86, 20);
		add(txtHeroName);
		txtHeroName.setColumns(10);
		
		heroType = new JComboBox<String>();
		heroType.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int index = heroType.getSelectedIndex();
				lblDescription.setText("<html>" + GameVariables.heroTypes.get(index).getShortDescription() + "</html>");
				lblIcon.setIcon(HelperFunction.resizeIcon(new ImageIcon(HeroSelectPanel.class.getResource(GameVariables.heroTypes.get(index).getIconUrl())), 70,70));
				heroAttack.setValue(GameVariables.heroTypes.get(index).getAttack());
				heroHealth.setValue(GameVariables.heroTypes.get(index).getHp());
				heroDefense.setValue(GameVariables.heroTypes.get(index).getDefense());
			}
		});
		heroType.setMaximumRowCount(6);
		heroType.setBounds(91, 50, 86, 20);
		add(heroType);
		
		lblDescription = new JLabel("");
		lblDescription.setHorizontalAlignment(SwingConstants.LEFT);
		lblDescription.setBounds(22, 78, 155, 48);
		add(lblDescription);
		
		lblIcon = new JLabel((Icon) null);
		lblIcon.setBounds(65, 137, 70, 70);
		add(lblIcon);
		
		heroHealth = new JProgressBar();
		heroHealth.setMaximum(200);
		heroHealth.setBounds(91, 224, 86, 14);
		add(heroHealth);
		
		heroAttack = new JProgressBar();
		heroAttack.setBounds(91, 249, 86, 14);
		add(heroAttack);
		
		heroDefense = new JProgressBar();
		heroDefense.setMaximum(10);
		heroDefense.setBounds(91, 274, 86, 14);
		add(heroDefense);
		
		JLabel lblDefence = new JLabel("Defence:");
		lblDefence.setBounds(22, 274, 71, 14);
		add(lblDefence);
		
		JLabel lblAttack = new JLabel("Attack:");
		lblAttack.setBounds(22, 249, 71, 14);
		add(lblAttack);
		
		JLabel lblHealth = new JLabel("Health:");
		lblHealth.setBounds(22, 224, 71, 14);
		add(lblHealth);
				
		JSeparator sep = new JSeparator();
		sep.setBounds(22, 211, 155, 2);
		add(sep);
		
		JLabel lblName = new JLabel("Hero Name:");
		lblName.setBounds(22, 25, 71, 14);
		add(lblName);
		
		JLabel lblType = new JLabel("Hero Type:");
		lblType.setBounds(22, 53, 71, 14);
		add(lblType);
		
		for (int i = 0; i < GameVariables.heroTypes.size(); i++) {
			heroType.addItem(GameVariables.heroTypes.get(i).getName());
		}
	}
	
	
	public String getName() {
		return txtHeroName.getText();
	}
	
	public JComboBox<String> getType(){
		return heroType;
	}

}

package gui;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;

import classes.HelperFunction;
import classes.Hero;
import classes.Villain;

public class HealthUI extends JPanel {
	
	private JLabel lblHeroIcon;
	private JProgressBar heroHealthBar;
	private JLabel lblHeroAttack;
	private JLabel lblHeroType;
	private JLabel lblHeroDefense;
	private JLabel lblHeroName;
	private JLabel lblHeroHp;
	
	
	private JLabel lblVillainIcon;
	private JProgressBar villainHealthBar;
	private JLabel lblVillainAttack;
	private JLabel lblVillainDefense;
	private JLabel lblVillainName;
	private JLabel lblVillainHp;

	/**
	 * Create the panel.
	 */
	public HealthUI() {		
		setSize(900,80);
		setLayout(null);
		
		//HERO UI
		
		lblHeroIcon = new JLabel(HelperFunction.resizeIcon(new ImageIcon(HealthUI.class.getResource("/images/heroes/questionmark.png")), 50, 50));
		lblHeroIcon.setBounds(10, 10, 50, 50);
		add(lblHeroIcon);
		
		heroHealthBar = new JProgressBar();
		heroHealthBar.setForeground(Color.GREEN);
		heroHealthBar.setMaximum(100);
		heroHealthBar.setValue(0);
		heroHealthBar.setBounds(80, 35, 150, 14);
		add(heroHealthBar);
		
		lblHeroAttack = new JLabel("Attack: ?");
		lblHeroAttack.setBounds(248, 10, 123, 14);
		add(lblHeroAttack);
		
		lblHeroType = new JLabel("Type: ?");
		lblHeroType.setBounds(248, 46, 148, 14);
		add(lblHeroType);
		
		lblHeroDefense = new JLabel("Defense: ?");
		lblHeroDefense.setBounds(248, 28, 123, 14);
		add(lblHeroDefense);
		
		lblHeroName = new JLabel("?????");
		lblHeroName.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeroName.setBounds(83, 15, 147, 14);
		add(lblHeroName);
		
		lblHeroHp = new JLabel("?/?HP");
		lblHeroHp.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeroHp.setBounds(80, 50, 150, 14);
		add(lblHeroHp);
		
		//Villain UI
		
		lblVillainIcon = new JLabel(HelperFunction.resizeIcon(new ImageIcon(HealthUI.class.getResource("/images/heroes/merchant.png")), 50, 50));
		lblVillainIcon.setBounds(838, 10, 50, 50);
		add(lblVillainIcon);
		
		villainHealthBar = new JProgressBar();
		villainHealthBar.setValue(100);
		villainHealthBar.setForeground(Color.RED);
		villainHealthBar.setBounds(670, 35, 150, 14);
		add(villainHealthBar);
		
		lblVillainHp = new JLabel("100/100HP");
		lblVillainHp.setHorizontalAlignment(SwingConstants.CENTER);
		lblVillainHp.setBounds(670, 50, 150, 14);
		add(lblVillainHp);
		
		lblVillainName = new JLabel("Villain Name");
		lblVillainName.setHorizontalAlignment(SwingConstants.CENTER);
		lblVillainName.setBounds(670, 15, 147, 14);
		add(lblVillainName);
		
		lblVillainAttack = new JLabel("Attack : 20");
		lblVillainAttack.setBounds(535, 10, 123, 14);
		add(lblVillainAttack);
		
		lblVillainDefense = new JLabel("Defense : 12");
		lblVillainDefense.setBounds(535, 28, 123, 14);
		add(lblVillainDefense);
	}
	
	public void update(Hero hero, Villain villain) {
		//Update Hero
		lblHeroName.setText(hero.getName());
		lblHeroIcon.setIcon((HelperFunction.resizeIcon(hero.getIcon(), 50, 50)));
		
		heroHealthBar.setMaximum(hero.getMaxHealth());
		heroHealthBar.setValue(hero.getCurrentHealth());
		
		lblHeroAttack.setText("Attack: "+hero.getAttack());
		lblHeroDefense.setText("Defense: "+hero.getDefense());
		lblHeroType.setText("Type: " + hero.getType());
		lblHeroHp.setText(hero.getHpString()+"HP");
		
		//Update Villain
		lblVillainName.setText(villain.getName());
		lblVillainIcon.setIcon((HelperFunction.resizeIcon(villain.getIcon(), 50, 50)));
		
		villainHealthBar.setMaximum(villain.getMaxHealth());
		villainHealthBar.setValue(villain.getCurrentHealth());
		lblVillainAttack.setText("Attack: "+villain.getAttack());
		lblVillainDefense.setText("Defense: "+villain.getDefense());
		lblVillainHp.setText(villain.getHpString()+"HP");
	}
	
	public void update(Villain villain) {
		//Update Villain
		lblVillainName.setText(villain.getName());
		lblVillainIcon.setIcon((HelperFunction.resizeIcon(villain.getIcon(), 50, 50)));
		
		villainHealthBar.setMaximum(villain.getMaxHealth());
		villainHealthBar.setValue(villain.getCurrentHealth());
		lblVillainAttack.setText("Attack: "+villain.getAttack());
		lblVillainDefense.setText("Defense: "+villain.getDefense());
		lblVillainHp.setText(villain.getHpString()+"HP");
	}
	
	public void reset() {
		lblHeroName.setText("?????");
		lblHeroIcon.setIcon(HelperFunction.resizeIcon(new ImageIcon(HealthUI.class.getResource("/images/heroes/questionmark.png")), 50, 50));		
		heroHealthBar.setValue(0);		
		lblHeroAttack.setText("Attack: ?");
		lblHeroDefense.setText("Defense: ?");
		lblHeroType.setText("Type: ?");
		lblHeroHp.setText("?/?HP");
		
	}
}

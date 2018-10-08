package gui;

import javax.swing.JPanel;

import classes.HelperFunction;
import classes.Hero;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;

public class HeroStatsPanel extends JPanel {
	
	private JLabel lblIcon;
	private JProgressBar healthBar;
	private JLabel lblAttack;
	private JLabel lblType;
	private JLabel lblDefense;
	private JLabel lblName;
	private JLabel lblHp;
	/**
	 * Create the panel. 
	 */
	public HeroStatsPanel(Hero hero) {
		setBackground(Color.WHITE);
		setLayout(null);
		setSize(400,70); 
		
		lblIcon = new JLabel(HelperFunction.resizeIcon(hero.getIcon(), 50, 50));
		lblIcon.setBounds(10, 10, 50, 50);
		add(lblIcon);
		 
		healthBar = new JProgressBar();
		healthBar.setForeground(Color.GREEN);
		healthBar.setMaximum(hero.getMaxHealth());
		healthBar.setValue(hero.getCurrentHealth());
		healthBar.setBounds(80, 35, 150, 14);
		add(healthBar);
		
		lblAttack = new JLabel("Attack : "+hero.getAttack());
		lblAttack.setBounds(248, 10, 123, 14);
		add(lblAttack);
		
		lblType = new JLabel("Type : " + hero.getType());
		lblType.setBounds(248, 46, 148, 14);
		add(lblType);
		
		lblDefense = new JLabel("Defense : "+hero.getDefense());
		lblDefense.setBounds(248, 28, 123, 14);
		add(lblDefense);
		
		lblName = new JLabel(hero.getName());
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setBounds(83, 15, 147, 14);
		add(lblName);
		
		lblHp = new JLabel(hero.getHpString()+"HP");
		lblHp.setHorizontalAlignment(SwingConstants.CENTER);
		lblHp.setBounds(80, 50, 150, 14);
		add(lblHp);

	}
}

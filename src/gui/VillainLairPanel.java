package gui;

import java.awt.CardLayout;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

import classes.HelperFunction;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class VillainLairPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	private RockPaperScissorsPanel rpsPanel;
	private DiceGamePanel diceGamePanel;
	private HighLowPanel highLowPanel;
	private PregamePanel pregame;
	private HealthUI healthUI;
	
	private CardLayout cardLayout;
	private JPanel gameContainer;
	private JLabel lblWin;
	private CombatLog combatLog;
	private CityDefeatedPanel cityDefeatedPanel;
	 
	private JButton btnNextGame, btnNextCity, btnSelectHero;
	
	public VillainLairPanel() {
		setLayout(null);
		setSize(900,600);
		
		cardLayout = new CardLayout();
		gameContainer = new JPanel();
		gameContainer.setSize(650,420);
		gameContainer.setBounds(0,80,650,420);		
		gameContainer.setLayout(cardLayout);
		add(gameContainer);
		
		healthUI = new HealthUI();
		healthUI.setBounds(0,0,900,80);
		healthUI.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		add(healthUI);
		
		combatLog = new CombatLog();
		combatLog.setBounds(650,80,250,520);
		combatLog.setBorder(new MatteBorder(0, 1, 0, 0, (Color) new Color(0, 0, 0)));
		add(combatLog);
		
		cityDefeatedPanel = new CityDefeatedPanel();
		gameContainer.add(cityDefeatedPanel, "cityDefeatedPanel");
		
		rpsPanel = new RockPaperScissorsPanel();
		gameContainer.add(rpsPanel, "rps");
		
		diceGamePanel = new DiceGamePanel();
		gameContainer.add(diceGamePanel, "diceGame");
		
		highLowPanel = new HighLowPanel();
		gameContainer.add(highLowPanel, "highLow");
		
		pregame = new PregamePanel();
		gameContainer.add(pregame, "pregame");

		btnNextGame = new JButton("Next Game");
		HelperFunction.buttonStyle(btnNextGame);
		btnNextGame.setBounds(438, 500, 200, 50);
		add(btnNextGame);
		
		btnNextCity = new JButton("Next City");
		HelperFunction.buttonStyle(btnNextCity);
		btnNextCity.setBounds(438, 500, 200, 50);
		btnNextCity.setEnabled(false);
		btnNextCity.setVisible(false);
		add(btnNextCity);
		
		btnSelectHero = new JButton("Select Hero");
		HelperFunction.buttonStyle(btnSelectHero);
		btnSelectHero.setBounds(10, 500, 200, 50);
		add(btnSelectHero);
	
		
		lblWin = new JLabel("");
		lblWin.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblWin.setIcon(new ImageIcon(MainMenuPanel.class.getResource("/images/locations/villainlair/winlabel.png")));
		lblWin.setHorizontalAlignment(SwingConstants.CENTER);
		lblWin.setBounds(228, 500, 200, 50);
		lblWin.setHorizontalTextPosition(JButton.CENTER);
		lblWin.setVerticalTextPosition(JButton.CENTER);
		lblWin.setVisible(false);
		add(lblWin);
	}
	//BUTTONS
	
	public void btnDeadHero() {
		btnSelectHero.setEnabled(true);
		btnSelectHero.setVisible(true);
		
		btnNextCity.setEnabled(false);
		btnNextCity.setVisible(false);
		
		btnNextGame.setEnabled(false);
		btnNextGame.setVisible(true);
	}
	
	public void btnCityDefeated() {
		btnSelectHero.setEnabled(false);
		btnSelectHero.setVisible(false);
		
		btnNextCity.setEnabled(true);
		btnNextCity.setVisible(true);
		
		btnNextGame.setEnabled(false);
		btnNextGame.setVisible(false);
	}
	
	public void btnInGame() {
		btnSelectHero.setEnabled(false);
		btnSelectHero.setVisible(true);
		
		btnNextCity.setEnabled(false);
		btnNextCity.setVisible(false);
		
		btnNextGame.setEnabled(false);
		btnNextGame.setVisible(true);
	}
	
	public void btnNextGame() {
		btnSelectHero.setEnabled(true);
		btnSelectHero.setVisible(true);
		
		btnNextCity.setEnabled(false);
		btnNextCity.setVisible(false);
		
		btnNextGame.setEnabled(true);
		btnNextGame.setVisible(true);
	}
	
	public JButton getNextGameButton() {
		return btnNextGame;
	}
	
	public JButton getSelectHeroButton() {
		return btnSelectHero;
	}
	
	public JButton getNextCityButton() {
		return btnNextCity;
	}
	
	//Label for Win
	public void lblWin(String string) {
		if (string == "win") {
			lblWin.setIcon(new ImageIcon(MainMenuPanel.class.getResource("/images/locations/villainlair/winlabel.png")));
			lblWin.setText("Win!");
			lblWin.setVisible(true);
		} else if (string == "loss") {
			lblWin.setIcon(new ImageIcon(MainMenuPanel.class.getResource("/images/locations/villainlair/losslabel.png")));
			lblWin.setText("Loss");
			lblWin.setVisible(true);
		} else if (string == "draw") {	
			lblWin.setIcon(new ImageIcon(MainMenuPanel.class.getResource("/images/locations/villainlair/drawlabel.png")));
			lblWin.setText("Draw");
			lblWin.setVisible(true);
		} else {
			lblWin.setVisible(false);
		}
	}

	public CombatLog getCombatLog() {
		return combatLog;
	}
	public PregamePanel getPregame() {
		return pregame;
	}
	
	public RockPaperScissorsPanel getRockPaperScissors() {
		return rpsPanel;
	}
	
	public DiceGamePanel getDiceGamePanel() {
		return diceGamePanel;
	}
	
	public HighLowPanel getHighLowPanel() {
		return highLowPanel;
	}
	
	public JLabel getLblWin() {
		return lblWin;
	}
	
	public JPanel getGameContainer() {
		return gameContainer;
	}
	
	public void showCard(String card) {
		cardLayout.show(gameContainer, card);
	}
	
	public HealthUI getHealthUI() {
		return healthUI;
	}
	
	public void reset() {
		cardLayout.show(gameContainer, "pregame");
		healthUI.reset();
		btnDeadHero();
		lblWin.setText("");
		lblWin.setVisible(false);
	}
}

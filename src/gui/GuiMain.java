package gui;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;


import classes.GameMap;
import classes.GameVariables;
import classes.Hero;
import classes.HeroType;
import classes.Party;
import java.awt.Toolkit;

/** 
 * GuiMain is the main class for the Heroes And Villains application.
 * 
 * @author Adam Conway
 * @author Flynn Doherty
 */

public class GuiMain {	
	
	/**
	 * This function is the main function for the Heroes And Villains application
	 * 
	 * @param args the args supplied by a cli
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		GuiMain window = new GuiMain();
		window.frame.setVisible(true);
	}
	
	private JFrame frame;
	private JPanel mainContainer;
	private MainMenuPanel mainMenu;
	private CardLayout cardLayout;	
	private Game game;	
	private NewGamePanel newGame;
	private HelpPanel help;	
	
	public GuiMain() {		
		initialise();
		loadMainMenu();
		loadHelpMenu();	
		loadNewGameMenu();
		showMainMenu();
	}
	
	private void initialise() {
		cardLayout = new CardLayout();
		mainContainer = new JPanel(cardLayout);
		frame = new JFrame();
		frame.getContentPane().add(mainContainer);

		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setResizable(false);		
		frame.pack();
		frame.setTitle("Heroes and Villains");
		frame.setSize(new Dimension(900,600));
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(GuiMain.class.getResource("/images/other/icon_77.png")));
	}

	private void showMainMenu() {
		cardLayout.show(mainContainer, "mainMenu");		
	}
	
	private void loadMainMenu() {
		mainMenu = new MainMenuPanel();
		mainContainer.add(mainMenu, "mainMenu");
		
		mainMenu.getBtnNewGame().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(mainContainer, "newGame");
			}
		});
		mainMenu.getBtnHelp().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(mainContainer, "help");
			}
		});
		mainMenu.getBtnQuit().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				frame.dispose();
			}
		});
	}
	
	private void loadNewGameMenu() {
		newGame = new NewGamePanel();
		mainContainer.add(newGame, "newGame");
		
		// Load back button
		newGame.getBtnBack().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(mainContainer, "mainMenu");
			}
		});
		
		
		// Load the party name text field and listen for changes.
		// If a change occurs, check the validity of the party name and show an error if need be.		
		newGame.getPartyNameTextField().getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) { warning(); }
			@Override
			public void removeUpdate(DocumentEvent e) { warning(); }
			@Override
			public void changedUpdate(DocumentEvent e) { warning();	}
			public void warning() {
		    	if ((newGame.getPartyNameTextField().getText().trim()).length() < 2) {
		    		newGame.setPartyErrorLabel("Please enter a longer party name.");
		    		newGame.getPartyErrorLabel().setVisible(true);
		    		newGame.getBtnNext().setEnabled(false);
		    	} else if ((newGame.getPartyNameTextField().getText().trim()).length() > 11) {
		    		newGame.setPartyErrorLabel("Please enter a shorter party name.");
		    		newGame.getPartyErrorLabel().setVisible(true);
		    		newGame.getBtnNext().setEnabled(false);
		    	} else {
		    		newGame.getPartyErrorLabel().setVisible(false);
		    		newGame.getBtnNext().setEnabled(true);
		    	}
			}
		});
		
		// Load the number of heroes slider and listen for changes.
		// If a change occurs, update the hero panels accordingly.
		newGame.getNumberOfHeroesSlider().addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				switch (newGame.getNumberOfHeroesSlider().getValue()) {
	            case 1:  
	            	newGame.getHeroPanels()[1].setVisible(false);
	            	newGame.getHeroPanels()[2].setVisible(false);
	                break;
	            case 2:  
	            	newGame.getHeroPanels()[1].setVisible(true);
	            	newGame.getHeroPanels()[2].setVisible(false);
	                break;
	            case 3:
	            	newGame.getHeroPanels()[1].setVisible(true);
	            	newGame.getHeroPanels()[2].setVisible(true);
	                break;
	            default:
	            	newGame.getHeroPanels()[1].setVisible(true);
	            	newGame.getHeroPanels()[2].setVisible(false);
	            	break;
			}	

			}
		});
		
		// Check if any error label is visible, if it is, do nothing.
		// If it isn't, load the Game.
		newGame.getBtnNext().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (newGame.correctHeroNames()) {
					Party party = new Party(newGame.getPartyName());
					for (int i = 0; i < newGame.getNumberOfHeroes(); i++) {
					
						HeroType heroType = GameVariables.heroTypes.get(newGame.getHeroPanels()[i].getType().getSelectedIndex());
						party.addHero(new Hero(newGame.getHeroPanels()[i].getName(), heroType.getIconUrl(), heroType.getAttack(),
								heroType.getDefense(), heroType.getHp(),heroType.getName(),heroType.getDescription(),heroType.getShortDescription()));
					}
					game = new Game(party, new GameMap(newGame.getNumberOfCities()));
					mainContainer.add(game, "game");
					setupGamePanels();
					cardLayout.show(mainContainer, "game");
					
					
				} else {
					newGame.displayError();
				}
			}
		});		
	}
	
	private void loadHelpMenu() {
		help = new HelpPanel();
		mainContainer.add(help, "help");
		help.getBtnBack().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(mainContainer, "mainMenu");
			}
		});		
	}
	
	//Setup Game win/loss panel return to menu buttons
	public void setupGamePanels() {
		game.getVictoryPanel().getMainMenuButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadNewGameMenu();
				cardLayout.show(mainContainer, "mainMenu");			
			}	
			
		});	

	}
	
}

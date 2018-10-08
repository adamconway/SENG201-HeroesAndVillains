package gui;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import classes.DiceGame;
import classes.GameMap;
import classes.GameVariables;
import classes.HealingItem;
import classes.HelperFunction;
import classes.Hero;
import classes.HighLow;
import classes.Party;
import classes.PowerUp;
import classes.RockPaperScissors;
import classes.TimerTime;


public class Game extends JPanel {

	//Game Variables
	private int currentCity;
	private int lastCity;
	private GameMap map;
	private Party party;
	private String gameName;
	private int selectedHero;
	private ArrayList<TimerTime> currentHeals = new ArrayList<TimerTime>();
	
	//GUI VARIABLES	
	private CardLayout cardLayout;
	
	
	//Setup Panels
	// Game Panels
	private HomebasePanel homebase;
	private ShopPanel shop;
    private PowerUpDenPanel powerUpDen;
    private VillainLairPanel villainLair;
	private HospitalPanel hospital;
    
    //Other Panels
    GameVictoryPanel victoryPanel = new GameVictoryPanel();   
	
	
	//END GUI VARIABLES
	/**
	 * Create the panel.
	 */
	public Game() {
		windowSetup();
		cardLayout.show(this, "homebase");
	}
	
	public Game(Party party, GameMap map) {
		this.lastCity = map.getMapSize()-1;
		this.map = map;
		this.party = party;
		this.gameName = party.getPartyName();
		windowSetup();
	}

	private void windowSetup() {
		cardLayout = new CardLayout();
		setLayout(cardLayout);
		setSize(900, 600);
		
		//Non-Gameplay Panels
		//City Defeat Panel
		
		
		//Add Game win/loss panels
		add(victoryPanel, "victoryPanel");
		
		
		//Homebase Setup
		loadHomease();
		 
		//Shop Setup
		loadShop();
		

		//PowerUpDen Setup
		loadPowerUpDen();
		
		//Hospital Setup
		loadHospital();
		
		//Villain Lair Setup
		loadVillainsLair();
		
		showHomebase();
	}
	
	private void showScreen(String name) {
		cardLayout.show(Game.this, name);
	}

	//GET AND SETTERS
	
	public int getCurrentCity() {
		return currentCity;
	}

	public void setCurrentCity(int currentCity) {
		this.currentCity = currentCity;
	}

	public int getLastCity() {
		return lastCity;
	}

	public void setLastCity(int lastCity) {
		this.lastCity = lastCity;
	}

	public GameMap getMap() {
		return map;
	}

	public void setMap(GameMap map) {
		this.map = map;
	}

	public Party getParty() {
		return party;
	}

	public void setParty(Party party) {
		this.party = party;
	}

	public String getGameName() {
		return gameName;
	}

	public void setGameName(String gameName) {
		this.gameName = gameName;
	}
	
	public GameVictoryPanel getVictoryPanel() {
		return victoryPanel;
	}


	//GUI CODE
	
	public void loadHomease() {
		homebase = new HomebasePanel();
		add(homebase, "homebase");
		
		homebase.getMapButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				map.getCity(currentCity).setAllVisible();
				party.removeMap();
				showHomebase();
			}
		});
		
		//DEV BUTTONS REMOVE LATER
		//SHOP
//		homebase.getBtnShop().addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				shop.update(party.currentGold(), party.getHealingItems(), party.getPowerUps());
//				showScreen("shop");
//			}
//		});
		
		//Party Button
		homebase.getBtnParty().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				homebase.createPartyPanel(party);
			}
		});
		
//		//PowerUpDenButton
//		homebase.getBtnPowerUpDen().addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				showPowerUpDen();
//			}
//		});
//		
//		//LAIR BUTTON
//		homebase.getBtnLair().addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {	
//				showVillainLair();
//			}
//		});
//		
//		homebase.getBtnHospital().addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {	
//				showHospital();
//			}
//		});
	}
	
	private void nextCity() {
		currentCity += 1;
		showHomebase();
	}

	public void loadShop() {
		//Construct the Shop
		shop = new ShopPanel();
		add(shop, "shop");		
		//Shop Back Button
		shop.getBackButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showHomebase();
				
			}
			
		});
		
		shop.buyMap().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				party.removeGold(250);
				party.addMap();
				shop.update(party.currentGold(), party.getHealingItems(), party.getPowerUps());
				shop.setMapCount(party.getMaps());
			}
			
		});
		
		//Add Listeners to Buy Buttons
		
		for (int i = 0; i < shop.getHealingItems().length; i++) {
			int index = i;
			shop.getHealingItems()[i].getBuyButton().addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					party.addHealingItem(GameVariables.healingItems.get(shop.getHealingItems()[index].getIndex()));
					party.removeGold((int)Math.round(GameVariables.healingItems.get(index).getCost()*party.merchantDiscount()));
					shop.updateGold(party.currentGold());
					shop.getHealingItems()[index].updateAmount(party.getHealingItems().getCount(GameVariables.healingItems.get(index)));
					shop.update(party.currentGold(), party.getHealingItems(), party.getPowerUps());
				}
				
			});
		}
		
		for (int i = 0; i < shop.getPowerUps().length; i++) {
			int index = i;
			shop.getPowerUps()[i].getBuyButton().addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					party.addPowerUp(GameVariables.powerUps.get(shop.getPowerUps()[index].getIndex()));
					party.removeGold((int)Math.round(GameVariables.powerUps.get(index).getCost()*party.merchantDiscount()));
					shop.updateGold(party.currentGold());
					shop.getPowerUps()[index].updateAmount(party.getPowerUps().getCount(GameVariables.powerUps.get(index)));
					shop.update(party.currentGold(), party.getHealingItems(), party.getPowerUps());
				}
				
			});
		}
			
	}
	
	public void loadPowerUpDen() {
		powerUpDen = new PowerUpDenPanel();
		add(powerUpDen, "powerUpDen");
		powerUpDen.update(party.getPowerUps());
		
		powerUpDen.getBackButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showHomebase();				
			}			
		});
		
		for (UseItemPanel panel: powerUpDen.getItems()) {
			panel.getUseButton().addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					SelectHeroDialog dialog = new SelectHeroDialog(party);
		    		int selectedHero = dialog.selectHero();
		    		if(selectedHero!=-1) {
		    			party.getHero(selectedHero).giveItem((PowerUp) panel.getUseButton().getClientProperty("item"));
			    		party.getPowerUps().removeItem((PowerUp) panel.getUseButton().getClientProperty("item"));
			    		powerUpDen.update(party.getPowerUps());
		    		}
		    		
				}
				
			});
		}
	}
	
	public void loadHospital() {
		hospital = new HospitalPanel();
		add(hospital, "hospital");
		hospital.update(party.getHealingItems(), currentHeals);
		hospital.getBackButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showHomebase();				
			}			
		});
		for (UseItemPanel panel: hospital.getItems()) {
			panel.getUseButton().addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					SelectHeroDialog select = new SelectHeroDialog(party);
					int heroNum = select.selectHero();
					if(heroNum != -1) {
						createHealTimer(party.getHero(heroNum),(HealingItem) panel.getUseButton().getClientProperty("item"));
						party.getHealingItems().removeItem((HealingItem) panel.getUseButton().getClientProperty("item"));
						hospital.update(party.getHealingItems(),currentHeals);
				}
				}
				
			});
		}
		
		
	}
	
	
	
	public void loadVillainsLair() {
		
		//Create Villain Lair Panel and add to Game Panel
		villainLair = new VillainLairPanel();		
		add(villainLair, "villainLair");
		showPregame();	
		
		
		//==============================================================================================
		//Main Game Control Panel
		//Next Game Button
		villainLair.getNextGameButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				villainLair.lblWin("");
				villainLair.btnInGame();
				playGame();				
			}
			
		});
		
		//Select Hero Button
		villainLair.getSelectHeroButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				villainLair.btnNextGame();
				showPregame();			
			}
			
		});
			
		//Next City button
		villainLair.getNextCityButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nextCity();
			}
			
		});
		//================================================================================================
		//Create Game Logic Classes - No GUI just Win/Lose/Moves
		RockPaperScissors rps = new RockPaperScissors();
		DiceGame diceGame = new DiceGame();
		HighLow highLow = new HighLow();
		
		//Dice Game Panel
		villainLair.getDiceGamePanel().getDiceButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				villainLair.getDiceGamePanel().getHeroRoll().setText(""+diceGame.heroRoll());
				villainLair.getDiceGamePanel().getVillainRoll().setText(""+diceGame.villainRoll());
				gameStatus(diceGame.getStatus());
				
			}
			
		});
		//code for high low game
		villainLair.getHighLowPanel().getGuessButton1().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				highLow.setVillainNumber();
				highLow.setHeroGuess(villainLair.getHighLowPanel().guess());
				if(highLow.guess() == "correct") {
					villainLair.getHighLowPanel().lock();
					gameStatus(highLow.getStatus());
					
				} else {
					villainLair.getHighLowPanel().setBtnGuess2();
					if (highLow.guess() == "high") {
						villainLair.getHighLowPanel().getLblResult().setText("Too High");
						
					} else if (highLow.guess() == "low") {
						villainLair.getHighLowPanel().getLblResult().setText("Too Low");
					} else {
						villainLair.getHighLowPanel().getLblResult().setText("ERROR");
					}
				}
				
			}
			
		});
		//Code for high low game
		villainLair.getHighLowPanel().getGuessButton2().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				villainLair.getHighLowPanel().lock();
				highLow.setHeroGuess(villainLair.getHighLowPanel().guess());
				if (highLow.guess() == "high") {
					villainLair.getHighLowPanel().getLblResult().setText("Too High");
					
				} else if (highLow.guess() == "low") {
					villainLair.getHighLowPanel().getLblResult().setText("Too Low");
				} else {
					villainLair.getHighLowPanel().getLblResult().setText("Correct");
				}
				villainLair.getHighLowPanel().getLblVillainNumber().setText(""+highLow.getVillainNumber());
				villainLair.getHighLowPanel().showVillainGuess();
				gameStatus(highLow.getStatus());
			}
		});
		
		//Paper Scissors Rock Panel
		//Rock Button
		villainLair.getRockPaperScissors().getBtnRock().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				villainLair.getRockPaperScissors().lock();
				rps.setPlayerMove(1);
				villainLair.getRockPaperScissors().setVillainMove(rps.getVillainMove());
				gameStatus(rps.getStatus());
				
			}
			
		});
		//Paper Button
		villainLair.getRockPaperScissors().getBtnPaper().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				villainLair.getRockPaperScissors().lock();
				rps.setPlayerMove(2);
				villainLair.getRockPaperScissors().setVillainMove(rps.getVillainMove());
				gameStatus(rps.getStatus());
			}
			
		});
		//Scissors Button
		villainLair.getRockPaperScissors().getBtnScissors().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				villainLair.getRockPaperScissors().lock();
				rps.setPlayerMove(3);
				villainLair.getRockPaperScissors().setVillainMove(rps.getVillainMove());
				gameStatus(rps.getStatus());
			}			 
		});
	}
	
	//Plays the Game Selected
	private void playGame() {
		villainLair.getDiceGamePanel().reset();
		villainLair.getHighLowPanel().reset();
		villainLair.getRockPaperScissors().reset();
		Random random = new Random();
		int game =  random.nextInt(3) + 1;
		switch(game) {
		case 1:
			villainLair.showCard("rps");
			break;
		case 2:
			villainLair.showCard("diceGame");
			break;
		case 3:
			villainLair.showCard("highLow");
			break;
		}
	}
	
	//Checks result of Game and calls correct functions
	private void gameStatus(String result) {
		if (result == "win") {
			villainLair.lblWin("win");	
			damageVillain(selectedHero);
			checkCityStatus();			

		} else if (result == "lose") {
			villainLair.lblWin("loss");	
			damageHero(selectedHero);
			checkHeroStatus();
			
		} else if (result == "draw") {
			villainLair.btnNextGame();
			villainLair.lblWin("draw");	
			
		}
		
//		villainLair.getPregame().update(party);
	}
	//Adds to villain lair combat panel
	private void addCombatLog(String string) {
		villainLair.getCombatLog().addLine(string);
	}
	
	private void damageHero(int hero) {
		party.getHero(hero).takeDamage(map.getCity(currentCity).getVillain().getAttack());
		//Add to Combat Log
		addCombatLog(party.getHero(hero).getName() + " took " + map.getCity(currentCity).getVillain().getAttack() +
				" damage from " + map.getCity(currentCity).getVillain().getName());
		updateHealthUI();
	}
	
	private void damageVillain(int hero) {
		map.getCity(currentCity).getVillain().takeDamage(party.getHero(hero).dealDamage());
		//Add to Combat Log+
		addCombatLog(party.getHero(hero).getName() + " dealt " + party.getHero(hero).dealDamage() +
				" damage to " + map.getCity(currentCity).getVillain().getName());
		updateHealthUI();
	}

	private void checkCityStatus() {
		updateHealthUI();
		if (!map.getCity(currentCity).getStatus()) {
			if (gameVictory()) {
				victoryScreen();
			} else {
				villainLair.showCard("cityDefeatedPanel");
				villainLair.btnCityDefeated();
				
			
				
			}		
		} else {
			villainLair.btnNextGame();
		}
	}
	
	private void checkHeroStatus() {
		if (!party.getHero(selectedHero).getStatus()) {
			Hero hero = party.getHero(selectedHero);
			party.removeHero(party.getHero(selectedHero));				
			if (party.getHeroList().isEmpty()) {
				System.out.print("You Lose");
				lossScreen();
			}	else {
				showPregame();
				updateHealthUI();
				villainLair.getHealthUI().reset();
				villainLair.btnDeadHero();
			}

			//DIALOG POPUP HERO HAS BEEN KILLED
			} else {
				updateHealthUI();
				villainLair.btnNextGame();
			}
		}

	
	private boolean gameVictory() {
		if (!map.getCity(lastCity).getStatus()) {
			return true;
		} else {
			return false;
		}
	}
	
	private void updateHealthUI() {
		villainLair.getHealthUI().update(party.getHero(selectedHero), map.getCity(currentCity).getVillain());
	}
	
	private void showPregame() {
		villainLair.getPregame().update(party);
		for (JButton button: villainLair.getPregame().getButtons()) {
			button.addActionListener(new ActionListener() {				
				public void actionPerformed(ActionEvent e) {
					selectedHero = (int) button.getClientProperty("heroNum");
					updateHealthUI();
					villainLair.btnNextGame();
				}				
			});
		}
		villainLair.showCard("pregame");
	}
	
	private void victoryScreen() {
		showScreen("victoryPanel");
	}
	
	private void lossScreen() {
		
			}

	public void showShop() {
		shop.update(party.currentGold(), party.getHealingItems(), party.getPowerUps());
		showScreen("shop");
	}
	
	public void showPowerUpDen() {		
		powerUpDen.update(party.getPowerUps());
		showScreen("powerUpDen");
	}
	
	public void showVillainLair() {
		villainLair.reset();
		villainLair.getHealthUI().update(map.getCity(currentCity).getVillain());
		showPregame();
		showScreen("villainLair");
	}
	
	public void showHospital() {
		hospital.update(party.getHealingItems(), currentHeals);		
		showScreen("hospital");
		
	}
	
	public void showHomebase() {
		if (party.getMaps() > 0) {
			homebase.getMapButton().setEnabled(true);
		} else {
			homebase.getMapButton().setEnabled(false);
		}
		for(JButton button : homebase.getTravelButtons()) {
			for( ActionListener al : button.getActionListeners() ) {
				button.removeActionListener( al );
		    }
			int direction = (int) button.getClientProperty("direction");			
			if (map.getCity(currentCity).isVisible(direction)) {
				button.setText(map.getCity(currentCity).getDestination(direction));
			}	else {
				button.setText((String) button.getClientProperty("name"));
			}
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					switch(map.getCity(currentCity).getDestination(direction)) {
					case "Shop":
						map.getCity(currentCity).setShopVisible(true);
						showShop();
						break;
					case "Power Up Den":
						map.getCity(currentCity).setPowerUpDenVisible(true);
						showPowerUpDen();
						break;
					case "Villain Lair":
						map.getCity(currentCity).setVillainLairVisible(true);
						int answer = JOptionPane.showConfirmDialog(Game.this, "You have found the Lair! Enter Lair?");
					    if (answer == JOptionPane.YES_OPTION) {
					    	showVillainLair();
					    	answer = JOptionPane.showConfirmDialog(Game.this, map.getCity(currentCity).getVillain().getName() + 
					    			"says: " + map.getCity(currentCity).getVillain().getQuote());
						    if (answer == JOptionPane.YES_OPTION) {
						    } else if (answer == JOptionPane.NO_OPTION) {
						
						    }
					    } else if (answer == JOptionPane.NO_OPTION) {
					
					    }
						
						
						break;
					case "Hospital":
						map.getCity(currentCity).setHospitalVisible(true);
						showHospital();
						break;
					}
				}
				
			});
		}
		homebase.getCurrentCityLabel().setText("Current City " + (currentCity+1) + "/" + (lastCity+1));
		homebase.getCurrentGoldLabel().setText(""+party.currentGold());
		
		showScreen("homebase");
		if(HelperFunction.chance(10)) {
			randomEvent();
			System.out.println("test");
		}
	}
	
	private void randomEvent() {
		CustomPopUp popup = new CustomPopUp("You have been given an item! Check your inventory to see it");
		party.addPowerUp(GameVariables.powerUps.get(0));
	}

	
	public void createHealTimer(Hero hero, HealingItem item) {
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			int times = 0;	
			TimerTime display;
			public void run() {					
				if (times == 0) {
					display = new TimerTime(hero.getName(),(int) Math.round(item.getHealAmount()*0.25*100),(int)((item.getHealAmount()+1-times)*item.getHealTime()));;
					currentHeals.add(display);
					times++;
				} else {
					hero.heal((int) Math.round((hero.getMaxHealth()*0.25)*party.HealBonus()));
					System.out.print("Healed "+ hero.getName() + " for 25%");

					times++;
					display.setTimeRemaining((int)((item.getHealAmount()+1-times)*item.getHealTime()));
				
					if (times == item.getHealAmount()+1) {
						currentHeals.remove(display);
						timer.cancel();
					}
				
				
				}
			}
			
		}, 0, item.getHealTime()*1000);
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}

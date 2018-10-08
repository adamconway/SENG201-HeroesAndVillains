package classes;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.util.Random;
import java.util.Scanner;

import javax.swing.ButtonModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import gui.MainMenuPanel;

//import com.google.gson.Gson;
//import com.google.gson.stream.JsonReader;

/** 
 * HelperFunction is a utility class for the Heros And Villians application.
 * 
 * It contains proceedures that were repeated numerous times throughout.
 * 
 * @author Adam Conway
 * @author Flynn Doherty 
 */

public class HelperFunction {
	
	/** 
	 * @param lower is the lowest value bound.
	 * @param upper is the highest value bound.
	 * @return the player's decision as an integer. 
	 */
	public static int IntRange(int lower, int upper) {
		return IntRange(lower, upper, "");
	}
	
	/**
	 * @param lower is the lowest value bound.
	 * @param upper is the highest value bound.
	 * @param menuText is the question text to display if the player enters invalid input.
	 * @return the player's decision as an integer.
	 */
	public static int IntRange(int lower, int upper, String menuText) {
		int player_input = -1;
		boolean validInput = false;
		Scanner input_stream = new Scanner(System.in);
		while(!validInput) {			
			if (input_stream.hasNextInt()) {
				player_input = input_stream.nextInt();
				if(player_input >= lower &&
						player_input <= upper) {
					validInput = true;
				} else {
					System.out.println("Input not in range. Please try again");
					System.out.println(menuText);
				}
			} else {
				input_stream.next();
				System.out.println("Not a valid option. Please enter an Integer");
				System.out.println(menuText);
			}
		}
		return player_input;
	}
	
	/**
	 * @param odds is the "1 in x" chance, where x is the integer value of odds.
	 * @return whether the player has succeeded or failed the pseudo random odds calculation.
	 */
	public static boolean chance(int odds) { 
		Random rand = new Random();
		int number = rand.nextInt(odds) + 1;
		if (number == 1) {
			return true;
		} else {
			return false;
		}
	}
	
	public static Icon resizeIcon(ImageIcon icon, int resizedWidth, int resizedHeight) {
	    Image img = icon.getImage();  
	    Image resizedImage = img.getScaledInstance(resizedWidth, resizedHeight,  java.awt.Image.SCALE_SMOOTH);  
	    return new ImageIcon(resizedImage);
	}
	
	public static void buttonStyle(JButton button) {
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Tahoma", Font.BOLD, 20));
		button.setIcon(new ImageIcon(MainMenuPanel.class.getResource("/images/gui/blue_button04.png")));
		button.setHorizontalTextPosition(JButton.CENTER);
		button.setVerticalTextPosition(JButton.CENTER);
		button.setContentAreaFilled(false); 
		button.setFocusPainted(false); 
		button.setOpaque(false);
		button.setBorderPainted(false);
		button.getModel().addChangeListener(new ChangeListener() {
		    @Override
		    public void stateChanged(ChangeEvent e) {
		        ButtonModel model = (ButtonModel) e.getSource();
		        if (model.isRollover()) {
		        	button.setIcon(new ImageIcon(MainMenuPanel.class.getResource("/images/gui/blue_button05.png")));
		        } else {
		        	button.setIcon(new ImageIcon(MainMenuPanel.class.getResource("/images/gui/blue_button04.png")));
		        }
		    }
		});
	}
	
	
}

package classes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/** 
 * City is an instantiatable class for the Heroes And Villains application.
 * 
 * It holds information about city composition and is the basis for .
 * 
 * @author Adam Conway
 * @author Flynn Doherty
 */

public class City {
	// Initializes City Destinations
	
	
	private Villain villain;
	
	private ArrayList<String> destinations;
	private String cityName;
	private boolean cityStatus, shopVisible, powerUpDenVisible, hospitalVisible, villainLairVisible;
	
	/** 
	 * Construct the @City and instantiate the: @Hospital, @PowerUpDen, @Shop and @VillainLair
	 * 
	 * Each city is treated as a 'round' in the game and must be beaten to advance to the next city. 
	 */
	City(boolean lastCity) {
		shopVisible = false;
		powerUpDenVisible = false;
		hospitalVisible = false;
		villainLairVisible = false;
		if (lastCity) {
			villain = new Villain("Villain","/images/heroes/tank.png", 20, 10, 200);
		} else {
			villain = new Villain("Villain","/images/heroes/tank.png", 20, 10, 100);
		}		
		cityName = "City Name"; // needs to be randomized with code TODO
		cityStatus = true;		
		destinations = new ArrayList<>(Arrays.asList("Shop", "Power Up Den", "Hospital", "Villain Lair"));
		Collections.shuffle(destinations);
	}
	
	public String getDestination(int index) {
		return destinations.get(index);
	}
	
	public boolean isVisible(int index) {
		String destination = destinations.get(index);
		switch(destination){
		case "Shop":
			return shopVisible;
		case "Power Up Den":
			return powerUpDenVisible;
		case "Villain Lair":
			return villainLairVisible;
		case "Hospital":
			return hospitalVisible;
		}
		return false;		
	}
		
	public void setAllVisible() {
		shopVisible = true;
		powerUpDenVisible = true;
		hospitalVisible = true;
		villainLairVisible = true;
	}
	
	public void setShopVisible(boolean shopVisible) {
		this.shopVisible = shopVisible;
	}

	public void setPowerUpDenVisible(boolean powerUpDenVisible) {
		this.powerUpDenVisible = powerUpDenVisible;
	}

	public void setHospitalVisible(boolean hospitalVisible) {
		this.hospitalVisible = hospitalVisible;
	}

	public void setVillainLairVisible(boolean villainLairVisible) {
		this.villainLairVisible = villainLairVisible;
	}

	public boolean getStatus() {
		if (villain.getStatus()) {
			cityStatus = true;
		} else {
			cityStatus = false;
		}
		return cityStatus;
	}
	
	public boolean isDefeated() {
		return cityStatus;
	}

	public String getCityName() {
		return cityName;
	}

	public Villain getVillain() {
		return villain;
	}

}

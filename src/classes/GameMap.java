package classes;
import java.util.ArrayList;

/** 
 * Map is a class for the Heroes And Villains application.
 * 
 * It binds all of the cities together and can be saved to a file. 
 * 
 * @author Adam Conway
 * @author Flynn Doherty
 */

public class GameMap {
	
	private int numberOfCities;
	private ArrayList<City> cities;
	
	/**
	 * Constructs the map given the following parameters:
	 * 
	 * @param number The number of cities the user selected to be on the map (Integer).
	 * 
	 * Initializes the numberOfCities to the value of number (Integer).
	 * Initializes the ArrayList by adding numberOfCities Cities (ArrayList).
	 */	
	public GameMap(int number) {
		cities = new ArrayList<>();
		numberOfCities = number;
		for (int i = 0; i<numberOfCities; i++) {
			if (i == numberOfCities-1) {
				cities.add(new City(true));
			} else {
				cities.add(new City(false));
			}
			
		}
	}	
	
	/**
	 * This returns the city at the given index in the cities ArrayList.
	 * @param index The index of city to be returned.
	 * @return the city at the given index.
	 */
	public City getCity(int index) {
		return cities.get(index);
	}
		
	/**
	 * @return the current map size
	 */
	public int getMapSize() {
		return cities.size();
	}
	
}

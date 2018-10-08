package classes;

/** 
 * TimerTimer is a class for the Heroes And Villains application.
 * 
 * @author Adam Conway
 * @author Flynn Doherty
 */

public class TimerTime {
	private String heroName;
	private int healAmount;
	private int timeRemaining;
	
	/**
	 * @param heroName is the name of the target hero
	 * @param healAmount is the amount of health to heal the hero
	 * @param timeRemaining is the amount of time remaining on the healing potion
	 */
	public TimerTime(String heroName, int healAmount, int timeRemaining){
		this.heroName = heroName;
		this.healAmount = healAmount;
		this.timeRemaining = timeRemaining;		
	}
	
	// Getters and Setters
	
	public String getHeroName() {
		return heroName;
	}

	public void setHeroName(String heroName) {
		this.heroName = heroName;
	}

	public int getHealAmount() {
		return healAmount;
	}

	public void setHealAmount(int healAmount) {
		this.healAmount = healAmount;
	}

	public int getTimeRemaining() {
		return timeRemaining;
	}

	public void setTimeRemaining(int timeRemaining) {
		this.timeRemaining = timeRemaining;
	}
	
	
}

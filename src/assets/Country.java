package assets;

import handlers.CountryHandler;
import handlers.Observable;
import handlers.Observer;

import java.util.HashSet;

import situationStrategies.AnyFrontierStrategy;
import situationStrategies.FrontierStrategy;

/**
 *  Class that represents a country in the game.
 *
 */
public class Country implements Observable{
	
	private static FrontierStrategy frontierStrategy = new AnyFrontierStrategy();
	
	private String name;
	private int soldiers;
	private Player owner;
	
	private HashSet<Observer> observers;
	
	public Country(String name) {
		this.name = name;
		this.soldiers = 1;
		observers = new HashSet<Observer>();
		this.addObserver(new CountryHandler(this));
	}
	/**
	 * Starts a battle between two countries if they can attack one another.
	 * @param enemy
	 * @return If a battle could be started.
	 */
	public boolean attack(Country enemy){
		if(this.soldiers == 1)
			return false;
		if(enemy.getOwner().equals(this.owner))
			return false;
		if(!GameManager.getInstance().getGameBox().getBoard().adjacentCountries(this, enemy))
			return false;
		if(!frontierStrategy.attackSituationChecker(this, enemy))
			return false;
		if(Battle.conflict(this, enemy)){
			Console.add(owner.getName() + " won the battle and conquered " + enemy.getName() + ".");
			GameManager.getInstance().objectivesCheck();
			GameManager.getInstance().conqueredACountry();
			notifyObservers();
		}
		else{
			Console.add(enemy.getOwner().getName() + " won the battle and defended " + enemy.getName() + " successfully.");
		}
		return true;
	}
	
	/**
	 * Moves one troop to another country if its possible.
	 * @param ally
	 * @return If the movement of troops was made.
	 */
	public boolean moveSoldiers(Country ally){
		if(this.soldiers == 1)
			return false;
		if(!ally.getOwner().equals(this.owner))
			return false;
		if(!GameManager.getInstance().getGameBox().getBoard().adjacentCountries(this, ally))
			return false;
		ally.incrementSoldiers();
		this.soldiers--;
		Console.add(owner.getName() + " moved a soldier from " + this.getName() + " to " + ally.getName() + ".");
		notifyObservers();
		return true;
	}
	/**
	 * Removes troops and tells if the country was conquered.
	 * @param kills number of troops to be substracted.
	 * @return If the country was conquered.
	 */
	public boolean killSoldiers(int kills){
		if(kills >= soldiers){
			soldiers = 1;
			notifyObservers();
			return true;
		}	
		this.soldiers -= kills;
		notifyObservers();
		return false;
	}
	/**
	 * Changes the owner of the country. Also removes this country from the old owner.
	 * @param newOwner
	 */
	public void changeOwner(Player newOwner){
		if(owner != null)
			owner.removeCountry(this);
		owner = newOwner;
		owner.addCountry(this);
		notifyObservers();
	}
	
	public Continent getContinent(){
		return GameManager.getInstance().getGameBox().getBoard().continentContainer(this);
	}
	/**
	 * Increments troops by one.
	 */
	public void incrementSoldiers(){
		soldiers++;
		notifyObservers();
		Console.add( this.owner.getName() + " added a soldier to " + this.name + ".");
	}
	///////////////////////////
	/////Getters & Setters/////
	///////////////////////////
	
	public String getName() {
		return name;
	}

	public int getSoldiers() {
		return soldiers;
	}
	
	public Player getOwner() {
		return owner;
	}

	public static void setFrontierStrategy(FrontierStrategy frontierStrategy) {
		Country.frontierStrategy = frontierStrategy;
	}

	@Override
	public void addObserver(Observer observer) {
		observers.add(observer);
	}

	@Override
	public void removeObserver(Observer observer) {
		observers.remove(observer);	
	}

	@Override
	public void notifyObservers() {
		for (Observer observer : observers) {
			observer.handleUpdate(this);
		}	
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Country other = (Country) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}

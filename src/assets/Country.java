package assets;

import java.util.HashSet;

import handlers.Observable;
import handlers.Observer;
import situationStrategies.AnyFrontierStrategy;
import situationStrategies.FrontierStrategy;


public class Country implements Observable{
	
	private static FrontierStrategy frontierStrategy = new AnyFrontierStrategy();
	
	private String name;
	private int soldiers;
	private Player owner;
	
	private HashSet<Observer> observers;
	
	public Country(String name) {
		this.name = name;
		this.soldiers = 1;
	}

	public boolean attack(Country enemy){
		if(this.soldiers == 1)
			return false;
		if(enemy.getOwner().equals(this.owner))
			return false;
		if(!GameManager.getInstance().getGameBox().getBoard().adjacentCountries(this, enemy))
			return false;
		if(!frontierStrategy.attackSituationChecker(this, enemy))
			return false;
		Battle.conflict(this, enemy);
		return true;
	}
	
	public boolean moveSoldiers(Country ally){
		if(this.soldiers == 1)
			return false;
		if(!ally.getOwner().equals(this.owner))
			return false;
		if(!GameManager.getInstance().getGameBox().getBoard().adjacentCountries(this, ally))
			return false;
		ally.incrementSoldiers();
		this.soldiers--;
		return true;
	}
	
	public boolean killSoldiers(int kills){
		if(kills >= soldiers){
			soldiers = 1;
			return true;
		}	
		this.soldiers -= kills;
		return false;
	}
	
	public void changeOwner(Player newOwner){
		owner.removeCountry(this);
		owner = newOwner;
		owner.addCountry(this);
	}
	
	public Continent getContinent(){
		return GameManager.getInstance().getGameBox().getBoard().continentContainer(this);
	}
	
	public void incrementSoldiers(){
		soldiers++;
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

}

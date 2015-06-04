package assets;

import handlers.Observable;
import handlers.Observer;

import java.util.HashSet;
import java.util.Set;

import objectives.Objective;

public class Player implements Observable {
	
	private String name;
	private String color;
	
	private Objective objective;
	
	private int totalSoldiers;
	private int leftOverSoldiers;
	
	private Set<Country> countries;
	private Set<CountryCard> cards;
	
	private HashSet<Observer> observers;
	
	public Player(String name, String color) {
		this.name = name;
		this.color = color;
		this.totalSoldiers = 0;
		this.leftOverSoldiers = 0;
		this.countries = new HashSet<Country>();
		this.cards = new HashSet<CountryCard>();
		this.observers = new HashSet<Observer>();
	}
	
	
	public boolean hasLost(){
		return ((totalSoldiers == 0) ? true : false);
	}
	
	public int countriesNumber(){
		return countries.size();
	}
	
	public void removeCountry(Country country){
		countries.remove(country);
		notifyObservers();
	}
	
	public void addCountry(Country country){
		countries.add(country);
		notifyObservers();
	}
	
	//TODO Add troops if player has the country.
	public void addCountryCard(CountryCard card){
		cards.add(card);
		notifyObservers();
	}
	
	public int continentCountries(Continent continent){
		int i = 0;
		for (Country country : countries) {
			if(continent.contains(country))
				i++;
		}
		return i;
	}
	
	public boolean hasContinent(Continent continent){
		return (continentCountries(continent) == continent.getCountriesNumber());
	}

	public String getName() {
		return name;
	}

	public String getColor() {
		return color;
	}

	public Objective getObjective() {
		return objective;
	}

	public int getTotalSoldiers() {
		return totalSoldiers;
	}

	public int getLeftOverSoldiers() {
		return leftOverSoldiers;
	}

	public Set<Country> getCountries() {
		return countries;
	}

	public Set<CountryCard> getCards() {
		return cards;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		return result;
	}

	// A nuestros fines, nos es pr�ctico ver dos jugadores iguales si tienen el mismo color.
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Player other = (Player) obj;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		return true;
	}
	
	public void setName(String name) {
		this.name = name;
		notifyObservers();
	}


	public String toString() {
		return name + " - " + color;
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

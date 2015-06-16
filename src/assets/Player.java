package assets;

import handlers.Observable;
import handlers.Observer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import objectives.Objective;

public class Player implements Observable {
	
	private String name;
	private String color;
	
	private Boolean isDead;
	
	private Objective objective;
	
	private int totalSoldiers;
	private int cardExchangeNumber;
	
	private Set<Country> countries;
	private Set<CountryCard> cards;
	
	private HashSet<Observer> observers;
	
	public Player(String name, String color, Objective objective) {
		this.name = name;
		this.color = color;
		this.totalSoldiers = 0;
		this.isDead = false;
		this.countries = new HashSet<Country>();
		this.cards = new HashSet<CountryCard>();
		this.observers = new HashSet<Observer>();
		this.setObjective(objective);
		this.cardExchangeNumber = 0;
		System.out.println("Creado jugador " + name + " " + color + ".");
	}
	
	
	public boolean hasLost(){
		return isDead;
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
		if(countries.contains(card.getCountry()))
			card.getCountry().incrementSoldiers();
		notifyObservers();
	}
	
	public boolean returnCountryCards(String cardName1, String cardName2, String cardName3){
		CountryCard card1 = null;
		CountryCard card2 = null;
		CountryCard card3 = null;
		
		for (CountryCard countryCard : cards) {
			if(countryCard.getCountry().getName().equals(cardName1))
				card1 = countryCard;
			if(countryCard.getCountry().getName().equals(cardName2))
				card2 = countryCard;
			if(countryCard.getCountry().getName().equals(cardName3))
				card3 = countryCard;
		}
		
		if(card1 == null || card2 == null || card3 == null)
			return false;
		else if(CardType.cardExchangeCheck(card1.getType(), card2.getType(), card3.getType()))
			return false;
		else
		GameManager.getInstance().getGameBox().returnCountryCards(card1, card2, card3);
		cards.remove(card1);
		cards.remove(card2);
		cards.remove(card3);
		cardExchangeNumber++;
		return true;
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
	
	public int getLeftOverSoldiers() {
		
		int troops = Math.floorDiv(countriesNumber(), 2);
		Board board = GameManager.getInstance().getGameBox().getBoard();
		HashMap<String, Continent> continents = board.getContinents();
		
		for (String continentName : continents.keySet()) {
			if(hasContinent(continents.get(continentName)))
				troops += continents.get(continentName).getSoldiersForConqueror();
		}
		return troops;
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

	public Set<Country> getCountries() {
		return countries;
	}

	public Set<CountryCard> getCards() {
		return cards;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public Boolean getIsDead() {
		return isDead;
	}


	public void setIsDead(Boolean isDead) {
		this.isDead = isDead;
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


	public int getCardExchangeNumber() {
		return cardExchangeNumber;
	}


	public void setObjective(Objective objective) {
		this.objective = objective;
		objective.setOwner(this);
		notifyObservers();
	}

}

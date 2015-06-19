package assets;

import handlers.Observable;
import handlers.Observer;
import handlers.PlayerHandler;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import objectives.Objective;

/**
 * Class that represents a player.
 */
public class Player implements Observable,Serializable {

	private static final long serialVersionUID = 1L;
	
	private String name;
	private String color;
	
	private Boolean isDead;
	private Boolean isWinner;
	
	private Objective objective;
	
	private int totalSoldiers;
	private int cardExchangeNumber;
	
	private Set<Country> countries;
	private Set<CountryCard> cards;
	
	private transient HashSet<Observer> observers;
	
	public Player(String name, String color, Objective objective) {
		
		this.name = name;
		this.color = color;
		this.totalSoldiers = 0;
		this.isDead = false;
		this.isWinner = false;
		this.countries = new HashSet<Country>();
		this.cards = new HashSet<CountryCard>();
		this.observers = new HashSet<Observer>();
		this.setObjective(objective);
		this.cardExchangeNumber = 0;
		
	}
	
	public boolean hasLost() {
		return isDead;
	}
	
	public boolean hasWon() {
		return isWinner;
	}
	
	public int countriesNumber() {
		return countries.size();
	}
	
	public void removeCountry(Country country) {
		countries.remove(country);
		notifyObservers();
	}
	
	public void addCountry(Country country) {
		countries.add(country);
		notifyObservers();
	}
	
	/**
	 * Adds a CountryCard to the player if he has less than 5. Also increments troops in the country 
	 * represented by the card if the player owns it.
	 * @return If the card could be added.
	 */
	//TODO Add troops if player has the country.
	public boolean addCountryCard() {
		
		if(cards.size() < 5) {
			
			CountryCard card = GameManager.getInstance().getGameBox().getRandomCard();
			cards.add(card);

			if(countries.contains(card.getCountry())) {
				card.getCountry().incrementSoldiers();
				card.getCountry().incrementSoldiers();
				card.getCountry().incrementSoldiers();
			}
			
			notifyObservers();
			return true;
			
		}
		return false;
	}
	
	/**
	 * Exchanges 3 of the player's CountryCards for troops.
	 * @return If the exchange could be made.
	 */
	public boolean returnCountryCards(String cardName1, String cardName2, String cardName3) {
		
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
		else if(!CardType.cardExchangeCheck(card1.getType(), card2.getType(), card3.getType()))
			return false;
		else
			
		GameManager.getInstance().getGameBox().returnCountryCards(card1, card2, card3);
		
		cards.remove(card1);
		cards.remove(card2);
		cards.remove(card3);
		
		cardExchangeNumber++;
		
		notifyObservers();
		
		return true;
		
	}
	
	/**
	 * Calculates the number of countries that the player has of a certain continent.
	 * @param continent
	 * @return
	 */
	public int continentCountries(Continent continent) {
		
		int i = 0;
		for (Country country : countries) {
			if(continent.contains(country))
				i++;
		}
		
		return i;
		
	}
	
	public boolean hasContinent(Continent continent) {
		return (continentCountries(continent) == continent.getCountriesNumber());
	}
	
	/**
	 * Calculates the number of troops to be added at the beginning of the turn.
	 * @return Number of troops to me added at the beginning of the turn.
	 */
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
		notifyObservers();
	}

	public void setIsWinner(Boolean isWinner) {
		this.isWinner = isWinner;
		notifyObservers();
	}
	
	public int getCardExchangeNumber() {
		return cardExchangeNumber;
	}


	public void setObjective(Objective objective) {
		this.objective = objective;
		objective.setOwner(this);
		notifyObservers();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		return result;
	}

	/**
	 * Equals by Color
	 */
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

	public void initializeObserver() {
		observers = new HashSet<Observer>();
		observers.add(new PlayerHandler(this));
		notifyObservers();
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

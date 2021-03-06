package ui;

import java.util.HashSet;
import java.util.Set;

/**
 * UI counterpart the the Player class in the backend.
 * Created and Edited by the PLayerHandler observer.
 * Access for reading to the frontend (Swing).
 */

public class PlayerUI {

	private String name;
	private String color;
	
	private Boolean isDead;
	
	private String objective;
	
	private int totalSoldiers;
	private int leftOverSoldiers;
	private int cardExchangeNumber;
	
	private Set<CountryUI> countries;
	private Set<CountryCardUI> cards;
	
	
	public PlayerUI(String name, String color) {
		this.name = name;
		this.color = color;
	}
	
	public PlayerUI(String name, String color, String objective) {
		this.name = name;
		this.color = color;
		this.objective = objective;
		this.totalSoldiers = 0;
		this.leftOverSoldiers = 0;
		this.countries = new HashSet<CountryUI>();
		this.cards = new HashSet<CountryCardUI>();
		this.cardExchangeNumber = 0;
	}

	public String getObjective() {
		return objective;
	}

	public int getTotalSoldiers() {
		return totalSoldiers;
	}

	public void setTotalSoldiers(int totalSoldiers) {
		this.totalSoldiers = totalSoldiers;
	}

	public int getLeftOverSoldiers() {
		return leftOverSoldiers;
	}

	public void setLeftOverSoldiers(int leftOverSoldiers) {
		this.leftOverSoldiers = leftOverSoldiers;
	}

	public Set<CountryUI> getCountries() {
		return countries;
	}

	public void setCountries(Set<CountryUI> countries) {
		this.countries = countries;
	}

	public Set<CountryCardUI> getCards() {
		return cards;
	}

	public void setCards(Set<CountryCardUI> cards) {
		this.cards = cards;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setObjective(String objective) {
		this.objective = objective;
	}

	public Boolean getIsDead() {
		return isDead;
	}

	public void setIsDead(Boolean isDead) {
		this.isDead = isDead;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getCardExchangeNumber() {
		return cardExchangeNumber;
	}

	public void setCardExchangeNumber(int cardExchangeNumber) {
		this.cardExchangeNumber = cardExchangeNumber;
	}
	
}

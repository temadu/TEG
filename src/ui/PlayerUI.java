package ui;

import java.util.HashSet;
import java.util.Set;

import objectives.Objective;
import assets.Country;
import assets.CountryCard;

public class PlayerUI {

	private String name;
	private String color;
	
	private String objective;
	
	private int totalSoldiers;
	private int leftOverSoldiers;
	
	private Set<String> countries;
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
		this.countries = new HashSet<String>();
		this.cards = new HashSet<CountryCardUI>();
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

	public Set<String> getCountries() {
		return countries;
	}

	public void setCountries(Set<String> countries) {
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

	public String getColor() {
		return color;
	}

	public void setObjective(String objective) {
		this.objective = objective;
	}
	
	
}

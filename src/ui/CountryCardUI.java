package ui;

import assets.CardType;

/**
 * UI counterpart the the CountryCard class in the backend.
 * Created and Edited by the PlayerHandler observer for displaying the playerCountryCards.
 * Access for reading to the frontend (Swing).
 */

public class CountryCardUI {

	private String country;
	private CardType type;
	
	public CountryCardUI(String country, CardType type) {
		this.country = country;
		this.type = type;
	}
	
	public String getCountry() {
		return country;
	}

	public CardType getType() {
		return type;
	}
	
}

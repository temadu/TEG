package ui;

import assets.CardType;

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

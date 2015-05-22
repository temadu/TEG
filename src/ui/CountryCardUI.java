package ui;

import assets.CardType;
import assets.Country;

public class CountryCardUI {

	private CountryUI country;
	private CardType type;
	
	public CountryCardUI(CountryUI country, CardType type) {
		super();
		this.country = country;
		this.type = type;
	}

	public CountryUI getCountry() {
		return country;
	}

	public CardType getType() {
		return type;
	}

	
	
	
}

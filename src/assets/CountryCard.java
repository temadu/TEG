package assets;

import java.io.Serializable;

/**
 * Represents the Game's Cards with country names. To be exchanged for troops.
 */
public class CountryCard implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Country country;
	private CardType type;
	
	public CountryCard(Country country, CardType type) {
		this.country = country;
		this.type = type;
	}

	public Country getCountry() {
		return country;
	}

	public CardType getType() {
		return type;
	}
	
}


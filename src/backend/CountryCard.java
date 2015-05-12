package backend;

public class CountryCard {
	
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


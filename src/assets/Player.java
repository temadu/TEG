package assets;

import java.util.HashSet;
import java.util.Set;

import objectives.Objective;

public class Player {
	
	private String name;
	private String color;
	
	private Objective objective;
	
	private int totalSoldiers;
	private int leftOverSoldiers;
	
	private Set<Country> countries;
	private Set<CountryCard> cards;
	
	public Player(String name, String color) {
		this.name = name;
		this.color = color;
	}
	
	public Player(String name, String color, Objective objective) {
		this.name = name;
		this.color = color;
		this.objective = objective;
		this.objective.setOwner(this);
	
		this.totalSoldiers = 0;
		this.leftOverSoldiers = 0;
		this.countries = new HashSet<Country>();
		this.cards = new HashSet<CountryCard>();
	}
	
	public boolean hasLost(){
		return ((totalSoldiers == 0) ? true : false);
	}
	
	public int countriesNumber(){
		return countries.size();
	}
	
	public void removeCountry(Country country){
		countries.remove(country);
	}
	
	public void addCountry(Country country){
		countries.add(country);
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
	
	public String toString() {
		return name + " - " + color;
	}

}
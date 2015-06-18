package assets;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

// Class that represents the game board, countries and their adjacent relationships.
public class Board implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int countriesNum;
	private HashMap<String, Continent> continents;
	private List<Country> countries;
	private boolean[][] adjacentMatrix;
	
	public Board(int countriesNum, HashMap<String, Continent> continents, List<Country> countries, boolean[][] adjacentMatrix) {
		
		this.countriesNum = countriesNum;
		this.continents = continents;
		this.countries = countries;
		this.adjacentMatrix = adjacentMatrix;
		
	}
	
	/**
	 * Checks if two countries are adjacent or not.
	 * @return If countries are adjacent.
	 */
	public boolean adjacentCountries(Country attacker, Country defender) {
		return adjacentMatrix[countries.indexOf(attacker)][countries.indexOf(defender)];
	}
	
	// Gives back the continent that contains the country.
	public Continent continentContainer(Country country) {
		
		Continent container = null;
		
		for (String continentName : continents.keySet()) {
			if (continents.get(continentName).contains(country)){
				container = continents.get(continentName);
				break;
			}
		}
		
		return container;
		
	}
	
	public Country parseStringToCountry(String countryName) {
		
		for (Country country : countries) {
			if(countryName.equals(country.getName()))
				return country;
		}
		
		return null;
		
	}
	
	public Continent getContinent(String continent) {
		return continents.get(continent);
	}

	public List<Country> getCountries() {
		return countries;
	}

	public HashMap<String, Continent> getContinents() {
		return continents;
	}

	public int getCountriesNum() {
		return countriesNum;
	}
	
}

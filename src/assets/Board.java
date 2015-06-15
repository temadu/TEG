package assets;

import java.util.HashMap;
import java.util.List;

public class Board {
	
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

	public Continent getContinent(String continent){
		return continents.get(continent);
	}
	
	public boolean adjacentCountries(Country attacker, Country defender){
		return adjacentMatrix[countries.indexOf(attacker)][countries.indexOf(defender)];
	}
	
	public Continent continentContainer(Country country){
		Continent container = null;
		for (String continentName : continents.keySet()) {
			if (continents.get(continentName).contains(country)){
				container = continents.get(continentName);
				break;
			}
		}
		return container;
	}
	
	public Country parseStringToCountry(String countryName){
		for (Country country : countries) {
			if(countryName.equals(country.getName()))
				return country;
		}
		return null;
		
	}

	public List<Country> getCountries() {
		return countries;
	}

	public HashMap<String, Continent> getContinents() {
		return continents;
	}
}
